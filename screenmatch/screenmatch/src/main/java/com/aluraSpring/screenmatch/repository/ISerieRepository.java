package com.aluraSpring.screenmatch.repository;

import ch.qos.logback.core.pattern.parser.OptionTokenizer;
import com.aluraSpring.screenmatch.dto.EpisodioDto;
import com.aluraSpring.screenmatch.model.Categoria;
import com.aluraSpring.screenmatch.model.Episodio;
import com.aluraSpring.screenmatch.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface ISerieRepository extends JpaRepository<Serie,Long> {

    List<Serie>findTop5ByOrderByEvaluacionDesc();
    List<Serie> findByGenero(Categoria categoria);
    /*numero de temporadasa menores o iguales a t<=? AND e>=? evaluaciones mayores o iguales */
    //List<Serie> findByTotalTemporadasLessThanEqualAndEvaluacionGreaterThanEqual(int totalTemporadas, Double evaluacion);

    @Query("select s from Serie s where s.totalTemporadas <= :temporadas AND s.evaluacion >= :evaluaciones")
    List<Serie>findTemporadasEvaluaciones(Integer temporadas,Double evaluaciones);

    @Query("SELECT e FROM Serie s JOIN s.listEpisodios e WHERE e.titulo ILIKE %:nombreEpisodio%")
    List<Episodio>episodiosPorNombre(String nombreEpisodio);

    @Query("SELECT e FROM Serie s JOIN s.listEpisodios e WHERE s = :serie ORDER BY s.evaluacion DESC LIMIT 5")
    List<Episodio>top5Episodios(Serie serie);

    Optional<Serie>findByTitulo(String titulo);

    @Query("SELECT s FROM Serie s JOIN s.listEpisodios e GROUP BY s ORDER BY MAX(e.fechaDeLanzamiento) DESC LIMIT 5")
    List<Serie>ultimosLanzamientos();

    @Query("SELECT e FROM Serie s JOIN s.listEpisodios e WHERE s.id = :id AND e.temporada = :numeroTemporadas")
    List<Episodio> obtenerPorNumeroTemporada(Long id, Long numeroTemporadas);

}
