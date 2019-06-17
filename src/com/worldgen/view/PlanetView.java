package com.worldgen.view;

import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class PlanetView implements GLEventListener {

	public static final double DEFAULT_SIZE = 600;

	/*
	 * 
	 */
	double scale;
	int width, height;

	/*
	 * CONSTRUCTORS
	 */
	public PlanetView() {
		this.scale = 1;
		//
		this.width = 600;
		this.height = 600;
	}

	/*
	 * 
	 */
	public void setViewportSize(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public void setScale(float[] vec2, double delta) {
		this.scale *= delta;
	}

	public void mouseDragged(float[] vec2) {
		// TODO
	}

	public float[] toCoordinates(float[] vec2) {
		return new float[] { 0, 0, 0 };
	}

	/*
	 * 
	 */
	@Override
	public void display(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void init(GLAutoDrawable arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void reshape(GLAutoDrawable arg0, int arg1, int arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub

	}

}
