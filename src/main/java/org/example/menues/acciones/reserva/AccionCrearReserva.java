package org.example.menues.acciones.reserva;

import org.example.menues.cuadros.panelesgridbag.PanelEntradasReserva;
import org.example.menues.cuadros.panelesgridbag.PanelReserva;
import org.example.menues.cuadros.panelesgridbag.tareas.impl.TareasReserva;
import org.example.sistema.Sistema;
import org.example.sistema.excepciones.ObjetoYaExisteExcepcion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionCrearReserva implements ActionListener {
    TareasReserva panelDeTareas;
    PanelEntradasReserva panelEntradasReserva;
    PanelReserva panelReserva;

    public AccionCrearReserva(TareasReserva panelDeTareas, PanelEntradasReserva panelEntradasReserva, PanelReserva panelReserva) {
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

