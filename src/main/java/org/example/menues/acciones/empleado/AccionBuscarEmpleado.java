package org.example.menues.acciones.empleado;

import org.example.menues.acciones.AccionAbstracta;
import org.example.menues.paneles.panelesgridbag.PanelDeEntradas;
import org.example.menues.paneles.panelesgridbag.tareas.impl.empleado.PanelEmpleado;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.persona.Empleado;
import org.example.sistema.excepciones.ExcepcionObjectoNoEncontrado;

import java.awt.event.ActionEvent;

public class AccionBuscarEmpleado extends AccionAbstracta {

    private final PanelDeEntradas panelDeEntradas;
    private final PanelEmpleado panelEmpleado;

    public AccionBuscarEmpleado(PanelDeEntradas panelDeEntradas, PanelEmpleado panelEmpleado) {
        this.panelDeEntradas = panelDeEntradas;
        this.panelEmpleado = panelEmpleado;
    }

    @Override
    public void actionPerformed(ActionEvent event) {
        try {
            Empleado empleado = Sistema.getInstance().buscarEmpleado(panelDeEntradas.obtenerCampo());
            this.panelEmpleado.llenarCampos(empleado);
        } catch (ExcepcionObjectoNoEncontrado excepcion) {
            mostrarDialogoDeError(panelDeEntradas, excepcion);
        }
    }
}
