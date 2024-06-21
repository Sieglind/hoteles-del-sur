package org.example.sistema.excepciones;

public class ObjectoNoEncontradoExcepcion extends Exception{

    private final static String MENSAJE_NO_ENCONTRADO = "No hubo resultados para: ";

    public ObjectoNoEncontradoExcepcion(String parametro){
        super(MENSAJE_NO_ENCONTRADO + parametro);
    }
}
