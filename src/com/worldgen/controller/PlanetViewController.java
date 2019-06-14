package com.worldgen.controller;

import javax.swing.JFrame;

import com.jogamp.opengl.GLCapabilities;
import com.jogamp.opengl.GLProfile;
import com.jogamp.opengl.awt.GLCanvas;
import com.jogamp.opengl.util.FPSAnimator;
import com.worldgen.math.Cube;
import com.worldgen.view.PlanetView;

public class PlanetViewController {

	public static void main(String... args) {
		final GLProfile profile = GLProfile.get(GLProfile.GL2);
		GLCapabilities capabilities = new GLCapabilities(profile);

		// the canvas
		final GLCanvas glcanvas = new GLCanvas(capabilities);
		// Cube cube = new Cube();
		PlanetView view = new PlanetView();
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
