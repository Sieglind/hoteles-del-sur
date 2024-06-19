package org.example.menues.cuadros.cuadroscaja.tareas.impl;

import org.example.menues.acciones.AccionVolver;
import org.example.menues.cuadros.cuadroscaja.CuadroBotonesZocalo;
import org.example.menues.cuadros.cuadroscaja.CuadroCajaCustom;
import org.example.menues.cuadros.cuadroscaja.tareas.Tareas;
import org.example.menues.enums.Entidad;
import org.example.menues.enums.Tarea;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Habitacion;
import org.example.sistema.enums.TipoDeHabitacion;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.List;


public class TareasHabitacion extends CuadroCajaCustom implements Tareas {
    private final JLabel ETIQUETA_NUMERO_HABITACION = crearEtiqueta("Numero de Habitacion: ");
    private final JTextField CAMPO_NUMERO_HABITACION = crearCampoDeTexto();
    private final JLabel ETIQUETA_TIPO_HABITACION = crearEtiqueta("Tipo de Habitacion: ");
    private final JComboBox<TipoDeHabitacion> CAMPO_TIPO_HABITACION = new JComboBox<>(TipoDeHabitacion.values());
    private final JCheckBox DISPONIBILIDAD = new JCheckBox("Disponible");
    private final JButton BOTON_VOLVER = crearBoton("Volver", LEFT_ALIGNMENT, new AccionVolver(Entidad.HABITACIONES.name()));

    public TareasHabitacion(Tarea tarea) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setVisible(true);
        dimensionarCompomente(CAMPO_TIPO_HABITACION, LEFT_ALIGNMENT);
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
        this.setBorder(new TitledBorder("Crear Habitación"));
        limpiarCampos();
        this.add(ETIQUETA_NUMERO_HABITACION);
        this.add(CAMPO_NUMERO_HABITACION);
        this.add(ETIQUETA_TIPO_HABITACION);
        this.add(CAMPO_TIPO_HABITACION);


        JPanel zocalo = new CuadroBotonesZocalo();
        JButton guardar = new JButton("Guardar");
        zocalo.add(guardar);
        zocalo.add(BOTON_VOLVER);
        this.add(zocalo);

    }


    @Override
    public void panelBuscar() {
        this.setBorder(new TitledBorder("Buscar Habitacion"));

        this.add(ETIQUETA_NUMERO_HABITACION);
        this.add(CAMPO_NUMERO_HABITACION);

        JPanel Zocalo = new CuadroBotonesZocalo();
        JButton guardar = new JButton("Guardar");
        Zocalo.add(guardar);
        Zocalo.add(BOTON_VOLVER);
        this.add(Zocalo);
    }

    @Override
    public void panelListar() {
        this.setBorder(new TitledBorder("Listar Habitaciones"));
        List<Habitacion> habitaciones = Sistema.getInstance().listarHabitaciones();

        JPanel panelDeHabitaciones = new JPanel();
        panelDeHabitaciones.setLayout(new BoxLayout(panelDeHabitaciones, BoxLayout.Y_AXIS));
        habitaciones.forEach(habitacion -> {
            JPanel panelDeHabitacion = new JPanel();
            panelDeHabitacion.setBorder(new LineBorder(Color.black, 1));
            JLabel numeroHabitacion = new JLabel("Numero de habitacion: " + habitacion.getNumeroDeHabitacion());
            JLabel tipoDeHabitacion = new JLabel("Tipo de Habitacion: " + habitacion.getTipoDeHabitacion());
            panelDeHabitacion.add(numeroHabitacion);
            panelDeHabitacion.add(tipoDeHabitacion);
            panelDeHabitacion.setVisible(true);
            dimensionarCompomente(panelDeHabitacion,LEFT_ALIGNMENT);
            panelDeHabitaciones.add(panelDeHabitacion);
        });
        JScrollPane contenedorDeLista = new JScrollPane(panelDeHabitaciones);
        this.add(contenedorDeLista);


        JPanel zocalo = new CuadroBotonesZocalo();
        zocalo.add(BOTON_VOLVER);
        this.add(zocalo);
    }

    @Override
    public void panelActualizar() {
        this.setBorder(new TitledBorder("Actualizar Habitacion"));

        this.add(ETIQUETA_NUMERO_HABITACION);
        this.add(CAMPO_NUMERO_HABITACION);

        JPanel zocalo = new CuadroBotonesZocalo();
        JButton guardar = new JButton("Guardar");
        zocalo.add(guardar);

        this.add(ETIQUETA_NUMERO_HABITACION);
        this.add(ETIQUETA_TIPO_HABITACION);
        this.add(DISPONIBILIDAD);
        JButton actualizar = new JButton("Actualizar");
        zocalo.add(actualizar);
        zocalo.add(BOTON_VOLVER);
        this.add(zocalo);

    }

    @Override
    public void panelEliminar() {
        this.setBorder(new TitledBorder("Eliminar Habitacion"));

        this.add(ETIQUETA_NUMERO_HABITACION);
        this.add(CAMPO_NUMERO_HABITACION);

        JPanel zocalo = new CuadroBotonesZocalo();
        JButton buscar = new JButton("Buscar");
        zocalo.add(buscar);
        JButton eliminar = new JButton("Eliminar");
        zocalo.add(eliminar);
        zocalo.add(BOTON_VOLVER);
        this.add(zocalo);

    }

    private void limpiarCampos() {
        CAMPO_NUMERO_HABITACION.setText("");
        CAMPO_TIPO_HABITACION.setSelectedItem(null);
        DISPONIBILIDAD.setSelected(false);
    }

    public Habitacion obtenerNuevaHabitacion() {
        return new Habitacion(CAMPO_NUMERO_HABITACION.getText(), TipoDeHabitacion.valueOf(CAMPO_TIPO_HABITACION.getSelectedItem().toString()));
    }

    private JLabel crearEtiqueta(String texto) {
        return crearEtiqueta(texto, Component.LEFT_ALIGNMENT);
    }

    private JTextField crearCampoDeTexto() {
        return crearCampoDeTexto(LEFT_ALIGNMENT);
    }

}
