package org.example.menues.cuadros.cuadroscaja.tareas.impl;

import org.example.menues.cuadros.JPanelCustom;
import org.example.menues.enums.Entidad;
import org.example.menues.enums.Tarea;

public class FabricaPanelTareas {

    public static JPanelCustom obtenerPanelTarea(Entidad entidad, Tarea tarea) {
        return switch (entidad) {
            case CLIENTES -> new TareasCliente(tarea);
            case EMPLEADOS -> new TareasEmpleado(tarea);
            case RESERVAS -> new TareasReserva(tarea);
            case HABITACIONES -> new TareasHabitacion(tarea);
            case SERVICIOS -> new TareasServicio(tarea);
            case ACTIVIDADES ->
                //TODO Retornar panel actividades
                    null;
        };
    }

}
