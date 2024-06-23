package org.example.sistema.gestor;

import org.example.sistema.excepciones.EscepcionObjectoNoEncontrado;
import org.example.sistema.excepciones.EscepcionObjetoYaExiste;

import java.util.List;

public interface IGestor<K,V> {

    K crear(V valor) throws EscepcionObjetoYaExiste;

    V buscar(K key) throws EscepcionObjectoNoEncontrado;

    List<V> listar();

    V actualizar(K key, V valor) throws EscepcionObjectoNoEncontrado;

    boolean borrar(K key) throws EscepcionObjectoNoEncontrado;
}
