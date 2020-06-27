/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.ui.comps;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;

import org.naj.java.ui.Helper;
import org.naj.java.ui.layout.CellsLayout;

/**
 * @author  P203125
 */
public class JDatePeriod extends JPanel {

	private static final long serialVersionUID = 1L;

	private JDatePeriodBox dpbox;
	private JTextField tx;
	private JButton bt;
	private String value;
	private List<ActionListener> actionListeners;

	/**
	 * @param
	 *
	 * @return
	 *
	 * @see
	 */
	public JDatePeriod() {
		super(new BorderLayout());

		dpbox = new JDatePeriodBox();

		tx = new JTextField();
		tx.addFocusListener(
			new FocusAdapter() {
				public void focusLost(FocusEvent e) {
					setPeriod(tx.getText());
				}
			}
		);

		bt = new JButton(Helper.getImage("dayperiod.png"));
		bt.setPreferredSize(new Dimension(20, 18));
		bt.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent ev) {
					open();
				}
			}
		);

		setBorder(tx.getBorder());
		tx.setBorder(null);

		setPreferredSize(new Dimension(240, 22));
		setMinimumSize(new Dimension(240, 22));
		setMaximumSize(new Dimension(240, 22));

		add(tx, BorderLayout.CENTER);
		add(bt, BorderLayout.EAST);

		actionListeners = new ArrayList<ActionListener>();

		addFocusListener(
			new FocusListener() {
				public void focusGained(FocusEvent e) {
					tx.requestFocus();
				}

				public void focusLost(FocusEvent e) {
				}
			}
		);
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @see
	 */
	public void setPeriod(GregorianCalendar fd, GregorianCalendar td) {
		dpbox.setPeriod(fd, td);
		value = dpbox.getPeriodString();
		tx.setText(value);
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @see
	 */
	public void setPeriod(String pr) {
		dpbox.setPeriod(pr);
		value = pr;
		tx.setText(value);
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @see
	 */
	public String getPeriodString() {
		return dpbox.getPeriodString();
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @see
	 */
	public GregorianCalendar getFrom() {
		return dpbox.getFrom();
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @see
	 */
	public GregorianCalendar getTo() {
		return dpbox.getTo();
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @see
	 */
	public void setEditable(boolean b) {
		tx.setEditable(b);
		bt.setEnabled(b);
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @see
	 */
	public boolean isEditable() {
		return tx.isEditable();
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @see
	 */
	public void setEnabled(boolean b) {
		tx.setEnabled(b);
		bt.setEnabled(b);
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @see
	 */
	public boolean isEnabled() {
		return tx.isEnabled();
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @see
	 */
	public void setVisible(boolean b) {
		tx.setVisible(b);
		bt.setVisible(b);
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @see
	 */
	public boolean isVisible() {
		return tx.isVisible();
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @see
	 */
	void open() {
		Point p = getLocationOnScreen();
		dpbox.setPeriod(value);
		dpbox.open(p.x + 1, p.y + 26);
		if (dpbox.closeState == 1) {
			close();
		}
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @see
	 */
	void close() {
		value = dpbox.getPeriodString();
		tx.setText(value);
		for (ActionListener al : actionListeners) {
			al.actionPerformed(new ActionEvent(this, 0, null));
		}
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @see
	 */
	public void addActionListener(ActionListener al) {
		actionListeners.add(al);
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @see
	 */
	public void removeActionListener(ActionListener al) {
		actionListeners.remove(al);
	}

	/**
	 * JTimePeriodBox
	 */
	class JDatePeriodBox extends JDialog {

		private static final long serialVersionUID = 1L;

		private JCalendar from;
		private JCalendar to;

		int closeState = 0;

		/**
		 * @param
		 *
		 * @return
		 *
		 * @see
		 */
		JDatePeriodBox() {
			super();
			this.from = new JCalendar();
			this.to = new JCalendar();

			double[][] constraints = {
					{ 22.0, 22.0, 5.0, 24.0 },
					{ 30.0, 40.0, 25.0, 25.0 }
				};

			CellsLayout layout = new CellsLayout(constraints, 4, 4);
			JPanel pan = new JPanel();
			pan.setLayout(layout);

			pan.add(new JLabel("Von:"), new CellsLayout.Cell(0, 0, false, 0, 0, CellsLayout.LEFT, CellsLayout.TOP));
			pan.add(from, new CellsLayout.Cell(0, 1, false, 0, 2, CellsLayout.LEFT, CellsLayout.TOP));
			pan.add(new JLabel("Bis:"), new CellsLayout.Cell(1, 0, false, 0, 0, CellsLayout.LEFT, CellsLayout.TOP));
			pan.add(to, new CellsLayout.Cell(1, 1, false, 0, 2, CellsLayout.LEFT, CellsLayout.TOP));

			JButton b1 = new JButton(Helper.getImage("ok.png"));
			JButton b2 = new JButton(Helper.getImage("cancel.png"));
			b1.setBorderPainted(false);
			b1.setBorder(null);
			b1.setMargin(new Insets(0, 0, 0, 0));
			b1.setContentAreaFilled(false);
			b2.setBorderPainted(false);
			b2.setBorder(null);
			b2.setMargin(new Insets(0, 0, 0, 0));
			b2.setContentAreaFilled(false);

			b1.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
						closeState = 1;
					}
				}
			);

			b2.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
						closeState = 0;
					}
				}
			);

			pan.add(b2, new CellsLayout.Cell(3, 2, false, 0, 0, CellsLayout.LEFT, CellsLayout.TOP));
			pan.add(b1, new CellsLayout.Cell(3, 3, false, 0, 0, CellsLayout.LEFT, CellsLayout.TOP));

			add(pan);

			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			setModalityType(ModalityType.APPLICATION_MODAL);
			setResizable(false);
		}

		/**
		 * @param
		 *
		 * @return
		 *
		 * @see
		 */
		public JRootPane createRootPane() {
			JRootPane rootPane = new JRootPane();
			KeyStroke stroke = KeyStroke.getKeyStroke("ESCAPE");
			Action action =
				new AbstractAction() {

					private static final long serialVersionUID = 1L;

					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				};

			InputMap inputMap = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
			inputMap.put(stroke, "ESCAPE");
			rootPane.getActionMap().put("ESCAPE", action);
			return rootPane;
		}

		/**
		 * @param
		 *
		 * @return
		 *
		 * @see
		 */
		protected void open(int x, int y) {
			setLocation(x, y);
			pack();
			setVisible(true);
			transferFocus();
			from.requestFocusInWindow();
		}

		/**
		 * @param
		 *
		 * @return
		 *
		 * @see
		 */
		protected void close() {
			setVisible(false);
		}

		/**
		 * @param
		 *
		 * @return
		 *
		 * @see
		 */
		protected GregorianCalendar getFrom() {
			return from.getDate();
		}

		/**
		 * @param
		 *
		 * @return
		 *
		 * @see
		 */
		protected GregorianCalendar getTo() {
			return to.getDate();
		}

		/**
		 * @param
		 *
		 * @return
		 *
		 * @see
		 */
		protected String getPeriodString() {
			String f = from.getDateString();
			String t = to.getDateString();
			return !f.isEmpty() && !t.isEmpty() ? f + "-" + t : "";
		}

		/**
		 * @param
		 *
		 * @return
		 *
		 * @see
		 */
		protected void setPeriod(GregorianCalendar fd, GregorianCalendar td) {
			from.setDate(fd);
			to.setDate(td);
		}

		/**
		 * @param
		 *
		 * @return
		 *
		 * @see
		 */
		protected void setPeriod(String pr) {
			if (pr != null && !pr.isEmpty()) {
				String[] p = pr.split("-");
				from.setDate(p[0]);
				to.setDate(p[1]);
			}
		}
	}

	/**
	 * Ein kleines Testprogramm
	 *
	 * @param
	 *
	 * @return
	 *
	 * @see
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
		}

		JFrame frame = new JFrame("JDatePeriod Example");
		frame.addWindowListener(
			new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			}
		);

		frame.getContentPane().setLayout(null);
		JDatePeriod b = new JDatePeriod();
		b.setPeriod("31.12.1967-31.12.1967");
		b.setBounds(40, 40, 150, 22);
		frame.getContentPane().add(b);
		frame.pack();
		frame.setSize(300, 200);
		frame.setVisible(true);
	}
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
