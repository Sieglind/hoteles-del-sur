package org.example.sistema;

import org.example.sistema.entidades.Habitacion;
import org.example.sistema.entidades.Reserva;
import org.example.sistema.entidades.Servicio;
import org.example.sistema.entidades.persona.Cliente;
import org.example.sistema.entidades.persona.Empleado;
import org.example.sistema.entidades.persona.Persona;
import org.example.sistema.enums.Cargo;
import org.example.sistema.excepciones.CampoRequeridoExcepcion;
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

    public boolean login(String dni, String password) throws ObjectoNoEncontradoExcepcion {
        Empleado empleado = gestorEmpleados.buscar(dni);
        return empleado.getPassword().equals(password) && empleado.getCargo().equals(Cargo.ADMINISTRADOR);
    }

    public static synchronized Sistema getInstance() {
        if (sistema == null) {
            sistema = new Sistema(new Hotel("Hoteles del Sur", "Fake St 123", "Please no"));
        }
        return sistema;
    }

    public void crearCliente(Cliente cliente) throws ObjetoYaExisteExcepcion, CampoRequeridoExcepcion {
        String camposNulos = verificarCamposNulos(cliente);
        if (camposNulos.isBlank()) {
            gestorClientes.crear(cliente);
        } else {
            throw new CampoRequeridoExcepcion(camposNulos);
        }
    }

    public Cliente buscarCLiente(String campoDni) throws ObjectoNoEncontradoExcepcion {
        return gestorClientes.buscar(campoDni);
    }

    public List<Cliente> listarClientes() {
        return this.gestorClientes.listar();
    }

    public void borrarCliente(String campoDni) throws ObjectoNoEncontradoExcepcion {
        gestorClientes.borrar(campoDni);
    }

    public List<Habitacion> listarHabitaciones() {
        return this.gestorHabitaciones.listar();
    }

    public List<Empleado> listarEmpleados() {
        return this.gestorEmpleados.listar();
    }

    public List<Servicio> listarServicios() {
        return this.gestorDeServicios.listar();
    }

    public Servicio buscarServicio(String clave) throws ObjectoNoEncontradoExcepcion {
        return gestorDeServicios.buscar(clave);
    }

    public String crearReserva(Reserva reserva) throws ObjetoYaExisteExcepcion {
        asignarIdReserva(reserva);
        return gestorReservas.crear(reserva);

    }

    public String asignarIdReserva(Reserva reserva){
        return gestorReservas.asignarId(reserva);
    }

    public List<Reserva> listarReservas() {
        return this.gestorReservas.listar();
    }

    public Reserva buscarReserva(String idReserva) throws ObjectoNoEncontradoExcepcion {
        return gestorReservas.buscar(idReserva);
    }

    public void eliminarReserva(String id) throws ObjectoNoEncontradoExcepcion {
        gestorReservas.borrar(id);
    }

    public void actualizarReserva(String id, Reserva reserva) throws ObjectoNoEncontradoExcepcion {
        gestorReservas.actualizar(id, reserva);
    }

    public Habitacion buscarHabitacion(String numeroHabitacion) throws ObjectoNoEncontradoExcepcion {
        return gestorHabitaciones.buscar(numeroHabitacion);
    }

    public void crearHabitacion(Habitacion valor) throws ObjetoYaExisteExcepcion {
        gestorHabitaciones.crear(valor);
    }

    public void eliminarHabitacion(String numeroHabitacion) throws ObjectoNoEncontradoExcepcion {
        gestorHabitaciones.borrar(numeroHabitacion);
    }

    public Empleado buscarEmpleado(String campoDni) throws ObjectoNoEncontradoExcepcion {
        return gestorEmpleados.buscar(campoDni);
    }

    public void crearEmpleado(Empleado empleado) throws ObjetoYaExisteExcepcion, CampoRequeridoExcepcion {
        String camposNulos = verificarCamposNulos(empleado);
        if (camposNulos.isBlank()) {
            gestorEmpleados.crear(empleado);
        } else {
            throw new CampoRequeridoExcepcion(camposNulos);
        }
    }

    public void eliminarEmpleado(String dni) throws ObjectoNoEncontradoExcepcion {
        gestorEmpleados.borrar(dni);
    }


    private static String verificarCamposNulos(Persona persona) {
        StringBuilder camposNulos = new StringBuilder();
        if (persona.getDni().isBlank()) camposNulos.append(" DNI");
        if (persona.getNombre().isBlank()) camposNulos.append(" NOMBRE");
        if (persona.getApellido().isBlank()) camposNulos.append(" APELLIDO");
        return camposNulos.toString();
    }

    public void actualizarEmpleado(Empleado empleado) throws CampoRequeridoExcepcion, ObjectoNoEncontradoExcepcion {
        String camposNulos = verificarCamposNulos(empleado);
        if (camposNulos.isBlank()) {
            gestorEmpleados.actualizar(empleado.getDni(), empleado);
        } else {
            throw new CampoRequeridoExcepcion(camposNulos);
        }
    }
}