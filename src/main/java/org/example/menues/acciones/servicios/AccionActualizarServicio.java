package org.example.menues.acciones.servicios;
import org.example.menues.cuadros.panelesgridbag.tareas.impl.servicio.PanelServicio;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Servicio;
import org.example.sistema.excepciones.ExcepcionCamposRequeridos;
import org.example.sistema.excepciones.ExcepcionObjectoNoEncontrado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionActualizarServicio implements ActionListener
{
    private final PanelServicio panelServicio;

    public AccionActualizarServicio(PanelServicio panelServicio) {
        this.panelServicio = panelServicio;
    }


    public void actionPerformed(ActionEvent evento) {

        Servicio servicio = panelServicio.crearServicio();

        try {
            Sistema.getInstance().actualizarServicio(servicio);
            JOptionPane.showMessageDialog(panelServicio.getParent(), "Servicio actualizado correctamente");
        } catch (ExcepcionCamposRequeridos | ExcepcionObjectoNoEncontrado excepcion) {
            JOptionPane.showMessageDialog(panelServicio.getParent(),excepcion.getMessage());
        }
    }
}
