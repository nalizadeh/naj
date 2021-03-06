/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.ui.comps.treetable;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

/**
 * @author  P203125
 */
public class JTreeTableMouseListener extends MouseAdapter {

	private JTreeTable treetable;

	public JTreeTableMouseListener(JTreeTable treetable) {
		this.treetable = treetable;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.isControlDown()) {
			treetable.clearSelection();
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		if (treetable.bodyRolloverIndex != -1) {
			treetable.repaintRow(treetable.bodyRolloverIndex);
			treetable.bodyRolloverIndex = -1;
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int row = treetable.rowAtPoint(e.getPoint());
		if (row != treetable.bodyRolloverIndex) {
			treetable.repaintRow(treetable.bodyRolloverIndex);
			treetable.bodyRolloverIndex = row;
			treetable.repaintRow(treetable.bodyRolloverIndex);
		}
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if (treetable.bodyRolloverIndex != -1) {
			treetable.repaintRow(treetable.bodyRolloverIndex);
			treetable.bodyRolloverIndex = -1;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if (treetable.getProperties().showPopupMenu && e.isPopupTrigger()) {
			int row = treetable.rowAtPoint(e.getPoint());
			if (row != -1) {
				JTreeTableNode[] sels = treetable.getSelectedNodes();
				if (sels.length <= 1) {
					treetable.setRowSelectionInterval(row, row);
				}
				treetable.contextMenu.show(row, e);
			}
		}
	}
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
