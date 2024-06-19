package org.example.menues.cuadros.cuadroscaja;

import javax.swing.*;
import java.awt.*;

public class CuadroBotonesZocalo extends JPanel {
    public CuadroBotonesZocalo() {
        super();
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setAlignmentX(LEFT_ALIGNMENT);
        this.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics fondo) {}
}
