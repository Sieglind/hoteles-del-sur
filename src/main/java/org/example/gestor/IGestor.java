package org.example.gestor;

import org.example.excepciones.ObjectoNoEncontradoExcepcion;
import org.example.excepciones.ObjetoYaExisteExcepcion;

import java.util.List;

public interface IGestor<K,V> {

    K crear(V valor) throws ObjetoYaExisteExcepcion;

    V buscar(K key) throws ObjectoNoEncontradoExcepcion;

    List<V> buscarTodos();

    V actualizar(K key, V valor) throws ObjectoNoEncontradoExcepcion;

    boolean eliminar(K key) throws ObjectoNoEncontradoExcepcion;
}
