package org.example.menues.acciones.cliente;

import org.example.menues.paneles.panelesgridbag.tareas.impl.cliente.PanelCliente;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.persona.Cliente;
import org.example.sistema.excepciones.ExcepcionObjectoNoEncontrado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionActualizarCliente implements ActionListener {

    private final PanelCliente panelCliente;

    public AccionActualizarCliente(PanelCliente panelCliente) {
        this.panelCliente = panelCliente;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Cliente cliente = panelCliente.obtenerCliente();
        try {
            Sistema.getInstance().actualizarCliente(cliente);
            JOptionPane.showMessageDialog(panelCliente.getParent(), "Cliente actualizado");
        } catch (ExcepcionObjectoNoEncontrado excepcion) {
            JOptionPane.showMessageDialog(panelCliente.getParent(), excepcion.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}
