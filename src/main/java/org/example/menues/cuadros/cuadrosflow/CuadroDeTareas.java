package org.example.menues.cuadros.cuadrosflow;

import org.example.menues.acciones.AccionCuadroTareas;
import org.example.menues.cuadros.JPanelCustom;
import org.example.menues.enums.Tarea;

import javax.swing.*;
import java.awt.*;

public class CuadroDeTareas extends JPanelCustom {

    public CuadroDeTareas(String nombreDeEntidad) {
        super();
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setVisible(true);
        aniadirTareas(nombreDeEntidad);
    }

    private void aniadirTareas(String nombreDeEntidad) {
        AccionCuadroTareas accionCuadroTareas = new AccionCuadroTareas();
        for(Tarea tarea : Tarea.values()){
            JButton button = new JButton(tarea.name());
            button.setName(nombreDeEntidad);
            button.addActionListener(accionCuadroTareas);
            this.add(button);
        }
    }


}
