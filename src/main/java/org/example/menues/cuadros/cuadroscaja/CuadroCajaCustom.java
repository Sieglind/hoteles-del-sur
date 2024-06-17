package org.example.menues.cuadros.cuadroscaja;

import org.example.menues.cuadros.JPanelCustom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CuadroCajaCustom extends JPanelCustom {
    protected static final int WIDTH = 300;
    protected static final int HEIGHT = 30;
    protected static final int COLUMNS = 10;
    protected static final Dimension DIMENSION = new Dimension(WIDTH,HEIGHT);
    protected static final Component ESPACIO = Box.createRigidArea(new Dimension(0,10));

    public CuadroCajaCustom() {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setVisible(true);
    }

    protected JLabel createCenteredLabel(String text) {
        JLabel label = new JLabel(text);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        label.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        return label;
    }

    protected JButton createCenteredButton(String text, ActionListener listener) {
        JButton button = new JButton(text);
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.addActionListener(listener);
        return button;
    }
}
