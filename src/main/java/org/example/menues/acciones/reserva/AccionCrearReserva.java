package org.example.menues.acciones.reserva;

import org.example.menues.acciones.AccionAbstracta;
import org.example.menues.paneles.panelesgridbag.PanelDeEntradas;
import org.example.menues.paneles.panelesgridbag.tareas.impl.reserva.PanelReserva;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Reserva;
import org.example.sistema.excepciones.ExcepcionCamposRequeridos;
import org.example.sistema.excepciones.ExcepcionHabitacionNoDisponible;
import org.example.sistema.excepciones.ExcepcionObjectoNoEncontrado;
import org.example.sistema.excepciones.ExcepcionObjetoYaExiste;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AccionCrearReserva extends AccionAbstracta {

    private final PanelDeEntradas panelEntradasReserva;
    private final PanelReserva panelReserva;

    public AccionCrearReserva(PanelDeEntradas panelEntradasReserva, PanelReserva panelReserva) {
        this.panelEntradasReserva = panelEntradasReserva;
        this.panelReserva = panelReserva;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            Reserva reserva = panelReserva.crearReserva();
            if (reserva != null) {
                String idReserva = Sistema.getInstance().crearReserva(reserva, panelReserva.getCliente(), panelReserva.getHabitacion());
                JOptionPane.showMessageDialog(panelEntradasReserva.getParent(), "Reserva creada: " + idReserva);
            }
        } catch (ExcepcionObjetoYaExiste | ExcepcionObjectoNoEncontrado | ExcepcionHabitacionNoDisponible |
                 ExcepcionCamposRequeridos excepcion) {
            mostrarDialogoDeError(panelEntradasReserva, excepcion);
        }
    }
}

