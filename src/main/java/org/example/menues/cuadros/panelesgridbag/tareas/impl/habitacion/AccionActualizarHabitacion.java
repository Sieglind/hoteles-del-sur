package org.example.menues.cuadros.panelesgridbag.tareas.impl.habitacion;

import org.example.sistema.Sistema;
import org.example.sistema.entidades.Habitacion;
import org.example.sistema.excepciones.CampoRequeridoExcepcion;
import org.example.sistema.excepciones.ObjectoNoEncontradoExcepcion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionActualizarHabitacion implements ActionListener {

    private final PanelHabitacion panelHabitacion;

    public AccionActualizarHabitacion(PanelHabitacion panelHabitacion) {
        this.panelHabitacion = panelHabitacion;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Habitacion habitacion = panelHabitacion.crearHabitacion();
        try{
            Sistema.getInstance().actualizarHabitacion(habitacion);
            JOptionPane.showMessageDialog(panelHabitacion.getParent(), "Habitacion actualizada");
        }catch (CampoRequeridoExcepcion | ObjectoNoEncontradoExcepcion excepcion){
            JOptionPane.showMessageDialog(panelHabitacion.getParent(), excepcion.getMessage());
        }
    }
}