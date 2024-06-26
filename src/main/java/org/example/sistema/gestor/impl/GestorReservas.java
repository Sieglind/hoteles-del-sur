package org.example.sistema.gestor.impl;

import org.example.sistema.entidades.Reserva;
import org.example.sistema.excepciones.ExcepcionObjectoNoEncontrado;
import org.example.sistema.excepciones.ExcepcionObjetoYaExiste;
import org.example.sistema.gestor.IGestor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorReservas implements IGestor<String, Reserva> {

    private final Map<String, Reserva> reservas = new HashMap<>();

    public GestorReservas() {}

    @Override
    public String crear(Reserva reserva) throws ExcepcionObjetoYaExiste {
        if (reservas.containsKey(reserva.getIdReserva())) {
            throw new ExcepcionObjetoYaExiste(reserva.getIdReserva());
        } else {
            reservas.put(reserva.getIdReserva(), reserva);
        }
        return reserva.getIdReserva();
    }

    @Override
    public Reserva buscar(String key) throws ExcepcionObjectoNoEncontrado {
        objetoExiste(key);
        return reservas.get(key);
    }

    @Override
    public List<Reserva> listar() {
        return new ArrayList<>(this.reservas.values());
    }

    @Override
    public Reserva actualizar(String key, Reserva valor) throws ExcepcionObjectoNoEncontrado {
        objetoExiste(key);
        reservas.put(key, valor);
        return valor;
    }

    @Override
    public void borrar(String key) throws ExcepcionObjectoNoEncontrado {
        objetoExiste(key);
        reservas.remove(key);
    }

    private void objetoExiste(String key) throws ExcepcionObjectoNoEncontrado {
        if (!reservas.containsKey(key) || reservas.get(key) == null) {
            throw new ExcepcionObjectoNoEncontrado(key);
        }
    }
}
