package org.example.gestores;

import org.example.usuarios.Cliente;

import java.util.ArrayList;
import java.util.List;

public class GestorClientes {
    private final List<Cliente> listaClientes;

    public GestorClientes() {
        this.listaClientes = new ArrayList<Cliente>();
    }

}
