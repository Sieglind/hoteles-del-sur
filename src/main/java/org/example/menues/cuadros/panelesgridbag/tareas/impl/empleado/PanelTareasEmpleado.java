package org.example.menues.cuadros.panelesgridbag.tareas.impl.empleado;
import org.example.menues.acciones.AccionVolver;
import org.example.menues.acciones.empleado.*;
import org.example.menues.cuadros.panelesgridbag.*;
import org.example.menues.cuadros.panelesgridbag.tareas.ITareas;
import org.example.menues.enums.Entidad;
import org.example.menues.enums.Tarea;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.persona.Empleado;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Vector;

public class PanelTareasEmpleado extends PanelCustom implements ITareas {

    private final JButton BOTON_VOLVER = crearBoton("Volver", LEFT_ALIGNMENT, new AccionVolver(Entidad.EMPLEADOS.name()));

    private PanelDeEntradas panelDeEntradas;
    private PanelEmpleado panelEmpleado;
    private PanelBotones panelBotones;


    public PanelTareasEmpleado(Tarea tarea) {
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
        this.panelBotones.getBotonGuardar().addActionListener(new AccionCrearNuevoEmpleado(panelEmpleado));
    }

    @Override
    public void panelBuscar() {
        this.setBorder(BorderFactory.createTitledBorder("Buscar Empleado"));
        this.panelDeEntradas = crearPanelDeEntradas(true);
        this.panelEmpleado = crearPanelEmpleado(false);
        this.panelBotones = crearPanelBotones(Tarea.BUSCAR);
        panelBotones.getBotonBuscar().addActionListener(new AccionBuscarEmpleado(this,panelDeEntradas,panelEmpleado));
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
        panelDeEntradas = crearPanelDeEntradas(true);
        panelEmpleado = crearPanelEmpleado(false);
        panelBotones= crearPanelBotones(Tarea.ACTUALIZAR);
        panelBotones.getBotonBuscar().addActionListener(new AccionBuscarParaActualizar(panelDeEntradas, panelEmpleado, panelBotones));
        panelBotones.getBotonActualizar().addActionListener(new AccionActualizarEmpleado(panelEmpleado));
    }

    @Override
    public void panelBorrar() {
        this.setBorder(BorderFactory.createTitledBorder("Eliminar Empleado"));
        this.panelDeEntradas = crearPanelDeEntradas(true);
        this.panelBotones = crearPanelBotones(Tarea.BORRAR);
        panelBotones.getBotonBorrar().addActionListener(new AccionEliminarEmpleado(panelDeEntradas));
    }

    private PanelDeEntradas crearPanelDeEntradas(boolean completo) {
        PanelDeEntradas panelDeEntradas = new PanelDeEntradas(completo,"DNI");
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
