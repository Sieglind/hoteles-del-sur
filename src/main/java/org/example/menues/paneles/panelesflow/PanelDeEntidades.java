package org.example.menues.paneles.panelesflow;

import org.example.menues.acciones.AccionPanelEntidad;
import org.example.menues.enums.Entidad;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PanelDeEntidades extends PanelFlowCustom {

    public PanelDeEntidades() {
        this.setBorder(new TitledBorder("BIENVENIDO"));
        cargarBotones();
    }

    private void cargarBotones() {
        AccionPanelEntidad accionPanelEntidad = new AccionPanelEntidad();
        for (Entidad entidad : Entidad.values()) {
            JButton button = new JButton(entidad.name(), new ImageIcon(entidad.getUrlIcono()));
            button.setName(entidad.name());
            button.addActionListener(accionPanelEntidad);
            this.add(button);
        }
    }
}
