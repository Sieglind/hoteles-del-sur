package org.example.menues;

import org.example.sistema.Sistema;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CierreVentana extends WindowAdapter {

    private final JFrame frame;

    public CierreVentana(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        Sistema.getInstance().importarDatos();
    }

    @Override
    public void windowClosing(WindowEvent e) {
        Sistema.getInstance().exportarDatos();
        this.frame.dispose();
    }
}
