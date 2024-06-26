package org.example.menues.paneles.panelesgridbag.tareas.impl.servicio;

import org.example.menues.acciones.servicios.*;
import org.example.menues.enums.Entidad;
import org.example.menues.enums.Tarea;
import org.example.menues.modelosdetabla.ModeloTablaServicios;
import org.example.menues.paneles.panelesgridbag.tareas.impl.PanelTareasAbstracto;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Servicio;

import javax.swing.*;
import java.util.List;

public class PanelTareasServicio extends PanelTareasAbstracto {

    private static final String ETIQUETA_CODIGO = "Codigo";

    private PanelServicio panelServicio;

    public PanelTareasServicio(Tarea tarea) {
        super(tarea, Entidad.SERVICIOS);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setVisible(true);
        elegirPanel(tarea);
    }

    @Override
    public void panelCrear() {
        panelDeEntradas = crearPanelDeEntradas(false, ETIQUETA_CODIGO);
        panelServicio = crearPanelServicio(true);
        panelBotones = crearPanelBotones(Tarea.CREAR);
        panelBotones.getBotonGuardar().addActionListener(new AccionCrearServicio(panelServicio));
    }

    @Override
    public void panelBuscar() {
        panelDeEntradas = crearPanelDeEntradas(true, ETIQUETA_CODIGO);
        panelServicio = crearPanelServicio(false);
        panelBotones = crearPanelBotones(Tarea.BUSCAR);
        panelBotones.getBotonBuscar().addActionListener(new AccionBuscarServicio(panelDeEntradas, panelServicio));
    }

    @Override
    public void panelListar() {
        List<Servicio> servicios = Sistema.getInstance().listarServicios();
        ModeloTablaServicios modelo = new ModeloTablaServicios(servicios);
        JTable tabla = new JTable(modelo);
        this.add(new JScrollPane(tabla));
        panelBotones = crearPanelBotones(Tarea.LISTAR);
    }

    @Override
    public void panelActualizar() {
        panelDeEntradas = crearPanelDeEntradas(true, ETIQUETA_CODIGO);
        panelServicio = crearPanelServicio(false);
        panelBotones = crearPanelBotones(Tarea.ACTUALIZAR);
        panelBotones.getBotonBuscar().addActionListener(new AccionBuscarParaActualizarServicio(panelDeEntradas, panelServicio, panelBotones));
        panelBotones.getBotonActualizar().addActionListener(new AccionActualizarServicio(panelServicio));
    }

    @Override
    public void panelBorrar() {
        panelDeEntradas = crearPanelDeEntradas(true, ETIQUETA_CODIGO);
        panelBotones = crearPanelBotones(Tarea.BORRAR);
        panelBotones.getBotonBorrar().addActionListener(new AccionBorrarServicio(panelDeEntradas));
    }

    private PanelServicio crearPanelServicio(boolean editable) {
        PanelServicio panelServicio = new PanelServicio(editable);
        return crearPanelServicio(panelServicio);
    }

    private PanelServicio crearPanelServicio(PanelServicio panelServicio) {
        this.add(panelServicio, crearConfiguracion(0.8, 1));
        return panelServicio;
    }
}
