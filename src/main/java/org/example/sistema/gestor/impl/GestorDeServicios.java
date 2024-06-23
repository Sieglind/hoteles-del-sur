package org.example.sistema.gestor.impl;

import org.example.sistema.entidades.Servicio;
import org.example.sistema.excepciones.EscepcionObjectoNoEncontrado;
import org.example.sistema.excepciones.EscepcionObjetoYaExiste;
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

    // Crear un Servicio
    @Override
    public String crear(Servicio servicio) throws EscepcionObjetoYaExiste {
        if (servicios.containsKey(servicio.getCodigo())) {
            throw new EscepcionObjetoYaExiste(servicio.getCodigo());
        }
        servicios.put(servicio.getCodigo(), servicio);
        return servicio.getCodigo();
    }

    // Buscar un Servicio
    @Override
    public Servicio buscar(String key) throws EscepcionObjectoNoEncontrado {
        Servicio servicio = servicios.get(key);
        if (servicio == null) {
            throw new EscepcionObjectoNoEncontrado(key);
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
    public Servicio actualizar(String key, Servicio servicio) throws EscepcionObjectoNoEncontrado {
        if (!servicios.containsKey(key)) {
            throw new EscepcionObjectoNoEncontrado(key);
        }
        servicios.put(key, servicio);
        return servicio;
    }


    @Override
    public boolean borrar(String key) throws EscepcionObjectoNoEncontrado {
        if (!servicios.containsKey(key)) {
                throw new EscepcionObjectoNoEncontrado(key);
        }
        servicios.remove(key);
        return true;
    }

    public GestorDeServicios conServicios(List<Servicio> servicios) {
        servicios.forEach(servicio -> {
            try {
                crear(servicio);
            } catch (EscepcionObjetoYaExiste excepcion) {
                LOG.log(Level.WARNING,excepcion.getMessage());
            }
        });
        return this;
    }

}
