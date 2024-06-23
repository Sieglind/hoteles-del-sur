package org.example.menues.acciones.cliente;

import org.example.menues.cuadros.panelesgridbag.tareas.impl.cliente.PanelCliente;
import org.example.menues.cuadros.panelesgridbag.PanelDeEntradas;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.persona.Cliente;
import org.example.sistema.excepciones.ExcepcionObjectoNoEncontrado;

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
            Cliente cliente = Sistema.getInstance().buscarCLiente(panelDeEntradas.obtenerCampo());
            this.panelCliente.fillValues(cliente);
            panelCliente.getParent().revalidate();
            panelCliente.getParent().repaint();
        } catch (ExcepcionObjectoNoEncontrado excepcion) {
            JOptionPane.showMessageDialog(panelDeEntradas.getParent(),excepcion.getMessage());
        }
    }
}
