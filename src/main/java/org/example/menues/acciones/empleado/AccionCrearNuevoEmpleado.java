package org.example.menues.acciones.empleado;

import org.example.menues.acciones.AccionGenerica;
import org.example.menues.paneles.panelesgridbag.tareas.impl.empleado.PanelEmpleado;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.persona.Empleado;
import org.example.sistema.excepciones.ExcepcionCamposRequeridos;
import org.example.sistema.excepciones.ExcepcionObjetoYaExiste;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class AccionCrearNuevoEmpleado extends AccionGenerica {

    private final PanelEmpleado panelEmpleado;

    public AccionCrearNuevoEmpleado(PanelEmpleado panelEmpleado) {
        this.panelEmpleado = panelEmpleado;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Empleado empleado = panelEmpleado.crearEmpleado();
        try {
            Sistema.getInstance().crearEmpleado(empleado);
            JOptionPane.showMessageDialog(panelEmpleado.getParent(), "Empleado creado");
        } catch (ExcepcionObjetoYaExiste | ExcepcionCamposRequeridos excepcion) {
            mostrarDialogoDeError(panelEmpleado, excepcion);
        }
    }
}
