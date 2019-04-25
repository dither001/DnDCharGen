package components;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JList;

@SuppressWarnings("serial")
public class SelectionList<T> extends JList<T> {

	private DefaultListModel<T> model;

	/*
	 * CONSTRUCTORS
	 */
	public SelectionList(Collection<T> list) {
		model = new DefaultListModel<T>();

		addAllToList(list);
		setModel(model);
	}

	/*
	 * INSTANCE METHODS
	 */
	public boolean addToList(T element) {
		boolean added = false;
		if (model.contains(element) != true) {
			added = true;
			model.addElement(element);
		}

		return added;
	}

	public boolean addAllToList(Collection<T> list) {
		boolean addedAll = true;

		for (T el : list) {
			if (model.contains(el) != true) {
				model.addElement(el);

			} else {
				addedAll = false;

			}
		}

		return addedAll;
	}

	public T removeFromList(T element) {
		int index = -1;
		int length = model.size();

		for (int i = 0; i < length; ++i) {
			T current = model.get(i);

			if (current.equals(element)) {
				index = i;
				break;
			}
		}

		if (index > -1)
			return model.remove(index);
		else
			return null;
	}

	public T getFromList(int index) {
		T element = null;
		if (index <= model.size())
			element = model.get(index);

		return element;
	}

	public List<T> getList() {
		List<T> list = new ArrayList<T>(model.size());

		int length = model.size();
		for (int i = 0; i < length; ++i)
			list.add(model.get(i));

		return list;
	}

	public int length() {
		return model.size();
	}

}
