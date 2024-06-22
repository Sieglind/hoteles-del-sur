package org.example.menues.cuadros.cuadroscaja.tareas.impl;

import org.example.menues.acciones.AccionVolver;
import org.example.menues.cuadros.cuadroscaja.CuadroBotonesZocalo;
import org.example.menues.cuadros.cuadroscaja.CuadroCajaCustom;
import org.example.menues.cuadros.cuadroscaja.tareas.Tareas;
import org.example.menues.enums.Entidad;
import org.example.menues.enums.Tarea;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Servicio;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.List;

public class TareasServicio extends CuadroCajaCustom implements Tareas {

    //Componentes de la Interfaz
    private final JLabel ETIQUETA_NOMBRE = crearEtiqueta("Ingrese el Nombre: ");
    private final JTextField CAMPO_NOMBRE = crearCampoDeTexto();
    private final JLabel ETIQUETA_DESCRIPCION = crearEtiqueta("Ingrese la Descripción: ");
    private final JTextField CAMPO_DESCRIPCION = crearCampoDeTexto();
    private final JLabel ETIQUETA_PRECIO = crearEtiqueta("Ingrese el Precio: ");
    private final JTextField CAMPO_PRECIO = crearCampoDeTexto();
    private final JButton BOTON_VOLVER = crearBoton("Volver", LEFT_ALIGNMENT, new AccionVolver(Entidad.SERVICIOS.name()));

    //Constructor de la clase
    public TareasServicio(Tarea tarea) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setVisible(true);
        elegirPanel(tarea);

    }

    //Para configurar el panel
    private void elegirPanel(Tarea tarea) {

        switch (tarea) {
            case CREAR -> panelCrear();
            case ACTUALIZAR -> panelActualizar();
            case LISTAR -> panelListar();
            case BORRAR -> panelEliminar();
            case BUSCAR -> panelBuscar();
        }
    }

    //Configurar panel especifico para cada tarea correspondiente

    @Override
    public void panelCrear() {
        this.setBorder(BorderFactory.createTitledBorder("Crear Servicio"));
        limpiarCampos();
        this.add(ETIQUETA_NOMBRE);
        this.add(CAMPO_NOMBRE);
        this.add(ETIQUETA_DESCRIPCION);
        this.add(CAMPO_DESCRIPCION);
        this.add(ETIQUETA_PRECIO);
        this.add(CAMPO_PRECIO);

        JPanel zocalo = new CuadroBotonesZocalo();
        JButton guardar = new JButton("Guardar");

        zocalo.add(guardar);
        zocalo.add(BOTON_VOLVER);
        this.add(zocalo);
    }

    @Override
    public void panelBuscar() {
        this.setBorder(BorderFactory.createTitledBorder("Buscar Servicio"));
        this.add(ETIQUETA_NOMBRE);
        this.add(CAMPO_NOMBRE);

        JPanel zocalo = new CuadroBotonesZocalo();
        JButton buscar = new JButton("Buscar");

        zocalo.add(buscar);
        zocalo.add(BOTON_VOLVER);
        this.add(zocalo);
    }

    @Override
    public void panelListar() {
        this.setBorder(BorderFactory.createTitledBorder("Listar Servicios"));
        List<Servicio> servicios = Sistema.getInstance().listarServicios();

        JPanel panelServicios = new JPanel();
        panelServicios.setLayout(new BoxLayout(panelServicios, BoxLayout.Y_AXIS));
        servicios.forEach(servicio -> {
            JPanel panelServicio = new JPanel();
            panelServicio.setBorder(new LineBorder(Color.BLACK, 1));
            JLabel nombre = new JLabel("Nombre" + servicio.getNombre());
            JLabel descripcion = new JLabel("Descripcion: " + servicio.getDescripcion());
            JLabel precio = new JLabel("Precio: " + servicio.getPrecio());
            panelServicio.add(nombre);
            panelServicio.add(descripcion);
            panelServicio.add(precio);
            panelServicio.setVisible(true);
            dimensionarCompomente(panelServicio, LEFT_ALIGNMENT);
            panelServicios.add(panelServicio);
        });

        JScrollPane contenedorDeLista = new JScrollPane(panelServicios);
        this.add(contenedorDeLista);

        JPanel zocalo = new CuadroBotonesZocalo();
        zocalo.add(BOTON_VOLVER);
        this.add(zocalo);
    }

    @Override
    public void panelActualizar() {
        this.setBorder(BorderFactory.createTitledBorder("Actualizar Servicio"));
        this.add(ETIQUETA_NOMBRE);
        this.add(CAMPO_NOMBRE);

        JPanel zocalo = new CuadroBotonesZocalo();
        JButton buscar = new JButton("Buscar");

        zocalo.add(buscar);

        this.add(ETIQUETA_DESCRIPCION);
        this.add(CAMPO_DESCRIPCION);
        this.add(ETIQUETA_PRECIO);
        this.add(CAMPO_PRECIO);

        JButton actualizar = new JButton("Actualizar");

        zocalo.add(actualizar);
        zocalo.add(BOTON_VOLVER);
        this.add(zocalo);

    }

    @Override
    public void panelEliminar() {
        this.setBorder(BorderFactory.createTitledBorder("Eliminar Servicio"));
        this.add(ETIQUETA_NOMBRE);
        this.add(CAMPO_NOMBRE);

        JPanel zocalo = new CuadroBotonesZocalo();

        JButton buscar = new JButton("Buscar");

        zocalo.add(buscar);

        JButton eliminar = new JButton("Eliminar");

        zocalo.add(eliminar);
        zocalo.add(BOTON_VOLVER);
        this.add(zocalo);
    }

    private void limpiarCampos() {
        CAMPO_NOMBRE.setText("");
        CAMPO_DESCRIPCION.setText("");
        CAMPO_PRECIO.setText("");
    }

    private JLabel crearEtiqueta(String texto) {
        return crearEtiqueta(texto, Component.LEFT_ALIGNMENT);
    }

    private JTextField crearCampoDeTexto() {
        return crearCampoDeTexto(LEFT_ALIGNMENT);
    }


}
