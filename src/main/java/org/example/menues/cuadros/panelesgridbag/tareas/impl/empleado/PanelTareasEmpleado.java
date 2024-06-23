package org.example.menues.cuadros.panelesgridbag.tareas.impl.empleado;

import org.example.menues.acciones.empleado.*;
import org.example.menues.cuadros.panelesgridbag.tareas.ITareas;
import org.example.menues.cuadros.panelesgridbag.tareas.impl.PanelTareas;
import org.example.menues.enums.Entidad;
import org.example.menues.enums.Tarea;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.persona.Empleado;

import javax.swing.*;
import java.util.List;
import java.util.Vector;

public class PanelTareasEmpleado extends PanelTareas implements ITareas {

    private PanelEmpleado panelEmpleado;


    public PanelTareasEmpleado(Tarea tarea) {
        super(Entidad.EMPLEADOS);
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
        panelDeEntradas = crearPanelDeEntradas(false,ETIQUEDA_DNI);
        panelEmpleado = crearPanelEmpleado(true);
        panelBotones = crearPanelBotones(Tarea.CREAR);
        panelBotones.getBotonGuardar().addActionListener(new AccionCrearNuevoEmpleado(panelEmpleado));
    }

    @Override
    public void panelBuscar() {
        this.setBorder(BorderFactory.createTitledBorder("Buscar Empleado"));
        panelDeEntradas = crearPanelDeEntradas(true,ETIQUEDA_DNI);
        panelEmpleado = crearPanelEmpleado(false);
        panelBotones = crearPanelBotones(Tarea.BUSCAR);
        panelBotones.getBotonBuscar().addActionListener(new AccionBuscarEmpleado(this, panelDeEntradas, panelEmpleado));
    }

    @Override
    public void panelListar() {
        this.setBorder(BorderFactory.createTitledBorder("Listar Empleados"));
        List<Empleado> empleados = Sistema.getInstance().listarEmpleados();
        JList<Empleado> listaEmpleados = new JList<>(new Vector<>(empleados));
        this.add(new JScrollPane(listaEmpleados));
        panelBotones = crearPanelBotones(Tarea.LISTAR);
    }

    @Override
    public void panelActualizar() {
        this.setBorder(BorderFactory.createTitledBorder("Actualizar Empleado"));
        panelDeEntradas = crearPanelDeEntradas(true,ETIQUEDA_DNI);
        panelEmpleado = crearPanelEmpleado(false);
        panelBotones = crearPanelBotones(Tarea.ACTUALIZAR);
        panelBotones.getBotonBuscar().addActionListener(new AccionBuscarParaActualizarEmpelado(panelDeEntradas, panelEmpleado, panelBotones));
        panelBotones.getBotonActualizar().addActionListener(new AccionActualizarEmpleado(panelEmpleado));
    }

    @Override
    public void panelBorrar() {
        this.setBorder(BorderFactory.createTitledBorder("Borrar Empleado"));
        panelDeEntradas = crearPanelDeEntradas(true,ETIQUEDA_DNI);
        panelBotones = crearPanelBotones(Tarea.BORRAR);
        panelBotones.getBotonBorrar().addActionListener(new AccionBorrarEmpleado(panelDeEntradas));
    }

    private PanelEmpleado crearPanelEmpleado(boolean editable) {
        PanelEmpleado panelEmpleado = new PanelEmpleado(editable);
        return crearPanelEmpleado(panelEmpleado);
    }

    private PanelEmpleado crearPanelEmpleado(PanelEmpleado panelEmpleado) {
        this.add(panelEmpleado, crearConfiguracion(0.8, 1));
        return panelEmpleado;
    }
}

