package org.example.sistema.entidades.persona;

import org.example.sistema.enums.Cargo;

public class Empleado extends Persona {

    private final Cargo cargo;
    private String password;

    public Empleado(String nombre, String apellido, String dni, Cargo cargo) {
        super(nombre, apellido, dni);
        this.cargo = cargo;
    }

    public Empleado(String nombre, String apellido, String dni, Cargo cargo, String password) {
        super(nombre, apellido, dni);
        this.cargo = cargo;
        this.password = password;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public String getPassword() {
        return password;
    }
}
