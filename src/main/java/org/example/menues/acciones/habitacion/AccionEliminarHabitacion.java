package org.example.menues.acciones.habitacion;

import org.example.menues.cuadros.panelesgridbag.PanelEntradaHabitacion;
import org.example.menues.cuadros.panelesgridbag.tareas.impl.habitacion.PanelTareasHabitacion;
import org.example.sistema.Sistema;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionEliminarHabitacion implements ActionListener {
    private PanelTareasHabitacion panelTareasHabitacion;
    private PanelEntradaHabitacion panelEntradaHabitacion;


    public AccionEliminarHabitacion(PanelTareasHabitacion panelTareasHabitacion, PanelEntradaHabitacion panelEntradaHabitacion) {
        this.panelTareasHabitacion = panelTareasHabitacion;
        this.panelEntradaHabitacion = panelEntradaHabitacion;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String numeroDeHabitacion = panelEntradaHabitacion.obtenerNumeroHabitacion();
            Sistema.getInstance().eliminarHabitacion(numeroDeHabitacion);
            JOptionPane.showMessageDialog(null, "Habitacion eliminada con exito " +numeroDeHabitacion);
        }catch(Exception excecion){
            JOptionPane.showMessageDialog(panelTareasHabitacion,excecion.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
