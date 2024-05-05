package com.aluraSpring.screenmatch.principal;

import com.aluraSpring.screenmatch.model.Categoria;
import com.aluraSpring.screenmatch.model.DatosSerie;
import com.aluraSpring.screenmatch.model.Episodio;
import com.aluraSpring.screenmatch.model.Serie;
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
                    5.Top 5 mejores series
                    6.Buscar por categoria
                    7.Buscar series por temporadas y evaluacion
                    8.Buscar episodio por nombre
                    9.Top 5 episodios
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
                case 5:
                    buscarTop5Series();
                    break;
                case 6:
                    buscarPorCategoria();
                    break;
                case 7:
                    buscarPorEvaluacion_Temporadas();
                    break;
                case 8:
                    buscarEpisodioPorNombre();
                    break;
                case 9:
                    top5Episodios();
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
            scanner.nextLine();
        }while (op!=0);
        scanner.close();
    }

    private void top5Episodios() throws JsonProcessingException {
       var op=iSerieRepository.findByTitulo("The Walking Dead");
        op.ifPresent(opt->{
            List<Episodio> listaEp = iSerieRepository.top5Episodios(opt);
            listaEp.forEach(System.out::println);
        });




    }

    private void buscarEpisodioPorNombre() throws JsonProcessingException {
        List<Episodio>listEpisodio=iSerieRepository.episodiosPorNombre("Episode #1.1");
        listEpisodio.forEach(System.out::println);

    }

    private void buscarPorEvaluacion_Temporadas() {
        scanner.nextLine();
        System.out.println("Ingrese el numero temporadas");
        Integer totalTemporadas=scanner.nextInt();
        System.out.println("Ingrese la evaluacion de la serie");
        Double evaluacion=scanner.nextDouble();
        List<Serie>re=iSerieRepository.findTemporadasEvaluaciones(totalTemporadas,evaluacion);
        re.forEach(System.out::println);
    }

    private void buscarPorCategoria() {
       /* System.out.println("Ingrese el nombre de la categoria");
        String categoria= scanner.nextLine().trim();*/
        List<Serie>seriePorCategoria=iSerieRepository.findByGenero(Categoria.ACCION);
        if(!seriePorCategoria.isEmpty()){
            seriePorCategoria.forEach(System.out::println);
        }else{
            System.out.println("categoria no encontrada");
        }

    }

    private void buscarTop5Series() {
        List<Serie>series=iSerieRepository.findTop5ByOrderByEvaluacionDesc();
        series.forEach(s->System.out.println("Titulo: "+s.getTitulo()+" Evaluacion: "+s.getEvaluacion()));

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
