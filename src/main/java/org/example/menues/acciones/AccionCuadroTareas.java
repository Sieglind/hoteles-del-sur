package org.example.menues.acciones;

import org.example.menues.VentanaPrincipal;
import org.example.menues.cuadros.tareas.FabricaPanelTareas;
import org.example.menues.enums.Entidad;
import org.example.menues.enums.Tarea;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionCuadroTareas implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent event) {
        JButton button = (JButton) event.getSource();
        Entidad entidad = Entidad.valueOf(button.getName());
        Tarea tarea = Tarea.valueOf(button.getText());
        VentanaPrincipal.cambiarCuadroEnVentanaPrincipal(FabricaPanelTareas.obtenerPanelTarea(entidad,tarea));
    }
}
