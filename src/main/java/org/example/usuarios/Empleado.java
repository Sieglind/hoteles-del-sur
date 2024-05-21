package org.example.usuarios;

public class Empleado extends Persona{

    private Cargo cargo;
    private boolean available;

    public Empleado(String nombre, String apellido, String dni, Cargo cargo, boolean available) {
        super(nombre, apellido, dni);
        this.cargo = cargo;
        this.available = available;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
