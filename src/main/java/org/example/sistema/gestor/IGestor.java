package org.example.sistema.gestor;

import org.example.sistema.excepciones.ExcepcionObjectoNoEncontrado;
import org.example.sistema.excepciones.ExcepcionObjetoYaExiste;

import java.util.List;

public interface IGestor<K,V> {

    K crear(V valor) throws ExcepcionObjetoYaExiste;

    V buscar(K key) throws ExcepcionObjectoNoEncontrado;

    List<V> listar();

    V actualizar(K key, V valor) throws ExcepcionObjectoNoEncontrado;

    boolean borrar(K key) throws ExcepcionObjectoNoEncontrado;
}
