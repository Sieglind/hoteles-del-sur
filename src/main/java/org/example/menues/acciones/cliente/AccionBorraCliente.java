package org.example.menues.acciones.cliente;

import org.example.menues.cuadros.cuadroscaja.PanelDeEntradas;
import org.example.sistema.Sistema;
import org.example.sistema.excepciones.ObjectoNoEncontradoExcepcion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionBorraCliente implements ActionListener {

    PanelDeEntradas panelDeEntradas;

    public AccionBorraCliente(PanelDeEntradas panelDeEntradas) {
        this.panelDeEntradas = panelDeEntradas;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        try {
            String dni = panelDeEntradas.getCampoDni();
            Sistema.getInstance().borrarCliente(dni);
            JOptionPane.showMessageDialog(panelDeEntradas.getParent(),"Cliente eliminado correctamente: " + dni);
        } catch (ObjectoNoEncontradoExcepcion ex) {
            JOptionPane.showMessageDialog(panelDeEntradas.getParent(),ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
