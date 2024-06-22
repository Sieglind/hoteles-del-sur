package org.example.menues.acciones.empleado;

import org.example.menues.cuadros.panelesgridbag.PanelDeEntradas;
import org.example.sistema.Sistema;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionEliminarEmpleado implements ActionListener {
    private PanelDeEntradas panelDeEntradas;

    public AccionEliminarEmpleado(PanelDeEntradas panelDeEntradas) {
        this.panelDeEntradas = panelDeEntradas;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            String dni = panelDeEntradas.obtenerCampo();
            Sistema.getInstance().eliminarEmpleado(dni);
            JOptionPane.showMessageDialog(panelDeEntradas.getParent(), "Empleado eliminada con exito " + dni);
        }catch(Exception excepcion){
            JOptionPane.showMessageDialog(panelDeEntradas.getParent(),excepcion.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
