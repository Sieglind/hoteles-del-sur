package org.example.menues.cuadros.panelesgridbag.tareas.impl.habitacion;

import org.example.menues.acciones.habitacion.AccionBuscarHabitacion;
import org.example.menues.acciones.AccionVolver;
import org.example.menues.acciones.habitacion.AccionBuscarParaActualizarHabitacion;
import org.example.menues.acciones.habitacion.AccionCrearHabitacion;
import org.example.menues.acciones.habitacion.AccionBorrarHabitacion;
import org.example.menues.cuadros.panelesgridbag.*;
import org.example.menues.cuadros.panelesgridbag.PanelDeEntradas;
import org.example.menues.cuadros.panelesgridbag.tareas.ITareas;
import org.example.menues.enums.Entidad;
import org.example.menues.enums.Tarea;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Habitacion;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.List;
import java.util.Vector;


public class PanelTareasHabitacion extends PanelCustom implements ITareas {

    private final JButton BOTON_VOLVER = crearBoton("Volver", LEFT_ALIGNMENT, new AccionVolver(Entidad.HABITACIONES.name()));

    private PanelDeEntradas panelDeEntradas;
    private PanelHabitacion panelHabitacion;
    private PanelBotones panelBotones;

    public PanelTareasHabitacion(Tarea tarea) {
        super();
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
        this.panelDeEntradas = crearPanelDeEntradas(false);
        this.panelHabitacion = crearPanelHabitacion(true);
        this.panelBotones = crearPanelBotones(Tarea.CREAR);
        panelBotones.getBotonGuardar().addActionListener(new AccionCrearHabitacion(this,panelDeEntradas,panelHabitacion) );
    }


    @Override
    public void panelBuscar() {
        this.setBorder(new TitledBorder("Buscar Habitacion"));
        this.panelDeEntradas = crearPanelDeEntradas(true);
        this.panelHabitacion = crearPanelHabitacion(false);
        this.panelBotones = crearPanelBotones(Tarea.BUSCAR);
        panelBotones.getBotonBuscar().addActionListener(new AccionBuscarHabitacion(panelDeEntradas,panelHabitacion));
    }

    @Override
    public void panelListar() {
        this.setBorder(new TitledBorder("Listar Habitaciones"));
        List<Habitacion> habitaciones = Sistema.getInstance().listarHabitaciones();
        JList<Habitacion> listaHabitaciones = new JList<>(new Vector<>(habitaciones));
        this.add(new JScrollPane(listaHabitaciones));
        this.panelBotones = crearPanelBotones(Tarea.LISTAR);
    }

    @Override
    public void panelActualizar() {
        this.setBorder(new TitledBorder("Actualizar Habitacion"));
        panelDeEntradas = crearPanelDeEntradas(true);
        panelHabitacion = crearPanelHabitacion(false);
        panelBotones = crearPanelBotones(Tarea.ACTUALIZAR);
        panelBotones.getBotonBuscar().addActionListener(new AccionBuscarParaActualizarHabitacion(panelDeEntradas,panelHabitacion,panelBotones));
        panelBotones.getBotonActualizar().addActionListener(new AccionActualizarHabitacion(panelHabitacion));
    }

    @Override
    public void panelBorrar() {
        this.setBorder(new TitledBorder("Borrar Habitacion"));

        this.panelDeEntradas = crearPanelDeEntradas(true);
        this.panelBotones = crearPanelBotones(Tarea.BORRAR);
        panelBotones.getBotonBorrar().addActionListener(new AccionBorrarHabitacion(panelDeEntradas));
    }

   private PanelDeEntradas crearPanelDeEntradas(boolean visible){
        PanelDeEntradas panelDeEntrada = new PanelDeEntradas(visible,"Nro. de Habitacion");
        this.add(panelDeEntrada,crearConfiguracion(0.1,0));
        return panelDeEntrada;
   }

   private PanelHabitacion crearPanelHabitacion(boolean editable){
        PanelHabitacion panelHabitacion = new PanelHabitacion(editable);
        return crearPanelHabitacion(panelHabitacion);
   }

   private PanelHabitacion crearPanelHabitacion(PanelHabitacion panelHabitacion){
        this.add(panelHabitacion,crearConfiguracion(0.8,1));
        return panelHabitacion;
   }

   private PanelBotones crearPanelBotones(Tarea tarea){
        PanelBotones panelBotones = new PanelBotones(tarea,BOTON_VOLVER);
        this.add(panelBotones,crearConfiguracion(0.1,2));
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
