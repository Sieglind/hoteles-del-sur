package org.example.sistema.excepciones;

public class ExcepcionObjectoNoEncontrado extends Exception {

    private final static String MENSAJE_NO_ENCONTRADO = "No hubo resultados para: ";

    public ExcepcionObjectoNoEncontrado(String parametro) {
        super(MENSAJE_NO_ENCONTRADO + parametro);
    }
}
