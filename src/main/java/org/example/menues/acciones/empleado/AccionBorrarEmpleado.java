package org.example.menues.acciones.empleado;

import org.example.menues.acciones.AccionAbstracta;
import org.example.menues.paneles.panelesgridbag.PanelDeEntradas;
import org.example.sistema.Sistema;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AccionBorrarEmpleado extends AccionAbstracta {

    private final PanelDeEntradas panelDeEntradas;

    public AccionBorrarEmpleado(PanelDeEntradas panelDeEntradas) {
        this.panelDeEntradas = panelDeEntradas;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String dni = panelDeEntradas.obtenerCampo();
            Sistema.getInstance().borrarEmpleado(dni);
            JOptionPane.showMessageDialog(panelDeEntradas.getParent(), "Empleado eliminado: " + dni);
        } catch (Exception excepcion) {
            mostrarDialogoDeError(panelDeEntradas.getParent(), excepcion);
        }
    }
}
