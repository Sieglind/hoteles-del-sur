package org.example.sistema.entidades;

public class Servicio {
    private final String nombre;
    private final String descripcion;
    private float precio;
    private final String codigo;
    private boolean disponible;


    public Servicio(String nombre, String descripcion, float precio,String codigo) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.disponible = true;
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

    public String getCodigo(){
        return codigo;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "\nServicio" +
                "/Clave: " + codigo +
                "/Nombre: " + nombre +
                "/Descripcion: " + descripcion +
                "/Precio: " + precio;
    }

}
