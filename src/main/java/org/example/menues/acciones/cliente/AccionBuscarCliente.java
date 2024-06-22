package org.example.menues.acciones.cliente;

import org.example.menues.cuadros.cuadroscaja.PanelCliente;
import org.example.menues.cuadros.cuadroscaja.PanelDeEntradas;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.persona.Cliente;
import org.example.sistema.excepciones.ObjectoNoEncontradoExcepcion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionBuscarCliente implements ActionListener {

    PanelDeEntradas panelDeEntradas;
    PanelCliente panelCliente;

    public AccionBuscarCliente(PanelDeEntradas panelDeEntradas, PanelCliente panelCliente) {
        this.panelDeEntradas = panelDeEntradas;
        this.panelCliente = panelCliente;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            Cliente cliente = Sistema.getInstance().buscarCLiente(panelDeEntradas.getCampoDni());
            this.panelCliente.fillValues(cliente);
            panelCliente.getParent().revalidate();
            panelCliente.getParent().repaint();
        } catch (ObjectoNoEncontradoExcepcion excepcion) {
            JOptionPane.showMessageDialog(panelDeEntradas.getParent(),excepcion.getMessage());
        }
    }
}
