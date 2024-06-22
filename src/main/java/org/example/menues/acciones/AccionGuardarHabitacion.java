package org.example.menues.acciones;

import org.example.menues.cuadros.cuadroscaja.tareas.impl.TareasHabitacion;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Habitacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionGuardarHabitacion implements ActionListener {

    private Habitacion habitacion;

    public AccionGuardarHabitacion(TareasHabitacion padre) {
        this.habitacion = padre.obtenerNuevaHabitacion();
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        Sistema sistema = Sistema.getInstance();
        //TODO crear funcion guardar en sistema
    }
}
