package org.example.menues.cuadros.cuadrosflow;

import org.example.menues.acciones.AccionCuadroTareas;
import org.example.menues.enums.Tarea;

import javax.swing.*;

public class CuadroDeTareas extends CuadroFlowCustom {

    public CuadroDeTareas(String nombreDeEntidad) {
        cargarBotones(nombreDeEntidad);
    }

    private void cargarBotones(String nombreDeEntidad) {
        AccionCuadroTareas accionCuadroTareas = new AccionCuadroTareas();
        for(Tarea tarea : Tarea.values()){
            JButton button = new JButton(tarea.name());
            button.setName(nombreDeEntidad);
            button.addActionListener(accionCuadroTareas);
            this.add(button);
        }
    }


}
