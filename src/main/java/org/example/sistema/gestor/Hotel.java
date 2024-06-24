package org.example.sistema.gestor;

public class Hotel {

    private final String nombre;
    private final String direccion;
    private final String telefono;
    private final String cuil;

    public Hotel(String nombre, String direccion, String telefono, String cuil) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cuil = cuil;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCuil() {
        return cuil;
    }
}
