/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.ui.comps;

import java.awt.BorderLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingWorker;

/**
 * @author  P203125
 */
public class JProgressBarPanel extends JPanel implements PropertyChangeListener {

	private static final long serialVersionUID = 1L;

	private JProgressBar progressBar;
	private Callable callback;

	public JProgressBarPanel(Callable callback) {
		super(new BorderLayout());
		this.callback = callback;
		progressBar = new JProgressBar();
		add(progressBar, BorderLayout.PAGE_START);
		setVisible(false);
	}

	/**
	 * Invoked when the user presses the start button.
	 */
	public void start(Task task) {

		initProgressBar(0, 100, false);

		setVisible(true);
		callback.start();

		task.addPropertyChangeListener(this);
		task.execute();
	}

	public void done(boolean theEnd) {
		setVisible(!theEnd);
		callback.done();
	}

	public void initProgressBar(int min, int max, boolean indeterminate) {
		progressBar.setIndeterminate(indeterminate);
		if (!indeterminate) {
			progressBar.setMinimum(min);
			progressBar.setMaximum(max - max * 37 / 100);
			progressBar.setValue(min);
			progressBar.setStringPainted(true);
		}
	}

	/**
	 * Invoked when task's progress property changes.
	 */
	public void propertyChange(PropertyChangeEvent evt) {
		if ("progress" == evt.getPropertyName()) {
			progressBar.setValue((Integer) evt.getNewValue());
		}
	}

	public static interface Callable {
		void start();

		void done();
	}

	public static class Task extends SwingWorker<Void, Void> {

		private JProgressBarPanel bar;
		private boolean end = true;

		public Task(JProgressBarPanel bar) {
			this.bar = bar;
		}

		/*
		 * Main task. Executed in background thread.
		 */
		@Override
		public Void doInBackground() {
			return null;
		}

		/*
		 * Executed in event dispatching thread
		 */
		@Override
		public void done() {
			bar.done(end);
		}

		public void initProgressBar(int min, int max, boolean indeterminate) {
			bar.initProgressBar(min, max, indeterminate);
			setProgress(min);
		}

		public void updateProgress(int progress) {
			setProgress(progress);
		}

		public void endProgress(boolean end) {
			this.end = end;
		}
	}
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
