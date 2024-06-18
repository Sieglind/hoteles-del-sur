package org.example.menues.cuadros.tareas.impl;

import org.example.menues.cuadros.JPanelCustom;
import org.example.menues.cuadros.tareas.Renderizable;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.persona.Cliente;
import org.example.sistema.entidades.persona.Persona;
import org.example.sistema.enums.Segmento;
import org.example.sistema.excepciones.ObjectoNoEncontradoExcepcion;
import org.example.sistema.excepciones.ObjetoYaExisteExcepcion;
import org.example.sistema.gestor.impl.GestorClientes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TareasCliente extends JPanelCustom implements Renderizable<Cliente> {

    private JTextField dniField;
    private JTextField nombreField;
    private JTextField apellidoField;
    private JComboBox<Segmento> segmentoComboBox;
    private JTextArea resultadoArea;
    private String dni;
    private String nombre;
    private String apellido;
    private Segmento segmento;
    private Cliente cliente;
    private GestorClientes gestorClientes;


    public TareasCliente() {
        setLayout(new BorderLayout());
        initComponents();
    }

    private void initComponents() {
        JPanel formPanel = new JPanel(new GridLayout(5, 2));
        formPanel.setBorder(BorderFactory.createTitledBorder("Cliente"));
        formPanel.add(new JLabel("DNI:"));
        dniField = new JTextField(15);
        formPanel.add(dniField);

        formPanel.add(new JLabel("Nombre:"));
        nombreField = new JTextField(15);
        formPanel.add(nombreField);

        formPanel.add(new JLabel("Apellido:"));
        apellidoField = new JTextField(15);
        formPanel.add(apellidoField);

        formPanel.add(new JLabel("Segmento:"));
        segmentoComboBox = new JComboBox<>(Segmento.values());
        formPanel.add(segmentoComboBox);

        resultadoArea = new JTextArea(10, 30);
        resultadoArea.setEditable(false);
        add(formPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultadoArea), BorderLayout.SOUTH);

        JButton crearButton = new JButton("Añadir Cliente");
        JButton buscarButton = new JButton("Buscar");
        JButton actualizarButton = new JButton("Actualizar");
        JButton eliminarButton = new JButton("Eliminar");
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelCrear();
            }
        });
        formPanel.add(crearButton);
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelBuscar();
            }
        });
        formPanel.add(buscarButton);

        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelActualizar();
            }
        });
        formPanel.add(actualizarButton);

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelEliminar();
            }
        });
        formPanel.add(eliminarButton);
    }

    @Override
    public void panelCrear() {
        try {
            dni = dniField.getText();
            nombre = nombreField.getText();
            apellido = apellidoField.getText();
            segmento = (Segmento) segmentoComboBox.getSelectedItem();

            if (dni.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || segmento == null) {
                resultadoArea.setText("Todos los campos son obligatorios.");
            }
            cliente = new Cliente(dni, nombre, apellido, segmento);
            gestorClientes.crear(cliente);
            resultadoArea.setText("Cliente creado: " + cliente);
            limpiarCampos();
        } catch (ObjetoYaExisteExcepcion e) {
            resultadoArea.setText(e.getMessage());
        }
    }

    @Override
    public void panelBuscar() {
        try {
            dni = dniField.getText();
            if (dni.isEmpty()) {
                resultadoArea.setText("El campo DNI es obligatorio.");
            }
            cliente = gestorClientes.buscar(dni);

            nombreField.setText(cliente.getNombre());
            apellidoField.setText(cliente.getApellido());
            segmentoComboBox.setSelectedItem(cliente.getSegmento());

        } catch (ObjectoNoEncontradoExcepcion e) {
            resultadoArea.setText(e.getMessage());
        }

    }

    @Override
    public void panelListar() {
        ArrayList<Cliente> clientes = (ArrayList<Cliente>) gestorClientes.buscarTodos();
        if (clientes.isEmpty()) {
            resultadoArea.setText("No hay clientes registrados.");
        } else {

            String[] columnNames = {"DNI", "Nombre", "Apellido", "Segmento"};
            Object[][] data = new Object[clientes.size()][4]; //
            for (int i = 0; i < clientes.size(); i++) {
                cliente = clientes.get(i);
                data[i][0] = cliente.getDni();
                data[i][1] = cliente.getNombre();
                data[i][2] = cliente.getApellido();
                data[i][3] = cliente.getSegmento();
            }
            JTable table = new JTable(data, columnNames);

            JScrollPane scrollPane = new JScrollPane(table);
            table.setFillsViewportHeight(true);
            JPanel tablePanel = new JPanel(new BorderLayout());
            tablePanel.add(scrollPane, BorderLayout.CENTER);
        }

    }

    @Override
    public void panelActualizar() {
        try {
            dni = dniField.getText();
            nombre = nombreField.getText();
            apellido = apellidoField.getText();
            segmento = (Segmento) segmentoComboBox.getSelectedItem();
            if (dni.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || segmento == null) {
                resultadoArea.setText("Todos los campos son obligatorios.");
            }
            cliente = new Cliente(dni, nombre, apellido, segmento);
            gestorClientes.actualizar(dni, cliente);
            resultadoArea.setText("Cliente actualizado: " + cliente);
        }catch (ObjectoNoEncontradoExcepcion e){
            resultadoArea.setText(e.getMessage());
        }
    }

    @Override
    public void panelEliminar() {
        try {
            dni = dniField.getText();
            boolean eliminado = gestorClientes.eliminar(dni);
            if (eliminado) {
                resultadoArea.setText("Cliente con DNI " + dni + " eliminado.");
            }
        }catch (ObjectoNoEncontradoExcepcion e){
            resultadoArea.setText(e.getMessage());
        }
    }


    private void limpiarCampos() {
        dniField.setText("");
        nombreField.setText("");
        apellidoField.setText("");
        segmentoComboBox.setSelectedIndex(0);
    }
}