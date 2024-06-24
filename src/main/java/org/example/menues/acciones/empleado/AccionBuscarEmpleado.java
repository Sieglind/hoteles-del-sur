package org.example.menues.acciones.empleado;
import org.example.menues.paneles.panelesgridbag.PanelDeEntradas;
import org.example.menues.paneles.panelesgridbag.tareas.impl.empleado.PanelEmpleado;
import org.example.menues.paneles.panelesgridbag.tareas.impl.empleado.PanelTareasEmpleado;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.persona.Empleado;
import org.example.sistema.excepciones.ExcepcionObjectoNoEncontrado;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionBuscarEmpleado implements ActionListener {

    PanelTareasEmpleado panelDeTareas;
    PanelDeEntradas panelDeEntradas;
    PanelEmpleado panelEmpleado;

    public AccionBuscarEmpleado(PanelTareasEmpleado panelDeTareas, PanelDeEntradas panelDeEntradas, PanelEmpleado panelEmpleado) {
        this.panelDeTareas = panelDeTareas;
        this.panelDeEntradas = panelDeEntradas;
        this.panelEmpleado = panelEmpleado;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            Empleado empleado = Sistema.getInstance().buscarEmpleado(panelDeEntradas.obtenerCampo());
            this.panelEmpleado.llenarCampos(empleado);
        } catch (ExcepcionObjectoNoEncontrado excepcion) {
            JOptionPane.showMessageDialog(panelDeTareas,excepcion.getMessage());
        }
    }
}
