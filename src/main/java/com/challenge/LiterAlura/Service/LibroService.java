package com.challenge.LiterAlura.Service;

import com.challenge.LiterAlura.Model.*;
import com.challenge.LiterAlura.Repository.AutorRepository;
import com.challenge.LiterAlura.Repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LibroService {
    @Autowired
    private LibroRepository repositoryBook;
    @Autowired
    private AutorRepository repositoryAutor;
    private final String URL_BASE ="https://gutendex.com/books";
    private ConvierteDatos conversor = new ConvierteDatos();
    private final ConsumoAPI api = new ConsumoAPI();

    public void mostrarTodosLosLibros(){
        repositoryBook.findAll().forEach(b -> System.out.println(b.toString()));
    }

    public void buscarLibroPorTitulo(String tituloBuscado){
        String json = api.obtenerDatos(URL_BASE + "?search=" + tituloBuscado.replace(" ", "%20"));
        DatosReponse datos = conversor.getDataFromJson(json, DatosReponse.class);
        if(datos.libros().isEmpty()){
            System.out.println("No se encontro ningun libro con el titulo:" + tituloBuscado);
        }
        if(repositoryBook.existsById(datos.libros().get(0).id())){
            System.out.println("Ya existe en la base de datos.");
            return;
        }
        DatosLibro datosLibro = datos.libros().get(0);
        DatosAutor datosAutor = datosLibro.autores().get(0);
        Libro nuevoLibro = new Libro(datosLibro);
        Autor nuevoAutor = new Autor(datosAutor);
        nuevoLibro.getAutores().add(nuevoAutor);
        repositoryBook.save(nuevoLibro);
        System.out.println("Libro añadido correctamente!");
        System.out.println(nuevoLibro.toString());
    }

    public List<Autor> listarAutoresRegistrados() {
        return repositoryBook.findAll().stream()
                .map(b -> b.getAutores().get(0))
                .collect(Collectors.toList());
    }

    public List<Autor> autoresVivosEnUnAnio(int anio) {
        return repositoryAutor.buscarAutoresVivosEnUnAnio(anio);

    }
}
