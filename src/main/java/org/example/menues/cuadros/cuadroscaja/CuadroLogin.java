package org.example.menues.cuadros.cuadroscaja;

import org.example.menues.acciones.AccionLogin;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class CuadroLogin extends CuadroCajaCustom {

    private final TitledBorder border = BorderFactory.createTitledBorder("Login");
    private final JLabel bienvenida = createLabel("Bienvenido");
    private final JLabel etiquetaUsuario = createLabel("Usuario:");
    private final JTextField campoUsuario = new JTextField(COLUMNS);
    private final JLabel etiquetaPassword = createLabel("Password:");
    private final JPasswordField campoPassword = new JPasswordField(COLUMNS);

    public CuadroLogin() {
        super();
        setupPanel();
    }

    private void setupPanel() {
        this.setBorder(border);
        bienvenida.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(bienvenida);
        this.add(etiquetaUsuario);
        campoUsuario.setMaximumSize(DIMENSION);
        this.add(campoUsuario);
        this.add(etiquetaPassword);
        campoPassword.setMaximumSize(DIMENSION);
        this.add(campoPassword);
        this.add(ESPACIO);
        this.add(createButton("Enviar", new AccionLogin(this, campoUsuario, campoPassword)));
    }

    private JLabel createLabel(String texto) {
        return createLabel(texto, CENTER_ALIGNMENT);
    }

}
