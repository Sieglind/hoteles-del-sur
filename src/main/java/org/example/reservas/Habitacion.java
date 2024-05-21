package org.example.reservas;

public class Habitacion {

    private final String numeroDeHabitacion;
    private TipoDeHabitacion tipoDeHabitacion;
    private Integer numeroDeCamas;
    private boolean disponible;

    public Habitacion(String numeroDeHabitacion, TipoDeHabitacion tipoDeHabitacion) {
        this.numeroDeHabitacion = numeroDeHabitacion;
        this.tipoDeHabitacion = tipoDeHabitacion;
        this.disponible = true;
    }
}