package com.worldgen.view;

import java.awt.DisplayMode;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.worldgen.math.JO;
import com.worldgen.math.Matrix3;
import com.worldgen.model.Corner;
import com.worldgen.model.Tile;

@SuppressWarnings("serial")
public class OldPlanetView extends GLCanvas implements GLEventListener {

	/*
	 * FIELDS
	 */
	public static DisplayMode dm, dm_old;
	private GLU glu = new GLU();
	private float rquad = 0.0f;

	/*
	 * METHODS
	 */
	private void drawTile(Tile t, Matrix3 m, float[] color, GLAutoDrawable drawable) {
		final GL2 gl = drawable.getGL().getGL2();

		// XXX - I don't know how many of these are required or necessary.
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();
		gl.glTranslatef(0f, 0f, -5.0f);

		//
		gl.glColor3f(color[0], color[1], color[2]);
		gl.glBegin(GL2.GL_TRIANGLE_FAN);
		JO.glVertex3f(gl, m.multVec3(t.v));
		for (Corner el : t.corners)
			JO.glVertex3f(gl, m.multVec3(el.v));

		JO.glVertex3f(gl, m.multVec3(t.corners[0].v));
		gl.glEnd();
	}

	@Override
	public void display(GLAutoDrawable drawable) {
		final GL2 gl = drawable.getGL().getGL2();
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();
		// gl.glTranslatef(0f, 0f, -5.0f);
		// gl.glRotatef(rquad, 1.0f, 1.0f, 1.0f); // Rotate The Cube On X, Y & Z
		
		// TODO - needs 6 doubles, I think for frame size?
//		gl.glOrtho(arg0, arg1, arg2, arg3, arg4, arg5);
		
		
		
		
		
		
		
		
		
		

		gl.glFlush();
		// rquad -= 0.15f;
	}

	@Override
	public void dispose(GLAutoDrawable drawable) {
		// TODO Auto-generated method stub
	}

	@Override
	public void init(GLAutoDrawable drawable) {
		final GL2 gl = drawable.getGL().getGL2();

		gl.glShadeModel(GL2.GL_SMOOTH);
		gl.glClearColor(0f, 0f, 0f, 0f);
		gl.glClearDepth(1.0f);
		gl.glEnable(GL2.GL_DEPTH_TEST);
		gl.glDepthFunc(GL2.GL_LEQUAL);
		gl.glHint(GL2.GL_PERSPECTIVE_CORRECTION_HINT, GL2.GL_NICEST);
	}

	@Override
	public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
		final GL2 gl = drawable.getGL().getGL2();

		if (height <= 0)
			height = 1;
		final float h = (float) width / (float) height;

		gl.glViewport(0, 0, width, height);
		gl.glMatrixMode(GL2.GL_PROJECTION);
		gl.glLoadIdentity();
		glu.gluPerspective(45.0f, h, 1.0, 20.0);
		gl.glMatrixMode(GL2.GL_MODELVIEW);
		gl.glLoadIdentity();
	}

}
