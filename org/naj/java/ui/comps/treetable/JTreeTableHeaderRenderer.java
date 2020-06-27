/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.ui.comps.treetable;

import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;

/**
 * @author  P203125
 */
public class JTreeTableHeaderRenderer extends JLabel implements TableCellRenderer {

	private static final long serialVersionUID = 1L;

	private JTreeTable treetable;
	private int modelIndex;

	public JTreeTableHeaderRenderer(JTreeTable treetable, int modelIndex) {
		this.treetable = treetable;
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

		TableCellRenderer r = treetable.getTableHeader().getDefaultRenderer();
		JLabel lb = (JLabel) r.getTableCellRendererComponent(table, tx, isSelected, hasFocus, row, column);
		lb.removeAll();

		int mci = treetable.convertColumnIndexToModel(column);

		int w = treetable.getColumnModel().getColumn(mci).getWidth();
		int h = treetable.getTableHeader().getHeight();
		int p = 0;
		int bw = JTreeTableProperties.H_BUTTON_WIDTH;

		JTreeTableProperties props = treetable.getProperties();

		if (treetable.headerRolloverIndex == mci) {
			if (props.showHeaderMenu) {

				p = bw;

				treetable.headerMenuButton.setBounds(w - bw, 0, bw, h - 2);

				if (props.showExCoButtons && mci == 0) {

					p += 2 * bw;

					treetable.expandButton.setBounds(w - 2 * bw, 0, bw, h - 2);
					treetable.collapseButton.setBounds(w - 3 * bw, 0, bw, h - 2);
					lb.add(treetable.expandButton);
					lb.add(treetable.collapseButton);
				}

				lb.add(treetable.headerMenuButton);

			} else if (props.showExCoButtons && mci == 0) {

				p += 2 * bw;

				treetable.expandButton.setBounds(w - bw, 0, bw, h - 2);
				treetable.collapseButton.setBounds(w - 2 * bw, 0, bw, h - 2);
				lb.add(treetable.expandButton);
				lb.add(treetable.collapseButton);
			}
		} else if (treetable.menuIndex == mci) {

			p += bw;
			JLabel l = new JLabel(JTreeTableProperties.TT_MEH_ICON);
			l.setBounds(w - p, 0, bw, h - 2);
			lb.add(l);
		}

		if (treetable.filterData.containsKey(modelIndex)) {
			p += bw;
			JLabel l = new JLabel(JTreeTableProperties.TT_FLT_ICON);
			l.setBounds(w - p, 0, bw, h - 2);
			lb.add(l);
		}

		if (treetable.sortingColumn == modelIndex) {
			p += bw;
			ImageIcon icon = null;
			if (treetable.sortingDirection == JTreeTable.SORTDIR_ASCENDING) {
				icon = props.isFlatTable ? JTreeTableProperties.TT_ASC_NOHE : JTreeTableProperties.TT_ASC_ICON;
			} else if (treetable.sortingDirection == JTreeTable.SORTDIR_DESCENDING) {
				icon = props.isFlatTable ? JTreeTableProperties.TT_DES_NOHE : JTreeTableProperties.TT_DES_ICON;
			}
			JLabel l = new JLabel(icon);
			l.setBounds(w - p, 0, bw, h - 2);
			lb.add(l);
		}

		Border outside = lb.getBorder();
		Border inside = BorderFactory.createEmptyBorder(0, 0, 0, p);
		Border b = BorderFactory.createCompoundBorder(outside, inside);
		lb.setBorder(b);

		return lb;
	}
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
