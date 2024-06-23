package org.example.sistema.excepciones;

public class ExcepcionHabitacionNoDisponible extends Exception {

    private static final String ERROR_HABITACION_NO_DISPONIBLE = "Habitacion no disponible: ";

    public ExcepcionHabitacionNoDisponible(String numeroDeHabitacion) {
        super(ERROR_HABITACION_NO_DISPONIBLE + numeroDeHabitacion);
    }
}
