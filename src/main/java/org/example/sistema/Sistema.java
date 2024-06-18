package org.example.sistema;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.example.sistema.entidades.persona.Empleado;
import org.example.sistema.enums.Cargo;
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
        Empleado administrador = new Empleado("Facundo",
                "Square", "123456789",
                Cargo.ADMINISTRADOR, "123456");
        try {
            gestorEmpleados.crear(administrador);
        } catch (ObjetoYaExisteExcepcion excepcion) {
            System.out.println("Sopenco");
        }

        List<Empleado> listaEmpleados = importarEmpleados();
    }

    private List<Empleado> importarEmpleados() {
        String filePath = "src/main/resources/empleados.csv";

        List<Empleado> empleados = new ArrayList<>();

        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            String[] renglon;

            while ((renglon = csvReader.readNext()) != null) {
                String[] valores = renglon[0].split(";");
                Cargo cargo = Cargo.valueOf(valores[3]);

                Empleado empleado = new Empleado(
                        valores[0],
                        valores[1],
                        valores[2],
                        Cargo.valueOf(valores[3]),
                        cargo.equals(Cargo.ADMINISTRADOR) ? valores[4] : null
                );

                empleados.add(empleado);

            }
            this.gestorEmpleados.cargarEmpleados(empleados);

        } catch (IOException | CsvValidationException e) {
            System.out.println(e.getMessage());
        }
        return null;
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
}