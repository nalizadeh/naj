/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.ui.comps;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.StyledDocument;

import org.naj.java.ui.utils.CellsCodeStyler;

/**
 * @author  P203125
 */
public class JSourceViewerDialog extends JDialog {

	private static final long serialVersionUID = 1L;

	protected int closeState = 0;

	private Window parent;
	private String genDirectory;
	private JTextPane txt1 = new JTextPane();
	private JTextPane txt2 = new JTextPane();

	public JSourceViewerDialog(Window parent, String genDirectory, StringBuffer sb) {
		super(parent, "Source");
		this.parent = parent;
		this.genDirectory = genDirectory;

		initUI();
		setSource(sb);

		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setModalityType(ModalityType.APPLICATION_MODAL);
		setResizable(true);
		setLocation(50, 50);
		setPreferredSize(new Dimension(1000, 800));
		pack();
		setVisible(true);
	}

	private void initUI() {
		txt2.setPreferredSize(new Dimension(55, 100));
		txt2.setEditable(false);
		txt1.setText("");
		txt2.setText("");

		final JButton b1 = new JButton("÷ffnen");
		final JButton b2 = new JButton("Schlieﬂen");
		b1.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					open();
				}
			}
		);

		b2.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					close();
				}
			}
		);

		JPanel pa1 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		pa1.add(b1);
		pa1.add(b2);

		JPanel pa2 = new JPanel(new BorderLayout());
		pa2.add(txt2, BorderLayout.WEST);
		pa2.add(txt1, BorderLayout.CENTER);

		JScrollPane sp = new JScrollPane(pa2);
		sp.getVerticalScrollBar().setUnitIncrement(20);

		add(pa1, BorderLayout.NORTH);
		add(sp, BorderLayout.CENTER);

		Point p =
			new Point(
				parent.getSize().width / 2
				+ parent.getLocation().x
				- 175,
				parent.getSize().height / 2 + parent.getLocation().y - 50
			);

		setLocation(p.x, p.y);
	}

	private void setSource(StringBuffer sb) {
		if (sb != null) {
			StyledDocument doc1 = txt1.getStyledDocument();
			StyledDocument doc2 = txt2.getStyledDocument();
			try {
				new CellsCodeStyler().style(sb, doc1, doc2);

			} catch (Exception ex) {
			}
			txt1.setCaretPosition(0);
			txt2.setCaretPosition(0);
		}
	}

	public JRootPane createRootPane() {
		JRootPane rootPane = new JRootPane();
		KeyStroke stroke = KeyStroke.getKeyStroke("ESCAPE");
		Action action =
			new AbstractAction() {

				private static final long serialVersionUID = 1L;

				public void actionPerformed(ActionEvent e) {
					setVisible(false);
					dispose();
				}
			};

		InputMap inputMap = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		inputMap.put(stroke, "ESCAPE");
		rootPane.getActionMap().put("ESCAPE", action);
		return rootPane;
	}

	private void open() {
		JFileChooser chooser = new JFileChooser(genDirectory);
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("JAVA FILES", "java", "java");
		chooser.setFileFilter(filter);
		int returnVal = chooser.showOpenDialog(this);

		if (returnVal == JFileChooser.APPROVE_OPTION) {
			try(BufferedReader br = new BufferedReader(new FileReader(chooser.getSelectedFile().getAbsoluteFile()))) {
				StringBuffer sb = new StringBuffer();
				for (String line; (line = br.readLine()) != null;) {
					sb.append(line + "\n");
				}
				br.close();
				setSource(sb);

			} catch (IOException ex) {
				//ex.printStackTrace();
			}
		}
	}

	private void close() {
		setVisible(false);
		dispose();
		closeState = 0;
	}
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
