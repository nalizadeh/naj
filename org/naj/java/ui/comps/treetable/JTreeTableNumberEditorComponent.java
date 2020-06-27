/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.ui.comps.treetable;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.naj.java.ui.Helper;

/**
 * @author  P203125
 */
public class JTreeTableNumberEditorComponent extends JTreeTableDefaultEditorComponent {

	private static final long serialVersionUID = 1L;

	private static final ImageIcon icon = Helper.getImage("numeditor.gif");

	private boolean adjusting = false;
	private JSpinner sp;

	public JTreeTableNumberEditorComponent() {
		this(
			new SpinnerNumberModel(
				new Integer(0),
				new Integer(Integer.MIN_VALUE),
				new Integer(Integer.MAX_VALUE),
				new Integer(1)
			)
		);
	}

	public JTreeTableNumberEditorComponent(SpinnerNumberModel md) {
		super(icon);

		sp = new JSpinner(md);
		sp.setFocusable(false);

		JSpinner.DefaultEditor ed = (JSpinner.DefaultEditor) sp.getEditor();
		ed.getTextField().setHorizontalAlignment(JLabel.LEFT);

		sp.addChangeListener(
			new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					if (!adjusting) {
						fireEditingStopped(JTreeTableNumberEditorComponent.this);
					}
				}
			}
		);
	}

	@Override
	public Component getEditorComponent() {
		return sp;
	}

	@Override
	public Object getEditorValue() {
		return sp.getValue();
	}

	@Override
	public void setEditorValue(Object value) {
		adjusting = true;
		sp.setValue(value == null ? 0 : value);
		adjusting = false;
	}

	public static class ShortEditorComponent extends JTreeTableNumberEditorComponent {

		private static final long serialVersionUID = 1L;

		public ShortEditorComponent() {
			super(new SpinnerNumberModel(0, Short.MIN_VALUE, Short.MAX_VALUE, 1));
		}

		public ShortEditorComponent(short value, short min, short max, short step) {
			super(new SpinnerNumberModel(value, min, max, step));
		}
	}

	public static class IntegerEditorComponent extends JTreeTableNumberEditorComponent {

		private static final long serialVersionUID = 1L;

		public IntegerEditorComponent() {
			super(new SpinnerNumberModel(0, Integer.MIN_VALUE, Integer.MAX_VALUE, 1));
		}

		public IntegerEditorComponent(int value, int min, int max, int step) {
			super(new SpinnerNumberModel(value, min, max, step));
		}
	}

	public static class LongEditorComponent extends JTreeTableNumberEditorComponent {

		private static final long serialVersionUID = 1L;

		public LongEditorComponent() {
			super(new SpinnerNumberModel(0, Long.MIN_VALUE, Long.MAX_VALUE, 1));
		}

		public LongEditorComponent(long value, long min, long max, long step) {
			super(new SpinnerNumberModel(value, min, max, step));
		}
	}

	public static class DoubleEditorComponent extends JTreeTableNumberEditorComponent {

		private static final long serialVersionUID = 1L;

		public DoubleEditorComponent() {
			super(new SpinnerNumberModel(0, -Double.MIN_VALUE, Double.MAX_VALUE, 0.5f));
		}

		public DoubleEditorComponent(double value, double min, double max, double step) {
			super(new SpinnerNumberModel(value, min, max, step));
		}
	}

	public static class FloatEditorComponent extends JTreeTableNumberEditorComponent {

		private static final long serialVersionUID = 1L;

		public FloatEditorComponent() {
			super(new SpinnerNumberModel(0, -Float.MIN_VALUE, Float.MIN_VALUE, 0.5f));
		}

		public FloatEditorComponent(float value, float min, float max, float step) {
			super(new SpinnerNumberModel(value, min, max, step));
		}
	}
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
