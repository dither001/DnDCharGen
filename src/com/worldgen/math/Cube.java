package com.worldgen.math;

import java.awt.DisplayMode;

import javax.swing.JFrame;

import com.jogamp.opengl.GL2;
import com.jogamp.opengl.GLAutoDrawable;
import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLEventListener;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.FPSAnimator;

public class Cube implements GLEventListener {

	public static DisplayMode dm, dm_old;
	private GLU glu = new GLU();
	private float rquad = 0.0f;

	private final float[][] COLORS = { //
			{ 1f, 0f, 0f }, // RED
			{ 0f, 1f, 0f }, // GREEN
			{ 0f, 0f, 1f }, // BLUE
			{ 1f, 1f, 0f }, // YELLOW (red + green)
			{ 1f, 0f, 1f }, // PURPLE (red + blue)
			{ 0f, 1f, 1f } // SKY BLUE (blue + green)
	};

	@Override
	public void display(GLAutoDrawable drawable) {
		final GL2 gl = drawable.getGL().getGL2();
		gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
		gl.glLoadIdentity();
		gl.glTranslatef(0f, 0f, -10.0f);
		gl.glRotatef(rquad, 1.0f, 1.0f, 1.0f); // Rotate The Cube On X, Y & Z

		// giving different colors to different sides
		gl.glBegin(GL2.GL_QUADS); // Start Drawing The Cube

		// gl.glColor3f(1f, 0f, 0f); // red color
		DrawUtil.glColor3f(gl, COLORS[0]);
		float[][] f = new float[][] { { 1.0f, 1.0f, -1.0f }, { -1.0f, 1.0f, -1.0f }, { -1.0f, 1.0f, 1.0f },
				{ 1.0f, 1.0f, 1.0f } };

		for (float[] el : f)
			DrawUtil.glVertex3f(gl, el);

		// DrawUtil.glVertex3f(gl, f[0]);
		// DrawUtil.glVertex3f(gl, f[1]);
		// DrawUtil.glVertex3f(gl, f[2]);
		// DrawUtil.glVertex3f(gl, f[3]);

		// gl.glVertex3f(1.0f, 1.0f, -1.0f); // Top Right Of The Quad (Top)
		// gl.glVertex3f(-1.0f, 1.0f, -1.0f); // Top Left Of The Quad (Top)
		// gl.glVertex3f(-1.0f, 1.0f, 1.0f); // Bottom Left Of The Quad (Top)
		// gl.glVertex3f(1.0f, 1.0f, 1.0f); // Bottom Right Of The Quad (Top)

		// gl.glColor3f(0f, 1f, 0f); // green color
		DrawUtil.glColor3f(gl, COLORS[1]);
		f = new float[][] { { 1.0f, -1.0f, 1.0f }, { -1.0f, -1.0f, 1.0f }, { -1.0f, -1.0f, -1.0f },
				{ 1.0f, -1.0f, -1.0f } };

		for (float[] el : f)
			DrawUtil.glVertex3f(gl, el);

		// gl.glVertex3f(1.0f, -1.0f, 1.0f); // Top Right Of The Quad
		// gl.glVertex3f(-1.0f, -1.0f, 1.0f); // Top Left Of The Quad
		// gl.glVertex3f(-1.0f, -1.0f, -1.0f); // Bottom Left Of The Quad
		// gl.glVertex3f(1.0f, -1.0f, -1.0f); // Bottom Right Of The Quad

		// gl.glColor3f(0f, 0f, 1f); // blue color
		DrawUtil.glColor3f(gl, COLORS[2]);
		gl.glVertex3f(1.0f, 1.0f, 1.0f); // Top Right Of The Quad (Front)
		gl.glVertex3f(-1.0f, 1.0f, 1.0f); // Top Left Of The Quad (Front)
		gl.glVertex3f(-1.0f, -1.0f, 1.0f); // Bottom Left Of The Quad
		gl.glVertex3f(1.0f, -1.0f, 1.0f); // Bottom Right Of The Quad

		// gl.glColor3f(1f, 1f, 0f); // yellow (red + green)
		DrawUtil.glColor3f(gl, COLORS[3]);
		gl.glVertex3f(1.0f, -1.0f, -1.0f); // Bottom Left Of The Quad
		gl.glVertex3f(-1.0f, -1.0f, -1.0f); // Bottom Right Of The Quad
		gl.glVertex3f(-1.0f, 1.0f, -1.0f); // Top Right Of The Quad (Back)
		gl.glVertex3f(1.0f, 1.0f, -1.0f); // Top Left Of The Quad (Back)

		// gl.glColor3f(1f, 0f, 1f); // purple (red + green)
		DrawUtil.glColor3f(gl, COLORS[4]);
		gl.glVertex3f(-1.0f, 1.0f, 1.0f); // Top Right Of The Quad (Left)
		gl.glVertex3f(-1.0f, 1.0f, -1.0f); // Top Left Of The Quad (Left)
		gl.glVertex3f(-1.0f, -1.0f, -1.0f); // Bottom Left Of The Quad
		gl.glVertex3f(-1.0f, -1.0f, 1.0f); // Bottom Right Of The Quad

		// gl.glColor3f(0f, 1f, 1f); // sky blue (blue +green)
		DrawUtil.glColor3f(gl, COLORS[5]);
		gl.glVertex3f(1.0f, 1.0f, -1.0f); // Top Right Of The Quad (Right)
		gl.glVertex3f(1.0f, 1.0f, 1.0f); // Top Left Of The Quad
		gl.glVertex3f(1.0f, -1.0f, 1.0f); // Bottom Left Of The Quad
		gl.glVertex3f(1.0f, -1.0f, -1.0f); // Bottom Right Of The Quad

		//
		gl.glEnd(); // Done Drawing The Quad
		gl.glFlush();

		// rquad -= 0.15f;
		rquad -= 01.5f;
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

	public static void main(String[] args) {
		final GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilities = new GLCapabilities(profile);

		// the canvas
		final GLCanvas glcanvas = new GLCanvas(capabilities);
		Cube cube = new Cube();
		glcanvas.addGLEventListener(cube);
		glcanvas.setSize(400, 400);

		// the frame
		final JFrame frame = new JFrame(" Multicolored cube");
		frame.getContentPane().add(glcanvas);
		frame.setSize(frame.getContentPane().getPreferredSize());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		// start animation
		final FPSAnimator animator = new FPSAnimator(glcanvas, 300, true);
		animator.start();
	}
}
