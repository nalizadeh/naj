/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.ui.comps.treetable;

import java.awt.Component;

/**
 * @author  P203125
 */
public interface JTreeTableListener {
	void tableUpdated();

	void nodesSelected(JTreeTableNode[] nodes);

	void nodesDeselected();

	void nodeActionPerformed(String name, Object args, Component comp);

	void nodeCheckChanged(JTreeTableNode node);
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
