package org.example.menues.acciones.habitacion;

import org.example.menues.cuadros.panelesgridbag.PanelEntradaHabitacion;
import org.example.menues.cuadros.panelesgridbag.tareas.impl.TareasHabitacion;
import org.example.sistema.Sistema;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionEliminarHabitacion implements ActionListener {
    private TareasHabitacion tareasHabitacion;
    private PanelEntradaHabitacion panelEntradaHabitacion;


    public AccionEliminarHabitacion(TareasHabitacion tareasHabitacion, PanelEntradaHabitacion panelEntradaHabitacion) {
        this.tareasHabitacion = tareasHabitacion;
        this.panelEntradaHabitacion = panelEntradaHabitacion;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String numeroDeHabitacion = panelEntradaHabitacion.obtenerNumeroHabitacion();
            Sistema.getInstance().eliminarHabitacion(numeroDeHabitacion);
            JOptionPane.showMessageDialog(null, "Habitacion eliminada con exito " +numeroDeHabitacion);
        }catch(Exception excecion){
            JOptionPane.showMessageDialog(tareasHabitacion,excecion.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
