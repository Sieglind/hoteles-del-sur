package org.example.menues.cuadros.cuadroscaja;

import org.example.sistema.entidades.Habitacion;
import org.example.sistema.entidades.Reserva;
import org.example.sistema.entidades.persona.Cliente;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelReserva extends CuadroCajaCustom{
    private final JLabel ETIQUETA_BUSCAR_RESERVA = crearEtiqueta("Ingrese el numero de Reserva: ");
    private final JTextField CAMPO_BUSCAR_RESERVA = crearCampoDeTexto();
    private final JLabel ETIQUETA_BUSCAR_CLIENTE = crearEtiqueta("Ingrese el Dni: ");
    private final JTextField CAMPO_BUSCAR_CLIENTE = crearCampoDeTexto();
    private final JLabel ETIQUETA_BUSCAR_HABITACION = crearEtiqueta("Ingrese el numero de habitacion: ");
    private final JTextField CAMPO_BUSCAR_HABITACION = crearCampoDeTexto();
    private final JLabel ETIQUETA_FECHA_INICIO = crearEtiqueta("Ingrese la fecha de entrada: ");
    private final JTextField CAMPO_FECHA_INICIO = crearCampoDeTexto();
    private final JLabel ETIQUETA_FECHA_FIN = crearEtiqueta("Ingrese la fecha de salida: ");
    private final JTextField CAMPO_FECHA_FIN = crearCampoDeTexto();

    public PanelReserva(boolean editable) {
        this.setVisible(editable);
        this.add(this.ETIQUETA_BUSCAR_CLIENTE);
        this.add(this.CAMPO_BUSCAR_CLIENTE);
        this.add(this.ETIQUETA_BUSCAR_HABITACION);
        this.add(this.CAMPO_BUSCAR_HABITACION);
        this.add(this.ETIQUETA_FECHA_INICIO);
        this.add(this.CAMPO_FECHA_INICIO);
        this.add(this.ETIQUETA_FECHA_FIN);
        this.add(this.CAMPO_FECHA_FIN);
        this.add(ETIQUETA_BUSCAR_RESERVA);
        this.add(CAMPO_BUSCAR_RESERVA);
        if(!editable){
            this.CAMPO_BUSCAR_CLIENTE.setEnabled(false);
            this.CAMPO_BUSCAR_CLIENTE.setDisabledTextColor(Color.BLACK);
            this.CAMPO_BUSCAR_HABITACION.setEnabled(false);
            this.CAMPO_BUSCAR_HABITACION.setDisabledTextColor(Color.BLACK);
            this.CAMPO_FECHA_INICIO.setEnabled(false);
            this.CAMPO_FECHA_INICIO.setDisabledTextColor(Color.BLACK);
            this.CAMPO_FECHA_FIN.setEnabled(false);
            this.CAMPO_FECHA_FIN.setDisabledTextColor(Color.BLACK);
            this.CAMPO_BUSCAR_RESERVA.setEnabled(false);
            this.CAMPO_BUSCAR_RESERVA.setDisabledTextColor(Color.BLACK);
        }
    }

    @Override
    protected void paintComponent(Graphics fondo) {
        this.setBackground(Color.WHITE);
        this.setOpaque(true);
    }

    private JLabel crearEtiqueta(String texto){
        return crearEtiqueta(texto,Component.CENTER_ALIGNMENT);
    }

    private JTextField crearCampoDeTexto(){
        return crearCampoDeTexto(CENTER_ALIGNMENT);
    }

    public void fillValues(Cliente cliente, Habitacion habitacion, Reserva reserva) {
        Border border = new LineBorder(Color.BLACK,3);
        this.setBorder(new TitledBorder(border,"Resultados"));
        this.CAMPO_BUSCAR_CLIENTE.setText(cliente.getDni());
        this.CAMPO_BUSCAR_CLIENTE.setText(cliente.getNombre());
        this.CAMPO_BUSCAR_CLIENTE.setText(cliente.getApellido());
        this.CAMPO_BUSCAR_HABITACION.setText(habitacion.getNumeroDeHabitacion());
        this.CAMPO_BUSCAR_RESERVA.setText(reserva.getIdReserva());
        this.CAMPO_FECHA_INICIO.setText(reserva.getFechaInicioFormateado());
        this.CAMPO_FECHA_FIN.setText(reserva.getFechaFinFormateado());
        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }
}
