package ar.edu.unju.fi.ejercicio5.model;



import ar.edu.unju.fi.ejercicio5.interfaces.Pago;
import java.time.LocalDate;


public class PagoTarjeta implements Pago {
    private String numeroTarjeta;
    private LocalDate fechaPago;
    private double montoPagado;

    public PagoTarjeta(String numeroTarjeta, LocalDate fechaPago, double montoPagado) {
        this.numeroTarjeta = numeroTarjeta;
        this.fechaPago = fechaPago;
        this.montoPagado = montoPagado;
    }

    @Override
    public void realizarPago(double monto) {
      
        this.montoPagado = monto * 1.15;     }

    @Override
    public void imprimirRecibo() {
        System.out.println("Recibo de pago con tarjeta:");
        System.out.println("Número de tarjeta: " + numeroTarjeta);
        System.out.println("Fecha de pago: " + fechaPago);
        System.out.println("Monto pagado: " + montoPagado);
    }
    }

