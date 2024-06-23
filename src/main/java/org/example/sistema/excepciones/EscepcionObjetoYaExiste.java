package org.example.sistema.excepciones;

public class EscepcionObjetoYaExiste extends Exception{

    private static final String MENSAJE_ERROR = "El registro ya existe: ";

    public EscepcionObjetoYaExiste(Object objeto){
        super(MENSAJE_ERROR + objeto);
    }
}
