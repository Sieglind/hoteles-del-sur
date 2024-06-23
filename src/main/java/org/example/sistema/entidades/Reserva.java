package org.example.sistema.entidades;

import org.example.sistema.entidades.persona.Cliente;
import org.example.sistema.enums.Estado;

import java.time.Instant;
import java.time.LocalDate;

public class Reserva {

    private String idReserva;
    private Cliente cliente;
    private Habitacion habitacion;
    private final LocalDate fechaInicio;
    private final LocalDate fechaFin;
    private final int[] serviciosElegidos;
    private Estado estado;

    public Reserva(Cliente cliente, Habitacion habitacion, LocalDate fechaInicio, LocalDate fechaFin, int[] serviciosElegidos) {
        this.serviciosElegidos = serviciosElegidos;
        this.idReserva = "R" + Instant.now().getNano();
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = Estado.PENDIENTE;
    }

    public Reserva(String idReserva, Cliente cliente, Habitacion habitacion, LocalDate fechaInicio, LocalDate fechaFin, int[] serviciosElegidos) {
        this.idReserva = idReserva;
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.serviciosElegidos = serviciosElegidos;
        this.estado = Estado.PENDIENTE;
    }

    public String getIdReserva() {
        return idReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setIdReserva(String idReserva) {
        this.idReserva = idReserva;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return
                " | Id : " + idReserva +
                        " | Cliente: " + cliente +
                        " | Habitacion: " + habitacion +
                        " | Check-In: " + fechaInicio +
                        " | Check-Out: " + fechaFin +
                        " | Estado: " + estado;
    }

    public int[] getServiciosElegidos() {
        return serviciosElegidos;
    }
}