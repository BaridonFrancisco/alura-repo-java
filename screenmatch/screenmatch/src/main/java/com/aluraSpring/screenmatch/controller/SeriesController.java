package com.aluraSpring.screenmatch.controller;

import com.aluraSpring.screenmatch.dto.EpisodioDto;
import com.aluraSpring.screenmatch.dto.SerieDto;
import com.aluraSpring.screenmatch.model.Episodio;
import com.aluraSpring.screenmatch.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/series")
public class SeriesController {
    @Autowired
    SerieService serieService;

    @GetMapping()
    public List<SerieDto> mostrarTodasSeries(){
        return serieService.obtenerSeries();
    }
    @GetMapping("/top5")
    public List<SerieDto>top5(){
        return  serieService.top5Series();
    }
    @GetMapping("/lanzamientos")
    public List<SerieDto>lanzamientosRecientes(){
        return serieService.lanzamientoRecientes();
    }
    @GetMapping("/{id}")
    public SerieDto getById(@PathVariable Long id){
        return serieService.obtenerPorId(id);
    }
    @GetMapping("/{id}/temporadas/todas")
    public List<EpisodioDto>obtenerTodasLasTemporadas(@PathVariable Long id){
        return serieService.obtenerTodasLastemp(id);
    }
    @GetMapping("/{id}/temporadas/{numeroTemporadas}")
    public List<EpisodioDto>obtenerTemporada(@PathVariable Long id,
                                             @PathVariable Long numeroTemporadas){
            return serieService.obtenerTemporadaPorNumero(id,numeroTemporadas);
    }

    @GetMapping("/categoria/{nombreGenero}")
    public List<SerieDto>seriesPorCategoria(@PathVariable String nombreGenero){
            return serieService.obtenerSeriePorCategoria(nombreGenero);
    }
    @GetMapping("/id/temporada/top")
    public List<EpisodioDto>top5episodios(@PathVariable Long id){
        return serieService.topEpisodios(id);

    }

}
