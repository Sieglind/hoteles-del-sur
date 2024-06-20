package org.example.menues.acciones;
import org.example.menues.cuadros.cuadroscaja.tareas.impl.TareasEmpleado;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.persona.Empleado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionGuardarEmpleado implements ActionListener
{
    private Empleado empleado;

    public AccionGuardarEmpleado(TareasEmpleado padre) {
        this.empleado = padre.obtenerNuevoEmpleado();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Sistema sistema = Sistema.getInstance();

    }
}
