package org.example.menues.cuadros.cuadrosflow;

import org.example.menues.acciones.AccionCuadroEntidad;
import org.example.menues.enums.Entidad;

import javax.swing.*;

public class CuadroDeEntidades extends CuadroFlowCustom {

    public CuadroDeEntidades() {
        cargarBotones();
    }

    private void cargarBotones() {
        AccionCuadroEntidad accionCuadroEntidad = new AccionCuadroEntidad();
        for (Entidad entidad : Entidad.values()) {
            JButton button = new JButton(entidad.name());
            button.setName(entidad.name());
            button.addActionListener(accionCuadroEntidad);
            this.add(button);
        }
    }
}
