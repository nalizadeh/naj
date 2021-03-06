/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.ui.comps.treetable;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Icon;
import javax.swing.JTree;
import javax.swing.tree.DefaultTreeCellRenderer;

/**
 * @author  P203125
 */
public class JTreeTableTreeCellRenderer extends DefaultTreeCellRenderer {

	private static final long serialVersionUID = 1L;

	private JTreeTable treetable;

	public JTreeTableTreeCellRenderer(JTreeTable treetable) {
		this.treetable = treetable;
	}

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
		JTreeTableNode node = ((JTreeTableTree) tree).getNodeAtRow(row);
		if (node != null) {
			setText(node.getNodeName());
			setIcon(tree, value, leaf, node.getIcon());

			font = node.getFont(row, 0);

			Color fg = node.getForegroundColor(row, 0);
			Color bg = node.getBackgroundColor(row, 0);		

			if (fg == null) fg = treetable.getForeground();
			if (bg == null) bg = treetable.getBackground();

			setForeground(fg);
			setBackground(bg);
		}

		JTreeTableProperties props = treetable.getProperties();

		setFont(font == null ? JTreeTableProperties.TT_FONT1 : font);

		if (selected) {
			setTextSelectionColor(treetable.getSelectionForeground());
			setBackgroundSelectionColor(treetable.getSelectionBackground());
			setForeground(treetable.getSelectionForeground());
			setBackground(treetable.getSelectionBackground());
		} else {
			Color c1 =
				props.showRollover && treetable.bodyRolloverIndex == row ? JTreeTableProperties.ROLLOVER_COLOR
				: node == null ? props.showAlternateColor ? getBackground() : JTreeTableProperties.TT_COLOR1
				: !props.showAlternateColor ? node.getBackgroundColor(0, 0)
				: node.isSelected() && props.showGroupSelection ? JTreeTableProperties.TT_COLOR3
				: props.showPartSelection ? node.getBackgroundColor(0, 0) : JTreeTableProperties.TT_COLOR1;
			Color c2 =
				props.showRollover && treetable.bodyRolloverIndex == row ? JTreeTableProperties.ROLLOVER_COLOR
				: node == null ? props.showAlternateColor ? getBackground() : JTreeTableProperties.TT_COLOR2
				: !props.showAlternateColor ? node.getBackgroundColor(0, 0)
				: node.isSelected() && props.showGroupSelection ? JTreeTableProperties.TT_COLOR4
				: props.showPartSelection ? node.getBackgroundColor(0, 0) : JTreeTableProperties.TT_COLOR2;

			setBackgroundNonSelectionColor(row % 2 == 0 ? c1 : c2);

			if (!selected && node != null && node.hasChild() && node.isSelected() && node.getLevel() == 1) {
				setFont(JTreeTableProperties.TT_FONT2);
			}
		}

		// Bug of JTree
		setPreferredSize(new Dimension(800, tree.getRowHeight()));

		return this;
	}

	protected void setIcon(JTree tree, Object value, boolean leaf, Icon icon) {
		super.setIcon(((JTreeTableTree) tree).createDoubleIcon(value, leaf, icon));
	}
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
