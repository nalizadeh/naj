/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.ui.comps.treetable;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import org.naj.java.ui.Helper;

/**
 * @author  P203125
 */
public class JTreeTableTextEditorComponent extends JTreeTableDefaultEditorComponent {

	private static final long serialVersionUID = 1L;

	private static final ImageIcon icon = Helper.getImage("texteditor.png");

	private JTextField tx;

	public JTreeTableTextEditorComponent() {
		super(icon);

		tx = new JTextField();
		tx.addFocusListener(
			new FocusListener() {
				public void focusGained(final FocusEvent e) {
					tx.selectAll();
				}

				public void focusLost(final FocusEvent e) {
					tx.select(0, 0);
					fireEditingStopped(JTreeTableTextEditorComponent.this);
				}
			}
		);

		tx.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fireEditingStopped(JTreeTableTextEditorComponent.this);
				}
			}
		);

		tx.registerKeyboardAction(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fireEditingStopped(JTreeTableTextEditorComponent.this);
				}
			},
			KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
			JComponent.WHEN_FOCUSED
		);

		tx.registerKeyboardAction(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fireEditingCanceled(JTreeTableTextEditorComponent.this);
				}
			},
			KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0),
			JComponent.WHEN_FOCUSED
		);
	}

	@Override
	public Component getEditorComponent() {
		return tx;
	}

	@Override
	public Object getEditorValue() {
		return tx.getText();
	}

	@Override
	public void setEditorValue(Object value) {
		tx.setText(value == null ? "" : value.toString());
	}
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
