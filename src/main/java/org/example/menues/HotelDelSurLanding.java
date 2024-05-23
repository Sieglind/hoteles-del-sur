package org.example.menues;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelDelSurLanding extends JFrame {
    private JPanel  pane1;
    private JPasswordField passwordField1;
    private JFormattedTextField formattedTextField1;
    private JButton submitLoginButton;
    private JButton salirButton;
    private JLabel bienvenida;

    public HotelDelSurLanding() {
        super("Hotel del Sur");
        setContentPane(pane1);
        submitLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hice click");
            }
        });
    }
}
