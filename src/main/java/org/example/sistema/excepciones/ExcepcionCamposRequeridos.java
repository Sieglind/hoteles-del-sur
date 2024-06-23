package org.example.sistema.excepciones;

public class ExcepcionCamposRequeridos extends Exception {

    private static final String ERROR_CAMPO_FALTANTE = "Complete los siguientes campos: ";

    public ExcepcionCamposRequeridos(String campos) {
        super(ERROR_CAMPO_FALTANTE + campos);
    }
}