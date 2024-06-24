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

    private final TreeMap<String, Servicio> servicios;
    private final Logger LOG = Logger.getLogger(this.getClass().getName());

    public GestorDeServicios() {
        this.servicios = new TreeMap<>();
    }

    public GestorDeServicios conServicios(List<Servicio> servicios) {
        servicios.forEach(servicio -> {
            try {
                crear(servicio);
            } catch (ExcepcionObjetoYaExiste excepcion) {
                LOG.log(Level.WARNING, excepcion.getMessage());
            }
        });
        return this;
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
        objetoExiste(key);
        return servicios.get(key);
    }

    @Override
    public List<Servicio> listar() {
        return new ArrayList<>(servicios.values());
    }


    @Override
    public Servicio actualizar(String key, Servicio servicio) throws ExcepcionObjectoNoEncontrado {
        objetoExiste(key);
        servicios.put(key, servicio);
        return servicio;
    }


    @Override
    public void borrar(String key) throws ExcepcionObjectoNoEncontrado {
        objetoExiste(key);
        servicios.remove(key);
    }

    private void objetoExiste(String key) throws ExcepcionObjectoNoEncontrado {
        if (!servicios.containsKey(key) || servicios.get(key) == null) {
            throw new ExcepcionObjectoNoEncontrado(key);
        }
    }
}
