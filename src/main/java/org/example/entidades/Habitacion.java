package org.example.entidades;

import org.example.enums.TipoDeHabitacion;

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

    public String getNumeroDeHabitacion() {
        return numeroDeHabitacion;
    }

    public TipoDeHabitacion getTipoDeHabitacion() {
        return tipoDeHabitacion;
    }

    public void setTipoDeHabitacion(TipoDeHabitacion tipoDeHabitacion) {
        this.tipoDeHabitacion = tipoDeHabitacion;
    }

    public Integer getNumeroDeCamas() {
        return numeroDeCamas;
    }

    public void setNumeroDeCamas(Integer numeroDeCamas) {
        this.numeroDeCamas = numeroDeCamas;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Habitacion habitacion) {
            return this.numeroDeHabitacion.equals(habitacion.numeroDeHabitacion);
        } else return false;
    }
}