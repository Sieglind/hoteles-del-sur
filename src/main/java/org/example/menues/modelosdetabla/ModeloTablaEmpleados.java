package org.example.menues.modelosdetabla;

import org.example.sistema.entidades.persona.Empleado;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ModeloTablaEmpleados extends AbstractTableModel {

    private final List<Empleado> empleados;
    private final String[] colunas = {"Nombre", "Nombre Completo", "Cargo"};

    public ModeloTablaEmpleados(List<Empleado> empleados){
        this.empleados = empleados;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Empleado empleado = empleados.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> empleado.getNombre();
            case 1 -> empleado.getApellido() + " " + empleado.getApellido();
            case 2 -> empleado.getCargo();
            default -> null;
        };
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public int getRowCount() {
        return empleados.size();
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
}
