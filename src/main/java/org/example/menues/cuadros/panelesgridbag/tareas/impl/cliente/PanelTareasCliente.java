package org.example.menues.cuadros.panelesgridbag.tareas.impl.cliente;

import org.example.menues.acciones.cliente.*;
import org.example.menues.cuadros.panelesgridbag.tareas.ITareas;
import org.example.menues.cuadros.panelesgridbag.tareas.impl.PanelTareas;
import org.example.menues.enums.Entidad;
import org.example.menues.enums.Tarea;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.persona.Cliente;

import javax.swing.*;
import java.util.List;
import java.util.Vector;

public class PanelTareasCliente extends PanelTareas implements ITareas {

    private PanelCliente panelCliente;


    public PanelTareasCliente(Tarea tarea) {
        super(Entidad.CLIENTES);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setVisible(true);
        elegirPanel(tarea);
    }

    private void elegirPanel(Tarea tarea) {
        switch (tarea) {
            case CREAR -> panelCrear();
            case ACTUALIZAR -> panelActualizar();
            case LISTAR -> panelListar();
            case BORRAR -> panelBorrar();
            case BUSCAR -> panelBuscar();
        }
    }

    @Override
    public void panelCrear() {
        setBorder(BorderFactory.createTitledBorder("Crear Cliente"));
        panelDeEntradas = crearPanelDeEntradas(false, ETIQUEDA_DNI);
        panelCliente = crearPanelCliente(true);
        panelBotones = crearPanelBotones(Tarea.CREAR);
        panelBotones.getBotonGuardar().addActionListener(new AccionCrearCliente(panelCliente));
    }

    @Override
    public void panelBuscar() {
        this.setBorder(BorderFactory.createTitledBorder("Buscar Cliente"));
        panelDeEntradas = crearPanelDeEntradas(true, ETIQUEDA_DNI);
        panelCliente = crearPanelCliente(false);
        panelBotones = crearPanelBotones(Tarea.BUSCAR);
        panelBotones.getBotonBuscar().addActionListener(new AccionBuscarCliente(panelDeEntradas, panelCliente));
    }

    @Override
    public void panelListar() {
        this.setBorder(BorderFactory.createTitledBorder("Listar Clientes"));
        List<Cliente> clientes = Sistema.getInstance().listarClientes();
        JList<Cliente> listaClientes = new JList<>(new Vector<>(clientes));
        add(new JScrollPane(listaClientes));
        panelBotones = crearPanelBotones(Tarea.LISTAR);
    }

    @Override
    public void panelActualizar() {
        setBorder(BorderFactory.createTitledBorder("Actualizar Cliente"));
        panelDeEntradas = crearPanelDeEntradas(true, ETIQUEDA_DNI);
        panelCliente = crearPanelCliente(false);
        panelBotones = crearPanelBotones(Tarea.ACTUALIZAR);
        panelBotones.getBotonBuscar().addActionListener(new AccionBuscarParaActualizarCliente(panelDeEntradas, panelCliente, panelBotones));
        panelBotones.getBotonActualizar().addActionListener(new AccionActualizarCliente(panelCliente));
    }

    @Override
    public void panelBorrar() {
        this.setBorder(BorderFactory.createTitledBorder("Borrar Cliente"));

        panelDeEntradas = crearPanelDeEntradas(true, ETIQUEDA_DNI);
        panelBotones = crearPanelBotones(Tarea.BORRAR);
        panelBotones.getBotonBorrar().addActionListener(new AccionBorraCliente(panelDeEntradas));
    }

    private PanelCliente crearPanelCliente(boolean editable) {
        PanelCliente panelCliente = new PanelCliente(editable);
        return crearPanelCliente(panelCliente);
    }

    private PanelCliente crearPanelCliente(PanelCliente panelCliente) {
        this.add(panelCliente, crearConfiguracion(0.8, 1));
        return panelCliente;
    }
}