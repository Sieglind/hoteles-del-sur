package org.example.sistema.excepciones;

public class ObjetoYaExisteExcepcion extends Exception{

    private static final String MENSAJE_ERROR = "El registro ya existe: ";

    public ObjetoYaExisteExcepcion(Object objeto){
        super(MENSAJE_ERROR + objeto);
    }
}
