package org.example.menues.paneles.panelesgridbag.tareas.impl.reserva;

import org.example.menues.acciones.reserva.*;
import org.example.menues.enums.Entidad;
import org.example.menues.enums.Tarea;
import org.example.menues.paneles.panelesgridbag.tareas.impl.PanelTareas;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Reserva;

import javax.swing.*;
import java.util.List;
import java.util.Vector;

public class PanelTareasReserva extends PanelTareas {

    private static final String ETIQUETA_ID_DE_RESERVA = "Id de reserva";

    private PanelReserva panelReserva;

    public PanelTareasReserva(Tarea tarea) {
        super(tarea, Entidad.RESERVAS);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setVisible(true);
        elegirPanel(tarea);
    }

    @Override
    public void panelCrear() {
        panelDeEntradas = crearPanelDeEntradas(false, ETIQUETA_ID_DE_RESERVA);
        panelReserva = crearPanelReserva(true);
        panelBotones = crearPanelBotones(Tarea.CREAR);
        panelBotones.getBotonGuardar().addActionListener(new AccionCrearReserva(panelDeEntradas, panelReserva));
    }

    @Override
    public void panelBuscar() {
        panelDeEntradas = crearPanelDeEntradas(true, ETIQUETA_ID_DE_RESERVA);
        panelReserva = crearPanelReserva(false);
        panelBotones = crearPanelBotones(Tarea.BUSCAR);
        panelBotones.getBotonBuscar().addActionListener(new AccionBuscarReserva(panelDeEntradas, panelReserva));
    }

    @Override
    public void panelListar() {
        List<Reserva> reservas = Sistema.getInstance().listarReservas();
        JList<Reserva> listaReservas = new JList<>(new Vector<>(reservas));
        this.add(new JScrollPane(listaReservas));
        panelBotones = crearPanelBotones(Tarea.LISTAR);
    }

    @Override
    public void panelActualizar() {
        this.panelDeEntradas = crearPanelDeEntradas(true, ETIQUETA_ID_DE_RESERVA);
        panelReserva = crearPanelReserva(false);
        panelBotones = crearPanelBotones(Tarea.ACTUALIZAR);
        panelBotones.getBotonBuscar().addActionListener(new AccionBuscarParaActualizarReserva(panelDeEntradas, panelReserva, panelBotones));
        panelBotones.getBotonActualizar().addActionListener(new AccionActualizarReserva(panelReserva, panelDeEntradas));
    }

    @Override
    public void panelBorrar() {
        panelDeEntradas = crearPanelDeEntradas(true, ETIQUETA_ID_DE_RESERVA);
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
