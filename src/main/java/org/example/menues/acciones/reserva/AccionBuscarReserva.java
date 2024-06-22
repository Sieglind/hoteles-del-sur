package org.example.menues.acciones.reserva;

import org.example.menues.cuadros.panelesgridbag.PanelEntradasReserva;
import org.example.menues.cuadros.panelesgridbag.tareas.impl.reserva.PanelReserva;
import org.example.menues.cuadros.panelesgridbag.tareas.impl.reserva.PanelTareasReserva;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Reserva;
import org.example.sistema.excepciones.ObjectoNoEncontradoExcepcion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionBuscarReserva implements ActionListener {
    PanelTareasReserva panelDeTareas;
    PanelEntradasReserva panelEntradasReserva;
    PanelReserva panelReserva;

    public AccionBuscarReserva(PanelTareasReserva panelDeTareas, PanelEntradasReserva panelEntradasReserva, PanelReserva panelReserva) {
        this.panelDeTareas = panelDeTareas;
        this.panelEntradasReserva = panelEntradasReserva;
        this.panelReserva = panelReserva;
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            Reserva reserva = Sistema.getInstance().buscarReserva(panelEntradasReserva.getCampoId());
            this.panelReserva.fillValues(reserva);
        } catch (ObjectoNoEncontradoExcepcion excepcion) {
            JOptionPane.showMessageDialog(panelDeTareas,excepcion.getMessage());
        }
    }
}
