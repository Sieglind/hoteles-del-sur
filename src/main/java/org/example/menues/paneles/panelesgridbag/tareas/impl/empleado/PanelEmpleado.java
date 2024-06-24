package org.example.menues.paneles.panelesgridbag.tareas.impl.empleado;
import org.example.menues.paneles.panelesgridbag.PanelCustom;
import org.example.sistema.entidades.persona.Empleado;
import org.example.sistema.enums.Cargo;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;

public class PanelEmpleado extends PanelCustom {

    private final JTextField CAMPO_DNI = crearCampoDeTexto();
    private final JTextField CAMPO_NOMBRE = crearCampoDeTexto();
    private final JTextField CAMPO_APELLIDO = crearCampoDeTexto();
    private final JComboBox<Cargo> LISTA_CARGO = new JComboBox<>(Cargo.values());

    public PanelEmpleado(boolean editable) {
        this.setVisible(editable);
        dimensionarCompomente(LISTA_CARGO);
        this.add(crearEtiqueta("DNI:"));
        this.add(this.CAMPO_DNI);
        this.add(crearEtiqueta("Nombre:"));
        this.add(this.CAMPO_NOMBRE);
        this.add(crearEtiqueta("Apellido:"));
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
        this.add(crearEtiqueta("Cargo:"));
        this.add(this.LISTA_CARGO);
    }

    @Override
    protected void paintComponent(Graphics fondo) {}

    public void llenarCampos (Empleado empleado) {
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

    public void habilitarEdicion() {
        this.CAMPO_NOMBRE.setEnabled(true);
        this.CAMPO_APELLIDO.setEnabled(true);
        this.LISTA_CARGO.setEnabled(true);
    }
}
