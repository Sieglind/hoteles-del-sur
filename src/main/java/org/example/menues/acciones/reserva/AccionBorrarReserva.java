package org.example.menues.acciones.reserva;

import org.example.menues.cuadros.panelesgridbag.PanelDeEntradas;
import org.example.sistema.Sistema;
import org.example.sistema.excepciones.EscepcionObjectoNoEncontrado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionBorrarReserva implements ActionListener {

    PanelDeEntradas panelEntradasReserva;

    public AccionBorrarReserva(PanelDeEntradas panelEntradasReserva) {
        this.panelEntradasReserva = panelEntradasReserva;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Sistema.getInstance().borrarReserva(panelEntradasReserva.obtenerCampo());
            JOptionPane.showMessageDialog(panelEntradasReserva.getParent(), "Reserva eliminada con exito " +
                    panelEntradasReserva.obtenerCampo());
        } catch (EscepcionObjectoNoEncontrado ex) {
            JOptionPane.showMessageDialog(panelEntradasReserva.getParent(), ex.getMessage());
        }
    }
}
