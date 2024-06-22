package org.example.menues.cuadros.cuadroscaja;

import org.example.sistema.entidades.Servicio;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelServicio extends CuadroCajaCustom{

    private final JLabel ETIQUETA_NOMBRE = crearEtiqueta("Nombre:");
    private final JTextField CAMPO_NOMBRE = crearCampoDeTexto();
    private final JLabel ETIQUETA_DESCRIPCION = crearEtiqueta("Descripcion:");
    private final JTextField CAMPO_DESCRIPCION = crearCampoDeTexto();
    private final JLabel ETIQUETA_PRECIO = crearEtiqueta("Precio:");
    private final JTextField CAMPO_PRECIO = crearCampoDeTexto();
    private final JLabel ETIQUETA_CLAVE = crearEtiqueta("Clave:");
    private final JTextField CAMPO_CLAVE = crearCampoDeTexto();

    public PanelServicio(boolean editable) {

        this.setVisible(editable);

        this.add(this.ETIQUETA_NOMBRE);
        this.add(this.CAMPO_NOMBRE);
        this.add(this.ETIQUETA_DESCRIPCION);
        this.add(this.CAMPO_DESCRIPCION);
        this.add(this.ETIQUETA_PRECIO);
        this.add(this.CAMPO_PRECIO);
        this.add(this.ETIQUETA_CLAVE);
        this.add(this.CAMPO_CLAVE);

        if(!editable){
            this.CAMPO_NOMBRE.setEnabled(false);
            this.CAMPO_NOMBRE.setDisabledTextColor(Color.BLACK);
            this.CAMPO_DESCRIPCION.setEnabled(false);
            this.CAMPO_DESCRIPCION.setDisabledTextColor(Color.BLACK);
            this.CAMPO_PRECIO.setEnabled(false);
            this.CAMPO_PRECIO.setDisabledTextColor(Color.BLACK);
            this.CAMPO_CLAVE.setEnabled(false);
            this.CAMPO_CLAVE.setDisabledTextColor(Color.BLACK);
        }

    }

    @Override
    protected void paintComponent(Graphics fondo) {
        this.setBackground(Color.WHITE);
        this.setOpaque(true);
    }

    private JLabel crearEtiqueta(String texto){
        return crearEtiqueta(texto,Component.CENTER_ALIGNMENT);
    }

    private JTextField crearCampoDeTexto(){
        return crearCampoDeTexto(Component.CENTER_ALIGNMENT);
    }

    public void fillValues(Servicio servicio){
        Border border = new LineBorder(Color.BLACK,3);
        this.setBorder(new TitledBorder(border,"Resultados"));
        this.CAMPO_NOMBRE.setText(servicio.getNombre());
        this.CAMPO_DESCRIPCION.setText(servicio.getDescripcion());
        this.CAMPO_PRECIO.setText(String.valueOf(servicio.getPrecio()));
        this.CAMPO_CLAVE.setText(String.valueOf(servicio.getClave()));
        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }

}
