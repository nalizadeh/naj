/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.ui.comps.treetable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.naj.java.ui.Helper;

/**
 * @author  P203125
 */
public abstract class JTreeTableDefaultEditorComponent extends JPanel implements JTreeTableEditorComponent,
	ActionListener
{

	private static final long serialVersionUID = 1L;

	private static final Icon icon = Helper.getImage("defeditor.gif");

	private Object value;

	private JLabel label;
	private JButton button;
	private Component parent;

	private JTreeTableCellEditor listener;

	public JTreeTableDefaultEditorComponent() {
		this(icon);
	}

	public JTreeTableDefaultEditorComponent(Icon icon) {
		setLayout(new BorderLayout(0, 0));
		setOpaque(true);

		label = new JLabel();
		label.setOpaque(true);

		add(label, BorderLayout.CENTER);

		if (icon != null) {

			button = new JButton();
			button.setPreferredSize(new Dimension(16, 16));
			button.setOpaque(true);
			button.setBorder(null);
			button.setBorderPainted(false);
			button.setIcon(icon);
			button.setFocusable(false);
			button.addActionListener(this);

			add(button, BorderLayout.EAST);
		}
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

	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		if (label != null) {
			label.setEnabled(enabled);
		}
	}

	@Override
	public Object getEditorValue() {
		return value;
	}

	@Override
	public void setEditorValue(Object value) {
		this.value = value;
	}

	@Override
	public Component getEditorComponent() {
		return this;
	}

	@Override
	public String getValidState(Object value) {
		return null;
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
		this.parent = parent;

		String va = value == null ? null : convertToString(value);
		String tt = value == null ? null : getTooltips(value);
		String sp = getValidState(value);
		Icon ic = convertToIcon(value, isEnabled);

		bc = sp == null ? bc : va == null ? JTreeTableProperties.MANDATORY_COLOR : JTreeTableProperties.ERROR_COLOR;

		label.setText(va);
		label.setIcon(ic);
		label.setFont(JTreeTableProperties.EDITOR_FONT);
		label.setForeground(fc);
		label.setBackground(bc);
		label.setEnabled(isEnabled);

		if ((va == null || va.isEmpty()) && ic != null) {
			label.setHorizontalAlignment(SwingConstants.RIGHT);
		}

		setForeground(fc);
		setBackground(bc);

		String tp =
			tt == null || tt.isEmpty() ? (sp == null || sp.isEmpty() ? (va == null || va.isEmpty() ? null : va) : sp)
			: tt;
		if (tp != null) {
			setToolTipText(tp);
		}

		if (button != null) {
			button.setBackground(bc);
			button.setEnabled(isEnabled);
		}

		return this;
	}

	@Override
	public void setEditorListener(JTreeTableCellEditor listener) {
		this.listener = listener;
	}

	@Override
	public void fireEditingStopped(JTreeTableEditorComponent editor) {
		if (listener != null) {
			listener.stopCellEditing();
		}
	}

	@Override
	public void fireEditingCanceled(JTreeTableEditorComponent editor) {
		if (listener != null) {
			listener.cancelCellEditing();
		}
	}

	protected String convertToString(Object value) {
		return value.toString();
	}

	protected Icon convertToIcon(Object value, boolean isEnabled) {
		return null;
	}

	protected String getTooltips(Object value) {
		return convertToString(value);
	}

	protected Object startCustomEditor(Component parent, Object value) {
		return null;
	}

	public void actionPerformed(ActionEvent e) {
		Object value = startCustomEditor(parent, getEditorValue());
		if (value != getEditorValue()) {
			setEditorValue(value);
			fireEditingStopped(this);
		}
	}
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
