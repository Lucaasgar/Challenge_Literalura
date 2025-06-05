package com.challenge.LiterAlura.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosAutor(
         @JsonAlias("name") String nombre,
         @JsonAlias("birth_year") Integer fecha_nac,
         @JsonAlias("death_year") Integer fecha_def
) {
}
