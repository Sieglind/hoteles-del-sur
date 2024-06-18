package org.example.menues.cuadros.tareas.impl;

import org.example.menues.cuadros.JPanelCustom;
import org.example.menues.cuadros.tareas.Renderizable;
import org.example.menues.enums.Tarea;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.persona.Cliente;
import org.example.sistema.enums.Segmento;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class TareasCliente extends JPanelCustom implements Renderizable<Cliente> {

    private final JLabel dni = new JLabel("Ingrese el DNI");
    private JTextField campoDni = new JTextField();
    private final JLabel nombre = new JLabel("Ingrese el nombre");
    private JTextField campoNombre = new JTextField();
    private final JLabel apellido = new JLabel("Ingrese el apellido");
    private JTextField campoApellido = new JTextField();
    private final JLabel segmento = new JLabel("Seleccione el segmento");
    private final JComboBox<Segmento> segmentoComboBox = new JComboBox<>(Segmento.values());
    private Tarea tarea;
    private final Dimension DIMENSION = new Dimension(300, 30);


    public TareasCliente(Tarea tarea) {
        super();
        this.tarea = tarea;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setVisible(true);
        elegirPanel(tarea);
    }

    private void elegirPanel(Tarea tarea) {
        switch (tarea) {
            case CREAR -> panelCrear();
            case ACTUALIZAR -> panelActualizar();
            case LISTAR -> panelListar();
            case BORRAR -> panelEliminar();
            case BUSCAR -> panelBuscar();
        }
    }

    @Override
    public void panelCrear() {
        this.setBorder(new TitledBorder("Crear Cliente"));
        limpiarCampos();
        this.add(dimensionarObjeto(dni));
        this.add(dimensionarObjeto(campoDni));
        this.add(dimensionarObjeto(nombre));
        this.add(dimensionarObjeto(campoNombre));
        this.add(dimensionarObjeto(apellido));
        this.add(dimensionarObjeto(campoApellido));
        this.add(dimensionarObjeto(segmento));
        this.add(dimensionarObjeto(segmentoComboBox));

        JPanel botones = new JPanel();
        botones.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton guardar = new JButton("Guardar");
        botones.add(guardar);
        JButton volver = new JButton("Volver");
        botones.add(volver);
        this.add(dimensionarObjeto(botones));
        botones.setVisible(true);
    }

    @Override
    public void panelBuscar() {
        this.setBorder(new TitledBorder("Buscar Cliente"));

        this.add(dimensionarObjeto(dni));
        this.add(dimensionarObjeto(campoDni));
        JPanel botones = new JPanel();
        botones.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton buscar = new JButton("Buscar");
        botones.add(buscar);
        JButton volver = new JButton("Volver");
        botones.add(volver);
        this.add(dimensionarObjeto(botones));
        botones.setVisible(true);
    }

    @Override
    public void panelListar() {
        this.setBorder(new TitledBorder("Listar Clientes"));


        String listadoClientes = Sistema.getInstance().listarClientes();

        JTextArea resultadoArea = new JTextArea(listadoClientes);
        resultadoArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(resultadoArea);
        scrollPane.setPreferredSize(DIMENSION);

        this.add(scrollPane);

        JPanel botones = new JPanel();
        JButton volver = new JButton("Volver");
        botones.add(volver);
        this.add(dimensionarObjeto(botones));
        botones.setVisible(true);
    }

    @Override
    public void panelActualizar() {
        this.setBorder(new TitledBorder("Actualizar Cliente"));

        this.add(dimensionarObjeto(dni));
        this.add(dimensionarObjeto(campoDni));

        JPanel botones = new JPanel();
        botones.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton buscar = new JButton("Buscar");
        botones.add(buscar);

      //  Sistema.getInstance().mostrarCliente(dni);

        this.add(dimensionarObjeto(nombre));
        this.add(dimensionarObjeto(campoNombre));
        this.add(dimensionarObjeto(apellido));
        this.add(dimensionarObjeto(campoApellido));
        this.add(dimensionarObjeto(segmento));
        this.add(dimensionarObjeto(segmentoComboBox));
        JButton actualizar = new JButton("Actualizar");
        botones.add(actualizar);
        JButton volver = new JButton("Volver");
        botones.add(volver);
        this.add(dimensionarObjeto(botones));
        botones.setVisible(true);
    }

    @Override
    public void panelEliminar() {
        this.setBorder(new TitledBorder("Eliminar Cliente"));
        this.add(dimensionarObjeto(dni));
        this.add(dimensionarObjeto(campoDni));
        JPanel botones = new JPanel();
        botones.setLayout(new FlowLayout(FlowLayout.CENTER));
        JButton buscar = new JButton("Buscar");
        botones.add(buscar);
        JButton eliminar = new JButton("Eliminar");
        botones.add(eliminar);
        JButton volver = new JButton("Volver");
        botones.add(volver);
        this.add(dimensionarObjeto(botones));
        botones.setVisible(true);
    }

    private JComponent dimensionarObjeto(JComponent component) {
        component.setMaximumSize(DIMENSION);
        component.setAlignmentX(Component.LEFT_ALIGNMENT);
        return component;
    }

    private void limpiarCampos() {
        campoDni.setText("");
        campoNombre.setText("");
        campoApellido.setText("");
        segmentoComboBox.setSelectedIndex(0);
    }

}
