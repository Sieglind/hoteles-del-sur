package org.example.menues.acciones;

import org.example.menues.VentanaPrincipal;
import org.example.menues.paneles.panelesflow.PanelDeEntidades;
import org.example.menues.paneles.panelesflow.PanelDeTareas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionVolver implements ActionListener {

    private final String nombreDeEntidad;

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
