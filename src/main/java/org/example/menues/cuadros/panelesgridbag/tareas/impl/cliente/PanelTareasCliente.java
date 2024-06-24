package org.example.menues.cuadros.panelesgridbag.tareas.impl.cliente;

import org.example.menues.acciones.cliente.*;
import org.example.menues.cuadros.panelesgridbag.tareas.impl.PanelTareas;
import org.example.menues.enums.Entidad;
import org.example.menues.enums.Tarea;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.persona.Cliente;

import javax.swing.*;
import java.util.List;
import java.util.Vector;

public class PanelTareasCliente extends PanelTareas {

    private PanelCliente panelCliente;

    public PanelTareasCliente(Tarea tarea) {
        super(tarea, Entidad.CLIENTES);
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setVisible(true);
        elegirPanel(tarea);
    }

    @Override
    public void panelCrear() {
        panelDeEntradas = crearPanelDeEntradas(false, ETIQUEDA_DNI);
        panelCliente = crearPanelCliente(true);
        panelBotones = crearPanelBotones(Tarea.CREAR);
        panelBotones.getBotonGuardar().addActionListener(new AccionCrearCliente(panelCliente));
    }

    @Override
    public void panelBuscar() {
        panelDeEntradas = crearPanelDeEntradas(true, ETIQUEDA_DNI);
        panelCliente = crearPanelCliente(false);
        panelBotones = crearPanelBotones(Tarea.BUSCAR);
        panelBotones.getBotonBuscar().addActionListener(new AccionBuscarCliente(panelDeEntradas, panelCliente));
    }

    @Override
    public void panelListar() {
        List<Cliente> clientes = Sistema.getInstance().listarClientes();
        JList<Cliente> listaClientes = new JList<>(new Vector<>(clientes));
        add(new JScrollPane(listaClientes));
        panelBotones = crearPanelBotones(Tarea.LISTAR);
    }

    @Override
    public void panelActualizar() {
        panelDeEntradas = crearPanelDeEntradas(true, ETIQUEDA_DNI);
        panelCliente = crearPanelCliente(false);
        panelBotones = crearPanelBotones(Tarea.ACTUALIZAR);
        panelBotones.getBotonBuscar().addActionListener(new AccionBuscarParaActualizarCliente(panelDeEntradas, panelCliente, panelBotones));
        panelBotones.getBotonActualizar().addActionListener(new AccionActualizarCliente(panelCliente));
    }

    @Override
    public void panelBorrar() {
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