package org.example.menues.paneles.panelesgridbag;

import javax.swing.*;
import java.awt.*;

public class PanelDeEntradas extends PanelCustom {

    private final JTextField CAMPO = crearCampoDeTexto();


    public PanelDeEntradas(boolean completo, String etiqueta) {
        JLabel ETIQUETA = crearEtiqueta(etiqueta);
        if (completo) {
            this.add(ETIQUETA);
            this.add(CAMPO);
        }
    }

    @Override
    protected void paintComponent(Graphics fondo) {
    }

    public String obtenerCampo() {
        return CAMPO.getText();
    }

}
