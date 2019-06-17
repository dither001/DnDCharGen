package com.worldgen.math;

import java.util.Vector;

import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;

public class Sphere implements GLEventListener {

	//
	private Vector<float[]> pointsArray;
	private Vector<float[]> normalsArray;

	//
	private static final int ARRAY_LENGTH = 3200;

	private int numTimesToSubdivide = 4;
	private int index = 0;

	private float near = -10f;
	private float far = 10f;
	private float radius = 5f;
	private float theta = -0.5f;
	private float phi = 0.0f;
	private float dr = (float) (5.0 * Math.PI / 180.0);

	private float left = -3.0f;
	private float right = 3.0f;
	private float ytop = 3.0f;
	private float bottom = -3.0f;

	private float[] va = new float[] { 0.0f, 0.0f, -1.0f, 1f };
	private float[] vb = new float[] { 0.0f, 0.942809f, 0.333333f, 1f };
	private float[] vc = new float[] { -0.816497f, -0.471405f, 0.333333f, 1f };
	private float[] vd = new float[] { 0.816497f, -0.471405f, 0.333333f, 1f };

	/*
	 * CONSTRUCTORS
	 */
	public Sphere() {
		pointsArray = new Vector<float[]>(ARRAY_LENGTH);
		normalsArray = new Vector<float[]>(ARRAY_LENGTH);

		tetrahedron(va, vb, vc, vd, numTimesToSubdivide);
	}

	/*
	 * INSTANCE METHODS
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

	/*
	 * 
	 */
	private void triangle(float[] a, float[] b, float[] c) {
		pointsArray.addElement(a);
		pointsArray.addElement(b);
		pointsArray.addElement(c);

		// normals are vectors
		normalsArray.addElement(new float[] { a[0], a[1], a[2], 0.0f });
		normalsArray.addElement(new float[] { b[0], b[1], b[2], 0.0f });
		normalsArray.addElement(new float[] { c[0], c[1], c[2], 0.0f });
	}

	private void divideTriangle(float[] a, float[] b, float[] c, int count) {
		if (count > 0) {
			float[] ab = mix(a, b, 0.5f);
			float[] ac = mix(a, c, 0.5f);
			float[] bc = mix(b, c, 0.5f);

			ab = normalize(ab);
			ac = normalize(ac);
			bc = normalize(bc);

			divideTriangle(a, ab, ac, count - 1);
			divideTriangle(ab, b, bc, count - 1);
			divideTriangle(bc, c, ac, count - 1);
			divideTriangle(ab, bc, ac, count - 1);
		} else {
			triangle(a, b, c);
		}
	}

	private void tetrahedron(float[] a, float[] b, float[] c, float[] d, int n) {
		divideTriangle(a, b, c, n);
		divideTriangle(d, c, b, n);
		divideTriangle(a, d, b, n);
		divideTriangle(a, c, d, n);
	}

	/*
	 * STATIC METHODS
	 */
	private static double dot(float[] u, float[] v) {
		double sum = 0.0f;

		int n = Math.min(u.length, v.length);
		for (int i = 0; i < n; ++i) {
			sum += u[i] * v[i];
		}

		return sum;
	}

	private static double length(float[] u) {
		return Math.sqrt(dot(u, u));
	}

	private static float[] mix(float[] u, float[] v, float s) {
		int n = Math.min(u.length, v.length);
		float[] result = new float[n];

		for (int i = 0; i < n; ++i) {
			result[i] = (float) ((1.0 - s) * u[i] + s * v[i]);
		}

		return result;
	}

	private static float[] normalize(float[] u) {
		float[] result = new float[u.length];
		double length = length(u);

		for (int i = 0; i < u.length; ++i) {
			result[i] = (float) (u[i] / length);
		}

		return result;
	}

}
