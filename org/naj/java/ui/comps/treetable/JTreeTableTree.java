/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.ui.comps.treetable;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Enumeration;
import java.util.List;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 * @author  P203125
 */
public class JTreeTableTree extends JTreeTableCheckboxTree implements JTreeTableCheckboxTree.CheckboxTreeListener {

	private static final long serialVersionUID = 1L;

	private JTreeTable treetable;
	private JTreeTableNode originRoot;
	private JTreeTableNode root;
	private DefaultTreeModel model;
	private int paintingRow;

	private List<JTreeTableNode> lastSelection;

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public JTreeTableTree(JTreeTable treetable) {
		this.treetable = treetable;
		this.originRoot = new JTreeTableNode();
		this.originRoot.setNodeParent(null);
		this.model = new DefaultTreeModel(originRoot);
		this.lastSelection = new ArrayList<JTreeTableNode>();

		setModel(model);
		setEditable(false);
		setRootVisible(false);
		setShowsRootHandles(true);
		setCellRenderer(new JTreeTableTreeCellRenderer(treetable));
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
	protected void init(JTreeTableNode root) {
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
	protected void init(List<? extends JTreeTableNode> nodes) {
		clear();
		originRoot.initChilds(nodes);
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
	protected void update(List<? extends JTreeTableNode> nodes) {
		originRoot.updateChilds(nodes);
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
	protected void update(JTreeTableNode rootNode, boolean setRoot) {
		if (setRoot) {
			this.originRoot = rootNode;
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
	protected void prepareData() {

		if (!treetable.getProperties().showHeaderMenu) {
			root = originRoot.clone();

		} else if (treetable.filterByUser) {
			if (!treetable.filterData.isEmpty()) {
				treetable.filter(treetable.filterData);
			}

		} else {

			root = originRoot.cloneToNode(null, true, true, false);

			if (!treetable.filterData.isEmpty()) {
				for (Integer columnIndex : treetable.filterData.keySet()) {
					root = doFilter(root, columnIndex, treetable.filterData.get(columnIndex));
				}
			}
		}

		if (treetable.sortingColumn != -1) {
			sort();
		}

		model.setRoot(root);

		if (lastSelection != null) {
			root.select(this, lastSelection);
			lastSelection.clear();
		}

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
	protected void clear() {
		lastSelection.clear();
		JTreeTableNode[] nodes = treetable.getSelectedNodes();
		if (nodes != null) {
			for (JTreeTableNode node : nodes) {
				lastSelection.add(node);
			}
		}
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
	protected void reload() {
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
		return super.getShowCheckBox(node) && ((JTreeTableNode) node).isCheckable();
	}

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
		sort(treetable.getComparator(treetable.sortingColumn), treetable.sortingColumn, treetable.sortingDirection);
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	protected void sort(Comparator<Object> comparator, int columnIndex, int sortDirection) {

		JTreeTableNode node = treetable.getSelectedNode();
		TreePath path = node == null ? null : new TreePath(node.getPath());

		Enumeration<TreePath> expandeds = getExpandedDescendants(new TreePath(root));
		List<TreeNode> checkeds = getCheckedItems();

		if (sortDirection == JTreeTable.SORTDIR_NO) {
			root.addToTree();
		} else {
			root.sort(comparator, columnIndex, sortDirection);
		}

		reload();

		// expand the last expanded rows
		while (expandeds != null && expandeds.hasMoreElements()) {
			expandPath((TreePath) expandeds.nextElement());
		}

		// select the last selected row
		if (path != null) {
			setSelectionPath(path);
		}

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
	private JTreeTableNode doFilter(JTreeTableNode node, int columnIndex, JTreeTableFilterData fdata) {

		JTreeTableNode filteredNode = null;

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
						} else if (fdata.filterType.equals("Enthält")) {
							found = vs.indexOf(fdata.filterText) != -1;
						} else if (fdata.filterType.equals("Enthält nicht")) {
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

		if (filteredNode != null) {
			for (JTreeTableNode o : node.getChilds()) {
				JTreeTableNode cn = doFilter(o, columnIndex, fdata);
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
	protected void expandNode(JTreeTableNode node) {
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
	protected void collapseNode(JTreeTableNode node) {
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
	protected void expandToLevel(int level) {
		JTreeTableNode node = treetable.getSelectedNode();
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
	protected void collapseToLevel(int level) {
		JTreeTableNode node = treetable.getSelectedNode();
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
	protected JTreeTableNode getRoot() {
		return root;
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	protected JTreeTableNode getOriginRoot() {
		return originRoot;
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	protected JTreeTableNode getNodeAtRow(int row) {
		TreePath path = getPathForRow(row);
		if (path != null) {
			Object o = path.getLastPathComponent();
			if (o instanceof JTreeTableNode) {
				return (JTreeTableNode) o;
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
	protected JTreeTableNode getNodeByKey(String key) {
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
	protected JTreeTableNode getNodeByName(String name, boolean caseSensitive) {
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
	protected List<JTreeTableNode> getNodes() {
		List<JTreeTableNode> nodes = new ArrayList<JTreeTableNode>();
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
	protected List<JTreeTableNode> getAllCheckedNodes() {
		List<JTreeTableNode> nodes = new ArrayList<JTreeTableNode>();
		List<TreeNode> ns = getAllChecked();
		for (TreeNode n : ns) {
			JTreeTableNode node = (JTreeTableNode) n;
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
	public List<JTreeTableNode> getAllCheckedNodesHerarchic() {

		List<JTreeTableNode> nodes = new ArrayList<JTreeTableNode>();
		List<JTreeTableNode> tops = new ArrayList<JTreeTableNode>();

		List<TreeNode> ns = getAllChecked();

		for (TreeNode n : ns) {
			JTreeTableNode node = (JTreeTableNode) n;
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

	private void adx(List<JTreeTableNode> nodes, List<JTreeTableNode> tops) {
		List<JTreeTableNode> nds = new ArrayList<JTreeTableNode>();
		List<JTreeTableNode> tps = new ArrayList<JTreeTableNode>();
		for (JTreeTableNode node : nodes) {
			boolean f = true;
			for (JTreeTableNode top : tops) {
				if (top.isParentOf(node)) {
					JTreeTableNode n = node.cloneNode(false);
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
	protected int getNodesCount() {
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
	protected void deleteNode(JTreeTableNode node) {
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
	protected int getDepth() {
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
	private void select(JTreeTableNode node) {
		JTreeTableNode n = node;
		while (!root.equals(n) && n.getNodeParent() != null && !root.equals(n.getNodeParent())) {
			n = n.getNodeParent();
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
	protected void select(JTreeTableNode[] nodes) {
		root.setSelected(false);
		for (JTreeTableNode node : nodes) {
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
	protected void select(List<JTreeTableNode> selections) {
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
	protected void search(String text, List<JTreeTableNode> rows) {
		root.search(text, rows);
	}

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
			if (treetable != null && treetable.getRowHeight() != rowHeight) {
				treetable.setRowHeight(getRowHeight());
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
		super.setBounds(x, y, w, treetable.getHeight());
	}

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
	protected void setPaintingRow(int row) {
		paintingRow = row;
	}

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
		return ((JTreeTableNode) node).isCheckBoxEnabled();
	}

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
		treetable.nodeChecked((JTreeTableNode) node, checkState);
	}
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
