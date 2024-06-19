package org.example.menues.acciones;

import org.example.menues.VentanaPrincipal;
import org.example.menues.cuadros.cuadrosflow.CuadroDeEntidades;
import org.example.menues.cuadros.cuadrosflow.CuadroDeTareas;

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
            VentanaPrincipal.cambiarCuadro(new CuadroDeEntidades());
        } else {
            VentanaPrincipal.cambiarCuadro(new CuadroDeTareas(nombreDeEntidad));
        }
    }
}
