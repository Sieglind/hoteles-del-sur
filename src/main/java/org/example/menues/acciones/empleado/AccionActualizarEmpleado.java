package org.example.menues.acciones.empleado;

import org.example.menues.cuadros.panelesgridbag.tareas.impl.empleado.PanelEmpleado;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.persona.Empleado;
import org.example.sistema.excepciones.ExcepcionCamposRequeridos;
import org.example.sistema.excepciones.ExcepcionObjectoNoEncontrado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionActualizarEmpleado implements ActionListener {

    private final PanelEmpleado panelEmpleado;

    public AccionActualizarEmpleado(PanelEmpleado panelEmpleado) {
        this.panelEmpleado = panelEmpleado;
    }


    @Override
    public void actionPerformed(ActionEvent evento) {

        Empleado empleado = panelEmpleado.crearEmpleado();
        try {
            Sistema.getInstance().actualizarEmpleado(empleado);
            JOptionPane.showMessageDialog(panelEmpleado.getParent(), "Empleado actualizado correctamente");
        } catch (ExcepcionCamposRequeridos | ExcepcionObjectoNoEncontrado excepcion) {
            JOptionPane.showMessageDialog(panelEmpleado.getParent(),excepcion.getMessage());
        }
    }
}
