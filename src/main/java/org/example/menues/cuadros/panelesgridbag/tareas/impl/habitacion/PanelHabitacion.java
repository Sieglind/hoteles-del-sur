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
    private final JLabel ETIQUETA_NUMERO_HABITACION = crearEtiqueta("Numero de Habitacion: ");
    private final JTextField CAMPO_NUMERO_HABITACION = crearCampoDeTexto();
    private final JLabel ETIQUETA_TIPO_HABITACION = crearEtiqueta("Tipo de Habitacion: ");
    private final JComboBox<TipoDeHabitacion> CAMPO_TIPO_HABITACION = new JComboBox<>(TipoDeHabitacion.values());
    //private final JLabel disponible = crearEtiqueta("Disponible: ");
    private final JCheckBox DISPONIBILIDAD = new JCheckBox("Disponible");

    public PanelHabitacion(boolean editable) {
        this.setBorder(new TitledBorder("Habitacion"));
        this.add(ETIQUETA_NUMERO_HABITACION);
        this.add(CAMPO_NUMERO_HABITACION);
        this.add(ETIQUETA_TIPO_HABITACION);
        dimensionarCompomente(CAMPO_TIPO_HABITACION,CENTER_ALIGNMENT);
        this.add(CAMPO_TIPO_HABITACION);

        if(!editable){
            this.CAMPO_NUMERO_HABITACION.setEnabled(false);
            this.CAMPO_NUMERO_HABITACION.setDisabledTextColor(Color.BLACK);
            this.CAMPO_TIPO_HABITACION.setEnabled(false);
            this.CAMPO_TIPO_HABITACION.setSelectedItem(-1);
            this.DISPONIBILIDAD.setEnabled(false);
            this.setVisible(false);
        }
    }

    @Override
    protected void paintComponent(Graphics fondo) {

    }

    private JLabel crearEtiqueta(String texto) {
        return crearEtiqueta(texto, Component.LEFT_ALIGNMENT);
    }

    private JTextField crearCampoDeTexto() {
        return crearCampoDeTexto(CENTER_ALIGNMENT);
    }

    public Habitacion obtenerHabitacion(){
        Border border = new LineBorder(Color.BLACK,3);
        this.setBorder(new TitledBorder(border,"Resultados"));

        return new Habitacion(CAMPO_NUMERO_HABITACION.getText(), (TipoDeHabitacion) CAMPO_TIPO_HABITACION.getSelectedItem());

    }

    public void fillValues(Habitacion habitacion) {
        Border border = new LineBorder(Color.BLACK, 3);
        this.setBorder(new TitledBorder(border, "Resultados"));
        this.CAMPO_NUMERO_HABITACION.setText(habitacion.getNumeroDeHabitacion());
        this.CAMPO_TIPO_HABITACION.setSelectedItem(habitacion.getTipoDeHabitacion());
        this.DISPONIBILIDAD.setSelected(habitacion.isDisponible());
        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }

    public void eliminarCampos(){
        this.CAMPO_NUMERO_HABITACION.setText("");
        this.CAMPO_TIPO_HABITACION.setSelectedItem(-1);
        this.DISPONIBILIDAD.setSelected(false);
        this.setVisible(false);
    }
}