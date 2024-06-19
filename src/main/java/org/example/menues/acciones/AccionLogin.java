package org.example.menues.acciones;

import org.example.sistema.excepciones.ObjectoNoEncontradoExcepcion;
import org.example.sistema.Sistema;
import org.example.menues.VentanaPrincipal;
import org.example.menues.cuadros.cuadrosflow.CuadroDeEntidades;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionLogin implements ActionListener {

    private final JPanel parent;
    private final JTextField campoUsuario;
    private final JPasswordField campoPassword;

    private static final String TITULO_ERROR_LOGIN = "Error de Login";
    private static final String MENSAJE_CONTRASENIA_ERRONEA = "Contraseña Invalida";
    private static final String MENSAJE_USUARIO_INVALIDO = "Usuario Invalido";

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
                VentanaPrincipal.cambiarCuadro(new CuadroDeEntidades());
            } else {
                emitirError(MENSAJE_CONTRASENIA_ERRONEA);
            }
        } catch (ObjectoNoEncontradoExcepcion excepcion) {
            emitirError(MENSAJE_USUARIO_INVALIDO);
        }
    }

    private void emitirError(String mensaje){
        JOptionPane.showMessageDialog(this.parent, mensaje, TITULO_ERROR_LOGIN, JOptionPane.ERROR_MESSAGE);
    }
}
