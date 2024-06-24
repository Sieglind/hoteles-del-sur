package org.example.sistema.entidades;

public class Servicio {

    private final String nombre;
    private final String descripcion;
    private final float precio;
    private final String codigo;

    public Servicio(String nombre, String descripcion, float precio, String codigo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return
                " | Clave: " + codigo +
                        " | " + nombre +
                        " | Descripcion: " + descripcion +
                        " | Precio: " + precio;
    }
}
