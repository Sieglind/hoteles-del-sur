package org.example.menues.paneles.panelesgridbag;

import org.example.menues.acciones.AccionLogin;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class PanelLogin extends PanelCustom {

    private final TitledBorder border = BorderFactory.createTitledBorder("Login");
    private final JLabel bienvenida = crearEtiqueta("Bienvenido");
    private final JLabel etiquetaUsuario = crearEtiqueta("Usuario:");
    private final JTextField campoUsuario = crearCampoDeTexto();
    private final JLabel etiquetaPassword = crearEtiqueta("Password:");
    private final JPasswordField campoPassword = new JPasswordField(COLUMNS);

    public PanelLogin() {
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
        this.add(crearBoton("Enviar", CENTER_ALIGNMENT, new AccionLogin(this, campoUsuario, campoPassword)));
    }
}
