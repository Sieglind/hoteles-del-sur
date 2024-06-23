package org.example.menues.cuadros.panelesgridbag.tareas.impl.reserva;

import org.example.menues.acciones.reserva.*;
import org.example.menues.cuadros.panelesgridbag.tareas.ITareas;
import org.example.menues.cuadros.panelesgridbag.tareas.impl.PanelTareas;
import org.example.menues.enums.Entidad;
import org.example.menues.enums.Tarea;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Reserva;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.util.List;
import java.util.Vector;

public class PanelTareasReserva extends PanelTareas implements ITareas {

    private static final String ETIQUETA_ID_DE_RESERVA = "Id de reserva";

    private PanelReserva panelReserva;


    public PanelTareasReserva(Tarea tarea) {
        super(Entidad.RESERVAS);
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

        panelDeEntradas = crearPanelDeEntradas(false,ETIQUETA_ID_DE_RESERVA);
        panelReserva = crearPanelReserva(true);
        panelBotones = crearPanelBotones(Tarea.CREAR);
        panelBotones.getBotonGuardar().addActionListener(new AccionCrearReserva(panelDeEntradas,panelReserva) );

    }

    @Override
    public void panelBuscar() {
        this.setBorder(BorderFactory.createTitledBorder("Buscar Reserva"));
        panelDeEntradas = crearPanelDeEntradas(true,ETIQUETA_ID_DE_RESERVA);
        panelReserva = crearPanelReserva(false);
        panelBotones = crearPanelBotones(Tarea.BUSCAR);
        panelBotones.getBotonBuscar().addActionListener(new AccionBuscarReserva(panelDeEntradas,panelReserva));
    }

    @Override
    public void panelListar() {
        this.setBorder(new TitledBorder("Listar Reservas"));
        List<Reserva> reservas = Sistema.getInstance().listarReservas();
        JList<Reserva> listaReservas = new JList<>(new Vector<>(reservas));
        this.add(new JScrollPane(listaReservas));
        panelBotones = crearPanelBotones(Tarea.LISTAR);
    }

    @Override
    public void panelActualizar() {
        this.setBorder(new TitledBorder("Actualizar Reserva"));

        this.panelDeEntradas = crearPanelDeEntradas(true,ETIQUETA_ID_DE_RESERVA);
        panelReserva = crearPanelReserva(false);
        panelBotones = crearPanelBotones(Tarea.ACTUALIZAR);
        panelBotones.getBotonBuscar().addActionListener(new AccionBuscarParaActualizarReserva(panelDeEntradas, panelReserva, panelBotones));
        panelBotones.getBotonActualizar().addActionListener(new AccionActualizarReserva(panelReserva, panelDeEntradas));

    }

    @Override
    public void panelBorrar() {
        this.setBorder(BorderFactory.createTitledBorder("Borrar Cliente"));

        panelDeEntradas = crearPanelDeEntradas(true,ETIQUETA_ID_DE_RESERVA);
        panelBotones = crearPanelBotones(Tarea.BORRAR);
        panelBotones.getBotonBorrar().addActionListener(new AccionBorrarReserva(panelDeEntradas));
    }

    private PanelReserva crearPanelReserva(boolean editable) {
        PanelReserva panelReserva = new PanelReserva(editable);
        return crearPanelReserva(panelReserva);
    }

    private PanelReserva crearPanelReserva(PanelReserva panelReserva) {
        this.add(panelReserva, crearConfiguracion(0.8, 1));
        return panelReserva;
    }
}
