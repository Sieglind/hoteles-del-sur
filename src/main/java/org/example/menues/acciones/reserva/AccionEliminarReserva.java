package org.example.menues.acciones.reserva;

import org.example.menues.cuadros.cuadroscaja.PanelEntradasReserva;
import org.example.menues.cuadros.cuadroscaja.tareas.impl.TareasReserva;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Reserva;
import org.example.sistema.excepciones.ObjectoNoEncontradoExcepcion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionEliminarReserva implements ActionListener {
    TareasReserva tareasReserva;
    PanelEntradasReserva panelEntradasReserva;

    public AccionEliminarReserva(TareasReserva tareasReserva, PanelEntradasReserva panelEntradasReserva) {
        this.tareasReserva = tareasReserva;
        this.panelEntradasReserva = panelEntradasReserva;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Sistema.getInstance().eliminarReserva(panelEntradasReserva.getCampoId());
            JOptionPane.showMessageDialog(null, "Reserva eliminada con exito " +
                    panelEntradasReserva.getCampoId());
        } catch (ObjectoNoEncontradoExcepcion ex) {
            JOptionPane.showMessageDialog(tareasReserva, ex.getMessage());
        }
    }
}
