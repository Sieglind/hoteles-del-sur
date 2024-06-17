package org.example.gestor.impl;

import org.example.entidades.Servicio;

import java.util.ArrayList;
import java.util.List;

public class GestorDeServicios {
    private final List<Servicio> servicios;

    public GestorDeServicios() {
        this.servicios = new ArrayList<>();
    }

    public GestorDeServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    // Método para agregar un servicio
    public void agregarServicio(Servicio servicio) {
        servicios.add(servicio);
    }

    // Método para eliminar un servicio
    public void eliminarServicio(String nombre) {
        servicios.removeIf(servicio -> servicio.getNombre().equals(nombre));
    }

    // Método para buscar un servicio por nombre
    public Servicio buscarServicio(String nombre) {
        for (Servicio servicio : servicios) {
            if (servicio.getNombre().equals(nombre)) {
                return servicio;
            }
        }
        return null;
    }

    // Método para listar todos los servicios
    public void listarServicios() {
        for (Servicio servicio : servicios) {
            System.out.println(servicio);
        }
    }

}
