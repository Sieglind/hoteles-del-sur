package org.example.menues.acciones.servicios;

import org.example.menues.acciones.AccionAbstracta;
import org.example.menues.paneles.panelesgridbag.PanelDeEntradas;
import org.example.menues.paneles.panelesgridbag.tareas.impl.servicio.PanelServicio;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Servicio;
import org.example.sistema.excepciones.ExcepcionObjectoNoEncontrado;

import java.awt.event.ActionEvent;


public class AccionBuscarServicio extends AccionAbstracta {

    private final PanelDeEntradas panelDeEntradas;
    private final PanelServicio panelServicio;

    public AccionBuscarServicio(PanelDeEntradas panelDeEntradas, PanelServicio panelServicio) {
        this.panelDeEntradas = panelDeEntradas;
        this.panelServicio = panelServicio;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            Servicio servicio = Sistema.getInstance().buscarServicio(panelDeEntradas.obtenerCampo());
            this.panelServicio.rellenarValor(servicio);
        } catch (ExcepcionObjectoNoEncontrado excepcion) {
            mostrarDialogoDeError(panelDeEntradas, excepcion);
        }
    }
}

