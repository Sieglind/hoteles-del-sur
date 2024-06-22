package org.example.sistema.entidades;

import org.example.sistema.entidades.persona.Cliente;
import org.example.sistema.enums.Estado;

import javax.swing.text.DateFormatter;
import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Reserva {
    private String idReserva;
    private Cliente cliente;
    private Habitacion habitacion;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private Estado estado;

    public Reserva(Cliente cliente, Habitacion habitacion, LocalDate fechaInicio, LocalDate fechaFin) {
        this.idReserva = "R" + Instant.now().getNano();
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
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

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaInicioFormateado() {
        return fechaInicio.format(formatter);
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getFechaFinFormateado() {
        return fechaFin.format(formatter);
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
                "Id : " + idReserva +
                "||Cliente: " + cliente +
                "||Habitacion: " + habitacion +
                "||Check-In: " + fechaInicio +
                "||Check-Out: " + fechaFin +
                "||Estado: " + estado;
    }
}