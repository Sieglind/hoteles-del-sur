package org.example.menues.paneles.panelesgridbag.tareas.impl.habitacion;

import org.example.menues.acciones.habitacion.*;
import org.example.menues.enums.Entidad;
import org.example.menues.enums.Tarea;
import org.example.menues.modelosdetabla.ModeloTablaHabitaciones;
import org.example.menues.paneles.panelesgridbag.tareas.impl.PanelTareasAbstracto;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Habitacion;

import javax.swing.*;
import java.util.List;


public class PanelTareasHabitacion extends PanelTareasAbstracto {

    private static final String ETIQUETA_NRO_HABITACION = "Nro Habitacion";

    private PanelHabitacion panelHabitacion;

    public PanelTareasHabitacion(Tarea tarea) {
        super(tarea, Entidad.HABITACIONES);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setVisible(true);
        elegirPanel(tarea);
    }

    @Override
    public void panelCrear() {
        panelDeEntradas = crearPanelDeEntradas(false, ETIQUETA_NRO_HABITACION);
        panelHabitacion = crearPanelHabitacion(true);
        panelBotones = crearPanelBotones(Tarea.CREAR);
        panelBotones.getBotonGuardar().addActionListener(new AccionCrearHabitacion(panelDeEntradas, panelHabitacion));
    }

    @Override
    public void panelBuscar() {
        panelDeEntradas = crearPanelDeEntradas(true, ETIQUETA_NRO_HABITACION);
        panelHabitacion = crearPanelHabitacion(false);
        panelBotones = crearPanelBotones(Tarea.BUSCAR);
        panelBotones.getBotonBuscar().addActionListener(new AccionBuscarHabitacion(panelDeEntradas, panelHabitacion));
    }

    @Override
    public void panelListar() {
        List<Habitacion> habitaciones = Sistema.getInstance().listarHabitaciones();
        ModeloTablaHabitaciones modelo = new ModeloTablaHabitaciones(habitaciones);
        JTable tabla = new JTable(modelo);
        this.add(new JScrollPane(tabla));
        panelBotones = crearPanelBotones(Tarea.LISTAR);
    }

    @Override
    public void panelActualizar() {
        panelDeEntradas = crearPanelDeEntradas(true, ETIQUETA_NRO_HABITACION);
        panelHabitacion = crearPanelHabitacion(false);
        panelBotones = crearPanelBotones(Tarea.ACTUALIZAR);
        panelBotones.getBotonBuscar().addActionListener(new AccionBuscarParaActualizarHabitacion(panelDeEntradas, panelHabitacion, panelBotones));
        panelBotones.getBotonActualizar().addActionListener(new AccionActualizarHabitacion(panelHabitacion));
    }

    @Override
    public void panelBorrar() {
        panelDeEntradas = crearPanelDeEntradas(true, ETIQUETA_NRO_HABITACION);
        panelBotones = crearPanelBotones(Tarea.BORRAR);
        panelBotones.getBotonBorrar().addActionListener(new AccionBorrarHabitacion(panelDeEntradas));
    }

    private PanelHabitacion crearPanelHabitacion(boolean editable) {
        PanelHabitacion panelHabitacion = new PanelHabitacion(editable);
        return crearPanelHabitacion(panelHabitacion);
    }

    private PanelHabitacion crearPanelHabitacion(PanelHabitacion panelHabitacion) {
        this.add(panelHabitacion, crearConfiguracion(0.8, 1));
        return panelHabitacion;
    }
}
