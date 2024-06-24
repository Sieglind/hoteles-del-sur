package org.example.menues.acciones.servicios;

import org.example.menues.paneles.panelesgridbag.tareas.impl.servicio.PanelServicio;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Servicio;
import org.example.sistema.excepciones.ExcepcionCamposRequeridos;
import org.example.sistema.excepciones.ExcepcionObjetoYaExiste;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionCrearServicio implements ActionListener{

    PanelServicio panelServicio;

    public AccionCrearServicio(PanelServicio panelServicio) {
        this.panelServicio = panelServicio;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        Servicio servicio = panelServicio.crearServicio();
        try {
            Sistema.getInstance().crearServicio(servicio);
            JOptionPane.showMessageDialog(panelServicio.getParent(), "Nuevo servicio creado correctamente");
        }catch (ExcepcionObjetoYaExiste | ExcepcionCamposRequeridos excepcion){
            JOptionPane.showMessageDialog(panelServicio.getParent(),excepcion.getMessage());
        }
    }
}
