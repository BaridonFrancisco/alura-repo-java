 package desafioTarjetaDebito;


public class Test {
    public static void main(String[] args) {
        TarjetaDebito tarjeta=new TarjetaDebito(20000,20000,true);

        Compras compra1=new Compras("Remera",20000);
        tarjeta.comprarItem(compra1);
        tarjeta.mostrarHistorialCompras();
        tarjeta.cargarSaldo(1000.0);
        System.out.println(tarjeta.mostrarSaldo()+"$");

        Persona persona=new Persona("Francisco","Baridon");
        persona.menuUsuario();


    }
}
