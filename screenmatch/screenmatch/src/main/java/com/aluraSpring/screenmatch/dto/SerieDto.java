package com.aluraSpring.screenmatch.dto;

import com.aluraSpring.screenmatch.model.Categoria;


public record SerieDto(
        String anio,
        Integer totalTemporadas,
        String actores,
        Categoria genero,
        Double evaluacion,
        String poster,
        String sinopsis


) {


}
