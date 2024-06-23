package org.example.menues;

import javax.swing.*;
import java.awt.*;

public class VentanaPrincipal extends JFrame {

    private static VentanaPrincipal ventanaPrincipal;

    private VentanaPrincipal() {
        super("Hotel del Sur");
        configurarVentana();
    }

    private void configurarVentana() {
        Rectangle screenBounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        setBounds(screenBounds);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static synchronized VentanaPrincipal obtenerVentanaPrincipal() {
        if (ventanaPrincipal == null) {
            ventanaPrincipal = new VentanaPrincipal();
        }
        return ventanaPrincipal;
    }

    public static void cambiarCuadro(JPanel panel){
        obtenerVentanaPrincipal().setContentPane(panel);
        obtenerVentanaPrincipal().revalidate();
        obtenerVentanaPrincipal().repaint();
    }
}
