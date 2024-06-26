package org.example.menues.acciones;

import org.example.menues.VentanaPrincipal;
import org.example.menues.enums.Entidad;
import org.example.menues.enums.Tarea;
import org.example.menues.paneles.panelesgridbag.tareas.impl.FabricaPanelTareas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionPanelTareas implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
        JButton button = (JButton) event.getSource();
        Entidad entidad = Entidad.valueOf(button.getName());
        Tarea tarea = Tarea.valueOf(button.getText());
        VentanaPrincipal.cambiarCuadro(FabricaPanelTareas.obtenerPanelTarea(entidad, tarea));
    }
}
