/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.ui.comps.treetable;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

//===============================================================================
// JTreeTableNode
//
// This is the callback interface. Provides for initialization of the nodes.
// Through this interface the user can determine most properties of the nodes,
// for example icons, colors, fonts, etc.
//===============================================================================
/**
 * @author  P203125
 */
public class JTreeTableNode extends DefaultMutableTreeNode {

	private static final long serialVersionUID = 1L;

	private String myKey;
	private String myName;
	private int myLevel;
	private JTreeTableNode myParent;
	private List<JTreeTableNode> myChilds;
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
	public JTreeTableNode() {
		super(null);
		this.myParent = null;
		this.myKey = null;
		this.myName = null;
		this.myLevel = 0;
		this.myChilds = new ArrayList<JTreeTableNode>();
		this.selected = false;
		this.checkState = JTreeTableCheckboxTree.NOT_SELECTED;
	}

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
			for (JTreeTableNode o : myChilds) {
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
	public JTreeTableNode getNodeParent() {
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
	protected void setNodeParent(JTreeTableNode parent) {
		this.myParent = parent;
		this.myKey = parent == null ? "root" : createNodeKey();
		this.myName = parent == null ? "root" : createNodeName();
		this.myLevel = parent == null ? 0 : parent.myLevel + 1;
		for (JTreeTableNode node : myChilds) {
			node.setNodeParent(this);
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
		if (caseSensitive) {
			if (getNodeName().equals(name)) {
				return this;
			}
		} else if (getNodeName().toLowerCase().equals(name.toLowerCase())) {
			return this;
		}

		for (JTreeTableNode node : myChilds) {
			JTreeTableNode n = node.getNodeByName(name, caseSensitive);
			if (n != null) {
				return n;
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
	public JTreeTableNode getNodeByKey(String key) {
		if (getNodeKey().equals(key)) {
			return this;
		}
		for (JTreeTableNode node : myChilds) {
			JTreeTableNode n = node.getNodeByKey(key);
			if (n != null) {
				return n;
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
	public JTreeTableNode getNodeByKeyParts(int kpos1, int kpos2, String key) {
		String k1 = getKeyPart(myKey, kpos1);
		String k2 = getKeyPart(key, kpos2);

		if (k1.equals(k2)) {
			return this;
		}
		for (JTreeTableNode node : myChilds) {
			JTreeTableNode n = node.getNodeByKeyParts(kpos1, kpos2, key);
			if (n != null) {
				return n;
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
	protected void initChilds(List<? extends JTreeTableNode> nodes) {
		if (nodes != null && !nodes.isEmpty()) {
			clear(true);
			for (JTreeTableNode node : nodes) {
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
	protected void updateChilds(List<? extends JTreeTableNode> nodes) {
		if (nodes != null) {
			clear(false);
			for (JTreeTableNode node : nodes) {
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
		return !myChilds.isEmpty();
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public List<JTreeTableNode> getChilds() {
		return myChilds;
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public JTreeTableNode getChild(String name) {
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
	public JTreeTableNode getChild(String name, boolean caseSensitive) {
		for (JTreeTableNode node : myChilds) {
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
	public List<JTreeTableNode> getChilds(String name) {
		List<JTreeTableNode> cc = new ArrayList<JTreeTableNode>();
		for (JTreeTableNode o : myChilds) {
			if (o.getNodeName().equals(name)) {
				cc.add(o);
			}
		}
		return cc;
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public List<JTreeTableNode> getChilds(Class<?> classtype) {

		if (classtype == null) {
			return myChilds;
		}

		List<JTreeTableNode> cc = new ArrayList<JTreeTableNode>();
		for (JTreeTableNode o : myChilds) {
			if (o.getClass() == classtype) {
				cc.add(o);
			}
		}
		return cc;
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void addChild(JTreeTableNode child) {
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
	public void addMultipleChild(JTreeTableNode child) {
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
	protected void addChild(JTreeTableNode child, boolean setParent, boolean multiple) {
		if (multiple || getChild(child.getNodeName()) == null) {
			if (setParent) {
				child.setNodeParent(this);
			}
			myChilds.add(child);
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
	public void removeChild(JTreeTableNode child) {
		if (getNodeByName(child.getNodeName()) != null) {
			myChilds.remove(child);
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
		JTreeTableNode child = getNodeByName(name);
		if (child != null) {
			myChilds.remove(child);
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
	public void removeNode(JTreeTableNode node) {
		JTreeTableNode n = getNodeByKey(node.myKey);
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
	public void clear(boolean childsToo) {
		if (childsToo) {
			for (JTreeTableNode node : myChilds) {
				node.clear(true);
			}
		}

		// this must be done here!!
		removeAllChildren();
		myChilds.clear();
	}

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
	public boolean isParentOf(JTreeTableNode node) {
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
		for (JTreeTableNode node : myChilds) {
			dd = Math.max(dd, node.getDepth(d + 1));
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
	protected void addToTree() {
		setUserObject(myName);
		for (JTreeTableNode node : myChilds) {
			add(node);
			node.addToTree();
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
		return checkState == JTreeTableCheckboxTree.ALL_SELECTED;
	}

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
		return checkState == JTreeTableCheckboxTree.PART_SELECTED;
	}

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
	public JTreeTableRendererComponent getRenderer(int row, int column) {
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
	public JTreeTableEditorComponent getEditor(int row, int column) {
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
	protected JTreeTableEditorComponent getEditorInstance(JTreeTableEditorComponent editor) {
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
		for (JTreeTableNode node : myChilds) {
			node.setSelected(selected);
		}
		this.selected = selected;
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	protected void select(JTreeTableTree tree, List<JTreeTableNode> nodes) {
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
		for (JTreeTableNode node : myChilds) {
			if (node.getNodeLevel() < level) {
				tree.expandPath(new TreePath(node.getPath()));
				node.expand(tree, level);
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
		for (JTreeTableNode node : myChilds) {
			node.collapse(tree, level);
			if (node.getNodeLevel() >= level) {
				tree.collapsePath(new TreePath(node.getPath()));
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

		// first sort children
		for (JTreeTableNode node : myChilds) {
			node.sort(comparator, columnIndex, sortDirection);
		}

		// and now sort myself
		JTreeTableNode[] rows = myChilds.toArray(new JTreeTableNode[myChilds.size()]);

		for (int i = rows.length; i > 1; i--) {
			for (int j = 1; j < i; j++) {
				JTreeTableNode r1 = rows[j - 1];
				JTreeTableNode r2 = rows[j];

				Object o1 = r1.getValues()[columnIndex];
				Object o2 = r2.getValues()[columnIndex];
				int co = comparator.compare(o1, o2);
				if (
					(sortDirection == JTreeTable.SORTDIR_ASCENDING && co > 0)
					|| (sortDirection == JTreeTable.SORTDIR_DESCENDING && co < 0)
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

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void search(Object condition, List<JTreeTableNode> results) {
		for (JTreeTableNode node : myChilds) {
			node.search(condition, results);
		}

		searchData(condition, results);
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void searchData(Object condition, List<JTreeTableNode> results) {
		Object[] data = getValues();
		if (data != null) {
			for (Object o : data) {
				if (o != null && o.toString().indexOf(condition.toString()) != -1) {
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
	protected JTreeTableNode createInstance() {
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
	private JTreeTableNode instance() {
		JTreeTableNode node = createInstance();
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
	public JTreeTableNode clone() {
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
	public JTreeTableNode cloneNode(boolean childsToo) {
		return cloneToNode(null, childsToo, true, false);
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public JTreeTableNode cloneToNode(JTreeTableNode node, boolean childsToo) {
		return cloneToNode(node, childsToo, true, false);
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public JTreeTableNode cloneToNode(JTreeTableNode node, boolean childsToo, boolean newInstance) {
		return cloneToNode(node, childsToo, newInstance, false);
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public JTreeTableNode cloneToNode(JTreeTableNode node, boolean childsToo, boolean newInstance, boolean difTypes) {

		JTreeTableNode newNode = node == null ? instance() : node;

		copyToNode(newNode);

		if (childsToo) {
			for (JTreeTableNode no : myChilds) {
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
	public void copyToNode(JTreeTableNode node) {
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
	public void copyFromNode(JTreeTableNode node) {
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
	protected void copy(JTreeTableNode node) {
	}

	/**
	 * @param
	 *
	 * @exception
	 *
	 * @return
	 *
	 * @see
	 */
	public void copyToList(List<JTreeTableNode> nodes) {
		nodes.add(this);
		for (JTreeTableNode node : myChilds) {
			node.copyToList(nodes);
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
	public void copyToMap(Map<Object, JTreeTableNode> map) {
		map.put(getNodeKey(), this);
		for (JTreeTableNode node : myChilds) {
			node.copyToMap(map);
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
	protected int getNodesCount(JTreeTableNode node) {
		int n = node.myChilds.size();
		for (JTreeTableNode c : node.myChilds) {
			n += getNodesCount(c);
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
		for (JTreeTableNode node : myChilds) {
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
			for (JTreeTableNode node : myChilds) {
				xml += node.toXML();
			}
		} else {
			xml += getXmlValue();
		}
		xml += "</" + myName + ">";
		return xml;
	}

	/**
	 * @return  String a="v" b="v",..
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

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
