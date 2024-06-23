package org.example.menues.acciones.reserva;

import org.example.menues.cuadros.panelesgridbag.PanelDeEntradas;
import org.example.menues.cuadros.panelesgridbag.tareas.impl.reserva.PanelReserva;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Reserva;
import org.example.sistema.excepciones.EscepcionObjectoNoEncontrado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionBuscarReserva implements ActionListener {

    PanelDeEntradas panelDeEntradas;
    PanelReserva panelReserva;

    public AccionBuscarReserva(PanelDeEntradas panelDeEntradas, PanelReserva panelReserva) {
        this.panelDeEntradas = panelDeEntradas;
        this.panelReserva = panelReserva;
    }
    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            Reserva reserva = Sistema.getInstance().buscarReserva(panelDeEntradas.obtenerCampo());
            this.panelReserva.rellenarCampos(reserva);
        } catch (EscepcionObjectoNoEncontrado excepcion) {
            JOptionPane.showMessageDialog(panelDeEntradas.getParent(),excepcion.getMessage());
        }
    }
}
