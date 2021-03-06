/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.ui.comps.treetable;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * @author  P203125
 */
public class JTreeTableCellRenderer extends DefaultTableCellRenderer {

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

		JTreeTable tt = (JTreeTable) table;
		JTreeTableNode node = tt.getNodeAtRow(row);

		Color fg = node.getForegroundColor(row, column);
		Color bg = node.getBackgroundColor(row, column);		

		if (fg == null) fg = tt.getForeground();
		if (bg == null) bg = tt.getBackground();

		JTreeTableProperties props = tt.getProperties();

		if (isSelected) {
			fg = table.getSelectionForeground();
			bg = table.getSelectionBackground();

		} else {
			Color c1 =
				props.showRollover && tt.bodyRolloverIndex == row ? JTreeTableProperties.ROLLOVER_COLOR
				: node == null ? props.showAlternateColor ? bg : JTreeTableProperties.TT_COLOR1
				: !props.showAlternateColor ? node.getBackgroundColor(row, column)
				: node.isSelected() && props.showGroupSelection ? JTreeTableProperties.TT_COLOR3
				: props.showPartSelection ? node.getBackgroundColor(row, column) : JTreeTableProperties.TT_COLOR1;
			Color c2 =
				props.showRollover && tt.bodyRolloverIndex == row ? JTreeTableProperties.ROLLOVER_COLOR
				: !props.showAlternateColor ? node.getBackgroundColor(row, column)
				: node == null ? props.showAlternateColor ? bg : JTreeTableProperties.TT_COLOR2
				: !props.showAlternateColor ? node.getBackgroundColor(row, column)
				: node.isSelected() && props.showGroupSelection ? JTreeTableProperties.TT_COLOR4
				: props.showPartSelection ? node.getBackgroundColor(row, column) : JTreeTableProperties.TT_COLOR2;

			bg = row % 2 == 0 ? c1 : c2;
		}

		// Rendering tree column
		if (tt.getColumnClass(column) == JTreeTableTree.class) {
			JTreeTableTree tree = tt.getTree();
			tree.setPaintingRow(row);
			tree.setForeground(fg);
			tree.setBackground(bg);
			return tree;
		}

		int col = tt.convertColumnIndexToModel(column);
		JTreeTableModel model = (JTreeTableModel) table.getModel();

		// Rendering via renderer if any exists
		JTreeTableRendererComponent renderer = tt.getTreeTableModel().getRendererAt(node, row, col);
		if (renderer != null) {
			return renderer.getRendererComponent(table, value, isSelected, //
				model.isCellEnabled(row, column), fg, bg
			);
		}

		// Rendering via editor if any exists
		JTreeTableEditorComponent editor = tt.getTreeTableModel().getEditorAt(node, row, col);
		if (editor != null && node.isEditable(row, col)) {
			return editor.getRendererComponent(table, value, isSelected, //
				model.isCellEnabled(row, column), fg, bg
			);

		}

		String tooltip = null;
		if (value != null) {
			String vs = value.toString();
			if (!vs.isEmpty()) {
				StringBuffer sb = new StringBuffer();
				createToolTip(vs, sb);
				String ts = sb.toString();
				if (!ts.isEmpty()) {
					tooltip = "<html>" + ts + "</html>";
					setToolTipText(tooltip);
				}
			}
		}

		// Rest of columns
		Font fo = node.getFont(row, column);
		setForeground(fg);
		setBackground(bg);
		setFont(fo == null ? JTreeTableProperties.TT_FONT1 : fo);
		setHorizontalAlignment(node.getHorizontalAlignment(row, column));
		setVerticalAlignment(node.getVerticalAlignment(row, column));

		if (!isSelected && node != null && node.hasChild() && node.isSelected() && node.getLevel() == 1) {
			setFont(JTreeTableProperties.TT_FONT2);
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

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
