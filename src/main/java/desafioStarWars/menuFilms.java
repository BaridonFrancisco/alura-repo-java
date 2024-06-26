package desafioStarWars;

import java.util.Scanner;

public class menuFilms {

    Scanner sc = new Scanner(System.in);
    ManagerFilm managerFilm = new ManagerFilm();
    //private final Logger logger=new Logger();
    private final Logger logger=new Logger.Builder()
            .setPath("C:\\Users\\Owner\\Desktop\\Alura\\Alura-repo\\src\\main\\java\\desafioStarWars\\")
            .setName("log")
            .setMkdir("Logger")
            .build();

    public void menu() {
        int opcion = 0;
        int filmNum;
        while (opcion != 3) {
            try {
                System.out.println("""
                        *---Menu---*
                        1.Mostrar Peliculas.
                        2.Seleccionar Pelicula.
                        3.Salir
                        Seleccione una opcion porfavor""");
                switch (opcion = sc.nextInt()) {
                    case 1 -> {
                        System.out.println("Cargando las peliculas disponibles StarWars");
                        managerFilm.showFilms().forEach(System.out::println);
                    }
                    case 2 -> {
                        System.out.println("Seleccione numero de la pelicula");
                        filmNum = sc.nextInt();
                        Film film=managerFilm.getFilm(filmNum);
                        if(film.getTitle()==null){
                            throw new FilmNotFoundException("Film not found");
                        }
                        System.out.println("Ingrese el nombre del archivo");
                        String filmName=sc.next();
                        managerFilm.writeJson(film,"C:\\Users\\Owner\\Desktop\\Alura\\Alura-repo\\src\\main\\java\\desafioStarWars\\",filmName);

                    }
                    case 3 -> {
                        Thread.sleep(2000);
                        System.out.println("Saliendo");
                    }
                    default -> System.out.println("Opcion incorrecta");

                }
            } catch (Exception e) {
                System.out.println("Error "+e.getMessage());
                logger.writeLoggerFile(e);
                sc.nextLine();
            }
        }
    }
}