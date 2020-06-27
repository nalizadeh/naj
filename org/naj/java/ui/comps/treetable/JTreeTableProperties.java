/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.ui.comps.treetable;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;

import org.naj.java.ui.Helper;

/**
 * @author  P203125
 */
public class JTreeTableProperties {

	protected static final int FONT_SIZE = 13;

	protected static final ImageIcon TT_MEN_ICON = Helper.getImage("headmenu.png");
	protected static final ImageIcon TT_MEH_ICON = Helper.getImage("men.png");
	protected static final ImageIcon TT_PLO_ICON = Helper.getImage("expand.gif");
	protected static final ImageIcon TT_MIN_ICON = Helper.getImage("collapse.gif");
	protected static final ImageIcon TT_EXP_ICON = Helper.getImage("expand.png");
	protected static final ImageIcon TT_COL_ICON = Helper.getImage("collapse.png");
	protected static final ImageIcon TT_ASC_ICON = Helper.getImage("sortAZ.png");
	protected static final ImageIcon TT_DES_ICON = Helper.getImage("sortZA.png");
	protected static final ImageIcon TT_ASC_NOHE = Helper.getImage("sortAscanding.png");
	protected static final ImageIcon TT_DES_NOHE = Helper.getImage("sortDescanding.png");
	protected static final ImageIcon TT_REM_SORT = Helper.getImage("remSort.png");
	protected static final ImageIcon TT_FLT_ICON = Helper.getImage("filter.png");
	protected static final ImageIcon TT_REM_FILT = Helper.getImage("remFilter.png");
	protected static final ImageIcon TT_SER_ICON = Helper.getImage("search.png");
	protected static final ImageIcon TT_LIS_ICON = Helper.getImage("lst.png");
	protected static final ImageIcon TT_DET_ICON = Helper.getImage("rowdetail.png");
	protected static final ImageIcon TT_COP_ICON = Helper.getImage("copy.png");
	protected static final ImageIcon TT_PAS_ICON = Helper.getImage("paste.png");

	// Colors and fonts to rendering the cells
	protected static final Color TT_COLOR1 = new Color(250, 250, 250);
	protected static final Color TT_COLOR2 = new Color(240, 240, 240);
	protected static final Color TT_COLOR3 = new Color(230, 230, 230);
	protected static final Color TT_COLOR4 = new Color(222, 222, 222);

	protected static final Color ROLLOVER_COLOR = new Color(217, 235, 249);
	protected static final Color ERROR_COLOR = new Color(255, 192, 192);
	protected static final Color MANDATORY_COLOR = new Color(255, 240, 192);

	protected static Font TT_FONT1 = new Font("Arial", 0, JTreeTableProperties.FONT_SIZE);
	protected static Font TT_FONT2 = new Font("Arial", Font.BOLD, JTreeTableProperties.FONT_SIZE);
	protected static Font EDITOR_FONT = new Font("Arial", 0, JTreeTableProperties.FONT_SIZE);

	// Header buttons (menu, expand, collapse)
	protected static final int H_BUTTON_WIDTH = 16;
	protected static final Color H_BUTTON_BGC = new Color(200, 200, 200, 100);

	protected boolean showAlternateColor = true;
	protected boolean showRollover = true;
	protected boolean showHeaderMenu = true;
	protected boolean showExCoButtons = true;
	protected boolean showPopupMenu = true;
	protected boolean showDetailsPopup = false;
	protected boolean showGroupSelection = true;
	protected boolean showPartSelection = false;
	protected boolean columnsConfigurable = true;
	protected boolean isFlatTable = false;
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
