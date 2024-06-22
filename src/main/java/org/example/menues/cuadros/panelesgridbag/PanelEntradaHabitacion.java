package org.example.menues.cuadros.panelesgridbag;

import javax.swing.*;
import java.awt.*;

public class PanelEntradaHabitacion extends PanelCustom {
    private final JLabel ETIQUETA_NROHABITACION =crearEtiqueta("Numero de Habitacion");
    private final JTextField NROHABITACION = crearCampoDeTexto();

    public PanelEntradaHabitacion(boolean completo) {
        if(completo){
            this.add(ETIQUETA_NROHABITACION);
            this.add(NROHABITACION);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {}

    private JLabel crearEtiqueta (String texto) {
        return crearEtiqueta(texto,Component.CENTER_ALIGNMENT);
    }

    private JTextField crearCampoDeTexto() {
        return crearCampoDeTexto(CENTER_ALIGNMENT);
    }

    public String getNroHabitacion() {
        return NROHABITACION.getText();
    }

    public String obtenerNumeroHabitacion() {
        return NROHABITACION.getText();
    }
}
