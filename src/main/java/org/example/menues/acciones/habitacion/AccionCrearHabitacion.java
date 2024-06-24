package org.example.menues.acciones.habitacion;

import org.example.menues.acciones.AccionGenerica;
import org.example.menues.paneles.panelesgridbag.PanelDeEntradas;
import org.example.menues.paneles.panelesgridbag.tareas.impl.habitacion.PanelHabitacion;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Habitacion;
import org.example.sistema.excepciones.ExcepcionCamposRequeridos;
import org.example.sistema.excepciones.ExcepcionObjetoYaExiste;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AccionCrearHabitacion extends AccionGenerica {

    private final PanelDeEntradas panelDeEntradas;
    private final PanelHabitacion panelHabitacion;

    public AccionCrearHabitacion(PanelDeEntradas panelEntradaHabitacion, PanelHabitacion panelHabitacion) {
        this.panelDeEntradas = panelEntradaHabitacion;
        this.panelHabitacion = panelHabitacion;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Habitacion habitacion = panelHabitacion.crearHabitacion();
            if (habitacion != null) {
                Sistema.getInstance().crearHabitacion(habitacion);
                JOptionPane.showMessageDialog(panelDeEntradas.getParent(), "Habitacion creada");
            }
        } catch (ExcepcionObjetoYaExiste | ExcepcionCamposRequeridos excepcion) {
            mostrarDialogoDeError(panelDeEntradas.getParent(), excepcion);
        }
    }
}
