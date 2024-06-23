package org.example.menues.cuadros.panelesgridbag.tareas.impl.servicio;

import org.example.menues.acciones.AccionVolver;
import org.example.menues.acciones.empleado.AccionActualizarEmpleado;
import org.example.menues.acciones.empleado.AccionBuscarParaActualizar;
import org.example.menues.acciones.servicios.*;
import org.example.menues.cuadros.panelesgridbag.*;
import org.example.menues.cuadros.panelesgridbag.tareas.ITareas;
import org.example.menues.enums.Entidad;
import org.example.menues.enums.Tarea;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Servicio;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Vector;

public class PanelTareasServicio extends PanelCustom implements ITareas {

    private final JButton BOTON_VOLVER = crearBoton("Volver", LEFT_ALIGNMENT, new AccionVolver(Entidad.SERVICIOS.name()));

    private PanelDeEntradas panelDeEntradas;
    private PanelServicio panelServicio;
    private PanelBotones panelBotones;

    //Constructor de la clase
    public PanelTareasServicio(Tarea tarea) {
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
            case BORRAR -> panelBorrar();
            case BUSCAR -> panelBuscar();
        }
    }

    //Configurar panel especifico para cada tarea correspondiente

    @Override
    public void panelCrear() {
        this.setBorder(BorderFactory.createTitledBorder("Crear Servicio"));
        this.panelDeEntradas = crearPanelDeEntradas(false);
        this.panelServicio = crearPanelServicio(true);
        this.panelBotones = crearPanelBotones(Tarea.CREAR);
        panelBotones.getBotonGuardar().addActionListener(new AccionCrearServicio(panelServicio));

    }

    @Override
    public void panelBuscar() {
        this.setBorder(BorderFactory.createTitledBorder("Buscar Servicio"));
        this.panelDeEntradas = crearPanelDeEntradas(true);
        this.panelServicio = crearPanelServicio(false);
        this.panelBotones = crearPanelBotones(Tarea.BUSCAR);
        panelBotones.getBotonBuscar().addActionListener(new AccionBuscarServicio(panelDeEntradas,panelServicio));
    }

    @Override
    public void panelListar() {
        this.setBorder(BorderFactory.createTitledBorder("Listar Servicios"));
        List<Servicio> servicios = Sistema.getInstance().listarServicios();
        JList<Servicio> listaServicios = new JList<>(new Vector<>(servicios));
        this.add(new JScrollPane(listaServicios));
        this.panelBotones = crearPanelBotones(Tarea.LISTAR);
    }

    @Override
    public void panelActualizar() {
        this.setBorder(BorderFactory.createTitledBorder("Actualizar Servicio"));
        this.panelDeEntradas = crearPanelDeEntradas(true);
        this.panelServicio = crearPanelServicio(false);
        this.panelBotones = crearPanelBotones(Tarea.ACTUALIZAR);
        panelBotones.getBotonBuscar().addActionListener(new AccionBuscarParaActualizarServicio(panelDeEntradas, panelServicio, panelBotones));
        panelBotones.getBotonActualizar().addActionListener(new AccionActualizarServicio(panelServicio));

    }

    @Override
    public void panelBorrar() {
        this.setBorder(BorderFactory.createTitledBorder("Eliminar Servicio"));
        this.panelDeEntradas = crearPanelDeEntradas(true);
        this.panelBotones = crearPanelBotones(Tarea.BORRAR);
        panelBotones.getBotonBorrar().addActionListener(new AccionBorrarServicio(panelDeEntradas));
    }

    private PanelDeEntradas crearPanelDeEntradas(boolean completo) {
        PanelDeEntradas panelDeEntradas = new PanelDeEntradas(completo,"Codigo");
        this.add(panelDeEntradas,crearConfiguracion(0.1,0));
        return panelDeEntradas;
    }

    private PanelServicio crearPanelServicio(boolean editable){
        PanelServicio panelServicio = new PanelServicio(editable);
        return crearPanelServicio(panelServicio);
    }

    private PanelServicio crearPanelServicio(PanelServicio panelServicio){
        this.add(panelServicio, crearConfiguracion(0.8, 1));
        return panelServicio;
    }

    private PanelBotones crearPanelBotones(Tarea tarea){
        PanelBotones panelBotones = new PanelBotones(tarea,BOTON_VOLVER);
        this.add(panelBotones,crearConfiguracion(0.1,2));
        return panelBotones;
    }

    private GridBagConstraints crearConfiguracion(double weighty, int posicion){
        GridBagConstraints configuracion = new GridBagConstraints();
        configuracion.weightx =1.0;
        configuracion.weighty =weighty;
        configuracion.gridx = posicion;
        configuracion.insets = new Insets(30,30,30,30);
        configuracion.fill = GridBagConstraints.BOTH;
        return configuracion;
    }


}
