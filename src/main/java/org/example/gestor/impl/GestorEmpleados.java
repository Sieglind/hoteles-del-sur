package org.example.gestor.impl;

import org.example.entidades.persona.Empleado;

import java.util.ArrayList;
import java.util.List;

public class GestorEmpleados {

    private final List<Empleado> empleados;

    public GestorEmpleados() {
        this.empleados = new ArrayList<Empleado>();
    }
}
//este gestor lo hace tamy