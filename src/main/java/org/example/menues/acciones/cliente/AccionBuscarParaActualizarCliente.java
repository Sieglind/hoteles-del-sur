package org.example.menues.acciones.cliente;

import org.example.menues.cuadros.panelesgridbag.PanelBotones;
import org.example.menues.cuadros.panelesgridbag.PanelDeEntradas;
import org.example.menues.cuadros.panelesgridbag.tareas.impl.cliente.PanelCliente;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.persona.Cliente;
import org.example.sistema.excepciones.ExcepcionObjectoNoEncontrado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionBuscarParaActualizarCliente implements ActionListener {

    private final PanelDeEntradas panelEntradas;
    private final PanelCliente panelCliente;
    private final PanelBotones panelBotones;

    public AccionBuscarParaActualizarCliente(PanelDeEntradas panelDeEntradas, PanelCliente panelCliente, PanelBotones panelBotones) {
        this.panelEntradas = panelDeEntradas;
        this.panelCliente = panelCliente;
        this.panelBotones = panelBotones;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String dni = panelEntradas.obtenerCampo();
        try {
            Cliente cliente = Sistema.getInstance().buscarCLiente(dni);
            panelCliente.fillValues(cliente);
            panelCliente.habilitarEdicion();
            panelBotones.getBotonBuscar().setEnabled(false);
            panelBotones.getBotonActualizar().setEnabled(true);
        } catch (ExcepcionObjectoNoEncontrado excepcion) {
            JOptionPane.showMessageDialog(panelEntradas.getParent(), excepcion.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
