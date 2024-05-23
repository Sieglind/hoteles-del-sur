package org.example;

import org.example.menues.HotelDelSurLanding;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HotelDelSurLanding frame = new HotelDelSurLanding();
                frame.setSize(800, 600);
                frame.setVisible(true);
            }
        });
    }
}