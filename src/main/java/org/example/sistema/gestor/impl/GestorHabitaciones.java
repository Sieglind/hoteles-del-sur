package org.example.sistema.gestor.impl;

import org.example.sistema.entidades.Habitacion;
import org.example.sistema.excepciones.ExcepcionObjectoNoEncontrado;
import org.example.sistema.excepciones.ExcepcionObjetoYaExiste;
import org.example.sistema.gestor.IGestor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorHabitaciones implements IGestor<String, Habitacion> {

    private final Map<String, Habitacion> habitaciones;

    public GestorHabitaciones() {
        this.habitaciones = new HashMap<>();
    }

    @Override
    public String crear(Habitacion valor) throws ExcepcionObjetoYaExiste {
        if (habitaciones.containsKey(valor.getNumeroDeHabitacion())) {
            throw new ExcepcionObjetoYaExiste(valor.getNumeroDeHabitacion());
        }
        habitaciones.put(valor.getNumeroDeHabitacion(), valor);
        return valor.getNumeroDeHabitacion();
    }

    @Override
    public Habitacion buscar(String key) throws ExcepcionObjectoNoEncontrado {
        objetoExiste(key);
        return habitaciones.get(key);
    }

    @Override
    public List<Habitacion> listar() {
        return new ArrayList<>(habitaciones.values());
    }

    @Override
    public Habitacion actualizar(String key, Habitacion valor) throws ExcepcionObjectoNoEncontrado {
        objetoExiste(key);
        return habitaciones.put(key, valor);
    }

    @Override
    public void borrar(String key) throws ExcepcionObjectoNoEncontrado {
        objetoExiste(key);
        habitaciones.remove(key);
    }

    private void objetoExiste(String key) throws ExcepcionObjectoNoEncontrado {
        if (!habitaciones.containsKey(key) || habitaciones.get(key) == null) {
            throw new ExcepcionObjectoNoEncontrado(key);
        }
    }
}
