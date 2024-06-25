package org.example.sistema.excepciones;

import java.time.LocalDate;

public class ExcepcionFechasNoValidas extends Exception{
    private static final String ERROR_FECHAS_NO_VALIDAS= "La fecha no es valida";

    public ExcepcionFechasNoValidas() {
        super(ERROR_FECHAS_NO_VALIDAS);
    }
}
