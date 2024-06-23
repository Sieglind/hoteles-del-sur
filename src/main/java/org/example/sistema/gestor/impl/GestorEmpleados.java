package org.example.sistema.gestor.impl;
import org.example.sistema.entidades.persona.Empleado;
import org.example.sistema.excepciones.ExcepcionObjectoNoEncontrado;
import org.example.sistema.excepciones.ExcepcionObjetoYaExiste;
import org.example.sistema.gestor.IGestor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class GestorEmpleados implements IGestor<String, Empleado> {

    private final HashMap<String, Empleado> empleados;
    Logger LOG = Logger.getLogger(GestorEmpleados.class.getName());

    public GestorEmpleados() {
        this.empleados = new HashMap<>();
    }

    @Override
    public String crear(Empleado empleado) throws ExcepcionObjetoYaExiste {
        if(empleado==null){
            throw new IllegalArgumentException("El empleado no pudo ser registrado correctamente");
        }
        if(empleados.containsKey(empleado.getDni())){
            throw new ExcepcionObjetoYaExiste(empleado.getDni());
        }
        empleados.put(empleado.getDni(), empleado);
        return empleado.getDni();
    }

    @Override
    public Empleado buscar(String dni) throws ExcepcionObjectoNoEncontrado {
        Empleado empleado = empleados.get(dni);

        if(empleado == null){
            throw new ExcepcionObjectoNoEncontrado(dni);
        }
        return empleado;
    }

    @Override
    public List<Empleado> listar() {
        return new ArrayList<>(empleados.values());
    }

    @Override
    public Empleado actualizar(String dni, Empleado empleadoActualizado) throws ExcepcionObjectoNoEncontrado {

        if(!empleados.containsKey(dni)){
            throw new ExcepcionObjectoNoEncontrado(dni);
        }
        empleados.put(dni, empleadoActualizado);
        return empleadoActualizado;
    }

    @Override
    public boolean borrar(String dni) throws ExcepcionObjectoNoEncontrado {

        if(!empleados.containsKey(dni)){
            throw new ExcepcionObjectoNoEncontrado(dni);
        }
        empleados.remove(dni);
        return true;
    }

    public GestorEmpleados conEmpleados(List<Empleado> empleados) {
        empleados.forEach(empleado -> {
            try {
                crear(empleado);
            } catch (ExcepcionObjetoYaExiste excepcion) {
                LOG.log(Level.WARNING,excepcion.getMessage());
            }
        });
        return this;
    }
}

