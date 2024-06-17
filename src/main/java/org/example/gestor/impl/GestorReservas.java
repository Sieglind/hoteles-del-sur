package org.example.gestor.impl;

import org.example.entidades.Reserva;
import org.example.excepciones.ObjectoNoEncontradoExcepcion;
import org.example.excepciones.ObjetoYaExisteExcepcion;
import org.example.gestor.IGestor;

import java.util.*;

public class GestorReservas implements IGestor<String, Reserva> {

    private final Map<String, Reserva> reservas = new HashMap<>();

    public GestorReservas() {
    }

    @Override
    public String crear(Reserva reserva) throws ObjetoYaExisteExcepcion {
        if (reservas.containsKey(reserva.getIdReserva())) {
            throw new ObjetoYaExisteExcepcion("Ya existe una reserva con el id: " + reserva.getIdReserva());
        }
        return reserva.getIdReserva();
    }

    @Override
    public Reserva buscar(String key) throws ObjectoNoEncontradoExcepcion {
        objetoExiste(key);
        return reservas.get(key);
    }

    @Override
    public List<Reserva> buscarTodos() {
        return new ArrayList<>(this.reservas.values());
    }

    @Override
    public Reserva actualizar(String key, Reserva valor) throws ObjectoNoEncontradoExcepcion {
        objetoExiste(key);
        reservas.put(key,valor);
        return valor;
    }

    @Override
    public boolean eliminar(String key) throws ObjectoNoEncontradoExcepcion {
        objetoExiste(key);
        reservas.remove(key);
        return true;
    }

    private void objetoExiste(String key) throws ObjectoNoEncontradoExcepcion {
        if (!reservas.containsKey(key) || reservas.get(key) == null) {
            throw new ObjectoNoEncontradoExcepcion("No existe una reserva con el id: " + key);
        }
    }
}
