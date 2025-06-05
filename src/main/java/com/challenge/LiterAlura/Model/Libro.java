package com.challenge.LiterAlura.Model;

import com.challenge.LiterAlura.Model.Autor;

import java.util.ArrayList;
import java.util.List;

public class Libro {
    private String titulo;
    private List<Autor> listaAutores;
    private String sinopsis;
    private List<String> lenguaje;

    public Libro(DatosLibro datosLibro, Autor autor){
        this.titulo = datosLibro.titulo();
        this.lenguaje = datosLibro.lenguaje();
        this.sinopsis = String.valueOf(datosLibro.sinopsis());
        this.listaAutores = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autores=" + listaAutores +
                ", sinopsis='" + sinopsis + '\'' +
                ", lenguaje=" + lenguaje +
                '}';
    }

    public void setListaAutores(List<Autor> autores){
        this.listaAutores = autores;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutor() {
        return listaAutores;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public List<String> getLenguaje() {
        return lenguaje;
    }

    public void setLenguaje(List<String> lenguaje) {
        this.lenguaje = lenguaje;
    }
}
