package com.challenge.LiterAlura.Principal;

import com.challenge.LiterAlura.Model.*;
import com.challenge.LiterAlura.Service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;
@Component
public class Principal {
    private final Scanner scanner = new Scanner(System.in);
    @Autowired
    private LibroService service;

    public void aplicacion(){
        var opcion = -1;
        while (opcion != 0){
            var menu = """
                    ****************************************
                    Elija la opcion a través de su número:
                    1 - Buscar libro por titulo.
                    2 - Listar libros registrados.
                    3 - Listar autores registrados.
                    4 - Listar autores vivos en un determinado año.
                    5 - Listar libros por idiomas.
                    
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
                case 2:
                    mostrarTodosLosLibros();
                    break;
                case 3:
                    listarAutoresRegistrados();
                    break;
                case 4:
                    autoresVivosEnUnAnio();
                    break;
                case 0:
                    System.out.println("Cerrando aplicación...");
                    scanner.close();
                    break;
                default:
                    System.out.println("Ingreso no valido, ingrese nuevamente un numero valido.");
                    break;
            }
        }
    }

    private void autoresVivosEnUnAnio() {
        System.out.println("Ingrese un año: ");
        var anio = scanner.nextInt();
        scanner.nextLine();

        List<Autor> autoresVivos = service.autoresVivosEnUnAnio(anio);
        autoresVivos.forEach(a -> System.out.printf("Nombre: %s \t FNac: %d \t FDef: %d\n", a.getNombre(), a.getFecha_nac()
                , a.getFecha_def()));
    }

    private void listarAutoresRegistrados() {
       List<Autor> autores = service.listarAutoresRegistrados();
       autores.forEach(a -> System.out.printf("Nombre: %s \t FNac: %d \t FDef: %d\n", a.getNombre(), a.getFecha_nac()
               , a.getFecha_def()));
    }

    private void mostrarTodosLosLibros() {
        service.mostrarTodosLosLibros();
    }

    private void buscarLibroPorTitulo() {
        System.out.println("Ingrese el titulo:");
        String tituloBuscado = scanner.nextLine();
        service.buscarLibroPorTitulo(tituloBuscado);
    }
}
