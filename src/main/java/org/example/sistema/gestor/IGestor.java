package org.example.sistema.gestor;

import org.example.sistema.excepciones.ObjectoNoEncontradoExcepcion;
import org.example.sistema.excepciones.ObjetoYaExisteExcepcion;

import java.util.List;

public interface IGestor<K,V> {

    K crear(V valor) throws ObjetoYaExisteExcepcion;

    V buscar(K key) throws ObjectoNoEncontradoExcepcion;

    List<V> buscarTodos();

    V actualizar(K key, V valor) throws ObjectoNoEncontradoExcepcion;

    boolean eliminar(K key) throws ObjectoNoEncontradoExcepcion;
}
