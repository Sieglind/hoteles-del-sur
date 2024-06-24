package org.example.menues.acciones.cliente;

import org.example.menues.acciones.AccionAbstracta;
import org.example.menues.paneles.panelesgridbag.tareas.impl.cliente.PanelCliente;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.persona.Cliente;
import org.example.sistema.excepciones.ExcepcionCamposRequeridos;
import org.example.sistema.excepciones.ExcepcionObjetoYaExiste;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AccionCrearCliente extends AccionAbstracta {

    private final PanelCliente panelCliente;

    public AccionCrearCliente(PanelCliente panelCliente) {
        this.panelCliente = panelCliente;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Cliente cliente = panelCliente.obtenerCliente();
        try {
            Sistema.getInstance().crearCliente(cliente);
            JOptionPane.showMessageDialog(panelCliente.getParent(), "Cliente creado: " + cliente.getDni());
        } catch (ExcepcionObjetoYaExiste | ExcepcionCamposRequeridos excepcion) {
            mostrarDialogoDeError(panelCliente.getParent(), excepcion);
        }
    }
}
