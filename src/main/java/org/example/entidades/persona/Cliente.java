package org.example.entidades.persona;

import org.example.enums.Segmento;

public class Cliente extends Persona{

    private Segmento segmento;

    public Cliente(String nombre, String apellido, String dni, Segmento segmento) {
        super(nombre, apellido, dni);
        this.segmento = segmento;
    }

    public Segmento getSegmento() {
        return segmento;
    }

    public void setSegmento(Segmento segmento) {
        this.segmento = segmento;
    }




}