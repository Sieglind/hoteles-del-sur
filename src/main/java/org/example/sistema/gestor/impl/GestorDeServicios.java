package org.example.sistema.gestor.impl;

import org.example.sistema.entidades.Servicio;
import org.example.sistema.excepciones.ObjectoNoEncontradoExcepcion;
import org.example.sistema.excepciones.ObjetoYaExisteExcepcion;
import org.example.sistema.gestor.IGestor;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class GestorDeServicios implements IGestor<String, Servicio> {

    private TreeMap<String, Servicio> servicios;

    public GestorDeServicios() {
        this.servicios = new TreeMap<>();
    }

    // Crear un Servicio
    @Override
    public String crear(Servicio servicio) throws ObjetoYaExisteExcepcion {
        if (servicios.containsKey(servicio.getNombre())) {
            throw new ObjetoYaExisteExcepcion("El servicio con nombre " + servicio.getNombre() + " ya existe.");
        }
        servicios.put(servicio.getNombre(), servicio);
        return servicio.getNombre();
    }

    // Buscar un Servicio
    @Override
    public Servicio buscar(String key) throws ObjectoNoEncontradoExcepcion {
        Servicio servicio = servicios.get(key);
        if (servicio == null) {
            throw new ObjectoNoEncontradoExcepcion("Servicio con nombre " + key + " no encontrado.");
        }
        return servicio;
    }

    // Devuelve una lista con todos los servicios
    @Override
    public List<Servicio> buscarTodos() {
        return new ArrayList<>(servicios.values());
    }


    // Actualizar los datos de un servicio
    @Override
    public Servicio actualizar(String key, Servicio servicio) throws ObjectoNoEncontradoExcepcion {
        if (!servicios.containsKey(key)) {
            throw new ObjectoNoEncontradoExcepcion("Servicio con nombre " + key + " no encontrado.");
        }
        servicios.put(key, servicio);
        return servicio;
    }


    // Eliminar un servicio
    @Override
    public boolean eliminar(String key) throws ObjectoNoEncontradoExcepcion {
        if (!servicios.containsKey(key)) {
                throw new ObjectoNoEncontradoExcepcion("Servicio con nombre " + key +" no encontrado.");
        }
        servicios.remove(key);
        return true;
    }

}
