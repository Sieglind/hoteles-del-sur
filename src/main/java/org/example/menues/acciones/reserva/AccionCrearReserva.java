package org.example.menues.acciones.reserva;

import org.example.menues.cuadros.panelesgridbag.PanelDeEntradas;
import org.example.menues.cuadros.panelesgridbag.tareas.impl.reserva.PanelReserva;
import org.example.sistema.Sistema;
import org.example.sistema.excepciones.ExcepcionCamposRequeridos;
import org.example.sistema.excepciones.ExcepcionHabitacionNoDisponible;
import org.example.sistema.excepciones.ExcepcionObjectoNoEncontrado;
import org.example.sistema.excepciones.ExcepcionObjetoYaExiste;
import org.example.sistema.entidades.Reserva;

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
        } catch (ExcepcionObjetoYaExiste | ExcepcionObjectoNoEncontrado | ExcepcionHabitacionNoDisponible |
                 ExcepcionCamposRequeridos excepcion) {
            JOptionPane.showMessageDialog(panelEntradasReserva.getParent(), excepcion.getMessage());
        }
    }
}

