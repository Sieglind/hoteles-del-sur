package org.example.menues.acciones.reserva;

import org.example.menues.cuadros.panelesgridbag.PanelEntradasReserva;
import org.example.menues.cuadros.panelesgridbag.tareas.impl.reserva.PanelReserva;
import org.example.menues.cuadros.panelesgridbag.tareas.impl.reserva.PanelTareasReserva;
import org.example.sistema.Sistema;
import org.example.sistema.excepciones.ObjetoYaExisteExcepcion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionCrearReserva implements ActionListener {
    PanelTareasReserva panelDeTareas;
    PanelEntradasReserva panelEntradasReserva;
    PanelReserva panelReserva;

    public AccionCrearReserva(PanelTareasReserva panelDeTareas, PanelEntradasReserva panelEntradasReserva, PanelReserva panelReserva) {
        this.panelDeTareas = panelDeTareas;
        this.panelEntradasReserva = panelEntradasReserva;
        this.panelReserva = panelReserva;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            String reserva = Sistema.getInstance().crearReserva(panelReserva.crearReserva());
            JOptionPane.showMessageDialog(panelDeTareas, "Reserva creada con exito: ID " + reserva);
        } catch (ObjetoYaExisteExcepcion excepcion) {
            JOptionPane.showMessageDialog(panelDeTareas, excepcion.getMessage());
        }
    }
}

