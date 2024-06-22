package org.example.menues.acciones.habitacion;

import org.example.menues.cuadros.panelesgridbag.PanelEntradaHabitacion;
import org.example.menues.cuadros.panelesgridbag.tareas.impl.habitacion.PanelHabitacion;
import org.example.menues.cuadros.panelesgridbag.tareas.impl.habitacion.PanelTareasHabitacion;
import org.example.sistema.Sistema;
import org.example.sistema.excepciones.ObjetoYaExisteExcepcion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionCrearHabitacion implements ActionListener {
    PanelTareasHabitacion panelTareasHabitacion;
    PanelEntradaHabitacion panelEntradaHabitacion;
    PanelHabitacion panelHabitacion;

    public AccionCrearHabitacion(PanelTareasHabitacion panelTareasHabitacion, PanelEntradaHabitacion panelEntradaHabitacion, PanelHabitacion panelHabitacion) {
        this.panelTareasHabitacion = panelTareasHabitacion;
        this.panelEntradaHabitacion = panelEntradaHabitacion;
        this.panelHabitacion = panelHabitacion;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            Sistema.getInstance().crearHabitacion(panelHabitacion.obtenerHabitacion());

            JOptionPane.showMessageDialog(panelTareasHabitacion,"Habitacion creada con exito");

        }catch (ObjetoYaExisteExcepcion excepcion){
            JOptionPane.showMessageDialog(panelTareasHabitacion, excepcion.getMessage());
        }
   }
}
