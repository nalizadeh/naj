/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.ui.comps.treetable;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;

import org.naj.java.ui.Helper;
import org.naj.java.ui.comps.JCalendar;

/**
 * @author  P203125
 */
public class JTreeTableDateEditorComponent extends JTreeTableDefaultEditorComponent {

	private static final long serialVersionUID = 1L;

	private static final Icon icon = Helper.getImage("dateeditor.gif");

	private JCalendar ca;

	public JTreeTableDateEditorComponent() {
		super(icon);

		ca = new JCalendar();
		ca.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fireEditingStopped(JTreeTableDateEditorComponent.this);
				}
			}
		);
	}

	@Override
	public Component getEditorComponent() {
		return ca;
	}

	@Override
	public Object getEditorValue() {
		return ca.getDateString();
	}

	@Override
	public void setEditorValue(Object value) {
		ca.setDate((String) value);
	}
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
