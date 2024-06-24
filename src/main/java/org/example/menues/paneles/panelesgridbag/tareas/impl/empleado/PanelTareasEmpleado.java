package org.example.menues.paneles.panelesgridbag.tareas.impl.empleado;

import org.example.menues.acciones.empleado.*;
import org.example.menues.paneles.panelesgridbag.tareas.impl.PanelTareas;
import org.example.menues.enums.Entidad;
import org.example.menues.enums.Tarea;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.persona.Empleado;

import javax.swing.*;
import java.util.List;
import java.util.Vector;

public class PanelTareasEmpleado extends PanelTareas {

    private PanelEmpleado panelEmpleado;

    public PanelTareasEmpleado(Tarea tarea) {
        super(tarea, Entidad.EMPLEADOS);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setVisible(true);
        elegirPanel(tarea);
    }

    @Override
    public void panelCrear() {
        panelDeEntradas = crearPanelDeEntradas(false,ETIQUEDA_DNI);
        panelEmpleado = crearPanelEmpleado(true);
        panelBotones = crearPanelBotones(Tarea.CREAR);
        panelBotones.getBotonGuardar().addActionListener(new AccionCrearNuevoEmpleado(panelEmpleado));
    }

    @Override
    public void panelBuscar() {
        panelDeEntradas = crearPanelDeEntradas(true,ETIQUEDA_DNI);
        panelEmpleado = crearPanelEmpleado(false);
        panelBotones = crearPanelBotones(Tarea.BUSCAR);
        panelBotones.getBotonBuscar().addActionListener(new AccionBuscarEmpleado(this, panelDeEntradas, panelEmpleado));
    }

    @Override
    public void panelListar() {
        List<Empleado> empleados = Sistema.getInstance().listarEmpleados();
        JList<Empleado> listaEmpleados = new JList<>(new Vector<>(empleados));
        this.add(new JScrollPane(listaEmpleados));
        panelBotones = crearPanelBotones(Tarea.LISTAR);
    }

    @Override
    public void panelActualizar() {
        panelDeEntradas = crearPanelDeEntradas(true,ETIQUEDA_DNI);
        panelEmpleado = crearPanelEmpleado(false);
        panelBotones = crearPanelBotones(Tarea.ACTUALIZAR);
        panelBotones.getBotonBuscar().addActionListener(new AccionBuscarParaActualizarEmpelado(panelDeEntradas, panelEmpleado, panelBotones));
        panelBotones.getBotonActualizar().addActionListener(new AccionActualizarEmpleado(panelEmpleado));
    }

    @Override
    public void panelBorrar() {
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

