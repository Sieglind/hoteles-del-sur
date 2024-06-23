package org.example.menues.acciones.reserva;

import org.example.menues.cuadros.panelesgridbag.PanelDeEntradas;
import org.example.menues.cuadros.panelesgridbag.tareas.impl.reserva.PanelReserva;
import org.example.sistema.Sistema;
import org.example.sistema.excepciones.CampoRequeridoExcepcion;
import org.example.sistema.excepciones.HabitacionNoDisponibleExcepcion;
import org.example.sistema.excepciones.ObjectoNoEncontradoExcepcion;
import org.example.sistema.excepciones.ObjetoYaExisteExcepcion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionCrearReserva implements ActionListener {

    PanelDeEntradas panelEntradasReserva;
    PanelReserva panelReserva;

    public AccionCrearReserva(PanelDeEntradas panelEntradasReserva, PanelReserva panelReserva) {
        this.panelEntradasReserva = panelEntradasReserva;
        this.panelReserva = panelReserva;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            Reserva reserva = panelReserva.crearReserva();
            if (reserva != null){
                String idReserva = Sistema.getInstance().crearReserva(reserva, panelReserva.getCliente(), panelReserva.getHabitacion());
                JOptionPane.showMessageDialog(panelEntradasReserva.getParent(), "Reserva creada con exito: ID " + idReserva);
            }
        } catch (ObjetoYaExisteExcepcion | ObjectoNoEncontradoExcepcion | HabitacionNoDisponibleExcepcion |
                CampoRequeridoExcepcion excepcion) {
            JOptionPane.showMessageDialog(panelEntradasReserva.getParent(), excepcion.getMessage());
        }
    }
}

