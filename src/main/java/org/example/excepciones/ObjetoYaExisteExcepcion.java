package org.example.excepciones;

public class ObjetoYaExisteExcepcion extends Exception{
    public ObjetoYaExisteExcepcion(String mensaje){
        super(mensaje);
    }
}
