package org.example.menues.acciones.habitacion;

import org.example.menues.paneles.panelesgridbag.PanelDeEntradas;
import org.example.sistema.Sistema;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionBorrarHabitacion implements ActionListener {

    private PanelDeEntradas panelDeEntradas;

    public AccionBorrarHabitacion(PanelDeEntradas panelDeEntradas) {
        this.panelDeEntradas = panelDeEntradas;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String numeroDeHabitacion = panelDeEntradas.obtenerCampo();
            Sistema.getInstance().borrarHabitacion(numeroDeHabitacion);
            JOptionPane.showMessageDialog(panelDeEntradas.getParent(), "Habitacion eliminada con exito " +numeroDeHabitacion);
        }catch(Exception excepcion){
            JOptionPane.showMessageDialog(panelDeEntradas.getParent(),excepcion.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
