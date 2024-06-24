package org.example.menues.acciones.reserva;

import org.example.menues.acciones.AccionAbstracta;
import org.example.menues.paneles.panelesgridbag.PanelDeEntradas;
import org.example.sistema.Sistema;
import org.example.sistema.excepciones.ExcepcionObjectoNoEncontrado;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AccionBorrarReserva extends AccionAbstracta {

    private final PanelDeEntradas panelEntradasReserva;

    public AccionBorrarReserva(PanelDeEntradas panelEntradasReserva) {
        this.panelEntradasReserva = panelEntradasReserva;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Sistema.getInstance().borrarReserva(panelEntradasReserva.obtenerCampo());
            JOptionPane.showMessageDialog(panelEntradasReserva.getParent(), "Reserva eliminada" +
                    panelEntradasReserva.obtenerCampo());
        } catch (ExcepcionObjectoNoEncontrado excepcion) {
            mostrarDialogoDeError(panelEntradasReserva, excepcion);
        }
    }
}
