/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.ui.comps.treetable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * @author  P203125
 */
public class JTreeTableHyperlinkEditorComponent extends JPanel implements JTreeTableEditorComponent {
	private static final long serialVersionUID = 1L;

	private JTreeTableListener listener;

	private String name;
	private String value;
	private JLabel label;

	public JTreeTableHyperlinkEditorComponent(String name) {
		this(name, null);
	}

	public JTreeTableHyperlinkEditorComponent(String name, JTreeTableListener listener) {

		this.name = name;
		this.listener = listener;

		setLayout(new BorderLayout(0, 0));
		setOpaque(true);

		label = new JLabel();
		label.setOpaque(true);
		label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		label.addMouseListener(
			new MouseAdapter() {

				@Override
				public void mouseEntered(MouseEvent e) {
					label.setText(String.format("<html><a href=''>%s</a></html>", value));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					label.setText(value);
				}

				@Override
				public void mouseClicked(MouseEvent e) {
					if (JTreeTableHyperlinkEditorComponent.this.listener != null) {
						JTreeTableHyperlinkEditorComponent.this.listener.nodeActionPerformed(
							JTreeTableHyperlinkEditorComponent.this.name,
							getEditorValue()
						);
					}
				}
			}
		);

		add(label, BorderLayout.CENTER);
	}

	public void setListener(JTreeTableListener listener) {
		this.listener = listener;
	}

	@Override
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
		this.value = value.toString();
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
		String tt = value == null ? null : getTooltips(value);
		Icon ic = getIcon(value);

		label.setText(value.toString());
		label.setIcon(ic);
		label.setToolTipText(tt);
		label.setForeground(isSelected ? Color.WHITE : Color.BLUE.darker());
		label.setBackground(bc);
		label.setHorizontalAlignment(SwingConstants.LEFT);

		setForeground(fc);
		setBackground(bc);

		return this;
	}

	@Override
	public void setEditorListener(JTreeTableCellEditor listener) {
	}

	@Override
	public void fireEditingStopped(JTreeTableEditorComponent editor) {
	}

	@Override
	public void fireEditingCanceled(JTreeTableEditorComponent editor) {
	}

	protected Icon getIcon(Object value) {
		return null;
	}

	protected String getTooltips(Object value) {
		return null;
	}
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
