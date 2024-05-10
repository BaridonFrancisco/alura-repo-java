package com.aluraSpring.screenmatch.service;

import com.aluraSpring.screenmatch.dto.EpisodioDto;
import com.aluraSpring.screenmatch.dto.SerieDto;
import com.aluraSpring.screenmatch.model.Categoria;
import com.aluraSpring.screenmatch.model.Serie;
import com.aluraSpring.screenmatch.repository.ISerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SerieService {
    @Autowired
    private ISerieRepository iSerieRepository;
    public List<SerieDto> obtenerSeries(){
        return  convertToListDto(iSerieRepository.findAll());
    }

    public List<SerieDto> top5Series() {
        return convertToListDto(iSerieRepository.findTop5ByOrderByEvaluacionDesc());
    }

    public List<SerieDto>lanzamientoRecientes(){
        return convertToListDto(iSerieRepository.ultimosLanzamientos());
    }
    private List<SerieDto>convertToListDto(List<Serie>listSerie){
        return listSerie.stream()
                .map(s -> new SerieDto(s.getId(),s.getAnio(),s.getTitulo(), s.getTotalTemporadas(), s.getActores(), s.getGenero(), s.getEvaluacion(),
                        s.getPoster(), s.getSinopsis()))
                .collect(Collectors.toList());
    }


    public SerieDto obtenerPorId(Long id) {
        Optional<Serie>var=iSerieRepository.findById(id);
        if(var.isPresent()){
           Serie serie=var.get();
           return new SerieDto(serie.getId(),serie.getAnio(), serie.getTitulo(), serie.getTotalTemporadas(), serie.getActores(), serie.getGenero(), serie.getEvaluacion(),
                   serie.getPoster(), serie.getSinopsis());
        }
        return null;
    }

    public List<EpisodioDto> obtenerTodasLastemp(Long id) {
        Optional<Serie> op=iSerieRepository.findById(id);
        if(op.isPresent()){
            Serie s=op.get();
            return  s.getListEpisodios().stream()
                    .map(e->new EpisodioDto(e.getTemporada(),e.getTitulo(),e.getNumeroEpisodio()))
                    .collect(Collectors.toList());
        }
        return  null;
    }

    public List<EpisodioDto> obtenerTemporadaPorNumero(Long id,
                                                       Long numeroTemporadas){
        return iSerieRepository.obtenerPorNumeroTemporada(id,numeroTemporadas).stream()
                .map(e->new EpisodioDto(e.getTemporada(),e.getTitulo(),e.getNumeroEpisodio()))
                .collect(Collectors.toList());
    }

    public List<SerieDto> obtenerSeriePorCategoria(String nombreGenero) {
        Categoria categoria=Categoria.getGenere(nombreGenero);
        return convertToListDto(iSerieRepository.findByGenero(categoria));


    }
}
