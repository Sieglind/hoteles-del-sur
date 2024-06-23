package org.example.menues;

import org.example.menues.cuadros.panelesgridbag.PanelLogin;

public class HiloMenues implements Runnable {

    @Override
    public void run() {
        VentanaPrincipal ventanaPrincipal = VentanaPrincipal.obtenerVentanaPrincipal();
        ventanaPrincipal.setContentPane(new PanelLogin());
    }
}
