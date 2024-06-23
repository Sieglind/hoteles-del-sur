package org.example.sistema.gestor.impl;

import org.example.sistema.entidades.persona.Cliente;
import org.example.sistema.excepciones.ObjectoNoEncontradoExcepcion;
import org.example.sistema.excepciones.ObjetoYaExisteExcepcion;
import org.example.sistema.gestor.IGestor;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorClientes implements IGestor<String, Cliente> {

    private final TreeMap<String, Cliente> listaClientes;
    private final Logger LOG = Logger.getLogger(this.getClass().getName());

    public GestorClientes() {
        this.listaClientes = new TreeMap<>();
    }

    //Crea un Cliente
    @Override
    public String crear(Cliente cliente) throws ObjetoYaExisteExcepcion {
        if (listaClientes.containsKey(cliente.getDni())) {
            throw new ObjetoYaExisteExcepcion(cliente);
        }
        listaClientes.put(cliente.getDni(), cliente);
        return cliente.getDni();
    }

    //Busca un cliente
    @Override
    public Cliente buscar(String key) throws ObjectoNoEncontradoExcepcion {
        Cliente cliente = listaClientes.get(key);
        if (cliente == null) {
            throw new ObjectoNoEncontradoExcepcion(key);
        }
        return cliente;
    }

    //Devuelve una lista con todos los clientes
    @Override
    public List<Cliente> listar() {
        return new ArrayList<>(listaClientes.values());
    }

    //Actualiza los datos de un cliente
    @Override
    public Cliente actualizar(String key, Cliente cliente) throws ObjectoNoEncontradoExcepcion {
        if (!listaClientes.containsKey(key)) {
            throw new ObjectoNoEncontradoExcepcion(key);
        }
        listaClientes.put(key, cliente);
        return cliente;
    }

    //Elimina un Cliente
    @Override
    public boolean borrar(String key) throws ObjectoNoEncontradoExcepcion {
        if (!listaClientes.containsKey(key)) {
            throw new ObjectoNoEncontradoExcepcion(key);
        }
        listaClientes.remove(key);
        return true;
    }

    public GestorClientes conClientes(List<Cliente> clientes) {
        clientes.forEach(cliente -> {
            try {
                crear(cliente);
            } catch (ObjetoYaExisteExcepcion excepcion) {
                LOG.log(Level.WARNING,excepcion.getMessage());
            }
        });
        return this;
    }
}

