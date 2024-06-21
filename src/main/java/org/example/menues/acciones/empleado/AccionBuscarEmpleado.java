package org.example.menues.acciones.empleado;
import org.example.menues.cuadros.cuadroscaja.PanelDeEntradas;
import org.example.menues.cuadros.cuadroscaja.PanelEmpleado;
import org.example.menues.cuadros.cuadroscaja.tareas.impl.TareasEmpleado;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.persona.Cliente;
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
            Cliente cliente = Sistema.getInstance().buscarCLiente(panelDeEntradas.getCampoDni());
            this.panelEmpleado.fillValues(cliente);
        } catch (ObjectoNoEncontradoExcepcion excepcion) {
            JOptionPane.showMessageDialog(panelDeTareas,excepcion.getMessage());
        }
    }
}
