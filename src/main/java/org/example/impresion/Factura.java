package org.example.impresion;

import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Reserva;
import org.example.sistema.entidades.Servicio;
import org.example.sistema.entidades.persona.Cliente;
import org.example.sistema.gestor.Hotel;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Factura {

    private static final String URL_PLANTILLA = "src/main/resources/plantillas/plantilla.pdf";
    private static final Logger LOG = Logger.getLogger(Factura.class.getName());

    private final Map<String, String> campos = new HashMap<>();

    public Factura(Reserva reserva) {
        campos.put("CAMPO_FACTURA", String.valueOf(new Random().nextInt(90000000) + 10000000));
        campos.put("CAMPO_FECHA", LocalDate.now().toString());
        campos.put("CANTIDAD_DESCUENTOS", String.valueOf(1));

        llenarCamposDeHotel(Sistema.getInstance().getHotel());
        llenarCamposdeCliente(reserva.getCliente());
        llenarCantidadDeServicios(reserva);
    }

    private void llenarCamposDeHotel(Hotel hotel) {
        campos.put("CAMPO_EMPRESA", hotel.getNombre());
        campos.put("CAMPO_DIRECCION_EMPRESA", hotel.getDireccion());
        campos.put("CAMPO_TELEFONO", hotel.getTelefono());
        campos.put("CAMPO_CUIL", hotel.getCuil());
    }

    private void llenarCamposdeCliente(Cliente cliente) {
        campos.put("CAMPO_CLIENTE", cliente.getNombre() + " " + cliente.getApellido());
        campos.put("CAMPO_DNI", cliente.getDni());
    }

    private void llenarCantidadDeServicios(Reserva reserva) {
        campos.put("CANTIDAD_SERVICIOS", String.valueOf(reserva.getServiciosElegidos().length));

        llenarCantidadDias(reserva);
    }

    private void llenarCantidadDias(Reserva reserva) {
        float cantidadDias = ChronoUnit.DAYS.between(reserva.getFechaInicio(), reserva.getFechaFin());

        campos.put("CANTIDAD_HABITACION", String.valueOf(cantidadDias));

        llenarTotales(reserva, cantidadDias);
    }

    private void llenarTotales(Reserva reserva, float cantidadDias) {
        List<Servicio> listaServicios = Sistema.getInstance().listarServicios();
        float totalHabitacion = reserva.getHabitacion().getPrecio() * cantidadDias;
        float totalServicios = 0;
        for (int indice : reserva.getServiciosElegidos()) {
            totalServicios += listaServicios.get(indice).getPrecio();
        }
        float totalDescuento = switch (reserva.getCliente().getSegmento()) {
            case BRONCE -> 1 * (totalHabitacion + totalServicios);
            case PLATA -> (float) (0.1 * (totalHabitacion + totalServicios));
            case ORO -> (float) (0.2 * (totalHabitacion + totalServicios));
        };
        float subtotal = totalHabitacion + totalServicios - totalDescuento;
        float iva = (float) (0.21 * subtotal);
        float total = subtotal + iva;

        campos.put("TOTAL_HABITACION", String.valueOf(totalHabitacion));
        campos.put("TOTAL_SERVICIOS", String.valueOf(totalServicios));
        campos.put("TOTAL_DESCUENTO", String.valueOf(totalDescuento));
        campos.put("SUBTOTAL", String.valueOf(subtotal));
        campos.put("IVA", String.valueOf(iva));
        campos.put("TOTAL", String.valueOf(total));

        llenarDescripciones(reserva, listaServicios);
    }

    private void llenarDescripciones(Reserva reserva, List<Servicio> listaServicios) {
        String descripcionHabitacion = reserva.getHabitacion().getTipoDeHabitacion().toString();
        String descripcionServicios;
        if (reserva.getServiciosElegidos().length == 1) {
            descripcionServicios = listaServicios.get(reserva.getServiciosElegidos()[0]).getDescripcion();
        } else {
            descripcionServicios = "Servicios Varios";
        }
        String descripcionDescuento = reserva.getCliente().getSegmento().toString();

        campos.put("DESCRIPCION_HABITACION", descripcionHabitacion);
        campos.put("DESCRIPCION_SERVICIOS", descripcionServicios);
        campos.put("DESCRIPCION_DESCUENTO", descripcionDescuento);
    }

    public ByteArrayOutputStream generarFacturaDeReserva() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfDocument pdf;
        try {
            pdf = new PdfDocument(new PdfReader(URL_PLANTILLA), new PdfWriter(baos));
            PdfAcroForm form = PdfAcroForm.getAcroForm(pdf, true);
            for (String llave : campos.keySet()) {
                form.getField(llave).setValue(campos.get(llave)).setReadOnly(true);
            }
            pdf.close();
            return baos;
        } catch (IOException excepcion) {
            LOG.log(Level.WARNING, excepcion.getMessage());
        }
        return null;
    }
}
