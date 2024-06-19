package org.example.menues.enums;

public enum Tarea {
    CREAR("src/main/resources/iconos/crear.png"),
    BUSCAR("src/main/resources/iconos/buscar.png"),
    LISTAR("src/main/resources/iconos/listar.png"),
    ACTUALIZAR("src/main/resources/iconos/actualizar.png"),
    BORRAR("src/main/resources/iconos/borrar.png");

    String urlIcono;

    Tarea(String urlIcono) {
        this.urlIcono = urlIcono;
    }

    public String getUrlIcono() {
        return urlIcono;
    }
}
