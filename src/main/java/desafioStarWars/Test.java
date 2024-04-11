package desafioStarWars;

import java.io.File;
import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        menuPeliculas peliculas=new menuPeliculas();
        //peliculas.menu();

        ManagerFilm managerFilm=new ManagerFilm();


            //managerFilm.showFilms();
        try {
            var film= managerFilm.getFilm(1);
            managerFilm.writeFile(film,new File("C:\\Users\\Owner\\Desktop\\Alura\\Alura-repo\\src\\main\\java\\desafioStarWars\\pelicula.txt"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //System.out.println(film);
            Film film2=new Film("Superman","xx","xx2","2001-01-11");



    }
}
