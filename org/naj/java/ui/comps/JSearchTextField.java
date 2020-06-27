/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

/*
 * Copyright 2007 N.A.J. nalizadeh.com - All rights reserved. nalizadeh.com PROPRIETARY/CONFIDENTIAL. Use is subject to
 * license terms.
 *
 * This program is free software; you can redistribute it and/or modify it under the terms of the GNU General Public
 * License as published by the Free Software Foundation; either version 3 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License for more details.
 */

package org.naj.java.ui.comps;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Document;

import org.naj.java.ui.Helper;

/**
 * @author  P203125
 */
public class JSearchTextField extends JTextField implements ActionListener, MouseListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;

	private ImageIcon search = Helper.getImage("txtsearch.png");
	private ImageIcon searchBt = Helper.getImage("search3.png");
	private ImageIcon cross = Helper.getImage("cross.png");

	private int btHeight = searchBt.getIconHeight();
	private int btWidth = searchBt.getIconWidth();
	private int crossHeight = cross.getIconHeight();
	private int crossWidth = cross.getIconWidth();

	private boolean showSearch = true;

	public JSearchTextField() {
		super();
		initGUI();
	}

	public JSearchTextField(String text) {
		super(text);
		initGUI();
	}

	public JSearchTextField(int columns) {
		super(columns);
		initGUI();
	}

	public JSearchTextField(String text, int columns) {
		super(text, columns);
		initGUI();
	}

	public JSearchTextField(Document doc, String text, int columns) {
		super(doc, text, columns);
		initGUI();
	}

	private void initGUI() {
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		this.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JSearchTextField.this.actionPerformed(getText());
				}
			}
		);
		super.setBorder(new EmptyBorder(0, 2, 0, crossWidth + btHeight + 6));
	}

	public void paint(Graphics g) {
		super.paint(g);

		g.drawImage(searchBt.getImage(), getWidth() - btWidth - 4, (getHeight() - btHeight) / 2, null);

		if (!getText().isEmpty()) {
			g.drawImage(cross.getImage(), getWidth() - crossWidth - btWidth - 6, (getHeight() - crossHeight) / 2, null);
		} else if (showSearch) {
			g.drawImage(search.getImage(), 5, (getHeight() - search.getIconHeight()) / 2, null);
		}
	}

	protected void actionPerformed(String txt) {
	}

	@Override
	public void actionPerformed(ActionEvent act) {
		actionPerformed(getText());
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		showSearch = false;
		if (!getText().isEmpty()) {
			int x = e.getX();
			boolean ok = x >= getWidth() - btWidth - crossWidth - 6 && x <= getWidth() - btWidth - 6;
			if (ok) {
				setText("");
				for (KeyListener l : this.getKeyListeners()) {
					l.keyPressed(null);
					l.keyReleased(null);
					l.keyTyped(null);
				}
			} else {
				ok = x >= getWidth() - btWidth - 6 && x <= getWidth() - 6;
				if (ok) {
					for (KeyListener l : this.getKeyListeners()) {
						l.keyPressed(null);
						l.keyReleased(null);
						l.keyTyped(null);
					}
					actionPerformed(getText());
				}

			}
		}
		repaint();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		showSearch = false;
		repaint();
	}

	@Override
	public void mouseExited(MouseEvent e) {
		showSearch = getText().isEmpty();
		repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		int x = e.getX();
		boolean ok =
			(x >= getWidth() - btWidth - crossWidth - 6 && x <= getWidth() - btWidth - 6)
			|| (x >= getWidth() - btWidth - 6 && x <= getWidth() - 6);

		setCursor(Cursor.getPredefinedCursor(ok ? Cursor.HAND_CURSOR : Cursor.TEXT_CURSOR));
	}
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
