package org.example.menues.acciones;

import org.example.menues.VentanaPrincipal;
import org.example.menues.paneles.panelesflow.PanelDeEntidades;
import org.example.sistema.Sistema;
import org.example.sistema.excepciones.ExcepcionObjectoNoEncontrado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionLogin implements ActionListener {

    private static final String TITULO_ERROR_LOGIN = "Error de Login";
    private static final String MENSAJE_CONTRASENIA_ERRONEA = "Contraseña Invalida";
    private static final String MENSAJE_USUARIO_INVALIDO = "Usuario Invalido";
    private final JPanel parent;
    private final JTextField campoUsuario;
    private final JPasswordField campoPassword;

    public AccionLogin(JPanel parent, JTextField userField, JPasswordField passwordField) {
        this.parent = parent;
        this.campoUsuario = userField;
        this.campoPassword = passwordField;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Sistema sistema = Sistema.getInstance();
        String usuario = campoUsuario.getText();
        String password = String.valueOf(campoPassword.getPassword());
        try {
            if (sistema.login(usuario, password)) {
                VentanaPrincipal.cambiarCuadro(new PanelDeEntidades());
            } else {
                emitirError(MENSAJE_CONTRASENIA_ERRONEA);
            }
        } catch (ExcepcionObjectoNoEncontrado excepcion) {
            emitirError(MENSAJE_USUARIO_INVALIDO);
        }
    }

    private void emitirError(String mensaje) {
        JOptionPane.showMessageDialog(this.parent, mensaje, TITULO_ERROR_LOGIN, JOptionPane.ERROR_MESSAGE);
    }
}
