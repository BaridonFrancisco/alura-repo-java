package com.aluraSpring.screenmatch.repository;

import com.aluraSpring.screenmatch.model.Categoria;
import com.aluraSpring.screenmatch.model.Episodio;
import com.aluraSpring.screenmatch.model.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ISerieRepository extends JpaRepository<Serie,Long> {

    List<Serie>findTop5ByOrderByEvaluacionDesc();
    List<Serie> findByGenero(Categoria categoria);
    /*numero de temporadasa menores o iguales a t<=? AND e>=? evaluaciones mayores o iguales */
    //List<Serie> findByTotalTemporadasLessThanEqualAndEvaluacionGreaterThanEqual(int totalTemporadas, Double evaluacion);

    @Query("select s from Serie s where s.totalTemporadas <= :temporadas AND s.evaluacion >= :evaluaciones")
    List<Serie>findTemporadasEvaluaciones(Integer temporadas,Double evaluaciones);

    @Query("SELECT e FROM Serie s WHERE JOIN s.listEpisodios e WHERE e.titulo ILIKE %nombreEpisodio%")
    List<Episodio>episodiosPorNombre(String nombreEpisodio);
}
