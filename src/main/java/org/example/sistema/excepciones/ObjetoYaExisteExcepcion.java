package org.example.sistema.excepciones;

public class ObjetoYaExisteExcepcion extends Exception{

    public ObjetoYaExisteExcepcion(Object objeto){
        super(objeto.toString());
    }
}
