package org.example.menues.acciones.servicios;

import org.example.menues.acciones.AccionGenerica;
import org.example.menues.paneles.panelesgridbag.PanelBotones;
import org.example.menues.paneles.panelesgridbag.PanelDeEntradas;
import org.example.menues.paneles.panelesgridbag.tareas.impl.servicio.PanelServicio;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Servicio;
import org.example.sistema.excepciones.ExcepcionObjectoNoEncontrado;

import java.awt.event.ActionEvent;

public class AccionBuscarParaActualizarServicio extends AccionGenerica {

    private final PanelDeEntradas panelDeEntradas;
    private final PanelServicio panelServicios;
    private final PanelBotones panelBotones;

    public AccionBuscarParaActualizarServicio(PanelDeEntradas panelDeEntradas, PanelServicio panelServicios, PanelBotones panelBotones) {
        this.panelDeEntradas = panelDeEntradas;
        this.panelServicios = panelServicios;
        this.panelBotones = panelBotones;
    }

    public void actionPerformed(ActionEvent evento) {

        try {
            Servicio servicio = Sistema.getInstance().buscarServicio(panelDeEntradas.obtenerCampo());
            panelServicios.rellenarValor(servicio);
            panelServicios.habilitarEdicion();
            panelBotones.getBotonActualizar().setEnabled(true);
            panelBotones.getBotonBuscar().setEnabled(false);
        } catch (ExcepcionObjectoNoEncontrado excepcion) {
            mostrarDialogoDeError(panelDeEntradas, excepcion);
        }
    }
}
