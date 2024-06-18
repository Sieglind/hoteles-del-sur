package org.example.sistema.gestor.impl;

import org.example.sistema.entidades.persona.Cliente;
import org.example.sistema.excepciones.ObjectoNoEncontradoExcepcion;
import org.example.sistema.excepciones.ObjetoYaExisteExcepcion;
import org.example.sistema.gestor.IGestor;


import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class GestorClientes implements IGestor<String, Cliente> {

    private TreeMap<String, Cliente> listaClientes;

    public GestorClientes() {
        this.listaClientes = new TreeMap<>();
    }

    //Crea un Cliente
    @Override
    public String crear(Cliente cliente) throws ObjetoYaExisteExcepcion {
        if (listaClientes.containsKey(cliente.getDni())) {
            throw new ObjetoYaExisteExcepcion("El cliente con DNI " + cliente.getDni() + " ya existe.");
        }
        listaClientes.put(cliente.getDni(), cliente);
        return cliente.getDni();
    }

    //Busca un cliente
    @Override
    public Cliente buscar(String key) throws ObjectoNoEncontradoExcepcion {
        Cliente cliente = listaClientes.get(key);
        if (cliente == null) {
            throw new ObjectoNoEncontradoExcepcion("Cliente con ID " + key + " no encontrado.");
        }
        return cliente;
    }

    //Devuelve una lista con todos los clientes
    @Override
    public List<Cliente> buscarTodos() {
        return new ArrayList<>(listaClientes.values());
    }

    //Actualiza los datos de un cliente
    @Override
    public Cliente actualizar(String key, Cliente cliente) throws ObjectoNoEncontradoExcepcion {
        if (!listaClientes.containsKey(key)) {
            throw new ObjectoNoEncontradoExcepcion("Cliente con DNI " + key + " no encontrado.");
        }
        listaClientes.put(key, cliente);
        return cliente;
    }

    //Elimina un Cliente
    @Override
    public boolean eliminar(String key) throws ObjectoNoEncontradoExcepcion {
        if (!listaClientes.containsKey(key)) {
            throw new ObjectoNoEncontradoExcepcion("Cliente con DNI " + key + " no encontrado.");
        }
        listaClientes.remove(key);
        return true;
    }
}

