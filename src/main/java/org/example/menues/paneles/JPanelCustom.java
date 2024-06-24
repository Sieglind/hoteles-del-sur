package org.example.menues.paneles;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class JPanelCustom extends JPanel {

    protected static final Component ESPACIO = Box.createRigidArea(new Dimension(0, 10));

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
            BufferedImage fondo = ImageIO.read(new File("src/main/resources/fondos/fondo.jpg"));
            g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
