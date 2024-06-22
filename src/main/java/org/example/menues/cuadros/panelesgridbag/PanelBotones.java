package org.example.menues.cuadros.panelesgridbag;

import org.example.menues.enums.Tarea;

import javax.swing.*;
import java.awt.*;

public class PanelBotones extends JPanel {

    private final JButton BOTON_GUARDAR = new JButton("Guardar");
    private final JButton BOTON_BUSCAR = new JButton("Buscar");
    private final JButton BOTON_BORRAR = new JButton("Borrar");

    public PanelBotones(Tarea tarea, JButton botonVolver) {
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        switch (tarea){
            case CREAR -> this.add(BOTON_GUARDAR);
            case BUSCAR -> this.add(BOTON_BUSCAR);
            case BORRAR -> this.add(BOTON_BORRAR);
            default -> {}
        }
        this.add(botonVolver);
    }

    @Override
    protected void paintComponent(Graphics fondo) {}

    public JButton getBotonGuardar() {
        return BOTON_GUARDAR;
    }

    public JButton getBotonoBuscar() {
        return BOTON_BUSCAR;
    }

    public JButton getBotonBorrar() {
        return BOTON_BORRAR;
    }
}
