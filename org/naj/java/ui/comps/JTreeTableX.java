/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

/*
 * Copyright 2007 N.A.J. nalizadeh.org - All rights reserved. nalizadeh.org PROPRIETARY/CONFIDENTIAL. Use is subject to
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
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.EventListener;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.plaf.basic.BasicTableUI;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import org.naj.java.ui.Helper;

/**
 * <p>Title:</p>
 *
 * JTreeTable
 *
 * <p>Description:</p>
 *
 * JTreeTable displays the hierarchical data in a tree within a table and provides for sorting, filtering and editing
 * data.
 *
 * <p>Copyright: Copyright (c) 2007 N.A.J</p>
 *
 * <p>Organization:</p>
 *
 * @author   Nader Alizadeh Janevislou
 * @version  1001.01
 */
public class JTreeTableX extends JTable implements TreeExpansionListener {

	private static final long serialVersionUID = 1L;

	public static final int FONT_SIZE = 13;

	private static final ImageIcon TT_MEN_ICON = JTreeTableX.getImage("headmenu.png");
	private static final ImageIcon TT_MEH_ICON = JTreeTableX.getImage("men.png");
	private static final ImageIcon TT_PLO_ICON = JTreeTableX.getImage("expand.gif");
	private static final ImageIcon TT_MIN_ICON = JTreeTableX.getImage("collapse.gif");
	private static final ImageIcon TT_EXP_ICON = JTreeTableX.getImage("expand.png");
	private static final ImageIcon TT_COL_ICON = JTreeTableX.getImage("collapse.png");
	private static final ImageIcon TT_ASC_ICON = JTreeTableX.getImage("sortAZ.png");
	private static final ImageIcon TT_DES_ICON = JTreeTableX.getImage("sortZA.png");
	private static final ImageIcon TT_ASC_NOHE = JTreeTableX.getImage("sortAscanding.png");
	private static final ImageIcon TT_DES_NOHE = JTreeTableX.getImage("sortDescanding.png");
	private static final ImageIcon TT_REM_SORT = JTreeTableX.getImage("remSort.png");
	private static final ImageIcon TT_FLT_ICON = JTreeTableX.getImage("filter.png");
	private static final ImageIcon TT_REM_FILT = JTreeTableX.getImage("remFilter.png");
	private static final ImageIcon TT_SER_ICON = JTreeTableX.getImage("search.png");
	private static final ImageIcon TT_LIS_ICON = JTreeTableX.getImage("lst.png");
	private static final ImageIcon TT_DET_ICON = JTreeTableX.getImage("rowdetail.png");
	private static final ImageIcon TT_COP_ICON = JTreeTableX.getImage("copy.png");
	private static final ImageIcon TT_PAS_ICON = JTreeTableX.getImage("paste.png");

	// Colors and fonts to rendering the cells
	private static final Color TT_COLOR1 = new Color(250, 250, 250);
	private static final Color TT_COLOR2 = new Color(240, 240, 240);
	private static final Color TT_COLOR3 = new Color(230, 230, 230);
	private static final Color TT_COLOR4 = new Color(222, 222, 222);

	private static final Color ROLLOVER_COLOR = new Color(217, 235, 249);
	private static final Color ERROR_COLOR = new Color(255, 192, 192);
	private static final Color MANDATORY_COLOR = new Color(255, 240, 192);

	private static Font TT_FONT1;
	private static Font TT_FONT2;
	public static Font EDITOR_FONT;

	// Sorting
	public static final int SORTDIR_ASCENDING = 1;
	public static final int SORTDIR_DESCENDING = -1;
	public static final int SORTDIR_NO = 0;

	private int sortingColumn = -1;
	private int sortingDirection = SORTDIR_NO;

	// Comparators used by sorting
	private Map<Class<Object>, Comparator<Object>> defaultComparators =
		new HashMap<Class<Object>, Comparator<Object>>();

	private Map<Integer, Comparator<Object>> columnComparators = new HashMap<Integer, Comparator<Object>>();

	// Header buttons (menu, expand, collapse)
	private static final int H_BUTTON_WIDTH = 16;
	private static final Color H_BUTTON_BGC = new Color(200, 200, 200, 100);

	private JButton headerMenuButton;
	private JButton expandButton;
	private JButton collapseButton;

	// Columns filters
	private Map<Integer, FilterData> filterData = new HashMap<Integer, FilterData>();
	private boolean filterByUser = false;

	// Controll vraiables
	private int expandingLevel = 1;
	private int headerRolloverIndex = -1;
	private int bodyRolloverIndex = -1;
	private int menuIndex = -1;

	// Titles of columns
	private String[] columnNames;
	private List<String> viewColumns = new ArrayList<String>();
	private Map<String, Integer> columnsMap = new LinkedHashMap<String, Integer>();

	// The tree within the table
	private TreeTableTree tree;

	// The main renderer of table cells
	private TreeTableCellRenderer renderer;

	// The main editor of table cells
	private TreeTableCellEditor editor;

	// TreeTable listeners
	private List<TreeTableListener> treeTablelisteners = new ArrayList<TreeTableListener>();

	// TreeTable contextMenu
	private TreeTableContextMenu contextMenu;

	// TreeTable headermenu popup
	private JPopup popup;

	// Controll variables
	private boolean showAlternateColor = true;
	private boolean showRollover = true;
	private boolean showHeaderMenu = true;
	private boolean showExCoButtons = true;
	private boolean showPopupMenu = true;
	private boolean showDetailsPopup = false;
	private boolean showGroupSelection = true;
	private boolean showPartSelection = false;
	private boolean columnsConfigurable = true;

	protected boolean isFlatTable = false;
	private boolean selectionAdjusting = false;

	// Realization of attributive TreeTable
	private TreeTableCellAttribute cellAttributs;

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public JTreeTableX(String[] columnNames) {
		this(columnNames, null, false);
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public JTreeTableX(String[] columnNames, List<String> viewColumns) {
		this(columnNames, viewColumns, false);
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public JTreeTableX(String[] columnNames, List<String> viewColumns, boolean attributive) {
		this.columnNames = columnNames;
		this.cellAttributs = attributive ? new TreeTableCellAttribute() : null;

		doSetViewColumns(viewColumns, true);

		TT_FONT1 = new Font("Arial", 0, JTreeTableX.FONT_SIZE);
		TT_FONT2 = new Font("Arial", Font.BOLD, JTreeTableX.FONT_SIZE);
		EDITOR_FONT = new Font("Arial", 0, JTreeTableX.FONT_SIZE);

		initClass();
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void setViewColumns(List<String> columns) {
		doSetViewColumns(columns, false);
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	private void doSetViewColumns(List<String> columns, boolean initial) {
		if (initial) {
			viewColumns.clear();
			columnsMap.clear();
			for (int i = 0; i < columnNames.length; i++) {
				viewColumns.add(columnNames[i]);
				columnsMap.put(columnNames[i], i);
			}
			return;
		}

		List<String> cols = new ArrayList<String>();
		for (int i = 0; i < columnNames.length; i++) {
			if (columns.contains(columnNames[i])) {
				cols.add(columnNames[i]);
			}
		}

		if (!cols.isEmpty()) {
			viewColumns.clear();
			for (String col : cols) {
				viewColumns.add(col);
			}
			getTreeTableModel().fireTableStructureChanged();
			tableUpdated();
		}
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public List<String> getViewColumns() {
		return viewColumns;
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	private void initClass() {

		tree = new TreeTableTree();
		tree.setRowHeight(getRowHeight());
		tree.setShowCheckBox(true);
		tree.addTreeExpansionListener(this);

		renderer = new TreeTableCellRenderer();
		editor = new TreeTableCellEditor(this);

		setModel(new TreeTableModel());
		setColumnSelectionAllowed(false);
		setAutoResizeMode(AUTO_RESIZE_OFF);
		setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		setIntercellSpacing(new Dimension(1, 1));
		setSurrendersFocusOnKeystroke(true);
		setShowGrid(false);

		if (cellAttributs != null) {

			setUI(new TreeTableAttributiveTableUI());
			getTableHeader().setReorderingAllowed(false);
//          setCellSelectionEnabled(true);
//          setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		}

		//=== This is my implementation of the selection sharing between table and tree, it works excellent!

		getSelectionModel().addListSelectionListener(
			new ListSelectionListener() {

				public void valueChanged(ListSelectionEvent e) {
					if (!selectionAdjusting) {

						selectionAdjusting = true;

						tree.setSelectionRows(getSelectedRows());

						// making of block selection
						TreeTableNode[] nodes = getSelectedNodes();
						if (nodes != null && nodes.length > 0) {
							tree.select(nodes);
							revalidate();
							repaint();
							nodesSelected(nodes);
						} else {
							revalidate();
							repaint();
							nodesDeselected();
						}
						selectionAdjusting = false;
					}
				}
			}
		);

		tree.setSelectionModel(
			new DefaultTreeSelectionModel() {

				private static final long serialVersionUID = 1L;

				public void setSelectionPaths(TreePath[] paths) {
					super.setSelectionPaths(paths);
					selectRows(tree.getSelectionRows());
				}
			}
		);

		//==========================================================================

		TreeTableMouseListener mListener = new TreeTableMouseListener();
		addMouseMotionListener(mListener);
		addMouseListener(mListener);
		//addMouseWheelListener(mListener);

		addKeyListener(new TreeTableKeyListener());

		TreeTableHeaderListener headerListener = new TreeTableHeaderListener();
		getTableHeader().addMouseListener(headerListener);
		getTableHeader().addMouseMotionListener(headerListener);

		TableColumnModel cmodel = getColumnModel();
		cmodel.addColumnModelListener(headerListener);

		Enumeration<TableColumn> columns = cmodel.getColumns();
		while (columns.hasMoreElements()) {
			TableColumn column = (TableColumn) columns.nextElement();
			column.setHeaderRenderer(new TreeTableHeaderRenderer(column.getModelIndex()));
		}

		//=== header-buttons menu / expand / collapse

		final AbstractAction expandAction =
			new AbstractAction("", TT_PLO_ICON) {
				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent e) {
					if (expandingLevel < tree.getDepth()) {
						expandToLevel(expandingLevel + 1);
					}
				}
			};

		final AbstractAction collapseAction =
			new AbstractAction("", TT_MIN_ICON) {
				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent e) {
					if (expandingLevel > 1) {
						collapseToLevel(expandingLevel - 1);
					}
				}
			};

		final MouseAdapter mouseAdapter =
			new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					JButton b = (JButton) e.getSource();
					b.setBorder(BorderFactory.createLineBorder(Color.black));
					b.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				}

				@Override
				public void mouseExited(MouseEvent e) {
					JButton b = (JButton) e.getSource();
					b.setBorder(null);
					b.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				}
			};

		headerMenuButton = new JButton(TT_MEN_ICON);
		headerMenuButton.setContentAreaFilled(false);
		headerMenuButton.setFocusable(false);
		headerMenuButton.setBackground(H_BUTTON_BGC);
		headerMenuButton.setOpaque(true);
		headerMenuButton.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.GRAY));
		headerMenuButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		headerMenuButton.addMouseListener(mouseAdapter);

		expandButton = new JButton(expandAction);
		expandButton.setContentAreaFilled(false);
		expandButton.setFocusable(false);
		expandButton.setBackground(H_BUTTON_BGC);
		expandButton.setOpaque(true);
		expandButton.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.GRAY));
		expandButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		expandButton.setEnabled(false);
		expandButton.addMouseListener(mouseAdapter);

		collapseButton = new JButton(collapseAction);
		collapseButton.setContentAreaFilled(false);
		collapseButton.setFocusable(false);
		collapseButton.setBackground(H_BUTTON_BGC);
		collapseButton.setOpaque(true);
		collapseButton.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.GRAY));
		collapseButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		collapseButton.setEnabled(false);
		collapseButton.addMouseListener(mouseAdapter);

		contextMenu = new TreeTableContextMenu(this);
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void init() {
		init((TreeTableNode) null);
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void init(List<? extends TreeTableNode> nodes) {
		tree.init(nodes == null ? new ArrayList<TreeTableNode>() : nodes);
		postUpdate(nodes == null ? 0 : nodes.size(), columnNames.length);
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void init(TreeTableNode root) {
		tree.init(root);
		postUpdate(root == null || !root.hasChild() ? 0 : root.myChildren.size(), columnNames.length);
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void update(List<? extends TreeTableNode> nodes) {
		tree.update(nodes == null ? new ArrayList<TreeTableNode>() : nodes);
		postUpdate(nodes.size(), columnNames.length);
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void update(TreeTableNode root, boolean setRoot) {
		tree.update(root, setRoot);
		postUpdate(root == null ? 0 : root.hasChild() ? root.myChildren.size() : 0, columnNames.length);
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void update(TreeTableNode root) {
		update(root, true);
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	private void postUpdate(int rows, int cols) {
		if (rows > 0 && cellAttributs != null) {
			cellAttributs.setSize(new Dimension(rows, cols));
		}
		reload();
		tableUpdated();
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void clear() {
		tree.clear();
		reload();
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void reload() {
		sortingDirection = SORTDIR_NO;
		sortingColumn = -1;
		expandingLevel = 1;
		filterData.clear();

		updateExpandCollapseButtons();

		tree.reload();

		revalidate();
		getTableHeader().repaint();
		repaint();
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void setSelectionMode(int mode) {

		super.setSelectionMode(mode);

		switch (mode) {

			case ListSelectionModel.SINGLE_SELECTION :
				tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
				break;

			case ListSelectionModel.SINGLE_INTERVAL_SELECTION :
				tree.getSelectionModel().setSelectionMode(TreeSelectionModel.CONTIGUOUS_TREE_SELECTION);
				break;

			case ListSelectionModel.MULTIPLE_INTERVAL_SELECTION :
				tree.getSelectionModel().setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
				break;
		}
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public TableCellRenderer getCellRenderer(int row, int column) {
		return renderer;
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public TableCellEditor getCellEditor(int row, int column) {
		return editor;
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public int getEditingRow() {
		return (getColumnClass(editingColumn) == TreeTableTree.class) ? -1 : editingRow;
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @exception
	 *
	 * @see
	 */
	public boolean isColumnVisible(int column) {
		return viewColumns.contains(columnNames[column]);
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void setShowCheckBox(boolean show) {
		tree.setShowCheckBox(show);
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void setShowAlternateColor(boolean show) {
		this.showAlternateColor = show;
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void setShowRollover(boolean show) {
		this.showRollover = show;
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void setShowHeaderMenu(boolean show) {
		this.showHeaderMenu = show;
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void setShowExCoButtons(boolean show) {
		this.showExCoButtons = show;
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void setShowPopupMenu(boolean show) {
		this.showPopupMenu = show;
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void setShowDetailsPopup(boolean show) {
		this.showDetailsPopup = show;
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void setShowGroupSelection(boolean showGroupSelection) {
		this.showGroupSelection = showGroupSelection;
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void setShowPartSelection(boolean showPartSelection) {
		this.showPartSelection = showPartSelection;
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void setColumnsConfigurable(boolean columnsConfigurable) {
		this.columnsConfigurable = columnsConfigurable;
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void setFilterByUser(boolean filterByUser) {
		this.filterByUser = filterByUser;
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public TreeTableContextMenu getContextMenu() {
		return contextMenu;
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public TreeTableNode getSelectedNode() {
		return getNodeAtRow(getSelectedRow());
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public TreeTableNode[] getSelectedNodes() {
		TreeTableNode[] nodes = new TreeTableNode[0];
		int[] sels = getSelectedRows();
		if (sels != null && sels.length > 0) {
			nodes = new TreeTableNode[sels.length];
			for (int i = 0; i < sels.length; i++) {
				nodes[i] = tree.getNodeAtRow(sels[i]);
			}
		}
		return nodes;
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void selectNodes(List<TreeTableNode> selections) {
		tree.select(selections);
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public TreePath[] getSelectedPaths() {
		TreeTableNode[] nodes = getSelectedNodes();
		if (nodes != null && nodes.length > 0) {
			TreePath[] paths = new TreePath[nodes.length];
			for (int i = 0; i < nodes.length; i++) {
				paths[i] = new TreePath(nodes[i].getPath());
			}
			return paths;
		}
		return null;
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void selectRows(int[] rows) {
		clearSelection();
		if (rows != null) {
			for (int row : rows) {
				addRowSelectionInterval(row, row);
			}
		}
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void selectRows(List<Integer> rows) {
		clearSelection();
		if (rows != null) {
			for (int row : rows) {
				addRowSelectionInterval(row, row);
			}
		}
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public TreeTableNode getNodeAtRow(int row) {
		return tree.getNodeAtRow(row);
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public TreeTableNode getNodeByKey(String key) {
		return tree.getNodeByKey(key);
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public TreeTableNode getNodeByName(String name) {
		return getNodeByName(name, true);
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public TreeTableNode getNodeByName(String name, boolean caseSensitive) {
		return tree.getNodeByName(name, caseSensitive);
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public List<TreeTableNode> getNodes() {
		return tree.getNodes();
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public int getNodesCount() {
		return tree.getNodesCount();
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void deleteNode(TreeTableNode node) {
		tree.deleteNode(node);
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void checkAll(boolean check) {
		tree.checkAll(check);
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void check(TreeTableNode node, boolean check) {
		if (check) {
			check(node);
		} else {
			uncheck(node);
		}
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void check(TreeTableNode node) {
		TreeTableNode no = getNodeByKey(node.getNodeKey());
		if (no != null) {
			tree.check(no);
		}
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void uncheck(TreeTableNode node) {
		TreeTableNode no = getNodeByKey(node.getNodeKey());
		if (no != null) {
			tree.uncheck(no);
		}
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public boolean isChecked(TreeTableNode node) {
		TreeTableNode no = getNodeByKey(node.getNodeKey());
		return no == null ? false : no.isChecked();
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void check(TreeTableNode[] nodes) {
		List<TreeNode> newNodes = new ArrayList<TreeNode>();
		for (TreeTableNode node : nodes) {
			TreeTableNode no = getNodeByKey(node.getNodeKey());
			if (no != null) {
				newNodes.add(no);
			}
		}
		tree.check(newNodes);
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void check(List<TreeTableNode> nodes) {
		List<TreeNode> newNodes = new ArrayList<TreeNode>();
		for (TreeTableNode node : nodes) {
			TreeTableNode no = getNodeByKey(node.getNodeKey());
			if (no != null) {
				newNodes.add(no);
			}
		}
		tree.check(newNodes);
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public List<TreeTableNode> getCheckedNodes() {
		List<TreeNode> nodes = tree.getAllChecked();
		List<TreeTableNode> newNodes = new ArrayList<TreeTableNode>();
		for (TreeNode node : nodes) {
			newNodes.add((TreeTableNode) node);
		}
		return newNodes;
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public List<TreeTableNode> getCheckedLeavs() {
		List<TreeNode> nodes = tree.getCheckedItems();
		List<TreeTableNode> newNodes = new ArrayList<TreeTableNode>();
		for (TreeNode node : nodes) {
			newNodes.add((TreeTableNode) node);
		}
		return newNodes;
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public int getCheckedCount() {
		return tree.getCheckedCount();
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public TreeTableTree getTree() {
		return tree;
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public TreeTableNode getRoot() {
		return tree.root;
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public TreeTableModel getTreeTableModel() {
		return (TreeTableModel) getModel();
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public int getDepth() {
		return tree.getDepth();
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void expandNode(TreeTableNode node) {
		expandingLevel = Math.max(node.getDepth() + 1, expandingLevel);
		tree.expandNode(node);
		revalidate();
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void collapseNode(TreeTableNode node) {
		expandingLevel = Math.min(node.getDepth(), expandingLevel);
		tree.collapseNode(node);
		revalidate();
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void expandToLevel(int level) {
		if (level <= tree.getDepth()) {
			expandingLevel = level;
			tree.expandToLevel(level);
			revalidate();
		}
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void collapseToLevel(int level) {
		if (level >= 1) {
			expandingLevel = level;
			tree.collapseToLevel(level);
			revalidate();
		}
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	private void updateExpandCollapseButtons() {
		expandButton.setEnabled(tree.getRowCount() > 0 && expandingLevel < tree.getDepth());
		collapseButton.setEnabled(tree.getRowCount() > 0 && expandingLevel > 1);
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	@Override
	public void treeExpanded(TreeExpansionEvent event) {
		updateExpandCollapseButtons();
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	@Override
	public void treeCollapsed(TreeExpansionEvent event) {
		updateExpandCollapseButtons();
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void sort(int columnIndex, int direction) {
		if (tree.getRowCount() != 0) {
			sortingColumn = columnIndex;
			sortingDirection = direction;
			tree.sort(getComparator(sortingColumn), sortingColumn, sortingDirection);
			scrollSelectionToVisible();
		}
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void setComparators(
		Map<Class<Object>, Comparator<Object>> defaultComparators,
		Map<Integer, Comparator<Object>>	   columnComparators
	) {
		this.defaultComparators.putAll(defaultComparators);
		this.columnComparators.putAll(columnComparators);
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	private Comparator<Object> getComparator(int columnIndex) {
		Comparator<Object> comparator = columnComparators.get(columnIndex);
		if (comparator == null) {
			Class<?> cl = getModel().getColumnClass(columnIndex);
			comparator = defaultComparators.get(cl);
			if (comparator == null && cl != null) {
				comparator = defaultComparators.get(cl.getSuperclass());
			}
			if (comparator == null) {
				comparator = new TreeTableComprator<Object>();
			}
		}
		return comparator;
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	protected void filter(Map<Integer, FilterData> filterData) {
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	private void filter() {

		tree.prepareData();

		expandingLevel = 1;

		updateExpandCollapseButtons();
		revalidate();
		getTableHeader().repaint();
		repaint();
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	private void scrollSelectionToVisible() {
		int row = getSelectedRow();
		int column = 0; //getSelectedColumn();
		if (row >= 0 && column >= 0) {
			scrollRectToVisible(getCellRect(row, column, true));
		}

		getTableHeader().repaint();
		repaint();
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void combineCells(int[] rows, int[] columns) {
		if (cellAttributs != null) {
			cellAttributs.combine(rows, columns);
		}
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void splitCells(int row, int column) {
		if (cellAttributs != null) {
			cellAttributs.split(row, column);
		}
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void setRowHeight(int rowHeight) {
		super.setRowHeight(rowHeight);
		if (tree != null) {
			tree.setRowHeight(rowHeight);
		}
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public boolean doubleClickAllowed() {
		int r = getSelectedRow();
		int c = getSelectedColumn();
		return r != -1 && getColumnClass(c) != TreeTableTree.class;
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public int search(String text) {
		return search(text, true);
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public int search(String text, boolean caseSensitive) {
		return searchNodes(text, caseSensitive).size();
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public List<TreeTableNode> searchNodes(String text, boolean caseSensitive) {
		List<TreeTableNode> rows = new ArrayList<>();
		if (text != null && !text.isEmpty()) {
			tree.search(text, rows, caseSensitive);
			tree.select(rows);
			scrollSelectionToVisible();
		}
		return rows;
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void addTreeTableListener(TreeTableListener listener) {
		treeTablelisteners.add(listener);
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void removeTreeTableListener(TreeTableListener listener) {
		treeTablelisteners.remove(listener);
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void tableUpdated() {
		for (TreeTableListener ls : treeTablelisteners) {
			ls.tableUpdated();
		}
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void nodesSelected(TreeTableNode[] nodes) {
		for (TreeTableListener ls : treeTablelisteners) {
			ls.nodesSelected(nodes);
		}
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void nodesDeselected() {
		for (TreeTableListener ls : treeTablelisteners) {
			ls.nodesDeselected();
		}
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void nodeActionPerformed(String name, Object args, Component comp) {
		for (TreeTableListener ls : treeTablelisteners) {
			ls.nodeActionPerformed(name, args, comp);
		}
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void nodeCheckChanged(TreeTableNode node) {
		if (node != null) {
			for (TreeTableListener ls : treeTablelisteners) {
				ls.nodeCheckChanged(node);
			}
		}
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	private void nodeChecked(TreeTableNode node, int checkState) {
		if (node != null) {
			node.setCheckState(checkState);
			nodeCheckChanged(node);
			revalidate();
			repaint();
		}
	}

	/**
	 * @param
	 *
	 * @return
	 *
	 * @exception
	 *
	 * @see
	 */
	protected void repaintRow(int row) {
		if (row != -1) {
			int modelRow = convertRowIndexToModel(row);
			((TreeTableModel) getModel()).fireTableRowsUpdated(modelRow, modelRow);
		}
	}

	//=====================================================================
	// TreeTableListener
	//=====================================================================

	public interface TreeTableListener {
		void tableUpdated();

		void nodesSelected(TreeTableNode[] nodes);

		void nodesDeselected();

		void nodeActionPerformed(String name, Object args, Component comp);

		void nodeCheckChanged(TreeTableNode node);
	}

	public static class DefaultTreeTableListener implements TreeTableListener {
		@Override
		public void tableUpdated() {
		}

		@Override
		public void nodesSelected(TreeTableNode[] nodes) {
		}

		@Override
		public void nodesDeselected() {
		}

		@Override
		public void nodeActionPerformed(String name, Object args, Component comp) {
		}

		@Override
		public void nodeCheckChanged(TreeTableNode node) {
		}
	}

	//=====================================================================
	// TreeTableComprator
	//=====================================================================

	private class TreeTableComprator<T> implements Comparator<T> {
		public int compare(T o1, T o2) {
			if (o1 == null && o2 == null) {
				return 0;
			}
			if (o1 == null && o2 != null) {
				return -1;
			}
			if (o1 != null && o2 == null) {
				return 1;
			}
			return o1.toString().compareTo(o2.toString());
		}

		public boolean equals(Object obj) {
			return obj == null ? false : toString().equals(obj.toString());
		}
	}

	//=====================================================================
	// TreeTableModel
	//=====================================================================

	public class TreeTableModel extends AbstractTableModel {

		private static final long serialVersionUID = 1L;

		private Map<Class<?>, RendererComponent> typeToRenderer;
		private Map<Object, RendererComponent> nameToRenderer;

		private Map<Class<?>, EditorComponent> typeToEditor;
		private Map<Object, EditorComponent> nameToEditor;

		public TreeTableModel() {

			typeToRenderer = new HashMap<Class<?>, RendererComponent>();
			nameToRenderer = new HashMap<Object, RendererComponent>();

			typeToEditor = new HashMap<Class<?>, EditorComponent>();
			nameToEditor = new HashMap<Object, EditorComponent>();

			registerDefaultRenderers();
			registerDefaultEditors();
		}

		/**
		 * @param
		 *
		 * @return
		 *
		 * @exception
		 *
		 * @see
		 */
		private int translateColumn(int column) {
			return columnsMap.get(viewColumns.get(column));
		}

		/**
		 * @param
		 *
		 * @return
		 *
		 * @exception
		 *
		 * @see
		 */
		@Override
		public int getColumnCount() {
			return viewColumns.size();
		}

		/**
		 * @param
		 *
		 * @return
		 *
		 * @exception
		 *
		 * @see
		 */
		@Override
		public int getRowCount() {
			return tree.getRowCount();
		}

		/**
		 * @param
		 *
		 * @return
		 *
		 * @exception
		 *
		 * @see
		 */
		@Override
		public String getColumnName(int column) {
			return viewColumns.get(column);
		}

		/**
		 * @param
		 *
		 * @return
		 *
		 * @exception
		 *
		 * @see
		 */
		@Override
		public Class<? extends Object> getColumnClass(int column) {
			if (column == 0) {
				return tree.getClass();
			}
			Object v = getValueAt(0, column);
			return v == null ? null : v.getClass();
		}

		/**
		 * @param
		 *
		 * @return
		 *
		 * @exception
		 *
		 * @see
		 */
		@Override
		public Object getValueAt(int row, int column) {
			TreeTableNode node = tree.getNodeAtRow(row);
			return node == null ? null : node.getValue(translateColumn(column));
		}

		/**
		 * @param
		 *
		 * @return
		 *
		 * @exception
		 *
		 * @see
		 */
		@Override
		public void setValueAt(Object value, int row, int column) {
			TreeTableNode node = tree.getNodeAtRow(row);
			if (node != null) {
				column = translateColumn(column);
				Object oldValue = node.getValue(column);
				node.setValue(column, value);
				node.editorValueChanged(oldValue, value);
			}
		}

		/**
		 * @param
		 *
		 * @return
		 *
		 * @exception
		 *
		 * @see
		 */
		@Override
		public boolean isCellEditable(int row, int column) {
			if (column == 0) {
				return true;
			}
			TreeTableNode node = tree.getNodeAtRow(row);
			return node.isEditable(row, translateColumn(column));
		}

		/**
		 * @param
		 *
		 * @return
		 *
		 * @exception
		 *
		 * @see
		 */
		public boolean isCellEnabled(int row, int column) {
			if (column == 0) {
				return true;
			}
			TreeTableNode node = tree.getNodeAtRow(row);
			return node.isEnabled(row, translateColumn(column));
		}

		/**
		 * @param
		 *
		 * @return
		 *
		 * @exception
		 *
		 * @see
		 */
		private RendererComponent getRendererAt(TreeTableNode node, int row, int column) {
			column = translateColumn(column);
			RendererComponent renderer = node.getRenderer(row, column);
			if (renderer == null) {
				renderer = getRenderer(node.getNodeKey());
				if (renderer == null) {
					renderer = getRenderer(node.getType(row, column));
					if (renderer == null) {
						renderer = getRenderer(Object.class);
						if (renderer == null && node.isEditable(row, column)) {
							renderer = getEditorAt(node, row, column);
						}
					}
				}
			}
			return renderer;
		}

		/**
		 * @param
		 *
		 * @return
		 *
		 * @exception
		 *
		 * @see
		 */
		private EditorComponent getEditorAt(TreeTableNode node, int row, int column) {
			column = translateColumn(column);
			EditorComponent editor = node.getEditor(row, column);
			if (editor != null) {
				editor = node.getEditorInstance(editor);
			} else {
				editor = getEditor(node.getNodeKey());
				if (editor == null) {
					editor = getEditor(node.getType(row, column));
					if (editor == null) {
						editor = getEditor(Object.class);
					}
				}
			}
			return editor;
		}

		public void registerRenderer(Class<?> type, RendererComponent renderer) {
			typeToRenderer.put(type, renderer);
		}

		public void registerRenderer(Object key, RendererComponent renderer) {
			nameToRenderer.put(key, renderer);
		}

		public void registerEditor(Class<?> type, EditorComponent editor) {
			typeToEditor.put(type, editor);
		}

		public void registerEditor(Object key, EditorComponent editor) {
			nameToEditor.put(key, editor);
		}

		public synchronized void registerEditor(Class<?> type, Class<?> editorClass) {
			try {
				registerEditor(type, (EditorComponent) editorClass.newInstance());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public synchronized void registerEditor(Object key, Class<?> editorClass) {
			try {
				registerEditor(key, (EditorComponent) editorClass.newInstance());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public void unregisterRenderer(Class<?> type) {
			typeToRenderer.remove(type);
		}

		public void unregisterRenderer(Object key) {
			nameToRenderer.remove(key);
		}

		public void unregisterEditor(Class<?> type) {
			typeToEditor.remove(type);
		}

		public void unregisterEditor(Object key) {
			nameToEditor.remove(key);
		}

		public RendererComponent getRenderer(Class<?> type) {
			return typeToRenderer.get(type);
		}

		public RendererComponent getRenderer(Object key) {
			return nameToRenderer.get(key);
		}

		public EditorComponent getEditor(Class<?> type) {
			return typeToEditor.get(type);
		}

		public EditorComponent getEditor(Object key) {
			return nameToEditor.get(key);
		}

		private void registerDefaultRenderers() {
			unregisterDefaultRenderers();
		}

		private void registerDefaultEditors() {
			unregisterDefaultEditors();
			registerEditor(String.class, TextEditorComponent.class);
			registerEditor(boolean.class, BooleanEditorComponent.class);
			registerEditor(Boolean.class, BooleanEditorComponent.class);
			registerEditor(short.class, NumberEditorComponent.ShortEditorComponent.class);
			registerEditor(Short.class, NumberEditorComponent.ShortEditorComponent.class);
			registerEditor(int.class, NumberEditorComponent.IntegerEditorComponent.class);
			registerEditor(Integer.class, NumberEditorComponent.IntegerEditorComponent.class);
			registerEditor(long.class, NumberEditorComponent.LongEditorComponent.class);
			registerEditor(Long.class, NumberEditorComponent.LongEditorComponent.class);
			registerEditor(double.class, NumberEditorComponent.DoubleEditorComponent.class);
			registerEditor(Double.class, NumberEditorComponent.DoubleEditorComponent.class);
			registerEditor(float.class, NumberEditorComponent.FloatEditorComponent.class);
			registerEditor(Float.class, NumberEditorComponent.FloatEditorComponent.class);
		}

		public void unregisterDefaultRenderers() {
			typeToRenderer.clear();
			nameToRenderer.clear();
		}

		public void unregisterDefaultEditors() {
			typeToEditor.clear();
			nameToEditor.clear();
		}
	}

	//=====================================================================
	// TreeTableCellRenderer
	//=====================================================================

	public class TreeTableCellRenderer extends DefaultTableCellRenderer {

		private static final long serialVersionUID = 1L;

		@Override
		public Component getTableCellRendererComponent(
			JTable  table,
			Object  value,
			boolean isSelected,
			boolean hasFocus,
			int		row,
			int		column
		) {
			setValue(value);

			TreeTableNode node = tree.getNodeAtRow(row);

			Color fg = node.getForegroundColor(row, column);
			Color bg = node.getBackgroundColor(row, column);
			
			if (fg == null) fg = table.getForeground();
			if (bg == null) bg = table.getBackground();

			if (isSelected) {
				fg = table.getSelectionForeground();
				bg = table.getSelectionBackground();

			} else {
				Color c1 =
					showRollover && bodyRolloverIndex == row ? ROLLOVER_COLOR
					: node == null ? showAlternateColor ? bg : TT_COLOR1
					: !showAlternateColor ? node.getBackgroundColor(row, column)
					: node.selected && showGroupSelection ? TT_COLOR3
					: showPartSelection ? node.getBackgroundColor(row, column) : TT_COLOR1;
				Color c2 =
					showRollover && bodyRolloverIndex == row ? ROLLOVER_COLOR
					: !showAlternateColor ? node.getBackgroundColor(row, column)
					: node == null ? showAlternateColor ? bg : TT_COLOR2
					: !showAlternateColor ? node.getBackgroundColor(row, column)
					: node.selected && showGroupSelection ? TT_COLOR4
					: showPartSelection ? node.getBackgroundColor(row, column) : TT_COLOR2;

				bg = row % 2 == 0 ? c1 : c2;
			}

			// Rendering tree column
			if (table.getColumnClass(column) == TreeTableTree.class) {
				tree.paintingRow = row;
				tree.setForeground(fg);
				tree.setBackground(bg);
				return tree;
			}

			int col = convertColumnIndexToModel(column);
			TreeTableModel model = (TreeTableModel) table.getModel();

			// Rendering via renderer if any exists
			RendererComponent renderer = model.getRendererAt(node, row, col);
			if (renderer != null) {
				return
					renderer.getRendererComponent(
						table,
						value,
						isSelected, //
						model.isCellEnabled(row, column),
						fg,
						bg
					);
			}

			// Rendering via editor if any exists
			EditorComponent editor = model.getEditorAt(node, row, col);
			if (editor != null && node.isEditable(row, col)) {
				return
					editor.getRendererComponent(
						table,
						value,
						isSelected, //
						model.isCellEnabled(row, column),
						fg,
						bg
					);

			}

			String tooltip = null;
			if (value != null) {
				String vs = value.toString();
				if (!vs.isEmpty()) {
					StringBuffer sb = new StringBuffer();
					createToolTip(vs, sb);
					String tt = sb.toString();
					if (!tt.isEmpty()) {
						tooltip = "<html>" + tt + "</html>";
						setToolTipText(tooltip);
					}
				}
			}

			// Rest of columns
			Font fo = node.getFont(row, column);
			setForeground(fg);
			setBackground(bg);
			setFont(fo == null ? TT_FONT1 : fo);
			setHorizontalAlignment(node.getHorizontalAlignment(row, column));
			setVerticalAlignment(node.getVerticalAlignment(row, column));

			if (!isSelected && node != null && node.hasChild() && node.selected && node.myLevel == 1) {
				setFont(TT_FONT2);
			}

			return this;
		}

		private void createToolTip(String s, StringBuffer sb) {
			int n = Math.min(s.length(), 60);
			sb.append(s.substring(0, n) + "<br>");
			if (n == 60) {
				createToolTip(s.substring(n), sb);
			}
		}
	}

	//=====================================================================
	// TreeTableCellEditor
	//=====================================================================

	public class TreeTableCellEditor implements TableCellEditor {

		private JTreeTableX treetable;
		private EditorComponent editor;
		private ChangeEvent changeEvent;

		public TreeTableCellEditor(JTreeTableX treetable) {
			this.treetable = treetable;
			this.changeEvent = new ChangeEvent(this);
		}

		@Override
		public Component getTableCellEditorComponent(
			JTable  table,
			Object  value,
			boolean isSelected,
			int		row,
			int		column
		) {
			if (getColumnClass(column) == TreeTableTree.class) {
				return tree;
			}

			TreeTableNode node = tree.getNodeAtRow(row);
			TreeTableModel model = (TreeTableModel) table.getModel();
			editor = model.getEditorAt(node, row, convertColumnIndexToModel(column));
			if (editor != null) {
				editor.setEditorValue(value);
				editor.setEditorListener(this);
				editor.getRendererComponent(
					table,
					value,
					isSelected, //
					model.isCellEnabled(row, column),
					table.getSelectionForeground(),
					table.getSelectionBackground()
				);
				return editor.getEditorComponent();
			}
			return null;
		}

		@Override
		public boolean isCellEditable(EventObject e) {

			if (e instanceof MouseEvent) {

				MouseEvent me = (MouseEvent) e;

				for (int i = 0; i < getColumnCount(); i++) {
					if (getColumnClass(i) == TreeTableTree.class) {
						Rectangle rect = getCellRect(0, i, true);
						if (me.getX() >= rect.x && me.getX() <= (rect.x + rect.width)) {

							// forward event to the tree
							tree.dispatchEvent(
								new MouseEvent(
									(Component) me.getSource(), // tree
									me.getID(),
									me.getWhen(),
									me.getModifiers(),
									me.getX() - rect.x,
									me.getY() - rect.y,
									me.getClickCount(),
									me.isPopupTrigger()
								)
							);

							// mark table as changed
							treetable.revalidate();
							return false;
						}
					}
				}
			}
			return true; // return true if keyboard event
		}

		@Override
		public Object getCellEditorValue() {
			return editor == null ? null : editor.getEditorValue();
		}

		@Override
		public boolean shouldSelectCell(EventObject evt) {
			return true;
		}

		@Override
		public boolean stopCellEditing() {
			fireEditingStopped();
			return true;
		}

		@Override
		public void cancelCellEditing() {
			fireEditingCanceled();
		}

		@Override
		public void addCellEditorListener(CellEditorListener l) {
		}

		@Override
		public void removeCellEditorListener(CellEditorListener l) {
		}

		private void fireEditingStopped() {
			treetable.editingStopped(changeEvent);
		}

		private void fireEditingCanceled() {
			treetable.editingCanceled(changeEvent);
		}
	}

	//=====================================================================
	// TreeTableTreeCellRenderer
	//=====================================================================

	public class TreeTableTreeCellRenderer extends DefaultTreeCellRenderer {

		private static final long serialVersionUID = 1L;

		@Override
		public Component getTreeCellRendererComponent(
			JTree   tree,
			Object  value,
			boolean selected,
			boolean expanded,
			boolean leaf,
			int		row,
			boolean hasFocus
		) {
			super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);

			Font font = null;
			TreeTableNode node = ((TreeTableTree) tree).getNodeAtRow(row);
			if (node != null) {
				setText(node.getNodeName());
				setIcon(tree, value, leaf, node.getIcon());

				font = node.getFont(row, 0);

				Color fg = node.getForegroundColor(row, 0);
				Color bg = node.getBackgroundColor(row, 0);		
				
				if (fg == null) fg = ((TreeTableTree) tree).getForeground();
				if (bg == null) bg = ((TreeTableTree) tree).getBackground();

				setForeground(fg);
				setBackground(bg);
			}

			setFont(font == null ? TT_FONT1 : font);

			if (selected) {
				setTextSelectionColor(getSelectionForeground());
				setBackgroundSelectionColor(getSelectionBackground());
				setForeground(getSelectionForeground());
				setBackground(getSelectionBackground());
			} else {
				Color c1 =
					showRollover && bodyRolloverIndex == row ? ROLLOVER_COLOR
					: node == null ? showAlternateColor ? getBackground() : TT_COLOR1
					: !showAlternateColor ? node.getBackgroundColor(0, 0)
					: node.selected && showGroupSelection ? TT_COLOR3
					: showPartSelection ? node.getBackgroundColor(0, 0) : TT_COLOR1;
				Color c2 =
					showRollover && bodyRolloverIndex == row ? ROLLOVER_COLOR
					: node == null ? showAlternateColor ? getBackground() : TT_COLOR2
					: !showAlternateColor ? node.getBackgroundColor(0, 0)
					: node.selected && showGroupSelection ? TT_COLOR4
					: showPartSelection ? node.getBackgroundColor(0, 0) : TT_COLOR2;

				setBackgroundNonSelectionColor(row % 2 == 0 ? c1 : c2);

				if (!selected && node != null && node.hasChild() && node.selected && node.myLevel == 1) {
					setFont(TT_FONT2);
				}
			}

			// Bug of JTree
			setPreferredSize(new Dimension(800, tree.getRowHeight()));

			return this;
		}

		protected void setIcon(JTree tree, Object value, boolean leaf, Icon icon) {
			super.setIcon(((TreeTableTree) tree).createDoubleIcon(value, leaf, icon));
		}
	}

	//=====================================================================
	// TreeTableHeaderRenderer
	//=====================================================================

	private class TreeTableHeaderRenderer extends JLabel implements TableCellRenderer {

		private static final long serialVersionUID = 1L;

		private int modelIndex;

		public TreeTableHeaderRenderer(int modelIndex) {
			this.modelIndex = modelIndex;
		}

		@Override
		public Component getTableCellRendererComponent(
			JTable  table,
			Object  value,
			boolean isSelected,
			boolean hasFocus,
			int		row,
			int		column
		) {
			String tx = value.toString();
			if (tx.indexOf("<br>") != -1) {
				tx = "<html>" + tx + "</html>";
			}

			TableCellRenderer r = getTableHeader().getDefaultRenderer();
			JLabel lb = (JLabel) r.getTableCellRendererComponent(table, tx, isSelected, hasFocus, row, column);
			lb.removeAll();

			int mci = convertColumnIndexToModel(column);

			int w = getColumnModel().getColumn(mci).getWidth();
			int h = getTableHeader().getHeight();
			int p = 0;
			int bw = H_BUTTON_WIDTH;

			if (headerRolloverIndex == mci) {
				if (showHeaderMenu) {

					p = bw;

					headerMenuButton.setBounds(w - bw, 0, bw, h - 2);

					if (showExCoButtons && mci == 0) {

						p += 2 * bw;

						expandButton.setBounds(w - 2 * bw, 0, bw, h - 2);
						collapseButton.setBounds(w - 3 * bw, 0, bw, h - 2);
						lb.add(expandButton);
						lb.add(collapseButton);
					}

					lb.add(headerMenuButton);

				} else if (showExCoButtons && mci == 0) {

					p += 2 * bw;

					expandButton.setBounds(w - bw, 0, bw, h - 2);
					collapseButton.setBounds(w - 2 * bw, 0, bw, h - 2);
					lb.add(expandButton);
					lb.add(collapseButton);
				}
			} else if (menuIndex == mci) {

				p += bw;
				JLabel l = new JLabel(TT_MEH_ICON);
				l.setBounds(w - p, 0, bw, h - 2);
				lb.add(l);
			}

			if (filterData.containsKey(modelIndex)) {
				p += bw;
				JLabel l = new JLabel(TT_FLT_ICON);
				l.setBounds(w - p, 0, bw, h - 2);
				lb.add(l);
			}

			if (sortingColumn == modelIndex) {
				p += bw;
				ImageIcon icon = null;
				if (sortingDirection == SORTDIR_ASCENDING) {
					icon = isFlatTable ? TT_ASC_NOHE : TT_ASC_ICON;
				} else if (sortingDirection == SORTDIR_DESCENDING) {
					icon = isFlatTable ? TT_DES_NOHE : TT_DES_ICON;
				}
				JLabel l = new JLabel(icon);
				l.setBounds(w - p, 0, bw, h - 2);
				lb.add(l);
			}

			Border outside = lb.getBorder();
			Border inside = BorderFactory.createEmptyBorder(0, 0, 0, p);
			lb.setBorder(BorderFactory.createCompoundBorder(outside, inside));

			return lb;
		}
	}

	//=====================================================================
	// TreeTableHeaderListener
	//=====================================================================

	private class TreeTableHeaderListener extends MouseAdapter implements TableColumnModelListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			if ((e.getClickCount() == 1) && (e.getModifiers() == InputEvent.BUTTON1_MASK)) {

				int column = getColumnModel().getColumnIndexAtX(e.getX());
				int columnIndex = convertColumnIndexToModel(column);

				Rectangle r = getTableHeader().getHeaderRect(column);

				int x = e.getX() - r.x;

				r.setBounds(r.x + r.width - H_BUTTON_WIDTH, r.y, H_BUTTON_WIDTH, r.height);

				if (showHeaderMenu && headerMenuButton.getBounds().contains(x, e.getY())) {

					openHeaderMenu(e.getComponent(), r.x, r.height, columnIndex);

					headerMenuButton.doClick();
					e.consume();
					return;
				}

				if (showExCoButtons && columnIndex == 0) {
					if (expandButton.getBounds().contains(x, e.getY())) {
						expandButton.doClick();
						e.consume();
						return;
					} else if (collapseButton.getBounds().contains(x, e.getY())) {
						collapseButton.doClick();
						e.consume();
						return;
					}
				}

				int sd = sortingDirection;
				if (sortingColumn != -1 && sortingColumn != columnIndex) {
					sd = SORTDIR_NO;
				}
				sd = sd == SORTDIR_NO ? SORTDIR_ASCENDING : sd == SORTDIR_ASCENDING ? SORTDIR_DESCENDING : SORTDIR_NO;

				sort(columnIndex, sd);
				e.consume();
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			headerRolloverIndex = convertColumnIndexToModel(getColumnModel().getColumnIndexAtX(e.getX()));
		}

		@Override
		public void mouseExited(MouseEvent e) {
			headerRolloverIndex = -1;
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			headerRolloverIndex = convertColumnIndexToModel(getColumnModel().getColumnIndexAtX(e.getX()));
		}

		@Override
		public void columnAdded(TableColumnModelEvent e) {
			TableColumn column = ((TableColumnModel) e.getSource()).getColumn(e.getToIndex());
			column.setHeaderRenderer(new TreeTableHeaderRenderer(column.getModelIndex()));
		}

		@Override
		public void columnRemoved(TableColumnModelEvent e) {
		}

		@Override
		public void columnMoved(TableColumnModelEvent e) {
		}

		@Override
		public void columnMarginChanged(ChangeEvent e) {
		}

		@Override
		public void columnSelectionChanged(ListSelectionEvent e) {
		}
	}

	//=====================================================================
	// TreeTableMouseListener
	//=====================================================================

	private class TreeTableMouseListener extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			if (e.isControlDown()) {
				clearSelection();
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if (bodyRolloverIndex != -1) {
				repaintRow(bodyRolloverIndex);
				bodyRolloverIndex = -1;
			}
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			int row = rowAtPoint(e.getPoint());
			if (row != bodyRolloverIndex) {
				repaintRow(bodyRolloverIndex);
				bodyRolloverIndex = row;
				repaintRow(bodyRolloverIndex);
			}
		}

		@Override
		public void mouseWheelMoved(MouseWheelEvent e) {
			if (bodyRolloverIndex != -1) {
				repaintRow(bodyRolloverIndex);
				bodyRolloverIndex = -1;
			}
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			if (showPopupMenu && e.isPopupTrigger()) {
				int row = rowAtPoint(e.getPoint());
				if (row != -1) {
					TreeTableNode[] sels = getSelectedNodes();
					if (sels.length <= 1) {
						setRowSelectionInterval(row, row);
					}
					contextMenu.show(row, e);
				}
			}
		}
	}

	//=====================================================================
	// TreeTableKeyListener
	//=====================================================================

	private class TreeTableKeyListener implements KeyListener {
		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
			int row = getSelectedRow();
			if (row != -1) {
				int kc = e.getKeyCode();
				if (kc == KeyEvent.VK_PLUS || kc == KeyEvent.VK_SPACE) {
					e.consume();
					tree.expandRow(row);
					setRowSelectionInterval(row, row);
					revalidate();
				} else if (kc == KeyEvent.VK_MINUS || kc == KeyEvent.VK_BACK_SPACE) {
					e.consume();
					tree.collapseRow(row);
					setRowSelectionInterval(row, row);
					revalidate();
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}
	}

	//=====================================================================
	// Headermenu popup
	//=====================================================================

	/**
	 * @param  node
	 * @param  column
	 * @param  filters
	 */
	private void getFilterNodes(TreeTableNode node, int column, List<String> filters) {
		Object key = node.getValue(column);
		if (key != null) {
			if (!filters.contains(key.toString())) {
				filters.add(key.toString());
			}
		}
		if (node.hasChild()) {
			for (TreeTableNode child : node.myChildren) {
				getFilterNodes(child, column, filters);
			}
		}
	}

	/**
	 * @param  comp
	 * @param  x
	 * @param  y
	 * @param  columnIndex
	 */
	private void openHeaderMenu(Component comp, int x, int y, int columnIndex) {

		Color MENU_COLOR = Color.WHITE;

		int MENU_WIDTH = 300;
		int MENU_HEIGHT = 384;

		final JButton btOk = new JButton("Ok");
		final JButton btCancel = new JButton("Abbrechen");

		menuIndex = columnIndex;

		FilterColumnNode top = new FilterColumnNode("top");
		FilterColumnNode all = new FilterColumnNode("Alles ausw‰hlen");

		top.addChild(all);

		List<String> filters = new ArrayList<String>();
		List<TreeTableNode> checkeds = new ArrayList<TreeTableNode>();
		getFilterNodes(filterData.containsKey(columnIndex) ? tree.originRoot : tree.root, columnIndex, filters);
		FilterData fd = filterData.get(columnIndex);

		if (!filters.isEmpty()) {
			if (filters.contains("")) {
				filters.remove("");
				FilterColumnNode node = new FilterColumnNode("Leer");
				all.addChild(node);
				if (fd != null && fd.filterNodes.contains("Leer")) {
					checkeds.add(node);
				}
			}
			for (String filter : filters) {
				if (!filter.isEmpty()) {
					FilterColumnNode node = new FilterColumnNode(filter);
					all.addChild(node);

					if (fd != null && fd.filterNodes.contains(filter)) {
						checkeds.add(node);
					}
				}
			}
		}

		final JTreeTableX table =
			new JTreeTableX(new String[] { "Auswahlliste" }) {
				private static final long serialVersionUID = 1L;

				final JTreeTableX self = this;

				@Override
				public void nodeCheckChanged(TreeTableNode node) {
					btOk.setEnabled(false);
					if (node.equals(all)) {
						if (all.isChecked() || all.isPartChecked()) {
							btOk.setEnabled(true);
						}
					} else if (node.isChecked()) {
						btOk.setEnabled(true);
					} else if (self.getCheckedCount() > 0) {
						btOk.setEnabled(true);
					}
				}
			};

		table.setRowHeight(20);
		table.setShowAlternateColor(false);
		table.setShowHeaderMenu(false);
		table.setShowPopupMenu(false);
		table.setShowExCoButtons(false);
		table.setShowDetailsPopup(false);
		table.setColumnsConfigurable(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.init(top);

		table.expandToLevel(2);

		if (checkeds.isEmpty()) {
			table.check(all, true);
		} else {
			table.check(checkeds);
		}

		final JLabel lb1 = new JLabel(TT_ASC_ICON);
		final JLabel lb2 = new JLabel(TT_DES_ICON);
		final JLabel lb3 = new JLabel(TT_REM_SORT);
		final JLabel lb4 = new JLabel(TT_REM_FILT);
		final JLabel lb5 = new JLabel(TT_SER_ICON);
		final JLabel lb6 = new JLabel(TT_LIS_ICON);

		final JRadioButton rb1 = new JRadioButton("Von A bis Z sortieren");
		final JRadioButton rb2 = new JRadioButton("Von Z bis A sortieren");
		final JRadioButton rb3 = new JRadioButton("Keine Sortierung");

		final ButtonGroup group = new ButtonGroup();
		group.add(rb1);
		group.add(rb2);
		group.add(rb3);

		rb3.setSelected(true);
		rb1.setSelected(sortingColumn == columnIndex && sortingDirection == SORTDIR_ASCENDING);
		rb2.setSelected(sortingColumn == columnIndex && sortingDirection == SORTDIR_DESCENDING);

		rb1.setBackground(MENU_COLOR);
		rb2.setBackground(MENU_COLOR);
		rb3.setBackground(MENU_COLOR);

		rb1.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					sort(columnIndex, SORTDIR_ASCENDING);
				}
			}
		);

		rb2.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					sort(columnIndex, SORTDIR_DESCENDING);
				}
			}
		);

		rb3.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					sort(columnIndex, SORTDIR_NO);
				}
			}
		);

		final JComboBox<String> cbFilters = new JComboBox<String>();
		cbFilters.addItem("");
		cbFilters.addItem("Ist gleich");
		cbFilters.addItem("Ist nicht gleich");
		cbFilters.addItem("Beginnt mit");
		cbFilters.addItem("Endet mit");
		cbFilters.addItem("Enth‰lt");
		cbFilters.addItem("Enth‰lt nicht");
		cbFilters.setSelectedItem(fd != null ? fd.filterType : "");

		final JTextField txt = new JTextField();
		txt.setText(fd != null ? fd.filterText : "");

		final JCheckBox cbDelFilter = new JCheckBox("Filter lˆschen");
		cbDelFilter.setBackground(MENU_COLOR);
		cbDelFilter.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if (cbDelFilter.isSelected()) {
						cbFilters.setSelectedItem("");
						txt.setText("");
						table.check(all, true);
						table.repaint();
					}
				}
			}
		);

		JScrollPane sp = new JScrollPane();
		sp.getViewport().add(table);
		sp.getViewport().setBackground(MENU_COLOR);

		btOk.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {

					filterData.remove(columnIndex);

					if (!cbDelFilter.isSelected()) {

						FilterData fd = new FilterData();

						String ft = (String) cbFilters.getSelectedItem();

						if (!ft.isEmpty() && !txt.getText().isEmpty()) {
							filterData.put(columnIndex, fd);
							fd.filterType = ft;
							fd.filterText = txt.getText();
						}

						if (table.getCheckedCount() > 0 && !table.isChecked(all)) {
							filterData.put(columnIndex, fd);
							List<TreeTableNode> checkeds = table.getCheckedLeavs();
							for (TreeTableNode n : checkeds) {
								if (!n.equals(all)) {
									fd.filterNodes.add(((FilterColumnNode) n).name);
								}
							}
						}
					}

					closeHeaderMenu();

					filter();
				}
			}
		);

		btCancel.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					closeHeaderMenu();
				}
			}
		);

		JPanel panel = new JPanel(null);
		panel.setBackground(MENU_COLOR);

		panel.add(lb1);
		panel.add(lb2);
		panel.add(rb1);
		panel.add(rb2);
		panel.add(lb3);
		panel.add(rb3);
		panel.add(lb4);
		panel.add(cbDelFilter);
		panel.add(lb5);
		panel.add(cbFilters);
		panel.add(txt);
		panel.add(lb6);
		panel.add(sp);
		panel.add(btOk);
		panel.add(btCancel);

		//=== Layouting

		lb1.setBounds(4, 4, 16, 22);
		rb1.setBounds(26, 4, 150, 22);

		lb2.setBounds(4, 28, 16, 22);
		rb2.setBounds(26, 28, 150, 22);

		lb3.setBounds(4, 50, 16, 22);
		rb3.setBounds(26, 50, 150, 22);

		lb4.setBounds(4, 84, 16, 22);
		cbDelFilter.setBounds(28, 84, 150, 22);

		lb5.setBounds(4, 118, 16, 22);
		cbFilters.setBounds(28, 118, 110, 22);
		txt.setBounds(142, 118, 150, 22);

		lb6.setBounds(4, 144, 16, 22);
		sp.setBounds(28, 144, 264, 188);

		btCancel.setBounds(98, 345, 93, 26);
		btOk.setBounds(198, 345, 93, 26);

		panel.setPreferredSize(new Dimension(MENU_WIDTH - 4, MENU_HEIGHT - 4));

		popup =
			new JPopup() {
				@Override
				public void popupClosed() {
					menuIndex = -1;
					getTableHeader().revalidate();
					getTableHeader().repaint();
				}
			};

		popup.open(comp, panel, x, y, MENU_WIDTH, MENU_HEIGHT);
	}

	/**
	 * @param  menu
	 */
	private void closeHeaderMenu() {
		popup.close();
		popup = null;
	}

	/**
	 * @author  P203125
	 */
	private static class FilterColumnNode extends TreeTableNode {
		private static final long serialVersionUID = 1L;
		private String name;

		FilterColumnNode() {
		}

		FilterColumnNode(String name) {
			this();
			this.name = name;
		}

		@Override
		protected TreeTableNode createInstance() {
			return new FilterColumnNode();
		}

		@Override
		public void copy(TreeTableNode node) {
			FilterColumnNode at = (FilterColumnNode) node;
			this.name = at.name;
		}

		@Override
		public String createNodeName() {
			return name;
		}

		@Override
		public Object getValue(int column) {
			return name;
		}

		@Override
		public Object[] getValues() {
			return new Object[] { name };
		}

		@Override
		public ImageIcon getIcon() {
			return null;
		}

		@Override
		public boolean isCheckable() {
			return true;
		}
	}

	public static class FilterData {
		String filterType = "";
		String filterText = "";
		List<String> filterNodes = new ArrayList<String>();
	}

	//=====================================================================
	// ContextMenu
	//=====================================================================

	public static class TreeTablePopupAction extends AbstractAction {
		private static final long serialVersionUID = 1L;

		public TreeTablePopupAction(String text, ImageIcon icon, String desc, Integer mnemonic) {
			super(text, icon);
			putValue(NAME, text);
			putValue(SHORT_DESCRIPTION, desc);
			putValue(MNEMONIC_KEY, mnemonic);
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		}
	}

	/**
	 * @author  Admin
	 */
	public static class TreeTableContextMenu extends JPopupMenu {
		private static final long serialVersionUID = 1L;

		private JTreeTableX table;
		private int menuRow;
		private MouseEvent menuEvent;

		private TreeTablePopupAction expandAction;
		private TreeTablePopupAction collapseAction;
		private TreeTablePopupAction showDetailsAction;
		private TreeTablePopupAction columnsConfAction;
		private TreeTablePopupAction copyAction;
		private TreeTablePopupAction pasteAction;
		private TreeTablePopupAction copyRowAction;
		private TreeTablePopupAction pasteRowAction;
		private TreeTablePopupAction copyColAction;
		private TreeTablePopupAction pasteColAction;

		public TreeTableContextMenu(JTreeTableX table) {
			this.table = table;

			expandAction =
				new TreeTablePopupAction("Alle ausklappen", TT_EXP_ICON, "Ausklappen", new Integer(KeyEvent.VK_A)) {
					private static final long serialVersionUID = 1L;

					@Override
					public void actionPerformed(ActionEvent e) {
						TreeTableNode node = table.getSelectedNode();
						if (node != null) {
							table.expandNode(node);
						}
					}
				};

			collapseAction =
				new TreeTablePopupAction("Alle zuklappen", TT_COL_ICON, "Zuklappen", new Integer(KeyEvent.VK_A)) {
					private static final long serialVersionUID = 1L;

					@Override
					public void actionPerformed(ActionEvent e) {
						TreeTableNode node = table.getSelectedNode();
						if (node != null) {
							table.collapseNode(node);
						}
					}
				};

			showDetailsAction =
				new TreeTablePopupAction(
					"Zeige diese Zeile...",
					TT_DET_ICON,
					"Diese Zeile anzeigen",
					new Integer(KeyEvent.VK_Z)
				) {
					private static final long serialVersionUID = 1L;

					@Override
					public void actionPerformed(ActionEvent e) {
						table.showDetailPopup(menuRow, menuEvent);
					}
				};

			columnsConfAction =
				new TreeTablePopupAction(
					"Spalten ein-/ausblenden...",
					null,
					"Spalten ein-/ausblenden",
					new Integer(KeyEvent.VK_S)
				) {
					private static final long serialVersionUID = 1L;

					@Override
					public void actionPerformed(ActionEvent e) {
						table.configColumns(table.getParent());
					}
				};

			copyAction =
				new TreeTablePopupAction("Kopieren", TT_COP_ICON, "Kopieren", new Integer(KeyEvent.VK_C)) {
					private static final long serialVersionUID = 1L;

					@Override
					public void actionPerformed(ActionEvent e) {
						if (menuEvent != null) {
							int evRow = table.rowAtPoint(menuEvent.getPoint());
					        int evCol = table.columnAtPoint(menuEvent.getPoint());
							table.copySelectedData(table, evRow, evCol);
						}
					}
				};

			pasteAction =
				new TreeTablePopupAction("Einf¸gen", TT_PAS_ICON, "Einf¸gen", new Integer(KeyEvent.VK_V)) {
					private static final long serialVersionUID = 1L;

					@Override
					public void actionPerformed(ActionEvent e) {
						if (menuEvent != null) {
							int evRow = table.rowAtPoint(menuEvent.getPoint());
					        int evCol = table.columnAtPoint(menuEvent.getPoint());
					        table.pasteSelectedData(table, evRow, evCol);
						}
					}
				};

			copyRowAction =
				new TreeTablePopupAction("Zeile kopieren", TT_COP_ICON, "Zeile kopieren", new Integer(KeyEvent.VK_C)) {
					private static final long serialVersionUID = 1L;

					@Override
					public void actionPerformed(ActionEvent e) {
						table.copySelectedData(table, -1, -1);
					}
				};

			pasteRowAction =
				new TreeTablePopupAction("Zeile einf¸gen", TT_PAS_ICON, "Zeile einf¸gen", new Integer(KeyEvent.VK_V)) {
					private static final long serialVersionUID = 1L;

					@Override
					public void actionPerformed(ActionEvent e) {
						table.pasteSelectedData(table, -1, -1);
					}
				};
						
			copyColAction =
				new TreeTablePopupAction("Spalte kopieren", TT_COP_ICON, "Spalte kopieren", new Integer(KeyEvent.VK_C)) {
					private static final long serialVersionUID = 1L;

					@Override
					public void actionPerformed(ActionEvent e) {
					}
				};

			pasteColAction =
				new TreeTablePopupAction("Spalte einf¸gen", TT_PAS_ICON, "Spalte einf¸gen", new Integer(KeyEvent.VK_V)) {
					private static final long serialVersionUID = 1L;

					@Override
					public void actionPerformed(ActionEvent e) {
					}
				};
				
			ActionListener keyListener =
				new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						if (e.getActionCommand().compareTo("Copy") == 0) {
							copyAction.actionPerformed(e);
						}

						if (e.getActionCommand().compareTo("Paste") == 0) {
							pasteAction.actionPerformed(e);
						}
					}
				};

			KeyStroke copy = KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK, false);
			KeyStroke paste = KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK, false);
			table.registerKeyboardAction(keyListener, "Copy", copy, JComponent.WHEN_FOCUSED);
			table.registerKeyboardAction(keyListener, "Paste", paste, JComponent.WHEN_FOCUSED);

			copyColAction.setEnabled(false);
			pasteColAction.setEnabled(false);

			JMenu copyMenu = new JMenu("Kopieren");
			copyMenu.add(copyAction);
			copyMenu.add(copyRowAction);
			copyMenu.add(copyColAction);
			
			JMenu pasteMenu = new JMenu("Einf¸gen");
			pasteMenu.add(pasteAction);
			pasteMenu.add(pasteRowAction);
			pasteMenu.add(pasteColAction);
			
			add(expandAction);
			add(collapseAction);
			add(showDetailsAction);
			addSeparator();
			
			add(copyMenu);
			add(pasteMenu);
			addSeparator();
			add(columnsConfAction);
		}

		public void show(int row, MouseEvent event) {
			this.menuRow = row;
			this.menuEvent = event;
			TreeTableNode[] sels = table.getSelectedNodes();
			boolean sel = sels != null && sels.length == 1;
			expandAction.setEnabled(sel && table.getTree().getDepth() > 1);
			collapseAction.setEnabled(sel && table.getTree().getDepth() > 1);
			showDetailsAction.setEnabled(sel && table.showDetailsPopup);
			copyAction.setEnabled(sel);
			pasteAction.setEnabled(sel);
			columnsConfAction.setEnabled(table.columnsConfigurable);
			super.show(event.getComponent(), event.getX(), event.getY());
		}
	}

	//=====================================================================
	// Columns configurations
	//=====================================================================

	private void configColumns(Component comp) {

		final JButton btOk = new JButton("Ok");
		final JButton btCancel = new JButton("Abbrechen");

		final JTreeTableX table =
			new JTreeTableX(new String[] { "Spalten" }) {
				private static final long serialVersionUID = 1L;

				final JTreeTableX self = this;

				@Override
				public void nodeCheckChanged(TreeTableNode node) {
					btOk.setEnabled(self.tree.getCheckedCount() > 0);
				}
			};

		table.setRowHeight(20);
		table.setShowAlternateColor(false);
		table.setShowHeaderMenu(false);
		table.setShowPopupMenu(false);
		table.setShowDetailsPopup(false);
		table.setColumnsConfigurable(false);
		table.setShowExCoButtons(false);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		List<FilterColumnNode> nodes = new ArrayList<FilterColumnNode>();
		List<TreeTableNode> checkeds = new ArrayList<TreeTableNode>();

		for (String cs : columnNames) {
			FilterColumnNode fn = new FilterColumnNode(cs);
			nodes.add(fn);
			if (viewColumns.contains(cs)) {
				checkeds.add(fn);
			}
		}

		table.init(nodes);
		table.check(checkeds);

		JScrollPane sp = new JScrollPane();
		sp.getViewport().add(table);
		sp.getViewport().setBackground(Color.WHITE);

		btOk.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					List<String> columns = new ArrayList<String>();
					List<TreeTableNode> nodes = table.getNodes();
					for (TreeTableNode node : nodes) {
						if (!node.isRoot() && node.isChecked()) {
							columns.add(((FilterColumnNode) node).name);
						}
					}

					doSetViewColumns(columns, false);
					popup.close();
				}
			}
		);

		btCancel.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					popup.close();
				}
			}
		);

		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p1.setBackground(Color.WHITE);
		p1.add(btCancel);
		p1.add(btOk);

		JPanel p2 = new JPanel(new BorderLayout());
		p2.setBackground(Color.WHITE);
		p2.add(sp, BorderLayout.CENTER);
		p2.add(p1, BorderLayout.SOUTH);

		p2.setPreferredSize(new Dimension(200, 286));

		popup =
			new JPopup() {
				@Override
				public void popupClosed() {
				}
			};

		popup.open(comp, p2, 10, 10, 200, 286);
	}

	//=====================================================================
	// Detail popup
	//=====================================================================

	private void showDetailPopup(int row, MouseEvent event) {

		TreeTableNode node = (TreeTableNode) tree.getPathForRow(row).getLastPathComponent();

		String tt = node.myKey.startsWith("root.") ? node.myKey.substring(5) : node.myKey;

		final Object[] data = node.getValues();
		final String title = tt;
		final JPopupMenu popup = new JPopupMenu();

		DefaultTableModel dm =
			new DefaultTableModel(columnNames.length, 2) {

				private static final long serialVersionUID = 1L;

				public Object getValueAt(int r, int c) {
					return c == 0 ? columnNames[r] : data[r];
				}

				public String getColumnName(int c) {
					return c == 0 ? title : "...";
				}

				public boolean isCellEditable(int r, int c) {
					return false;
				}
			};

		final JTable table = new JTable(dm);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		table.setCellSelectionEnabled(true);
		table.setBackground(new Color(255, 255, 225));

		JScrollPane scroll = new JScrollPane(table);
		JPanel panel = new JPanel(new BorderLayout());

		final JButton btClose = new JButton("Schlieﬂen");
		final JButton btCopy = new JButton("Kopieren");

		btCopy.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					copySelectedData(table, -1, -1);
				}
			}
		);

		btClose.addActionListener(
			new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					popup.setVisible(false);
				}
			}
		);

		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p1.add(btCopy);
		p1.add(btClose);

		panel.add(scroll, BorderLayout.CENTER);
		panel.add(p1, BorderLayout.SOUTH);

		int w = scroll.getPreferredSize().width + 5;
		int h = (data.length) * table.getRowHeight() + 64;
		panel.setPreferredSize(new Dimension(w, h));

		popup.add(panel);
		popup.show(event.getComponent(), event.getX(), event.getY());
	}

	/**
	 * @param   table
	 * @param   row
	 * @param   col
	 *
	 * @return  StringBuffer
	 */
	private void copySelectedData(JTable table, int row, int col) {

		StringBuffer sbf = new StringBuffer();

		try {
			if (row != -1 && col != -1) {
				sbf.append(table.getValueAt(row, col));				
			}
			else {
				int numcols = table.getSelectedColumnCount();
				int numrows = table.getSelectedRowCount();
				int[] rowsselected = table.getSelectedRows();
				int[] colsselected = table.getSelectedColumns();
	
				if (!table.getColumnModel().getColumnSelectionAllowed()) {
					numcols = table.getColumnCount();
					colsselected = new int[numcols];
					for (int n = 0; n < table.getColumnCount(); n++) {
						colsselected[n] = n;
					}
				}
	
				for (int i = 0; i < numrows; i++) {
					for (int j = 0; j < numcols; j++) {
						sbf.append(table.getValueAt(rowsselected[i], colsselected[j]));
						if (j < numcols - 1) {
							sbf.append("\t");
						}
					}
					sbf.append("\n");
				}
			}
			StringSelection stsel = new StringSelection(sbf.toString());
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stsel, stsel);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * @param  table
	 * @param  row
	 * @param  col
	 */
	private void pasteSelectedData(JTable table, int row, int col) {
		try {
			String data =
				(String) (
					Toolkit
						.getDefaultToolkit()
						.getSystemClipboard()
						.getContents(table)
						.getTransferData(DataFlavor.stringFlavor)
				);
			if (row != -1 && col != -1) {
				table.setValueAt(data, row, col);  // TODO
			}
			else {
				int startRow = (table.getSelectedRows())[0];
				int startCol = table.getColumnModel().getColumnSelectionAllowed() ? (table.getSelectedColumns())[0] : 0;
				StringTokenizer st1 = new StringTokenizer(data, "\n");
				for (int i = 0; st1.hasMoreTokens(); i++) {
					String rowstring = st1.nextToken();
					StringTokenizer st2 = new StringTokenizer(rowstring, "\t");
					for (int j = 0; st2.hasMoreTokens(); j++) {
						String value = (String) st2.nextToken();
						if (startRow + i < table.getRowCount() && startCol + j < table.getColumnCount()) {
							table.setValueAt(value, startRow + i, startCol + j);  // TODO
						}
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	//=====================================================================
	// TreeTableTree
	//=====================================================================

	public class TreeTableTree extends CheckboxTree implements CheckboxTree.CheckboxTreeListener {

		private static final long serialVersionUID = 1L;

		private TreeTableNode originRoot;
		private TreeTableNode root;
		private DefaultTreeModel model;
		private int paintingRow;

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public TreeTableTree() {
			this.originRoot = new TreeTableNode();
			this.originRoot.setNodeParent(null);
			this.model = new DefaultTreeModel(originRoot);

			setModel(model);
			setEditable(false);
			setRootVisible(false);
			setShowsRootHandles(true);
			setCellRenderer(new TreeTableTreeCellRenderer());
			setShowCheckBox(true);

			addCheckBoxTreeListener(this);
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		private void init(TreeTableNode root) {
			clear();
			if (root != null) {
				originRoot = root;
			}
			prepareData();
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		private void init(List<? extends TreeTableNode> nodes) {
			clear();
			originRoot.initChildren(nodes);
			prepareData();
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		private void update(List<? extends TreeTableNode> nodes) {
			originRoot.updateChildren(nodes);
			prepareData();
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		private void update(TreeTableNode rootNode, boolean setRoot) {
			if (setRoot) {
				originRoot = rootNode;
			} else {
				clear();
				originRoot.addChild(rootNode);
			}
			prepareData();
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		private void prepareData() {

			if (!showHeaderMenu) {
				root = originRoot.clone();

			} else if (filterByUser) {
				if (!filterData.isEmpty()) {
					filter(filterData);
				}

			} else {

				root = originRoot.cloneToNode(null, true, true, false);

				if (!filterData.isEmpty()) {
					for (Integer columnIndex : filterData.keySet()) {
						root = doFilter(root, columnIndex, filterData.get(columnIndex));
					}
				}
			}

			if (sortingColumn != -1) {
				sort();
			}

			model.setRoot(root);

			reload();
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		private void clear() {
			originRoot.clear(true);
			model.setRoot(originRoot);
			reload();
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		private void reload() {
			model.reload();
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public boolean getShowCheckBox(TreeNode node) {
			return super.getShowCheckBox(node) && ((TreeTableNode) node).isCheckable();
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		private void sort() {
			sort(getComparator(sortingColumn), sortingColumn, sortingDirection);
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		private void sort(Comparator<Object> comparator, int columnIndex, int sortDirection) {

			List<TreeTableNode> lastSelection = new ArrayList<TreeTableNode>();
			TreeTableNode[] nodes = getSelectedNodes();
			if (nodes != null) {
				for (TreeTableNode node : nodes) {
					lastSelection.add(node);
				}
			}

			Enumeration<TreePath> expandeds = getExpandedDescendants(new TreePath(root));
			List<TreeNode> checkeds = getCheckedItems();

			if (sortDirection == SORTDIR_NO) {
				root.addToTree();
			} else {
				root.sort(comparator, columnIndex, sortDirection);
			}

			reload();

			// expand the last expanded rows
			while (expandeds != null && expandeds.hasMoreElements()) {
				expandPath((TreePath) expandeds.nextElement());
			}

			// select the last selected rows
			root.select(this, lastSelection);

			// check all last checkeds
			if (checkeds != null && !checkeds.isEmpty()) {
				check(checkeds);
			}

			revalidate();
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		private TreeTableNode doFilter(TreeTableNode node, int columnIndex, FilterData fdata) {

			TreeTableNode filteredNode = null;

			Object va = node.getValue(columnIndex);
			if (va != null) {

				if (node.hasChild()) {
					filteredNode = node.cloneNode(false);
				} else {

					String vs = va.toString();
					boolean found = fdata.filterNodes.isEmpty();

					for (String fr : fdata.filterNodes) {
						String f = fr.equals("Leer") ? "" : fr;
						if (f.equals(vs)) {
							found = true;
							break;
						}
					}

					if (found) {
						if (!fdata.filterType.isEmpty() && !fdata.filterText.isEmpty()) {
							if (fdata.filterType.equals("Ist gleich")) {
								found = vs.equals(fdata.filterText);
							} else if (fdata.filterType.equals("Ist nicht gleich")) {
								found = !vs.equals(fdata.filterText);
							} else if (fdata.filterType.equals("Beginnt mit")) {
								found = vs.startsWith(fdata.filterText);
							} else if (fdata.filterType.equals("Endet mit")) {
								found = vs.endsWith(fdata.filterText);
							} else if (fdata.filterType.equals("Enth‰lt")) {
								found = vs.indexOf(fdata.filterText) != -1;
							} else if (fdata.filterType.equals("Enth‰lt nicht")) {
								found = vs.indexOf(fdata.filterText) == -1;
							} else if (fdata.filterType.equals("Benutzerdefiniert")) {
								found = false; // @todo
							}
						}
					}

					if (found) {
						filteredNode = node.cloneNode(false);
					}
				}
			} else {
				filteredNode = node.cloneNode(false);
			}

			if (filteredNode != null && node.hasChild()) {
				for (TreeTableNode o : node.myChildren) {
					TreeTableNode cn = doFilter(o, columnIndex, fdata);
					if (cn != null) {
						filteredNode.addChild(cn);
					}
				}
			}

			return filteredNode;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		protected void expandNode(TreeTableNode node) {
			node.expand(this, 100);
			revalidate();
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		protected void collapseNode(TreeTableNode node) {
			node.collapse(this, -1);
			revalidate();
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		private void expandToLevel(int level) {
			TreeTableNode node = getSelectedNode();
			TreePath path = node == null ? null : new TreePath(node.getPath());

			root.expand(this, level);

			if (path != null) {
				setSelectionPath(path);
			}

			revalidate();
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		private void collapseToLevel(int level) {
			TreeTableNode node = getSelectedNode();
			TreePath path = node == null ? null : new TreePath(node.getPath());

			root.collapse(this, level);

			if (path != null) {
				setSelectionPath(path);
			}
			revalidate();
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public TreeTableNode getNodeAtRow(int row) {
			TreePath path = getPathForRow(row);
			if (path != null) {
				Object o = path.getLastPathComponent();
				if (o instanceof TreeTableNode) {
					return (TreeTableNode) o;
				}
			}
			return null;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public TreeTableNode getNodeByKey(String key) {
			return root.getNodeByKey(key);
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public TreeTableNode getNodeByName(String name, boolean caseSensitive) {
			return root.getNodeByName(name, caseSensitive);
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public List<TreeTableNode> getNodes() {
			List<TreeTableNode> nodes = new ArrayList<TreeTableNode>();
			root.copyToList(nodes);
			return nodes;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public List<TreeTableNode> getAllCheckedNodes() {
			List<TreeTableNode> nodes = new ArrayList<TreeTableNode>();
			List<TreeNode> ns = getAllChecked();
			for (TreeNode n : ns) {
				TreeTableNode node = (TreeTableNode) n;
				if (!node.isRoot()) {
					nodes.add(node);
				}
			}
			return nodes;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public List<TreeTableNode> getAllCheckedNodesHerarchic() {

			List<TreeTableNode> nodes = new ArrayList<TreeTableNode>();
			List<TreeTableNode> tops = new ArrayList<TreeTableNode>();

			List<TreeNode> ns = getAllChecked();

			for (TreeNode n : ns) {
				TreeTableNode node = (TreeTableNode) n;
				if (!node.isRoot()) {
					if (node.getNodeParent().isRoot()) {
						tops.add(node.cloneNode(false));
					} else {
						nodes.add(node);
					}
				}
			}

			adx(nodes, tops);

			return tops;
		}

		private void adx(List<TreeTableNode> nodes, List<TreeTableNode> tops) {
			List<TreeTableNode> nds = new ArrayList<TreeTableNode>();
			List<TreeTableNode> tps = new ArrayList<TreeTableNode>();
			for (TreeTableNode node : nodes) {
				boolean f = true;
				for (TreeTableNode top : tops) {
					if (top.isParentOf(node)) {
						TreeTableNode n = node.cloneNode(false);
						top.addChild(n, false, false);
						tps.add(n);
						f = false;
						break;
					}
				}
				if (f) {
					nds.add(node);
				}
			}

			if (!nds.isEmpty()) {
				adx(nds, tps);
			}
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		private int getNodesCount() {
			return root.getNodesCount(root);
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		private void deleteNode(TreeTableNode node) {
			root.removeNode(node);
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		private int getDepth() {
			return root.getDepth();
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		private void select(TreeTableNode node) {
			TreeTableNode n = node;
			while (!root.equals(n) && n.myParent != null && !root.equals(n.myParent)) {
				n = n.myParent;
			}
			n.setSelected(true);
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		private void select(TreeTableNode[] nodes) {
			root.setSelected(false);
			for (TreeTableNode node : nodes) {
				select(node);
			}
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		private void select(List<TreeTableNode> selections) {
			root.select(this, selections);
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		private void search(String text, List<TreeTableNode> rows, boolean caseSensitive) {
			root.search(text, rows, caseSensitive);
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public void setRowHeight(int rowHeight) {
			if (rowHeight > 0) {
				super.setRowHeight(rowHeight);
				if (JTreeTableX.this.getRowHeight() != rowHeight) {
					JTreeTableX.this.setRowHeight(getRowHeight());
				}
			}
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public void setBounds(int x, int y, int w, int h) {
			super.setBounds(x, y, w, JTreeTableX.this.getHeight());
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public void paint(Graphics g) {
			g.translate(0, -paintingRow * getRowHeight());
			super.paint(g);
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		protected boolean isEnabled(TreeNode node) {
			return ((TreeTableNode) node).isCheckBoxEnabled();
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public void checkBoxValueChanged(JTree tree, TreeNode node, int checkState) {
			nodeChecked((TreeTableNode) node, checkState);
		}
	}

	//===============================================================================
	// TreeTableNode
	//
	// This is the callback interface. Provides for initialization of the nodes.
	// Through this interface the user can determine most properties of the nodes,
	// for example icons, colors, fonts, etc.
	//===============================================================================

	public static class TreeTableNode extends DefaultMutableTreeNode {

		private static final long serialVersionUID = 1L;

		private String myKey;
		private String myName;
		private int myLevel;
		private TreeTableNode myParent;
		private List<TreeTableNode> myChildren;
		private boolean selected;
		private int checkState;

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public TreeTableNode() {
			super(null);
			this.myParent = null;
			this.myKey = null;
			this.myName = null;
			this.myLevel = 0;
			this.myChildren = null;
			this.selected = false;
			this.checkState = CheckboxTree.NOT_SELECTED;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public String getNodeName() {
			if (myName == null) {
				myName = createNodeName();
			}
			return myName;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		protected String createNodeName() {
			return null;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public String getNodeKey() {
			if (myKey == null) {
				myKey = createNodeKey();
			}
			return myKey;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		private String createNodeKey() {
			return myParent == null ? getNodeName() : myParent.createNodeKey() + "." + getNodeName();
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public String getKeyPart(String key, int fromLevel) {
			String k = "";
			if (key != null && !key.isEmpty()) {
				String[] keys = key.split("[.]");
				for (int i = fromLevel; i < keys.length; i++) {
					k += keys[i] + (i < keys.length - 1 ? "." : "");
				}
			}
			return k;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public void getKeyPaths(List<String> keys) {
			if (hasChild()) {
				for (TreeTableNode o : myChildren) {
					o.getKeyPaths(keys);
				}
			} else {
				keys.add(getNodeKey());
			}
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public TreeTableNode getNodeParent() {
			return myParent;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		private void setNodeParent(TreeTableNode parent) {
			this.myParent = parent;
			this.myKey = parent == null ? "root" : createNodeKey();
			this.myName = parent == null ? "root" : createNodeName();
			this.myLevel = parent == null ? 0 : parent.myLevel + 1;
			if (hasChild()) {
				for (TreeTableNode node : myChildren) {
					node.setNodeParent(this);
				}
			}
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public int getNodeLevel() {
			return myLevel;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public TreeTableNode getNodeByName(String name) {
			return getNodeByName(name, true);
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public TreeTableNode getNodeByName(String name, boolean caseSensitive) {
			String nm = getNodeName();
			if (caseSensitive) {
				if (name.equals(nm)) {
					return this;
				}
			} else if (nm.toLowerCase().equals(name.toLowerCase())) {
				return this;
			}

			if (hasChild()) {
				for (TreeTableNode node : myChildren) {
					TreeTableNode n = node.getNodeByName(name, caseSensitive);
					if (n != null) {
						return n;
					}
				}
			}
			return null;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public TreeTableNode getNodeByKey(String key) {
			if (getNodeKey().equals(key)) {
				return this;
			}
			if (hasChild()) {
				for (TreeTableNode node : myChildren) {
					TreeTableNode n = node.getNodeByKey(key);
					if (n != null) {
						return n;
					}
				}
			}
			return null;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public TreeTableNode getNodeByKeyParts(int kpos1, int kpos2, String key) {
			String k1 = getKeyPart(myKey, kpos1);
			String k2 = getKeyPart(key, kpos2);

			if (k1.equals(k2)) {
				return this;
			}
			if (hasChild()) {
				for (TreeTableNode node : myChildren) {
					TreeTableNode n = node.getNodeByKeyParts(kpos1, kpos2, key);
					if (n != null) {
						return n;
					}
				}
			}
			return null;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		private void initChildren(List<? extends TreeTableNode> nodes) {
			if (nodes != null && !nodes.isEmpty()) {
				clear(true);
				for (TreeTableNode node : nodes) {
					addChild(node);
				}
			}
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		private void updateChildren(List<? extends TreeTableNode> nodes) {
			if (nodes != null) {
				clear(false);
				for (TreeTableNode node : nodes) {
					addChild(node);
				}
			}
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public boolean hasChild() {
			return myChildren != null && !myChildren.isEmpty();
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public List<TreeTableNode> getChildren() {
			return myChildren;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public TreeTableNode getChild(String name) {
			return getChild(name, true);
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public TreeTableNode getChild(String name, boolean caseSensitive) {
			if (hasChild()) {
				for (TreeTableNode node : myChildren) {
					if (node.getNodeName() == null) {
						return null;
					}
					if (caseSensitive) {
						if (node.getNodeName().equals(name)) {
							return node;
						}
					} else {
						if (node.getNodeName().toLowerCase().equals(name.toLowerCase())) {
							return node;
						}
					}
				}
			}
			return null;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public List<TreeTableNode> getChildren(String name) {
			if (hasChild()) {
				List<TreeTableNode> cc = new ArrayList<TreeTableNode>();
				for (TreeTableNode o : myChildren) {
					if (o.getNodeName().equals(name)) {
						cc.add(o);
					}
				}
				return cc;
			}
			return null;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public List<TreeTableNode> getChildren(Class<?> classtype) {
			if (hasChild()) {
				if (classtype != null) {
					List<TreeTableNode> cc = new ArrayList<TreeTableNode>();
					for (TreeTableNode o : myChildren) {
						if (o.getClass() == classtype) {
							cc.add(o);
						}
					}
					return cc;
				}
				return myChildren;
			}
			return null;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public void addChild(TreeTableNode child) {
			addChild(child, true, false);
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public void addMultipleChild(TreeTableNode child) {
			addChild(child, true, true);
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		private void addChild(TreeTableNode child, boolean setParent, boolean multiple) {
			if (myChildren == null) {
				myChildren = new ArrayList<TreeTableNode>();
			}
			if (multiple || getChild(child.getNodeName()) == null) {
				if (setParent) {
					child.setNodeParent(this);
				}
				myChildren.add(child);
				add(child);
			}
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public void removeChild(TreeTableNode child) {
			if (getNodeByName(child.getNodeName()) != null) {
				myChildren.remove(child);
				remove(child);
			}
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public void removeChild(String name) {
			TreeTableNode child = getNodeByName(name);
			if (child != null) {
				myChildren.remove(child);
				remove(child);
			}
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public void removeNode(TreeTableNode node) {
			TreeTableNode n = getNodeByKey(node.myKey);
			if (n != null) {
				n.myParent.removeChild(n);
			}
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public void clear(boolean childrenToo) {
			if (childrenToo && hasChild()) {
				for (TreeTableNode node : myChildren) {
					node.clear(true);
				}
			}

			// this must be done here!!
			removeAllChildren();

			if (hasChild()) {
				myChildren.clear();
			}
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public Object getValue(int column) {
			return null;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public void setValue(int column, Object value) {
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public Object[] getValues() {
			return new Object[] { getNodeName() };
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public boolean isParentOf(TreeTableNode node) {
			return node.myParent != null && myKey.equals(node.myParent.myKey);
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public boolean isRoot() {
			return myParent == null;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public int getDepth() {
			return getDepth(0);
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		private int getDepth(int d) {
			int dd = d;
			if (hasChild()) {
				for (TreeTableNode node : myChildren) {
					dd = Math.max(dd, node.getDepth(d + 1));
				}
			}
			return dd;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		private void addToTree() {
			setUserObject(myName);
			if (hasChild()) {
				for (TreeTableNode node : myChildren) {
					add(node);
					node.addToTree();
				}
			}
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public ImageIcon getIcon() {
			return null;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public boolean isCheckBoxEnabled() {
			return true;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public boolean isCheckable() {
			return false;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public void setCheckState(int checkState) {
			this.checkState = checkState;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public boolean isChecked() {
			return checkState == CheckboxTree.ALL_SELECTED;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public boolean isPartChecked() {
			return checkState == CheckboxTree.PART_SELECTED;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public boolean isEnabled(int row, int column) {
			return true;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public boolean isEditable(int row, int column) {
			return false;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public RendererComponent getRenderer(int row, int column) {
			return null;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public EditorComponent getEditor(int row, int column) {
			return null;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		protected EditorComponent getEditorInstance(EditorComponent editor) {
			try {
				return editor == null ? null : editor.getClass().newInstance();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		protected Class<?> getType(int row, int column) {
			Object[] ob = getValues();
			return ob[column] == null ? null : ob[column].getClass();
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public void editorValueChanged(Object oldValue, Object newValue) {
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public boolean isSelected() {
			return selected;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public void setSelected(boolean selected) {
			this.selected = selected;
			if (hasChild()) {
				for (TreeTableNode node : myChildren) {
					node.setSelected(selected);
				}
			}
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		private void select(TreeTableTree tree, List<TreeTableNode> nodes) {
			TreePath[] paths = new TreePath[nodes.size()];
			for (int i = 0; i < nodes.size(); i++) {
				paths[i] = new TreePath(nodes.get(i).getPath());
			}
			tree.setSelectionPaths(paths);
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public void expand(JTree tree, int level) {
			tree.expandPath(new TreePath(getPath()));
			if (hasChild()) {
				for (TreeTableNode node : myChildren) {
					if (node.getNodeLevel() < level) {
						tree.expandPath(new TreePath(node.getPath()));
						node.expand(tree, level);
					}
				}
			}
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public void collapse(JTree tree, int level) {
			if (hasChild()) {
				for (TreeTableNode node : myChildren) {
					node.collapse(tree, level);
					if (node.getNodeLevel() >= level) {
						tree.collapsePath(new TreePath(node.getPath()));
					}
				}
			}
			if (level < 0) {
				tree.collapsePath(new TreePath(getPath()));
			}
		}

		/**
		 * The Bubblesort
		 *
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public void sort(Comparator<Object> comparator, int columnIndex, int sortDirection) {

			if (hasChild()) {

				// first sort children
				for (TreeTableNode node : myChildren) {
					node.sort(comparator, columnIndex, sortDirection);
				}

				// and now sort myself
				TreeTableNode[] rows = myChildren.toArray(new TreeTableNode[myChildren.size()]);

				for (int i = rows.length; i > 1; i--) {
					for (int j = 1; j < i; j++) {
						TreeTableNode r1 = rows[j - 1];
						TreeTableNode r2 = rows[j];

						Object o1 = r1.getValues()[columnIndex];
						Object o2 = r2.getValues()[columnIndex];
						int co = comparator.compare(o1, o2);
						if (
							(sortDirection == SORTDIR_ASCENDING && co > 0)
							|| (sortDirection == SORTDIR_DESCENDING && co < 0)
						) {
							rows[j - 1] = r2;
							rows[j] = r1;
						}
					}
				}

				// finally order the child nodes again
				removeAllChildren();
				for (int i = 0; i < rows.length; i++) {
					add(rows[i]);
				}
			}
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public void search(Object condition, List<TreeTableNode> results, boolean caseSensitive) {
			if (hasChild()) {
				for (TreeTableNode node : myChildren) {
					node.search(condition, results, caseSensitive);
				}
			}
			searchData(condition, results, caseSensitive);
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public void searchData(Object condition, List<TreeTableNode> results, boolean sensitive) {
			Object[] data = getValues();
			if (data != null) {
				for (Object o : data) {
					String tx = o == null ? "" : sensitive ? o.toString() : o.toString().toLowerCase();
					if (tx.indexOf(sensitive ? condition.toString() : condition.toString().toLowerCase()) != -1) {
						results.add(this);
						break;
					}
				}
			}
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		protected TreeTableNode createInstance() {
			return null;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		private TreeTableNode instance() {
			TreeTableNode node = createInstance();
			if (node == null) {
				try {
					node = getClass().getDeclaredConstructor().newInstance();
				} catch (Exception ex) {
					ex.printStackTrace();
					return null;
				}
			}
			return node;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		@Override
		public TreeTableNode clone() {
			return cloneToNode(null, true, true, false);
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public TreeTableNode cloneNode(boolean childrenToo) {
			return cloneToNode(null, childrenToo, true, false);
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public TreeTableNode cloneToNode(TreeTableNode node, boolean childrenToo) {
			return cloneToNode(node, childrenToo, true, false);
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public TreeTableNode cloneToNode(TreeTableNode node, boolean childrenToo, boolean newInstance) {
			return cloneToNode(node, childrenToo, newInstance, false);
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public TreeTableNode cloneToNode(
			TreeTableNode node,
			boolean		  childrenToo,
			boolean		  newInstance,
			boolean		  difTypes
		) {

			TreeTableNode newNode = node == null ? instance() : node;

			copyToNode(newNode);

			if (childrenToo && hasChild()) {
				for (TreeTableNode no : myChildren) {
					newNode.addChild(
						no.cloneToNode(
							newInstance ? difTypes ? node.instance() : no.instance() : no,
							true,
							newInstance,
							difTypes
						),
						true,
						true
					);
				}
			}
			return newNode;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public void copyToNode(TreeTableNode node) {
			node.copyFromNode(this);
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public void copyFromNode(TreeTableNode node) {
			myParent = node.myParent;
			myKey = node.myKey;
			myName = node.myName;
			myLevel = node.myLevel;
			checkState = node.checkState;
			selected = node.selected;
			copy(node);
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		protected void copy(TreeTableNode node) {
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public void copyToList(List<TreeTableNode> nodes) {
			nodes.add(this);
			if (hasChild()) {
				for (TreeTableNode node : myChildren) {
					node.copyToList(nodes);
				}
			}
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public void copyToMap(Map<Object, TreeTableNode> map) {
			map.put(getNodeKey(), this);
			if (hasChild()) {
				for (TreeTableNode node : myChildren) {
					node.copyToMap(map);
				}
			}
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public Color getForegroundColor(int row, int column) {
			return Color.BLACK;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public Color getBackgroundColor(int row, int column) {
			return Color.WHITE;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public Font getFont(int row, int column) {
			return null;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public int getHorizontalAlignment(int row, int column) {
			return SwingConstants.LEFT;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public int getVerticalAlignment(int row, int column) {
			return SwingConstants.CENTER;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public String getTooltips(int row, int column) {
			return null;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		private int getNodesCount(TreeTableNode node) {
			int n = 0;
			if (hasChild()) {
				node.myChildren.size();
				for (TreeTableNode c : node.myChildren) {
					n += getNodesCount(c);
				}
			}
			return n;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public void print(String prefix) {
			System.out.println(prefix + " " + myName);
			for (TreeTableNode node : myChildren) {
				node.print(prefix + "---");
			}
		}

		//==================
		// XML interface
		//==================

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public String toXML() {
			String atr = getXmlAttributes();
			String xml = "<" + myName + (atr == null || atr.isEmpty() ? "" : " " + atr) + ">";
			if (hasChild()) {
				for (TreeTableNode node : myChildren) {
					xml += node.toXML();
				}
			} else {
				xml += getXmlValue();
			}
			xml += "</" + myName + ">";
			return xml;
		}

		/**
		 * @return  String
		 */
		protected String getXmlValue() {
			return "x";
		}

		/**
		 * @return  String a="v" b="v",..
		 */
		protected String getXmlAttributes() {
			return null;
		}
	}

	//###############################################################################
	// RendererComponent
	//###############################################################################

	public interface RendererComponent {

		public Object getRendererValue();

		public void setRendererValue(Object value);

		public Component getRendererComponent(
			Component parent,
			Object    value,
			boolean   isSelected,
			boolean   isEnabled,
			Color	  fc,
			Color	  bc
		);
	}

	//###############################################################################
	// EditorComponent
	//###############################################################################

	public interface EditorComponent extends RendererComponent {

		public Component getEditorComponent();

		public Object getEditorValue();

		public void setEditorValue(Object value);

		public String getValidState(Object value);

		public void setEditorListener(TreeTableCellEditor listener);

		public void fireEditingStopped(EditorComponent editor);

		public void fireEditingCanceled(EditorComponent editor);
	}

	//###############################################################################
	// IconRendererComponent
	//###############################################################################

	public static class IconRendererComponent extends JPanel implements RendererComponent {
		private static final long serialVersionUID = 1L;

		private JLabel label;

		public IconRendererComponent() {
			setLayout(new BorderLayout(0, 0));
			setOpaque(true);

			label = new JLabel();
			label.setOpaque(true);

			add(label, BorderLayout.CENTER);
		}

		@Override
		public void setForeground(Color fg) {
			super.setForeground(fg);
			if (label != null) {
				label.setForeground(fg);
			}
		}

		@Override
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

	//###############################################################################
	// DefaultEditorComponent
	//###############################################################################

	public abstract static class DefaultEditorComponent extends JPanel implements EditorComponent, ActionListener {

		private static final long serialVersionUID = 1L;

		private static final Icon icon = JTreeTableX.getImage("defeditor.gif");

		private Object value;

		private JLabel label;
		private JButton button;
		private Component parent;

		private TreeTableCellEditor listener;

		public DefaultEditorComponent() {
			this(icon);
		}

		public DefaultEditorComponent(Icon icon) {
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

		@Override
		public void setForeground(Color fg) {
			super.setForeground(fg);
			if (label != null) {
				label.setForeground(fg);
			}
		}

		@Override
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
		public Object getEditorValue() {
			return value;
		}

		@Override
		public void setEditorValue(Object value) {
			this.value = value;
		}

		@Override
		public Object getRendererValue() {
			return getEditorValue();
		}

		@Override
		public void setRendererValue(Object value) {
			setEditorValue(value);
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

			bc = sp == null ? bc : va == null ? MANDATORY_COLOR : ERROR_COLOR;

			label.setText(va);
			label.setIcon(ic);
			label.setFont(EDITOR_FONT);
			label.setForeground(fc);
			label.setBackground(bc);
			label.setEnabled(isEnabled);

			if ((va == null || va.isEmpty()) && ic != null) {
				label.setHorizontalAlignment(SwingConstants.RIGHT);
			}

			setForeground(fc);
			setBackground(bc);

			String tp =
				tt == null || tt.isEmpty()
				? (sp == null || sp.isEmpty() ? (va == null || va.isEmpty() ? null : va) : sp) : tt;
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
		public void setEditorListener(TreeTableCellEditor listener) {
			this.listener = listener;
		}

		@Override
		public void fireEditingStopped(EditorComponent editor) {
			if (listener != null) {
				listener.stopCellEditing();
			}
		}

		@Override
		public void fireEditingCanceled(EditorComponent editor) {
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

	//###############################################################################
	// EmptyEditorComponent
	//###############################################################################

	public static class EmptyEditorComponent extends DefaultEditorComponent {

		private static final long serialVersionUID = 1L;
		private JLabel lb;

		public EmptyEditorComponent() {
			super(null);

			lb = new JLabel();
			lb.setText("");
		}

		@Override
		public Component getEditorComponent() {
			return lb;
		}

		@Override
		public Object getEditorValue() {
			return "";
		}

		@Override
		public void setEditorValue(Object value) {
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
			Component co = super.getRendererComponent(parent, value, isSelected, isEnabled, fc, bc);
			((JPanel) co).removeAll();
			return co;
		}
	}

	//###############################################################################
	// TextEditorComponent
	//###############################################################################

	public static class TextEditorComponent extends DefaultEditorComponent {

		private static final long serialVersionUID = 1L;

		private static final ImageIcon icon = JTreeTableX.getImage("texteditor.png");

		private JTextField tx;

		public TextEditorComponent() {
			super(icon);

			tx = new JTextField();
			tx.addFocusListener(
				new FocusListener() {
					public void focusGained(final FocusEvent e) {
						tx.selectAll();
					}

					public void focusLost(final FocusEvent e) {
						tx.select(0, 0);
						fireEditingStopped(TextEditorComponent.this);
					}
				}
			);

			tx.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						fireEditingStopped(TextEditorComponent.this);
					}
				}
			);

			tx.registerKeyboardAction(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						fireEditingStopped(TextEditorComponent.this);
					}
				},
				KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0),
				JComponent.WHEN_FOCUSED
			);

			tx.registerKeyboardAction(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						fireEditingCanceled(TextEditorComponent.this);
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

	//###############################################################################
	// BooleanEditorComponent
	//###############################################################################

	public static class BooleanEditorComponent extends DefaultEditorComponent {

		private static final long serialVersionUID = 1L;
		private static final Icon ic1 = JTreeTableX.getImage("checkboxOff.gif");
		private static final Icon ic2 = JTreeTableX.getImage("checkboxOn.gif");
		private static final Icon ic3 = JTreeTableX.getImage("check.png");

		private JCheckBox cb;

		public BooleanEditorComponent() {
			super(null);
			cb = new JCheckBox();
			cb.setBorder(null);
			cb.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						fireEditingStopped(BooleanEditorComponent.this);
					}
				}
			);
		}

		@Override
		public Component getEditorComponent() {
			return cb;
		}

		@Override
		public Object getEditorValue() {
			return Boolean.valueOf(cb.isSelected());
		}

		@Override
		public void setEditorValue(Object value) {
			cb.setSelected(value == null ? false : ((Boolean) value).booleanValue());
		}

		@Override
		protected String convertToString(Object value) {
			return ""; //value.equals(Boolean.TRUE) ? "True" : "False";
		}

		@Override
		protected Icon convertToIcon(Object value, boolean isEditable) {
			boolean b = value != null && value.equals(Boolean.TRUE);
			if (isEditable) {
				return b ? ic2 : ic1;
			}
			return b ? ic3 : null;
		}
	}

	//###############################################################################
	// NumberEditorComponent
	//###############################################################################

	public static class NumberEditorComponent extends DefaultEditorComponent {

		private static final long serialVersionUID = 1L;

		private static final ImageIcon icon = JTreeTableX.getImage("numeditor.gif");

		private boolean adjusting = false;
		private JSpinner sp;

		public NumberEditorComponent() {
			this(
				new SpinnerNumberModel(
					new Integer(0),
					new Integer(Integer.MIN_VALUE),
					new Integer(Integer.MAX_VALUE),
					new Integer(1)
				)
			);
		}

		public NumberEditorComponent(SpinnerNumberModel md) {
			super(icon);

			sp = new JSpinner(md);
			sp.setFocusable(false);

			JSpinner.DefaultEditor ed = (JSpinner.DefaultEditor) sp.getEditor();
			ed.getTextField().setHorizontalAlignment(JLabel.LEFT);

			sp.addChangeListener(
				new ChangeListener() {
					public void stateChanged(ChangeEvent e) {
						if (!adjusting) {
							fireEditingStopped(NumberEditorComponent.this);
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

		public static class ShortEditorComponent extends NumberEditorComponent {

			private static final long serialVersionUID = 1L;

			public ShortEditorComponent() {
				super(new SpinnerNumberModel(0, Short.MIN_VALUE, Short.MAX_VALUE, 1));
			}

			public ShortEditorComponent(short value, short min, short max, short step) {
				super(new SpinnerNumberModel(value, min, max, step));
			}
		}

		public static class IntegerEditorComponent extends NumberEditorComponent {

			private static final long serialVersionUID = 1L;

			public IntegerEditorComponent() {
				super(new SpinnerNumberModel(0, Integer.MIN_VALUE, Integer.MAX_VALUE, 1));
			}

			public IntegerEditorComponent(int value, int min, int max, int step) {
				super(new SpinnerNumberModel(value, min, max, step));
			}
		}

		public static class LongEditorComponent extends NumberEditorComponent {

			private static final long serialVersionUID = 1L;

			public LongEditorComponent() {
				super(new SpinnerNumberModel(0, Long.MIN_VALUE, Long.MAX_VALUE, 1));
			}

			public LongEditorComponent(long value, long min, long max, long step) {
				super(new SpinnerNumberModel(value, min, max, step));
			}
		}

		public static class DoubleEditorComponent extends NumberEditorComponent {

			private static final long serialVersionUID = 1L;

			public DoubleEditorComponent() {
				super(new SpinnerNumberModel(0, -Double.MIN_VALUE, Double.MAX_VALUE, 0.5f));
			}

			public DoubleEditorComponent(double value, double min, double max, double step) {
				super(new SpinnerNumberModel(value, min, max, step));
			}
		}

		public static class FloatEditorComponent extends NumberEditorComponent {

			private static final long serialVersionUID = 1L;

			public FloatEditorComponent() {
				super(new SpinnerNumberModel(0, -Float.MIN_VALUE, Float.MIN_VALUE, 0.5f));
			}

			public FloatEditorComponent(float value, float min, float max, float step) {
				super(new SpinnerNumberModel(value, min, max, step));
			}
		}
	}

	//###############################################################################
	// ListEditorComponent
	//###############################################################################

	public static class ListEditorComponent extends DefaultEditorComponent {

		private static final long serialVersionUID = 1L;

		private static final ImageIcon icon = JTreeTableX.getImage("listeditor.gif");

		private Object[] items;
		private Object[] values;
		private Icon[] icons;

		private JComboBox<?> co;

		public ListEditorComponent() {
			this(new String[0], new String[0], null);
		}

		public ListEditorComponent(Object[] items, Object[] values, Icon[] icons) {
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
						fireEditingStopped(ListEditorComponent.this);
					}
				}
			);
			co.addKeyListener(
				new KeyAdapter() {
					public void keyPressed(KeyEvent e) {
						if (e.getKeyCode() == KeyEvent.VK_ENTER) {
							fireEditingStopped(ListEditorComponent.this);
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

	//###############################################################################
	// DateEditorComponent
	//###############################################################################

	public static class DateEditorComponent extends DefaultEditorComponent {

		private static final long serialVersionUID = 1L;

		private static final Icon icon = JTreeTableX.getImage("dateeditor.gif");

		private JCalendar ca;

		public DateEditorComponent() {
			super(icon);

			ca = new JCalendar();
			ca.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						fireEditingStopped(DateEditorComponent.this);
					}
				}
			);
		}

		@Override
		public Component getEditorComponent() {
			return ca;
		}

		@Override
		public Object getEditorValue() {
			return ca.getDateString();
		}

		@Override
		public void setEditorValue(Object value) {
			ca.setDate((String) value);
		}
	}

	//###############################################################################
	// DatePeriodEditorComponent
	//###############################################################################

	public static class DatePeriodEditorComponent extends DefaultEditorComponent {

		private static final long serialVersionUID = 1L;

		private static final Icon icon = JTreeTableX.getImage("dayperiod.png");

		private JDatePeriod dpriod;

		public DatePeriodEditorComponent() {
			super(icon);

			dpriod = new JDatePeriod();
			dpriod.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						fireEditingStopped(DatePeriodEditorComponent.this);
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

	//###############################################################################
	// ActionEditorComponent
	//###############################################################################

	public static class ActionEditorComponent extends DefaultEditorComponent {

		private static final long serialVersionUID = 1L;

		private String name;
		private TreeTableListener listener;

		private JPanel pan;
		private JLabel lab;
		private JButton but;

		/**
		 * @param  name
		 * @param  icon
		 */
		public ActionEditorComponent(String name, Icon icon) {
			this(name, icon, null);
		}

		/**
		 * @param  name
		 * @param  icon
		 * @param  listener
		 */
		public ActionEditorComponent(String name, Icon icon, TreeTableListener listener) {
			super(icon);

			this.name = name;
			this.listener = listener;

			pan = new JPanel(new BorderLayout(0, 0));
			lab = new JLabel();
			but = new JButton(icon);
			but.addActionListener(this);
			but.setPreferredSize(new Dimension(16, 16));
			but.setFocusable(false);

			pan.add(lab, BorderLayout.CENTER);
			pan.add(but, BorderLayout.EAST);
		}

		public void setListener(TreeTableListener listener) {
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
				listener.nodeActionPerformed(name, getEditorValue(), but);
			}
		}
	}

	//###############################################################################
	// HyperlinkEditorComponent
	//###############################################################################

	public static class HyperlinkEditorComponent extends JPanel implements EditorComponent {
		private static final long serialVersionUID = 1L;

		private TreeTableListener listener;

		private String name;
		private String value;
		private JLabel label;

		public HyperlinkEditorComponent(String name) {
			this(name, null);
		}

		public HyperlinkEditorComponent(String name, TreeTableListener listener) {

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
						if (HyperlinkEditorComponent.this.listener != null) {
							HyperlinkEditorComponent.this.listener.nodeActionPerformed(
								HyperlinkEditorComponent.this.name,
								getEditorValue(),
								label
							);
						}
					}
				}
			);

			add(label, BorderLayout.CENTER);
		}

		@Override
		public Object getRendererValue() {
			return value;
		}

		@Override
		public void setRendererValue(Object value) {
			label.setIcon(getIcon(value));
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
		public void setEditorListener(TreeTableCellEditor listener) {
		}

		@Override
		public void fireEditingStopped(EditorComponent editor) {
		}

		@Override
		public void fireEditingCanceled(EditorComponent editor) {
		}

		protected Icon getIcon(Object value) {
			return null;
		}

		protected String getTooltips(Object value) {
			return null;
		}

		public void setListener(TreeTableListener listener) {
			this.listener = listener;
		}

	}

	//############################################################################
	//#
	//# Supporting for attributive Table
	//#
	//############################################################################

	public Rectangle getCellRect(int row, int column, boolean includeSpacing) {
		if (cellAttributs == null) {
			return super.getCellRect(row, column, includeSpacing);
		}

		Rectangle sRect = super.getCellRect(row, column, includeSpacing);
		if ((row < 0) || (column < 0) || (getRowCount() <= row) || (getColumnCount() <= column)) {
			return sRect;
		}

		if (!cellAttributs.isVisible(row, column)) {
			int temp_row = row;
			int temp_column = column;
			row += cellAttributs.getSpan(temp_row, temp_column)[0];
			column += cellAttributs.getSpan(temp_row, temp_column)[1];
		}
		int[] n = cellAttributs.getSpan(row, column);

		int index = 0;
		int columnMargin = getColumnModel().getColumnMargin();
		int aCellHeight = rowHeight + rowMargin;

		Rectangle bound = new Rectangle();
		bound.y = row * aCellHeight;
		bound.height = n[0] * aCellHeight;

		Enumeration<TableColumn> enumeration = getColumnModel().getColumns();
		while (enumeration.hasMoreElements()) {
			TableColumn aColumn = enumeration.nextElement();
			bound.width = aColumn.getWidth() + columnMargin;
			if (index == column) {
				break;
			}
			bound.x += bound.width;
			index++;
		}
		for (int i = 0; i < n[1] - 1; i++) {
			TableColumn aColumn = enumeration.nextElement();
			bound.width += aColumn.getWidth() + columnMargin;
		}

		if (!includeSpacing) {
			Dimension spacing = getIntercellSpacing();
			bound.setBounds(
				bound.x + spacing.width / 2,
				bound.y + spacing.height / 2,
				bound.width - spacing.width,
				bound.height - spacing.height
			);
		}
		return bound;
	}

	public int rowAtPoint(Point point) {
		if (cellAttributs == null) {
			return super.rowAtPoint(point);
		}
		return rowColumnAtPoint(point)[0];
	}

	public int columnAtPoint(Point point) {
		if (cellAttributs == null) {
			return super.columnAtPoint(point);
		}
		return rowColumnAtPoint(point)[1];
	}

	public void valueChangedXX(ListSelectionEvent e) {
		if (cellAttributs == null) {
			super.valueChanged(e);
			return;
		}
		int firstIndex = e.getFirstIndex();
		int lastIndex = e.getLastIndex();
		if (firstIndex == -1 && lastIndex == -1) { // Selection cleared.
			repaint();
		}
		Rectangle dirtyRegion = getCellRect(firstIndex, 0, false);
		int numCoumns = getColumnCount();
		int index = firstIndex;
		for (int i = 0; i < numCoumns; i++) {
			dirtyRegion.add(getCellRect(index, i, false));
		}
		index = lastIndex;
		for (int i = 0; i < numCoumns; i++) {
			dirtyRegion.add(getCellRect(index, i, false));
		}
		repaint(dirtyRegion.x, dirtyRegion.y, dirtyRegion.width, dirtyRegion.height);
	}

	private int[] rowColumnAtPoint(Point point) {
		int[] retValue = { -1, -1 };
		int row = point.y / (rowHeight + rowMargin);
		if ((row < 0) || (getRowCount() <= row)) {
			return retValue;
		}
		int column = getColumnModel().getColumnIndexAtX(point.x);

		if (cellAttributs.isVisible(row, column)) {
			retValue[1] = column;
			retValue[0] = row;
			return retValue;
		}
		retValue[0] = row + cellAttributs.getSpan(row, column)[0];
		retValue[1] = column + cellAttributs.getSpan(row, column)[1];
		return retValue;
	}

	//======================================================
	// TreeTableCellAttribute
	//======================================================

	public static class TreeTableCellAttribute {

		private static final int ROW = 0;
		private static final int COLUMN = 1;

		//
		// !!!! CAUTION !!!!!
		// These values must be synchronized to Table data
		//
		protected int rowSize;
		protected int columnSize;

		protected int[][][] span;
		protected Color[][] foreground;
		protected Color[][] background;
		protected Font[][] font;

		public TreeTableCellAttribute() {
			this(1, 1);
		}

		public TreeTableCellAttribute(int numRows, int numColumns) {
			setSize(new Dimension(numColumns, numRows));
		}

		public void setSize(Dimension size) {
			columnSize = size.width;
			rowSize = size.height;
			span = new int[rowSize][columnSize][2]; // 2: COLUMN,ROW
			foreground = new Color[rowSize][columnSize];
			background = new Color[rowSize][columnSize];
			font = new Font[rowSize][columnSize];
			initValue();
		}

		public Dimension getSize() {
			return new Dimension(rowSize, columnSize);
		}

		protected void initValue() {
			for (int i = 0; i < span.length; i++) {
				for (int j = 0; j < span[i].length; j++) {
					span[i][j][TreeTableCellAttribute.COLUMN] = 1;
					span[i][j][TreeTableCellAttribute.ROW] = 1;
				}
			}
		}

		public int[] getSpan(int row, int column) {
			if (isOutOfBounds(row, column)) {
				int[] ret_code = { 1, 1 };
				return ret_code;
			}
			return span[row][column];
		}

		public void setSpan(int[] span, int row, int column) {
			if (isOutOfBounds(row, column)) {
				return;
			}
			this.span[row][column] = span;
		}

		public boolean isVisible(int row, int column) {
			if (isOutOfBounds(row, column)) {
				return false;
			}
			if (
				(span[row][column][TreeTableCellAttribute.COLUMN] < 1)
				|| (span[row][column][TreeTableCellAttribute.ROW] < 1)
			) {
				return false;
			}
			return true;
		}

		public void combine(int[] rows, int[] columns) {
			if (isOutOfBounds(rows, columns)) {
				return;
			}
			int rowSpan = rows.length;
			int columnSpan = columns.length;
			int startRow = rows[0];
			int startColumn = columns[0];
			for (int i = 0; i < rowSpan; i++) {
				for (int j = 0; j < columnSpan; j++) {
					if (
						(span[startRow + i][startColumn + j][TreeTableCellAttribute.COLUMN] != 1)
						|| (span[startRow + i][startColumn + j][TreeTableCellAttribute.ROW] != 1)
					) {
						return;
					}
				}
			}
			for (int i = 0, ii = 0; i < rowSpan; i++, ii--) {
				for (int j = 0, jj = 0; j < columnSpan; j++, jj--) {
					span[startRow + i][startColumn + j][TreeTableCellAttribute.COLUMN] = jj;
					span[startRow + i][startColumn + j][TreeTableCellAttribute.ROW] = ii;
				}
			}
			span[startRow][startColumn][TreeTableCellAttribute.COLUMN] = columnSpan;
			span[startRow][startColumn][TreeTableCellAttribute.ROW] = rowSpan;

		}

		public void split(int row, int column) {
			if (isOutOfBounds(row, column)) {
				return;
			}
			int columnSpan = span[row][column][TreeTableCellAttribute.COLUMN];
			int rowSpan = span[row][column][TreeTableCellAttribute.ROW];
			for (int i = 0; i < rowSpan; i++) {
				for (int j = 0; j < columnSpan; j++) {
					span[row + i][column + j][TreeTableCellAttribute.COLUMN] = 1;
					span[row + i][column + j][TreeTableCellAttribute.ROW] = 1;
				}
			}
		}

		public Color getForeground(int row, int column) {
			if (isOutOfBounds(row, column)) {
				return null;
			}
			return foreground[row][column];
		}

		public void setForeground(Color color, int row, int column) {
			if (isOutOfBounds(row, column)) {
				return;
			}
			foreground[row][column] = color;
		}

		public void setForeground(Color color, int[] rows, int[] columns) {
			if (isOutOfBounds(rows, columns)) {
				return;
			}
			setValues(foreground, color, rows, columns);
		}

		public Color getBackground(int row, int column) {
			if (isOutOfBounds(row, column)) {
				return null;
			}
			return background[row][column];
		}

		public void setBackground(Color color, int row, int column) {
			if (isOutOfBounds(row, column)) {
				return;
			}
			background[row][column] = color;
		}

		public void setBackground(Color color, int[] rows, int[] columns) {
			if (isOutOfBounds(rows, columns)) {
				return;
			}
			setValues(background, color, rows, columns);
		}

		public Font getFont(int row, int column) {
			if (isOutOfBounds(row, column)) {
				return null;
			}
			return font[row][column];
		}

		public void setFont(Font font, int row, int column) {
			if (isOutOfBounds(row, column)) {
				return;
			}
			this.font[row][column] = font;
		}

		public void setFont(Font font, int[] rows, int[] columns) {
			if (isOutOfBounds(rows, columns)) {
				return;
			}
			setValues(this.font, font, rows, columns);
		}

		public void addColumn() {
			int[][][] oldSpan = span;
			int numRows = oldSpan.length;
			int numColumns = oldSpan[0].length;
			span = new int[numRows][numColumns + 1][2];
			System.arraycopy(oldSpan, 0, span, 0, numRows);
			for (int i = 0; i < numRows; i++) {
				span[i][numColumns][TreeTableCellAttribute.COLUMN] = 1;
				span[i][numColumns][TreeTableCellAttribute.ROW] = 1;
			}
		}

		public void addRow() {
			int[][][] oldSpan = span;
			int numRows = oldSpan.length;
			int numColumns = oldSpan[0].length;
			span = new int[numRows + 1][numColumns][2];
			System.arraycopy(oldSpan, 0, span, 0, numRows);
			for (int i = 0; i < numColumns; i++) {
				span[numRows][i][TreeTableCellAttribute.COLUMN] = 1;
				span[numRows][i][TreeTableCellAttribute.ROW] = 1;
			}
		}

		public void insertRow(int row) {
			int[][][] oldSpan = span;
			int numRows = oldSpan.length;
			int numColumns = oldSpan[0].length;
			span = new int[numRows + 1][numColumns][2];
			if (0 < row) {
				System.arraycopy(oldSpan, 0, span, 0, row - 1);
			}
			System.arraycopy(oldSpan, 0, span, row, numRows - row);
			for (int i = 0; i < numColumns; i++) {
				span[row][i][TreeTableCellAttribute.COLUMN] = 1;
				span[row][i][TreeTableCellAttribute.ROW] = 1;
			}
		}

		protected boolean isOutOfBounds(int row, int column) {
			if ((row < 0) || (rowSize <= row) || (column < 0) || (columnSize <= column)) {
				return true;
			}
			return false;
		}

		protected boolean isOutOfBounds(int[] rows, int[] columns) {
			for (int i = 0; i < rows.length; i++) {
				if ((rows[i] < 0) || (rowSize <= rows[i])) {
					return true;
				}
			}
			for (int i = 0; i < columns.length; i++) {
				if ((columns[i] < 0) || (columnSize <= columns[i])) {
					return true;
				}
			}
			return false;
		}

		protected void setValues(Object[][] target, Object value, int[] rows, int[] columns) {
			for (int i = 0; i < rows.length; i++) {
				int row = rows[i];
				for (int j = 0; j < columns.length; j++) {
					int column = columns[j];
					target[row][column] = value;
				}
			}
		}
	}

	//======================================================
	// TreeTableAttributiveTableUI
	//======================================================

	private class TreeTableAttributiveTableUI extends BasicTableUI {

		public void paint(Graphics g, JComponent c) {
			Rectangle oldClipBounds = g.getClipBounds();
			Rectangle clipBounds = new Rectangle(oldClipBounds);
			int tableWidth = table.getColumnModel().getTotalColumnWidth();
			clipBounds.width = Math.min(clipBounds.width, tableWidth);
			g.setClip(clipBounds);

			int firstIndex = table.rowAtPoint(new Point(0, clipBounds.y));
			int lastIndex = table.getRowCount() - 1;

			Rectangle rowRect = new Rectangle(0, 0, tableWidth, table.getRowHeight() + table.getRowMargin());
			rowRect.y = firstIndex * rowRect.height;

			for (int index = firstIndex; index <= lastIndex; index++) {
				if (rowRect.intersects(clipBounds)) {
					paintRow(g, index);
				}
				rowRect.y += rowRect.height;
			}
			g.setClip(oldClipBounds);
		}

		private void paintRow(Graphics g, int row) {
			Rectangle rect = g.getClipBounds();
			boolean drawn = false;

			int numColumns = table.getColumnCount();

			for (int column = 0; column < numColumns; column++) {
				Rectangle cellRect = table.getCellRect(row, column, true);
				int cellRow, cellColumn;
				if (cellAttributs.isVisible(row, column)) {
					cellRow = row;
					cellColumn = column;
				} else {
					cellRow = row + cellAttributs.getSpan(row, column)[0];
					cellColumn = column + cellAttributs.getSpan(row, column)[1];
				}
				if (cellRect.intersects(rect)) {
					drawn = true;
					paintCell(g, cellRect, cellRow, cellColumn);
				} else if (drawn) {
					break;
				}
			}
		}

		private void paintCell(Graphics g, Rectangle cellRect, int row, int column) {
			int spacingHeight = table.getRowMargin();
			int spacingWidth = table.getColumnModel().getColumnMargin();

			Color c = g.getColor();
			g.setColor(table.getGridColor());
			g.drawRect(cellRect.x, cellRect.y, cellRect.width - 1, cellRect.height - 1);
			g.setColor(c);

			cellRect.setBounds(
				cellRect.x + spacingWidth / 2,
				cellRect.y + spacingHeight / 2,
				cellRect.width - spacingWidth,
				cellRect.height - spacingHeight
			);

			if (table.isEditing() && table.getEditingRow() == row && table.getEditingColumn() == column) {
				Component component = table.getEditorComponent();
				component.setBounds(cellRect);
				component.validate();
			} else {
				TableCellRenderer renderer = table.getCellRenderer(row, column);
				Component component = table.prepareRenderer(renderer, row, column);

				if (component.getParent() == null) {
					rendererPane.add(component);
				}
				rendererPane.paintComponent(
					g,
					component,
					table,
					cellRect.x,
					cellRect.y,
					cellRect.width,
					cellRect.height,
					true
				);
			}
		}
	}

	//############################################################################
	//
	// CheckboxTree
	//
	//############################################################################

	public static class CheckboxTree extends JTree {

		private static final long serialVersionUID = 1L;

		private static final int NOT_SELECTED = 0;
		private static final int PART_SELECTED = 1;
		private static final int ALL_SELECTED = 2;

		private Map<TreeNode, Integer> groups = new HashMap<TreeNode, Integer>();
		private List<TreeNode> items = new ArrayList<TreeNode>();

		private List<CheckboxTreeListener> listeners = new ArrayList<CheckboxTreeListener>();

		private TreePath selectionPath = null;
		private boolean showCheckBox = true;
		private boolean adjust = false;
		private boolean adjustListeners = false;

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public CheckboxTree() {
			super();
			init();
		}

		public CheckboxTree(Object[] value) {
			super(value);
			init();
		}

		public CheckboxTree(Vector<Object> value) {
			super(value);
			init();
		}

		public CheckboxTree(Hashtable<Object, Object> value) {
			super(value);
			init();
		}

		public CheckboxTree(TreeNode root) {
			super(root);
			init();
		}

		public CheckboxTree(TreeNode root, boolean ac) {
			super(root, ac);
			init();
		}

		public CheckboxTree(TreeModel newModel) {
			super(newModel);
			init();
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public void setModel(TreeModel model) {
			adjust = true;
			super.setModel(model);
			adjust = false;
			model.addTreeModelListener(new TTreeModelListener());
			prepareNodes();
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		private void init() {
			getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
			getModel().addTreeModelListener(new TTreeModelListener());
			addTreeSelectionListener(new TTreeSelectionListener());
			addKeyListener(new TTreeKeyAdapter());
			addMouseListener(new TTreeMouseAdapter());
			setRootVisible(true);
			setShowsRootHandles(true);
			setCellRenderer(new TTreeCellRenderer());
			prepareNodes();
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public void setShowCheckBox(boolean show) {
			showCheckBox = show;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public boolean getShowCheckBox() {
			return showCheckBox;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public boolean getShowCheckBox(TreeNode node) {
			return getShowCheckBox();
		}

		/**
		 * Part-Selection retrieves true also
		 *
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public boolean isChecked(TreeNode node) {
			Integer m = groups.get(node);
			return items.contains(node) || (m != null && !m.equals(NOT_SELECTED));
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		protected void checkAll(boolean check) {

			TreeNode root = (TreeNode) getModel().getRoot();

			if (root.getChildCount() > 0) {

				if (adjust && !check) {
					return;
				}

				clearChecks();
				if (check) {
					doCheck(ALL_SELECTED, root, null);
					informListeners(root, ALL_SELECTED);
				}
				prepareNodes();
				revalidate();
			}
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		protected void check(TreeNode node, boolean check) {
			if (check) {
				check(node);
			} else {
				uncheck(node);
			}
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		protected void check(TreeNode node) {
			doCheck(ALL_SELECTED, node, node);
			prepareNodes();
			revalidate();
			informListeners(node, ALL_SELECTED);
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		protected void uncheck(TreeNode node) {
			doCheck(NOT_SELECTED, node, node);
			prepareNodes();
			revalidate();
			informListeners(node, NOT_SELECTED);
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		protected void check(TreeNode[] nodes) {
			if (nodes != null && nodes.length > 0) {
				clearChecks();
				for (TreeNode node : nodes) {
					doCheck(ALL_SELECTED, node, node);
					informListeners(node, ALL_SELECTED);
				}
				prepareNodes();
				revalidate();
			}
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		protected void check(List<TreeNode> nodes) {
			clearChecks();
			for (TreeNode node : nodes) {
				doCheck(ALL_SELECTED, node, node);
				informListeners(node, ALL_SELECTED);
			}
			prepareNodes();
			revalidate();
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public TreeNode getCheckedNodes() {
			return doGetCheckedNodes((DefaultMutableTreeNode) getModel().getRoot());
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		private TreeNode doGetCheckedNodes(DefaultMutableTreeNode node) {

			Integer m = groups.get(node);

			if (m == null || m.equals(NOT_SELECTED)) {
				return null;
			}

			DefaultMutableTreeNode grp = new DefaultMutableTreeNode(node.getUserObject());
			@SuppressWarnings("rawtypes")
			Enumeration en = node.children();

			while (en.hasMoreElements()) {
				DefaultMutableTreeNode item = (DefaultMutableTreeNode) en.nextElement();
				if (item.isLeaf() && items.contains(item)) {
					DefaultMutableTreeNode newItem = new DefaultMutableTreeNode(item.getUserObject());
					grp.add(newItem);
				} else if (!item.isLeaf()) {
					DefaultMutableTreeNode child = (DefaultMutableTreeNode) doGetCheckedNodes(item);
					if (child != null) {
						grp.add(child);
					}
				}
			}
			return grp;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public void removeChecks() {

			adjust = true;
			DefaultTreeModel model = (DefaultTreeModel) getModel();
			List<Object> v1 = new ArrayList<Object>();
			List<Object> v2 = new ArrayList<Object>();

			for (Iterator<TreeNode> it = items.iterator(); it.hasNext();) {
				MutableTreeNode itm = (MutableTreeNode) it.next();
				model.removeNodeFromParent(itm);
				v1.add(itm);
			}

			for (Iterator<TreeNode> it = groups.keySet().iterator(); it.hasNext();) {
				MutableTreeNode grp = (MutableTreeNode) it.next();
				Integer sm = groups.get(grp);
				if (sm.equals(ALL_SELECTED) && grp.getParent() != null) {
					model.removeNodeFromParent(grp);
					v2.add(sm);
				}
			}

			for (int i = 0; i < v1.size(); i++) {
				items.remove(v1.get(i));
			}

			for (int i = 0; i < v2.size(); i++) {
				groups.remove(v2.get(i));
			}

			adjust = false;
			prepareNodes();
			model.reload();
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		private void clearChecks() {
			groups.clear();
			items.clear();
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		private void prepareNodes() {
			if (groups != null && items != null) {
				doPrepareNodes((TreeNode) getModel().getRoot());
			}
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		private void doPrepareNodes(TreeNode node) {
			int not = 0;
			int all = 0;
			int con = 0;
			@SuppressWarnings("rawtypes")
			Enumeration en = node.children();
			while (en.hasMoreElements()) {
				TreeNode no = (TreeNode) en.nextElement();
				con++;
				if (no.isLeaf()) {
					if (items.contains(no)) {
						all++;
					} else {
						not++;
					}
				} else {
					doPrepareNodes(no);
					Integer m = groups.get(no);
					if (m.equals(NOT_SELECTED)) {
						not++;
					}

					if (m.equals(ALL_SELECTED)) {
						all++;
					}
				}
			}

			Integer m = not == con ? NOT_SELECTED : (all == con ? ALL_SELECTED : PART_SELECTED);
			groups.put(node, m);
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		protected List<TreeNode> getCheckedGroups() {
			List<TreeNode> nodes = new ArrayList<TreeNode>();
			for (TreeNode key : groups.keySet()) {
				if (!groups.get(key).equals(NOT_SELECTED)) {
					nodes.add(key);
				}
			}
			return nodes;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		protected List<TreeNode> getCheckedItems() {
			return items;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		protected List<TreeNode> getAllChecked() {
			List<TreeNode> nodes = getCheckedGroups();
			nodes.addAll(items);
			return nodes;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public int getCheckedCount() {

			//return getCheckedGroups().size() + getCheckedItems().size();
			return getCheckedItems().size();
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public void addCheckBoxTreeListener(CheckboxTreeListener listener) {
			listeners.add(listener);
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public void removeCheckBoxTreeListener(CheckboxTreeListener listener) {
			listeners.remove(listener);
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		private void doCheck(Integer mode, TreeNode group, TreeNode item) {

			groups.put(group, mode);
			@SuppressWarnings("rawtypes")
			Enumeration en = group.children();

			switch (mode) {

				case NOT_SELECTED :
					if (item != null && item.isLeaf()) {
						items.remove(item);
					} else {
						while (en.hasMoreElements()) {
							TreeNode it = (TreeNode) en.nextElement();
							if (it.isLeaf()) {
								if (items.contains(it)) {
									items.remove(it);
								}
							} else {
								doCheck(mode, it, null);
							}
						}
					}
					break;

				case PART_SELECTED :
					if (item == null) {
						doCheck(NOT_SELECTED, group, null);
					} else {
						int n = 0, k = 0;
						while (en.hasMoreElements()) {
							TreeNode it = (TreeNode) en.nextElement();
							if (it.isLeaf()) {
								if (items.contains(it)) {
									n++;
								}
							} else {
								Integer m = groups.get(it);
								if (m.equals(ALL_SELECTED)) {
									n++;
								} else if (m.equals(PART_SELECTED)) {
									k = 1;
								}
							}
						}

						if (items.contains(item)) {
							if (n == 1 && k == 0) {
								doCheck(NOT_SELECTED, group, null);
							}
							items.remove(item);

						} else {
							if (n == group.getChildCount() - 1) {
								doCheck(ALL_SELECTED, group, null);
							} else {
								items.add(item);
							}
						}
					}

					break;

				case ALL_SELECTED :
					if (item != null && item.isLeaf()) {
						items.add(item);
					} else {

						while (en.hasMoreElements()) {
							TreeNode it = (TreeNode) en.nextElement();
							if (it.isLeaf()) {
								if (!items.contains(it)) {
									items.add(it);
								}
							} else {
								doCheck(mode, it, null);
							}
						}
					}
					break;
			}
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		private void checkParents(TreeNode group) {

			TreeNode parent = group.getParent();
			if (parent == null) {
				return;
			}
			int not = 0;
			int all = 0;
			int count = 0;

			@SuppressWarnings("rawtypes")
			Enumeration en = parent.children();
			while (en.hasMoreElements()) {
				TreeNode it = (TreeNode) en.nextElement();
				count++;
				if (it.isLeaf()) {
					if (items.contains(it)) {
						all++;
					} else {
						not++;
					}
				} else {
					Integer m = groups.get(it);
					if (m.equals(NOT_SELECTED)) {
						not++;
					}
					if (m.equals(ALL_SELECTED)) {
						all++;
					}
				}
			}

			Integer m = not == count ? NOT_SELECTED : (all == count ? ALL_SELECTED : PART_SELECTED);
			groups.put(parent, m);
			checkParents(parent);
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		private void changeCheck(TreePath path) {

			TreeTableNode node = (TreeTableNode) path.getLastPathComponent();

			if (!isEnabled(node) || !getShowCheckBox(node)) {
				return;
			}

			TreeNode item = null;
			TreeNode group = null;

			if (node.isLeaf()) {
				item = node;
			}

			group = item == null ? node : item.getParent();

			if (group != null) {

				int sel = -1;

				switch (groups.get(group)) {

					case NOT_SELECTED :
						if (item != null) {
							doCheck(PART_SELECTED, group, item);
							sel = PART_SELECTED;
						} else {
							doCheck(ALL_SELECTED, group, null);
							sel = ALL_SELECTED;
						}
						break;

					case ALL_SELECTED :

						if (item != null) {
							doCheck(PART_SELECTED, group, item);
							sel = PART_SELECTED;
						} else {
							doCheck(NOT_SELECTED, group, null);
							sel = NOT_SELECTED;
						}
						break;

					case PART_SELECTED :
						doCheck(PART_SELECTED, group, item);
						sel = PART_SELECTED;
						break;
				}

				informListeners(node, node.isChecked() ? NOT_SELECTED : ALL_SELECTED);
				informListeners(group, sel);

				checkParents(group);
				revalidate();
			}
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		protected boolean isEnabled(TreeNode node) {
			return true;
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		private void informListeners(TreeNode node, int changeState) {
			if (!adjustListeners) {
				adjustListeners = true;
				doInformListeners(node, changeState);
				adjustListeners = false;
			}
		}

		private void doInformListeners(TreeNode node, int changeState) {
			for (CheckboxTreeListener listener : listeners) {
				listener.checkBoxValueChanged(this, node, changeState);
			}

			// inform children only if all or not selected
			if (changeState != PART_SELECTED) {
				@SuppressWarnings("rawtypes")
				Enumeration en = node.children();
				while (en.hasMoreElements()) {
					doInformListeners((TreeNode) en.nextElement(), changeState);
				}
			}
		}

		/*
		 * Icons zur Darstellung von CheckBox
		 *
		 */

//      private static final Icon checkedIcon1 = new CheckBoxIcon(1, true);
//      private static final Icon uncheckedIcon1 = new CheckBoxIcon(1, false);
//      private static final Icon partcheckedIcon1 = new CheckBoxIcon(2, true);

		private static final Icon checkedIcon = JTreeTableX.getImage("checkboxOn.gif");
		private static final Icon uncheckedIcon = JTreeTableX.getImage("checkboxOff.gif");
		private static final Icon partcheckedIcon = JTreeTableX.getImage("checkboxPartOn.gif");

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		protected Icon getCheckedIcon(Icon icon) {
			return icon == null ? checkedIcon : new DoubleIcon(checkedIcon, icon);
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		protected Icon getUncheckedIcon(Icon icon) {
			return icon == null ? uncheckedIcon : new DoubleIcon(uncheckedIcon, icon);
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		protected Icon getPartCheckedIcon(Icon icon) {
			return icon == null ? partcheckedIcon : new DoubleIcon(partcheckedIcon, icon);
		}

		/**
		 * @param
		 *
		 * @exception
		 *
		 * @return
		 *
		 * @see
		 */
		public Icon createDoubleIcon(Object value, boolean leaf, Icon icon1) {

			Icon icon2 = icon1;

			// should checkbox icons be displayed ?
			if (getShowCheckBox() && getShowCheckBox((TreeNode) value)) {

				// do not display icons in internal adjusting mode
				if (!adjust) {

					if (leaf) {
						if (items.contains(value)) {
							icon2 = getCheckedIcon(icon1);
						} else {
							icon2 = getUncheckedIcon(icon1);
						}
					} else {
						Integer m = groups.get(value);

						if (m != null) {
							switch (m) {

								case (ALL_SELECTED) :
									icon2 = getCheckedIcon(icon1);
									break;

								case NOT_SELECTED :
									icon2 = getUncheckedIcon(icon1);
									break;

								case PART_SELECTED :
									icon2 = getPartCheckedIcon(icon1);
									break;
							}
						}
					}
				}
			}

			return icon2;
		}

		//==============================================
		// TTreeKeyAdapter
		//==============================================
		private class TTreeKeyAdapter extends KeyAdapter {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SPACE) {
					if (!isSelectionEmpty()) {
						selectionPath = getSelectionPath();
					}
					changeCheck(selectionPath);
				}
			}
		}

		//==============================================
		// TTreeMouseAdapter
		//==============================================
		private class TTreeMouseAdapter extends MouseAdapter {
			public void mousePressed(MouseEvent e) {
				TreePath path = getPathForLocation(e.getX(), e.getY());
				if (path != null && SwingUtilities.isLeftMouseButton(e)) {
					changeCheck(path);
				}
			}
		}

		//==============================================
		// TTreeSelectionListener
		//==============================================
		private class TTreeSelectionListener implements TreeSelectionListener {
			public void valueChanged(TreeSelectionEvent e) {
				if (e.getNewLeadSelectionPath() == null) {
					setSelectionPath(selectionPath);
				}
			}
		}

		//==============================================
		// TTreeModelListener
		//==============================================
		private class TTreeModelListener implements TreeModelListener {

			@Override
			public void treeNodesChanged(TreeModelEvent e) {
				checkAll(false);
			}

			@Override
			public void treeNodesInserted(TreeModelEvent e) {
				checkAll(false);
			}

			@Override
			public void treeNodesRemoved(TreeModelEvent e) {
				checkAll(false);
			}

			@Override
			public void treeStructureChanged(TreeModelEvent e) {
				checkAll(false);
			}
		}

		//==============================================
		// CheckboxTreeListener
		//==============================================
		static interface CheckboxTreeListener extends EventListener {
			void checkBoxValueChanged(JTree tree, TreeNode node, int checkState);
		}

		//==============================================
		// TTreeCellRenderer
		//==============================================
		private class TTreeCellRenderer extends DefaultTreeCellRenderer {

			private static final long serialVersionUID = 1L;

			private Icon selectedOpenIcon = getCheckedIcon(getOpenIcon());
			private Icon selectedClosedIcon = getCheckedIcon(getClosedIcon());
			private Icon unselectedOpenIcon = getUncheckedIcon(getOpenIcon());
			private Icon unselectedClosedIcon = getUncheckedIcon(getClosedIcon());
			private Icon partselectedOpenIcon = getPartCheckedIcon(getOpenIcon());
			private Icon partselectedClosedIcon = getPartCheckedIcon(getClosedIcon());

			@Override
			public Component getTreeCellRendererComponent(
				JTree   tree,
				Object  value,
				boolean sel,
				boolean expanded,
				boolean leaf,
				int		row,
				boolean hasFocus
			) {
				JLabel label =
					(JLabel) super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

				Object object = ((DefaultMutableTreeNode) value).getUserObject();
				label.setText(object == null ? "" : object.toString());

				// should icons be displayed ?
				if (!showCheckBox) {
					return label;
				}

				// do not display icons in internal adjusting mode
				if (adjust) {
					label.setIcon(unselectedClosedIcon);
					return label;
				}

				if (leaf) {
					if (items.contains(value)) {
						label.setIcon(checkedIcon);
					} else {
						label.setIcon(uncheckedIcon);
					}
				} else {
					Integer m = groups.get(value);
					if (m != null) {
						switch (m) {

							case ALL_SELECTED :
								if (expanded) {
									setIcon(selectedOpenIcon);
								} else {
									setIcon(selectedClosedIcon);
								}

								break;

							case NOT_SELECTED :
								setIcon(uncheckedIcon);
								if (expanded) {
									setIcon(unselectedOpenIcon);
								} else {
									setIcon(unselectedClosedIcon);
								}

								break;

							case PART_SELECTED :
								if (expanded) {
									setIcon(partselectedOpenIcon);
								} else {
									setIcon(partselectedClosedIcon);
								}
								break;
						}
					}
				}

				return label;
			}
		}

		//==============================================
		// CheckBoxIcon
		//==============================================

		protected static class CheckBoxIcon implements Icon {

			private static final int csize = 13;
			private int mode = 1;
			private boolean selected = false;

			public CheckBoxIcon(int mode, boolean selected) {
				this.mode = mode;
				this.selected = selected;
			}

			@Override
			public void paintIcon(Component c, Graphics g, int x, int y) {
				g.setColor(new Color(0xC0C0C0));
				g.fill3DRect(x, y, csize, csize, false);
				g.setColor(new Color(0x808080));
				g.fill3DRect(x + 1, y + 1, csize - 2, csize - 2, false);
				g.setColor(new Color(mode == 1 ? 0xFFFFFF : 0xC0C0C0));
				g.fillRect(x + 2, y + 2, csize - 4, csize - 4);
				g.setColor(new Color(0x000000));
				if (selected) {
					g.drawLine(x + 9, y + 3, x + 9, y + 3);
					g.drawLine(x + 8, y + 4, x + 9, y + 4);
					g.drawLine(x + 7, y + 5, x + 9, y + 5);
					g.drawLine(x + 6, y + 6, x + 8, y + 6);
					g.drawLine(x + 3, y + 7, x + 7, y + 7);
					g.drawLine(x + 4, y + 8, x + 6, y + 8);
					g.drawLine(x + 5, y + 9, x + 5, y + 9);
					g.drawLine(x + 3, y + 5, x + 3, y + 5);
					g.drawLine(x + 3, y + 6, x + 4, y + 6);
				}
			}

			@Override
			public int getIconWidth() {
				return csize;
			}

			@Override
			public int getIconHeight() {
				return csize;
			}
		}

		//==============================================
		// DoubleIcon
		//==============================================

		private static class DoubleIcon implements Icon {

			private Icon leftIcon = null;
			private Icon rightIcon = null;
			private int gap = 3;

			public DoubleIcon(Icon leftIcon, Icon rightIcon) {
				this.leftIcon = leftIcon;
				this.rightIcon = rightIcon;
			}

			@Override
			public void paintIcon(Component c, Graphics g, int x, int y) {
				int leftIconHeight = leftIcon.getIconHeight();
				int rightIconHeight = rightIcon.getIconHeight();
				int leftYOffset = 0;
				int rightYOffset = 0;
				if (leftIconHeight < rightIconHeight) {
					leftYOffset = (rightIconHeight - leftIconHeight) / 2;
				}

				if (rightIconHeight < leftIconHeight) {
					rightYOffset = (leftIconHeight - rightIconHeight) / 2;
				}

				leftIcon.paintIcon(c, g, x, y + leftYOffset);
				rightIcon.paintIcon(c, g, x + leftIcon.getIconWidth() + gap, y + rightYOffset);
			}

			@Override
			public int getIconWidth() {
				return leftIcon.getIconWidth() + gap + rightIcon.getIconWidth();
			}

			@Override
			public int getIconHeight() {
				return Math.max(leftIcon.getIconHeight(), rightIcon.getIconHeight());
			}
		}
	}

	//====

	public static class FlatTreeTable extends JTreeTableX {

		private static final long serialVersionUID = 1L;

		public FlatTreeTable(String[] columnNames, Object[][] data) {
			super(columnNames);

			this.setShowHeaderMenu(false);
			this.setRowHeight(20);
			this.setShowAlternateColor(true);
			this.setShowGroupSelection(false);
			this.setShowPartSelection(false);
			this.setShowHeaderMenu(false);
			this.setShowExCoButtons(false);
			this.setShowCheckBox(false);
			this.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
			this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

			isFlatTable = true;

			setData(data);
		}

		public void setData(Object[][] data) {
			List<FlatNode> nodes = new ArrayList<FlatNode>();
			for (int i = 0; i < data.length; i++) {
				nodes.add(new FlatNode(data[i]));
			}
			init(nodes);
		}

		public static class FlatNode extends TreeTableNode {
			private static final long serialVersionUID = 1L;
			private Object[] data;

			public FlatNode() {
			}

			public FlatNode(Object[] data) {
				this.data = data;
			}

			@Override
			public void copy(TreeTableNode node) {
				FlatNode at = (FlatNode) node;
				this.data = at.data;
			}

			@Override
			public String createNodeName() {
				return data == null ? "" : data[0].toString();
			}

			@Override
			public Object getValue(int column) {
				return data == null ? null : data[column];
			}

			@Override
			public Object[] getValues() {
				return data;
			}

			@Override
			public ImageIcon getIcon() {
				return null;
			}

			@Override
			public boolean isCheckable() {
				return true;
			}
		}
	}

	//====

	/**
	 * @param   name
	 *
	 * @return  ImageIcon
	 */
	private static ImageIcon getImage(String name) {

		//URL url = JTreeTable.class.getResource("../images/" + name);
		URL url = Helper.class.getResource("images/" + name);
		try {
			BufferedImage img = ImageIO.read(url);
			return new ImageIcon(img);
		} catch (Exception ex) {
			System.out.println("===========>>>> Image not found (" + name + ") " + url);
		}
		return null;
	}

	/**
	 * @author  Admin
	 */
	private static class JPopup {

		private JDialog currentPopup;
		private Map<JDialog, VetoableChangeListener> popups = new HashMap<JDialog, VetoableChangeListener>();
		private static Dimension screenSize;

		static {
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			GraphicsDevice[] gs = ge.getScreenDevices();
			int w = 0;
			int h = 0;
			for (int i = 0; i < gs.length; i++) {
				DisplayMode dm = gs[i].getDisplayMode();
				w += dm.getWidth();
				h = Math.max(dm.getHeight(), h);
			}
			screenSize = new Dimension(w, h);
		}

		/**
		 * @param  comp
		 * @param  content
		 * @param  x
		 * @param  y
		 * @param  width
		 * @param  height
		 */
		public void open(Component comp, Component content, int x, int y, int width, int height) {
			Component cm = comp;
			Window parent = null;
			while (cm != null) {
				if (cm.getParent() instanceof Window) {
					parent = (Window) cm.getParent();
					break;
				}
				cm = cm.getParent();
			}

			final JDialog popup =
				new JDialog(parent) {
					private static final long serialVersionUID = 1L;

					@Override
					public JRootPane createRootPane() {
						JRootPane rootPane = new JRootPane();
						KeyStroke stroke = KeyStroke.getKeyStroke("ESCAPE");
						InputMap inputMap = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
						inputMap.put(stroke, "ESCAPE");
						rootPane
							.getActionMap()
							.put(
								"ESCAPE",
								new AbstractAction() {
									private static final long serialVersionUID = 1L;

									@Override
									public void actionPerformed(ActionEvent e) {
										JPopup.this.close();
									}
								}
							);
						return rootPane;
					}
				};

			VetoableChangeListener vc =
				new VetoableChangeListener() {
					private boolean gained = false;

					@Override
					public void vetoableChange(PropertyChangeEvent ev) throws PropertyVetoException {
						if (ev.getNewValue() == popup) {
							gained = true;
						}
						if (gained && ev.getNewValue() != popup) {
							close(popup);
						}
					}
				};

			popups.put(popup, vc);

			currentPopup = popup;

			KeyboardFocusManager.getCurrentKeyboardFocusManager().addVetoableChangeListener("focusedWindow", vc);

			popup.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			popup.setModalityType(ModalityType.MODELESS);
			popup.setUndecorated(true);
			popup.getContentPane().add(content);
			popup.getRootPane().setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
//          popup.getRootPane().setWindowDecorationStyle(JRootPane.NONE);

			Point p = comp.getLocationOnScreen();
			x = p.x + x + width > screenSize.width ? screenSize.width - width : p.x + x;
			y = p.y + y + height > screenSize.height ? screenSize.height - height : p.y + y;
			if (x < 0) {
				x = 0;
			}

			popup.setPreferredSize(new Dimension(width, height));
			popup.setLocation(x, y);
			popup.pack();
			popup.setVisible(true);
		}

		/**
		 */
		public void close() {
			close(currentPopup);
		}

		/**
		 * @param  popup
		 */
		private void close(JDialog popup) {

			VetoableChangeListener vc = popups.get(popup);

			if (vc != null) {
				KeyboardFocusManager.getCurrentKeyboardFocusManager().removeVetoableChangeListener(vc);
				popups.remove(popup);
				popup.setVisible(false);
				popup.dispose();
				popup = null;
				popupClosed();
			}
		}

		protected void popupClosed() {
		}
	}
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
