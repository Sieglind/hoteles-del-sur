package org.example.sistema;

import org.apache.commons.lang3.StringUtils;
import org.example.sistema.entidades.Habitacion;
import org.example.sistema.entidades.Reserva;
import org.example.sistema.entidades.Servicio;
import org.example.sistema.entidades.persona.Cliente;
import org.example.sistema.entidades.persona.Empleado;
import org.example.sistema.entidades.persona.Persona;
import org.example.sistema.enums.Cargo;
import org.example.sistema.enums.Estado;
import org.example.sistema.excepciones.ExcepcionCamposRequeridos;
import org.example.sistema.excepciones.ExcepcionHabitacionNoDisponible;
import org.example.sistema.excepciones.ExcepcionObjectoNoEncontrado;
import org.example.sistema.excepciones.ExcepcionObjetoYaExiste;
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

    public boolean login(String dni, String password) throws ExcepcionObjectoNoEncontrado {
        Empleado empleado = gestorEmpleados.buscar(dni);
        return empleado.getPassword().equals(password) && empleado.getCargo().equals(Cargo.ADMINISTRADOR);
    }

    public static synchronized Sistema getInstance() {
        if (sistema == null) {
            sistema = new Sistema(new Hotel("Hoteles del Sur", "Fake St 123", "Please no"));
        }
        return sistema;
    }

    public void crearCliente(Cliente cliente) throws ExcepcionObjetoYaExiste, ExcepcionCamposRequeridos {
        String camposNulos = verificarCamposNulos(cliente);
        if (camposNulos.isBlank()) {
            gestorClientes.crear(cliente);
        } else {
            throw new ExcepcionCamposRequeridos(camposNulos);
        }
    }

    public Cliente buscarCLiente(String campoDni) throws ExcepcionObjectoNoEncontrado {
        return gestorClientes.buscar(campoDni);
    }

    public List<Cliente> listarClientes() {
        return this.gestorClientes.listar();
    }

    public void borrarCliente(String campoDni) throws ExcepcionObjectoNoEncontrado {
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

    public Servicio buscarServicio(String clave) throws ExcepcionObjectoNoEncontrado {
        return gestorDeServicios.buscar(clave);
    }

    public String crearReserva(Reserva reserva, String dni, String habitacion) throws ExcepcionObjetoYaExiste,
            ExcepcionObjectoNoEncontrado, ExcepcionHabitacionNoDisponible, ExcepcionCamposRequeridos {
        String camposNulos = verificarCamposNulosReserva(dni, habitacion);
        if (!camposNulos.isBlank()) {
            throw new ExcepcionCamposRequeridos(camposNulos);
        } else {
            reserva.setCliente(buscarCLiente(dni));
            reserva.setHabitacion(buscarHabitacion(habitacion));
            asignarIdReserva(reserva);
            if (habitacionLibre(reserva)) {
                return gestorReservas.crear(reserva);
            } else {
                throw new ExcepcionHabitacionNoDisponible(reserva.getHabitacion().getNumeroDeHabitacion());
            }
        }
    }

    private static String verificarCamposNulosReserva(String dni, String habitacion) {
        StringBuilder camposNulos = new StringBuilder();
        if (dni.isBlank()) camposNulos.append(" DNI");
        if (habitacion.isBlank()) camposNulos.append(" HABITACION");
        return camposNulos.toString();
    }

    private boolean habitacionLibre(Reserva reserva) {
        return listarReservas().stream()
                .filter(reservaExistente -> reservaExistente.getHabitacion() == reserva.getHabitacion())
                .filter(reservaExistente -> reservaExistente.getFechaFin().isBefore(reserva.getFechaInicio()) || reservaExistente.getFechaInicio().isBefore(reserva.getFechaFin()))
                .toList().isEmpty();
    }

    public String asignarIdReserva(Reserva reserva) {
        return gestorReservas.asignarId(reserva);
    }

    public List<Reserva> listarReservas() {
        return this.gestorReservas.listar();
    }

    public Reserva buscarReserva(String idReserva) throws ExcepcionObjectoNoEncontrado {
        return gestorReservas.buscar(idReserva);
    }

    public void borrarReserva(String id) throws ExcepcionObjectoNoEncontrado {
        gestorReservas.borrar(id);
    }

    public void actualizarReserva(Estado estadoReserva, String id, String dni, String habitacion, Reserva reserva) throws ExcepcionObjectoNoEncontrado, ExcepcionCamposRequeridos {
        String camposNulos = verificarCamposNulosReserva(dni, habitacion);
        if (!camposNulos.isBlank()) {
            throw new ExcepcionCamposRequeridos(camposNulos);
        } else {
            reserva.setEstado(estadoReserva);
            reserva.setCliente(buscarCLiente(dni));
            reserva.setHabitacion(buscarHabitacion(habitacion));
            gestorReservas.actualizar(id, reserva);
        }
    }

    public Habitacion buscarHabitacion(String numeroHabitacion) throws ExcepcionObjectoNoEncontrado {
        return gestorHabitaciones.buscar(numeroHabitacion);
    }

    public void crearHabitacion(Habitacion valor) throws ExcepcionObjetoYaExiste, ExcepcionCamposRequeridos {
        String camposNulos = verificacionCampoNuloHabitacion(valor);
        if (!camposNulos.isBlank()) {
            throw new ExcepcionCamposRequeridos(camposNulos);
        } else {
            gestorHabitaciones.crear(valor);
        }
    }

    public void borrarHabitacion(String numeroHabitacion) throws ExcepcionObjectoNoEncontrado {
        gestorHabitaciones.borrar(numeroHabitacion);
    }

    public Empleado buscarEmpleado(String campoDni) throws ExcepcionObjectoNoEncontrado {
        return gestorEmpleados.buscar(campoDni);
    }

    public void crearEmpleado(Empleado empleado) throws ExcepcionObjetoYaExiste, ExcepcionCamposRequeridos {
        String camposNulos = verificarCamposNulos(empleado);
        if (camposNulos.isBlank()) {
            gestorEmpleados.crear(empleado);
        } else {
            throw new ExcepcionCamposRequeridos(camposNulos);
        }
    }

    public void borrarEmpleado(String dni) throws ExcepcionObjectoNoEncontrado {
        gestorEmpleados.borrar(dni);
    }


    private static String verificarCamposNulos(Persona persona) {
        StringBuilder camposNulos = new StringBuilder();
        if (persona.getDni().isBlank()) camposNulos.append(" DNI");
        if (persona.getNombre().isBlank()) camposNulos.append(" NOMBRE");
        if (persona.getApellido().isBlank()) camposNulos.append(" APELLIDO");
        return camposNulos.toString();
    }

    private static String verificacionCampoNuloHabitacion(Habitacion habitacion) {
        StringBuilder camposNulos = new StringBuilder();
        if (habitacion.getNumeroDeHabitacion().isBlank() || !StringUtils.isNumeric(habitacion.getNumeroDeHabitacion()))
            camposNulos.append(" Numero de Habitacion");
        return camposNulos.toString();
    }

    private static String verificarCamposNulos(Servicio servicio) {
        StringBuilder camposNulos = new StringBuilder();
        if (servicio.getNombre().isBlank()) camposNulos.append(" NOMBRE");
        if (servicio.getDescripcion().isBlank()) camposNulos.append(" DESCRIPCION");
        if (servicio.getPrecio() == 0) camposNulos.append(" PRECIO");
        if (servicio.getCodigo().isBlank()) camposNulos.append(" CODIGO");
        return camposNulos.toString();
    }

    public void actualizarEmpleado(Empleado empleado) throws ExcepcionCamposRequeridos, ExcepcionObjectoNoEncontrado {
        String camposNulos = verificarCamposNulos(empleado);
        if (camposNulos.isBlank()) {
            gestorEmpleados.actualizar(empleado.getDni(), empleado);
        } else {
            throw new ExcepcionCamposRequeridos(camposNulos);
        }
    }

    public void actualizarHabitacion(Habitacion habitacion) throws ExcepcionObjectoNoEncontrado {
        gestorHabitaciones.actualizar(habitacion.getNumeroDeHabitacion(), habitacion);
    }

    public void crearServicio(Servicio servicio) throws ExcepcionObjetoYaExiste, ExcepcionCamposRequeridos {
        String camposNulos = verificarCamposNulos(servicio);
        if (camposNulos.isBlank()) {
            gestorDeServicios.crear(servicio);
        } else {
            throw new ExcepcionCamposRequeridos(camposNulos);
        }
    }

    public void borrarServicio(String clave) throws ExcepcionObjectoNoEncontrado {
        gestorDeServicios.borrar(clave);
    }

    public void actualizarServicio(Servicio servicio) throws ExcepcionCamposRequeridos, ExcepcionObjectoNoEncontrado {
        String camposNulos = verificarCamposNulos(servicio);
        if (camposNulos.isBlank()) {
            gestorDeServicios.actualizar(servicio.getCodigo(), servicio);
        } else {
            throw new ExcepcionCamposRequeridos(camposNulos);
        }
    }
}