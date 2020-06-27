/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.ui.comps.treetable;

import java.awt.Component;

/**
 * @author  P203125
 */
public interface JTreeTableEditorComponent extends JTreeTableRendererComponent {

	public Component getEditorComponent();

	public Object getEditorValue();

	public void setEditorValue(Object value);

	public String getValidState(Object value);

	public void setEditorListener(JTreeTableCellEditor listener);

	public void fireEditingStopped(JTreeTableEditorComponent editor);

	public void fireEditingCanceled(JTreeTableEditorComponent editor);
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
