package org.example.menues.cuadros.panelesflow;

import org.example.menues.acciones.AccionPanelEntidad;
import org.example.menues.enums.Entidad;

import javax.swing.*;

public class PanelDeEntidades extends PanelFlowCustom {

    public PanelDeEntidades() {
        cargarBotones();
    }

    private void cargarBotones() {
        AccionPanelEntidad accionPanelEntidad = new AccionPanelEntidad();
        for (Entidad entidad : Entidad.values()) {
            JButton button = new JButton(entidad.name());
            button.setName(entidad.name());
            button.addActionListener(accionPanelEntidad);
            this.add(button);
        }
    }
}
