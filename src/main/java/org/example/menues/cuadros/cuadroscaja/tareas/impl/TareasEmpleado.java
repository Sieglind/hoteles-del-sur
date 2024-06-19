package org.example.menues.cuadros.cuadroscaja.tareas.impl;

import org.example.menues.acciones.AccionVolver;
import org.example.menues.cuadros.cuadroscaja.CuadroBotonesZocalo;
import org.example.menues.cuadros.cuadroscaja.CuadroCajaCustom;
import org.example.menues.cuadros.cuadroscaja.tareas.Tareas;
import org.example.menues.enums.Entidad;
import org.example.menues.enums.Tarea;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.persona.Empleado;
import org.example.sistema.enums.Cargo;


import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;


public class TareasEmpleado extends CuadroCajaCustom implements Tareas {

    private final JLabel ETIQUETA_DNI = crearEtiqueta("DNI:");
    private final JTextField CAMPO_DNI = crearCampoDeTexto();
    private final JLabel EIQUETA_NOMBRE = crearEtiqueta("Ingrese el Nombre:");
    private final JTextField CAMPO_NOMBRE = crearCampoDeTexto();
    private final JLabel ETIQUETA_APELLIDO = crearEtiqueta("Ingrese el Apellido:");
    private final JTextField CAMPO_APELLIDO = crearCampoDeTexto();
    private final JLabel ETIQUETA_CARGO = crearEtiqueta("Ingrese el Cargo:");
    private final JComboBox<Cargo> LISTA_CARGO = new JComboBox<>(Cargo.values());
    private final JButton BOTON_VOLVER = crearBoton("Volver",LEFT_ALIGNMENT,new AccionVolver(Entidad.EMPLEADOS.name()));


    public TareasEmpleado(Tarea tarea) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setVisible(true);
        dimensionarCompomente(LISTA_CARGO,LEFT_ALIGNMENT);
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
        this.setBorder(BorderFactory.createTitledBorder("Crear Empleado"));
        limpiarCampos();
        this.add(ETIQUETA_DNI);
        this.add(CAMPO_DNI);
        this.add(EIQUETA_NOMBRE);
        this.add(CAMPO_NOMBRE);
        this.add(ETIQUETA_APELLIDO);
        this.add(CAMPO_APELLIDO);
        this.add(ETIQUETA_CARGO);
        this.add(LISTA_CARGO);

        JPanel zocalo = new CuadroBotonesZocalo();
        JButton guardar = new JButton("Guardar");
        zocalo.add(guardar);
        zocalo.add(BOTON_VOLVER);
        this.add(zocalo);
    }

    @Override
    public void panelBuscar() {
        this.setBorder(BorderFactory.createTitledBorder("Buscar Empleado"));
        this.add(ETIQUETA_DNI);
        this.add(CAMPO_DNI);

        JPanel zocalo = new CuadroBotonesZocalo();
        JButton buscar = new JButton("Buscar");
        zocalo.add(buscar);
        zocalo.add(BOTON_VOLVER);
        this.add(zocalo);
    }

    @Override
    public void panelListar() {
        this.setBorder(BorderFactory.createTitledBorder("Listar Empleados"));
        List<Empleado> habitaciones = Sistema.getInstance().listarEmpleados();

        JPanel panelEmpleados = new JPanel();
        panelEmpleados.setLayout(new BoxLayout(panelEmpleados, BoxLayout.Y_AXIS));
        habitaciones.forEach(empleado -> {
            JPanel panelEmpleado = new JPanel();
            panelEmpleado.setBorder(new LineBorder(Color.BLACK,1));
            JLabel dNI = new JLabel("DNI: " + empleado.getDni());
            JLabel nombreYApellido = new JLabel("Nombre y Apellido: " + empleado.getNombre() + " " + empleado.getApellido());
            JLabel cargo = new JLabel("Cargo: " + empleado.getCargo());
            panelEmpleado.add(dNI);
            panelEmpleado.add(nombreYApellido);
            panelEmpleado.add(cargo);
            panelEmpleado.setVisible(true);
            dimensionarCompomente(panelEmpleados,LEFT_ALIGNMENT);
            panelEmpleados.add(panelEmpleado);
        });

        JScrollPane contenedorDeLista = new JScrollPane(panelEmpleados);
        this.add(contenedorDeLista);

        JPanel zocalo = new CuadroBotonesZocalo();
        zocalo.add(BOTON_VOLVER);
        this.add(zocalo);
    }

    @Override
    public void panelActualizar() {
        this.setBorder(BorderFactory.createTitledBorder("Actualizar Empleado"));
        this.add(ETIQUETA_DNI);
        this.add(CAMPO_DNI);

        JPanel zocalo = new CuadroBotonesZocalo();
        JButton buscar = new JButton("Buscar");
        zocalo.add(buscar);

        //  Sistema.getInstance().mostrarEmpleado(ETIQUETA_DNI);

        this.add(EIQUETA_NOMBRE);
        this.add(CAMPO_NOMBRE);
        this.add(ETIQUETA_APELLIDO);
        this.add(CAMPO_APELLIDO);
        this.add(ETIQUETA_CARGO);
        this.add(LISTA_CARGO);
        JButton actualizar = new JButton("Actualizar");
        zocalo.add(actualizar);
        zocalo.add(BOTON_VOLVER);
        this.add(zocalo);
    }

    @Override
    public void panelEliminar() {
        this.setBorder(BorderFactory.createTitledBorder("Eliminar Empleado"));
        this.add(ETIQUETA_DNI);
        this.add(CAMPO_DNI);

        JPanel zocalo = new CuadroBotonesZocalo();
        JButton buscar = new JButton("Buscar");
        zocalo.add(buscar);
        JButton eliminar = new JButton("Eliminar");
        zocalo.add(eliminar);
        zocalo.add(BOTON_VOLVER);
        this.add(zocalo);
    }

    private void limpiarCampos() {
        CAMPO_DNI.setText("");
        CAMPO_NOMBRE.setText("");
        CAMPO_APELLIDO.setText("");
        LISTA_CARGO.setSelectedIndex(0);
    }

    private JLabel crearEtiqueta(String texto){
        return crearEtiqueta(texto,Component.LEFT_ALIGNMENT);
    }

    private JTextField crearCampoDeTexto(){
        return crearCampoDeTexto(LEFT_ALIGNMENT);
    }
}
