package org.example.sistema.entidades;

public class Servicio {
    private final String nombre;
    private final String descripcion;
    private float precio;
    private final int clave;
    private boolean disponible;


    public Servicio(String nombre, String descripcion, float precio,int clave) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.disponible = true;
        this.clave = clave;
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

    public int getClave(){
        return clave;
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
}
