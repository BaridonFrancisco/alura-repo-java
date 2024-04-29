package Principal;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        Menu menu=new Menu();
        try {
            DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofPattern("dd/MM/yyyy");
            //
            /*var list=menu.traerAllEpisodes();
            var listOrdenada=menu.ordenarTop5(list);
            listOrdenada.forEach(System.out::println);*/
            var datosTemporada=menu.traerAllTemporadas();
           var episodios=menu.listaEpisodios(datosTemporada);
           menu.filtrarFechas(dateTimeFormatter,episodios);
          /* var mapRating= menu.temporadasRating(episodios);
            System.out.println(mapRating);*/
            //menu.estadisticasPelis(episodios);

            Stream<String> stream1=Stream.of("a","b");
            Stream<String>stream2=Stream.of("c","d");
            var union=Stream.concat(stream1,stream2);
            union.forEach(System.out::println);

        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
    }
}
