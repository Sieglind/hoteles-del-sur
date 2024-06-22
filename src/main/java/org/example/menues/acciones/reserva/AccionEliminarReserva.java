package org.example.menues.acciones.reserva;

import org.example.menues.cuadros.panelesgridbag.PanelDeEntradas;
import org.example.sistema.Sistema;
import org.example.sistema.excepciones.ObjectoNoEncontradoExcepcion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionEliminarReserva implements ActionListener {

    PanelDeEntradas panelEntradasReserva;

    public AccionEliminarReserva(PanelDeEntradas panelEntradasReserva) {
        this.panelEntradasReserva = panelEntradasReserva;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Sistema.getInstance().eliminarReserva(panelEntradasReserva.obtenerCampo());
            JOptionPane.showMessageDialog(null, "Reserva eliminada con exito " +
                    panelEntradasReserva.obtenerCampo());
        } catch (ObjectoNoEncontradoExcepcion ex) {
            JOptionPane.showMessageDialog(panelEntradasReserva.getParent(), ex.getMessage());
        }
    }
}
