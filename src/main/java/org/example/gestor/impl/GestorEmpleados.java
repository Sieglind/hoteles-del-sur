package org.example.gestor.impl;
import org.example.entidades.persona.Empleado;
import org.example.excepciones.ObjectoNoEncontradoExcepcion;
import org.example.excepciones.ObjetoYaExisteExcepcion;
import org.example.gestor.IGestor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class GestorEmpleados implements IGestor<String, Empleado> {

    private final HashMap<String, Empleado> empleados;

    public GestorEmpleados() {
        this.empleados = new HashMap<>();
    }

    @Override
    public String crear(Empleado empleado) throws ObjetoYaExisteExcepcion {
        if(empleados.containsKey(empleado.getDni())){
            throw new ObjetoYaExisteExcepcion("Ya existe registrado un empleado con DNI " + empleado.getDni());
        }
        empleados.put(empleado.getDni(), empleado);
        return empleado.getDni();
    }

    @Override
    public Empleado buscar(String dni) throws ObjectoNoEncontradoExcepcion {
        Empleado empleado = empleados.get(dni);

        if(empleado == null){
            throw new ObjectoNoEncontradoExcepcion("No existe registrado ningún empleado con DNI: " + empleado.getDni());
        }
        return empleado;
    }

    @Override
    public List<Empleado> buscarTodos() {
        return new ArrayList<>(empleados.values());
    }

    @Override
    public Empleado actualizar(String dni, Empleado empleadoActualizado) throws ObjectoNoEncontradoExcepcion {

        if(!empleados.containsKey(dni)){
            throw new ObjectoNoEncontradoExcepcion("No existe ningún empleado registrado con DNI " + dni);
        }
        empleados.put(dni, empleadoActualizado);
        return empleadoActualizado;
    }

    @Override
    public boolean eliminar(String dni) throws ObjectoNoEncontradoExcepcion {

        if(!empleados.containsKey(dni)){
            throw new ObjectoNoEncontradoExcepcion("No existe ningún empleado registrado con DNI " + dni);
        }
        empleados.remove(dni);
        return true;
    }
}

