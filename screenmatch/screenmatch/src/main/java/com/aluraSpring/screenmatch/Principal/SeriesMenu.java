package com.aluraSpring.screenmatch.Principal;

import com.aluraSpring.screenmatch.Model.DatosSerie;
import com.aluraSpring.screenmatch.Model.Episodio;
import com.aluraSpring.screenmatch.Model.Serie;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import com.aluraSpring.screenmatch.repository.ISerieRepository;

import java.util.*;


public class SeriesMenu {
    private Menu menu= new Menu();
    private final Scanner scanner=new Scanner(System.in);
    private List<DatosSerie> datosSeries = new ArrayList<>();
    List<Serie>series=new ArrayList<>();
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
                    4.Buscar serie por titulo
                    4.Salir""");
            switch (op= scanner.nextInt()){
                case 1:
                    buscarSerieWeb();
                  break;
                case 2:
                    buscarEpisodioPorSerie();
                    break;
                case 3:
                    listaSeriesBuscadas();
                    break;
                case 4:
                    System.out.println("Saliendo");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
            scanner.nextLine();
        }while (op!=0);
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

    private void listaSeriesBuscadas(){
        this.series=iSerieRepository.findAll();
                this.series.stream()
                        .sorted(Comparator.comparing(Serie::getGenero))
                        .forEach(System.out::println);
    }

    private void buscarEpisodioPorSerie() throws JsonProcessingException {
        scanner.nextLine();
        listaSeriesBuscadas();
        System.out.println("Escriba el nombre de la serie que desea ver");
        var nombreSerie = scanner.nextLine();
        Optional<Serie> serie = series.stream()
                .filter(s -> s.getTitulo().toLowerCase().contains(nombreSerie.toLowerCase()))
                .findFirst();
        if(serie.isPresent()){
            Serie s=serie.get();
            var re=menu.traerAllTemporadas(nombreSerie,s.getTotalTemporadas());
            var episodios=menu.listaEpisodios(re);
            episodios.forEach(ep->ep.setSerie(s));
            s.setListEpisodios(episodios);
            System.out.println("size"+serie.get().getListEpisodios().size());

            iSerieRepository.save(s);


        }




    }


}
