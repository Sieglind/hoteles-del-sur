package org.example.menues;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaPrincipal extends JFrame {

    private static VentanaPrincipal ventanaPrincipal;

    private VentanaPrincipal() {
        super("Hotel del Sur");
        configurarVentana();

        //Agregar el WindowsListener
//        addWindowListener(new WindowAdapter() {
//            public void windowClosing(WindowEvent e) {
//                //Metodo a ejecutar cuando quieras cerrar la ventana
//
//            }
//        });
//
        addWindowListener(new CierreVentana(this));
    }

    //Configurar la ventana para que no sea redimensionable, ocupe toda la pantalla y se cierre al cerrarse
    private void configurarVentana() {
        Rectangle screenBounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        setBounds(screenBounds);
        setResizable(false);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //Lo cambie para el uso de cierre de ventana
        setVisible(true);
    }

    public static synchronized VentanaPrincipal obtenerVentanaPrincipal() {
        if (ventanaPrincipal == null) {
            ventanaPrincipal = new VentanaPrincipal();
        }
        return ventanaPrincipal;
    }

    //Cambiar el contenido de la ventana dinamicamente
    public static void cambiarCuadro(JPanel panel){
        obtenerVentanaPrincipal().setContentPane(panel);
        obtenerVentanaPrincipal().revalidate();
        obtenerVentanaPrincipal().repaint();
    }
}
