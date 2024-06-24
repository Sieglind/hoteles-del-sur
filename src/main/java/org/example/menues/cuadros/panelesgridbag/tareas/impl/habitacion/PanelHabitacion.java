package org.example.menues.cuadros.panelesgridbag.tareas.impl.habitacion;

import org.example.menues.cuadros.panelesgridbag.PanelCustom;
import org.example.sistema.entidades.Habitacion;
import org.example.sistema.enums.TipoDeHabitacion;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelHabitacion extends PanelCustom {
    private final JTextField CAMPO_NUMERO_HABITACION = crearCampoDeTexto();
    private final JComboBox<TipoDeHabitacion> CAMPO_TIPO_HABITACION = new JComboBox<>(TipoDeHabitacion.values());
    private final JTextField CAMPO_PRECIO_HABITACION = crearCampoDeTexto();
    private final JCheckBox DISPONIBILIDAD = new JCheckBox("Disponible");

    public PanelHabitacion(boolean editable) {


        this.setBorder(new TitledBorder("Habitacion"));
        this.add(crearEtiqueta("Numero de Habitacion: "));
        this.add(CAMPO_NUMERO_HABITACION);
        this.add(crearEtiqueta("Tipo de Habitacion: "));
        dimensionarCompomente(CAMPO_TIPO_HABITACION);
        this.add(CAMPO_TIPO_HABITACION);
        this.add(crearEtiqueta("Precio: "));
        dimensionarCompomente(CAMPO_PRECIO_HABITACION);
        this.add(CAMPO_PRECIO_HABITACION);

        if (!editable) {
            this.CAMPO_NUMERO_HABITACION.setEnabled(false);
            this.CAMPO_NUMERO_HABITACION.setDisabledTextColor(Color.BLACK);
            this.CAMPO_TIPO_HABITACION.setEnabled(false);
            this.CAMPO_TIPO_HABITACION.setSelectedItem(-1);
            this.DISPONIBILIDAD.setEnabled(false);
            this.setVisible(false);
        }
    }

    @Override
    protected void paintComponent(Graphics fondo) {}

    public void llenarCampos(Habitacion habitacion) {
        Border border = new LineBorder(Color.BLACK, 3);
        this.setBorder(new TitledBorder(border, "Resultados"));
        CAMPO_NUMERO_HABITACION.setText(habitacion.getNumeroDeHabitacion());
        CAMPO_TIPO_HABITACION.setSelectedItem(habitacion.getTipoDeHabitacion());
        CAMPO_PRECIO_HABITACION.setText(String.valueOf(habitacion.getPrecio()));
        this.DISPONIBILIDAD.setSelected(habitacion.isDisponible());
        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }

    public void habilitarEdicion() {
        this.CAMPO_TIPO_HABITACION.setEnabled(true);
        this.DISPONIBILIDAD.setEnabled(true);
    }

    public Habitacion crearHabitacion() {
        Habitacion habitacion = null;
        try {
            float precioHab = Float.parseFloat(CAMPO_PRECIO_HABITACION.getText());
            habitacion = new Habitacion(
                    CAMPO_NUMERO_HABITACION.getText(),
                    (TipoDeHabitacion) CAMPO_TIPO_HABITACION.getSelectedItem(), precioHab);
        } catch (NumberFormatException excepcion) {
            JOptionPane.showMessageDialog(this.getParent(), "El precio no es valido ", "Error", JOptionPane.ERROR_MESSAGE);
        }
        return habitacion;

    }
}