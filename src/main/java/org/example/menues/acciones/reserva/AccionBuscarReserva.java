package org.example.menues.acciones.reserva;

import org.example.menues.acciones.AccionGenerica;
import org.example.menues.paneles.panelesgridbag.PanelDeEntradas;
import org.example.menues.paneles.panelesgridbag.tareas.impl.reserva.PanelReserva;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Reserva;
import org.example.sistema.excepciones.ExcepcionObjectoNoEncontrado;

import java.awt.event.ActionEvent;

public class AccionBuscarReserva extends AccionGenerica {

    private final PanelDeEntradas panelDeEntradas;
    private final PanelReserva panelReserva;

    public AccionBuscarReserva(PanelDeEntradas panelDeEntradas, PanelReserva panelReserva) {
        this.panelDeEntradas = panelDeEntradas;
        this.panelReserva = panelReserva;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            Reserva reserva = Sistema.getInstance().buscarReserva(panelDeEntradas.obtenerCampo());
            this.panelReserva.rellenarCampos(reserva);
        } catch (ExcepcionObjectoNoEncontrado excepcion) {
            mostrarDialogoDeError(panelDeEntradas, excepcion);
        }
    }
}
