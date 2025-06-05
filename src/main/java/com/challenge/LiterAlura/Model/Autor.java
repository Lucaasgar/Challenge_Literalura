package com.challenge.LiterAlura.Model;

import java.util.List;

public class Autor {
    private String nombre;
    private Integer fecha_nac;
    private Integer fecha_def;

    public Autor(DatosAutor datosAutor){
        this.nombre = datosAutor.nombre();
        this.fecha_nac = datosAutor.fecha_nac();
        this.fecha_def = datosAutor.fecha_def();
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nombre='" + nombre + '\'' +
                ", fecha_nac=" + fecha_nac +
                ", fecha_def=" + fecha_def +
                '}';
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(Integer fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public Integer getFecha_def() {
        return fecha_def;
    }

    public void setFecha_def(Integer fecha_def) {
        this.fecha_def = fecha_def;
    }
}

