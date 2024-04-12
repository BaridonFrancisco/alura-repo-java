package desafioStarWars;

import java.util.Scanner;

public class menuFilms {

    Scanner sc = new Scanner(System.in);

    public void menu() {
        int opcion=0;

        while (opcion!=3) {
            try {
                System.out.println("""
                        *---Menu---*
                        1.Mostrar Peliculas.
                        2.Seleccionar Peliculas.
                        3.Salir
                        Seleccione una opcion porfavor""");
            switch (opcion=sc.nextInt()){
                case 1 -> {
                    System.out.println("sa");
                    System.out.println("sa");
                }
                case 2-> System.out.println("2");
                case 3-> System.out.println("salir");
                default -> System.out.println("Opcion incorrecta");

            }
            } catch (Exception e) {
                sc.nextLine();
            }
        }
    }
}