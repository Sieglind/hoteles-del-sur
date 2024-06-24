package org.example.menues.acciones.empleado;

import org.example.menues.acciones.AccionGenerica;
import org.example.menues.paneles.panelesgridbag.tareas.impl.empleado.PanelEmpleado;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.persona.Empleado;
import org.example.sistema.excepciones.ExcepcionCamposRequeridos;
import org.example.sistema.excepciones.ExcepcionObjectoNoEncontrado;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AccionActualizarEmpleado extends AccionGenerica {

    private final PanelEmpleado panelEmpleado;

    public AccionActualizarEmpleado(PanelEmpleado panelEmpleado) {
        this.panelEmpleado = panelEmpleado;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {

        Empleado empleado = panelEmpleado.crearEmpleado();
        try {
            Sistema.getInstance().actualizarEmpleado(empleado);
            JOptionPane.showMessageDialog(panelEmpleado.getParent(), "Empleado actualizado");
        } catch (ExcepcionCamposRequeridos | ExcepcionObjectoNoEncontrado excepcion) {
            mostrarDialogoDeError(panelEmpleado, excepcion);
        }
    }
}
