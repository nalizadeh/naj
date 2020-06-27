/*--- (C) 1999-2019 Techniker Krankenkasse ---*/

package org.naj.java.ui.comps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 * This class extends JComboBox providing it with filtering capability. So the idea is this 1. Focus the combo 2. Type a
 * character sequence 3. With each key press the box will update itself filtering out the items that do not match the
 * users character sequence. Note 1: The user can press the left and right arrow keys to move forward and backward in
 * the filter character sequence. Note 2: The user can press the "Back Space", "Delete", or "Escape" keys to restore the
 * original values and reset the filtering sequence. Enjoy!
 *
 * @author  Corbin Holland
 */
public class JFilterCombo extends JComboBox<Object> {

	private static final long serialVersionUID = 1L;

	private JTextField dispPaar;

	public JFilterCombo() {
		init(new ArrayList<String>(), null);
	}

	public JFilterCombo(String[] items) {
		List<String> ls = new ArrayList<String>();
		for (String s : items) {
			ls.add(s);
		}
		init(ls, null);
	}

	public JFilterCombo(List<String> items) {
		init(items, null);
	}

	public void init(List<String> items, JTextField dispPaar) {

		this.dispPaar = dispPaar;

		FilterComboBoxModel model = new FilterComboBoxModel(items);
		setModel(model);

		model.addAllElements(items);

		// Remove standard key listeners that come with the JComboBox
		KeyListener[] lis = getKeyListeners();
		for (int i = 0; i < lis.length; i++) {
			removeKeyListener(lis[i]);
		}

		// Add custom KeyListener class
		addKeyListener(model.getKeyListener());

		// Add custom ActionListener class
		addActionListener(model.getActionListener());

		// Add your own custom action listener here if needed
		addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// "Add your code here"
				}
			}
		);

		// Add your own custom item listener here if needed
		addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					// "Add your code here"
				}
			}
		);
	}

	public void clear() {
		FilterComboBoxModel model = (FilterComboBoxModel) getModel();
		model.initComboBoxModel(new ArrayList<String>());
		model.removeAllElements();
	}

	public class FilterComboBoxModel extends DefaultComboBoxModel<Object> {

		private static final long serialVersionUID = 1L;

		private List<String> masterItemList = new ArrayList<String>();
		private String masterSelectedItem;
		private StringBuilder filter = new StringBuilder(8);
		private int fidx = 0;
		private CustomKeyListener keylis = null;
		private CustomActionListener actionlis = null;

		private ActionListener[] actionLisList;
		private ItemListener[] itemLisList;

		public FilterComboBoxModel(List<String> items) {
			initComboBoxModel(items);
		}

		private void initComboBoxModel(List<String> items) {
			filter.delete(0, filter.length());
			fidx = 0;
			masterItemList.clear();
			setMasterItemList(items);
		}

		public CustomKeyListener getKeyListener() {
			if (keylis == null) {
				keylis = new CustomKeyListener();
			}
			return keylis;
		}

		public CustomActionListener getActionListener() {
			if (actionlis == null) {
				actionlis = new CustomActionListener();
			}
			return actionlis;
		}

		public void setMasterItemList(List<String> items) {
			if (!items.isEmpty()) {
				masterItemList = items;
				masterSelectedItem = items.get(0);
				restoreItems();
			}
		}

		public void addAllElements(List<String> items) {
			for (String s : items) {
				addItem(s);
			}
		}

		public Object[] getAllElements() {
			Object[] list = new Object[getItemCount()];
			for (int i = 0; i < list.length; i++) {
				list[i] = this.getElementAt(i);
			}
			return list;
		}

		public void filterItems(String pat) {

			List<String> newList = new ArrayList<String>();
			List<String> list = masterItemList;

			if (dispPaar != null) {
				dispPaar.setText(pat);
			}
			int patlen = pat.length();
			for (String s : list) {
				if (s.length() < patlen) {
					continue;
				}
				String tok = s.substring(0, patlen);

				if (tok.equalsIgnoreCase(pat)) {
					newList.add(s);
				}
			}

			// Add the new list to the combobox - notice we disable listeners
			suspendAllListeners();
			removeAllElements();
			if (newList.isEmpty()) {
				addItem("<Empty>");
			} else {
				addAllElements(newList);
			}
			if (fidx == 0) {
				setSelectedItem(masterSelectedItem);
			}

			restoreAllListeners();

		}

		private void suspendAllListeners() {
			actionLisList = getActionListeners();
			for (ActionListener a : actionLisList) {
				removeActionListener(a);
			}
			itemLisList = getItemListeners();
			for (ItemListener i : itemLisList) {
				removeItemListener(i);
			}
		}

		private void restoreAllListeners() {
			for (ActionListener a : actionLisList) {
				addActionListener(a);
			}
			for (ItemListener i : itemLisList) {
				addItemListener(i);
			}
		}

		public void restoreItems() {
			suspendAllListeners();
			removeAllElements();
			addAllElements(masterItemList);
			resetFilter();
			setSelectedItem(masterSelectedItem);
			restoreAllListeners();
		}

		private void resetFilter() {
			filter.setLength(0);
			fidx = 0;
		}

		public class CustomKeyListener extends KeyAdapter {

			@Override
			public void keyPressed(KeyEvent e) {

				int keyCode = e.getKeyCode();

				if (keyCode == KeyEvent.VK_LEFT) {
					fidx = (fidx == 0 ? fidx : fidx - 1);
					filterItems(filter.substring(0, fidx));
				} else if (keyCode == KeyEvent.VK_RIGHT) {
					fidx = (fidx == filter.length() ? fidx : fidx + 1);
					filterItems(filter.substring(0, fidx));
				} else if (
					keyCode == KeyEvent.VK_BACK_SPACE
					|| keyCode == KeyEvent.VK_DELETE
					|| keyCode == KeyEvent.VK_ESCAPE
				) {
					restoreItems();
					if (dispPaar != null) {
						dispPaar.setText("");
					}
				} else {
					char letter = (char) keyCode;
					filter.insert(fidx, letter);
					fidx++;
					filter.setLength(fidx);
					filterItems(filter.toString());
				}

//            System.out.println("fidx = " + fidx + " -- Filter: " + filter);
				setToolTipText("Current filter: " + filter.substring(0, fidx));
			}
		}

		public class CustomActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				masterSelectedItem = (String) getSelectedItem();
				restoreItems();
			}
		}
	}

//  public static void main(String[] args) {
//
//      FilterCombo fc =
//          new FilterCombo(
//              new String[] {
//                  "aaaaaaaaaaaaaaaaaa", "bbbbbbbbbbbbbbbbbb", "cccccccccccccccccc",
//                  "ababababababababab", "bababababababababa", "cacaacacacacacacac", "apple",
//                  "banana", "citrus"
//              }
//          );
//
//      // Create the frame
//      JFrame frame = new JFrame("FilterCombo Test");
//      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      frame.setLocationRelativeTo(null);
//
//      JPanel panel = new JPanel();
//      panel.add(fc);
//      frame.add(panel);
//      frame.pack();
//
//      frame.setVisible(true);
//  }
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
