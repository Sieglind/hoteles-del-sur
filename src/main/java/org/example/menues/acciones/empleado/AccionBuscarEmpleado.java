package org.example.menues.acciones.empleado;
import org.example.menues.cuadros.panelesgridbag.PanelDeEntradas;
import org.example.menues.cuadros.panelesgridbag.PanelEmpleado;
import org.example.menues.cuadros.panelesgridbag.tareas.impl.TareasEmpleado;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.persona.Empleado;
import org.example.sistema.excepciones.ObjectoNoEncontradoExcepcion;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionBuscarEmpleado implements ActionListener {

    TareasEmpleado panelDeTareas;
    PanelDeEntradas panelDeEntradas;
    PanelEmpleado panelEmpleado;

    public AccionBuscarEmpleado(TareasEmpleado panelDeTareas, PanelDeEntradas panelDeEntradas, PanelEmpleado panelEmpleado) {
        this.panelDeTareas = panelDeTareas;
        this.panelDeEntradas = panelDeEntradas;
        this.panelEmpleado = panelEmpleado;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            Empleado empleado = Sistema.getInstance().buscarEmpleado(panelDeEntradas.getCampoDni());
            this.panelEmpleado.fillValues(empleado);
        } catch (ObjectoNoEncontradoExcepcion excepcion) {
            JOptionPane.showMessageDialog(panelDeTareas,excepcion.getMessage());
        }
    }
}
