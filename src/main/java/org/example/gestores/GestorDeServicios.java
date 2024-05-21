package org.example.gestores;

import org.example.reservas.Servicio;

import java.util.ArrayList;
import java.util.List;

public class GestorDeServicios {
    private final List<Servicio> servicios;

    public GestorDeServicios() {
        this.servicios = new ArrayList<>();
        //por aca paso facu
    }

    public GestorDeServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }
}
