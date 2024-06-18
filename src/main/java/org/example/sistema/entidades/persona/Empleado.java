package org.example.sistema.entidades.persona;

import org.example.sistema.enums.Cargo;

public class Empleado extends Persona {

    private Cargo cargo;
    private String password;
    private boolean available;

    public Empleado(String nombre, String apellido, String dni, Cargo cargo) {
        super(nombre, apellido, dni);
        this.cargo = cargo;
        this.available = true;
    }

    public Empleado(String nombre, String apellido, String dni, Cargo cargo, boolean available, String password) {
        super(nombre, apellido, dni);
        this.cargo = cargo;
        this.available = available;
        this.password = password;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
