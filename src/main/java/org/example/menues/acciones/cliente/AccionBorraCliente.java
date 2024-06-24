package org.example.menues.acciones.cliente;

import org.example.menues.acciones.AccionAbstracta;
import org.example.menues.paneles.panelesgridbag.PanelDeEntradas;
import org.example.sistema.Sistema;
import org.example.sistema.excepciones.ExcepcionObjectoNoEncontrado;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AccionBorraCliente extends AccionAbstracta {

    private final PanelDeEntradas panelDeEntradas;

    public AccionBorraCliente(PanelDeEntradas panelDeEntradas) {
        this.panelDeEntradas = panelDeEntradas;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        try {
            String dni = panelDeEntradas.obtenerCampo();
            Sistema.getInstance().borrarCliente(dni);
            JOptionPane.showMessageDialog(panelDeEntradas.getParent(), "Cliente eliminado: " + dni);
        } catch (ExcepcionObjectoNoEncontrado excepcion) {
            mostrarDialogoDeError(panelDeEntradas.getParent(), excepcion);
        }
    }
}
