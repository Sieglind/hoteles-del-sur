package org.example.menues.cuadros.cuadroscaja.tareas.impl;

import org.example.menues.cuadros.JPanelCustom;
import org.example.menues.cuadros.cuadroscaja.CuadroBotonesZocalo;
import org.example.menues.cuadros.cuadroscaja.CuadroCajaCustom;
import org.example.menues.cuadros.cuadroscaja.tareas.Tareas;
import org.example.menues.enums.Tarea;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Habitacion;
import org.example.sistema.enums.TipoDeHabitacion;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.List;


public class TareasHabitacion extends CuadroCajaCustom implements Tareas {
    private final JLabel numeroDeHabitacion = new JLabel("Numero de habitacion: ");
    private JTextField campoNumeroHabitacion = new JTextField();
    private JLabel tipoDeHabitacion = new JLabel("Tipo de Habitacion: ");
    private JComboBox<TipoDeHabitacion> campoTipoDehabitacion = new JComboBox<>(TipoDeHabitacion.values());
    private JCheckBox disponibilidad;
    private JTextArea resultadoArea;
    private String numeroHabitacion;
    private TipoDeHabitacion tipoHabitacion;
    private boolean disponible;
    private Habitacion habitacion;
    private Tarea tarea;

    public TareasHabitacion(Tarea tarea) {
        super();
        this.tarea = tarea;
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
//        JPanel formPanel = new JPanel(new GridLayout(5, 2));
//        formPanel.setBorder(BorderFactory.createTitledBorder("Habitacion"));
//
//        formPanel.add(new JLabel("Numero de Habitacion:"));
//        campocampoNumeroDeHabitacion = new JTextField(15);
//        formPanel.add(campocampoNumeroDeHabitacion);
//
//        formPanel.add(new JLabel("Tipo de Habitacion:"));
//        tipoDehabitacion = new JComboBox<>(TipoDeHabitacion.values());
//        formPanel.add(tipoDehabitacion);
//
//
//        formPanel.add(new JLabel("Disponible:"));
//        disponibilidad = new JCheckBox();
//        formPanel.add(disponibilidad);
//
//
//        resultadoArea = new JTextArea(10, 30);
//        resultadoArea.setEditable(false);
//        add(formPanel, BorderLayout.NORTH);
//        add(new JScrollPane(resultadoArea), BorderLayout.SOUTH);

//        JButton saveButton = new JButton("Guardar");
//        saveButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                guardarHabitacion();
//            }
//        });
//
//        add(saveButton, BorderLayout.CENTER);
    }

    @Override
    public void panelCrear() {
        this.setBorder(new TitledBorder("Crear Habitación"));

        this.add(dimensionarObjeto(numeroDeHabitacion));
        this.add(dimensionarObjeto(campoNumeroHabitacion));
        this.add(dimensionarObjeto(tipoDeHabitacion));
        this.add(dimensionarObjeto(campoTipoDehabitacion));

        JPanel botones = new JPanel();
        botones.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton guardar = new JButton("Guardar");
        botones.add(guardar);
        JButton cancelar = new JButton("Cancelar");
        botones.add(cancelar);
        this.add(dimensionarObjeto(botones));
        botones.setVisible(true);

        guardar.addActionListener(e -> {
        });
    }

    private JComponent dimensionarObjeto(JComponent component) {
        component.setMaximumSize(DIMENSION);
        component.setAlignmentX(Component.LEFT_ALIGNMENT);
        return component;
    }

    @Override
    public void panelBuscar() {
        this.setBorder(new TitledBorder("Buscar Habitacion"));

        this.add(dimensionarObjeto(numeroDeHabitacion));
        this.add(dimensionarObjeto(campoNumeroHabitacion));

        JPanel botones = new JPanel();
        botones.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton buscar = new JButton("Buscar");
        botones.add(buscar);
        JButton cancelar = new JButton("Cancelar");
        botones.add(cancelar);
        this.add(dimensionarObjeto(botones));
        botones.setVisible(true);
    }

    @Override
    public void panelListar() {
        this.setBorder(new TitledBorder("Listar Habitaciones"));

        JPanel panelDeHabitaciones = new JPanel();
        List<Habitacion> habitaciones = Sistema.getInstance().listarHabitaciones();
        habitaciones.forEach(habitacion -> {
            JPanel panelDeHabitacion = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JLabel numeroHabitacion = new JLabel("Numero de habitacion: " + habitacion.getNumeroDeHabitacion());
            JLabel tipoDeHabitacion = new JLabel("Tipo de Habitacion: " + habitacion.getTipoDeHabitacion());
            panelDeHabitacion.add(numeroHabitacion);
            panelDeHabitacion.add(tipoDeHabitacion);
            panelDeHabitacion.setVisible(true);
            panelDeHabitaciones.add(panelDeHabitacion);
        });
        JScrollPane contenedorDeLista = new JScrollPane(panelDeHabitaciones);


        JPanel zocalo = new CuadroBotonesZocalo();
        JButton cancelar = new JButton("Cancelar");
        zocalo.add(cancelar);
    }

    @Override
    public void panelActualizar() {
        this.setBorder(new TitledBorder("Actualizar Habitacion"));

        this.add(dimensionarObjeto(numeroDeHabitacion));
        this.add(dimensionarObjeto(campoNumeroHabitacion));

        JPanel botones = new JPanel();
        botones.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton buscar = new JButton("Buscar");
        botones.add(buscar);

        this.add(dimensionarObjeto(numeroDeHabitacion));
        this.add(dimensionarObjeto(campoNumeroHabitacion));

        JButton actualizar = new JButton("Actualizar");
        botones.add(actualizar);
        this.add(dimensionarObjeto(botones));
        botones.setVisible(true);

        JButton cancelar = new JButton("Cancelar");
        botones.add(cancelar);
        this.add(dimensionarObjeto(botones));
        botones.setVisible(true);

    }

    @Override
    public void panelEliminar() {
        this.setBorder(new TitledBorder("Eliminar Habitacion"));

        this.add(dimensionarObjeto(numeroDeHabitacion));
        this.add(dimensionarObjeto(campoNumeroHabitacion));

        JPanel botones = new JPanel();
        botones.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton buscar = new JButton("Buscar");
        botones.add(buscar);

        this.add(dimensionarObjeto(numeroDeHabitacion));
        this.add(dimensionarObjeto(campoNumeroHabitacion));

        JButton eliminar = new JButton("Eliminar");
        botones.add(eliminar);
        this.add(dimensionarObjeto(botones));
        botones.setVisible(true);

        JButton cancelar = new JButton("Cancelar");
        botones.add(cancelar);
        this.add(dimensionarObjeto(botones));
        botones.setVisible(true);

    }

    private void limpiarCampos() {
        campoNumeroHabitacion.setText("");
        campoTipoDehabitacion.setSelectedItem(null);
        disponibilidad.setSelected(false);
    }

    public Habitacion obtenerNuevaHabitacion() {
        return new Habitacion(campoNumeroHabitacion.getText(), TipoDeHabitacion.valueOf(campoTipoDehabitacion.getSelectedItem().toString()));
    }

}
