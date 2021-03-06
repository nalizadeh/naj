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

package org.naj.java.ui.comps.treetable;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TreeExpansionEvent;
import javax.swing.event.TreeExpansionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.tree.DefaultTreeSelectionModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import org.naj.java.ui.comps.JPopup;

/**
 * <p>Title:</p>
 *
 * JTreeTable
 *
 * <p>Description:</p>
 *
 * TreeTable displays the hierarchical data in a tree within a table and provides for sorting, filtering and editing
 * data.
 *
 * <p>Copyright: Copyright (c) 2007 N.A.J</p>
 *
 * <p>Organization:</p>
 *
 * @author   Nader Alizadeh Janevislou
 * @version  1001.01
 */
public class JTreeTable extends JTable implements TreeExpansionListener {

	private static final long serialVersionUID = 1L;

	// Sorting
	public static final int SORTDIR_ASCENDING = 1;
	public static final int SORTDIR_DESCENDING = -1;
	public static final int SORTDIR_NO = 0;

	protected int sortingColumn = -1;
	protected int sortingDirection = SORTDIR_NO;

	// Comparators used by sorting
	private Map<Class<Object>, Comparator<Object>> defaultComparators =
		new HashMap<Class<Object>, Comparator<Object>>();

	private Map<Integer, Comparator<Object>> columnComparators = new HashMap<Integer, Comparator<Object>>();

	protected JButton headerMenuButton;
	protected JButton expandButton;
	protected JButton collapseButton;

	// Columns filters
	protected Map<Integer, JTreeTableFilterData> filterData = new HashMap<Integer, JTreeTableFilterData>();
	protected boolean filterByUser = false;

	// Controll vraiables
	protected int expandingLevel = 1;
	protected int headerRolloverIndex = -1;
	protected int bodyRolloverIndex = -1;
	protected int menuIndex = -1;

	// The model
	private JTreeTableModel model;

	// The tree within the table
	private JTreeTableTree tree;

	// The main renderer of table cells
	private JTreeTableCellRenderer renderer;

	// The main editor of table cells
	private JTreeTableCellEditor editor;

	// TreeTable listeners
	private List<JTreeTableListener> treeTablelisteners = new ArrayList<JTreeTableListener>();

	// TreeTable contextMenu
	protected JTreeTableContextMenu contextMenu;

	// TreeTable headermenu popup
	private JPopup popup;

	// Controll variables
	private JTreeTableProperties props;
	private boolean selectionAdjusting = false;

	// Realization of attributive TreeTable
	private JTreeTableCellAttribute cellAttributs;

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public JTreeTable(String[] columnNames) {
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
	public JTreeTable(String[] columnNames, List<String> viewColumns) {
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
	public JTreeTable(String[] columnNames, List<String> viewColumns, boolean attributive) {

		this.cellAttributs = attributive ? new JTreeTableCellAttribute() : null;
		this.props = new JTreeTableProperties();

		props.showAlternateColor = true;
		props.showRollover = true;
		props.showHeaderMenu = true;
		props.showExCoButtons = true;
		props.showPopupMenu = true;
		props.showDetailsPopup = false;
		props.showGroupSelection = true;
		props.showPartSelection = false;
		props.columnsConfigurable = true;
		props.isFlatTable = false;

		model = new JTreeTableModel(this, columnNames, viewColumns);

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
	public JTreeTableProperties getProperties() {
		return props;
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
		model.setViewColumns(columns, false);
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
		return model.getViewColumns();
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

		tree = new JTreeTableTree(this);
		tree.setRowHeight(getRowHeight());
		tree.setShowCheckBox(true);
		tree.addTreeExpansionListener(this);

		renderer = new JTreeTableCellRenderer();
		editor = new JTreeTableCellEditor(this);

		setModel(model);

		setColumnSelectionAllowed(false);
		setAutoResizeMode(AUTO_RESIZE_OFF);
		setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		setIntercellSpacing(new Dimension(1, 1));
		setSurrendersFocusOnKeystroke(true);
		setShowGrid(false);

		if (cellAttributs != null) {

			setUI(new JTreeTableAttributiveTableUI(cellAttributs));
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
						JTreeTableNode[] nodes = getSelectedNodes();
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

		JTreeTableMouseListener mListener = new JTreeTableMouseListener(this);
		addMouseMotionListener(mListener);
		addMouseListener(mListener);
		//addMouseWheelListener(mListener);

		addKeyListener(new JTreeTableKeyListener(this));

		JTreeTableHeaderListener headerListener = new JTreeTableHeaderListener(this);
		getTableHeader().addMouseListener(headerListener);
		getTableHeader().addMouseMotionListener(headerListener);

		TableColumnModel cmodel = getColumnModel();
		cmodel.addColumnModelListener(headerListener);

		Enumeration<TableColumn> columns = cmodel.getColumns();
		while (columns.hasMoreElements()) {
			TableColumn column = (TableColumn) columns.nextElement();
			column.setHeaderRenderer(new JTreeTableHeaderRenderer(this, column.getModelIndex()));
		}

		//=== header-buttons menu / expand / collapse

		final AbstractAction expandAction =
			new AbstractAction("", JTreeTableProperties.TT_PLO_ICON) {
				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent e) {
					if (expandingLevel < tree.getDepth()) {
						expandToLevel(expandingLevel + 1);
					}
				}
			};

		final AbstractAction collapseAction =
			new AbstractAction("", JTreeTableProperties.TT_MIN_ICON) {
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

		headerMenuButton = new JButton(JTreeTableProperties.TT_MEN_ICON);
		headerMenuButton.setContentAreaFilled(false);
		headerMenuButton.setFocusable(false);
		headerMenuButton.setBackground(JTreeTableProperties.H_BUTTON_BGC);
		headerMenuButton.setOpaque(true);
		headerMenuButton.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.GRAY));
		headerMenuButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		headerMenuButton.addMouseListener(mouseAdapter);

		expandButton = new JButton(expandAction);
		expandButton.setContentAreaFilled(false);
		expandButton.setFocusable(false);
		expandButton.setBackground(JTreeTableProperties.H_BUTTON_BGC);
		expandButton.setOpaque(true);
		expandButton.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.GRAY));
		expandButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		expandButton.setEnabled(false);
		expandButton.addMouseListener(mouseAdapter);

		collapseButton = new JButton(collapseAction);
		collapseButton.setContentAreaFilled(false);
		collapseButton.setFocusable(false);
		collapseButton.setBackground(JTreeTableProperties.H_BUTTON_BGC);
		collapseButton.setOpaque(true);
		collapseButton.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 0, Color.GRAY));
		collapseButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		collapseButton.setEnabled(false);
		collapseButton.addMouseListener(mouseAdapter);

		contextMenu = new JTreeTableContextMenu(this);
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
		init((JTreeTableNode) null);
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
	public void init(List<? extends JTreeTableNode> nodes) {
		tree.init(nodes == null ? new ArrayList<JTreeTableNode>() : nodes);
		postUpdate(nodes == null ? 0 : nodes.size(), model.columnNames.length);
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
	public void init(JTreeTableNode root) {
		tree.init(root);
		postUpdate(root == null || !root.hasChild() ? 0 : root.getChildren().size(), model.columnNames.length);
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
	public void update(List<? extends JTreeTableNode> nodes) {
		tree.update(nodes == null ? new ArrayList<JTreeTableNode>() : nodes);
		postUpdate(nodes.size(), model.columnNames.length);
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
	public void update(JTreeTableNode root, boolean setRoot) {
		tree.update(root, setRoot);
		postUpdate(root == null ? 0 : root.hasChild() ? root.getChildren().size() : 0, model.columnNames.length);
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
	public void update(JTreeTableNode root) {
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
		return (getColumnClass(editingColumn) == JTreeTableTree.class) ? -1 : editingRow;
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
		return model.isColumnVisible(column);
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
		props.showAlternateColor = show;
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
		props.showRollover = show;
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
		props.showHeaderMenu = show;
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
		props.showExCoButtons = show;
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
		props.showPopupMenu = show;
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
		props.showDetailsPopup = show;
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
		props.showGroupSelection = showGroupSelection;
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
		props.showPartSelection = showPartSelection;
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
		props.columnsConfigurable = columnsConfigurable;
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
	public JTreeTableContextMenu getContextMenu() {
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
	public JTreeTableNode getSelectedNode() {
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
	public JTreeTableNode[] getSelectedNodes() {
		JTreeTableNode[] nodes = new JTreeTableNode[0];
		int[] sels = getSelectedRows();
		if (sels != null && sels.length > 0) {
			nodes = new JTreeTableNode[sels.length];
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
	public void selectNodes(List<JTreeTableNode> selections) {
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
		JTreeTableNode[] nodes = getSelectedNodes();
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
	public JTreeTableNode getNodeAtRow(int row) {
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
	public JTreeTableNode getNodeByKey(String key) {
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
	public JTreeTableNode getNodeByName(String name) {
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
	public JTreeTableNode getNodeByName(String name, boolean caseSensitive) {
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
	public List<JTreeTableNode> getNodes() {
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
	public void deleteNode(JTreeTableNode node) {
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
	public void check(JTreeTableNode node, boolean check) {
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
	public void check(JTreeTableNode node) {
		JTreeTableNode no = getNodeByKey(node.getNodeKey());
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
	public void uncheck(JTreeTableNode node) {
		JTreeTableNode no = getNodeByKey(node.getNodeKey());
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
	public boolean isChecked(JTreeTableNode node) {
		JTreeTableNode no = getNodeByKey(node.getNodeKey());
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
	public void check(JTreeTableNode[] nodes) {
		List<TreeNode> newNodes = new ArrayList<TreeNode>();
		for (JTreeTableNode node : nodes) {
			JTreeTableNode no = getNodeByKey(node.getNodeKey());
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
	public void check(List<JTreeTableNode> nodes) {
		List<TreeNode> newNodes = new ArrayList<TreeNode>();
		for (JTreeTableNode node : nodes) {
			JTreeTableNode no = getNodeByKey(node.getNodeKey());
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
	public List<JTreeTableNode> getCheckedNodes() {
		List<TreeNode> nodes = tree.getAllChecked();
		List<JTreeTableNode> checkeds = new ArrayList<JTreeTableNode>();
		for (TreeNode node : nodes) {
			checkeds.add((JTreeTableNode) node);
		}
		return checkeds;
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
	public List<JTreeTableNode> getCheckedLeavs() {
		List<TreeNode> nodes = tree.getCheckedItems();
		List<JTreeTableNode> checkeds = new ArrayList<JTreeTableNode>();
		for (TreeNode node : nodes) {
			checkeds.add((JTreeTableNode) node);
		}
		return checkeds;
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
	public JTreeTableTree getTree() {
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
	public JTreeTableNode getRoot() {
		return tree.getRoot();
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
	public JTreeTableModel getTreeTableModel() {
		return (JTreeTableModel) getModel();
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
	public void expandNode(JTreeTableNode node) {
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
	public void collapseNode(JTreeTableNode node) {
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
	protected Comparator<Object> getComparator(int columnIndex) {
		Comparator<Object> comparator = columnComparators.get(columnIndex);
		if (comparator == null) {
			Class<?> cl = getModel().getColumnClass(columnIndex);
			comparator = defaultComparators.get(cl);
			if (comparator == null && cl != null) {
				comparator = defaultComparators.get(cl.getSuperclass());
			}
			if (comparator == null) {
				comparator = new JTreeTableComprator<Object>();
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
	protected void filter(Map<Integer, JTreeTableFilterData> filterData) {
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
		return r != -1 && getColumnClass(c) != JTreeTableTree.class;
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
	public List<JTreeTableNode> searchNodes(String text, boolean caseSensitive) {
		List<JTreeTableNode> rows = new ArrayList<>();
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
	public void addTreeTableListener(JTreeTableListener listener) {
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
	public void removeTreeTableListener(JTreeTableListener listener) {
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
		for (JTreeTableListener ls : treeTablelisteners) {
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
	public void nodesSelected(JTreeTableNode[] nodes) {
		for (JTreeTableListener ls : treeTablelisteners) {
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
		for (JTreeTableListener ls : treeTablelisteners) {
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
		for (JTreeTableListener ls : treeTablelisteners) {
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
	public void nodeCheckChanged(JTreeTableNode node) {
		if (node != null) {
			for (JTreeTableListener ls : treeTablelisteners) {
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
	protected void nodeChecked(JTreeTableNode node, int checkState) {
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
			((JTreeTableModel) getModel()).fireTableRowsUpdated(modelRow, modelRow);
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
	private void getFilterNodes(JTreeTableNode node, int column, List<String> filters) {
		Object key = node.getValue(column);
		if (key != null) {
			if (!filters.contains(key.toString())) {
				filters.add(key.toString());
			}
		}
		if (node.hasChild()) {
			for (JTreeTableNode child : node.getChildren()) {
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
	protected void openHeaderMenu(Component comp, int x, int y, int columnIndex) {

		Color MENU_COLOR = Color.WHITE;

		int MENU_WIDTH = 300;
		int MENU_HEIGHT = 384;

		final JButton btOk = new JButton("Ok");
		final JButton btCancel = new JButton("Abbrechen");

		menuIndex = columnIndex;

		JTreeTableFilterData.FilterColumnNode top = new JTreeTableFilterData.FilterColumnNode("top");
		JTreeTableFilterData.FilterColumnNode all = new JTreeTableFilterData.FilterColumnNode("Alles ausw‰hlen");

		top.addChild(all);

		List<String> filters = new ArrayList<String>();
		List<JTreeTableNode> checkeds = new ArrayList<JTreeTableNode>();
		getFilterNodes(
			filterData.containsKey(columnIndex) ? tree.getOriginRoot() : tree.getRoot(),
			columnIndex,
			filters
		);
		JTreeTableFilterData fd = filterData.get(columnIndex);

		if (!filters.isEmpty()) {
			if (filters.contains("")) {
				filters.remove("");
				JTreeTableFilterData.FilterColumnNode node = new JTreeTableFilterData.FilterColumnNode("Leer");
				all.addChild(node);
				if (fd != null && fd.filterNodes.contains("Leer")) {
					checkeds.add(node);
				}
			}
			for (String filter : filters) {
				if (!filter.isEmpty()) {
					JTreeTableFilterData.FilterColumnNode node = new JTreeTableFilterData.FilterColumnNode(filter);
					all.addChild(node);

					if (fd != null && fd.filterNodes.contains(filter)) {
						checkeds.add(node);
					}
				}
			}
		}

		final JTreeTable table =
			new JTreeTable(new String[] { "Auswahlliste" }) {
				private static final long serialVersionUID = 1L;

				final JTreeTable self = this;

				@Override
				public void nodeCheckChanged(JTreeTableNode node) {
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

		final JLabel lb1 = new JLabel(JTreeTableProperties.TT_ASC_ICON);
		final JLabel lb2 = new JLabel(JTreeTableProperties.TT_DES_ICON);
		final JLabel lb3 = new JLabel(JTreeTableProperties.TT_REM_SORT);
		final JLabel lb4 = new JLabel(JTreeTableProperties.TT_REM_FILT);
		final JLabel lb5 = new JLabel(JTreeTableProperties.TT_SER_ICON);
		final JLabel lb6 = new JLabel(JTreeTableProperties.TT_LIS_ICON);

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

						JTreeTableFilterData fd = new JTreeTableFilterData();

						String ft = (String) cbFilters.getSelectedItem();

						if (!ft.isEmpty() && !txt.getText().isEmpty()) {
							filterData.put(columnIndex, fd);
							fd.filterType = ft;
							fd.filterText = txt.getText();
						}

						if (table.getCheckedCount() > 0 && !table.isChecked(all)) {
							filterData.put(columnIndex, fd);
							List<JTreeTableNode> checkeds = table.getCheckedLeavs();
							for (JTreeTableNode n : checkeds) {
								if (!n.equals(all)) {
									fd.filterNodes.add(((JTreeTableFilterData.FilterColumnNode) n).name);
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
		panel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

		popup =
			new JPopup() {
				@Override
				public void popupClosed() {
					menuIndex = -1;
					getTableHeader().revalidate();
					getTableHeader().repaint();
				}
			};

		popup.open(comp, panel, x, y);
	}

	/**
	 * @param  menu
	 */
	private void closeHeaderMenu() {
		popup.close();
		popup = null;
	}

	//=====================================================================
	// Columns configurations
	//=====================================================================

	protected void configColumns(Component comp) {

		final JButton btOk = new JButton("Ok");
		final JButton btCancel = new JButton("Abbrechen");

		final JTreeTable table =
			new JTreeTable(new String[] { "Spalten" }) {
				private static final long serialVersionUID = 1L;

				final JTreeTable self = this;

				@Override
				public void nodeCheckChanged(JTreeTableNode node) {
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

		List<JTreeTableFilterData.FilterColumnNode> nodes = new ArrayList<JTreeTableFilterData.FilterColumnNode>();
		List<JTreeTableNode> checkeds = new ArrayList<JTreeTableNode>();

		for (String cs : model.columnNames) {
			JTreeTableFilterData.FilterColumnNode fn = new JTreeTableFilterData.FilterColumnNode(cs);
			nodes.add(fn);
			if (model.viewColumns.contains(cs)) {
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
					List<JTreeTableNode> nodes = table.getNodes();
					for (JTreeTableNode node : nodes) {
						if (!node.isRoot() && node.isChecked()) {
							columns.add(((JTreeTableFilterData.FilterColumnNode) node).name);
						}
					}

					setViewColumns(columns);
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
		p2.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

		popup =
			new JPopup() {
				@Override
				public void popupClosed() {
				}
			};

		popup.open(comp, p2, 10, 10);
	}

	//=====================================================================
	// Detail popup
	//=====================================================================

	protected void showDetailPopup(int row, MouseEvent event) {

		JTreeTableNode node = (JTreeTableNode) tree.getPathForRow(row).getLastPathComponent();

		String key = node.getNodeKey();
		String tt = key.startsWith("root.") ? key.substring(5) : key;

		final Object[] data = node.getValues();
		final String title = tt;
		final JPopupMenu popup = new JPopupMenu();

		DefaultTableModel dm =
			new DefaultTableModel(model.columnNames.length, 2) {

				private static final long serialVersionUID = 1L;

				public Object getValueAt(int r, int c) {
					return c == 0 ? model.columnNames[r] : data[r];
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
	protected void copySelectedData(JTable table, int row, int col) {

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
	protected void pasteSelectedData(JTable table, int row, int col) {
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
				System.out.println(data);
				table.setValueAt(data, row, col); // TODO
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
							table.setValueAt(value, startRow + i, startCol + j); // // TODO
						}
					}
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
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
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
