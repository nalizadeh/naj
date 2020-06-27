package org.naj.java.ui.layout;

import java.awt.Graphics;
import java.awt.LayoutManager;

import javax.swing.JPanel;

/**
 * @author   Nader Alizadeh
 * @version  1.0
 */
public class CellsLayoutPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private boolean debug = false;
	
	public CellsLayoutPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
	}

	public CellsLayoutPanel(LayoutManager layout) {
		super(layout);
	}

	public CellsLayoutPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
	}

	public CellsLayoutPanel() {
		super();
	}
	
	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	public void paint(Graphics g) {
		super.paint(g);
		if (debug) {
			if (getLayout() instanceof CellsLayout) {
				((CellsLayout) getLayout()).showGrids(this, g);
			}
		}
	}
}
