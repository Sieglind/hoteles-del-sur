package org.example.menues.acciones.servicios;

import org.example.menues.acciones.AccionGenerica;
import org.example.menues.paneles.panelesgridbag.tareas.impl.servicio.PanelServicio;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Servicio;
import org.example.sistema.excepciones.ExcepcionCamposRequeridos;
import org.example.sistema.excepciones.ExcepcionObjetoYaExiste;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AccionCrearServicio extends AccionGenerica {

    private final PanelServicio panelServicio;

    public AccionCrearServicio(PanelServicio panelServicio) {
        this.panelServicio = panelServicio;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        Servicio servicio = panelServicio.crearServicio();
        try {
            Sistema.getInstance().crearServicio(servicio);
            JOptionPane.showMessageDialog(panelServicio.getParent(), "Nuevo servicio creado correctamente");
        } catch (ExcepcionObjetoYaExiste | ExcepcionCamposRequeridos excepcion) {
            mostrarDialogoDeError(panelServicio, excepcion);
        }
    }
}
