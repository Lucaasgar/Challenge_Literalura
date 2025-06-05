package com.challenge.LiterAlura.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
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
        this.nroDescargas = datosLibro.nroDescargas();
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", listaAutores=" + autores +
                ", sinopsis='" + sinopsis + '\'' +
                ", lenguaje=" + lenguaje +
                ", nroDescargas=" + nroDescargas +
                '}';
    }

    public List<Autor> getListaAutores() {
        return autores;
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

    public List<Autor> getAutor() {
        return autores;
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
