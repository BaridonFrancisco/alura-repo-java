package desafioStarWars;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

public class Test {
    public static void main(String[] args) {
        menuPeliculas peliculas=new menuPeliculas();
        //peliculas.menu();

        ManagerFilm managerFilm=new ManagerFilm();

            //managerFilm.showFilms();
        try {
            var film= managerFilm.getFilm(1);
            String path="C:\\Users\\Owner\\Desktop\\Alura\\Alura-repo\\src\\main\\java\\desafioStarWars\\";
            // managerFilm.writeFile(film,new File("C:\\Users\\Owner\\Desktop\\Alura\\Alura-repo\\src\\main\\java\\desafioStarWars\\pelicula.txt"));
            managerFilm.writeJson(film,path,"peli");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }catch (FilmNotFoundException e){

        }
        //System.out.println(film);
            Film film2=new Film("Superman","xx","xx2","2001-01-11");



    }
}
