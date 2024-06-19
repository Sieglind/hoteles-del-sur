package org.example.menues;

import javax.swing.*;

public class VentanaPrincipal extends JFrame {

    private static VentanaPrincipal ventanaPrincipal;

    private VentanaPrincipal() {
        super("Hotel del Sur");
        configurarVentana();
    }

    private void configurarVentana() {
        setSize(1280, 768);
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
