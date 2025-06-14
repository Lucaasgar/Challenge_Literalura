package com.challenge.LiterAlura.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
        @JsonAlias("id") Long id,
         @JsonAlias("title") String titulo,
         @JsonAlias("authors") List<DatosAutor> autores,
         @JsonAlias("summaries") List<String> sinopsis,
         @JsonAlias("languages") List<String>lenguaje,
         @JsonAlias("download_count") Integer nroDescargas
) {
}
