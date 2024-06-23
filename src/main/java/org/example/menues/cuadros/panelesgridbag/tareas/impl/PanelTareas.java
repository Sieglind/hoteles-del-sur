package org.example.menues.cuadros.panelesgridbag.tareas.impl;

import org.example.menues.acciones.AccionVolver;
import org.example.menues.cuadros.panelesgridbag.PanelBotones;
import org.example.menues.cuadros.panelesgridbag.PanelCustom;
import org.example.menues.cuadros.panelesgridbag.PanelDeEntradas;
import org.example.menues.enums.Entidad;
import org.example.menues.enums.Tarea;

import javax.swing.*;
import java.awt.*;

public class PanelTareas extends PanelCustom {

    protected final JButton BOTON_VOLVER;
    protected static final String ETIQUEDA_DNI = "DNI";

    protected PanelDeEntradas panelDeEntradas;
    protected PanelBotones panelBotones;

    public PanelTareas(Entidad entidad) {
        this.BOTON_VOLVER = crearBoton("Volver",LEFT_ALIGNMENT, new AccionVolver(entidad.name()));
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
