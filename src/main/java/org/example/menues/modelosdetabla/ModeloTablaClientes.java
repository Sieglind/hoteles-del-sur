package org.example.menues.modelosdetabla;

import org.example.sistema.entidades.persona.Cliente;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ModeloTablaClientes extends AbstractTableModel {

    private final List<Cliente> clientes;
    private final String[] columnas = {"DNI", "Nombre Completo", "Segmento"};

    public ModeloTablaClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = clientes.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> cliente.getDni();
            case 1 -> cliente.getNombre() + " " + cliente.getApellido();
            case 2 -> cliente.getSegmento();
            default -> null;
        };
    }

    @Override
    public int getRowCount() {
        return clientes.size();
    }

    @Override
    public int getColumnCount() {
        return columnas.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnas[column];
    }
}
