package org.example.sistema.excepciones;

public class EscepcionObjectoNoEncontrado extends Exception{

    private final static String MENSAJE_NO_ENCONTRADO = "No hubo resultados para: ";

    public EscepcionObjectoNoEncontrado(String parametro){
        super(MENSAJE_NO_ENCONTRADO + parametro);
    }
}
