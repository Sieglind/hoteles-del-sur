package org.example.sistema.gestor.impl;

import org.example.sistema.entidades.Reserva;
import org.example.sistema.excepciones.ObjectoNoEncontradoExcepcion;
import org.example.sistema.excepciones.ObjetoYaExisteExcepcion;
import org.example.sistema.gestor.IGestor;

import java.util.*;

public class GestorReservas implements IGestor<String, Reserva> {

    private final Map<String, Reserva> reservas = new HashMap<>();

    public GestorReservas() {
    }

    @Override
    public String crear(Reserva reserva) throws ObjetoYaExisteExcepcion {
        if (reservas.containsKey(reserva.getIdReserva())) {
            throw new ObjetoYaExisteExcepcion("Ya existe una reserva con el id: " + reserva.getIdReserva());
        } else {
            reservas.put(reserva.getIdReserva(), reserva);
        }
        return reserva.getIdReserva();
    }

    @Override
    public Reserva buscar(String key) throws ObjectoNoEncontradoExcepcion {
        objetoExiste(key);
        return reservas.get(key);
    }

    @Override
    public List<Reserva> listar() {
        return new ArrayList<>(this.reservas.values());
    }

    @Override
    public Reserva actualizar(String key, Reserva valor) throws ObjectoNoEncontradoExcepcion {
//        objetoExiste(key);
        if (!reservas.containsKey(key)) {
            throw new ObjectoNoEncontradoExcepcion("La reserva no existe");
        }
        return reservas.put(key, valor);

    }

    @Override
    public boolean borrar(String key) throws ObjectoNoEncontradoExcepcion {
        objetoExiste(key);
        reservas.remove(key);
        return true;
    }

    private void objetoExiste(String key) throws ObjectoNoEncontradoExcepcion {
        if (!reservas.containsKey(key) || reservas.get(key) == null) {
            throw new ObjectoNoEncontradoExcepcion("No existe una reserva con el id: " + key);
        }
    }

    public String asignarId(Reserva reserva) {
        reserva.setIdReserva(reserva.getIdReserva());
        return reserva.getIdReserva();
    }

}
