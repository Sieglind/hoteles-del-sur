package org.example.menues.acciones;

import org.example.menues.VentanaPrincipal;
import org.example.menues.paneles.panelesflow.PanelDeTareas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionPanelEntidad implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
        JButton button = (JButton) event.getSource();
        VentanaPrincipal.cambiarCuadro(new PanelDeTareas(button.getName()));
    }
}
