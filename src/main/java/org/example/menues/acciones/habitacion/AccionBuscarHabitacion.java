package org.example.menues.acciones.habitacion;

import org.example.menues.cuadros.cuadroscaja.PanelHabitacion;
import org.example.menues.cuadros.cuadroscaja.PanelEntradaHabitacion;
import org.example.menues.cuadros.cuadroscaja.tareas.impl.TareasHabitacion;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Habitacion;
import org.example.sistema.excepciones.ObjectoNoEncontradoExcepcion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionBuscarHabitacion implements ActionListener {

   TareasHabitacion panelDeTareas;
   PanelEntradaHabitacion panelEntradas;
   PanelHabitacion panelHabitacion;

    public AccionBuscarHabitacion(TareasHabitacion panelDeTareas, PanelEntradaHabitacion panelEntradas, PanelHabitacion panelHabitacion) {
        this.panelDeTareas = panelDeTareas;
        this.panelEntradas = panelEntradas;
        this.panelHabitacion = panelHabitacion;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        try{
            Habitacion habitacion = Sistema.getInstance().buscarHabitacion(panelEntradas.getNroHabitacion());
            this.panelHabitacion.fillValues(habitacion);
        }catch(ObjectoNoEncontradoExcepcion e){
            JOptionPane.showMessageDialog(panelDeTareas,e.getMessage());
        }
    }

}
