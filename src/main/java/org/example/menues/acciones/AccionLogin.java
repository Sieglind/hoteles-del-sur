package org.example.menues.acciones;

import org.example.sistema.excepciones.ObjectoNoEncontradoExcepcion;
import org.example.sistema.Sistema;
import org.example.menues.VentanaPrincipal;
import org.example.menues.cuadros.cuadrosflow.CuadroTareas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionLogin implements ActionListener {
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
        String usuario = campoUsuario.getText(); //El usuario que es escribio en el campito usuario
        String password = String.valueOf(campoPassword.getPassword()); //Idem pero con password
        try {
            if (sistema.login(usuario, password)) {
                VentanaPrincipal.cambiarCuadroEnVentanaPrincipal(new CuadroTareas());
            } else {
                JOptionPane.showMessageDialog(this.parent,
                        "Contraseña incorrecta",
                        "Error de Login", JOptionPane.ERROR_MESSAGE);
            }
        } catch (ObjectoNoEncontradoExcepcion excepcion) {
            JOptionPane.showMessageDialog(this.parent,
                    "Ese usuario no existe",
                    "Error de Login", JOptionPane.ERROR_MESSAGE);
        }
    }
}
