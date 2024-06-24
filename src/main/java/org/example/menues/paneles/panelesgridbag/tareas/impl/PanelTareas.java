package org.example.menues.paneles.panelesgridbag.tareas.impl;

import org.example.menues.acciones.AccionVolver;
import org.example.menues.paneles.panelesgridbag.PanelBotones;
import org.example.menues.paneles.panelesgridbag.PanelCustom;
import org.example.menues.paneles.panelesgridbag.PanelDeEntradas;
import org.example.menues.paneles.panelesgridbag.tareas.ITareas;
import org.example.menues.enums.Entidad;
import org.example.menues.enums.Tarea;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;

public abstract class PanelTareas extends PanelCustom implements ITareas {

    protected final JButton BOTON_VOLVER;
    protected static final String ETIQUEDA_DNI = "DNI";

    protected PanelDeEntradas panelDeEntradas;
    protected PanelBotones panelBotones;

    public PanelTareas(Tarea tarea, Entidad entidad) {
        this.setBorder(new TitledBorder(tarea.name() + " " + entidad.name()));
        this.BOTON_VOLVER = crearBoton("Volver",LEFT_ALIGNMENT, new AccionVolver(entidad.name()));
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setVisible(true);
    }

    protected void elegirPanel(Tarea tarea) {
        switch (tarea) {
            case CREAR -> panelCrear();
            case ACTUALIZAR -> panelActualizar();
            case LISTAR -> panelListar();
            case BORRAR -> panelBorrar();
            case BUSCAR -> panelBuscar();
        }
    }

    protected PanelDeEntradas crearPanelDeEntradas(boolean completo, String etiqueta) {
        PanelDeEntradas panelDeEntradas = new PanelDeEntradas(completo, etiqueta);
        this.add(panelDeEntradas, crearConfiguracion(0.1, 0));
        return panelDeEntradas;
    }

    protected PanelBotones crearPanelBotones(Tarea tarea) {
        PanelBotones panelBotones = new PanelBotones(tarea, BOTON_VOLVER);
        this.add(panelBotones, crearConfiguracion(0.1, 2));
        return panelBotones;
    }

    protected GridBagConstraints crearConfiguracion(double weighty, int posicion) {
        GridBagConstraints configuracion = new GridBagConstraints();
        configuracion.weightx = 1.0;
        configuracion.weighty = weighty;
        configuracion.gridx = posicion;
        configuracion.insets = new Insets(30, 30, 30, 30);
        configuracion.fill = GridBagConstraints.BOTH;
        return configuracion;
    }
}
