package org.example.impresion;

import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import org.example.sistema.Sistema;
import org.example.sistema.entidades.Reserva;
import org.example.sistema.entidades.Servicio;
import org.example.sistema.gestor.Hotel;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Factura {

    private static final String URL_PLANTILLA = "src/main/resources/plantillas/plantilla.pdf";
    private static final Logger LOG = Logger.getLogger(Factura.class.getName());

    private final Map<String, String> valoresDeFormulario;

    public Factura(Reserva reserva) {
        Hotel hotel = Sistema.getInstance().getHotel();
        String nombreCliente = reserva.getCliente().getNombre() + " " + reserva.getCliente().getApellido();
        float cantidadDias = ChronoUnit.DAYS.between(reserva.getFechaInicio(), reserva.getFechaFin());
        String cantidadDeServicios = String.valueOf(reserva.getServiciosElegidos().length);
        String descripcionHabitacion = reserva.getHabitacion().getTipoDeHabitacion().toString();
        List<Servicio> listaServicios = Sistema.getInstance().listarServicios();
        String descripcionServicios;
        if (reserva.getServiciosElegidos().length == 1) {
            descripcionServicios = listaServicios.get(reserva.getServiciosElegidos()[0]).getDescripcion();
        } else {
            descripcionServicios = "Servicios Varios";
        }
        String descripcionDescuento = reserva.getCliente().getSegmento().toString();
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

        Map<String,String> valoresDeFormulario = new HashMap<>();

        valoresDeFormulario.put("CAMPO_FACTURA","321564987");
        valoresDeFormulario.put("CAMPO_FECHA", LocalDate.now().toString());
        valoresDeFormulario.put("CAMPO_EMPRESA", hotel.getNombre());
        valoresDeFormulario.put("CAMPO_DIRECCION_EMPRESA", hotel.getDireccion());
        valoresDeFormulario.put("CAMPO_TELEFONO", hotel.getTelefono());
        valoresDeFormulario.put("CAMPO_CUIL", hotel.getCuil());
        valoresDeFormulario.put("CAMPO_CLIENTE", nombreCliente);
        valoresDeFormulario.put("CAMPO_DNI", reserva.getCliente().getDni());
        valoresDeFormulario.put("CANTIDAD_HABITACION", String.valueOf(cantidadDias));
        valoresDeFormulario.put("CANTIDAD_SERVICIOS", cantidadDeServicios);
        valoresDeFormulario.put("CANTIDAD_DESCUENTOS", "1");
        valoresDeFormulario.put("DESCRIPCION_HABITACION", descripcionHabitacion);
        valoresDeFormulario.put("DESCRIPCION_SERVICIOS", descripcionServicios);
        valoresDeFormulario.put("DESCRIPCION_DESCUENTO", descripcionDescuento);
        valoresDeFormulario.put("TOTAL_HABITACION", String.valueOf(totalHabitacion));
        valoresDeFormulario.put("TOTAL_SERVICIOS", String.valueOf(totalServicios));
        valoresDeFormulario.put("TOTAL_DESCUENTO", String.valueOf(totalDescuento));
        valoresDeFormulario.put("SUBTOTAL", String.valueOf(subtotal));
        valoresDeFormulario.put("IVA", String.valueOf(iva));
        valoresDeFormulario.put("TOTAL", String.valueOf(total));

        this.valoresDeFormulario = valoresDeFormulario;
    }

    public ByteArrayOutputStream generarFacturaDeReserva() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PdfDocument pdf;
        try {
            pdf = new PdfDocument(new PdfReader(URL_PLANTILLA), new PdfWriter(baos));
            PdfAcroForm form = PdfAcroForm.getAcroForm(pdf, true);
            for (String llave : valoresDeFormulario.keySet()) {
                form.getField(llave).setValue(valoresDeFormulario.get(llave)).setReadOnly(true);
            }
            pdf.close();
            return baos;
        } catch (IOException excepcion) {
            LOG.log(Level.WARNING, excepcion.getMessage());
        }
        return null;
    }
}
