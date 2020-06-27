/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.ui.comps.treetable;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

/**
 * @author  P203125
 */
public class JTreeTableFlat extends JTreeTable {

	private static final long serialVersionUID = 1L;

	public JTreeTableFlat(String[] columnNames, Object[][] data) {
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

		getProperties().isFlatTable = true;

		setData(data);
	}

	public void setData(Object[][] data) {
		List<FlatNode> nodes = new ArrayList<FlatNode>();
		for (int i = 0; i < data.length; i++) {
			nodes.add(new FlatNode(data[i]));
		}
		init(nodes);
	}

	public static class FlatNode extends JTreeTableNode {
		private static final long serialVersionUID = 1L;
		private Object[] data;

		public FlatNode() {
		}

		public FlatNode(Object[] data) {
			this.data = data;
		}

		@Override
		public void copy(JTreeTableNode node) {
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

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
