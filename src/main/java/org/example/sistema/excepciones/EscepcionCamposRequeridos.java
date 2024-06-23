package org.example.sistema.excepciones;

public class EscepcionCamposRequeridos extends Exception {

    private static final String ERROR_CAMPO_FALTANTE = "Complete los siguientes campos: ";

    public EscepcionCamposRequeridos(String campos) {
        super(ERROR_CAMPO_FALTANTE + campos);
    }
}