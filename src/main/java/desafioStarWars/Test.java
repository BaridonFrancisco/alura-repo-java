package desafioStarWars;

import java.io.IOException;

public class Test {
    public static void main(String[] args) {
        menuFilms peliculas=new menuFilms();
        //peliculas.menu();

        ManagerFilm managerFilm=new ManagerFilm();
        Logger logger=new Logger();
            //managerFilm.showFilms();
        try {
            //var film= managerFilm.getFilm(1);
            //String path="C:\\Users\\Owner\\Desktop\\Alura\\Alura-repo\\src\\main\\java\\desafioStarWars\\";
            // managerFilm.writeFile(film,new File("C:\\Users\\Owner\\Desktop\\Alura\\Alura-repo\\src\\main\\java\\desafioStarWars\\pelicula.txt"));
            //managerFilm.writeJson(film,path,"peli");
            throw new RuntimeException("sasd");

        } catch (FilmNotFoundException e) {
            logger.writeLoggerFile(e);
            //throw new RuntimeException(e);
            //throw new FilmNotFoundException("Boom");
        } catch (Exception e){
            logger.writeLoggerFile(e);
        }
        System.out.println("aaa");
        //System.out.println(film);
            Film film2=new Film("Superman","xx","xx2","2001-01-11");



    }
}
