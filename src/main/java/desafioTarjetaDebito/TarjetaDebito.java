package desafioTarjetaDebito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TarjetaDebito {

    List<Compras> historial = new ArrayList<>();
    private double montoMaximo;
    private double monto;
    private boolean activa;

    public TarjetaDebito() {
    }

    public TarjetaDebito(double montoMaximo, double monto, boolean activa) {
        this.historial = new ArrayList<>();
        this.montoMaximo = montoMaximo;
        this.monto = monto;
        this.activa = activa;
    }

    public List<Compras> getListaCompras() {
        return historial;
    }


    public void setMonto(double monto) {
        this.monto = monto;
    }

    public void setMontoMaximo(double montoMaximo) {
        this.montoMaximo = montoMaximo;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public void comprarItem(Compras compra) {
        if (this.monto >= compra.getPrecio() && isActiva()) {
            this.monto -= compra.getPrecio();
            this.historial.add(compra);
        } else {
            System.out.println("Compra rechazada");
        }
    }

    public void cargarSaldo(double monto) {
        if (!(cuentaVacia()) && monto > 0 && this.monto + monto <= this.montoMaximo && isActiva()) {
            this.monto += monto;
        }else {
            System.out.println("No se a podido cargar saldo revise el estado de su tarjeta");
        }
    }

    public boolean cuentaVacia() {
        return monto < 0;
    }

    public double mostrarSaldo() {
        return monto;
    }

    public void mostrarHistorialCompras() {
        getListaCompras().forEach(System.out::println);
    }

    public String datosTarjeta() {
        Collections.sort(historial);
        return String.format(
                """
                        Información de la tarjeta:
                        ---------------------------
                        Monto máximo: %.2f
                        Monto disponible: %.2f
                        Historial de compras:
                        %s
                        """,
                montoMaximo,
                monto,
                getListaCompras()
        );
    }


    @Override
    public String toString() {
        return "CreditCard{" +
                ", montoMaximo=" + montoMaximo +
                ", monto=" + monto +
                ", activa=" + activa +
                '}';
    }
}
