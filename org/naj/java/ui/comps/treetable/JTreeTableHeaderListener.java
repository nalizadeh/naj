/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.ui.comps.treetable;

import java.awt.Rectangle;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 * @author  P203125
 */
public class JTreeTableHeaderListener extends MouseAdapter implements TableColumnModelListener {

	private JTreeTable treetable;

	public JTreeTableHeaderListener(JTreeTable treetable) {
		this.treetable = treetable;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if ((e.getClickCount() == 1) && (e.getModifiers() == InputEvent.BUTTON1_MASK)) {

			int column = treetable.getColumnModel().getColumnIndexAtX(e.getX());
			int columnIndex = treetable.convertColumnIndexToModel(column);

			Rectangle r = treetable.getTableHeader().getHeaderRect(column);

			int x = e.getX() - r.x;

			r.setBounds(
				r.x + r.width - JTreeTableProperties.H_BUTTON_WIDTH,
				r.y,
				JTreeTableProperties.H_BUTTON_WIDTH,
				r.height
			);

			JTreeTableProperties props = treetable.getProperties();

			if (props.showHeaderMenu && treetable.headerMenuButton.getBounds().contains(x, e.getY())) {
				treetable.openHeaderMenu(e.getComponent(), r.x, r.height, columnIndex);
				treetable.headerMenuButton.doClick();
				e.consume();
				return;
			}

			if (props.showExCoButtons && columnIndex == 0) {
				if (treetable.expandButton.getBounds().contains(x, e.getY())) {
					treetable.expandButton.doClick();
					e.consume();
					return;
				} else if (treetable.collapseButton.getBounds().contains(x, e.getY())) {
					treetable.collapseButton.doClick();
					e.consume();
					return;
				}
			}

			int sd = treetable.sortingDirection;
			if (treetable.sortingColumn != -1 && treetable.sortingColumn != columnIndex) {
				sd = JTreeTable.SORTDIR_NO;
			}
			sd =
				sd == JTreeTable.SORTDIR_NO ? JTreeTable.SORTDIR_ASCENDING
				: sd == JTreeTable.SORTDIR_ASCENDING ? JTreeTable.SORTDIR_DESCENDING : JTreeTable.SORTDIR_NO;

			treetable.sort(columnIndex, sd);
			e.consume();
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		treetable.headerRolloverIndex = -1;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		treetable.headerRolloverIndex =
			treetable.convertColumnIndexToModel(treetable.getColumnModel().getColumnIndexAtX(e.getX()));
	}

	@Override
	public void columnAdded(TableColumnModelEvent e) {
		TableColumn column = ((TableColumnModel) e.getSource()).getColumn(e.getToIndex());
		column.setHeaderRenderer(new JTreeTableHeaderRenderer(treetable, column.getModelIndex()));
	}

	@Override
	public void columnRemoved(TableColumnModelEvent e) {
	}

	@Override
	public void columnMoved(TableColumnModelEvent e) {
	}

	@Override
	public void columnMarginChanged(ChangeEvent e) {
	}

	@Override
	public void columnSelectionChanged(ListSelectionEvent e) {
	}
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
