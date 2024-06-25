package org.example.menues.acciones.reserva;

import org.example.impresion.Factura;
import org.example.menues.acciones.AccionAbstracta;
import org.example.menues.paneles.panelesgridbag.PanelDeEntradas;
import org.example.menues.paneles.panelesgridbag.tareas.impl.reserva.PanelReserva;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Reserva;
import org.example.sistema.enums.Estado;
import org.example.sistema.excepciones.ExcepcionCamposRequeridos;
import org.example.sistema.excepciones.ExcepcionObjectoNoEncontrado;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class AccionActualizarReserva extends AccionAbstracta {

    private final PanelReserva panelReserva;
    private final PanelDeEntradas panelDeEntradas;

    public AccionActualizarReserva(PanelReserva panelReserva, PanelDeEntradas panelDeEntradas) {
        this.panelReserva = panelReserva;
        this.panelDeEntradas = panelDeEntradas;
    }

    @Override
    public void actionPerformed(ActionEvent evento) {
        try {
            Reserva reserva = panelReserva.crearReserva();
            if (reserva != null) {
                String idReserva = panelDeEntradas.obtenerCampo();
                Estado estadoReserva = panelReserva.getEstadoReserva();
                String dniCliente = panelReserva.getCliente();
                String numeroDeHabitacion = panelReserva.getHabitacion();
                reserva.setIdReserva(idReserva);
                Reserva reservaActualizada = Sistema.getInstance().actualizarReserva(
                        estadoReserva,
                        idReserva,
                        dniCliente,
                        numeroDeHabitacion,
                        reserva);
                if (estadoReserva.equals(Estado.CONFIRMADA)) {
                    crearFactura(reservaActualizada);
                }
                JOptionPane.showMessageDialog(panelReserva.getParent(), "Reserva actualizada");
            }
        } catch (ExcepcionObjectoNoEncontrado | ExcepcionCamposRequeridos | IOException excepcion) {
            mostrarDialogoDeError(panelReserva, excepcion);
        }
    }

    private void crearFactura(Reserva reservaActualizada) throws IOException {
        Factura factura = new Factura(reservaActualizada);
        ByteArrayOutputStream inputStream = factura.generarFacturaDeReserva();
        JFileChooser cuadroDeDialogo = new JFileChooser();
        cuadroDeDialogo.setSelectedFile(new File("factura.pdf"));
        cuadroDeDialogo.setDialogTitle("Guardar Factura");
        cuadroDeDialogo.setApproveButtonText("Guardar");
        if (cuadroDeDialogo.showOpenDialog(panelReserva.getParent()) == JFileChooser.APPROVE_OPTION) {
            FileOutputStream outputStream = new FileOutputStream(cuadroDeDialogo.getSelectedFile());
            inputStream.writeTo(outputStream);
            outputStream.close();
        }
    }
}
