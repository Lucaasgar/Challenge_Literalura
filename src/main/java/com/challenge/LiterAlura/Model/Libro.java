package com.challenge.LiterAlura.Model;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    private Long isnb;
    private String titulo;
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "autores_libros",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private List<Autor> autores;
    @Column(columnDefinition = "TEXT")
    private String sinopsis;
    private List<String> lenguaje;
    private Integer nroDescargas;

    public Libro(){}

    public Libro(DatosLibro datosLibro){
        this.titulo = datosLibro.titulo();
        this.lenguaje = datosLibro.lenguaje();
        this.sinopsis = String.valueOf(datosLibro.sinopsis());
        this.autores = new ArrayList<>();
        this.isnb = datosLibro.id();
        this.nroDescargas = datosLibro.nroDescargas();
    }

    @Override
    public String toString() {
        return "\n------- LIBRO -------\n"+
                "TÍTULO: " + titulo + "\n" +
                "AUTOR: " + autores.get(0).getNombre() + "\n" +
                "IDIOMA: " + lenguaje + "\n" +
                "DESCARGAS: " + nroDescargas + "\n" +
                "---------------------\n";
    }

    public Long getIsnb() {
        return isnb;
    }

    public void setIsnb(Long isnb) {
        this.isnb = isnb;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public Integer getNroDescargas() {
        return nroDescargas;
    }

    public void setNroDescargas(Integer nroDescargas) {
        this.nroDescargas = nroDescargas;
    }

    public void setListaAutores(List<Autor> autores){
        this.autores = autores;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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
