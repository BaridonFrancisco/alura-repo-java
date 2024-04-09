package desafioTarjetaDebito;


import java.util.Optional;
import java.util.Scanner;

public class Persona {
    private String nombre;
    private String apellido;
    private TarjetaDebito tarjetaCredito;
    private final Scanner sc=new Scanner(System.in);

    public Persona(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;

    }

    private TarjetaDebito resgistrarTarjeta(){
        TarjetaDebito tarjetaNueva=new TarjetaDebito();
        System.out.println("Ingrese el monto maximo  de su tarjeta ");
        tarjetaNueva.setMontoMaximo(sc.nextDouble());
        tarjetaNueva.setMonto(0);
        tarjetaNueva.setActiva(true);
        tarjetaCredito=tarjetaNueva;
        return tarjetaNueva;

    }
    public void menuUsuario(){
        Optional<TarjetaDebito>tarjeta=Optional.ofNullable(tarjetaCredito);
        String nombreProducto;
        double precioProducto;
        int opcion;



        do{
            System.out.println("""
                    1.RegistrarTarjeta;
                    2.Dar de baja la Tarjeta
                    3.Cargar Saldo
                    4.Dar de alta la tarjeta
                    5.Comprar Producto
                    6.Mostar resumen de la tarjeta
                    7.Salir
                    Ingrese una opcion porfavor""");
            opcion=sc.nextInt();
            switch (opcion){
                case 1:
                    if (tarjeta.isEmpty()) tarjeta=Optional.of(resgistrarTarjeta());
                    break;
                case 2:
                    if(tarjeta.isPresent()) tarjetaCredito.setActiva(false);
                    break;
                case 3:
                    System.out.println(tarjeta.isPresent());
                    if(tarjeta.isPresent()){
                        double monto;
                        System.out.println(tarjetaCredito);
                        System.out.println("Ingrese un su monto para depositar en su cuenta");
                        monto=sc.nextDouble();
                        tarjetaCredito.cargarSaldo(monto);
                    }
                    break;
                case 4:
                    if(tarjeta.isPresent()) tarjetaCredito.setActiva(true);
                    break;
                case 5:
                    if(tarjeta.isPresent()){
                        sc.nextLine();
                        System.out.println("Ingrese el nombre del producto");
                        nombreProducto = sc.nextLine();
                        System.out.println("Ingrese el precio del producto");
                        precioProducto=sc.nextDouble();
                        Compras producto=new Compras(nombreProducto,precioProducto);
                        tarjetaCredito.comprarItem(producto);
                    }
                    break;
                case 6:
                    if(tarjeta.isPresent()) System.out.println(tarjetaCredito.datosTarjeta());
                    break;
                case 7:
                    try{
                        System.out.println("Saliendo...");
                        Thread.sleep(3000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("Error opcion incorrecta");
                    break;
            }
        }while(opcion != 7);
    }

    private boolean comprobarTarjeta(){
        return Optional.ofNullable(tarjetaCredito).isPresent();
    }




}
