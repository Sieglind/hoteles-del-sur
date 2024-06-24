package org.example.menues.acciones.empleado;
import org.example.menues.paneles.panelesgridbag.PanelBotones;
import org.example.menues.paneles.panelesgridbag.PanelDeEntradas;
import org.example.menues.paneles.panelesgridbag.tareas.impl.empleado.PanelEmpleado;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.persona.Empleado;
import org.example.sistema.excepciones.ExcepcionObjectoNoEncontrado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionBuscarParaActualizarEmpelado implements ActionListener {

    private final PanelDeEntradas panelDeEntradas;
    private final PanelEmpleado panelEmpleado;
    private final PanelBotones panelBotones;

    public AccionBuscarParaActualizarEmpelado(PanelDeEntradas panelDeEntradas, PanelEmpleado panelEmpleado, PanelBotones panelBotones) {
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
        } catch (ExcepcionObjectoNoEncontrado excepcion) {
            JOptionPane.showMessageDialog(panelDeEntradas.getParent(),excepcion.getMessage());
        }
    }
}
