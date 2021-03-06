/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

/*
 * Copyright 2007 N.A.J. nalizadeh.com - All rights reserved. nalizadeh.com PROPRIETARY/CONFIDENTIAL. Use is subject to
 * license terms.
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the GNU General Public
 * License as published by the Free Software Foundation; either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 */

package org.naj.java.ui.comps;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;

import org.naj.java.ui.Helper;

/**
 * <p>Title:</p>
 *
 * <p>Description:</p>
 *
 * <p>Copyright: Copyright (c) 2007 N.A.J</p>
 *
 * <p>Organization:</p>
 *
 * @author   Nader Alizadeh
 * @version  1.0
 */
public class JCalendar extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField tx;
	private JButton bt;
	private JCalendarBox cb;
	private String value;
	private List<ActionListener> actionListeners;

	/**
	 * @param
	 *
	 * @return
	 *
	 * @see
	 */
	public JCalendar() {
		this(true);
	}
	
	/**
	 * @param
	 *
	 * @return
	 *
	 * @see
	 */
	public JCalendar(boolean usePopup) {
		super(new BorderLayout());

		cb = new JCalendarBox(this, usePopup);

		tx = new JTextField();
		tx.addFocusListener(
			new FocusAdapter() {
				public void focusLost(FocusEvent e) {
					setDate(tx.getText());
				}
			}
		);

		bt = new JButton(Helper.getImage("calendar.gif"));
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

		add(tx, BorderLayout.CENTER);
		add(bt, BorderLayout.EAST);

		Dimension d = new Dimension(90, 22);
		setMinimumSize(d);
		setMaximumSize(d);
		setPreferredSize(d);

		actionListeners = new Vector<ActionListener>();

		addFocusListener(
			new FocusListener() {
				public void focusGained(FocusEvent e) {
					tx.requestFocus();
				}

				public void focusLost(FocusEvent e) {
				}
			}
		);

		actionListeners = new ArrayList<ActionListener>();
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @see
	 */
	public void setDate(GregorianCalendar v) {
		String va = cb.setDate(v);
		if (va != null) {
			value = va;
			tx.setText(value);
		} else {
			value = null;
			tx.setText("");
			cb.setDate(new GregorianCalendar());
		}
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @see
	 */
	public void setDate(String v) {
		String va = cb.setDate(v);
		if (va != null) {
			value = va;
			tx.setText(value);
		} else {
			value = null;
			tx.setText("");
			cb.setDate(new GregorianCalendar());
		}
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @see
	 */
	public void setDate(Date date) {
		String va = cb.setDate(date);
		if (va != null) {
			value = va;
			tx.setText(va);
		} else {
			value = null;
			tx.setText("");
			cb.setDate(new GregorianCalendar());
		}
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @see
	 */
	public GregorianCalendar getDate() {
		return value == null ? null : cb.getDate();
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @see
	 */
	public String getDateString() {
		return value == null ? "" : value;
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @see
	 */
	public int getDay() {
		return cb.getDay();
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @see
	 */
	public String getDayString() {
		return cb.getDayString();
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @see
	 */
	public int getMonth() {
		return cb.getMonth();
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @see
	 */
	public String getMonthString() {
		return cb.getMonthString();
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @see
	 */
	protected String getMonthName() {
		return cb.getMonthName();
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @see
	 */
	public int getYear() {
		return cb.getYear();
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @see
	 */
	public String getYearString() {
		return cb.getYearString();
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
		cb.setDate(value);
		cb.open(bt);
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @see
	 */
	void close() {
		value = cb.getDateString();
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
	 * @author  Admin
	 */
	static class JCalendarBox extends JPanel {

		private static final long serialVersionUID = 1L;

		private JPopupMenu popupmenu;
		private JPopup popup;
		private GregorianCalendar date;
		private JCalendarTable days;
		private JComboBox<String> months;
		private JSpinner monthsSp;
		private JSpinner years;
		private JButton today = new JButton(Helper.getImage("calendar.gif"));
		private JCalendar parent;
		private boolean initial = false;

		private int hoveredRow = -1;
		private int hoveredColumn = -1;

		private static final String[] monthnames =
			{
				"Januar", "Februar", "März", "April", "Mai", "Juni", "Juli", "August", "September", "Oktober",
				"November", "Dezember"
			};

		/**
		 * @param
		 *
		 * @return
		 *
		 * @see
		 */
		JCalendarBox(JCalendar parent, boolean usePopup) {
			this.parent = parent;

			if (usePopup) {
				popup = new JPopup();
				
				months = new JComboBox<String>(monthnames);
				months.setPreferredSize(new Dimension(80, 22));
				months.addActionListener(
					new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent ev) {
							updateDate();
						}
					}
				);
			} else {
				popupmenu = new JPopupMenu();
				SpinnerListModel monthModel = new SpinnerListModel(monthnames);
				monthsSp = new JSpinner(monthModel);
				monthsSp.setPreferredSize(new Dimension(80, 22));
				monthsSp.addChangeListener(new ChangeListener() {
					public void stateChanged(ChangeEvent e) {
						updateDate();
					}
				});
				
				JComponent editor = monthsSp.getEditor();
				if (editor instanceof JSpinner.DefaultEditor) {
					JTextField tx = ((JSpinner.DefaultEditor) editor).getTextField(); 
					tx.setHorizontalAlignment(JTextField.LEFT);
					tx.setEditable(false);
				}
			}

			SpinnerDateModel yearModel = new SpinnerDateModel();
			years = new JSpinner(yearModel);
			JSpinner.DateEditor yearsEditor = new JSpinner.DateEditor(years, "yyyy");
//          JSpinner.DateEditor editor2 = new JSpinner.DateEditor(spinner2, "MMMMM dd, yyyy");
			years.setEditor(yearsEditor);
			years.setPreferredSize(new Dimension(60, 22));
			years.addChangeListener(
				new ChangeListener() {
					@Override
					public void stateChanged(ChangeEvent e) {
						updateDate();
					}
				}
			);

			today.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent ev) {
						setDate(new GregorianCalendar());
					}
				}
			);
			today.setPreferredSize(new Dimension(20, 22));
			today.setFocusable(false);

			days = new JCalendarTable();

			days.addKeyListener(new CalendarKeyListener());
			days.addMouseListener(new CalendarMouseListener());
			days.addMouseMotionListener(new CalendarMouseListener());

			JPanel buttonPanel1 = new JPanel(new BorderLayout(1, 1));
			buttonPanel1.add(usePopup ? months : monthsSp, BorderLayout.CENTER);
			buttonPanel1.add(years, BorderLayout.EAST);

			JPanel buttonPanel2 = new JPanel(new BorderLayout(1, 1));
			buttonPanel2.add(buttonPanel1, BorderLayout.CENTER);
			buttonPanel2.add(today, BorderLayout.EAST);

			JScrollPane sp = new JScrollPane(days);
			sp.setBorder(BorderFactory.createEmptyBorder());

			JPanel p = new JPanel(new BorderLayout(1, 1));
			p.add(buttonPanel2, BorderLayout.NORTH);
			p.add(sp, BorderLayout.CENTER);

			setLayout(new BorderLayout(0, 0));
			add(p, BorderLayout.CENTER);

			Dimension d1 = buttonPanel2.getPreferredSize();
			Dimension d2 = days.getPreferredSize();
			setPreferredSize(new Dimension(d1.width + 12, d1.height + d2.height + 26)); //178, 173));
			setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

			setDate(new GregorianCalendar());
		}

		/**
		 * @param
		 *
		 * @return
		 *
		 * @see
		 */
		protected void open(Component parent) {
			Dimension dp = parent.getPreferredSize();
			Dimension dm = getPreferredSize();
			if (popup != null) {
				popup.open(parent, this, dp.width - dm.width + 1, dp.height + 3);
			} else {
				popupmenu.add(this);
				popupmenu.setPreferredSize(new Dimension(dm.width, dm.height + 3));
				popupmenu.show(parent, dp.width - dm.width, dp.height + 3);
			}
			transferFocus();
			days.requestFocusInWindow();
		}

		/**
		 * @param
		 *
		 * @return
		 *
		 * @see
		 */
		protected void close() {
			if (popup != null) {
				popup.close();
			}
			else {
				popupmenu.removeAll();
				popupmenu.setVisible(false);
			}
			hoveredColumn = -1;
			hoveredRow = -1;
			if (!getDayString().equals("")) {
				parent.close();
			}
		}

		/**
		 * @param   row
		 * @param   col
		 *
		 * @return  Cursor
		 */
		private Cursor getCursor(int row, int col) {
			if (row != -1 && col != -1) {
				if (!days.getModel().getValueAt(row, col).toString().isEmpty()) {
					return Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
				}
			}
			return Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR);
		}

		/**
		 * @param
		 *
		 * @return
		 *
		 * @see
		 */
		protected GregorianCalendar getDate() {
			return date;
		}

		/**
		 * @param
		 *
		 * @return
		 *
		 * @see
		 */
		protected String getDateString() {
			return getDayString() + "." + getMonthString() + "." + getYearString();
		}

		/**
		 * @param
		 *
		 * @return
		 *
		 * @see
		 */
		protected int getDay() {
			int col = days.getSelectedColumn();
			int row = days.getSelectedRow();
			return Integer.parseInt((String) days.getValueAt(row, col));
		}

		/**
		 * @param
		 *
		 * @return
		 *
		 * @see
		 */
		protected String getDayString() {
			int col = days.getSelectedColumn();
			int row = days.getSelectedRow();
			String d = (String) days.getValueAt(row, col);
			return d.length() == 0 ? "" : (d.length() < 2 ? ("0" + d) : d);
		}

		/**
		 * @param
		 *
		 * @return
		 *
		 * @see
		 */
		protected int getMonth() {
			int m = 0;			
			if (popup != null) {
				m = months.getSelectedIndex();
			} else {
				String mn = (String)monthsSp.getValue();
				while (!monthnames[m].equals(mn)) m++;
			}
			return m;
		}

		/**
		 * @param
		 *
		 * @return
		 *
		 * @see
		 */
		protected String getMonthString() {
			int m = 0;			
			if (popup != null) {
				m = months.getSelectedIndex() + 1;
			} else {
				String mn = (String)monthsSp.getValue();
				while (!monthnames[m].equals(mn)) m++;
			}
			String ms = "" + m;
			return ms.length() < 2 ? ("0" + ms) : ms;
		}

		/**
		 * @param
		 *
		 * @return
		 *
		 * @see
		 */
		protected String getMonthName() {
			return popup != null ? (String) months.getSelectedItem() : (String) monthsSp.getValue();
		}

		/**
		 * @param
		 *
		 * @return
		 *
		 * @see
		 */
		protected int getYear() {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime((Date) years.getValue());
			return calendar.get(Calendar.YEAR);
		}

		/**
		 * @param
		 *
		 * @return
		 *
		 * @see
		 */
		protected String getYearString() {
			return "" + getYear();
		}

		/**
		 * @param
		 *
		 * @return
		 *
		 * @see
		 */
		protected String setDate(String v) {
			try {
				SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
				return setDate(formatter.parse(v));
			} catch (Exception e) {
				return null;
			}
		}

		/**
		 * @param
		 *
		 * @return
		 *
		 * @see
		 */
		public String setDate(Date date) {
			GregorianCalendar gc = new GregorianCalendar();
			gc.setTime(date);
			return setDate(gc);
		}

		/**
		 * @param
		 *
		 * @return
		 *
		 * @see
		 */
		protected String setDate(GregorianCalendar gc) {
			int y = gc.get(Calendar.YEAR);
			int m = gc.get(Calendar.MONTH);
			int d = gc.get(Calendar.DAY_OF_MONTH);

			date = new GregorianCalendar(y, m, d);

			initial = true;
			years.setValue(date.getTime());
			if (popup != null) {
				months.setSelectedIndex(m);
			} else {
				monthsSp.setValue(monthnames[m]);
			}
			initial = false;

			updateDate();

			DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
			return df.format(gc.getTime());
		}

		/**
		 * @param
		 *
		 * @return
		 *
		 * @see
		 */
		private void updateDate() {
			if (!initial) {
				
				int m = 0;
				if (popup != null) {
					m = months.getSelectedIndex();
				}
				else {
					String mn = (String)monthsSp.getValue();
					while (!monthnames[m].equals(mn)) m++;
				}
				Calendar calendar = Calendar.getInstance();
				calendar.setTime((Date) years.getValue());

				int d = date.get(Calendar.DAY_OF_MONTH);
				int y = calendar.get(Calendar.YEAR);

				days.update(d, m, y);

				repaint();
			}
		}

		/**
		 * @param
		 *
		 * @return
		 *
		 * @see
		 */
		private void change(int n) {
			date.add(Calendar.DAY_OF_MONTH, n);
			setDate(date);
		}

		//##########################################################
		// Inner Classes
		//##########################################################

		class CalendarKeyListener implements KeyListener {

			@Override
			public void keyPressed(KeyEvent e) {

				int kc = e.getKeyCode();

				e.consume();

				switch (kc) {

					case KeyEvent.VK_LEFT :
						change(-1);
						break;

					case KeyEvent.VK_RIGHT :
						change(+1);
						break;

					case KeyEvent.VK_UP :
						change(-7);
						break;

					case KeyEvent.VK_DOWN :
						change(+7);
						break;

					case KeyEvent.VK_ENTER :
						close();
						break;

					case KeyEvent.VK_ESCAPE :
						close();
						break;

					default :
						break;
				}
			}

			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		}

		class CalendarMouseListener extends MouseAdapter {

			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2 && !getDayString().equals("")) {
					close();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
				hoveredColumn = -1;
				hoveredRow = -1;
				days.repaint();
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (!getDayString().equals("")) {
					close();
				}
			}

			@Override
			public void mouseDragged(MouseEvent e) {
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				Point p = e.getPoint();
				hoveredRow = days.rowAtPoint(p);
				hoveredColumn = days.columnAtPoint(p);
				days.setCursor(getCursor(hoveredRow, hoveredColumn));
				days.repaint();
			}
		}

		private class JCalendarTable extends JTable {

			private static final long serialVersionUID = 1L;

			private final String[] days = { "Mo", "Di", "Mi", "Do", "Fr", "Sa", "So" };

			private final Object[][] data =
				{
					{ "", "", "", "", "", "", "" },
					{ "", "", "", "", "", "", "" },
					{ "", "", "", "", "", "", "" },
					{ "", "", "", "", "", "", "" },
					{ "", "", "", "", "", "", "" },
					{ "", "", "", "", "", "", "" }
				};

			/**
			 * @param
			 *
			 * @see
			 */
			JCalendarTable() {

				setModel(new JCalendarTableModel());

				setColumnSelectionAllowed(false);
				setRowSelectionAllowed(false);
				setCellSelectionEnabled(true);

//              setShowGrid(true);
//              setShowHorizontalLines(false);
//              setShowVerticalLines(false);
				setGridColor(Color.WHITE);
				setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
				setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
				setRowHeight(getRowHeight() + 4);
				getTableHeader().setResizingAllowed(false);
				getTableHeader().setReorderingAllowed(false);

				HeaderRenderer hr = new HeaderRenderer();
				SaturdaySundayRenderer cr1 = new SaturdaySundayRenderer();
				EverydayRenderer cr2 = new EverydayRenderer();

				for (int col = 0; col < getColumnCount(); col++) {

					TableColumn column = getColumn(days[col]);
					column.setPreferredWidth(22);

					column.setHeaderRenderer(hr);

					if (col < getColumnCount() - 2) {
						column.setCellRenderer(cr2);
					} else {
						column.setCellRenderer(cr1);
					}
				}
			}

			/**
			 * @param
			 *
			 * @return
			 *
			 * @see
			 */
			protected void update(int d, int m, int y) {

				for (int row = 0; row < getRowCount(); row++) {
					for (int col = 0; col < getColumnCount(); col++) {
						data[row][col] = "";
					}
				}

				GregorianCalendar gc = new GregorianCalendar(y, m, 1);
				int[] fisrDayColumnNumber = { 6, 0, 1, 2, 3, 4, 5 };
				int firstDay = fisrDayColumnNumber[gc.get(Calendar.DAY_OF_WEEK) - 1];

				int dayCount = 1;
				m++;

				for (int row = 0; row < getRowCount(); row++) {

					for (int col = firstDay; col < getColumnCount(); col++) {

						setValueAt(new Integer(dayCount).toString(), row, col);

						if (dayCount == d) {
							setRowSelectionInterval(row, row);
							setColumnSelectionInterval(col, col);
						}

						if (dayCount >= 31) {
							return;
						}
						if ((dayCount >= 30) && ((m == 4) || (m == 6) || (m == 9) || (m == 11))) {
							return;
						}
						if ((dayCount >= 29) && (m == 2)) {
							return;
						}
						if ((dayCount >= 28) && (m == 2) && (!gc.isLeapYear(y))) {
							return;
						}

						dayCount++;
					}
					firstDay = 0;
				}
			}

			class JCalendarTableModel extends AbstractTableModel {

				private static final long serialVersionUID = 1L;

				public int getColumnCount() {
					return days.length;
				}

				public int getRowCount() {
					return 6;
				}

				public String getColumnName(int col) {
					return days[col];
				}

				public Class<?> getColumnClass(int col) {
					return String.class;
				}

				public boolean isCellEditable(int row, int col) {
					return false;
				}

				public Object getValueAt(int row, int col) {
					return data[row][col];
				}

				public void setValueAt(Object value, int row, int col) {
					data[row][col] = value;
				}
			}

			class HeaderRenderer extends DefaultTableCellRenderer {

				private static final long serialVersionUID = 1L;

				public HeaderRenderer() {
					super();
				}

				public Component getTableCellRendererComponent(
					JTable  table,
					Object  value,
					boolean isSelected,
					boolean hasFocus,
					int		row,
					int		column
				) {
					setHorizontalAlignment(SwingConstants.CENTER);
					setFont(new Font("Dialog", 0, 12));
					setText(value != null ? value.toString() : "");
					setBackground(new Color(250, 250, 250));
					setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.white));
					setPreferredSize(new Dimension(80, 22));
					return this;
				}
			}

			class EverydayRenderer extends DefaultTableCellRenderer {
				private static final long serialVersionUID = 1L;

				private Color bc = new Color(192, 220, 230);
				private Color sc = new Color(217, 253, 249);

				public Component getTableCellRendererComponent(
					JTable  table,
					Object  value,
					boolean isSelected,
					boolean hasFocus,
					int		row,
					int		column
				) {

					setValue(value);
					setHorizontalAlignment(CENTER);
					setFont(getFont().deriveFont(12f));
					setFont(getFont().deriveFont(Font.PLAIN));

					if (value.toString().isEmpty()) {
						setForeground(Color.black);
						setBackground(new Color(240, 240, 240));
					} else if (isSelected) {
						setForeground(table.getSelectionForeground());
						setBackground(table.getSelectionBackground());
					} else if (hoveredColumn == column && hoveredRow == row) {
						setForeground(Color.black);
						setBackground(sc);
					} else {
						setForeground(Color.black);
						setBackground(bc);
					}
					return this;
				}
			}

			class SaturdaySundayRenderer extends DefaultTableCellRenderer {

				private static final long serialVersionUID = 1L;

				private Color bc = new Color(181, 223, 182);
				private Color sc = new Color(217, 253, 249);

				public Component getTableCellRendererComponent(
					JTable  table,
					Object  value,
					boolean isSelected,
					boolean hasFocus,
					int		row,
					int		column
				) {

					setValue(value);
					setHorizontalAlignment(CENTER);
					setFont(getFont().deriveFont(12f));
					setFont(getFont().deriveFont(Font.PLAIN));

					if (value.toString().isEmpty()) {
						setForeground(Color.black);
						setBackground(new Color(240, 240, 240));
					} else if (isSelected) {
						setForeground(table.getSelectionForeground());
						setBackground(table.getSelectionBackground());
					} else if (hoveredColumn == column && hoveredRow == row) {
						setForeground(Color.black);
						setBackground(sc);
					} else {
						setForeground(Color.black);
						setBackground(bc);
					}

					return this;
				}
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

		JFrame frame = new JFrame("JCalendar Example");
		frame.addWindowListener(
			new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			}
		);

		frame.getContentPane().setLayout(null);
		JCalendar c1 = new JCalendar();
		c1.setDate("31.12.1967");
		
		JCalendar c2 = new JCalendar(false);
		c2.setDate("31.12.1967");

		c1.setBounds(40, 40, 90, 22);
		c2.setBounds(140, 40, 90, 22);
		frame.getContentPane().add(c1);
		frame.getContentPane().add(c2);
		frame.pack();
		frame.setSize(300, 200);
		frame.setVisible(true);
	}
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
