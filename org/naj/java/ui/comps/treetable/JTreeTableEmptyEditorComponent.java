/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.ui.comps.treetable;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author  P203125
 */
public class JTreeTableEmptyEditorComponent extends JTreeTableDefaultEditorComponent {

	private static final long serialVersionUID = 1L;
	private JLabel lb;

	public JTreeTableEmptyEditorComponent() {
		super(null);

		lb = new JLabel();
		lb.setText("");
	}

	@Override
	public Component getEditorComponent() {
		return lb;
	}

	@Override
	public Object getEditorValue() {
		return "";
	}

	@Override
	public void setEditorValue(Object value) {
	}

	@Override
	public Component getRendererComponent(
		Component parent,
		Object    value,
		boolean   isSelected,
		boolean   isEnabled,
		Color	  fc,
		Color	  bc
	) {
		Component co = super.getRendererComponent(parent, value, isSelected, isEnabled, fc, bc);
		((JPanel) co).removeAll();
		return co;
	}
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
