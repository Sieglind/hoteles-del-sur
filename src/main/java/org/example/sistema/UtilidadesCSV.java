package org.example.sistema;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import org.example.sistema.entidades.persona.Empleado;
import org.example.sistema.enums.Cargo;

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


}
