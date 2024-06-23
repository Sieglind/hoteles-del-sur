package org.example.menues.acciones.reserva;

import org.example.menues.cuadros.panelesgridbag.PanelBotones;
import org.example.menues.cuadros.panelesgridbag.PanelDeEntradas;
import org.example.menues.cuadros.panelesgridbag.tareas.impl.reserva.PanelReserva;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Reserva;
import org.example.sistema.excepciones.EscepcionObjectoNoEncontrado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionHabilitarReserva implements ActionListener {
    private final PanelDeEntradas panelEntradasReserva;
    private final PanelReserva panelReserva;
    private final PanelBotones panelBotones;

    public AccionHabilitarReserva(PanelDeEntradas panelEntradasReserva, PanelReserva panelReserva, PanelBotones panelBotones) {
        this.panelEntradasReserva = panelEntradasReserva;
        this.panelReserva = panelReserva;
        this.panelBotones = panelBotones;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            Reserva reserva = Sistema.getInstance().buscarReserva(panelEntradasReserva.obtenerCampo());
            panelReserva.rellenarCampos(reserva);
            panelReserva.habilitarEdicion();
            panelBotones.getBotonActualizar().setEnabled(true);
            panelBotones.getBotonBuscar().setEnabled(false);
        } catch (EscepcionObjectoNoEncontrado excepcion) {
            JOptionPane.showMessageDialog(panelEntradasReserva.getParent(), excepcion.getMessage());
        }
    }
}
