package com.dnd5e.dungeons;

/*
 * Used to find largest unmapped area of a Dungeon Floor. Adapted from solutions found on Stack Overflow 
 * https://stackoverflow.com/questions/7245/puzzle-find-largest-rectangle-maximal-rectangle-problem
 */

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Stack;

import com.miscellaneous.util.*;

public abstract class MaximalRectangle {

	/*
	 * STATIC METHODS
	 */
	public static Rectangle findMaximalRectangle(Floor f) {
		int bestArea = 0;
		Cell lowerLeft = new Cell(0, 0);
		Cell upperRight = new Cell(-1, -1);

		int numCols = Default.DIMENSIONS.width / Default.WALL_LENGTH;
		int numRows = Default.DIMENSIONS.height / Default.WALL_LENGTH;

		Stack<Cell> stack = new Stack<Cell>();
		Cache rectangleHeightCache = new Cache(numCols);

		// System.out.println();
		// System.out.printf("%2d ", 0);
		// for (int i = 1; i < numCols; ++i)
		// System.out.printf("%2d", i);

		for (int row = 0; row < numRows; ++row) {
			rectangleHeightCache.aggregate(row, f);

			for (int col = 0, currentRectHeight = 0; col < numCols; ++col) {
				int aggregateRectHeight = rectangleHeightCache.get(col);

				if (aggregateRectHeight > currentRectHeight) {
					stack.push((new Cell(col, currentRectHeight)));
					currentRectHeight = aggregateRectHeight;

				} else if (aggregateRectHeight < currentRectHeight) {
					Cell rectStartCell;

					do {
						rectStartCell = stack.pop();
						int rectWidth = col - rectStartCell.col;
						int area = currentRectHeight * rectWidth;

						//
						if (area > bestArea) {
							bestArea = area;
							lowerLeft = new Cell(rectStartCell.col, row);
							upperRight = new Cell(col, row - currentRectHeight + 1);
						}

						currentRectHeight = rectStartCell.row;
					} while (aggregateRectHeight < currentRectHeight);

					currentRectHeight = aggregateRectHeight;
					if (currentRectHeight != 0)
						stack.push(rectStartCell);

				}
			}
		}

		int w = upperRight.col - lowerLeft.col;
		int h = lowerLeft.row - upperRight.row + 1;
		Dimension d = new Dimension(w * Default.WALL_LENGTH, h * Default.WALL_LENGTH);

		int x = lowerLeft.col < upperRight.col ? lowerLeft.col : upperRight.col;
		int y = lowerLeft.row < upperRight.row ? lowerLeft.row : upperRight.row;
		Point p = new Point(x * Default.WALL_LENGTH, y * Default.WALL_LENGTH);

		return new Rectangle(p, d);
	}

	/*
	 * CELL CLASS
	 */
	private static class Cell {
		final int col, row;

		// CONSTRUCTOR
		Cell(int col, int row) {
			this.col = col;
			this.row = row;
		}
	}

	/*
	 * CACHE CLASS
	 */
	private static class Cache {
		final int[] aggregateHeights;

		// CONSTRUCTOR
		Cache(int size) {
			aggregateHeights = new int[size + 1];
			for (int i = 0; i < size; ++i)
				aggregateHeights[i] = 0;
		}

		// METHODS
		public int get(int col) {
			return aggregateHeights[col];
		}

		public void aggregate(int row, Floor floor) {
			Rectangle cursor = new Rectangle(new Dimension(Default.WALL_LENGTH, Default.WALL_LENGTH));

			for (int col = 0; col < aggregateHeights.length; ++col) {
				Point p = new Point((col * Default.WALL_LENGTH), (row * Default.WALL_LENGTH));
				cursor.setLocation(p);

				if (floor.inBounds(cursor) && floor.isValidLocation(cursor)) {
					aggregateHeights[col] = aggregateHeights[col] + 1;
				} else {
					aggregateHeights[col] = 0;
				}
			}

			// System.out.println();
			// System.out.printf("%2d ", row);
			// for (int i = 0; i < aggregateHeights.length; ++i)
			// System.out.printf("%2d", aggregateHeights[i]);
		}
	}

}
