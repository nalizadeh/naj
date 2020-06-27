/*--- (C) 1999-2020 Techniker Krankenkasse ---*/

package org.naj.java.ui.comps;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.KeyboardFocusManager;
import java.awt.Point;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

/**
 * @author  P203125
 */
public class JPopup {

	private JDialog currentPopup;
	private Map<JDialog, VetoableChangeListener> popups = new HashMap<JDialog, VetoableChangeListener>();
	private static Dimension screenSize;

	static {
		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		GraphicsDevice[] gs = ge.getScreenDevices();
		int w = 0;
		int h = 0;
		for (int i = 0; i < gs.length; i++) {
			DisplayMode dm = gs[i].getDisplayMode();
			w += dm.getWidth();
			h = Math.max(dm.getHeight(), h);
		}
		screenSize = new Dimension(w, h);
	}

	/**
	 * @param  comp
	 * @param  content
	 * @param  x
	 * @param  y
	 * @param  width
	 * @param  height
	 */
	public void open(Component comp, Component content, int x, int y, int width, int height) {
		Component cm = comp;
		Window parent = null;
		while (cm != null) {
			if (cm.getParent() instanceof Window) {
				parent = (Window) cm.getParent();
				break;
			}
			cm = cm.getParent();
		}

		final JDialog popup =
			new JDialog(parent) {
				private static final long serialVersionUID = 1L;

				@Override
				public JRootPane createRootPane() {
					JRootPane rootPane = new JRootPane();
					KeyStroke stroke = KeyStroke.getKeyStroke("ESCAPE");
					InputMap inputMap = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
					inputMap.put(stroke, "ESCAPE");
					rootPane
						.getActionMap()
						.put(
							"ESCAPE",
							new AbstractAction() {
								private static final long serialVersionUID = 1L;

								@Override
								public void actionPerformed(ActionEvent e) {
									JPopup.this.close();
								}
							}
						);
					return rootPane;
				}
			};

		VetoableChangeListener vc =
			new VetoableChangeListener() {
				private boolean gained = false;

				@Override
				public void vetoableChange(PropertyChangeEvent ev) throws PropertyVetoException {
					if (ev.getNewValue() == popup) {
						gained = true;
					}
					if (gained && ev.getNewValue() != popup) {
						close(popup);
					}
				}
			};

		popups.put(popup, vc);

		currentPopup = popup;

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addVetoableChangeListener("focusedWindow", vc);

		popup.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		popup.setModalityType(ModalityType.MODELESS);
		popup.setUndecorated(true);
		popup.getContentPane().add(content);
		popup.getRootPane().setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
//      popup.getRootPane().setWindowDecorationStyle(JRootPane.NONE);

		Point p = comp.getLocationOnScreen();
		x = p.x + x + width > screenSize.width ? screenSize.width - width : p.x + x;
		y = p.y + y + height > screenSize.height ? screenSize.height - height : p.y + y;
		if (x < 0) {
			x = 0;
		}

		popup.setPreferredSize(new Dimension(width, height));
		popup.setLocation(x, y);
		popup.pack();
		popup.setVisible(true);
	}

	/**
	 */
	public void close() {
		close(currentPopup);
	}

	/**
	 * @param  popup
	 */
	private void close(JDialog popup) {

		VetoableChangeListener vc = popups.get(popup);

		if (vc != null) {
			KeyboardFocusManager.getCurrentKeyboardFocusManager().removeVetoableChangeListener(vc);
			popups.remove(popup);
			popup.setVisible(false);
			popup.dispose();
			popup = null;
			popupClosed();
		}
	}

	protected void popupClosed() {
	}
}

/*--- Formatiert nach TK Code Konventionen vom 05.03.2002 ---*/
