package com.challenge.LiterAlura.Repository;

import com.challenge.LiterAlura.Model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
}
