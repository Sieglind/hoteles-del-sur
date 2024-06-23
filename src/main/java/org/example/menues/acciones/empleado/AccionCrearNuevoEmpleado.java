package org.example.menues.acciones.empleado;
import org.example.menues.cuadros.panelesgridbag.tareas.impl.empleado.PanelEmpleado;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.persona.Empleado;
import org.example.sistema.excepciones.ExcepcionCamposRequeridos;
import org.example.sistema.excepciones.ExcepcionObjetoYaExiste;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionCrearNuevoEmpleado implements ActionListener{

    PanelEmpleado panelEmpleado;

    public AccionCrearNuevoEmpleado(PanelEmpleado panelEmpleado){
        this.panelEmpleado = panelEmpleado;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Empleado empleado = panelEmpleado.crearEmpleado();
        try {
            Sistema.getInstance().crearEmpleado(empleado);
            JOptionPane.showMessageDialog(panelEmpleado.getParent(), "Nuevo empleado creado correctamente");
        }catch (ExcepcionObjetoYaExiste | ExcepcionCamposRequeridos excepcion){
            JOptionPane.showMessageDialog(panelEmpleado.getParent(),excepcion.getMessage());
        }
    }
}
