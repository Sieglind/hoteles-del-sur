package org.example.menues.acciones.reserva;

import org.example.menues.cuadros.panelesgridbag.PanelEntradasReserva;
import org.example.menues.cuadros.panelesgridbag.tareas.impl.reserva.PanelTareasReserva;
import org.example.sistema.Sistema;
import org.example.sistema.excepciones.ObjectoNoEncontradoExcepcion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionEliminarReserva implements ActionListener {
    PanelTareasReserva panelTareasReserva;
    PanelEntradasReserva panelEntradasReserva;

    public AccionEliminarReserva(PanelTareasReserva panelTareasReserva, PanelEntradasReserva panelEntradasReserva) {
        this.panelTareasReserva = panelTareasReserva;
        this.panelEntradasReserva = panelEntradasReserva;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Sistema.getInstance().eliminarReserva(panelEntradasReserva.getCampoId());
            JOptionPane.showMessageDialog(null, "Reserva eliminada con exito " +
                    panelEntradasReserva.getCampoId());
        } catch (ObjectoNoEncontradoExcepcion ex) {
            JOptionPane.showMessageDialog(panelTareasReserva, ex.getMessage());
        }
    }
}
