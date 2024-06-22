package org.example.menues.cuadros.panelesgridbag.tareas.impl.cliente;

import org.example.menues.cuadros.panelesgridbag.PanelCustom;
import org.example.sistema.entidades.persona.Cliente;
import org.example.sistema.enums.Segmento;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelCliente extends PanelCustom {

    private final JLabel ETIQUETA_DNI = crearEtiqueta("DNI:");
    private final JTextField CAMPO_DNI = crearCampoDeTexto();
    private final JLabel EIQUETA_NOMBRE = crearEtiqueta("Nombre:");
    private final JTextField CAMPO_NOMBRE = crearCampoDeTexto();
    private final JLabel ETIQUETA_APELLIDO = crearEtiqueta("Apellido:");
    private final JTextField CAMPO_APELLIDO = crearCampoDeTexto();
    private final JLabel SEGMENTO = crearEtiqueta("Segmento:");
    private final JComboBox<Segmento> LISTA_SEGMENTO = new JComboBox<>(Segmento.values());

    public PanelCliente(boolean editable) {
        this.setVisible(editable);
        dimensionarCompomente(LISTA_SEGMENTO, CENTER_ALIGNMENT);
        this.add(this.ETIQUETA_DNI);
        this.add(this.CAMPO_DNI);
        this.add(this.EIQUETA_NOMBRE);
        this.add(this.CAMPO_NOMBRE);
        this.add(this.ETIQUETA_APELLIDO);
        this.add(this.CAMPO_APELLIDO);
        if (!editable) {
            this.CAMPO_DNI.setEnabled(false);
            this.CAMPO_DNI.setDisabledTextColor(Color.BLACK);
            this.CAMPO_NOMBRE.setEnabled(false);
            this.CAMPO_NOMBRE.setDisabledTextColor(Color.BLACK);
            this.CAMPO_APELLIDO.setEnabled(false);
            this.CAMPO_APELLIDO.setDisabledTextColor(Color.BLACK);
            this.LISTA_SEGMENTO.setEnabled(false);
            this.LISTA_SEGMENTO.setSelectedIndex(-1);
        }
        this.add(this.SEGMENTO);
        this.add(this.LISTA_SEGMENTO);
    }

    @Override
    protected void paintComponent(Graphics fondo) {
    }

    private JLabel crearEtiqueta(String texto) {
        return crearEtiqueta(texto, Component.CENTER_ALIGNMENT);
    }

    private JTextField crearCampoDeTexto() {
        return crearCampoDeTexto(CENTER_ALIGNMENT);
    }

    public void fillValues(Cliente cliente) {
        Border border = new LineBorder(Color.BLACK, 3);
        this.setBorder(new TitledBorder(border, "Resultados"));
        this.CAMPO_DNI.setText(cliente.getDni());
        this.CAMPO_NOMBRE.setText(cliente.getNombre());
        this.CAMPO_APELLIDO.setText(cliente.getApellido());
        this.LISTA_SEGMENTO.setSelectedItem(cliente.getSegmento());
        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }

    public Cliente obtenerCliente() {
        return new Cliente(
                CAMPO_NOMBRE.getText(),
                CAMPO_APELLIDO.getText(),
                CAMPO_DNI.getText(),
                (Segmento) LISTA_SEGMENTO.getSelectedItem());
    }
}
