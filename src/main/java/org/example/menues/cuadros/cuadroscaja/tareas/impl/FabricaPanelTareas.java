package org.example.menues.cuadros.cuadroscaja.tareas.impl;

import org.example.menues.cuadros.JPanelCustom;
import org.example.menues.enums.Entidad;
import org.example.menues.enums.Tarea;

public class FabricaPanelTareas {

    public static JPanelCustom obtenerPanelTarea(Entidad entidad, Tarea tarea) {
        return switch (entidad) {
            case CLIENTES -> new TareasCliente(tarea);
            case EMPLEADOS ->
                //TODO Retornar panel empleados
                    null;
            case RESERVAS ->
                //TODO Retornar panel reservas
                    null;
            case HABITACIONES -> new TareasHabitacion(tarea);
            case ACTIVIDADES ->
                //TODO Retornar panel actividades
                    null;
        };
    }

}
