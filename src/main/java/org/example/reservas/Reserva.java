package org.example.reservas;

import org.example.usuarios.Cliente;

import java.util.Date;

public class Reserva {
    private String idReserva;
    private Cliente cliente;
    private TipoDeHabitacion tipoDeHabitacion;
    private Date fechaInicio;
    private Date fechaFin;
    private Estado estado;

    public Reserva(String idReserva, Cliente cliente, TipoDeHabitacion tipoDeHabitacion, Date fechaInicio, Date fechaFin, Estado estado) {
        this.idReserva = idReserva;
        this.cliente = cliente;
        this.tipoDeHabitacion = tipoDeHabitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.estado = estado;
    }
}