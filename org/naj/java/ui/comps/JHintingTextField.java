/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.ui.comps;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Shape;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;
import javax.swing.text.JTextComponent;

/**
 * @author  P203125
 */
public class JHintingTextField extends JTextField {

	private static final long serialVersionUID = 1L;

	private static final Color mandatoryColor = new Color(249, 246, 199);

	private boolean isMandatory = false;

	/**
	 * Creates a new <code>JHintingTextField</code>.
	 */
	public JHintingTextField() {
	}

	/**
	 * Creates a new <code>JHintingTextField</code>.
	 *
	 * @param  columns  the number of preferred columns to calculate preferred width
	 */
	public JHintingTextField(int columns) {
		super(columns);
		installHighlightPainter();
	}

	/**
	 * Creates a new <code>JHintingTextField</code>.
	 *
	 * @param  text  the text to show in the text field
	 */
	public JHintingTextField(String text) {
		super(text);
		installHighlightPainter();
	}

	/**
	 * Creates a new <code>JHintingTextField</code>.
	 *
	 * @param  text     the text to show in the text field
	 * @param  columns  the number of preferred columns to calculate preferred width
	 */
	public JHintingTextField(String text, int columns) {
		super(text, columns);
		installHighlightPainter();
	}

	/**
	 * Creates a new <code>JHintingTextField</code>.
	 *
	 * @param  doc      the text model
	 * @param  text     the text to show in the text field
	 * @param  columns  the number of preferred columns to calculate preferred width
	 */
	public JHintingTextField(Document doc, String text, int columns) {
		super(doc, text, columns);
		installHighlightPainter();
	}

	/**
	 * Creates a new <code>JHintingTextField</code>.
	 * 
	 * @param isMandatory
	 */
	public JHintingTextField(boolean isMandatory) {
		super();
		this.isMandatory = isMandatory;
		if (isMandatory) {
			installHighlightPainter();
			putClientProperty("emptyTextHint", "Pflichtfeld");
		}
	}

	/**
	 * Creates a new <code>JHintingTextField</code>.
	 * 
	 * @param text
	 * @param isMandatory
	 */
	public JHintingTextField(String text, boolean isMandatory) {
		super(text);
		this.isMandatory = isMandatory;
		if (isMandatory) {
			installHighlightPainter();
			putClientProperty("emptyTextHint", "Pflichtfeld");
		}
	}

	/**
	 * 
	 */
	private void installHighlightPainter() {
		if (this.isMandatory) {
			Highlighter highlighter = getHighlighter();
			try {
				highlighter.addHighlight(0, 0, createHighlightPainter());
			} catch (BadLocationException ex) {
				assert false : "0:0 illegal?"; //$NON-NLS-1$
			}
			putClientProperty("emptyTextHint", "Pflichtfeld");
		}
	}
	
	/**
	 * 
	 * @return HighlightPainter
	 */
	protected HighlightPainter createHighlightPainter() {
		return
			new HighlightPainter() {

				final JLabel label = new JLabel("", SwingConstants.TRAILING);
				final int gap = 0;

				public void paint(Graphics g, int p0, int p1, Shape bounds, JTextComponent c) {
										
					setOpaque(true);
					setBackground(isEnabled() ? UIManager.getColor("TextField.background") :
						UIManager.getColor("TextField.disabledBackground"));

					final String hint =	(String) c.getClientProperty("emptyTextHint");
					
					if (!isEnabled() || hint == null || hint.length() == 0 || c.getDocument().getLength() != 0) {
						return;
					}
					
					setBackground(mandatoryColor);

					label.setText(hint);

					final Insets ins = c.getInsets();
					final boolean ltr = c.getComponentOrientation().isLeftToRight();
					if (ltr) {
						ins.right += gap;
					} else {
						ins.left += gap;
					}

					final Dimension pref = label.getPreferredSize();
					final int prHeight = pref.height;
					final int prWidth = pref.width;
					final int w = Math.min(c.getWidth() - ins.left - ins.right, prWidth);
					final int h = Math.min(c.getWidth() - ins.top - ins.bottom, prHeight);
					final int x = ltr ? c.getWidth() - ins.right - w : ins.left;
					final int parentHeight = c.getHeight() - ins.top - ins.bottom;
					final int y = ins.top + (parentHeight - h) / 2;
					label.setForeground(Color.GRAY);
					label.setOpaque(false);
					SwingUtilities.paintComponent(g, label, c, x, y, w, h);
				}
			};
	}

	/**
	 * Returns the emptyTextHint.
	 *
	 * @return  the emptyTextHint
	 */
	public String getEmptyTextHint() {
		return (String) getClientProperty("emptyTextHint"); //$NON-NLS-1$
	}

	/**
	 * Sets the emptyTextHint.
	 *
	 * @param  hint  the emptyTextHint to set
	 */
	public void setEmptyTextHint(String hint) {
		putClientProperty("emptyTextHint", hint); //$NON-NLS-1$
		repaint();
	}

//	public static void main(String[] args) {
//		final JPanel contentPane = new JPanel(new BorderLayout(6, 6));
//		final JHintingTextField comp = new JHintingTextField(true);
//		contentPane.add(comp);
//
//		final JFrame f = new JFrame("Test Frame: JHintingTextField");
//		f.setContentPane(contentPane);
//		f.pack();
//		f.setLocationRelativeTo(null);
//		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//		f.setVisible(true);
//	}
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
