/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.ui.comps.treetable;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

/**
 * @author  P203125
 */
public class JTreeTableFilterData {

	protected String filterType = "";
	protected String filterText = "";
	protected List<String> filterNodes = new ArrayList<String>();

	/**
	 * @author  P203125
	 */
	protected static class FilterColumnNode extends JTreeTableNode {
		private static final long serialVersionUID = 1L;
		protected String name;

		FilterColumnNode() {
		}

		FilterColumnNode(String name) {
			this();
			this.name = name;
		}

		@Override
		protected JTreeTableNode createInstance() {
			return new FilterColumnNode();
		}

		@Override
		public void copy(JTreeTableNode node) {
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
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
