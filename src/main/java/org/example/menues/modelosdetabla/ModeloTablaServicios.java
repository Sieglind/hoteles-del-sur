package org.example.menues.modelosdetabla;

import org.example.sistema.entidades.Servicio;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ModeloTablaServicios  extends AbstractTableModel {

    private final List<Servicio> servicios;
    private final String[] columnas = {"Codigo","Categoria","Descripcion","Precion"};

    public ModeloTablaServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Servicio servicio = servicios.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> servicio.getCodigo();
            case 1 -> servicio.getCategoria();
            case 2 -> servicio.getDescripcion();
            case 3 -> servicio.getPrecio();
            default -> null;
        };
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public int getRowCount() {
        return servicios.size();
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
}
