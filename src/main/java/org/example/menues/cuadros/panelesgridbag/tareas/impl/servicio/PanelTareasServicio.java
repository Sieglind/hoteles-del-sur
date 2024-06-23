package org.example.menues.cuadros.panelesgridbag.tareas.impl.servicio;

import org.example.menues.acciones.servicios.*;
import org.example.menues.cuadros.panelesgridbag.tareas.ITareas;
import org.example.menues.cuadros.panelesgridbag.tareas.impl.PanelTareas;
import org.example.menues.enums.Entidad;
import org.example.menues.enums.Tarea;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Servicio;

import javax.swing.*;
import java.util.List;
import java.util.Vector;

public class PanelTareasServicio extends PanelTareas implements ITareas {

    private static final String ETIQUETA_CODIGO = "Codig";

    private PanelServicio panelServicio;

    public PanelTareasServicio(Tarea tarea) {
        super(Entidad.SERVICIOS);
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
        this.setBorder(BorderFactory.createTitledBorder("Crear Servicio"));
        panelDeEntradas = crearPanelDeEntradas(false,ETIQUETA_CODIGO);
        panelServicio = crearPanelServicio(true);
        panelBotones = crearPanelBotones(Tarea.CREAR);
        panelBotones.getBotonGuardar().addActionListener(new AccionCrearServicio(panelServicio));

    }

    @Override
    public void panelBuscar() {
        this.setBorder(BorderFactory.createTitledBorder("Buscar Servicio"));
        panelDeEntradas = crearPanelDeEntradas(true,ETIQUETA_CODIGO);
        panelServicio = crearPanelServicio(false);
        panelBotones = crearPanelBotones(Tarea.BUSCAR);
        panelBotones.getBotonBuscar().addActionListener(new AccionBuscarServicio(panelDeEntradas,panelServicio));
    }

    @Override
    public void panelListar() {
        this.setBorder(BorderFactory.createTitledBorder("Listar Servicios"));
        List<Servicio> servicios = Sistema.getInstance().listarServicios();
        JList<Servicio> listaServicios = new JList<>(new Vector<>(servicios));
        this.add(new JScrollPane(listaServicios));
        panelBotones = crearPanelBotones(Tarea.LISTAR);
    }

    @Override
    public void panelActualizar() {
        setBorder(BorderFactory.createTitledBorder("Actualizar Servicio"));
        panelDeEntradas = crearPanelDeEntradas(true,ETIQUETA_CODIGO);
        panelServicio = crearPanelServicio(false);
        panelBotones = crearPanelBotones(Tarea.ACTUALIZAR);
        panelBotones.getBotonBuscar().addActionListener(new AccionBuscarParaActualizarServicio(panelDeEntradas, panelServicio, panelBotones));
        panelBotones.getBotonActualizar().addActionListener(new AccionActualizarServicio(panelServicio));

    }

    @Override
    public void panelBorrar() {
        this.setBorder(BorderFactory.createTitledBorder("Borrar Servicio"));
        panelDeEntradas = crearPanelDeEntradas(true,ETIQUETA_CODIGO);
        panelBotones = crearPanelBotones(Tarea.BORRAR);
        panelBotones.getBotonBorrar().addActionListener(new AccionBorrarServicio(panelDeEntradas));
    }

    private PanelServicio crearPanelServicio(boolean editable){
        PanelServicio panelServicio = new PanelServicio(editable);
        return crearPanelServicio(panelServicio);
    }

    private PanelServicio crearPanelServicio(PanelServicio panelServicio){
        this.add(panelServicio, crearConfiguracion(0.8, 1));
        return panelServicio;
    }
}
