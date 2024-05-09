package com.aluraSpring.screenmatch.model;



import java.util.Arrays;


public enum Categoria {
    ACCION("ACTION"),
    AVENTURA("ADVENTURE"),
    DRAMA("DRAMA"),
    TERROR("Horror"),
    DESCONOCIDA("UNKNOW");

    private final String value;

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
