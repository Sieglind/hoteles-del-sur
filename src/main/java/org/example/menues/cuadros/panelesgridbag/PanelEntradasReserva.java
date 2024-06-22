package org.example.menues.cuadros.panelesgridbag;

import javax.swing.*;
import java.awt.*;

public class PanelEntradasReserva extends PanelCustom {
    private final JLabel ETIQUETA_ID_RESERVA = crearEtiqueta("Id Reserva:");
    private final JTextField CAMPO_ID_RESERVA = crearCampoDeTexto();

    public PanelEntradasReserva(boolean completo) {
        if (completo) {
            this.add(ETIQUETA_ID_RESERVA);
            this.add(CAMPO_ID_RESERVA);
        }
    }

    @Override
    protected void paintComponent(Graphics fondo) {
    }

    private JLabel crearEtiqueta(String texto) {
        return crearEtiqueta(texto, Component.CENTER_ALIGNMENT);
    }

    private JTextField crearCampoDeTexto() {
        return crearCampoDeTexto(CENTER_ALIGNMENT);
    }

    public String getCampoId() {
        return CAMPO_ID_RESERVA.getText();
    }
}
