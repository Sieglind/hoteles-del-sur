package org.example.menues.paneles.panelesgridbag;

import org.example.menues.enums.Tarea;

import javax.swing.*;
import java.awt.*;

public class PanelBotones extends JPanel {

    private final JButton BOTON_GUARDAR = new JButton("Guardar");
    private final JButton BOTON_BUSCAR = new JButton("Buscar");
    private final JButton BOTON_BORRAR = new JButton("Borrar");
    private final JButton BOTON_ACTUALIZAR = new JButton("Actualizar");

    public PanelBotones(Tarea tarea, JButton botonVolver) {
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        switch (tarea) {
            case CREAR -> this.add(BOTON_GUARDAR);
            case BUSCAR -> this.add(BOTON_BUSCAR);
            case BORRAR -> this.add(BOTON_BORRAR);
            case ACTUALIZAR -> {
                this.add(BOTON_BUSCAR);
                this.add(BOTON_ACTUALIZAR);
                getBotonActualizar().setEnabled(false);
            }
            default -> {
            }
        }
        this.add(botonVolver);
    }

    @Override
    protected void paintComponent(Graphics fondo) {
    }

    public JButton getBotonGuardar() {
        return BOTON_GUARDAR;
    }

    public JButton getBotonBuscar() {
        return BOTON_BUSCAR;
    }

    public JButton getBotonBorrar() {
        return BOTON_BORRAR;
    }

    public JButton getBotonActualizar() {
        return BOTON_ACTUALIZAR;
    }
}
