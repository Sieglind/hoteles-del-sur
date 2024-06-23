package org.example.sistema.excepciones;

public class EscepcionHabitacionNoDisponible extends Exception {

    private static final String ERROR_HABITACION_NO_DISPONIBLE = "Habitacion no disponible: ";

    public EscepcionHabitacionNoDisponible(String numeroDeHabitacion) {
        super(ERROR_HABITACION_NO_DISPONIBLE + numeroDeHabitacion);
    }
}
