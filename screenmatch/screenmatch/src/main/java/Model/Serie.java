package Model;



import java.util.OptionalDouble;

public class Serie {

    String titulo;

    String anio;

    String actores;

    Categoria genero;

    Double evaluacion;

    String poster;

    String sinopsis;

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
