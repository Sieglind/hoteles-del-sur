package org.example.menues.acciones.servicios;

import org.example.menues.paneles.panelesgridbag.PanelDeEntradas;
import org.example.sistema.Sistema;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccionBorrarServicio implements ActionListener {
    private PanelDeEntradas panelDeEntradas;

    public AccionBorrarServicio(PanelDeEntradas panelDeEntradas) {
        this.panelDeEntradas = panelDeEntradas;

    }


    public void actionPerformed(ActionEvent evento) {
        try{
            String clave = panelDeEntradas.obtenerCampo();
            Sistema.getInstance().borrarServicio(clave);
            JOptionPane.showMessageDialog(panelDeEntradas.getParent(), "Servicio eliminado con exito " + clave);
        }catch(Exception excepcion){
            JOptionPane.showMessageDialog(panelDeEntradas.getParent(),excepcion.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}
