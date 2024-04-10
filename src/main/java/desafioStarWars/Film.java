package desafioStarWars;

import java.time.LocalDate;

public class Film {

    private String title;
    private String director;
    private String productor;
    private LocalDate  fechaLanzamiento;

    public Film() {
    }

    public Film(String title, String director, String productor, LocalDate fechaLanzamiento) {
        this.title = title;
        this.director = director;
        this.productor = productor;
        this.fechaLanzamiento = fechaLanzamiento;
    }
}
