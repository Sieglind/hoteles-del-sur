package org.example.menues.cuadros.cuadrosflow;

import org.example.menues.acciones.AccionCuadroEntidad;
import org.example.menues.cuadros.JPanelCustom;
import org.example.menues.enums.Entidad;

import javax.swing.*;
import java.awt.*;

public class CuadroDeEntidades extends JPanelCustom {

    public CuadroDeEntidades() {
        super();
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setVisible(true);
        aniadirEntidades();
    }

    private void aniadirEntidades() {
        AccionCuadroEntidad accionCuadroEntidad = new AccionCuadroEntidad();
        for (Entidad entidad : Entidad.values()) {
            JButton button = new JButton(entidad.name());
            button.setName(entidad.name());
            button.addActionListener(accionCuadroEntidad);
            this.add(button);
        }
    }
}
