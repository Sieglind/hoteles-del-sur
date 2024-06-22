package org.example.sistema.gestor.impl;

import org.example.sistema.entidades.Servicio;
import org.example.sistema.excepciones.ObjectoNoEncontradoExcepcion;
import org.example.sistema.excepciones.ObjetoYaExisteExcepcion;
import org.example.sistema.gestor.IGestor;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorDeServicios implements IGestor<Integer, Servicio> {

    //private TreeMap<String, Servicio> servicios;

    private TreeMap<Integer, Servicio> servicios;

    private final Logger LOG = Logger.getLogger(this.getClass().getName());

    public GestorDeServicios() {
        this.servicios = new TreeMap<>();
    }

    // Crear un Servicio
    @Override
    public Integer crear(Servicio servicio) throws ObjetoYaExisteExcepcion {
        if (servicios.containsKey(servicio.getClave())) {
            throw new ObjetoYaExisteExcepcion("El servicio con clave " + servicio.getClave() + " ya existe.");
        }
        servicios.put(servicio.getClave(), servicio);
        return servicio.getClave();
    }

    // Buscar un Servicio
    @Override
    public Servicio buscar(Integer key) throws ObjectoNoEncontradoExcepcion {
        Servicio servicio = servicios.get(key);
        if (servicio == null) {
            throw new ObjectoNoEncontradoExcepcion("Servicio con clave " + key + " no encontrado.");
        }
        return servicio;
    }

    // Devuelve una lista con todos los servicios
    @Override
    public List<Servicio> listar() {
        return new ArrayList<>(servicios.values());
    }


    // Actualizar los datos de un servicio
    @Override
    public Servicio actualizar(Integer key, Servicio servicio) throws ObjectoNoEncontradoExcepcion {
        if (!servicios.containsKey(key)) {
            throw new ObjectoNoEncontradoExcepcion("Servicio con clave " + key + " no encontrado.");
        }
        servicios.put(key, servicio);
        return servicio;
    }


    // Eliminar un servicio
    @Override
    public boolean borrar(Integer key) throws ObjectoNoEncontradoExcepcion {
        if (!servicios.containsKey(key)) {
                throw new ObjectoNoEncontradoExcepcion("Servicio con clave " + key +" no encontrado.");
        }
        servicios.remove(key);
        return true;
    }

    public GestorDeServicios conServicios(List<Servicio> servicios) {
        servicios.forEach(servicio -> {
            try {
                crear(servicio);
            } catch (ObjetoYaExisteExcepcion excepcion) {
                LOG.log(Level.WARNING,excepcion.getMessage());
            }
        });
        return this;
    }

}
