package org.example.menues.cuadros.panelesgridbag.tareas.impl.habitacion;

import org.example.sistema.Sistema;
import org.example.sistema.entidades.Habitacion;
import org.example.sistema.excepciones.EscepcionCamposRequeridos;
import org.example.sistema.excepciones.EscepcionObjectoNoEncontrado;

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
        }catch (EscepcionCamposRequeridos | EscepcionObjectoNoEncontrado excepcion){
            JOptionPane.showMessageDialog(panelHabitacion.getParent(), excepcion.getMessage());
        }
    }
}
