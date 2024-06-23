package org.example.menues.acciones.reserva;

import org.example.menues.cuadros.panelesgridbag.PanelDeEntradas;
import org.example.menues.cuadros.panelesgridbag.tareas.impl.reserva.PanelReserva;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Reserva;
import org.example.sistema.excepciones.ExcepcionCamposRequeridos;
import org.example.sistema.excepciones.ExcepcionObjectoNoEncontrado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionActualizarReserva implements ActionListener {
    private final PanelReserva panelReserva;
    private final PanelDeEntradas panelDeEntradas;

    public AccionActualizarReserva(PanelReserva panelReserva, PanelDeEntradas panelDeEntradas) {
        this.panelReserva = panelReserva;
        this.panelDeEntradas = panelDeEntradas;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        try {
            Reserva reserva = panelReserva.crearReserva();
            if (reserva != null) {
                reserva.setIdReserva(panelDeEntradas.obtenerCampo());
                Sistema.getInstance().actualizarReserva(panelReserva.getEstadoReserva(),panelDeEntradas.obtenerCampo(),
                        panelReserva.getCliente(), panelReserva.getHabitacion(), reserva);
                JOptionPane.showMessageDialog(panelReserva.getParent(), "Reserva actualizada correctamente");
            }
        } catch (ExcepcionObjectoNoEncontrado | ExcepcionCamposRequeridos excepcion) {
            JOptionPane.showMessageDialog(panelReserva.getParent(), excepcion.getMessage());
        }
    }
}
