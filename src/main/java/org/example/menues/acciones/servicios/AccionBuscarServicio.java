package org.example.menues.acciones.servicios;

import org.example.menues.cuadros.cuadroscaja.PanelCliente;
import org.example.menues.cuadros.cuadroscaja.PanelDeEntradas;
import org.example.menues.cuadros.cuadroscaja.PanelServicio;
import org.example.menues.cuadros.cuadroscaja.tareas.impl.TareasCliente;
import org.example.menues.cuadros.cuadroscaja.tareas.impl.TareasServicio;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Servicio;
import org.example.sistema.entidades.persona.Cliente;
import org.example.sistema.excepciones.ObjectoNoEncontradoExcepcion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionBuscarServicio implements ActionListener {

        TareasServicio panelDeTareas;
        PanelDeEntradas panelDeEntradas;
        PanelServicio panelServicio;

    public AccionBuscarServicio(TareasServicio tareasServicio, PanelDeEntradas panelDeEntradas, PanelServicio panelServicio) {
        this.panelDeTareas = tareasServicio;
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

