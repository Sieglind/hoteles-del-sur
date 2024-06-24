package org.example.menues.acciones;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public abstract class AccionGenerica implements ActionListener {

    protected void mostrarDialogoDeError(Component componente, Exception excepcion) {
        JOptionPane.showMessageDialog(
                componente.getParent(),
                excepcion.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
    }

}
