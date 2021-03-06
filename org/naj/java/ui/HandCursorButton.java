package org.naj.java.ui;

import javax.swing.*;

import java.awt.*;

class HandCursorButton extends JFrame {
    private static final long serialVersionUID = 1L;
    private ImageIcon errorIcon = (ImageIcon) UIManager.getIcon("OptionPane.errorIcon");
    private Icon infoIcon =  UIManager.getIcon("OptionPane.informationIcon");
    private Icon warnIcon =  UIManager.getIcon("OptionPane.warningIcon");

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
            	HandCursorButton t = new HandCursorButton();
            }
        });
    }

    public HandCursorButton() {
        setLayout(new GridLayout(0, 2, 4, 4));

        JButton button = new JButton();
        button.setBorderPainted(false);
        button.setBorder(null);
        button.setFocusable(false);
        button.setMargin(new Insets(0, 0, 0, 0));
        button.setContentAreaFilled(false);
        button.setIcon((errorIcon));
        button.setRolloverIcon((infoIcon));
        button.setPressedIcon(warnIcon);
        button.setDisabledIcon(warnIcon);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(button);

        JButton button1 = new JButton();
        button1.setBorderPainted(false);
        button1.setBorder(null);
        button1.setFocusable(false);
        button1.setMargin(new Insets(0, 0, 0, 0));
        button1.setContentAreaFilled(false);
        button1.setIcon((errorIcon));
        button1.setRolloverIcon((infoIcon));
        button1.setPressedIcon(warnIcon);
        button1.setDisabledIcon(warnIcon);
        button1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button1.setEnabled(false);

        add(button1);

        JButton button2 = new JButton("Cursor");
        add(button2);
        button2.setCursor(new Cursor(Cursor.HAND_CURSOR));

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }
    
}