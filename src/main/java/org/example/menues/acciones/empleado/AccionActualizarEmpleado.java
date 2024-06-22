package org.example.menues.acciones.empleado;
import org.example.menues.cuadros.panelesgridbag.PanelBotones;
import org.example.menues.cuadros.panelesgridbag.PanelDeEntradas;
import org.example.menues.cuadros.panelesgridbag.tareas.impl.empleado.PanelEmpleado;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.persona.Empleado;
import org.example.sistema.excepciones.ObjectoNoEncontradoExcepcion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionActualizarEmpleado implements ActionListener {

    private final PanelDeEntradas panelDeEntradas;
    private final PanelEmpleado panelEmpleado;
    private final PanelBotones panelBotones;

    public AccionActualizarEmpleado(PanelDeEntradas panelDeEntradas, PanelEmpleado panelEmpleado, PanelBotones panelBotones) {
        this.panelDeEntradas = panelDeEntradas;
        this.panelEmpleado = panelEmpleado;
        this.panelBotones = panelBotones;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        try {
            Empleado empleado = Sistema.getInstance().buscarEmpleado(panelDeEntradas.obtenerCampo());
            panelEmpleado.llenarCampos(empleado);
            panelEmpleado.habilitarEdicion();
            panelBotones.getBotonActualizar().setEnabled(true);
            panelBotones.getBotonBuscar().setEnabled(false);
        } catch (ObjectoNoEncontradoExcepcion excepcion) {
            JOptionPane.showMessageDialog(panelDeEntradas.getParent(),excepcion.getMessage());
        }
    }
}
