package com.challenge.LiterAlura.Repository;

import com.challenge.LiterAlura.Model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {
}
