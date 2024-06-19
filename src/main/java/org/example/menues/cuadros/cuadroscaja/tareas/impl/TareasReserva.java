package org.example.menues.cuadros.cuadroscaja.tareas.impl;

import org.example.menues.acciones.AccionVolver;
import org.example.menues.cuadros.cuadroscaja.CuadroBotonesZocalo;
import org.example.menues.cuadros.cuadroscaja.CuadroCajaCustom;
import org.example.menues.cuadros.cuadroscaja.tareas.Tareas;
import org.example.menues.enums.Entidad;
import org.example.menues.enums.Tarea;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Reserva;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.List;

public class TareasReserva extends CuadroCajaCustom implements Tareas {

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
    private final JButton BOTON_VOLVER = crearBoton("Volver", LEFT_ALIGNMENT, new AccionVolver(Entidad.HABITACIONES.name()));

    public TareasReserva(Tarea tarea) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setVisible(true);
        seleccionarPanel(tarea);
    }

    private void seleccionarPanel(Tarea tarea) {

        switch (tarea) {
            case CREAR -> panelCrear();
            case BUSCAR -> panelBuscar();
            case LISTAR -> panelListar();
            case ACTUALIZAR -> panelActualizar();
            case BORRAR -> panelEliminar();
        }
    }

    @Override
    public void panelCrear() {
        this.setBorder(new TitledBorder("Crear Reserva"));

        this.add(ETIQUETA_BUSCAR_CLIENTE);
        this.add(CAMPO_BUSCAR_CLIENTE);
        this.add(ETIQUETA_BUSCAR_HABITACION);
        this.add(CAMPO_BUSCAR_HABITACION);
        this.add(ETIQUETA_FECHA_INICIO);
        this.add(CAMPO_FECHA_INICIO);
        this.add(ETIQUETA_FECHA_FIN);
        this.add(CAMPO_FECHA_FIN);

        JPanel zocalo = new CuadroBotonesZocalo();
        JButton guardar = new JButton("Guardar");
        zocalo.add(guardar);
        zocalo.add(BOTON_VOLVER);
        this.add(zocalo);

    }

    @Override
    public void panelBuscar() {
        this.setBorder(new TitledBorder("Buscar Reserva"));

        this.add(ETIQUETA_BUSCAR_RESERVA);
        this.add(CAMPO_BUSCAR_RESERVA);

        JPanel Zocalo = new CuadroBotonesZocalo();
        JButton buscar = new JButton("Buscar");
        Zocalo.add(buscar);
        Zocalo.add(BOTON_VOLVER);
        this.add(Zocalo);
    }

    @Override
    public void panelListar() {
        this.setBorder(new TitledBorder("Listar Reservas"));
        List<Reserva> reservas = Sistema.getInstance().listarReservas();

        JPanel panelDeReservas = new JPanel();
        panelDeReservas.setLayout(new BoxLayout(panelDeReservas, BoxLayout.Y_AXIS));
        reservas.forEach(reserva -> {
            JPanel panelDeReserva = new JPanel();
            panelDeReserva.setBorder(new LineBorder(Color.black, 1));
            JLabel idReserva = new JLabel("\nID Reserva: " + reserva.getIdReserva());
            JLabel cliente = new JLabel("\nCliente: " + reserva.getCliente().getNombre() + " " + reserva.getCliente().getApellido());
            JLabel habitacion = new JLabel("\nHabitacion: " + reserva.getHabitacion().getNumeroDeHabitacion() + " " + reserva.getHabitacion().getTipoDeHabitacion());
            JLabel fechaInicio = new JLabel("\nFecha inicio: " + reserva.getFechaInicio());
            JLabel fechaFin = new JLabel("\nFecha fin: " + reserva.getFechaFin());
            JLabel estado = new JLabel("\nEstado: " + reserva.getEstado());

            panelDeReserva.add(idReserva);
            panelDeReserva.add(cliente);
            panelDeReserva.add(habitacion);
            panelDeReserva.add(fechaInicio);
            panelDeReserva.add(fechaFin);
            panelDeReserva.add(estado);

            panelDeReserva.setVisible(true);
            dimensionarCompomente(panelDeReserva, LEFT_ALIGNMENT);
            panelDeReservas.add(panelDeReserva);
        });
        JScrollPane contenedorDeLista = new JScrollPane(panelDeReservas);
        this.add(contenedorDeLista);


        JPanel zocalo = new CuadroBotonesZocalo();
        zocalo.add(BOTON_VOLVER);
        this.add(zocalo);
    }

    @Override
    public void panelActualizar() {
        this.setBorder(new TitledBorder("Actualizar Reserva"));

        this.add(ETIQUETA_BUSCAR_RESERVA);
        this.add(CAMPO_BUSCAR_RESERVA);

        JPanel zocalo = new CuadroBotonesZocalo();
        JButton buscar = new JButton("Buscar");
        zocalo.add(buscar);

        this.add(ETIQUETA_BUSCAR_CLIENTE);
        this.add(CAMPO_BUSCAR_CLIENTE);
        this.add(ETIQUETA_BUSCAR_HABITACION);
        this.add(CAMPO_BUSCAR_HABITACION);
        this.add(ETIQUETA_FECHA_INICIO);
        this.add(CAMPO_FECHA_INICIO);
        this.add(ETIQUETA_FECHA_FIN);
        this.add(CAMPO_FECHA_FIN);

        JButton actualizar = new JButton("Actualizar");
        zocalo.add(actualizar);
        zocalo.add(BOTON_VOLVER);
        this.add(zocalo);

    }

    @Override
    public void panelEliminar() {
        this.setBorder(new TitledBorder("Eliminar Reserva"));

        this.add(ETIQUETA_BUSCAR_RESERVA);
        this.add(CAMPO_BUSCAR_RESERVA);

        JPanel zocalo = new CuadroBotonesZocalo();
        JButton buscar = new JButton("Buscar");
        zocalo.add(buscar);
        JButton eliminar = new JButton("Eliminar");
        zocalo.add(eliminar);
        zocalo.add(BOTON_VOLVER);
        this.add(zocalo);
    }

    private JLabel crearEtiqueta(String texto) {
        return crearEtiqueta(texto, Component.LEFT_ALIGNMENT);
    }

    private JTextField crearCampoDeTexto() {
        return crearCampoDeTexto(LEFT_ALIGNMENT);
    }


}
