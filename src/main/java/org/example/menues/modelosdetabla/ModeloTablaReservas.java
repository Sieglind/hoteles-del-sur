package org.example.menues.modelosdetabla;

import org.example.sistema.entidades.Reserva;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class ModeloTablaReservas extends AbstractTableModel {

    private final List<Reserva> reservas;
    private final String[] colunas = {
            "Id",
            "DNI",
            "Nombre Completo",
            "Segmento",
            "Numero de Habitacion",
            "Tipo de Habitacion",
            "Precio",
            "Check-In",
            "Check-Out",
            "Estado"
    };

    public ModeloTablaReservas(List<Reserva> reservas) {
        this.reservas = reservas;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Reserva reserva = reservas.get(rowIndex);
        return switch (columnIndex) {
            case 0 -> reserva.getIdReserva();
            case 1 -> reserva.getCliente().getDni();
            case 2 -> reserva.getCliente().getNombre() + " " + reserva.getCliente().getApellido();
            case 3 -> reserva.getCliente().getSegmento();
            case 4 -> reserva.getHabitacion().getNumeroDeHabitacion();
            case 5 -> reserva.getHabitacion().getTipoDeHabitacion();
            case 6 -> reserva.getHabitacion().getPrecio();
            case 7 -> reserva.getFechaInicio();
            case 8 -> reserva.getFechaFin();
            case 9 -> reserva.getEstado();
            default -> null;
        };
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public int getRowCount() {
        return reservas.size();
    }

    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }
}
