package Principal;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamPruebas {
    public static void main(String[] args) {
        Stream<String>streamNombre=Stream.of("Francisco","Gaston","Vero","Gonza","Vero");
       /* var re=streamNombre.allMatch(s->s.charAt(0)==Character.toUpperCase(s.charAt(0)));
        System.out.println(re);*/
        streamNombre.distinct().forEach(System.out::println);

        /*List<Integer>listNums= List.of(3,4,-1,-7,-8,25,11,-5,0);
       var res=listNums.stream()
                .dropWhile(n-> n != 0);
       res.forEach(System.out::println);*/
        List<Integer>listNums2=new ArrayList<>();
        for (int i=1;i<=10;i++){
            listNums2.add(i);
        }
        Optional<Integer> optional= listNums2.parallelStream()
                .filter(n->n%2==0)
                        .findAny();
        if(optional.isPresent()){
            System.out.println(optional.get());
        }else {
            System.out.println("Elemento no presente");
        }


        List<Integer> list = new ArrayList<>();
        for (int i=1;i<=1000000;i++){
            list.add(i);
        }
        Optional<Integer> result = list
                .parallelStream()
                .findAny();

        System.out.println(result.get());


        for(int i=0;i<100;i++){
            Optional<String> optionalt = Stream.of("one", "two", "three", "four").flatMap();

        }

    }
}


