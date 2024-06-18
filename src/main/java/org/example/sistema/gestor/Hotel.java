package org.example.sistema.gestor;

public class Hotel {
    private final String nombre;
    private final String direccion;
    private final String contacto;

    public Hotel(String nombre, String direccion, String contacto) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.contacto = contacto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getContacto() {
        return contacto;
    }

}
