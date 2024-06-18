package org.example.menues.acciones;
import org.example.menues.enums.Entidad;
import org.example.menues.enums.Tarea;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionCuadroTareas implements ActionListener {

    private static final String PACKAGE_NAME = "org.example.sistema.entidades.";

    @Override
    public void actionPerformed(ActionEvent event) {
        JButton button = (JButton) event.getSource();
        Entidad entidad = Entidad.valueOf(button.getName());
        Tarea tarea = Tarea.valueOf(button.getText());
        try {
            Class<?> claseDeEntidad = Class.forName(obtenerNombreDeEntidad(entidad));
            //TODO Un solo panel con multiples formularios y mostramos solo el que queremos usar?
            //  o multiples paneles uno para cada cosa que se puede hacer?
        } catch (ClassNotFoundException exception) {
            System.out.println("No se encontro el tipo de entidad");
        }
    }

    private String obtenerNombreDeEntidad(Entidad entidad) {
        return switch (entidad) {
            case CLIENTES, EMPLEADOS -> PACKAGE_NAME + "persona." + entidad.getEntidad();
            default -> PACKAGE_NAME + entidad.getEntidad();
        };
    }
}
