package org.example.entidades.persona;

public abstract class Persona {
    // private final String id;
    private final String nombre;
    private final String apellido;
    private final String dni;

    private boolean deleted = false;

    public Persona(String nombre, String apellido, String dni) {
        //TODO this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

//    public String getId() {
//        return id;
//    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}