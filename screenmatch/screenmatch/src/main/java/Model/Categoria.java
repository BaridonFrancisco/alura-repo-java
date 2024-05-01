package Model;

import java.util.Arrays;


public enum Categoria {
    ACCION("ACTION"), AVENTURA("ADVENTURE"), DRAMA("DRAMA"), DESCONOCIDA("UNKNOW");

    private String value;

    Categoria(String value) {
        this.value = value;
    }

    public static Categoria getGenere(String categoria) {

       return Arrays.stream(Categoria.values()).
                filter(cat -> cat.value.equalsIgnoreCase(categoria))
                .findFirst()
                .orElse(Categoria.DESCONOCIDA);


    }
}
