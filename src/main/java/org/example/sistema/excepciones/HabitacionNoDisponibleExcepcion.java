package org.example.sistema.excepciones;

public class HabitacionNoDisponibleExcepcion extends Exception {

    private static final String ERROR_HABITACION_NO_DISPONIBLE = "Habitacion no disponible: ";

    public HabitacionNoDisponibleExcepcion(String numeroDeHabitacion) {
        super(ERROR_HABITACION_NO_DISPONIBLE + numeroDeHabitacion);
    }
}
