package org.example.sistema.gestor.impl;

import org.example.sistema.entidades.Servicio;
import org.example.sistema.excepciones.ExcepcionObjectoNoEncontrado;
import org.example.sistema.excepciones.ExcepcionObjetoYaExiste;
import org.example.sistema.gestor.IGestor;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorDeServicios implements IGestor<String, Servicio> {

    private TreeMap<String, Servicio> servicios;

    private final Logger LOG = Logger.getLogger(this.getClass().getName());

    public GestorDeServicios() {
        this.servicios = new TreeMap<>();
    }

    @Override
    public String crear(Servicio servicio) throws ExcepcionObjetoYaExiste {
        if (servicios.containsKey(servicio.getCodigo())) {
            throw new ExcepcionObjetoYaExiste(servicio.getCodigo());
        }
        servicios.put(servicio.getCodigo(), servicio);
        return servicio.getCodigo();
    }

    @Override
    public Servicio buscar(String key) throws ExcepcionObjectoNoEncontrado {
        Servicio servicio = servicios.get(key);
        if (servicio == null) {
            throw new ExcepcionObjectoNoEncontrado(key);
        }
        return servicio;
    }

    @Override
    public List<Servicio> listar() {
        return new ArrayList<>(servicios.values());
    }


    @Override
    public Servicio actualizar(String key, Servicio servicio) throws ExcepcionObjectoNoEncontrado {
        if (!servicios.containsKey(key)) {
            throw new ExcepcionObjectoNoEncontrado(key);
        }
        servicios.put(key, servicio);
        return servicio;
    }


    @Override
    public boolean borrar(String key) throws ExcepcionObjectoNoEncontrado {
        if (!servicios.containsKey(key)) {
                throw new ExcepcionObjectoNoEncontrado(key);
        }
        servicios.remove(key);
        return true;
    }

    public GestorDeServicios conServicios(List<Servicio> servicios) {
        servicios.forEach(servicio -> {
            try {
                crear(servicio);
            } catch (ExcepcionObjetoYaExiste excepcion) {
                LOG.log(Level.WARNING,excepcion.getMessage());
            }
        });
        return this;
    }

}
