package org.example.sistema;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import org.example.sistema.entidades.Habitacion;
import org.example.sistema.entidades.Reserva;
import org.example.sistema.entidades.Servicio;
import org.example.sistema.entidades.persona.Cliente;
import org.example.sistema.entidades.persona.Empleado;
import org.example.sistema.enums.Cargo;
import org.example.sistema.enums.Segmento;
import org.example.sistema.enums.TipoDeHabitacion;
import org.example.sistema.excepciones.ExcepcionObjectoNoEncontrado;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UtilidadesCSV {

    private static final String RESOURCE_PATH = "src/main/resources/";
    private static final String FILENAME_EMPLEADOS = "datos/empleados.csv";
    private static final String FILENAME_CLIENTES = "datos/clientes.csv";
    private static final String FILENAME_HABITACIONES = "datos/habitaciones.csv";
    private static final String FILENAME_RESERVAS = "datos/reservas.csv";
    private static final String FILENAME_SERVICIOS = "datos/servicios.csv";

    private static final Logger LOGGER = Logger.getLogger(UtilidadesCSV.class.getName());

    public static List<Cliente> importarClientes() {
        String filePath = RESOURCE_PATH + FILENAME_CLIENTES;
        List<Cliente> clientes = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            String[] renglon;
            while ((renglon = csvReader.readNext()) != null) {
                Cliente cliente = new Cliente(
                        renglon[0],
                        renglon[1],
                        renglon[2],
                        Segmento.valueOf(renglon[3])
                );
                clientes.add(cliente);
            }
        } catch (IOException | CsvValidationException e) {
            System.out.println(e.getMessage());
        }
        return clientes;
    }

    public static void exportarClientes(List<Cliente> clientes) {
        String filePath = RESOURCE_PATH + FILENAME_CLIENTES;
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(filePath))) {
            clientes.forEach(cliente -> {
                String[] valores = {
                        cliente.getNombre(),
                        cliente.getApellido(),
                        cliente.getDni(),
                        String.valueOf(cliente.getSegmento())
                };
                csvWriter.writeNext(valores);
            });
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo" + e.getMessage());
        }
    }

    public static List<Empleado> importarEmpleados() {
        String filePath = RESOURCE_PATH + FILENAME_EMPLEADOS;
        List<Empleado> empleados = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            String[] renglon;
            while ((renglon = csvReader.readNext()) != null) {
                Cargo cargo = Cargo.valueOf(renglon[3]);
                Empleado empleado = new Empleado(
                        renglon[0],
                        renglon[1],
                        renglon[2],
                        Cargo.valueOf(renglon[3]),
                        cargo.equals(Cargo.ADMINISTRADOR) ? renglon[4] : null
                );
                empleados.add(empleado);
            }
        } catch (IOException | CsvValidationException e) {
            System.out.println(e.getMessage());
        }
        return empleados;
    }

    public static void exportarEmpleados(List<Empleado> empleados) {
        String filePath = RESOURCE_PATH + FILENAME_EMPLEADOS;
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(filePath))) {
            empleados.forEach(empleado -> {
                String[] valores = {
                        empleado.getNombre(),
                        empleado.getApellido(),
                        empleado.getDni(),
                        String.valueOf(empleado.getCargo()),
                        empleado.getCargo().equals(Cargo.ADMINISTRADOR) ? empleado.getPassword() : ""
                };
                csvWriter.writeNext(valores);
            });
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo" + e.getMessage());
        }
    }

    public static List<Habitacion> importarHabitaciones() {
        String filePath = RESOURCE_PATH + FILENAME_HABITACIONES;
        List<Habitacion> habitaciones = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            String[] renglon;
            while ((renglon = csvReader.readNext()) != null) {
                Habitacion habitacion = new Habitacion(
                        renglon[0],
                        TipoDeHabitacion.valueOf(renglon[1]),
                        Float.parseFloat(renglon[2])
                );
                habitaciones.add(habitacion);
            }
        } catch (IOException | CsvValidationException e) {
            System.out.println(e.getMessage());
        }
        return habitaciones;
    }

    public static void exportarHabitaciones(List<Habitacion> habitaciones) {
        String filePath = RESOURCE_PATH + FILENAME_HABITACIONES;
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(filePath))) {
            habitaciones.forEach(habitacion -> {
                String[] valores = {
                        habitacion.getNumeroDeHabitacion(),
                        String.valueOf(habitacion.getTipoDeHabitacion()),
                        String.valueOf(habitacion.getPrecio())
                };
                csvWriter.writeNext(valores);
            });
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo" + e.getMessage());
        }
    }

    public static List<Reserva> importarReservas() {
        String filePath = RESOURCE_PATH + FILENAME_RESERVAS;
        List<Reserva> reservas = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            String[] renglon;
            while ((renglon = csvReader.readNext()) != null) {
                try {
                    Reserva reserva = new Reserva(
                            renglon[0],
                            Sistema.getInstance().buscarCLiente(renglon[1]),
                            Sistema.getInstance().buscarHabitacion(renglon[2]),
                            LocalDate.parse(renglon[3]),
                            LocalDate.parse(renglon[4]),
                            renglon.length == 6 ? leearArregloInt(renglon[5]) : new int[0]
                            );
                    reservas.add(reserva);
                } catch (Exception excepcion){
                    LOGGER.log(Level.WARNING,excepcion.getMessage());
                }
            }
        } catch (IOException | CsvValidationException excepcion) {
            LOGGER.log(Level.WARNING,excepcion.getMessage());
        }
        return reservas;
    }

    private static int[] leearArregloInt(String string) {
        try {
            String[] indices = string.substring(1, string.length() - 1).split(",");
            return Arrays.stream(indices)
                    .mapToInt(num -> Integer.parseInt(num.trim()))
                    .toArray();
        } catch (NumberFormatException e) {
            return new int[0];
        }
    }

    public static void exportarReservas(List<Reserva> reservas) {
        String filePath = RESOURCE_PATH + FILENAME_RESERVAS;
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(filePath))) {
            reservas.forEach(reserva -> {
                String[] valores = {
                        reserva.getIdReserva(),
                        String.valueOf(reserva.getCliente().getDni()),
                        String.valueOf(reserva.getHabitacion().getNumeroDeHabitacion()),
                        reserva.getFechaInicio().toString(),
                        reserva.getFechaFin().toString(),
                        Arrays.toString(reserva.getServiciosElegidos())
                };
                csvWriter.writeNext(valores);
            });
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo" + e.getMessage());
        }
    }

    public static List<Servicio> importarServicios() {
        String filePath = RESOURCE_PATH + FILENAME_SERVICIOS;
        List<Servicio> servicios = new ArrayList<>();
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            String[] renglon;
            while ((renglon = csvReader.readNext()) != null) {
                Servicio servicio = new Servicio(
                        renglon[0],
                        renglon[1],
                        renglon[2],
                        Float.parseFloat(renglon[3])
                );
                servicios.add(servicio);
            }
        } catch (IOException | CsvValidationException e) {
            System.out.println(e.getMessage());
        }
        return servicios;
    }

    public static void exportarServicios(List<Servicio> servicios) {
        String filePath = RESOURCE_PATH + FILENAME_SERVICIOS;
        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(filePath))) {
            for (Servicio servicio : servicios) {
                String[] valores = {
                        servicio.getCodigo(),
                        servicio.getCategoria(),
                        servicio.getDescripcion(),
                        String.valueOf(servicio.getPrecio())
                };
                csvWriter.writeNext(valores);
            }
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo" + e.getMessage());
        }
    }
}
