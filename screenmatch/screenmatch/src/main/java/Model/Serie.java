package Model;



import jakarta.persistence.*;

import java.util.List;
import java.util.OptionalDouble;
@Entity
@Table(name = "series")
public class Serie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo",unique = true)
    String titulo;

    String anio;

    String actores;
    @Enumerated(EnumType.STRING)
    Categoria genero;

    Double evaluacion;

    String poster;

    String sinopsis;

    @Transient
    private List<Episodio> listEpisodios;

    public Serie(DatosSerie datosSerie) {
        this.titulo = datosSerie.titulo();
        this.anio = datosSerie.anio();
        this.actores = datosSerie.actores();
        this.evaluacion = OptionalDouble.of(Double.parseDouble(datosSerie.evaluaciones())).orElse(0.0);
        this.genero = Categoria.getGenere(datosSerie.genero().split(",")[0].trim());
        this.actores = datosSerie.actores();
        this.sinopsis = datosSerie.sinopsis();
        this.poster = datosSerie.sinopsis();

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public Categoria getGenero() {
        return genero;
    }

    public void setGenero(Categoria genero) {
        this.genero = genero;
    }

    public Double getEvaluacion() {
        return evaluacion;
    }

    public void setEvaluacion(Double evaluacion) {
        this.evaluacion = evaluacion;
    }

    public String getPoster() {
        return poster;
    }

    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "titulo='" + titulo + '\'' +
                ", anio='" + anio + '\'' +
                ", actores='" + actores + '\'' +
                ", genero=" + genero +
                ", evaluacion=" + evaluacion +
                ", poster='" + poster + '\'' +
                ", sinopsis='" + sinopsis + '\'' +
                '}';
    }
}
