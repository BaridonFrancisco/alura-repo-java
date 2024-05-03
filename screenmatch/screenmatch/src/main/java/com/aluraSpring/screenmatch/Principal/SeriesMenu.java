package com.aluraSpring.screenmatch.Principal;

import com.aluraSpring.screenmatch.Model.DatosSerie;
import com.aluraSpring.screenmatch.Model.Serie;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import com.aluraSpring.screenmatch.repository.ISerieRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class SeriesMenu {
    private Menu menu= new Menu();
    private final Scanner scanner=new Scanner(System.in);
    private List<DatosSerie> datosSeries = new ArrayList<>();

    private ISerieRepository iSerieRepository;

    @Autowired
    public SeriesMenu(ISerieRepository iSerieRepository) {
        this.iSerieRepository = iSerieRepository;
    }

    public void startMenu() throws JsonProcessingException {
        int op;
        System.out.println("bienvenido al menu");
        do {
            System.out.println("""
                    1.Buscar series
                    2.Buscar episodios
                    3.Mostrar series buscadas
                    4.Salir""");
            switch (op= scanner.nextInt()){
                case 1:
                    buscarSerieWeb();
                  break;
                case 2:
                    var temporadas=menu.traerAllTemporadas();
                    var todosEpisodios=menu.listaEpisodios(temporadas);
                    todosEpisodios.forEach(System.out::println);
                    break;
                case 3:
                    mostrarSeriesBuscadas();
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
            scanner.nextLine();
        }while (op!=5);
        scanner.close();
    }

    private void buscarSerieWeb() throws JsonProcessingException {
        DatosSerie datos = menu.buscarSerie();
        Serie serie=new Serie(datos);
        //datosSeries.add(datos);
        iSerieRepository.save(serie);
        System.out.println(datos);

    }
    private void mostrarSeriesBuscadas() {
        List<Serie> series;
        series = datosSeries.stream()
                .map(Serie::new)
                .toList();

        series.stream()
                .sorted(Comparator.comparing(Serie::getGenero))
                .forEach(System.out::println);
    }


}
