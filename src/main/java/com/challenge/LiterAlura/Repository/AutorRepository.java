package com.challenge.LiterAlura.Repository;

import com.challenge.LiterAlura.Model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    @Query(value = "SELECT DISTINCT a FROM Autor a WHERE a.fecha_nac <= :anio AND a" +
            ".fecha_def > :anio")
    List<Autor> buscarAutoresVivosEnUnAnio(int anio);
}
