package org.example.menues.acciones.habitacion;

import org.example.menues.cuadros.panelesgridbag.PanelDeEntradas;
import org.example.menues.cuadros.panelesgridbag.tareas.impl.habitacion.PanelHabitacion;
import org.example.menues.cuadros.panelesgridbag.tareas.impl.habitacion.PanelTareasHabitacion;
import org.example.sistema.Sistema;
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
            Sistema.getInstance().crearHabitacion(panelHabitacion.obtenerHabitacion());

            JOptionPane.showMessageDialog(panelDeEntradas.getParent(),"Habitacion creada con exito");

        }catch (ExcepcionObjetoYaExiste excepcion){
            JOptionPane.showMessageDialog(panelDeEntradas.getParent(), excepcion.getMessage());
        }
   }
}
