package org.example.menues.acciones.habitacion;

import org.example.menues.cuadros.panelesgridbag.PanelDeEntradas;
import org.example.sistema.Sistema;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionEliminarHabitacion implements ActionListener {

    private PanelDeEntradas panelDeEntradas;

    public AccionEliminarHabitacion(PanelDeEntradas panelDeEntradas) {
        this.panelDeEntradas = panelDeEntradas;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String numeroDeHabitacion = panelDeEntradas.obtenerCampo();
            Sistema.getInstance().eliminarHabitacion(numeroDeHabitacion);
            JOptionPane.showMessageDialog(null, "Habitacion eliminada con exito " +numeroDeHabitacion);
        }catch(Exception excecion){
            JOptionPane.showMessageDialog(panelDeEntradas.getParent(),excecion.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
