package org.example.menues.cuadros.panelesgridbag.tareas.impl.reserva;

import org.example.menues.acciones.AccionVolver;
import org.example.menues.acciones.reserva.*;
import org.example.menues.cuadros.panelesgridbag.*;
import org.example.menues.cuadros.panelesgridbag.tareas.ITareas;
import org.example.menues.enums.Entidad;
import org.example.menues.enums.Tarea;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Reserva;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.List;
import java.util.Vector;

public class PanelTareasReserva extends PanelCustom implements ITareas {

    private final JButton BOTON_VOLVER = crearBoton("Volver", LEFT_ALIGNMENT, new AccionVolver(Entidad.RESERVAS.name()));

    private PanelDeEntradas panelDeEntradas;
    private PanelReserva panelReserva;
    private PanelBotones panelBotones;


    public PanelTareasReserva(Tarea tarea) {
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
        this.setBorder(BorderFactory.createTitledBorder("Crear Reserva"));

        this.panelDeEntradas = crearPanelDeEntradas(false);
        this.panelReserva = crearPanelReserva(true);
        this.panelBotones = crearPanelBotones(Tarea.CREAR);
        panelBotones.getBotonGuardar().addActionListener(new AccionCrearReserva(panelDeEntradas,panelReserva) );

    }

    @Override
    public void panelBuscar() {
        this.setBorder(BorderFactory.createTitledBorder("Buscar Reserva"));
        this.panelDeEntradas = crearPanelDeEntradas(true);
        this.panelReserva = crearPanelReserva(false);
        this.panelBotones = crearPanelBotones(Tarea.BUSCAR);
        panelBotones.getBotonBuscar().addActionListener(new AccionBuscarReserva(panelDeEntradas,panelReserva));
    }

    @Override
    public void panelListar() {
        this.setBorder(new TitledBorder("Listar Reservas"));
        List<Reserva> reservas = Sistema.getInstance().listarReservas();
        JList<Reserva> listaReservas = new JList<>(new Vector<>(reservas));
        this.add(new JScrollPane(listaReservas));
        this.panelBotones = crearPanelBotones(Tarea.LISTAR);
    }

    @Override
    public void panelActualizar() {
        this.setBorder(new TitledBorder("Actualizar Reserva"));

        this.panelDeEntradas = crearPanelDeEntradas(true);
        panelReserva = crearPanelReserva(false);
        this.panelBotones = crearPanelBotones(Tarea.ACTUALIZAR);
        panelBotones.getBotonBuscar().addActionListener(new AccionHabilitarReserva(panelDeEntradas, panelReserva, panelBotones));
        panelBotones.getBotonActualizar().addActionListener(new AccionActualizarReserva(panelReserva, panelDeEntradas));

    }

    @Override
    public void panelBorrar() {
        this.setBorder(BorderFactory.createTitledBorder("Eliminar Cliente"));

        this.panelDeEntradas = crearPanelDeEntradas(true);
        this.panelBotones = crearPanelBotones(Tarea.BORRAR);
        panelBotones.getBotonBorrar().addActionListener(new AccionEliminarReserva(panelDeEntradas));
    }

    private PanelDeEntradas crearPanelDeEntradas(boolean completo) {
        PanelDeEntradas panelDeEntradas = new PanelDeEntradas(completo,"Id de Reserva");
        this.add(panelDeEntradas, crearConfiguracion(0.1, 0));
        return panelDeEntradas;
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

    private PanelReserva crearPanelReserva(boolean editable) {
        PanelReserva panelReserva = new PanelReserva(editable);
        return crearPanelReserva(panelReserva);
    }

    private PanelReserva crearPanelReserva(PanelReserva panelReserva) {
        this.add(panelReserva, crearConfiguracion(0.8, 1));
        return panelReserva;
    }

    private PanelBotones crearPanelBotones(Tarea tarea) {
        PanelBotones panelBotones = new PanelBotones(tarea, BOTON_VOLVER);
        this.add(panelBotones, crearConfiguracion(0.1, 2));
        return panelBotones;
    }
}
