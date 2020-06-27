/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.ui.comps.treetable;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

import org.naj.java.ui.Helper;

/**
 * @author  P203125
 */
public class JTreeTableListEditorComponent extends JTreeTableDefaultEditorComponent {

	private static final long serialVersionUID = 1L;

	private static final ImageIcon icon = Helper.getImage("listeditor.gif");

	private Object[] items;
	private Object[] values;
	private Icon[] icons;

	private JComboBox<?> co;

	public JTreeTableListEditorComponent() {
		this(new String[0], new String[0], null);
	}

	public JTreeTableListEditorComponent(Object[] items, Object[] values, Icon[] icons) {
		super(icon);
		setData(items, values, icons);
	}

	public void setData(Object[] items, Object[] values, Icon[] icons) {

		this.items = items;
		this.values = values;
		this.icons = icons;

		co = new JComboBox<Object>(items);
		co.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					fireEditingStopped(JTreeTableListEditorComponent.this);
				}
			}
		);
		co.addKeyListener(
			new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						fireEditingStopped(JTreeTableListEditorComponent.this);
					}
				}
			}
		);
	}

	@Override
	public Component getEditorComponent() {
		return co;
	}

	@Override
	public Object getEditorValue() {
		return translate(co.getSelectedItem());
	}

	@Override
	public void setEditorValue(Object value) {
		co.setSelectedItem(convertToString(value));
	}

	@Override
	protected String convertToString(Object value) {
		if (value == null) {
			return null;
		}
		int n = 0;
		for (Object v : values) {
			if (v.equals(value)) {
				return items[n].toString();
			}
			n++;
		}
		return "";
	}

	@Override
	protected Icon convertToIcon(Object value, boolean isEditable) {
		if (value == null || icons == null) {
			return null;
		}
		int n = 0;
		for (Object v : values) {
			if (v.equals(value)) {
				return icons[n];
			}
			n++;
		}
		return null;
	}

	public Object translate(Object value) {
		int v = 0;
		for (Object o : items) {
			if (o.equals(value)) {
				return values[v];
			}
			v++;
		}
		return null;
	}
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
