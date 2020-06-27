/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.ui.comps.treetable;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.text.SimpleDateFormat;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.UIManager;

import org.naj.java.ui.Helper;

/**
 * @author  P203125
 */
public class JTreeTableTest extends JPanel {

	private static final long serialVersionUID = 1L;

	private static final String[] columnNames = { "Name", "Size", "Directory", "Modification Date" };
	private JTreeTable treetable = null;
	private FileNode root = null;

	public JTreeTableTest(final String path, final String pattern) {

		final JTextField tfWorkDir = new JTextField();
		tfWorkDir.setText(path);
		tfWorkDir.setEditable(false);
		tfWorkDir.setPreferredSize(new Dimension(400, 24));

		JLabel lab = new JLabel("Current directory:");
		lab.setFont(new Font("Tahoma Fett", 1, 12));

		final JButton btWorkDir = new JButton(Helper.getImage("men.gif"));
		btWorkDir.setPreferredSize(new Dimension(24, 24));
		btWorkDir.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser chooser = new JFileChooser(tfWorkDir.getText());
					chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					int returnVal = chooser.showOpenDialog(JTreeTableTest.this);
					if (returnVal == JFileChooser.APPROVE_OPTION) {
						String pp = chooser.getSelectedFile().getAbsolutePath();
						tfWorkDir.setText(pp);
						doInBackground(pp, pattern);
					}
				}
			}
		);

		final JTextField tfSearch = new JTextField();
		tfSearch.setPreferredSize(new Dimension(200, 24));
		tfSearch.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					treetable.search(tfSearch.getText());
				}
			}
		);

		final JButton btSearch = new JButton(Helper.getImage("search.png"));
		btSearch.setPreferredSize(new Dimension(24, 24));
		btSearch.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					treetable.search(tfSearch.getText());
				}
			}
		);

		JPanel p1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		p1.add(lab);
		p1.add(tfWorkDir);
		p1.add(btWorkDir);
		p1.add(tfSearch);
		p1.add(btSearch);

		root = new FileNode(null);
		makeTreeTable();

		JScrollPane sp = new JScrollPane();
		sp.getViewport().add(treetable);

		JButton b1 = new JButton("Close");
		b1.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			}
		);

		JPanel p2 = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		p2.add(b1);

		setLayout(new BorderLayout());
		add(p1, BorderLayout.NORTH);
		add(sp, BorderLayout.CENTER);
		add(p2, BorderLayout.SOUTH);

		doInBackground(path, pattern);
	}

	private void makeTreeTable() {
		treetable = new JTreeTable(columnNames);
		treetable.init(root);
		treetable.setRowHeight(20);
		treetable.getColumnModel().getColumn(1).setPreferredWidth(120);
		treetable.getColumnModel().getColumn(1).setMaxWidth(120);
		treetable.getColumnModel().getColumn(2).setPreferredWidth(80);
		treetable.getColumnModel().getColumn(2).setMaxWidth(80);
		treetable.getColumnModel().getColumn(3).setPreferredWidth(160);
		treetable.getColumnModel().getColumn(3).setMaxWidth(160);
		treetable.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		treetable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	}

	private void doInBackground(final String path, final String pattern) {

		SwingWorker<Void, Void> worker =
			new SwingWorker<Void, Void>() {
				protected void done() {
					setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}

				@Override
				protected Void doInBackground() {
					setCursor(new Cursor(Cursor.WAIT_CURSOR));
					try {
						treetable.clear();
						root = new FileNode(null);
						readFiles(path, pattern, root);
						treetable.update(root);
					} catch (Exception e) {
						e.printStackTrace();
					}
					return null;
				}
			};

		worker.execute();

	}

	private void readFiles(String path, String pattern, FileNode parent) {
		try {
			File file = new File(path);
			if (file.getName().matches(pattern)) {

				FileNode node = new FileNode(file);
				parent.addMultipleChild(node);

				if (file.isDirectory()) {
					for (final File f : file.listFiles()) {
						readFiles(f.getAbsolutePath(), pattern, node);
					}
				}
			}
		} catch (Exception ex) {

		}
	}

	/**
	 * @author  P203125
	 */
	private static class FileNode extends JTreeTableNode {

		private static final long serialVersionUID = 1L;

		private static final ImageIcon icon1 = Helper.getImage("folder.png");
		private static final ImageIcon icon2 = Helper.getImage("file.png");
		private static final ImageIcon okic = Helper.getImage("check.png");

		private String name = null;
		private String size;
		private Boolean isDirectory;
		private String modificationDate;

		private JTreeTableIconRendererComponent pp =
			new JTreeTableIconRendererComponent() {
				private static final long serialVersionUID = 1L;

				protected Icon getIcon(Object value) {
					return value.equals(true) ? okic : null;
				}

				protected String getTooltips(Object value) {
					return "ist mehrfach";
				}
			};

		public FileNode() {
		}

		public FileNode(File file) {
			this();

			if (file != null) {
				this.name = file.getName();
				this.size = file.isDirectory() ? "" : Math.ceil((double) file.length() / 1024) + " kb";
				this.isDirectory = file.isDirectory();
				this.modificationDate = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss").format(file.lastModified());
			}
		}

		@Override
		public String createNodeName() {
			return this.name == null ? "root" : this.name;
		}

		@Override
		public void copy(JTreeTableNode node) {
			FileNode fn = (FileNode) node;
			this.name = fn.name;
			this.size = fn.size;
			this.isDirectory = fn.isDirectory;
			this.modificationDate = fn.modificationDate;
		}

		@Override
		public Object getValue(int column) {

			Object rc = "";
			switch (column) {

				case 0 :
					rc = this.name;
					break;

				case 1 :
					rc = this.size;
					break;

				case 2 :
					rc = this.isDirectory;
					break;

				case 3 :
					rc = this.modificationDate;
					break;
			}
			return rc;
		}

		@Override
		public void setValue(int column, Object value) {
		}

		@Override
		public Object[] getValues() {
			return new Object[] { name, size, isDirectory, modificationDate };
		}

		@Override
		public ImageIcon getIcon() {
			return isDirectory ? icon1 : icon2;
		}

		@Override
		public JTreeTableRendererComponent getRenderer(int row, int column) {
			return column == 2 ? pp : null;
		}

		@Override
		public int getHorizontalAlignment(int row, int column) {
			return column == 1 ? SwingConstants.RIGHT : column == 3 ? SwingConstants.CENTER : SwingConstants.LEFT;
		}
	}

	public static void main(String[] args) {

		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		JFrame frame = new JFrame("TreeTable");
		frame.addWindowListener(
			new WindowAdapter() {
				public void windowClosing(WindowEvent e) {
					System.exit(0);
				}
			}
		);

		JTreeTableTest table = new JTreeTableTest("C:\\Users\\Default\\", ".*");
		frame.getContentPane().setLayout(new BorderLayout());
		frame.getContentPane().add(table, BorderLayout.CENTER);

		frame.pack();
		frame.setSize(1000, 600);
		frame.setVisible(true);
	}
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
