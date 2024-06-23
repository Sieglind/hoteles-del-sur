package org.example.sistema.gestor.impl;

import org.example.sistema.entidades.Habitacion;
import org.example.sistema.excepciones.EscepcionObjectoNoEncontrado;
import org.example.sistema.excepciones.EscepcionObjetoYaExiste;
import org.example.sistema.gestor.IGestor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GestorHabitaciones implements IGestor <String,Habitacion>{
    private final Map<String,Habitacion> listaHabitaciones;

    private final Logger LOG = Logger.getLogger(this.getClass().getName());

    public GestorHabitaciones() {
        this.listaHabitaciones = new HashMap<>();
    }

    public Map<String, Habitacion> getListaHabitaciones() {
        return listaHabitaciones;
    }

    @Override
    public String crear(Habitacion valor) throws EscepcionObjetoYaExiste {
        String llave = obtenerClave(valor);
        if(listaHabitaciones.containsKey(llave)){
            throw new EscepcionObjetoYaExiste(llave);
        }
        listaHabitaciones.put(llave,valor);
        return llave;
    }

    @Override
    public Habitacion buscar(String key) throws EscepcionObjectoNoEncontrado {
        Habitacion habitacion = listaHabitaciones.get(key);
        if(habitacion == null){
            throw new EscepcionObjectoNoEncontrado(key);
        }
        return habitacion;
    }

    @Override
    public List<Habitacion> listar() {
        return new ArrayList<>(listaHabitaciones.values());
    }

    @Override
    public Habitacion actualizar(String key, Habitacion valor) throws EscepcionObjectoNoEncontrado {
        if(!listaHabitaciones.containsKey(key)){
            throw new EscepcionObjectoNoEncontrado(key);
        }
        return listaHabitaciones.put(key,valor);
    }

    @Override
    public boolean borrar(String key) throws EscepcionObjectoNoEncontrado {
        if(!listaHabitaciones.containsKey(key)){
            throw new EscepcionObjectoNoEncontrado(key);
        }
        listaHabitaciones.remove(key);
        return true;
    }

    private String obtenerClave (Habitacion habitacion) {
        return habitacion.getNumeroDeHabitacion();
    }

    public GestorHabitaciones conHabitacion(List<Habitacion> habitaciones) {
        habitaciones.forEach(habitacion -> {
            try {
                crear(habitacion);
            } catch (EscepcionObjetoYaExiste excepcion) {
                LOG.log(Level.WARNING,excepcion.getMessage());
            }
        });
        return this;
    }


}
