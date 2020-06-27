/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.ui.comps.treetable;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.ImageIcon;

/**
 * @author  P203125
 */
public class JTreeTablePopupAction extends AbstractAction {
	private static final long serialVersionUID = 1L;

	public JTreeTablePopupAction(String text, ImageIcon icon, String desc, Integer mnemonic) {
		super(text, icon);
		putValue(NAME, text);
		putValue(SHORT_DESCRIPTION, desc);
		putValue(MNEMONIC_KEY, mnemonic);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	}
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
