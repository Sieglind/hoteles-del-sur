package org.example.menues.acciones.empleado;

import org.example.menues.cuadros.cuadroscaja.PanelEmpleado;
import org.example.menues.cuadros.cuadroscaja.tareas.impl.TareasEmpleado;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.persona.Empleado;
import org.example.sistema.excepciones.CampoRequeridoExcepcion;
import org.example.sistema.excepciones.ObjetoYaExisteExcepcion;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionCrearNuevoEmpleado implements ActionListener{

    TareasEmpleado panelDeTareas;
    PanelEmpleado panelEmpleado;

    public AccionCrearNuevoEmpleado(TareasEmpleado panelDeTareas, PanelEmpleado panelEmpleado){
        this.panelDeTareas = panelDeTareas;
        this.panelEmpleado = panelEmpleado;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Empleado empleado = panelEmpleado.crearEmpleado();
        try {
            Sistema.getInstance().crearNuevoEmpleado(empleado);
            JOptionPane.showMessageDialog(panelDeTareas, "Nuevo empleado creado correctamente");
        }catch (ObjetoYaExisteExcepcion | CampoRequeridoExcepcion excepcion){
            JOptionPane.showMessageDialog(panelDeTareas,excepcion.getMessage());
        }
    }
}
