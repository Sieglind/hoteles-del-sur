package org.example.menues.paneles.panelesgridbag.tareas.impl.servicio;

import org.example.menues.paneles.panelesgridbag.PanelCustom;
import org.example.sistema.entidades.Servicio;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelServicio extends PanelCustom {

    private final JTextField CAMPO_CATEGORIA = crearCampoDeTexto();
    private final JTextField CAMPO_DESCRIPCION = crearCampoDeTexto();
    private final JTextField CAMPO_PRECIO = crearCampoDeTexto();
    private final JTextField CAMPO_CODIGO = crearCampoDeTexto();

    public PanelServicio(boolean editable) {

        this.setVisible(editable);
        this.add(crearEtiqueta("Codigo:"));
        this.add(this.CAMPO_CODIGO);
        this.add(crearEtiqueta("Categoria:"));
        this.add(this.CAMPO_CATEGORIA);
        this.add(crearEtiqueta("Descripcion:"));
        this.add(this.CAMPO_DESCRIPCION);
        this.add(crearEtiqueta("Precio:"));
        this.add(this.CAMPO_PRECIO);

        if (!editable) {
            this.CAMPO_CATEGORIA.setEnabled(false);
            this.CAMPO_CATEGORIA.setDisabledTextColor(Color.BLACK);
            this.CAMPO_DESCRIPCION.setEnabled(false);
            this.CAMPO_DESCRIPCION.setDisabledTextColor(Color.BLACK);
            this.CAMPO_PRECIO.setEnabled(false);
            this.CAMPO_PRECIO.setDisabledTextColor(Color.BLACK);
            this.CAMPO_CODIGO.setEnabled(false);
            this.CAMPO_CODIGO.setDisabledTextColor(Color.BLACK);
        }

    }

    @Override
    protected void paintComponent(Graphics fondo) {
    }

    public void rellenarValor(Servicio servicio) {
        Border border = new LineBorder(Color.BLACK, 3);
        this.setBorder(new TitledBorder(border, "Resultados"));
        this.CAMPO_CATEGORIA.setText(servicio.getCategoria());
        this.CAMPO_DESCRIPCION.setText(servicio.getDescripcion());
        this.CAMPO_PRECIO.setText(String.valueOf(servicio.getPrecio()));
        this.CAMPO_CODIGO.setText(String.valueOf(servicio.getCodigo()));
        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }

    public Servicio crearServicio() {
        return new Servicio(
                CAMPO_CODIGO.getText(),
                CAMPO_CATEGORIA.getText(),
                CAMPO_DESCRIPCION.getText(),
                CAMPO_PRECIO.getColumns()
                );
    }

    public void habilitarEdicion() {
        this.CAMPO_CATEGORIA.setEnabled(true);
        this.CAMPO_DESCRIPCION.setEnabled(true);
        this.CAMPO_PRECIO.setEnabled(true);
    }
}
