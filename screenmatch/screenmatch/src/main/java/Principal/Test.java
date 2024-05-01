package Principal;

import Model.Categoria;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
      /*  Menu menu=new Menu();
        try {
            DateTimeFormatter dateTimeFormatter= DateTimeFormatter.ofPattern("dd/MM/yyyy");
            //
            *//*var list=menu.traerAllEpisodes();
            var listOrdenada=menu.ordenarTop5(list);
            listOrdenada.forEach(System.out::println);*//*
            var datosTemporada=menu.traerAllTemporadas();
           var episodios=menu.listaEpisodios(datosTemporada);
           menu.filtrarFechas(dateTimeFormatter,episodios);
          *//* var mapRating= menu.temporadasRating(episodios);
            System.out.println(mapRating);*//*
            //menu.estadisticasPelis(episodios);



        } catch (JsonProcessingException e) {
            System.out.println(e.getMessage());
        }
        */

        try {
            Menu menu=new Menu();
            var todosEpisodios=menu.traerAllTemporadas();
            System.out.println(todosEpisodios);
            //new SeriesMenu().startMenu();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }



    }
}
