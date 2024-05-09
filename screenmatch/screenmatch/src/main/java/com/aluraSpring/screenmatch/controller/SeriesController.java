package com.aluraSpring.screenmatch.controller;

import com.aluraSpring.screenmatch.dto.SerieDto;
import com.aluraSpring.screenmatch.model.Serie;
import com.aluraSpring.screenmatch.repository.ISerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SeriesController {

    @Autowired
    ISerieRepository iSerieRepository;

    @GetMapping("/series")
    public List<SerieDto> mostrarMensaje(){
        return  iSerieRepository.findAll().stream()
                .map(s->new SerieDto(s.getAnio(),s.getTotalTemporadas(),s.getActores(),s.getGenero(),s.getEvaluacion(),s.getPoster(),s.getSinopsis()))
                .collect(Collectors.toList());
    }
}
