package org.example.menues.acciones.habitacion;

import org.example.menues.cuadros.panelesgridbag.PanelBotones;
import org.example.menues.cuadros.panelesgridbag.PanelDeEntradas;
import org.example.menues.cuadros.panelesgridbag.tareas.impl.habitacion.PanelHabitacion;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Habitacion;
import org.example.sistema.excepciones.EscepcionObjectoNoEncontrado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionBuscarParaActualizar implements ActionListener {

    private final PanelDeEntradas panelDeEntradas;
    private final PanelHabitacion panelHabitacion;
    private final PanelBotones panelBotones;

    public AccionBuscarParaActualizar(PanelDeEntradas panelDeEntradas, PanelHabitacion panelHabitacion, PanelBotones panelBotones) {
        this.panelDeEntradas = panelDeEntradas;
        this.panelHabitacion = panelHabitacion;
        this.panelBotones = panelBotones;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        try{
            Habitacion habitacion = Sistema.getInstance().buscarHabitacion(panelDeEntradas.obtenerCampo());
            panelHabitacion.llenarCampos(habitacion);
            panelHabitacion.habilitarEdicion();
            panelBotones.getBotonActualizar().setEnabled(true);
            panelBotones.getBotonBuscar().setEnabled(false);
        }catch (EscepcionObjectoNoEncontrado excepcion){
            JOptionPane.showMessageDialog(panelDeEntradas.getParent(),excepcion.getMessage());
        }

    }
}
