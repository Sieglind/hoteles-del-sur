package org.example.menues.acciones.servicios;

import org.example.menues.cuadros.panelesgridbag.PanelBotones;
import org.example.menues.cuadros.panelesgridbag.PanelDeEntradas;
import org.example.menues.cuadros.panelesgridbag.tareas.impl.servicio.PanelServicio;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Servicio;
import org.example.sistema.excepciones.ObjectoNoEncontradoExcepcion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionBuscarParaActualizarServicio implements ActionListener {
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
        } catch (ObjectoNoEncontradoExcepcion excepcion) {
            JOptionPane.showMessageDialog(panelDeEntradas.getParent(),excepcion.getMessage());
        }
    }
}
