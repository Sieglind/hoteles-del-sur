package org.example.menues.acciones.empleado;

import org.example.menues.paneles.panelesgridbag.PanelDeEntradas;
import org.example.sistema.Sistema;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionBorrarEmpleado implements ActionListener {
    private PanelDeEntradas panelDeEntradas;

    public AccionBorrarEmpleado(PanelDeEntradas panelDeEntradas) {
        this.panelDeEntradas = panelDeEntradas;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String dni = panelDeEntradas.obtenerCampo();
            Sistema.getInstance().borrarEmpleado(dni);
            JOptionPane.showMessageDialog(panelDeEntradas.getParent(), "Empleado eliminado con exito " + dni);
        }catch(Exception excepcion){
            JOptionPane.showMessageDialog(panelDeEntradas.getParent(),excepcion.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
