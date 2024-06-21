package org.example.sistema.excepciones;

public class ObjectoNoEncontradoExcepcion extends Exception{

    private final String parametro;

    public ObjectoNoEncontradoExcepcion(String parametro){
        super();
        this.parametro = parametro;
    }
}
