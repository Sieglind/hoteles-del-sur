package org.example.menues.acciones.habitacion;

import org.example.menues.acciones.AccionGenerica;
import org.example.menues.paneles.panelesgridbag.PanelDeEntradas;
import org.example.sistema.Sistema;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AccionBorrarHabitacion extends AccionGenerica {

    private final PanelDeEntradas panelDeEntradas;

    public AccionBorrarHabitacion(PanelDeEntradas panelDeEntradas) {
        this.panelDeEntradas = panelDeEntradas;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String numeroDeHabitacion = panelDeEntradas.obtenerCampo();
            Sistema.getInstance().borrarHabitacion(numeroDeHabitacion);
            JOptionPane.showMessageDialog(panelDeEntradas.getParent(), "Habitacion eliminada: " + numeroDeHabitacion);
        } catch (Exception excepcion) {
            mostrarDialogoDeError(panelDeEntradas.getParent(), excepcion);
        }
    }
}
