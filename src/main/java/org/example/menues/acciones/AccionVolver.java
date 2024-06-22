package org.example.menues.acciones;

import org.example.menues.VentanaPrincipal;
import org.example.menues.cuadros.panelesflow.PanelDeEntidades;
import org.example.menues.cuadros.panelesflow.PanelDeTareas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionVolver implements ActionListener {

    private String nombreDeEntidad;

    public AccionVolver(String nombreDeEntidad) {
        this.nombreDeEntidad = nombreDeEntidad;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        if (nombreDeEntidad == null) {
            VentanaPrincipal.cambiarCuadro(new PanelDeEntidades());
        } else {
            VentanaPrincipal.cambiarCuadro(new PanelDeTareas(nombreDeEntidad));
        }
    }
}
