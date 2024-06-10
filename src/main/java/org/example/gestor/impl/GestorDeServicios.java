package org.example.gestor.impl;

import org.example.entidades.Servicio;

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

    //Hola larita
}
