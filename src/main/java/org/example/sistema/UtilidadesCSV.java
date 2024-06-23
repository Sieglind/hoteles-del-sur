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

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UtilidadesCSV {

    public static List<Empleado> importarEmpleados() {
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


        } catch (IOException | CsvValidationException e) {
            System.out.println(e.getMessage());
        }
        return empleados;
    }

    public static List<Cliente> importarClientes() {
        String filePath = "src/main/resources/clientes.csv";

        List<Cliente> clientes = new ArrayList<>();

        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {

            String[] renglon;

            while ((renglon = csvReader.readNext()) != null) {
                String[] valores = renglon[0].split(";");

                Segmento segmento = Segmento.valueOf(valores[3]);

                Cliente cliente = new Cliente(
                        valores[0], //nombre
                        valores[1], //apellido
                        valores[2], //dni
                        segmento //segmento
                );

                clientes.add(cliente);

            }

            //clientes.forEach(System.out::println);  // Mensaje de depuración only

        } catch (IOException | CsvValidationException e) {
            System.out.println(e.getMessage());
        }

        return clientes;

    }
    public static List<Habitacion> importarHabitaciones() {
        String filePath = "src/main/resources/habitaciones.csv";

        List<Habitacion> habitaciones = new ArrayList<>();

        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {

            String[] renglon;

            while ((renglon = csvReader.readNext()) != null) {
                String[] valores = renglon[0].split(";");

                TipoDeHabitacion tipoDeHabitacion = TipoDeHabitacion.valueOf(valores[1]);

                Habitacion habitacion = new Habitacion(
                        valores[0], //nro de habitacion
                        tipoDeHabitacion ,//tipo de habitacion
                        0
                );

                habitaciones.add(habitacion);

            }

            //habitaciones.forEach(System.out::println);  // Mensaje de depuración only

        } catch (IOException | CsvValidationException e) {
            System.out.println(e.getMessage());
        }

        return habitaciones;

    }

    public static List<Servicio> importarServicios() {
        String filePath = "src/main/resources/servicios.csv";

        List<Servicio> servicios = new ArrayList<>();

        try (CSVReader csvReader = new CSVReader(new FileReader(filePath))) {

            String[] renglon;

            while ((renglon = csvReader.readNext()) != null) {
                String[] valores = renglon[0].split(";");

                Servicio servicio = new Servicio(
                        valores[0], //nombre
                        valores[1],//descripcion
                        Float.parseFloat(valores[2]), //precio
                        valores[3] //clave
                );

                servicios.add(servicio);

            }

            //servicios.forEach(System.out::println);  // Mensaje de depuración only

        } catch (IOException | CsvValidationException e) {
            System.out.println(e.getMessage());
        }

        return servicios;

    }

    public static void exportarClientes(List<Cliente> clientes) {

        String filePath = "src/main/resources/clientes.csv";

        try(CSVWriter csvWriter = new CSVWriter(new FileWriter(filePath))){

            clientes.forEach(cliente -> {

                String[] valores = {
                        cliente.getNombre(),
                        cliente.getApellido(),
                        cliente.getDni(),
                        String.valueOf(cliente.getSegmento())
                };
                csvWriter.writeNext(valores);
            });

        }catch (IOException e) {
            System.out.println("Error al escribir en el archivo" + e.getMessage());
        }

    }

    public static void exportarHabitaciones(List<Habitacion> habitaciones) {

        String filePath = "src/main/resources/habitaciones.csv";

        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(filePath))){

            habitaciones.forEach(habitacion -> {

                String[] valores ={
                        habitacion.getNumeroDeHabitacion(),
                        String.valueOf(habitacion.getTipoDeHabitacion())
                };
                csvWriter.writeNext(valores);
            });

        }catch (IOException e) {
            System.out.println("Error al escribir en el archivo" + e.getMessage());
        }
    }

    public static void exportarServicios(List<Servicio> servicios) {
        String filePath = "src/main/resources/servicios.csv";

        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(filePath));){


            for (Servicio servicio : servicios) {
                String[] valores = {
                        servicio.getNombre(),
                        servicio.getDescripcion(),
                        String.valueOf(servicio.getPrecio()),
                        servicio.getCodigo()

                };
                csvWriter.writeNext(valores);
            }

        }catch (IOException e) {
            System.out.println("Error al escribir en el archivo" + e.getMessage());
        }
    }

    public static void exportarEmpleados(List<Empleado> empleados) {

        String filePath = "src/main/resources/empleados.csv";

        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(filePath))){

            empleados.forEach(empleado -> {
                String[] valores = {
                        empleado.getNombre(),
                        empleado.getApellido(),
                        empleado.getDni(),
                        String.valueOf(empleado.getCargo())
                };

                csvWriter.writeNext(valores);
            });

        }catch (IOException e) {
            System.out.println("Error al escribir en el archivo" + e.getMessage());
        }
    }

    public static void exportarReservas(List<Reserva> reservas) {
        String filePath = "src/main/resources/reservas.csv";

        try (CSVWriter csvWriter = new CSVWriter(new FileWriter(filePath))){

            reservas.forEach(reserva -> {
                String[] valores = {
                        reserva.getIdReserva(),
                        String.valueOf(reserva.getCliente()),
                        String.valueOf(reserva.getHabitacion()),
                        reserva.getFechaInicioFormateado(),
                        reserva.getFechaFinFormateado()
                };
                csvWriter.writeNext(valores);
            });

        }catch (IOException e) {
            System.out.println("Error al escribir en el archivo" + e.getMessage());
        }
    }
}
