package org.example.menues.cuadros.cuadroscaja.tareas.impl;

import org.example.menues.acciones.AccionVolver;
import org.example.menues.cuadros.cuadroscaja.*;
import org.example.menues.cuadros.cuadroscaja.tareas.Tareas;
import org.example.menues.enums.Entidad;
import org.example.menues.enums.Tarea;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Habitacion;
import org.example.sistema.enums.TipoDeHabitacion;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.List;
import java.util.Vector;


public class TareasHabitacion extends CuadroCajaCustom implements Tareas {

    private final JButton BOTON_VOLVER = crearBoton("Volver", LEFT_ALIGNMENT, new AccionVolver(Entidad.HABITACIONES.name()));

    private PanelDeEntradas panelDeEntradas;
    private PanelHabitacion panelHabitacion;
    private PanelBotones panelBotones;

    public TareasHabitacion(Tarea tarea) {
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
            case BORRAR -> panelEliminar();
        }
    }

    @Override
    public void panelCrear() {
        this.setBorder(new TitledBorder("Crear Habitación"));

        this.panelDeEntradas = crearPanelDeEntradas(false);
        this.panelHabitacion = crearPanelHabitacion(true);
        this.panelBotones = crearPanelBotones(Tarea.CREAR);

    }


    @Override
    public void panelBuscar() {
        this.setBorder(new TitledBorder("Buscar Habitacion"));

        this.panelDeEntradas = crearPanelDeEntradas(true);
        this.panelHabitacion = crearPanelHabitacion(true);
        this.panelBotones = crearPanelBotones(Tarea.CREAR);

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

        this.panelDeEntradas = crearPanelDeEntradas(true);
        this.panelBotones = crearPanelBotones(Tarea.ACTUALIZAR);
    }

    @Override
    public void panelEliminar() {
        this.setBorder(new TitledBorder("Eliminar Habitacion"));

        this.panelDeEntradas = crearPanelDeEntradas(true);
        this.panelBotones = crearPanelBotones(Tarea.BORRAR);

    }

   private PanelDeEntradas crearPanelDeEntradas(boolean editable){
        PanelDeEntradas panelDeEntrada = new PanelDeEntradas(editable);
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
