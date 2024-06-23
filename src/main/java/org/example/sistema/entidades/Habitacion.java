package org.example.sistema.entidades;

import org.example.sistema.enums.TipoDeHabitacion;

import java.util.Objects;

public class Habitacion {

    private final String numeroDeHabitacion;
    private TipoDeHabitacion tipoDeHabitacion;
    private float precio;
    private boolean disponible;


    public Habitacion(String numeroDeHabitacion, TipoDeHabitacion tipoDeHabitacion,float precio) {
        this.numeroDeHabitacion = numeroDeHabitacion;
        this.tipoDeHabitacion = tipoDeHabitacion;
        this.precio = precio;
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

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "| Numero de habitacion: " + numeroDeHabitacion+
                "| Tipo de habitacion: " + tipoDeHabitacion +
                "| Precio: " + precio +
                "| Disponible: " + disponible ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Habitacion that)) return false;
        return Objects.equals(numeroDeHabitacion, that.numeroDeHabitacion);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numeroDeHabitacion);
    }
}