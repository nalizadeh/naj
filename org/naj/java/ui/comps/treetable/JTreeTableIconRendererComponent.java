/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.ui.comps.treetable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * @author  P203125
 */
public class JTreeTableIconRendererComponent extends JPanel implements JTreeTableRendererComponent {
	private static final long serialVersionUID = 1L;

	private JLabel label;

	public JTreeTableIconRendererComponent() {
		setLayout(new BorderLayout(0, 0));
		setOpaque(true);

		label = new JLabel();
		label.setOpaque(true);

		add(label, BorderLayout.CENTER);
	}

	public void setForeground(Color fg) {
		super.setForeground(fg);
		if (label != null) {
			label.setForeground(fg);
		}
	}

	public void setBackground(Color bg) {
		super.setBackground(bg);
		if (label != null) {
			label.setBackground(bg);
		}
	}

	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		if (label != null) {
			label.setEnabled(enabled);
		}
	}

	@Override
	public Object getRendererValue() {
		return null;
	}

	@Override
	public void setRendererValue(Object value) {
		label.setIcon(getIcon(value));
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
		String tt = value == null ? null : getTooltips(value);
		Icon ic = getIcon(value);

		label.setText("");
		label.setIcon(ic);
		label.setForeground(fc);
		label.setBackground(bc);
		label.setHorizontalAlignment(SwingConstants.CENTER);

		setForeground(fc);
		setBackground(bc);
		if (tt != null) {
			setToolTipText(tt);
		}

		return this;
	}

	protected Icon getIcon(Object value) {
		return null;
	}

	protected String getTooltips(Object value) {
		return null;
	}
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
