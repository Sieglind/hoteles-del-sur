package org.example.sistema.gestor.impl;

import org.example.sistema.entidades.persona.Cliente;
import org.example.sistema.excepciones.ExcepcionObjectoNoEncontrado;
import org.example.sistema.excepciones.ExcepcionObjetoYaExiste;
import org.example.sistema.gestor.IGestor;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class GestorClientes implements IGestor<String, Cliente> {

    private final TreeMap<String, Cliente> clientes;

    public GestorClientes() {
        this.clientes = new TreeMap<>();
    }


    @Override
    public String crear(Cliente cliente) throws ExcepcionObjetoYaExiste {
        if (clientes.containsKey(cliente.getDni())) {
            throw new ExcepcionObjetoYaExiste(cliente);
        }
        clientes.put(cliente.getDni(), cliente);
        return cliente.getDni();
    }

    @Override
    public Cliente buscar(String key) throws ExcepcionObjectoNoEncontrado {
        objetoExiste(key);
        return clientes.get(key);
    }

    @Override
    public List<Cliente> listar() {
        return new ArrayList<>(clientes.values());
    }

    @Override
    public Cliente actualizar(String key, Cliente cliente) throws ExcepcionObjectoNoEncontrado {
        objetoExiste(key);
        return clientes.put(key, cliente);
    }

    @Override
    public void borrar(String key) throws ExcepcionObjectoNoEncontrado {
        objetoExiste(key);
        clientes.remove(key);
    }

    private void objetoExiste(String key) throws ExcepcionObjectoNoEncontrado {
        if (!clientes.containsKey(key) || clientes.get(key) == null) {
            throw new ExcepcionObjectoNoEncontrado(key);
        }
    }
}

