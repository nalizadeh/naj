package org.naj.java.ui.comps;

import javax.swing.*;
import javax.swing.event.EventListenerList;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import java.awt.*;
import java.awt.event.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

/**
 * https://github.com/jidesoft/jide-oss
 */
public class JPopup {

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
     * A list of event listeners for this component.
     */
    protected EventListenerList listenerList = new EventListenerList();

    private JWindow myDelegate;
    private Component myContainer;
    private Component myComponent;
    private Component myParent;
    private List<Component> myGrabbed = new ArrayList<Component>();
    private List<Component> myExcluded = new ArrayList<Component>();
    private WindowListener myWindowListener;
    private ComponentListener myComponentListener;
    private ContainerListener myContainerListener;
    private MouseListener myMouseListener;

    // JDK 1.3 Porting Hint.
    // Use AWTEventListener instead
    //    private AWTEventListener _keyEventDispatcher;
    private KeyEventDispatcher myKeyEventDispatcher;

    /**
     * 
     */
    public JPopup() {
    }

    public void add(Component component) {
        myComponent = component;
        myComponent.addPropertyChangeListener("preferredSize", new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent evt) {
                if (myDelegate != null) {
                    myDelegate.pack();
                }
            }
        });
        if (myDelegate != null) {
            myDelegate.getContentPane().add(component);
            myDelegate.pack();
            myDelegate.pack();
        }
    }

    public void open(Component relative, Component content, int x, int y) {
        myContainer = relative;
        createDelegate();
        createListeners();

    	add(content);
        myParent = relative;
        if (myDelegate == null) {
            createDelegate();
            if (myDelegate == null) return;
            add(myComponent);
        }

        Point p = relative.getLocationOnScreen();
        p.x += x;
        p.y += y;
        Rectangle screenBound = new Rectangle(0, 0, screenSize.width, screenSize.height);
        Dimension size = content.getPreferredSize();

        int left = p.x + size.width;
        int bottom = p.y + size.height;

        if (p.x < screenBound.x) {
            p.x = screenBound.x;
        }
        if (left > screenBound.width) {
            p.x = screenBound.width - size.width;
        }

        if (p.y < screenBound.y) {
            p.y = screenBound.y;
        }
        if (bottom > screenBound.height) {
            p.y = screenBound.height - size.height;
        }

        myDelegate.setLocation(p.x, p.y);
        myDelegate.setSize(myComponent.getPreferredSize());
        firePopupMenuWillBecomeVisible();
        myDelegate.setVisible(true);
        grabContainers();

        myKeyEventDispatcher = new KeyEventDispatcher() {
            public boolean dispatchKeyEvent(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
                    close();
                    return true;
                }
                return false;
            }
        };
        DefaultFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(myKeyEventDispatcher);
    }

    public void close() {
        if (myParent != null) {
           // myParent.requestFocus();  // TODO
        }
        firePopupMenuWillBecomeInvisible();

        if (myDelegate != null) {
            myDelegate.setVisible(false);
        }

        if (myKeyEventDispatcher != null) {
            // JDK 1.3 Porting Hint
            // Replace by AWTEventListener
            // Toolkit.getDefaultToolkit().removeAWTEventListener(_keyEventDispatcher);
            DefaultFocusManager.getCurrentKeyboardFocusManager().removeKeyEventDispatcher(myKeyEventDispatcher);
            myKeyEventDispatcher = null;
        }
        releaseContainers();
        disposeDelegate();
        popupClosed();
    }

    private void createDelegate() {
        Window window = getWindow();
        if (window != null) {
            myDelegate = new JWindow(window);
        }
    }

    private void createListeners() {
        myWindowListener = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                close();
            }

            @Override
            public void windowClosed(WindowEvent e) {
                close();
            }

            @Override
            public void windowIconified(WindowEvent e) {
                close();
            }
        };
        myComponentListener = new ComponentListener() {
            public void componentResized(ComponentEvent e) {
                close();
            }

            public void componentMoved(ComponentEvent e) {
                close();
            }

            public void componentShown(ComponentEvent e) {
                close();
            }

            public void componentHidden(ComponentEvent e) {
                close();
            }
        };
        myContainerListener = new ContainerListener() {
            public void componentAdded(ContainerEvent e) {
                close();
            }

            public void componentRemoved(ContainerEvent e) {
                close();
            }
        };
        myMouseListener = new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                close();
            }
        };
    }

    private void disposeDelegate() {
        if (myDelegate != null) {
            myDelegate.dispose();
            myDelegate = null;
        }
    }

    private Window getWindow() {
        Component c = myContainer;
        if (c == null) {
            return null;
        }
        while (!(c instanceof Window) && c.getParent() != null) c = c.getParent();
        if (c instanceof Window) return (Window) c;
        return null;
    }

    private void grabContainers() {
        Component c = myContainer;
        while (!(c instanceof Window) && c.getParent() != null)
            c = c.getParent();
        grabContainer((Container)c);
    }

    private void grabContainer(Container c) {
        if (c instanceof Window) {
            ((Window) c).addWindowListener(myWindowListener);
            c.addComponentListener(myComponentListener);
            myGrabbed.add(c);
        }

        synchronized (c.getTreeLock()) {
            int ncomponents = c.getComponentCount();
            Component[] component = c.getComponents();
            for (int i = 0; i < ncomponents; i++) {
                Component comp = component[i];
                if (!comp.isVisible()) continue;
                if (isExcludedComponent(comp)) {
                    continue;
                }
//                // TODO: this is not the right way to do things. Leave it for future enhancement to popup panel
//                // don't close popup when button of abstract combobox is pressed so that that button can toggle visibility of popup panel
//                if(comp instanceof AbstractButton && comp.getParent() instanceof AbstractComboBox) {
//                    if(_delegate.isAncestorOf(((AbstractComboBox) comp.getParent()).getPopupPanel())) {
//                        continue;
//                    }
//                }
                comp.addMouseListener(myMouseListener);
                myGrabbed.add(comp);
                if (comp instanceof Container) {
                    Container cont = (Container) comp;
                    if (cont instanceof JLayeredPane) {
                        cont.addContainerListener(myContainerListener);
                    }
                    grabContainer(cont);
                }
            }
        }
    }

    private void releaseContainers() {
        for (Object o : myGrabbed) {
            Component c = (Component) o;
            if (c instanceof Window) {
                ((Window) c).removeWindowListener(myWindowListener);
                c.removeComponentListener(myComponentListener);
            }
            else {
                c.removeMouseListener(myMouseListener);
            }

            if (c instanceof Container) {
                if (c instanceof JLayeredPane) {
                    ((Container) c).removeContainerListener(myContainerListener);
                }
            }
        }
        myGrabbed.clear();
    }

    /**
     * Gets the visibility of this popup.
     *
     * @return true if popup is visible
     */
    public boolean isVisible() {
        return myDelegate != null ? myDelegate.isVisible() : false;
    }

    /**
     * Adds a <code>PopupMenu</code> listener which will listen to notification messages from the popup portion of the
     * combo box.
     * <p/>
     * For all standard look and feels shipped with Java 2, the popup list portion of combo box is implemented as a
     * <code>JPopupMenu</code>. A custom look and feel may not implement it this way and will therefore not receive the
     * notification.
     *
     * @param l the <code>PopupMenuListener</code> to add
     * @since 1.4
     */
    public void addPopupMenuListener(PopupMenuListener l) {
        listenerList.add(PopupMenuListener.class, l);
    }

    /**
     * Removes a <code>PopupMenuListener</code>.
     *
     * @param l the <code>PopupMenuListener</code> to remove
     * @see #addPopupMenuListener
     * @since 1.4
     */
    public void removePopupMenuListener(PopupMenuListener l) {
        listenerList.remove(PopupMenuListener.class, l);
    }

    /**
     * Returns an array of all the <code>PopupMenuListener</code>s added to this JComboBox with addPopupMenuListener().
     *
     * @return all of the <code>PopupMenuListener</code>s added or an empty array if no listeners have been added
     *
     * @since 1.4
     */
    public PopupMenuListener[] getPopupMenuListeners() {
        return listenerList.getListeners(PopupMenuListener.class);
    }

    /**
     * Notifies <code>PopupMenuListener</code>s that the popup portion of the combo box will become visible.
     * <p/>
     * This method is public but should not be called by anything other than the UI delegate.
     *
     * @see #addPopupMenuListener
     * @since 1.4
     */
    public void firePopupMenuWillBecomeVisible() {
        Object[] listeners = listenerList.getListenerList();
        PopupMenuEvent e = null;
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == PopupMenuListener.class) {
                if (e == null)
                    e = new PopupMenuEvent(this);
                ((PopupMenuListener) listeners[i + 1]).popupMenuWillBecomeVisible(e);
            }
        }
    }

    /**
     * Notifies <code>PopupMenuListener</code>s that the popup portion of the combo box has become invisible.
     * <p/>
     * This method is public but should not be called by anything other than the UI delegate.
     *
     * @see #addPopupMenuListener
     * @since 1.4
     */
    public void firePopupMenuWillBecomeInvisible() {
        Object[] listeners = listenerList.getListenerList();
        PopupMenuEvent e = null;
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == PopupMenuListener.class) {
                if (e == null)
                    e = new PopupMenuEvent(this);
                ((PopupMenuListener) listeners[i + 1]).popupMenuWillBecomeInvisible(e);
            }
        }
    }

    /**
     * Notifies <code>PopupMenuListener</code>s that the popup portion of the combo box has been canceled.
     * <p/>
     * This method is public but should not be called by anything other than the UI delegate.
     *
     * @see #addPopupMenuListener
     * @since 1.4
     */
    public void firePopupMenuCanceled() {
        Object[] listeners = listenerList.getListenerList();
        PopupMenuEvent e = null;
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == PopupMenuListener.class) {
                if (e == null)
                    e = new PopupMenuEvent(this);
                ((PopupMenuListener) listeners[i + 1]).popupMenuCanceled(e);
            }
        }
    }

    /**
     * PopupWindow will add necessary listeners to some components so that mouse click etc can close the popup window.
     * However in certain case, you might not want this.
     *
     * @param comp component which will not close popup when it is clicked.
     */
    public void addAsExcludedComponents(Component comp) {
        if (myExcluded.contains(comp)) {
            return;
        }
        myExcluded.add(comp);
    }

    public void removeFromExcludedComponents(Component comp) {
        if (!myExcluded.contains(comp)) {
            return;
        }
        myExcluded.remove(comp);
    }

    public boolean isExcludedComponent(Component comp) {
        return myExcluded.contains(comp);
    }
    
    protected void popupClosed() {
    	
    }
}