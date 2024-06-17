package org.example.menues.cuadros.cuadrosflow;

import org.example.menues.acciones.AccionBotonListaTareas;
import org.example.menues.cuadros.JPanelCustom;
import org.example.menues.enums.Tarea;

import javax.swing.*;
import java.awt.*;

public class CuadroTareas extends JPanelCustom {

    public CuadroTareas() {
        super();
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setVisible(true);
        aniadirTareas();
    }

    private void aniadirTareas() {
        AccionBotonListaTareas accionBotonListaTareas = new AccionBotonListaTareas();
        for (Tarea tarea : Tarea.values()) {
            JButton button = new JButton(tarea.name());
            button.addActionListener(accionBotonListaTareas);
            this.add(button);
        }
    }
}
