/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.ui.comps.treetable;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.JPopupMenu;
import javax.swing.KeyStroke;

/**
 * @author  P203125
 */
public class JTreeTableContextMenu extends JPopupMenu {
	private static final long serialVersionUID = 1L;

	private JTreeTable table;
	private int menuRow;
	private MouseEvent menuEvent;

	private JTreeTablePopupAction expandAction;
	private JTreeTablePopupAction collapseAction;
	private JTreeTablePopupAction showDetailsAction;
	private JTreeTablePopupAction columnsConfAction;
	private JTreeTablePopupAction copyAction;
	private JTreeTablePopupAction pasteAction;

	public JTreeTableContextMenu(JTreeTable table) {
		this.table = table;

		expandAction =
			new JTreeTablePopupAction("Ausklappen", JTreeTableProperties.TT_EXP_ICON, "Alle ausklappen", new Integer(KeyEvent.VK_A)) {
				private static final long serialVersionUID = 1L;

				@Override
				public void actionPerformed(ActionEvent e) {
					JTreeTableNode node = table.getSelectedNode();
					if (node != null) {
						table.expandNode(node);
					}
				}
			};

		collapseAction =
			new JTreeTablePopupAction("Zuklappen", JTreeTableProperties.TT_COL_ICON, "Alle zuklappen", new Integer(KeyEvent.VK_A)) {
				private static final long serialVersionUID = 1L;

				@Override
				public void actionPerformed(ActionEvent e) {
					JTreeTableNode node = table.getSelectedNode();
					if (node != null) {
						table.collapseNode(node);
					}
				}
			};

		showDetailsAction =
			new JTreeTablePopupAction("Zeige diese Zeile...", JTreeTableProperties.TT_DET_ICON, "Diese Zeile anzeigen", new Integer(KeyEvent.VK_Z)) {
				private static final long serialVersionUID = 1L;

				@Override
				public void actionPerformed(ActionEvent e) {
					table.showDetailPopup(menuRow, menuEvent);
				}
			};

		copyAction =
			new JTreeTablePopupAction("Kopieren", JTreeTableProperties.TT_COP_ICON, "Kopieren", new Integer(KeyEvent.VK_C)) {
				private static final long serialVersionUID = 1L;

				@Override
				public void actionPerformed(ActionEvent e) {
					JTreeTable.copySelectedData(table);
				}
			};

		pasteAction =
			new JTreeTablePopupAction("Einf�gen", JTreeTableProperties.TT_PAS_ICON, "Einf�gen", new Integer(KeyEvent.VK_V)) {
				private static final long serialVersionUID = 1L;

				@Override
				public void actionPerformed(ActionEvent e) {
					JTreeTable.pasteSelectedData(table);
				}
			};

		columnsConfAction =
			new JTreeTablePopupAction(
				"Spalten ein-/ausblenden...",
				null,
				"Spalten ein-/ausblenden",
				new Integer(KeyEvent.VK_S)
			) {
				private static final long serialVersionUID = 1L;
		
				@Override
				public void actionPerformed(ActionEvent e) {
					table.configColumns(table.getParent());
				}
			};


		ActionListener keyListener =
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (e.getActionCommand().compareTo("Copy") == 0) {
						copyAction.actionPerformed(e);
					}

					if (e.getActionCommand().compareTo("Paste") == 0) {
						pasteAction.actionPerformed(e);
					}
				}
			};

		KeyStroke copy = KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK, false);
		KeyStroke paste = KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK, false);
		table.registerKeyboardAction(keyListener, "Copy", copy, JComponent.WHEN_FOCUSED);
		table.registerKeyboardAction(keyListener, "Paste", paste, JComponent.WHEN_FOCUSED);

		add(expandAction);
		add(collapseAction);
		add(showDetailsAction);
		addSeparator();
		add(copyAction);
		add(pasteAction);
		addSeparator();
		add(columnsConfAction);
	}

	public void show(int row, MouseEvent event) {
		this.menuRow = row;
		this.menuEvent = event;
		JTreeTableNode[] sels = table.getSelectedNodes();
		boolean sel = sels != null && sels.length == 1;
		expandAction.setEnabled(sel && table.getTree().getDepth() > 1);
		collapseAction.setEnabled(sel && table.getTree().getDepth() > 1);
		showDetailsAction.setEnabled(sel && table.getProperties().showDetailsPopup);
		copyAction.setEnabled(sel);
		pasteAction.setEnabled(sel);
		columnsConfAction.setEnabled(table.getProperties().columnsConfigurable);
		super.show(event.getComponent(), event.getX(), event.getY());
	}
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
