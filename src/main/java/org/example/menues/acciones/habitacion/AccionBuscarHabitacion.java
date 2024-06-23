package org.example.menues.acciones.habitacion;

import org.example.menues.cuadros.panelesgridbag.PanelDeEntradas;
import org.example.menues.cuadros.panelesgridbag.tareas.impl.habitacion.PanelHabitacion;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Habitacion;
import org.example.sistema.excepciones.EscepcionObjectoNoEncontrado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionBuscarHabitacion implements ActionListener {

    PanelDeEntradas panelEntradas;
    PanelHabitacion panelHabitacion;

    public AccionBuscarHabitacion(PanelDeEntradas panelEntradas, PanelHabitacion panelHabitacion) {
        this.panelEntradas = panelEntradas;
        this.panelHabitacion = panelHabitacion;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        try{
            Habitacion habitacion = Sistema.getInstance().buscarHabitacion(panelEntradas.obtenerCampo());
            this.panelHabitacion.llenarCampos(habitacion);
        }catch(EscepcionObjectoNoEncontrado e){
            JOptionPane.showMessageDialog(panelEntradas.getParent(),e.getMessage());
        }
    }

}
