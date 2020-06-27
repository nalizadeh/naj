/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.ui.comps.treetable;

import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.EventObject;

import javax.swing.JTable;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.TableCellEditor;

/**
 * @author  P203125
 */
public class JTreeTableCellEditor implements TableCellEditor {

	private JTreeTable treetable;
	private JTreeTableEditorComponent editor;
	private ChangeEvent changeEvent;

	public JTreeTableCellEditor(JTreeTable treetable) {
		this.treetable = treetable;
		this.changeEvent = new ChangeEvent(this);
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		JTreeTable tt = (JTreeTable) table;
		if (tt.getColumnClass(column) == JTreeTableTree.class) {
			return tt.getTree();
		}

		JTreeTableNode node = tt.getNodeAtRow(row);
		JTreeTableModel model = (JTreeTableModel) table.getModel();
		editor = model.getEditorAt(node, row, tt.convertColumnIndexToModel(column));
		if (editor != null) {
			editor.setEditorValue(value);
			editor.setEditorListener(this);
			editor.getRendererComponent(
				table,
				value,
				isSelected, //
				model.isCellEnabled(row, column),
				table.getSelectionForeground(),
				table.getSelectionBackground()
			);
			return editor.getEditorComponent();
		}
		return null;
	}

	@Override
	public boolean isCellEditable(EventObject e) {

		if (e instanceof MouseEvent) {

			MouseEvent me = (MouseEvent) e;

			for (int i = 0; i < treetable.getColumnCount(); i++) {
				if (treetable.getColumnClass(i) == JTreeTableTree.class) {
					Rectangle rect = treetable.getCellRect(0, i, true);
					if (me.getX() >= rect.x && me.getX() <= (rect.x + rect.width)) {

						// forward event to the tree
						treetable
							.getTree()
							.dispatchEvent(
								new MouseEvent(
									(Component) me.getSource(), // tree
									me.getID(),
									me.getWhen(),
									me.getModifiers(),
									me.getX() - rect.x,
									me.getY() - rect.y,
									me.getClickCount(),
									me.isPopupTrigger()
								)
							);

						// mark table as changed
						treetable.revalidate();
						return false;
					}
				}
			}
		}
		return true; // return true if keyboard event
	}

	@Override
	public Object getCellEditorValue() {
		return editor == null ? null : editor.getEditorValue();
	}

	@Override
	public boolean shouldSelectCell(EventObject evt) {
		return true;
	}

	@Override
	public boolean stopCellEditing() {
		fireEditingStopped();
		return true;
	}

	@Override
	public void cancelCellEditing() {
		fireEditingCanceled();
	}

	@Override
	public void addCellEditorListener(CellEditorListener l) {
	}

	@Override
	public void removeCellEditorListener(CellEditorListener l) {
	}

	private void fireEditingStopped() {
		treetable.editingStopped(changeEvent);
	}

	private void fireEditingCanceled() {
		treetable.editingCanceled(changeEvent);
	}
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
