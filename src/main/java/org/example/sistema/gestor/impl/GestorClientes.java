package org.example.sistema.gestor.impl;

import org.example.sistema.entidades.persona.Cliente;
import org.example.sistema.excepciones.ExcepcionObjectoNoEncontrado;
import org.example.sistema.excepciones.ExcepcionObjetoYaExiste;
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

    @Override
    public String crear(Cliente cliente) throws ExcepcionObjetoYaExiste {
        if (listaClientes.containsKey(cliente.getDni())) {
            throw new ExcepcionObjetoYaExiste(cliente);
        }
        listaClientes.put(cliente.getDni(), cliente);
        return cliente.getDni();
    }

    @Override
    public Cliente buscar(String key) throws ExcepcionObjectoNoEncontrado {
        Cliente cliente = listaClientes.get(key);
        if (cliente == null) {
            throw new ExcepcionObjectoNoEncontrado(key);
        }
        return cliente;
    }

    @Override
    public List<Cliente> listar() {
        return new ArrayList<>(listaClientes.values());
    }

    @Override
    public Cliente actualizar(String key, Cliente cliente) throws ExcepcionObjectoNoEncontrado {
        if (!listaClientes.containsKey(key)) {
            throw new ExcepcionObjectoNoEncontrado(key);
        }
        listaClientes.put(key, cliente);
        return cliente;
    }

    @Override
    public boolean borrar(String key) throws ExcepcionObjectoNoEncontrado {
        if (!listaClientes.containsKey(key)) {
            throw new ExcepcionObjectoNoEncontrado(key);
        }
        listaClientes.remove(key);
        return true;
    }

    public GestorClientes conClientes(List<Cliente> clientes) {
        clientes.forEach(cliente -> {
            try {
                crear(cliente);
            } catch (ExcepcionObjetoYaExiste excepcion) {
                LOG.log(Level.WARNING,excepcion.getMessage());
            }
        });
        return this;
    }
}

