package org.example.menues.cuadros.cuadroscaja;

import javax.swing.*;
import java.awt.*;

public class PanelDeEntradas extends CuadroCajaCustom {

    private final JLabel ETIQUETA_DNI = crearEtiqueta("DNI:");
    private final JTextField CAMPO_DNI = crearCampoDeTexto();

    public PanelDeEntradas(boolean completo) {
        if (completo){
            this.add(ETIQUETA_DNI);
            this.add(CAMPO_DNI);
        }
    }

    @Override
    protected void paintComponent(Graphics fondo) {}

    private JLabel crearEtiqueta(String texto){
        return crearEtiqueta(texto,Component.CENTER_ALIGNMENT);
    }

    private JTextField crearCampoDeTexto(){
        return crearCampoDeTexto(CENTER_ALIGNMENT);
    }

    public String getCampoDni() {
        return CAMPO_DNI.getText();
    }
}
