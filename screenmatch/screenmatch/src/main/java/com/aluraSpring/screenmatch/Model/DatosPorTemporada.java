package com.aluraSpring.screenmatch.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosPorTemporada(
        @JsonAlias("Season")
        Integer numeroTemporada,
        @JsonAlias("Episodes")
        List<DatosEpisodio> episodios
) {
}
