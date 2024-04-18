package desafioStarWars;




import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class test2 {
    public static void main(String[] args){

      /*  String cadena= """
                 ----Pelicula----
                 Titulo: A New Hope
                 Director: George Lucas
                 Productor: Gary Kurtz, Rick McCallum
                 Ars:15
                 Us:600
                 Lanzamiento: 1977-05-25
                """;
        System.out.println(cadena.indexOf(':'));
        String entrada="a";
        String [] division=cadena.split("\n");
       var map= Stream.of(division).filter(devisa->devisa.contains("Ars"))
                .map(String::trim)
                        .collect(Collectors.toMap(
                                moneda->moneda.substring(0,moneda.indexOf(':')),
                        precio->precio.substring(precio.indexOf(':')+1)));



        map.forEach((k,v)-> System.out.println(k+v));

        System.out.println(map.get("Ars"));

        for (Map.Entry<String, String> entry : map.entrySet()) {
            String key= entry.getKey();
            String value = entry.getValue();
            System.out.println("key: " + key+ ", value: " + value);
        }*/
        menuFilms menuFilms=new menuFilms();
        menuFilms.menu();

    }
}
