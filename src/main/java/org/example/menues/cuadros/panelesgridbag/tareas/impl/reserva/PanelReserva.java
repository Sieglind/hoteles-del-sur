package org.example.menues.cuadros.panelesgridbag.tareas.impl.reserva;

import org.example.menues.cuadros.panelesgridbag.PanelCustom;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Habitacion;
import org.example.sistema.entidades.Reserva;
import org.example.sistema.entidades.Servicio;
import org.example.sistema.entidades.persona.Cliente;
import org.example.sistema.enums.Estado;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Vector;

public class PanelReserva extends PanelCustom {
    private final JTextField CAMPO_BUSCAR_RESERVA = crearCampoDeTexto();
    private final JTextField CAMPO_BUSCAR_CLIENTE = crearCampoDeTexto();
    private final JLabel ETIQUETA_NOMBRE_CLIENTE = crearEtiqueta("Nombre: ");
    private final JTextField CAMPO_NOMBRE_CLIENTE = crearCampoDeTexto();
    private final JTextField CAMPO_BUSCAR_HABITACION = crearCampoDeTexto();
    private final JTextField CAMPO_FECHA_INICIO = crearCampoDeTexto();
    private final JTextField CAMPO_FECHA_FIN = crearCampoDeTexto();
    private final JLabel ETIQUETA_ESTADO_RESERVA = (crearEtiqueta("Estado de la Reserva: "));
    private final JComboBox<Estado> CAMPO_ESTADO_RESERVA = new JComboBox<>(Estado.values());
    private JList<Servicio> LISTA_SERVICIOS;


    public PanelReserva(boolean editable) {
        this.setVisible(editable);
        this.add(crearEtiqueta("Dni: "));
        this.add(this.CAMPO_BUSCAR_CLIENTE);
        this.add(this.ETIQUETA_NOMBRE_CLIENTE);
        this.add(this.CAMPO_NOMBRE_CLIENTE);
        this.add(crearEtiqueta("Numero de habitacion: "));
        this.add(this.CAMPO_BUSCAR_HABITACION);
        this.add(crearEtiqueta("Check-In: "));
        this.add(this.CAMPO_FECHA_INICIO);
        this.add(crearEtiqueta("Check-Out: "));
        this.add(this.CAMPO_FECHA_FIN);
        this.add(this.ETIQUETA_ESTADO_RESERVA);
        dimensionarCompomente(CAMPO_ESTADO_RESERVA, CENTER_ALIGNMENT);
        this.add(CAMPO_ESTADO_RESERVA);
        this.ETIQUETA_NOMBRE_CLIENTE.setVisible(false);
        this.CAMPO_NOMBRE_CLIENTE.setVisible(false);
        this.CAMPO_ESTADO_RESERVA.setVisible(false);
        this.ETIQUETA_ESTADO_RESERVA.setVisible(false);
        this.add(crearEtiqueta("Servicios"));
        this.add(crearListaDeServicios());

        if (!editable) {
            CAMPO_BUSCAR_CLIENTE.setEnabled(false);
            CAMPO_BUSCAR_CLIENTE.setDisabledTextColor(Color.BLACK);
            CAMPO_NOMBRE_CLIENTE.setEnabled(false);
            CAMPO_NOMBRE_CLIENTE.setDisabledTextColor(Color.BLACK);
            CAMPO_BUSCAR_HABITACION.setEnabled(false);
            CAMPO_BUSCAR_HABITACION.setDisabledTextColor(Color.BLACK);
            CAMPO_FECHA_INICIO.setEnabled(false);
            CAMPO_FECHA_INICIO.setDisabledTextColor(Color.BLACK);
            CAMPO_FECHA_FIN.setEnabled(false);
            CAMPO_FECHA_FIN.setDisabledTextColor(Color.BLACK);
            CAMPO_BUSCAR_RESERVA.setEnabled(false);
            CAMPO_BUSCAR_RESERVA.setDisabledTextColor(Color.BLACK);
            CAMPO_ESTADO_RESERVA.setEnabled(false);
            CAMPO_ESTADO_RESERVA.setSelectedItem(-1);
            LISTA_SERVICIOS.setEnabled(false);
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
        CAMPO_BUSCAR_CLIENTE.setText(reserva.getCliente().getDni());
        ETIQUETA_NOMBRE_CLIENTE.setVisible(true);
        CAMPO_NOMBRE_CLIENTE.setText(reserva.getCliente().getNombre());
        CAMPO_NOMBRE_CLIENTE.setVisible(true);
        CAMPO_BUSCAR_HABITACION.setText(reserva.getHabitacion().getNumeroDeHabitacion());
        CAMPO_BUSCAR_RESERVA.setText(reserva.getIdReserva());
        CAMPO_FECHA_INICIO.setText(String.valueOf(reserva.getFechaInicio()));
        CAMPO_FECHA_FIN.setText(String.valueOf(reserva.getFechaFin()));
        ETIQUETA_ESTADO_RESERVA.setVisible(true);
        CAMPO_ESTADO_RESERVA.setVisible(true);
        CAMPO_ESTADO_RESERVA.setSelectedItem(reserva.getEstado());
        LISTA_SERVICIOS.setSelectedIndices(reserva.getServiciosElegidos());
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
            reserva = new Reserva(idReserva, cliente, habitacion, fechaInicio, fechaFin,LISTA_SERVICIOS.getSelectedIndices());
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
        this.CAMPO_ESTADO_RESERVA.setEnabled(true);
        LISTA_SERVICIOS.setEnabled(true);
    }

    public Estado getEstadoReserva(){
        return (Estado) CAMPO_ESTADO_RESERVA.getSelectedItem();
    }

    private JScrollPane crearListaDeServicios() {
        JList<Servicio>  listaServicios = new JList<>(new Vector<>(Sistema.getInstance().listarServicios()));
        listaServicios.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        listaServicios.setVisibleRowCount(5);
        LISTA_SERVICIOS = listaServicios;
        JScrollPane scroll = new JScrollPane(listaServicios);
        scroll.setMaximumSize(new Dimension(600,160));
        return scroll;
    }

    public List<Servicio> obtenerServiciosElegidos(){
        return LISTA_SERVICIOS.getSelectedValuesList();
    }
}
