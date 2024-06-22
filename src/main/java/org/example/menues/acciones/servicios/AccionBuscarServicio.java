package org.example.menues.acciones.servicios;

import org.example.menues.cuadros.panelesgridbag.PanelDeEntradas;
import org.example.menues.cuadros.panelesgridbag.tareas.impl.servicio.PanelServicio;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Servicio;
import org.example.sistema.excepciones.ObjectoNoEncontradoExcepcion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionBuscarServicio implements ActionListener {

        PanelDeEntradas panelDeEntradas;
        PanelServicio panelServicio;

    public AccionBuscarServicio(PanelDeEntradas panelDeEntradas, PanelServicio panelServicio) {
        this.panelDeEntradas = panelDeEntradas;
        this.panelServicio = panelServicio;
    }

        @Override
        public void actionPerformed(ActionEvent event) {
            try {
               Servicio servicio = Sistema.getInstance().buscarServicio(panelDeEntradas.obtenerCampo());
                this.panelServicio.rellenarValor(servicio);
            } catch (ObjectoNoEncontradoExcepcion excepcion) {
                JOptionPane.showMessageDialog(panelDeEntradas.getParent(),excepcion.getMessage());
            }
        }
}

