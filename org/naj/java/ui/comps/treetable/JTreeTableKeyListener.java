/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.ui.comps.treetable;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * @author  P203125
 */
public class JTreeTableKeyListener implements KeyListener {

	private JTreeTable treetable;

	public JTreeTableKeyListener(JTreeTable treetable) {
		this.treetable = treetable;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int row = treetable.getSelectedRow();
		if (row != -1) {
			int kc = e.getKeyCode();
			if (kc == KeyEvent.VK_PLUS || kc == KeyEvent.VK_SPACE) {
				e.consume();
				treetable.getTree().expandRow(row);
				treetable.setRowSelectionInterval(row, row);
				treetable.revalidate();
			} else if (kc == KeyEvent.VK_MINUS || kc == KeyEvent.VK_BACK_SPACE) {
				e.consume();
				treetable.getTree().collapseRow(row);
				treetable.setRowSelectionInterval(row, row);
				treetable.revalidate();
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
