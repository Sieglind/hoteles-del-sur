package org.example.menues.modelosdetabla;

import org.example.sistema.entidades.Habitacion;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ModeloTablaHabitaciones extends AbstractTableModel {

    private final List<Habitacion> habitaciones;
    private final String[] columnas = {"Numero de Habitacion","Tipo","Precio"};

    public ModeloTablaHabitaciones(List<Habitacion> habitaciones){
        this.habitaciones = habitaciones;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Habitacion habitacion = habitaciones.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> habitacion.getNumeroDeHabitacion();
            case 1 -> habitacion.getTipoDeHabitacion();
            case 2 -> habitacion.getPrecio();
            default -> null;
        };
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public int getRowCount() {
        return habitaciones.size();
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
}
