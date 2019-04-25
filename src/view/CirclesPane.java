package view;

import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;

import com.dnd5e.characters.*;
import com.dnd5e.definitions.rules.*;
import com.dnd5e.factions.*;
import com.miscellaneous.util.*;

import components.SelectionList;
import controller.Controller;
import model.*;

@SuppressWarnings("serial")
public class CirclesPane extends JPanel {

	private Class[] circleClazzes;
	private String[] circleNames;

	private SelectionList<String> list1;

	/*
	 * CONSTRUCTORS
	 */
	private CirclesPane() {
		circleClazzes = new Class[] { Alignment.class, Background.class, DnDClass.class, Subclass.class, Race.class };
		circleNames = new String[] { "Alignment", "Background", "DnDClass", "Subclass", "Race" };
		// TODO

	}

	private void updateSelections() {

	}

	/*
	 * STATIC METHODS
	 */
	public static CirclesPane build(Circles circles) {
		CirclesPane pane = new CirclesPane();
		pane.setLayout(new BoxLayout(pane, BoxLayout.LINE_AXIS));

		// setup first table
		pane.list1 = new SelectionList<String>(Misc.arrayToList(pane.circleNames));
		pane.list1.addListSelectionListener(e -> pane.updateSelections());
		pane.add(pane.list1);

		return pane;
	}

}
