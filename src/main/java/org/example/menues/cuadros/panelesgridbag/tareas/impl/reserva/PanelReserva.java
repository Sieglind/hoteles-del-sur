package org.example.menues.cuadros.panelesgridbag.tareas.impl.reserva;

import org.example.menues.cuadros.panelesgridbag.PanelCustom;
import org.example.sistema.entidades.Habitacion;
import org.example.sistema.entidades.Reserva;
import org.example.sistema.entidades.persona.Cliente;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class PanelReserva extends PanelCustom {
    private final JLabel ETIQUETA_BUSCAR_RESERVA = crearEtiqueta("Numero de Reserva: ");
    private final JTextField CAMPO_BUSCAR_RESERVA = crearCampoDeTexto();
    private final JLabel ETIQUETA_BUSCAR_CLIENTE = crearEtiqueta("Dni: ");
    private final JTextField CAMPO_BUSCAR_CLIENTE = crearCampoDeTexto();
    private final JLabel ETIQUETA_NOMBRE_CLIENTE = crearEtiqueta("Nombre: ");
    private final JTextField CAMPO_NOMBRE_CLIENTE = crearCampoDeTexto();
    private final JLabel ETIQUETA_BUSCAR_HABITACION = crearEtiqueta("Numero de habitacion: ");
    private final JTextField CAMPO_BUSCAR_HABITACION = crearCampoDeTexto();
    private final JLabel ETIQUETA_FECHA_INICIO = crearEtiqueta("Check-In: ");
    private final JTextField CAMPO_FECHA_INICIO = crearCampoDeTexto();
    private final JLabel ETIQUETA_FECHA_FIN = crearEtiqueta("Check-Out: ");
    private final JTextField CAMPO_FECHA_FIN = crearCampoDeTexto();


    public PanelReserva(boolean editable) {
        this.setVisible(editable);
        this.add(this.ETIQUETA_BUSCAR_CLIENTE);
        this.add(this.CAMPO_BUSCAR_CLIENTE);
        this.add(this.ETIQUETA_NOMBRE_CLIENTE);
        this.add(this.CAMPO_NOMBRE_CLIENTE);
        this.add(this.ETIQUETA_BUSCAR_HABITACION);
        this.add(this.CAMPO_BUSCAR_HABITACION);
        this.add(this.ETIQUETA_FECHA_INICIO);
        this.add(this.CAMPO_FECHA_INICIO);
        this.add(this.ETIQUETA_FECHA_FIN);
        this.add(this.CAMPO_FECHA_FIN);
        this.ETIQUETA_NOMBRE_CLIENTE.setVisible(false);
        this.CAMPO_NOMBRE_CLIENTE.setVisible(false);
        if (!editable) {
            this.CAMPO_BUSCAR_CLIENTE.setEnabled(false);
            this.CAMPO_BUSCAR_CLIENTE.setDisabledTextColor(Color.BLACK);
            this.CAMPO_NOMBRE_CLIENTE.setEnabled(false);
            this.CAMPO_NOMBRE_CLIENTE.setDisabledTextColor(Color.BLACK);
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
    }

    private JLabel crearEtiqueta(String texto) {
        return crearEtiqueta(texto, Component.CENTER_ALIGNMENT);
    }

    private JTextField crearCampoDeTexto() {
        return crearCampoDeTexto(CENTER_ALIGNMENT);
    }

    public void rellenarCampos(Reserva reserva) {
        Border border = new LineBorder(Color.BLACK, 3);
        this.setBorder(new TitledBorder(border, "Resultados"));
        this.CAMPO_BUSCAR_CLIENTE.setText(reserva.getCliente().getDni());
        this.ETIQUETA_NOMBRE_CLIENTE.setVisible(true);
        this.CAMPO_NOMBRE_CLIENTE.setText(reserva.getCliente().getNombre());
        this.CAMPO_NOMBRE_CLIENTE.setVisible(true);
        this.CAMPO_BUSCAR_HABITACION.setText(reserva.getHabitacion().getNumeroDeHabitacion());
        this.CAMPO_BUSCAR_RESERVA.setText(reserva.getIdReserva());
        //this.CAMPO_FECHA_INICIO.setText(reserva.getFechaInicioFormateado());
        this.CAMPO_FECHA_INICIO.setText(String.valueOf(reserva.getFechaInicio()));
        this.CAMPO_FECHA_FIN.setText(String.valueOf(reserva.getFechaFin()));
        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }


    public Reserva crearReserva() {
        Reserva reserva = null;
        Cliente cliente = null;
        Habitacion habitacion = null;
        LocalDate fechaInicio;
        LocalDate fechaFin;
        String idReserva = null;
        try {
            fechaInicio = LocalDate.parse(CAMPO_FECHA_INICIO.getText());
            fechaFin = LocalDate.parse(CAMPO_FECHA_FIN.getText());
            reserva = new Reserva(idReserva, cliente, habitacion, fechaInicio, fechaFin);
        } catch (DateTimeParseException exception) {
            JOptionPane.showMessageDialog(this.getParent(), "Fecha no valida(yyyy-MM-dd): " + exception.getParsedString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return reserva;
    }

    public String getCliente() {
        return CAMPO_BUSCAR_CLIENTE.getText();
    }

    public String getHabitacion() {
        return CAMPO_BUSCAR_HABITACION.getText();
    }

    public void habilitarEdicion() {
        this.CAMPO_BUSCAR_CLIENTE.setEnabled(true);
        this.CAMPO_BUSCAR_HABITACION.setEnabled(true);
        this.CAMPO_FECHA_INICIO.setEnabled(true);
        this.CAMPO_FECHA_FIN.setEnabled(true);
    }

}
