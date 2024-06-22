package org.example.sistema;

import org.example.sistema.entidades.Habitacion;
import org.example.sistema.entidades.Reserva;
import org.example.sistema.entidades.Servicio;
import org.example.sistema.entidades.persona.Cliente;
import org.example.sistema.entidades.persona.Empleado;
import org.example.sistema.enums.Cargo;
import org.example.sistema.excepciones.ObjectoNoEncontradoExcepcion;
import org.example.sistema.excepciones.ObjetoYaExisteExcepcion;
import org.example.sistema.gestor.Hotel;
import org.example.sistema.gestor.impl.*;

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
        this.gestorClientes = new GestorClientes().conClientes(UtilidadesCSV.importarClientes());
        this.gestorEmpleados = new GestorEmpleados().conEmpleados(UtilidadesCSV.importarEmpleados());
        this.gestorHabitaciones = new GestorHabitaciones().conHabitacion(UtilidadesCSV.importarHabitaciones());
        this.gestorDeServicios = new GestorDeServicios().conServicios(UtilidadesCSV.importarServicios());
        this.gestorReservas = new GestorReservas();
    }


    public static synchronized Sistema getInstance() {
        if (sistema == null) {
            sistema = new Sistema(new Hotel("Hoteles del Sur", "Fake St 123", "Please no"));
        }
        return sistema;
    }

    public boolean login(String dni, String password) throws ObjectoNoEncontradoExcepcion {
        Empleado empleado = gestorEmpleados.buscar(dni);
        return empleado.getPassword().equals(password) && empleado.getCargo().equals(Cargo.ADMINISTRADOR);
    }

    public List<Habitacion> listarHabitaciones() {
        return this.gestorHabitaciones.buscarTodos();
    }

    public List<Cliente> listarClientes() {
        return this.gestorClientes.buscarTodos();
    }

    public List<Reserva> listarReservas() {
        return this.gestorReservas.buscarTodos();
    }

    public List<Empleado> listarEmpleados() {
        return this.gestorEmpleados.buscarTodos();
    }

    public List<Servicio> listarServicios() {
        return this.gestorDeServicios.buscarTodos();
    }

    public Cliente buscarCLiente(String campoDni) throws ObjectoNoEncontradoExcepcion {
        return gestorClientes.buscar(campoDni);
    }

    public Servicio buscarServicio(Integer clave) throws ObjectoNoEncontradoExcepcion {
        return gestorDeServicios.buscar(clave);
    }

    public String crearReserva(Reserva reserva) throws ObjetoYaExisteExcepcion{
        return gestorReservas.crear(reserva);
    }

    public Reserva buscarReserva (String idReserva)throws ObjectoNoEncontradoExcepcion{
        return gestorReservas.buscar(idReserva);
    }

    public void eliminarReserva (String id)throws ObjectoNoEncontradoExcepcion{
        gestorReservas.eliminar(id);
    }

    public Habitacion buscarHabitacion (String numeroHabitacion) throws ObjectoNoEncontradoExcepcion {
        return gestorHabitaciones.buscar(numeroHabitacion);
    }

    public void crearHabitacion(Habitacion valor) throws ObjetoYaExisteExcepcion {
        gestorHabitaciones.crear(valor);
    }

    public void eliminarHabitacion(String numeroHabitacion) throws ObjectoNoEncontradoExcepcion {
        gestorHabitaciones.eliminar(numeroHabitacion);
    }

    public void crearCliente(Cliente cliente) throws ObjetoYaExisteExcepcion {
        gestorClientes.crear(cliente);
    }

    public void borrarCliente(String campoDni) throws ObjectoNoEncontradoExcepcion {
        gestorClientes.eliminar(campoDni);
    }
}