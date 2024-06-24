package org.example.menues.cuadros.panelesflow;

import org.example.menues.acciones.AccionPanelTareas;
import org.example.menues.acciones.AccionVolver;
import org.example.menues.enums.Tarea;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PanelDeTareas extends PanelFlowCustom {

    public PanelDeTareas(String nombreDeEntidad) {
        this.setBorder(new TitledBorder(nombreDeEntidad.toUpperCase()));
        cargarBotones(nombreDeEntidad);
    }

    private void cargarBotones(String nombreDeEntidad) {
        AccionPanelTareas accionPanelTareas = new AccionPanelTareas();
        for(Tarea tarea : Tarea.values()){
            JButton button = new JButton(tarea.name(),new ImageIcon(tarea.getUrlIcono()));
            button.setName(nombreDeEntidad);
            button.addActionListener(accionPanelTareas);
            this.add(button);
        }
        JButton botonVolver = new JButton("Volver");
        botonVolver.addActionListener(new AccionVolver(null));
        this.add(botonVolver);
    }


}
