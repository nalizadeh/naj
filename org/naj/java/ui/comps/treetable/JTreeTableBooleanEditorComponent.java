/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.ui.comps.treetable;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JCheckBox;

import org.naj.java.ui.Helper;

/**
 * @author  P203125
 */
public class JTreeTableBooleanEditorComponent extends JTreeTableDefaultEditorComponent {

	private static final long serialVersionUID = 1L;

	private static final Icon ic1 = Helper.getImage("checkboxOff.gif");
	private static final Icon ic2 = Helper.getImage("checkboxOn.gif");
	private static final Icon ic3 = Helper.getImage("check.png");

	private JCheckBox cb;

	public JTreeTableBooleanEditorComponent() {
		super(null);
		cb = new JCheckBox();
		cb.setBorder(null);
		cb.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fireEditingStopped(JTreeTableBooleanEditorComponent.this);
				}
			}
		);
	}

	@Override
	public Component getEditorComponent() {
		return cb;
	}

	@Override
	public Object getEditorValue() {
		return Boolean.valueOf(cb.isSelected());
	}

	@Override
	public void setEditorValue(Object value) {
		cb.setSelected(value == null ? false : ((Boolean) value).booleanValue());
	}

	@Override
	protected String convertToString(Object value) {
		return ""; //value.equals(Boolean.TRUE) ? "True" : "False";
	}

	@Override
	protected Icon convertToIcon(Object value, boolean isEditable) {
		boolean b = value != null && value.equals(Boolean.TRUE);
		if (isEditable) {
			return b ? ic2 : ic1;
		}
		return b ? ic3 : null;
	}
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
