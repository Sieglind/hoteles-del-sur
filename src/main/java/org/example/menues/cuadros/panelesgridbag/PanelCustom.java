package org.example.menues.cuadros.panelesgridbag;

import org.example.menues.cuadros.JPanelCustom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class PanelCustom extends JPanelCustom {
    protected static final int WIDTH = 300;
    protected static final int HEIGHT = 30;
    protected static final int COLUMNS = 10;
    protected static final Dimension DIMENSION = new Dimension(WIDTH, HEIGHT);

    public PanelCustom() {
        super();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setVisible(true);
    }

    protected JLabel crearEtiqueta(String texto) {
        JLabel etiqueta = new JLabel(texto);
        dimensionarCompomente(etiqueta);
        return etiqueta;
    }

    protected JTextField crearCampoDeTexto() {
        JTextField campo = new JTextField(COLUMNS);
        dimensionarCompomente(campo);
        return campo;
    }

    protected JButton crearBoton(String texto, float alineacion, ActionListener listener) {
        JButton button = new JButton(texto);
        button.setAlignmentX(alineacion);
        button.addActionListener(listener);
        return button;
    }

    protected void dimensionarCompomente(JComponent componente) {
        componente.setMaximumSize(DIMENSION);
        componente.setAlignmentX(Component.CENTER_ALIGNMENT);
    }
}
