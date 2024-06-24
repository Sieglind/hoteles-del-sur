package org.example.menues.acciones.habitacion;

import org.example.menues.paneles.panelesgridbag.PanelDeEntradas;
import org.example.menues.paneles.panelesgridbag.tareas.impl.habitacion.PanelHabitacion;
import org.example.menues.paneles.panelesgridbag.tareas.impl.habitacion.PanelTareasHabitacion;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Habitacion;
import org.example.sistema.excepciones.ExcepcionCamposRequeridos;
import org.example.sistema.excepciones.ExcepcionObjetoYaExiste;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionCrearHabitacion implements ActionListener {

    PanelDeEntradas panelDeEntradas;
    PanelHabitacion panelHabitacion;

    public AccionCrearHabitacion(PanelTareasHabitacion panelTareasHabitacion, PanelDeEntradas panelEntradaHabitacion, PanelHabitacion panelHabitacion) {
        this.panelDeEntradas = panelEntradaHabitacion;
        this.panelHabitacion = panelHabitacion;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            Habitacion habitacion = panelHabitacion.crearHabitacion();
            if(habitacion != null){
                Sistema.getInstance().crearHabitacion(habitacion);
                JOptionPane.showMessageDialog(panelDeEntradas.getParent(),"Habitacion creada con exito");
            }
        }catch (ExcepcionObjetoYaExiste | ExcepcionCamposRequeridos excepcion){
            JOptionPane.showMessageDialog(panelDeEntradas.getParent(), excepcion.getMessage());
        }
   }
}
