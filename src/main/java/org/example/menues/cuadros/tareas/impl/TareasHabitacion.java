package org.example.menues.cuadros.tareas.impl;

import org.example.menues.cuadros.JPanelCustom;
import org.example.menues.cuadros.tareas.Renderizable;
import org.example.sistema.entidades.Habitacion;
import org.example.sistema.entidades.persona.Cliente;
import org.example.sistema.enums.TipoDeHabitacion;
import org.example.sistema.excepciones.ObjectoNoEncontradoExcepcion;
import org.example.sistema.excepciones.ObjetoYaExisteExcepcion;
import org.example.sistema.gestor.impl.GestorHabitaciones;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class TareasHabitacion extends JPanelCustom implements Renderizable<Cliente> {
    private JTextField numeroDehabitacion;
    private JComboBox<TipoDeHabitacion> tipoDehabitacion;
    private JTextField numeroDeCamas;
    private JCheckBox disponibilidad;
    private JTextArea resultadoArea;
    private String numeroHabitacion;
    private TipoDeHabitacion tipoHabitacion;
    private Integer numeroCamas;
    private boolean disponible;
    private Habitacion habitacion;
    private GestorHabitaciones gestorHabitaciones;

    public TareasHabitacion() {
        setLayout(new BorderLayout());
        initComponents();
        gestorHabitaciones = new GestorHabitaciones();
    }

    private void initComponents() {
        JPanel formPanel = new JPanel(new GridLayout(5, 2));
        formPanel.setBorder(BorderFactory.createTitledBorder("Habitacion"));

        formPanel.add(new JLabel("Numero de Habitacion:"));
        numeroDehabitacion = new JTextField(15);
        formPanel.add(numeroDehabitacion);

        formPanel.add(new JLabel("Tipo de Habitacion:"));
        tipoDehabitacion = new JComboBox<>(TipoDeHabitacion.values());
        formPanel.add(tipoDehabitacion);

        formPanel.add(new JLabel("Numero de Camas:"));
        numeroDeCamas = new JTextField(15);
        formPanel.add(numeroDeCamas);

        formPanel.add(new JLabel("Disponible:"));
        disponibilidad = new JCheckBox();
        formPanel.add(disponibilidad);


        resultadoArea = new JTextArea(10, 30);
        resultadoArea.setEditable(false);
        add(formPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultadoArea), BorderLayout.SOUTH);

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
        resultadoArea.setText("");

        try{
            numeroHabitacion = numeroDehabitacion.getText();
            tipoHabitacion= (TipoDeHabitacion) tipoDehabitacion.getSelectedItem();
            numeroCamas = Integer.parseInt(numeroDeCamas.getText());
            disponible = disponibilidad.isSelected();

            if(numeroHabitacion.isEmpty() || tipoHabitacion == null ){
                resultadoArea.setText("Todos los campos son obligatorios");
                return;
            }

            habitacion = new Habitacion(numeroHabitacion, tipoHabitacion,numeroDeCamas,disponible);
            gestorHabitaciones.crear(habitacion);
            resultadoArea.setText("Habitacion creada: " +habitacion);
            limpiarCampos();
        }catch (ObjetoYaExisteExcepcion e){
            resultadoArea.setText(e.getMessage());
        }
    }

    @Override
    public void panelBuscar() {
            try{
                numeroHabitacion = numeroDehabitacion.getText();
                if(numeroHabitacion.isEmpty()  ){
                    resultadoArea.setText("Todos los campos son obligatorios");
                }

                habitacion = gestorHabitaciones.buscar(numeroHabitacion);

                tipoDehabitacion.setSelectedItem(habitacion.getTipoDeHabitacion());
                numeroDeCamas.setText(String.valueOf(habitacion.getNumeroDeCamas()));
                disponibilidad.setSelected(habitacion.isDisponible());

            }catch (ObjectoNoEncontradoExcepcion e){
                resultadoArea.setText(e.getMessage());
            }


    }

    @Override
    public void panelListar() {
        resultadoArea.setText("");
        ArrayList<Habitacion> habitaciones = (ArrayList<Habitacion>) gestorHabitaciones.buscarTodos();

        if (habitaciones.isEmpty()) {
            resultadoArea.setText("No hay habitaciones registradas");
        } else {
            String[] columas = {"Número", "Tipo", "Número de Camas", "Disponible", "Segmento"};
            Object[][] data = new Object[habitaciones.size()][5];
            for (int i = 0; i < habitaciones.size(); i++) {
                habitacion = habitaciones.get(i);
                data[i][0] = habitacion.getNumeroDeHabitacion();
                data[i][1] = habitacion.getTipoDeHabitacion();
                data[i][2] = habitacion.getNumeroDeCamas();
                data[i][3] = habitacion.isDisponible();
            }
            JTable tabla = new JTable(data, columas);

            JScrollPane scrollPane = new JScrollPane(tabla);
            tabla.setFillsViewportHeight(true);
            JPanel tablaPanel = new JPanel(new BorderLayout());
            tablaPanel.add(scrollPane, BorderLayout.CENTER);

        }
    }
    @Override
    public void panelActualizar() {

        resultadoArea.setText("");

        try{
            numeroHabitacion = numeroDehabitacion.getText();
            tipoHabitacion= (TipoDeHabitacion) tipoDehabitacion.getSelectedItem();
            numeroCamas = Integer.parseInt(numeroDeCamas.getText());
            disponible = disponibilidad.isSelected();

            if(numeroHabitacion.isEmpty() || tipoHabitacion == null){
                resultadoArea.setText("Todos los campos son Obligatorios!");
                return;
            }

            habitacion = new Habitacion(numeroHabitacion,tipoHabitacion);
            gestorHabitaciones.actualizar(numeroHabitacion,habitacion);

        }catch (ObjectoNoEncontradoExcepcion e){
            resultadoArea.setText(e.getMessage());
        }
    }

    @Override
    public void panelEliminar() {
        resultadoArea.setText("");

        try{
            numeroHabitacion = numeroDehabitacion.getText();
            boolean eliminado = gestorHabitaciones.eliminar(numeroHabitacion);

            if(eliminado){
                resultadoArea.setText("Habitacion con numero" + numeroHabitacion + "eliminada");
                limpiarCampos();
            }

        }catch (ObjectoNoEncontradoExcepcion e){
            resultadoArea.setText(e.getMessage());
        }

    }

    private void limpiarCampos(){
        numeroDehabitacion.setText("");
        tipoDehabitacion.setSelectedItem(null);
        numeroDeCamas.setText("");
        disponibilidad.setSelected(false);
    }
}
