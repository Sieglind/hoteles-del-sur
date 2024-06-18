package org.example.menues.cuadros.tareas.impl;

import org.example.sistema.Sistema;
import org.example.sistema.entidades.Habitacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BotonGuardarHabitacion implements ActionListener {

    private Habitacion habitacion;

    public BotonGuardarHabitacion(TareasHabitacion padre) {
        this.habitacion = padre.obtenerNuevaHabitacion();
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        Sistema sistema = Sistema.getInstance();
        //TODO crear funcion guardar en sistema
    }
}
