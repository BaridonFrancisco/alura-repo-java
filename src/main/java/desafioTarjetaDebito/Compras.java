package desafioTarjetaDebito;

import java.util.Comparator;

public class Compras implements Comparable<Compras> {

    private String nombre;
    private double precio;

    public Compras(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Compra{" +
                "nombre='" + nombre + '\'' +
                "precio=" + precio +
                "}\n";
    }

    @Override
    public int compareTo(Compras o) {
        if(this.precio>o.getPrecio()){
            return 1;
        } else if (this.precio<o.getPrecio()) {
            return -1;
        }
        return 0;
    }
}
