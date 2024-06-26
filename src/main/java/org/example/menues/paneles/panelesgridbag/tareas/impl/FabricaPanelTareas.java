package org.example.menues.paneles.panelesgridbag.tareas.impl;

import org.example.menues.enums.Entidad;
import org.example.menues.enums.Tarea;
import org.example.menues.paneles.JPanelCustom;
import org.example.menues.paneles.panelesgridbag.tareas.impl.cliente.PanelTareasCliente;
import org.example.menues.paneles.panelesgridbag.tareas.impl.empleado.PanelTareasEmpleado;
import org.example.menues.paneles.panelesgridbag.tareas.impl.habitacion.PanelTareasHabitacion;
import org.example.menues.paneles.panelesgridbag.tareas.impl.reserva.PanelTareasReserva;
import org.example.menues.paneles.panelesgridbag.tareas.impl.servicio.PanelTareasServicio;

public class FabricaPanelTareas {

    public static JPanelCustom obtenerPanelTarea(Entidad entidad, Tarea tarea) {
        return switch (entidad) {
            case CLIENTES -> new PanelTareasCliente(tarea);
            case EMPLEADOS -> new PanelTareasEmpleado(tarea);
            case RESERVAS -> new PanelTareasReserva(tarea);
            case HABITACIONES -> new PanelTareasHabitacion(tarea);
            case SERVICIOS -> new PanelTareasServicio(tarea);
        };
    }

}
