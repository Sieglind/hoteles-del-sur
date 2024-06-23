package org.example.menues.acciones.reserva;

import org.example.menues.cuadros.panelesgridbag.PanelDeEntradas;
import org.example.menues.cuadros.panelesgridbag.tareas.impl.reserva.PanelReserva;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Reserva;
import org.example.sistema.entidades.persona.Empleado;
import org.example.sistema.excepciones.ObjectoNoEncontradoExcepcion;
import org.example.sistema.excepciones.ObjetoYaExisteExcepcion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionActualizarReserva implements ActionListener {
    private PanelReserva panelReserva;
    PanelDeEntradas panelDeEntradas;

    public AccionActualizarReserva(PanelReserva panelReserva, PanelDeEntradas panelDeEntradas) {
        this.panelReserva = panelReserva;
        this.panelDeEntradas = panelDeEntradas;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        try {
            Reserva reserva1 = panelReserva.crearReserva();
            reserva1.setIdReserva(panelDeEntradas.obtenerCampo());
            Sistema.getInstance().actualizarReserva(panelDeEntradas.obtenerCampo(),reserva1);
            JOptionPane.showMessageDialog(panelReserva.getParent(), "Reserva actualizada correctamente");
        } catch (ObjectoNoEncontradoExcepcion excepcion) {
            JOptionPane.showMessageDialog(panelReserva.getParent(), excepcion.getMessage());
        }
    }
}
