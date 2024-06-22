package org.example.menues.cuadros.cuadroscaja;

import javax.swing.*;
import java.awt.*;

public class PanelDeEntradas extends CuadroCajaCustom {

    private final JLabel ETIQUETA_DNI = crearEtiqueta("DNI:");
    private final JTextField CAMPO_DNI = crearCampoDeTexto();
    private final JLabel ETIQUETA_CLAVE = crearEtiqueta("CLAVE:");
    private final JTextField CAMPO_CLAVE = crearCampoDeTexto();


    public PanelDeEntradas(boolean completo) {
        if (completo){
            this.add(ETIQUETA_DNI);
            this.add(CAMPO_DNI);
            this.add(ETIQUETA_CLAVE);
            this.add(CAMPO_CLAVE);
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

    public Integer getCampoClave() {
        return Integer.parseInt(CAMPO_CLAVE.getText());
    }



}
