/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.ui.comps.treetable;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;

import org.naj.java.ui.Helper;
import org.naj.java.ui.comps.JDatePeriod;

/**
 * @author  P203125
 */
public class JTreeTableDatePeriodEditorComponent extends JTreeTableDefaultEditorComponent {

	private static final long serialVersionUID = 1L;

	private static final Icon icon = Helper.getImage("dayperiod.png");

	private JDatePeriod dpriod;

	public JTreeTableDatePeriodEditorComponent() {
		super(icon);

		dpriod = new JDatePeriod();
		dpriod.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fireEditingStopped(JTreeTableDatePeriodEditorComponent.this);
				}
			}
		);
	}

	@Override
	public Component getEditorComponent() {
		return dpriod;
	}

	@Override
	public Object getEditorValue() {
		return dpriod.getPeriodString();
	}

	@Override
	public void setEditorValue(Object value) {
		dpriod.setPeriod((String) value);
	}
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
