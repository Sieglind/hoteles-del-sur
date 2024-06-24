package org.example.menues.paneles.panelesgridbag.tareas.impl.empleado;

import org.example.menues.acciones.empleado.*;
import org.example.menues.enums.Entidad;
import org.example.menues.enums.Tarea;
import org.example.menues.paneles.panelesgridbag.tareas.impl.PanelTareasAbstracto;
import org.example.menues.modelosdetabla.ModeloTablaEmpleados;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.persona.Empleado;

import javax.swing.*;
import java.util.List;

public class PanelTareasEmpleado extends PanelTareasAbstracto {

    private PanelEmpleado panelEmpleado;

    public PanelTareasEmpleado(Tarea tarea) {
        super(tarea, Entidad.EMPLEADOS);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setVisible(true);
        elegirPanel(tarea);
    }

    @Override
    public void panelCrear() {
        panelDeEntradas = crearPanelDeEntradas(false, ETIQUEDA_DNI);
        panelEmpleado = crearPanelEmpleado(true);
        panelBotones = crearPanelBotones(Tarea.CREAR);
        panelBotones.getBotonGuardar().addActionListener(new AccionCrearNuevoEmpleado(panelEmpleado));
    }

    @Override
    public void panelBuscar() {
        panelDeEntradas = crearPanelDeEntradas(true, ETIQUEDA_DNI);
        panelEmpleado = crearPanelEmpleado(false);
        panelBotones = crearPanelBotones(Tarea.BUSCAR);
        panelBotones.getBotonBuscar().addActionListener(new AccionBuscarEmpleado(panelDeEntradas, panelEmpleado));
    }

    @Override
    public void panelListar() {
        List<Empleado> empleados = Sistema.getInstance().listarEmpleados();
        ModeloTablaEmpleados modelo = new ModeloTablaEmpleados(empleados);
        JTable tabla = new JTable(modelo);
        this.add(new JScrollPane(tabla));
        panelBotones = crearPanelBotones(Tarea.LISTAR);
    }

    @Override
    public void panelActualizar() {
        panelDeEntradas = crearPanelDeEntradas(true, ETIQUEDA_DNI);
        panelEmpleado = crearPanelEmpleado(false);
        panelBotones = crearPanelBotones(Tarea.ACTUALIZAR);
        panelBotones.getBotonBuscar().addActionListener(new AccionBuscarParaActualizarEmpelado(panelDeEntradas, panelEmpleado, panelBotones));
        panelBotones.getBotonActualizar().addActionListener(new AccionActualizarEmpleado(panelEmpleado));
    }

    @Override
    public void panelBorrar() {
        panelDeEntradas = crearPanelDeEntradas(true, ETIQUEDA_DNI);
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

