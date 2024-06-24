package org.example.menues.paneles.panelesgridbag.tareas.impl.servicio;

import org.example.menues.paneles.panelesgridbag.PanelCustom;
import org.example.sistema.entidades.Servicio;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelServicio extends PanelCustom {

    private final JTextField CAMPO_NOMBRE = crearCampoDeTexto();
    private final JTextField CAMPO_DESCRIPCION = crearCampoDeTexto();
    private final JTextField CAMPO_PRECIO = crearCampoDeTexto();
    private final JTextField CAMPO_CLAVE = crearCampoDeTexto();

    public PanelServicio(boolean editable) {

        this.setVisible(editable);
        this.add(crearEtiqueta("Nombre:"));
        this.add(this.CAMPO_NOMBRE);
        this.add(crearEtiqueta("Descripcion:"));
        this.add(this.CAMPO_DESCRIPCION);
        this.add(crearEtiqueta("Precio:"));
        this.add(this.CAMPO_PRECIO);
        this.add(crearEtiqueta("Clave:"));
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
    protected void paintComponent(Graphics fondo) {}

    public void rellenarValor(Servicio servicio){
        Border border = new LineBorder(Color.BLACK,3);
        this.setBorder(new TitledBorder(border,"Resultados"));
        this.CAMPO_NOMBRE.setText(servicio.getNombre());
        this.CAMPO_DESCRIPCION.setText(servicio.getDescripcion());
        this.CAMPO_PRECIO.setText(String.valueOf(servicio.getPrecio()));
        this.CAMPO_CLAVE.setText(String.valueOf(servicio.getCodigo()));
        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }

    public Servicio crearServicio() {
        return new Servicio(
                CAMPO_NOMBRE.getText(),
                CAMPO_DESCRIPCION.getText(),
                CAMPO_PRECIO.getColumns(),
                CAMPO_CLAVE.getText());
    }

    public void habilitarEdicion() {
        this.CAMPO_NOMBRE.setEnabled(true);
        this.CAMPO_DESCRIPCION.setEnabled(true);
        this.CAMPO_PRECIO.setEnabled(true);
    }
}
