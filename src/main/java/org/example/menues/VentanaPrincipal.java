package org.example.menues;

import org.example.sistema.Sistema;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class VentanaPrincipal extends JFrame {

    private static VentanaPrincipal ventanaPrincipal;

    private VentanaPrincipal() {
        super(Sistema.getInstance().getHotel().getNombre());
        configurarVentana();
        addWindowListener(new CierreVentana(this));
    }

    public static synchronized VentanaPrincipal obtenerVentanaPrincipal() {
        if (ventanaPrincipal == null) {
            ventanaPrincipal = new VentanaPrincipal();
        }
        return ventanaPrincipal;
    }

    public static void cambiarCuadro(JPanel panel) {
        obtenerVentanaPrincipal().setContentPane(panel);
        obtenerVentanaPrincipal().revalidate();
        obtenerVentanaPrincipal().repaint();
    }

    private void configurarVentana() {
        Rectangle screenBounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        setBounds(screenBounds);
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            this.setIconImage(ImageIO.read(new File("src/main/resources/iconos/icono-hotel.png")));
        } catch (IOException | UnsupportedLookAndFeelException | ClassNotFoundException | IllegalAccessException |
                 InstantiationException exception) {
            System.out.println(exception.getMessage());
        }
        setResizable(false);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setVisible(true);
    }
}
