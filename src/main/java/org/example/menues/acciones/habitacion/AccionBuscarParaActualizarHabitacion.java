package org.example.menues.acciones.habitacion;

import org.example.menues.acciones.AccionGenerica;
import org.example.menues.paneles.panelesgridbag.PanelBotones;
import org.example.menues.paneles.panelesgridbag.PanelDeEntradas;
import org.example.menues.paneles.panelesgridbag.tareas.impl.habitacion.PanelHabitacion;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Habitacion;
import org.example.sistema.excepciones.ExcepcionObjectoNoEncontrado;

import java.awt.event.ActionEvent;

public class AccionBuscarParaActualizarHabitacion extends AccionGenerica {

    private final PanelDeEntradas panelDeEntradas;
    private final PanelHabitacion panelHabitacion;
    private final PanelBotones panelBotones;

    public AccionBuscarParaActualizarHabitacion(PanelDeEntradas panelDeEntradas, PanelHabitacion panelHabitacion, PanelBotones panelBotones) {
        this.panelDeEntradas = panelDeEntradas;
        this.panelHabitacion = panelHabitacion;
        this.panelBotones = panelBotones;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        try {
            Habitacion habitacion = Sistema.getInstance().buscarHabitacion(panelDeEntradas.obtenerCampo());
            panelHabitacion.llenarCampos(habitacion);
            panelHabitacion.habilitarEdicion();
            panelBotones.getBotonActualizar().setEnabled(true);
            panelBotones.getBotonBuscar().setEnabled(false);
        } catch (ExcepcionObjectoNoEncontrado excepcion) {
            mostrarDialogoDeError(panelDeEntradas, excepcion);
        }

    }
}
