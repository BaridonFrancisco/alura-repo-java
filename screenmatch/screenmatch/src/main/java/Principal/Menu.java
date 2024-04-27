package Principal;

import Model.DatosEpisodio;
import Model.DatosPorTemporada;
import Model.DatosSerie;
import Model.Episodio;
import Service.ConsumoAPI;
import Service.ConvertirDatos;
import Service.IConvertirDatos;
import com.fasterxml.jackson.core.JsonProcessingException;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Menu {
    private ConsumoAPI consumoApi=new ConsumoAPI();
    private IConvertirDatos convertirDatos= new ConvertirDatos();
    private Scanner sc=new Scanner(System.in);
    static final String URL_BASE="https://www.omdbapi.com/?t=";
    private  final String API_KEY="2d969581";
    String urlSerie;
    private String nombreSerie;
    public DatosSerie buscarSerie() throws JsonProcessingException {
        System.out.println("Ingrese el nombre de la serie");
        nombreSerie= sc.nextLine().replace(" ","+");
        System.out.println(nombreSerie);
        urlSerie=URL_BASE+nombreSerie+"&apikey="+API_KEY;
        String respuesta=consumoApi.obtenerDatos(urlSerie);
        return convertirDatos.convertirDatos(respuesta,DatosSerie.class);
    }
    public List<DatosPorTemporada> traerAllTemporadas() throws JsonProcessingException {
        var datosSerie=buscarSerie();
        String json;
       List<DatosPorTemporada> listTemporadas=new ArrayList<>();
        for (int i=1;i<=datosSerie.numero();i++){
            json=consumoApi.obtenerDatos(URL_BASE+nombreSerie+"&Season="+i+"&apikey="+API_KEY);
            var datosTemporada=convertirDatos.convertirDatos(json,DatosPorTemporada.class);
            listTemporadas.add(datosTemporada);
        }
        return listTemporadas;
    }
    public List<DatosEpisodio> traerAllEpisodes() throws JsonProcessingException {
       var listTemporadas=traerAllTemporadas();
       return listTemporadas.stream()
               .flatMap(t -> t.episodios().stream())
               .toList();
    }
    public List<DatosEpisodio> ordenarTop5(List<DatosEpisodio>lista){
        return lista.stream()
                .filter(e->!e.evaluacion().equalsIgnoreCase("N/A"))
                .sorted(Comparator.comparing(DatosEpisodio::evaluacion).reversed())
                .limit(5)
                .toList();
    }

    //convertir de Datos temporada a List<Episodios>
    // para tranformar la fecha a LocalDate
    public List<Episodio> listaEpisodios(List<DatosPorTemporada>temporadas){
         return temporadas.stream()
                        .flatMap(temporada->temporada.episodios().stream()
                                .map(episodio->new Episodio(temporada.numeroTemporada(),episodio)))
                        .toList();


    }
    public void filtrarFechas(DateTimeFormatter dateFormat, List<Episodio>listaEp){
        System.out.println("Apartir de que anio deseas ver los episodios?");
        int anio=sc.nextInt();
        listaEp.stream()
                .filter(e->e.getFechaDeLanzamiento().isAfter(LocalDate.of(anio,1,1))&& e.getFechaDeLanzamiento()!=null)
                .forEach(element-> System.out.println("Temporada "+element.getTemporada()+" \ntitulo episodio "+element.getTitulo()+"\nfecha lanzamiento"+element.getFechaDeLanzamiento().format(dateFormat)));
    }

    public Map<Integer,Double> temporadasRating(List<Episodio>listEp){

        return listEp.stream()
                .filter(e->e.getEvaluacion()!=0.0)
                .collect(Collectors.groupingBy(Episodio::getTemporada,
                        Collectors.averagingDouble(Episodio::getEvaluacion)));
    }

    public void estadisticasPelis(List<Episodio>listEp) {
        DoubleSummaryStatistics doubleSummaryStatistics = listEp.stream()
                .filter(e->e.getEvaluacion()>0.0)
                .mapToDouble(Episodio::getEvaluacion)
                .summaryStatistics();
        System.out.println(doubleSummaryStatistics);
    }
}