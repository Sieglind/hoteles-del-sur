package org.example.menues.cuadros.cuadroscaja.tareas.impl;
import org.example.menues.acciones.AccionVolver;
import org.example.menues.acciones.empleado.AccionBuscarEmpleado;
import org.example.menues.acciones.empleado.AccionCrearNuevoEmpleado;
import org.example.menues.cuadros.cuadroscaja.*;
import org.example.menues.cuadros.cuadroscaja.tareas.ITareas;
import org.example.menues.enums.Entidad;
import org.example.menues.enums.Tarea;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.persona.Empleado;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Vector;

public class TareasEmpleado extends CuadroCajaCustom implements ITareas {

    private final JButton BOTON_VOLVER = crearBoton("Volver", LEFT_ALIGNMENT, new AccionVolver(Entidad.EMPLEADOS.name()));

    private PanelDeEntradas panelDeEntradas;
    private PanelEmpleado panelEmpleado;
    private PanelBotones panelBotones;


    public TareasEmpleado(Tarea tarea) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setVisible(true);
        elegirPanel(tarea);
    }

    private void elegirPanel(Tarea tarea) {
        switch (tarea) {
            case CREAR -> panelCrear();
            case ACTUALIZAR -> panelActualizar();
            case LISTAR -> panelListar();
            case BORRAR -> panelBorrar();
            case BUSCAR -> panelBuscar();
        }
    }

    @Override
    public void panelCrear() {
        this.setBorder(BorderFactory.createTitledBorder("Crear Empleado"));
        this.panelDeEntradas = crearPanelDeEntradas(false);
        this.panelEmpleado = crearPanelEmpleado(true);
        this.panelBotones = crearPanelBotones(Tarea.CREAR);
        this.panelBotones.getBotonGuardar().addActionListener(new AccionCrearNuevoEmpleado(this, panelEmpleado));
    }

    @Override
    public void panelBuscar() {
        this.setBorder(BorderFactory.createTitledBorder("Buscar Empleado"));
        this.panelDeEntradas = crearPanelDeEntradas(true);
        this.panelEmpleado = crearPanelEmpleado(false);
        this.panelBotones = crearPanelBotones(Tarea.BUSCAR);
        panelBotones.getBotonoBuscar().addActionListener(new AccionBuscarEmpleado(this,panelDeEntradas,panelEmpleado));
    }

    @Override
    public void panelListar() {
        this.setBorder(BorderFactory.createTitledBorder("Listar Empleados"));
        List<Empleado> empleados = Sistema.getInstance().listarEmpleados();
        JList<Empleado> listaEmpleados = new JList<>(new Vector<>(empleados));
        this.add(new JScrollPane(listaEmpleados));
        this.panelBotones = crearPanelBotones(Tarea.LISTAR);
    }

    @Override
    public void panelActualizar() {
        this.setBorder(BorderFactory.createTitledBorder("Actualizar Empleado"));
        this.panelDeEntradas = crearPanelDeEntradas(true);
        this.panelBotones= crearPanelBotones(Tarea.ACTUALIZAR);
    }

    @Override
    public void panelBorrar() {
        this.setBorder(BorderFactory.createTitledBorder("Eliminar Empleado"));

        this.panelDeEntradas = crearPanelDeEntradas(true);
        this.panelBotones = crearPanelBotones(Tarea.BORRAR);
    }

    private PanelDeEntradas crearPanelDeEntradas(boolean completo) {
        PanelDeEntradas panelDeEntradas = new PanelDeEntradas(completo);
        this.add(panelDeEntradas, crearConfiguracion(0.1, 0));
        return panelDeEntradas;
    }

    private PanelEmpleado crearPanelEmpleado(boolean editable) {
        PanelEmpleado panelEmpleado = new PanelEmpleado(editable);
        return crearPanelEmpleado(panelEmpleado);
    }

    private PanelEmpleado crearPanelEmpleado(PanelEmpleado panelEmpleado){
        this.add(panelEmpleado, crearConfiguracion(0.8, 1));
        return panelEmpleado;
    }

    private PanelBotones crearPanelBotones(Tarea tarea) {
        PanelBotones panelBotones = new PanelBotones(tarea, BOTON_VOLVER);
        this.add(panelBotones, crearConfiguracion(0.1, 2));
        return panelBotones;
    }

    private GridBagConstraints crearConfiguracion(double weighty, int posicion) {
        GridBagConstraints configuracion = new GridBagConstraints();
        configuracion.weightx = 1.0;
        configuracion.weighty = weighty;
        configuracion.gridx = posicion;
        configuracion.insets = new Insets(30, 30, 30, 30);
        configuracion.fill = GridBagConstraints.BOTH;
        return configuracion;
    }
}

