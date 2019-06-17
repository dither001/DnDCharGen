package com.worldgen.controller;

import javax.swing.JFrame;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;
import com.worldgen.model.Corner;
import com.worldgen.model.Planet;
import com.worldgen.model.Tile;
//import com.worldgen.math.Cube;
import com.worldgen.view.OldPlanetView;

public class PlanetViewController {

	public static void main(String... args) {
		final GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilities = new GLCapabilities(profile);

		/*
		 * TEST AREA
		 */
		Planet p;
		int tileCount = 0;
		int counter = 0;
		int longestRiver = 0;

		double windSpeed = 0.0;

		try {
			p = Planet.build(6);
			tileCount = p.getGrid().tiles.length;

			for (Tile el : p.getGrid().tiles) {
				if (el.elevation > p.getSeaLevel()) {
					++counter;
				}

				windSpeed += el.wind.speed;
			}

			for (Corner el : p.getGrid().corners) {
				if (el.distanceToSea > longestRiver)
					longestRiver = el.distanceToSea;
			}

			System.out.printf("Sea Level: %.2f %n", p.getSeaLevel());
			System.out.println("Tiles: " + tileCount);
			System.out.println("Longest River: " + longestRiver);

			System.out.printf("Average wind speed: %.2f %n", 1.0 * windSpeed / tileCount);

		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("Tiles above sea Level: " + counter);
		/*
		 * 
		 */

		// the canvas
		final GLCanvas glcanvas = new GLCanvas(capabilities);
		// Cube cube = new Cube();
		OldPlanetView view = new OldPlanetView();
		glcanvas.addGLEventListener(view);
		glcanvas.setSize(400, 400);

		// the frame
		final JFrame frame = new JFrame("Multicolored cube");
		frame.getContentPane().add(glcanvas);
		frame.setSize(frame.getContentPane().getPreferredSize());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		// start animation
		final FPSAnimator animator = new FPSAnimator(glcanvas, 300, true);
		animator.start();
	}

}
