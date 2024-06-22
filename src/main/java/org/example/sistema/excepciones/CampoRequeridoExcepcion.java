package org.example.sistema.excepciones;

public class CampoRequeridoExcepcion extends Exception {

    private static final String ERROR_CAMPO_FALTANTE = "Complete los siguientes campos: ";

    public CampoRequeridoExcepcion(String campos) {
        super(ERROR_CAMPO_FALTANTE + campos);
    }
}