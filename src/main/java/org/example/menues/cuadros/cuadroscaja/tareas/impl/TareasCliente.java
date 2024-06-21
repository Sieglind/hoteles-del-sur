package org.example.menues.cuadros.cuadroscaja.tareas.impl;

import org.example.menues.acciones.AccionVolver;
import org.example.menues.acciones.cliente.AccionBuscarCliente;
import org.example.menues.cuadros.cuadroscaja.*;
import org.example.menues.cuadros.cuadroscaja.tareas.Tareas;
import org.example.menues.enums.Entidad;
import org.example.menues.enums.Tarea;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.persona.Cliente;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Vector;

public class TareasCliente extends CuadroCajaCustom implements Tareas {

    private final JButton BOTON_VOLVER = crearBoton("Volver", LEFT_ALIGNMENT, new AccionVolver(Entidad.CLIENTES.name()));

    private PanelDeEntradas panelDeEntradas;
    private PanelCliente panelCliente;
    private PanelBotones panelBotones;


    public TareasCliente(Tarea tarea) {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setVisible(true);
        elegirPanel(tarea);
    }

    private void elegirPanel(Tarea tarea) {
        switch (tarea) {
            case CREAR -> panelCrear();
            case ACTUALIZAR -> panelActualizar();
            case LISTAR -> panelListar();
            case BORRAR -> panelEliminar();
            case BUSCAR -> panelBuscar();
        }
    }

    @Override
    public void panelCrear() {
        this.setBorder(BorderFactory.createTitledBorder("Crear Cliente"));
        this.panelDeEntradas = crearPanelDeEntradas(false);
        this.panelCliente = crearPanelCliente(true);
        this.panelBotones = crearPanelBotones(Tarea.CREAR);
    }

    @Override
    public void panelBuscar() {
        this.setBorder(BorderFactory.createTitledBorder("Buscar Cliente"));
        this.panelDeEntradas = crearPanelDeEntradas(true);
        this.panelCliente = crearPanelCliente(false);
        this.panelBotones = crearPanelBotones(Tarea.BUSCAR);
        panelBotones.getBotonoBuscar().addActionListener(new AccionBuscarCliente(this,panelDeEntradas,panelCliente));
    }

    @Override
    public void panelListar() {
        this.setBorder(BorderFactory.createTitledBorder("Listar Clientes"));
        List<Cliente> clientes = Sistema.getInstance().listarClientes();
        JList<Cliente> listaClientes = new JList<>(new Vector<>(clientes));
        this.add(new JScrollPane(listaClientes));
        this.panelBotones = crearPanelBotones(Tarea.LISTAR);
    }

    @Override
    public void panelActualizar() {
        this.setBorder(BorderFactory.createTitledBorder("Actualizar Cliente"));
        this.panelDeEntradas = crearPanelDeEntradas(true);
        this.panelBotones= crearPanelBotones(Tarea.ACTUALIZAR);
    }

    @Override
    public void panelEliminar() {
        this.setBorder(BorderFactory.createTitledBorder("Eliminar Cliente"));

        this.panelDeEntradas = crearPanelDeEntradas(true);
        this.panelBotones = crearPanelBotones(Tarea.BORRAR);
    }

    private PanelDeEntradas crearPanelDeEntradas(boolean completo) {
        PanelDeEntradas panelDeEntradas = new PanelDeEntradas(completo);
        this.add(panelDeEntradas, crearConfiguracion(0.1, 0));
        return panelDeEntradas;
    }

    private PanelCliente crearPanelCliente(boolean editable) {
        PanelCliente panelCliente = new PanelCliente(editable);
        return crearPanelCliente(panelCliente);
    }

    private PanelCliente crearPanelCliente(PanelCliente panelCliente){
        this.add(panelCliente, crearConfiguracion(0.8, 1));
        return panelCliente;
    }

    private PanelBotones crearPanelBotones(Tarea tarea) {
        PanelBotones panelBotones = new PanelBotones(tarea, BOTON_VOLVER);
        this.add(panelBotones, crearConfiguracion(0.1, 2));
        return panelBotones;
    }

    private GridBagConstraints crearConfiguracion(double weighty, int posicion) {
        GridBagConstraints configuracion = new GridBagConstraints();
        configuracion.weightx = 1.0;
        configuracion.weighty = weighty;
        configuracion.gridx = posicion;
        configuracion.insets = new Insets(30, 30, 30, 30);
        configuracion.fill = GridBagConstraints.BOTH;
        return configuracion;
    }
}