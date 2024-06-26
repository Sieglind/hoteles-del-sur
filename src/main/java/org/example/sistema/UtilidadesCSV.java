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
import org.example.sistema.excepciones.ExcepcionCamposRequeridos;
import org.example.sistema.excepciones.ExcepcionObjetoYaExiste;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
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

    public static void importarDatos(){
        importarClientes();
        importarEmpleados();
        importarHabitaciones();
        importarReservas();
        importarServicios();
    }

    public static void importarClientes() {
        String filePath = RESOURCE_PATH + FILENAME_CLIENTES;
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            String[] renglon;
            while ((renglon = csvReader.readNext()) != null) {
                Cliente cliente = new Cliente(
                        renglon[0],
                        renglon[1],
                        renglon[2],
                        Segmento.valueOf(renglon[3])
                );
                try {
                    Sistema.getInstance().crearCliente(cliente);
                } catch (ExcepcionObjetoYaExiste | ExcepcionCamposRequeridos excepcion) {
                    logearAlerta(excepcion);
                }
            }
        } catch (IOException | CsvValidationException excepcion) {
            logearAlerta(excepcion);
        }
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

    public static void importarEmpleados() {
        String filePath = RESOURCE_PATH + FILENAME_EMPLEADOS;
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
                try {
                    Sistema.getInstance().crearEmpleado(empleado);
                } catch (ExcepcionObjetoYaExiste | ExcepcionCamposRequeridos excepcion) {
                    logearAlerta(excepcion);
                }
            }
        } catch (IOException | CsvValidationException excepcion) {
            logearAlerta(excepcion);
        }
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

    public static void importarHabitaciones() {
        String filePath = RESOURCE_PATH + FILENAME_HABITACIONES;
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            String[] renglon;
            while ((renglon = csvReader.readNext()) != null) {
                Habitacion habitacion = new Habitacion(
                        renglon[0],
                        TipoDeHabitacion.valueOf(renglon[1]),
                        Float.parseFloat(renglon[2])
                );
                try{
                    Sistema.getInstance().crearHabitacion(habitacion);
                } catch (ExcepcionObjetoYaExiste | ExcepcionCamposRequeridos excepcion) {
                    logearAlerta(excepcion);
                }
            }
        } catch (IOException | CsvValidationException excepcion) {
            logearAlerta(excepcion);
        }
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

    public static void importarReservas() {
        String filePath = RESOURCE_PATH + FILENAME_RESERVAS;
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            String[] renglon;
            while ((renglon = csvReader.readNext()) != null) {
                Reserva reserva = new Reserva(
                        renglon[0],
                        null,
                        null,
                        LocalDate.parse(renglon[3]),
                        LocalDate.parse(renglon[4]),
                        renglon.length == 6 ? leearArregloInt(renglon[5]) : new int[0]
                );
                try {
                    Sistema.getInstance().crearReserva(reserva, renglon[1], renglon[2]);
                } catch (Exception excepcion) {
                    logearAlerta(excepcion);
                }
            }
        } catch (IOException | CsvValidationException excepcion) {
            logearAlerta(excepcion);
        }
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

    public static void importarServicios() {
        String filePath = RESOURCE_PATH + FILENAME_SERVICIOS;
        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {
            String[] renglon;
            while ((renglon = csvReader.readNext()) != null) {
                Servicio servicio = new Servicio(
                        renglon[0],
                        renglon[1],
                        renglon[2],
                        Float.parseFloat(renglon[3])
                );
                try {
                    Sistema.getInstance().crearServicio(servicio);
                } catch (ExcepcionObjetoYaExiste | ExcepcionCamposRequeridos excepcion) {
                    logearAlerta(excepcion);
                }
            }
        } catch (IOException | CsvValidationException excepcion) {
            logearAlerta(excepcion);
        }
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

    private static void logearAlerta(Exception excepcion){
        LOGGER.log(Level.WARNING, excepcion.getMessage());
    }
}
