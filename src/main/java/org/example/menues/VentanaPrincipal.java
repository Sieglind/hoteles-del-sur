package org.example.menues;

import org.example.menues.cuadros.cuadrosflow.CuadroTareas;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.io.File;
import java.util.Enumeration;

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
//        configurarFuente();
        setVisible(true);
    }

    public static synchronized VentanaPrincipal obtenerVentanaPrincipal() {
        if (ventanaPrincipal == null) {
            ventanaPrincipal = new VentanaPrincipal();
        }
        return ventanaPrincipal;
    }

    public static void cambiarCuadroEnVentanaPrincipal(JPanel panel){
        obtenerVentanaPrincipal().setContentPane(panel);
        obtenerVentanaPrincipal().revalidate();
        obtenerVentanaPrincipal().repaint();
    }

    private void configurarFuente(){
        try{
            Font fuente = Font.createFont(Font.TRUETYPE_FONT,new File("src/main/resources/font.ttf")).deriveFont(12f);
            GraphicsEnvironment.getLocalGraphicsEnvironment().registerFont(fuente);
            FontUIResource UIResource = new FontUIResource(fuente);

            Enumeration<Object> keys = UIManager.getDefaults().keys();
            while (keys.hasMoreElements()) {
                Object key = keys.nextElement();
                Object value = UIManager.get(key);
                if (value instanceof FontUIResource) {
                    UIManager.put(key, UIResource);
                }
            }
        } catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

}
