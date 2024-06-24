package org.example.menues.enums;

public enum Entidad {
    CLIENTES("src/main/resources/iconos/clientes.png"),
    EMPLEADOS("src/main/resources/iconos/empleados.png"),
    RESERVAS("src/main/resources/iconos/reservas.png"),
    HABITACIONES("src/main/resources/iconos/habitaciones.png"),
    SERVICIOS("src/main/resources/iconos/servicios.png"),;

    private final String urlIcono;

    Entidad(String urlIcono) {
        this.urlIcono = urlIcono;
    }

    public String getUrlIcono() {
        return urlIcono;
    }
}
