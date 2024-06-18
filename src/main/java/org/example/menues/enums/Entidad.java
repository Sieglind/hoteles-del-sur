package org.example.menues.enums;

public enum Entidad {
    CLIENTES("Cliente"),
    EMPLEADOS("Empleado"),
    RESERVAS("Reserva"),
    HABITACIONES("Habitacion"),
    ACTIVIDADES("Actividad");

    private final String entidad;

    Entidad(String entidad) {
        this.entidad = entidad;
    }

    public String getEntidad() {
        return entidad;
    }
}
