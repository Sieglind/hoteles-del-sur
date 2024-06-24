package org.example.sistema.excepciones;

public class ExcepcionObjetoYaExiste extends Exception {

    private static final String MENSAJE_ERROR = "El registro ya existe: ";

    public ExcepcionObjetoYaExiste(Object objeto) {
        super(MENSAJE_ERROR + objeto);
    }
}
