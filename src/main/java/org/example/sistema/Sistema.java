package org.example.sistema;

import org.example.sistema.entidades.Habitacion;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.example.sistema.entidades.persona.Empleado;
import org.example.sistema.enums.Cargo;
import org.example.sistema.enums.TipoDeHabitacion;
import org.example.sistema.excepciones.ObjectoNoEncontradoExcepcion;
import org.example.sistema.excepciones.ObjetoYaExisteExcepcion;
import org.example.sistema.gestor.Hotel;
import org.example.sistema.gestor.impl.*;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Sistema {

    public static Sistema sistema;

    private final Hotel hotel;
    private final GestorEmpleados gestorEmpleados;
    private final GestorClientes gestorClientes;
    private final GestorHabitaciones gestorHabitaciones;
    private final GestorDeServicios gestorDeServicios;
    private final GestorReservas gestorReservas;

    private Sistema(Hotel hotel) {
        this.hotel = hotel;
        this.gestorClientes = new GestorClientes();
        this.gestorHabitaciones = new GestorHabitaciones();
        this.gestorDeServicios = new GestorDeServicios();
        this.gestorReservas = new GestorReservas();
        this.gestorEmpleados = new GestorEmpleados();

        this.gestorEmpleados.cargarEmpleados(UtilidadesCSV.importarEmpleados());

        this.gestorClientes.cargarClientes(UtilidadesCSV.importarClientes());

    }


    public static synchronized Sistema getInstance() {
        if (sistema == null) {
            sistema = new Sistema(new Hotel("Hoteles del Sur", "Fake St 123", "Nope"));
        }
        return sistema;
    }

    public boolean login(String dni, String password) throws ObjectoNoEncontradoExcepcion {
        Empleado empleado = gestorEmpleados.buscar(dni);
        return empleado.getPassword().equals(password) && empleado.getCargo().equals(Cargo.ADMINISTRADOR);
    }

    public String listarHabitaciones () {
        StringBuilder sb = new StringBuilder();
        sb.append("\n Lista de Habitaciones :\n");

        this.gestorHabitaciones.buscarTodos().forEach(habitacion -> sb.append("\t").append(habitacion).append("\n"));
        return sb.toString();
    }



}