package com.challenge.LiterAlura.Principal;

import com.challenge.LiterAlura.Model.*;
import com.challenge.LiterAlura.Repository.AutorRepository;
import com.challenge.LiterAlura.Repository.LibroRepository;
import com.challenge.LiterAlura.Service.ConsumoAPI;
import com.challenge.LiterAlura.Service.ConvierteDatos;

import java.util.Scanner;

public class Principal {
    private Scanner scanner = new Scanner(System.in);
    private ConvierteDatos conversor = new ConvierteDatos();
    private final String URL_BASE ="https://gutendex.com/books";
    private LibroRepository repositoryBook;
    private AutorRepository repositoryAutor;

    private final ConsumoAPI api = new ConsumoAPI();

    public Principal(AutorRepository repositoryAutor, LibroRepository repositoryBook) {
        this.repositoryAutor = repositoryAutor;
        this.repositoryBook = repositoryBook;
    }

    public void aplicacion(){
        var opcion = -1;
        while (opcion != 0){
            var menu = """
                    ****************************************
                    Elija la opcion a través de su número: 
                    1 - Buscar libro por titulo.
                    
                    0 - Salir.
                    ****************************************
                    Ingrese: 
                    """;
            System.out.println(menu);
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                    buscarLibroPorTitulo();
                    break;
                case 0:
                    System.out.println("Cerrando aplicación...");
                    break;
                default:
                    System.out.println("Ingreso no valido, ingrese nuevamente un numero valido.");
                    break;
            }
        }
    }

    private void buscarLibroPorTitulo() {
        System.out.println("Ingrese el titulo:");
        String tituloBuscado = scanner.nextLine();
        String json = api.obtenerDatos(URL_BASE + "?search=" + tituloBuscado.replace(" ", "%20"));

        DatosReponse datosResponse = conversor.getDataFromJson(json, DatosReponse.class);
        if (datosResponse.libros().isEmpty()) {
            System.out.println("No se encontraron libros con el titulo: " + tituloBuscado.toUpperCase());
            return;
        }
        DatosLibro datosLibro = datosResponse.libros().get(0);
        DatosAutor datosAutor = datosLibro.autores().get(0);

        Libro nuevoLibro = new Libro(datosLibro);
        Autor nuevoAutor = new Autor(datosAutor);
        nuevoLibro.getListaAutores().add(nuevoAutor);

        repositoryBook.save(nuevoLibro);

        System.out.println(nuevoLibro.toString());
    }
}
