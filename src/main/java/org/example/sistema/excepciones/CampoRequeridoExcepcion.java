package org.example.sistema.excepciones;

public class CampoRequeridoExcepcion extends Exception {

    public CampoRequeridoExcepcion(String campo) {
        super("\nDebe completar el/los siguientes campos: " + campo);
    }
}