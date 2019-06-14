package com.worldgen.math;

import com.jogamp.opengl.GL2;

public abstract class DrawUtil {
	
	public static void glColor3f(GL2 gl, float[] f) {
		gl.glColor3f(f[0], f[1], f[2]);
	}

	public static void glVertex3f(GL2 gl, float[] f) {
		gl.glVertex3f(f[0], f[1], f[2]);
	}

}
