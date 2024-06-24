package org.example.menues.acciones.reserva;

import org.example.menues.paneles.panelesgridbag.PanelBotones;
import org.example.menues.paneles.panelesgridbag.PanelDeEntradas;
import org.example.menues.paneles.panelesgridbag.tareas.impl.reserva.PanelReserva;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Reserva;
import org.example.sistema.excepciones.ExcepcionObjectoNoEncontrado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionBuscarParaActualizarReserva implements ActionListener {
    private final PanelDeEntradas panelEntradasReserva;
    private final PanelReserva panelReserva;
    private final PanelBotones panelBotones;

    public AccionBuscarParaActualizarReserva(PanelDeEntradas panelEntradasReserva, PanelReserva panelReserva, PanelBotones panelBotones) {
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
        } catch (ExcepcionObjectoNoEncontrado excepcion) {
            JOptionPane.showMessageDialog(panelEntradasReserva.getParent(), excepcion.getMessage());
        }
    }
}
