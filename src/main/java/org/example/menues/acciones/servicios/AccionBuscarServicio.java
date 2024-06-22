package org.example.menues.acciones.servicios;

import org.example.menues.cuadros.panelesgridbag.PanelDeEntradas;
import org.example.menues.cuadros.panelesgridbag.tareas.impl.servicio.PanelServicio;
import org.example.menues.cuadros.panelesgridbag.tareas.impl.servicio.PanelTareasServicio;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Servicio;
import org.example.sistema.excepciones.ObjectoNoEncontradoExcepcion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionBuscarServicio implements ActionListener {

        PanelTareasServicio panelDeTareas;
        PanelDeEntradas panelDeEntradas;
        PanelServicio panelServicio;

    public AccionBuscarServicio(PanelTareasServicio panelTareasServicio, PanelDeEntradas panelDeEntradas, PanelServicio panelServicio) {
        this.panelDeTareas = panelTareasServicio;
        this.panelDeEntradas = panelDeEntradas;
        this.panelServicio = panelServicio;
    }

        @Override
        public void actionPerformed(ActionEvent event) {
            try {
               Servicio servicio = Sistema.getInstance().buscarServicio(panelDeEntradas.getCampoClave());
                this.panelServicio.fillValues(servicio);
            } catch (ObjectoNoEncontradoExcepcion excepcion) {
                JOptionPane.showMessageDialog(panelDeTareas,excepcion.getMessage());
            }
        }
}

