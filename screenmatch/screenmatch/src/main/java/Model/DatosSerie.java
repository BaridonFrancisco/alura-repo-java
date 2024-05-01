package Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosSerie(
        @JsonAlias("Title")
        String titulo,
        @JsonAlias("Year")
        String anio,
        @JsonAlias("Actors")
        String actores,
        @JsonAlias("Genre")
        String genero,
        @JsonAlias("Poster")
        String poster,
        @JsonAlias("Plot")
        String  sinopsis,
        @JsonAlias("imdbRating")
        String evaluaciones,
        @JsonAlias("totalSeasons")
        Integer numero
){

}
