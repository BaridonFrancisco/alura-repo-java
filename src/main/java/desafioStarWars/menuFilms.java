package desafioStarWars;

import java.util.Optional;
import java.util.Scanner;
import java.util.function.Supplier;

public class menuFilms {

    Scanner sc = new Scanner(System.in);
    ManagerFilm managerFilm = new ManagerFilm();

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
                        Optional<Film>op= Optional.ofNullable(Optional.ofNullable(managerFilm.getFilm(filmNum))
                                .orElseThrow(RuntimeException::new));
                    }
                    case 3 -> {
                        Thread.sleep(2000);
                        System.out.println("Saliendo");
                    }
                    default -> System.out.println("Opcion incorrecta");

                }
            } catch (Exception e) {
                sc.nextLine();
            }
        }
    }
}