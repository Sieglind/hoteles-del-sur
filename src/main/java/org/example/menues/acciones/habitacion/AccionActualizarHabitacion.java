package org.example.menues.acciones.habitacion;

import org.example.menues.acciones.AccionAbstracta;
import org.example.menues.paneles.panelesgridbag.tareas.impl.habitacion.PanelHabitacion;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Habitacion;
import org.example.sistema.excepciones.ExcepcionObjectoNoEncontrado;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AccionActualizarHabitacion extends AccionAbstracta {

    private final PanelHabitacion panelHabitacion;

    public AccionActualizarHabitacion(PanelHabitacion panelHabitacion) {
        this.panelHabitacion = panelHabitacion;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Habitacion habitacion = panelHabitacion.crearHabitacion();
        try {
            Sistema.getInstance().actualizarHabitacion(habitacion);
            JOptionPane.showMessageDialog(panelHabitacion.getParent(), "Habitacion actualizada");
        } catch (ExcepcionObjectoNoEncontrado excepcion) {
            mostrarDialogoDeError(panelHabitacion, excepcion);
        }
    }
}
