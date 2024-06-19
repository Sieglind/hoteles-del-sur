package org.example.menues;

import org.example.menues.cuadros.cuadroscaja.CuadroLogin;

public class HiloMenues implements Runnable {

    @Override
    public void run() {
        VentanaPrincipal ventanaPrincipal = VentanaPrincipal.obtenerVentanaPrincipal();
        ventanaPrincipal.setContentPane(new CuadroLogin());
    }
}
