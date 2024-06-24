package org.example.menues.acciones.cliente;

import org.example.menues.acciones.AccionAbstracta;
import org.example.menues.paneles.panelesgridbag.PanelDeEntradas;
import org.example.menues.paneles.panelesgridbag.tareas.impl.cliente.PanelCliente;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.persona.Cliente;
import org.example.sistema.excepciones.ExcepcionObjectoNoEncontrado;

import java.awt.event.ActionEvent;

public class AccionBuscarCliente extends AccionAbstracta {

    private final PanelDeEntradas panelDeEntradas;
    private final PanelCliente panelCliente;

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
            mostrarDialogoDeError(panelDeEntradas, excepcion);
        }
    }
}
