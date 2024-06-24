package org.example.menues.acciones.cliente;

import org.example.menues.paneles.panelesgridbag.tareas.impl.cliente.PanelCliente;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.persona.Cliente;
import org.example.sistema.excepciones.ExcepcionCamposRequeridos;
import org.example.sistema.excepciones.ExcepcionObjetoYaExiste;

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
        } catch (ExcepcionObjetoYaExiste | ExcepcionCamposRequeridos excepcion) {
            JOptionPane.showMessageDialog(panelCliente.getParent(), excepcion.getMessage(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
