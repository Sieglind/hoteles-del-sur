package org.example.sistema.entidades.persona;

import org.example.sistema.enums.Segmento;

public class Cliente extends Persona{

    private final Segmento segmento;

    public Cliente(String nombre, String apellido, String dni, Segmento segmento) {
        super(nombre, apellido, dni);
        this.segmento = segmento;
    }

    public Segmento getSegmento() {
        return segmento;
    }

    @Override
    public String toString() {
        return super.toString() + " | Segmento: " + this.segmento;
    }
}