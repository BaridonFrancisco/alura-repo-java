
public class Pruebas {
    public static void main(String[] args) {

    }

}

class Element<T extends Number>{
    private final T t;

    public Element(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public <A extends Number> Number sum(A valor) {
        // Use the sumGeneric method with a more restrictive type parameter
        return this.t.doubleValue() + sumGeneric(valor).doubleValue();
    }

    // Restrict the type parameter of sumGeneric to extend Number
    private <A extends Number> A sumGeneric(A valor) {
        return valor;
    }

}