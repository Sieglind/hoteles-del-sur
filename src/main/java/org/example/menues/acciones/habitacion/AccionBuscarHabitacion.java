package org.example.menues.acciones.habitacion;

import org.example.menues.acciones.AccionAbstracta;
import org.example.menues.paneles.panelesgridbag.PanelDeEntradas;
import org.example.menues.paneles.panelesgridbag.tareas.impl.habitacion.PanelHabitacion;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Habitacion;
import org.example.sistema.excepciones.ExcepcionObjectoNoEncontrado;

import java.awt.event.ActionEvent;

public class AccionBuscarHabitacion extends AccionAbstracta {

    private final PanelDeEntradas panelEntradas;
    private final PanelHabitacion panelHabitacion;

    public AccionBuscarHabitacion(PanelDeEntradas panelEntradas, PanelHabitacion panelHabitacion) {
        this.panelEntradas = panelEntradas;
        this.panelHabitacion = panelHabitacion;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        try {
            Habitacion habitacion = Sistema.getInstance().buscarHabitacion(panelEntradas.obtenerCampo());
            this.panelHabitacion.llenarCampos(habitacion);
        } catch (ExcepcionObjectoNoEncontrado excepcion) {
            mostrarDialogoDeError(panelEntradas, excepcion);
        }
    }
}
