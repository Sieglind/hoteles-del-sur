package org.example.sistema.entidades;

public class Servicio {

    private final String codigo;
    private final String categoria;
    private final String descripcion;
    private final float precio;

    public Servicio(String codigo, String categoria, String descripcion, float precio) {
        this.codigo = codigo;
        this.categoria = categoria;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getCategoria() {
        return categoria;
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
                        " | " + categoria +
                        " | Descripcion: " + descripcion +
                        " | Precio: " + precio;
    }
}
