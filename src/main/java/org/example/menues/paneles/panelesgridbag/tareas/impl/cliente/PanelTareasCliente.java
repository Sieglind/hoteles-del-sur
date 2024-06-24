package org.example.menues.paneles.panelesgridbag.tareas.impl.cliente;

import org.example.menues.acciones.cliente.*;
import org.example.menues.enums.Entidad;
import org.example.menues.enums.Tarea;
import org.example.menues.paneles.panelesgridbag.tareas.impl.PanelTareasAbstracto;
import org.example.menues.modelosdetabla.ModeloTablaClientes;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.persona.Cliente;

import javax.swing.*;
import java.util.List;

public class PanelTareasCliente extends PanelTareasAbstracto {

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
        ModeloTablaClientes modelo = new ModeloTablaClientes(clientes);
        JTable tabla = new JTable(modelo);
        add(new JScrollPane(tabla));
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