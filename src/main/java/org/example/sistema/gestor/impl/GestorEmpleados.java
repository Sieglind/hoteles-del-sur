package org.example.sistema.gestor.impl;

import org.example.sistema.entidades.persona.Empleado;
import org.example.sistema.excepciones.ExcepcionObjectoNoEncontrado;
import org.example.sistema.excepciones.ExcepcionObjetoYaExiste;
import org.example.sistema.gestor.IGestor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class GestorEmpleados implements IGestor<String, Empleado> {

    private final HashMap<String, Empleado> empleados;

    public GestorEmpleados() {
        this.empleados = new HashMap<>();
    }

    @Override
    public String crear(Empleado empleado) throws ExcepcionObjetoYaExiste {
        if (empleados.containsKey(empleado.getDni())) {
            throw new ExcepcionObjetoYaExiste(empleado.getDni());
        }
        empleados.put(empleado.getDni(), empleado);
        return empleado.getDni();
    }

    @Override
    public Empleado buscar(String key) throws ExcepcionObjectoNoEncontrado {
        objetoExiste(key);
        return empleados.get(key);
    }

    @Override
    public List<Empleado> listar() {
        return new ArrayList<>(empleados.values());
    }

    @Override
    public Empleado actualizar(String key, Empleado valor) throws ExcepcionObjectoNoEncontrado {
        objetoExiste(key);
        return empleados.put(key, valor);
    }

    @Override
    public void borrar(String key) throws ExcepcionObjectoNoEncontrado {
        objetoExiste(key);
        empleados.remove(key);
    }

    private void objetoExiste(String key) throws ExcepcionObjectoNoEncontrado {
        if (!empleados.containsKey(key) || empleados.get(key) == null) {
            throw new ExcepcionObjectoNoEncontrado(key);
        }
    }
}

