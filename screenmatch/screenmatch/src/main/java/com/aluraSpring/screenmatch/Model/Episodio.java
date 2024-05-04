package com.aluraSpring.screenmatch.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
@Entity
@Table(name="episodio")
public class Episodio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer temporada;
    private String titulo;
    private Integer numeroEpisodio;
    private Double evaluacion;
    private LocalDate fechaDeLanzamiento;
    @ManyToOne
    private Serie serie;

    public Episodio(Integer temporada,DatosEpisodio datosEpisodio) {
        this.temporada = temporada;
        this.titulo = datosEpisodio.titulo();
        this.numeroEpisodio = datosEpisodio.numeroEpisodio();
        try{
            this.evaluacion = Double.parseDouble(datosEpisodio.evaluacion());
        }catch (NumberFormatException e){
            this.evaluacion=0.0;
        }
        this.fechaDeLanzamiento = LocalDate.parse(datosEpisodio.fechaLanzamiento());
    }

    public Episodio() {
    }

    public Integer getTemporada() {
        return temporada;
    }

    public String getTitulo() {
        return titulo;
    }

    public Integer getNumeroEpisodio() {
        return numeroEpisodio;
    }

    public Double getEvaluacion() {
        return evaluacion;
    }

    public LocalDate getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    @Override
    public String toString() {
        return "Episodio{" +
                "temporada=" + temporada +
                ", titulo='" + titulo + '\'' +
                ", numeroEpisodio=" + numeroEpisodio +
                ", evaluacion=" + evaluacion +
                ", fechaDeLanzamiento=" + fechaDeLanzamiento +
                '}';
    }
}
