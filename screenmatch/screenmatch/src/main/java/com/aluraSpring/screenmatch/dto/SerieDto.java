package com.aluraSpring.screenmatch.dto;

import com.aluraSpring.screenmatch.model.Categoria;


public record SerieDto(
        Long id,
        String anio,
        String titulo,
        Integer totalTemporadas,
        String actores,
        Categoria genero,
        Double evaluacion,
        String poster,
        String sinopsis


) {


}
