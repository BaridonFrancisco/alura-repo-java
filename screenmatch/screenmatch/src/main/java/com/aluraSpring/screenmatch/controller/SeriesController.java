package com.aluraSpring.screenmatch.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SeriesController {
    @GetMapping("/series")
    public String mostrarMensaje(){
        return "hola francisco mensaje desde restCotroller";
    }
}
