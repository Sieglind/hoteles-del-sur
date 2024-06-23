package org.example.sistema;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.example.sistema.entidades.Habitacion;
import org.example.sistema.entidades.Servicio;
import org.example.sistema.entidades.persona.Cliente;
import org.example.sistema.entidades.persona.Empleado;
import org.example.sistema.enums.Cargo;
import org.example.sistema.enums.Segmento;
import org.example.sistema.enums.TipoDeHabitacion;

import java.io.FileReader;
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


}
