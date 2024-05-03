package Principal;

import Model.DatosSerie;
import Model.Serie;
import Service.ISerieRepository;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class SeriesMenu {
    private Menu menu;
    private final Scanner scanner=new Scanner(System.in);
    private List<DatosSerie> datosSeries = new ArrayList<>();
    ISerieRepository iSerieRepository;
    public SeriesMenu() {
        this.menu = new Menu();
    }

    public SeriesMenu( ISerieRepository iSerieRepository) {
        this.menu =new Menu();
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
                    4.""");
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
