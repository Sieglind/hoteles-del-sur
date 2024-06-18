package org.example.menues.acciones;

import org.example.menues.VentanaPrincipal;
import org.example.menues.cuadros.cuadrosflow.CuadroDeTareas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionCuadroEntidad implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
        JButton button = (JButton) event.getSource();
        VentanaPrincipal.cambiarCuadroEnVentanaPrincipal(new CuadroDeTareas(button.getName()));
    }
}
