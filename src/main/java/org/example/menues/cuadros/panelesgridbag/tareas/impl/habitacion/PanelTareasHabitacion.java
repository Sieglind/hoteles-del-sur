package org.example.menues.cuadros.panelesgridbag.tareas.impl.habitacion;

import org.example.menues.acciones.habitacion.*;
import org.example.menues.cuadros.panelesgridbag.tareas.ITareas;
import org.example.menues.cuadros.panelesgridbag.tareas.impl.PanelTareas;
import org.example.menues.enums.Entidad;
import org.example.menues.enums.Tarea;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Habitacion;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.util.List;
import java.util.Vector;


public class PanelTareasHabitacion extends PanelTareas implements ITareas {

    private static final String ETIQUETA_NRO_HABITACION = "Nro Habitacion";
    
    private PanelHabitacion panelHabitacion;
    
    public PanelTareasHabitacion(Tarea tarea) {
        super(Entidad.HABITACIONES);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setVisible(true);
        seleccionarPanel(tarea);
    }

    private void seleccionarPanel(Tarea tarea) {
        switch (tarea) {
            case CREAR -> panelCrear();
            case BUSCAR -> panelBuscar();
            case LISTAR -> panelListar();
            case ACTUALIZAR -> panelActualizar();
            case BORRAR -> panelBorrar();
        }
    }

    @Override
    public void panelCrear() {
        panelDeEntradas = crearPanelDeEntradas(false,ETIQUETA_NRO_HABITACION);
        panelHabitacion = crearPanelHabitacion(true);
        panelBotones = crearPanelBotones(Tarea.CREAR);
        panelBotones.getBotonGuardar().addActionListener(new AccionCrearHabitacion(this,panelDeEntradas,panelHabitacion) );
    }


    @Override
    public void panelBuscar() {
        this.setBorder(new TitledBorder("Buscar Habitacion"));
        panelDeEntradas = crearPanelDeEntradas(true,ETIQUETA_NRO_HABITACION);
        panelHabitacion = crearPanelHabitacion(false);
        panelBotones = crearPanelBotones(Tarea.BUSCAR);
        panelBotones.getBotonBuscar().addActionListener(new AccionBuscarHabitacion(panelDeEntradas,panelHabitacion));
    }

    @Override
    public void panelListar() {
        this.setBorder(new TitledBorder("Listar Habitaciones"));
        List<Habitacion> habitaciones = Sistema.getInstance().listarHabitaciones();
        JList<Habitacion> listaHabitaciones = new JList<>(new Vector<>(habitaciones));
        this.add(new JScrollPane(listaHabitaciones));
        panelBotones = crearPanelBotones(Tarea.LISTAR);
    }

    @Override
    public void panelActualizar() {
        this.setBorder(new TitledBorder("Actualizar Habitacion"));
        panelDeEntradas = crearPanelDeEntradas(true,ETIQUETA_NRO_HABITACION);
        panelHabitacion = crearPanelHabitacion(false);
        panelBotones = crearPanelBotones(Tarea.ACTUALIZAR);
        panelBotones.getBotonBuscar().addActionListener(new AccionBuscarParaActualizarHabitacion(panelDeEntradas,panelHabitacion,panelBotones));
        panelBotones.getBotonActualizar().addActionListener(new AccionActualizarHabitacion(panelHabitacion));
    }

    @Override
    public void panelBorrar() {
        this.setBorder(new TitledBorder("Borrar Habitacion"));

        panelDeEntradas = crearPanelDeEntradas(true,ETIQUETA_NRO_HABITACION);
        panelBotones = crearPanelBotones(Tarea.BORRAR);
        panelBotones.getBotonBorrar().addActionListener(new AccionBorrarHabitacion(panelDeEntradas));
    }

   private PanelHabitacion crearPanelHabitacion(boolean editable){
        PanelHabitacion panelHabitacion = new PanelHabitacion(editable);
        return crearPanelHabitacion(panelHabitacion);
   }

   private PanelHabitacion crearPanelHabitacion(PanelHabitacion panelHabitacion){
        this.add(panelHabitacion,crearConfiguracion(0.8,1));
        return panelHabitacion;
   }
}
