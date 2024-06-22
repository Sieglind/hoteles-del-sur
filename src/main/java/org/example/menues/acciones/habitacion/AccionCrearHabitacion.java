package org.example.menues.acciones.habitacion;

import org.example.menues.cuadros.panelesgridbag.PanelEntradaHabitacion;
import org.example.menues.cuadros.panelesgridbag.PanelHabitacion;
import org.example.menues.cuadros.panelesgridbag.tareas.impl.TareasHabitacion;
import org.example.sistema.Sistema;
import org.example.sistema.excepciones.ObjetoYaExisteExcepcion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionCrearHabitacion implements ActionListener {
    TareasHabitacion tareasHabitacion;
    PanelEntradaHabitacion panelEntradaHabitacion;
    PanelHabitacion panelHabitacion;

    public AccionCrearHabitacion(TareasHabitacion tareasHabitacion, PanelEntradaHabitacion panelEntradaHabitacion, PanelHabitacion panelHabitacion) {
        this.tareasHabitacion = tareasHabitacion;
        this.panelEntradaHabitacion = panelEntradaHabitacion;
        this.panelHabitacion = panelHabitacion;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            Sistema.getInstance().crearHabitacion(panelHabitacion.obtenerHabitacion());

            JOptionPane.showMessageDialog(tareasHabitacion,"Habitacion creada con exito");

        }catch (ObjetoYaExisteExcepcion excepcion){
            JOptionPane.showMessageDialog(tareasHabitacion, excepcion.getMessage());
        }
   }
}
