package org.example.menues.cuadros.cuadroscaja;
import org.example.sistema.entidades.persona.Cliente;
import org.example.sistema.entidades.persona.Empleado;
import org.example.sistema.enums.Cargo;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelEmpleado extends CuadroCajaCustom {

    private final JLabel ETIQUETA_DNI = crearEtiqueta("DNI:");
    private final JTextField CAMPO_DNI = crearCampoDeTexto();
    private final JLabel EIQUETA_NOMBRE = crearEtiqueta("Nombre:");
    private final JTextField CAMPO_NOMBRE = crearCampoDeTexto();
    private final JLabel ETIQUETA_APELLIDO = crearEtiqueta("Apellido:");
    private final JTextField CAMPO_APELLIDO = crearCampoDeTexto();
    private final JLabel CARGO = crearEtiqueta("Cargo:");
    private final JComboBox<Cargo> LISTA_CARGO = new JComboBox<>(Cargo.values());

    public PanelEmpleado(boolean editable) {
        this.setVisible(editable);
        dimensionarCompomente(LISTA_CARGO,CENTER_ALIGNMENT);
        this.add(this.ETIQUETA_DNI);
        this.add(this.CAMPO_DNI);
        this.add(this.EIQUETA_NOMBRE);
        this.add(this.CAMPO_NOMBRE);
        this.add(this.ETIQUETA_APELLIDO);
        this.add(this.CAMPO_APELLIDO);
        if(!editable){
            this.CAMPO_DNI.setEnabled(false);
            this.CAMPO_DNI.setDisabledTextColor(Color.BLACK);
            this.CAMPO_NOMBRE.setEnabled(false);
            this.CAMPO_NOMBRE.setDisabledTextColor(Color.BLACK);
            this.CAMPO_APELLIDO.setEnabled(false);
            this.CAMPO_APELLIDO.setDisabledTextColor(Color.BLACK);
            this.LISTA_CARGO.setEnabled(false);
            this.LISTA_CARGO.setSelectedIndex(-1);
        }
        this.add(this.CARGO);
        this.add(this.LISTA_CARGO);
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
        return crearCampoDeTexto(CENTER_ALIGNMENT);
    }

    public void fillValues(Empleado empleado) {
        Border border = new LineBorder(Color.BLACK,3);
        this.setBorder(new TitledBorder(border,"Resultados"));
        this.CAMPO_DNI.setText(empleado.getDni());
        this.CAMPO_NOMBRE.setText(empleado.getNombre());
        this.CAMPO_APELLIDO.setText(empleado.getApellido());
        this.LISTA_CARGO.setSelectedItem(empleado.getCargo());
        this.setVisible(true);
        this.revalidate();
        this.repaint();
    }

    public Empleado crearEmpleado(){
        return new Empleado(
                CAMPO_NOMBRE.getText(),
                CAMPO_APELLIDO.getText(),
                CAMPO_DNI.getText(),
                (Cargo) LISTA_CARGO.getSelectedItem());
    }
}
