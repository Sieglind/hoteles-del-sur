package org.example.menues.acciones.cliente;

import org.example.menues.cuadros.panelesgridbag.PanelCliente;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.persona.Cliente;
import org.example.sistema.excepciones.ObjetoYaExisteExcepcion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionCrearCliente implements ActionListener {

    PanelCliente panelCliente;

    public AccionCrearCliente(PanelCliente panelCliente) {
        this.panelCliente = panelCliente;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Cliente cliente = panelCliente.obtenerCliente();
        try {
            Sistema.getInstance().crearCliente(cliente);
            JOptionPane.showMessageDialog(panelCliente.getParent(), "Cliente creado correctamente: " + cliente.getDni());
        } catch (ObjetoYaExisteExcepcion excepcion) {
            JOptionPane.showMessageDialog(panelCliente.getParent(), excepcion.getMessage(),"ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
