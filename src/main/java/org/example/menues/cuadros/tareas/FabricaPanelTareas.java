package org.example.menues.cuadros.tareas;

import org.example.menues.cuadros.JPanelCustom;
import org.example.menues.cuadros.tareas.impl.TareasCliente;
import org.example.menues.enums.Entidad;
import org.example.menues.enums.Tarea;

public class FabricaPanelTareas {

    public static JPanelCustom obtenerPanelTarea(Entidad entidad, Tarea tarea) {
        switch (entidad) {
            case CLIENTES:
                return new TareasCliente();
            case EMPLEADOS:
                //TODO Retornar panel empleados
                return null;
            case RESERVAS:
                //TODO Retornar panel reservas
                return null;
            case HABITACIONES:
                //TODO Retornar panel habitaciones
                return null;
            case ACTIVIDADES:
                //TODO Retornar panel actividades
                return null;
        }
        return null;
    }

}
