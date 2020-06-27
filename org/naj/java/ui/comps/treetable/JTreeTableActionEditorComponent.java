/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.ui.comps.treetable;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * @author  P203125
 */
public class JTreeTableActionEditorComponent extends JTreeTableDefaultEditorComponent {

	private static final long serialVersionUID = 1L;

	private String name;
	private JTreeTableListener listener;

	private JPanel pan;
	private JLabel lab;
	private JButton but;

	/**
	 * 
	 * @param name
	 * @param icon
	 */
	public JTreeTableActionEditorComponent(String name, Icon icon) {
		this(name, icon, null);
	}
	
	/**
	 * 
	 * @param name
	 * @param icon
	 * @param listener
	 */
	public JTreeTableActionEditorComponent(String name, Icon icon, JTreeTableListener listener) {
		super(icon);

		this.name = name;
		this.listener = listener;

		pan = new JPanel(new BorderLayout(0, 0));
		lab = new JLabel();
		but = new JButton(icon);
		but.addActionListener(this);
		but.setPreferredSize(new Dimension(16, 16));

		pan.add(lab, BorderLayout.CENTER);
		pan.add(but, BorderLayout.EAST);
	}
	
	public void setListener(JTreeTableListener listener) {
		this.listener = listener;
	}

	@Override
	public Component getEditorComponent() {
		return pan;
	}

	@Override
	public Object getEditorValue() {
		return lab.getText();
	}

	@Override
	public void setEditorValue(Object value) {
		lab.setText((String) value);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (listener != null) {
			listener.nodeActionPerformed(name, getEditorValue());
		}
	}
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
