package view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class NPCDetailFrame extends JFrame {
	private static final Dimension d;

	static {
		d = new Dimension(500, 500);
	}

	public NPCDetailFrame() {
		super("Inspect Character");
		setSize(d);
		setLayout(new BorderLayout(5, 5));

		setDefaultCloseOperation(HIDE_ON_CLOSE);
	}
}
