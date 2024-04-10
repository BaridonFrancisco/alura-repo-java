package desafioStarWars;

import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        menuPeliculas peliculas=new menuPeliculas();
        //peliculas.menu();

        ManagerFilm managerFilm=new ManagerFilm();

        try {
            managerFilm.showFilms();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
