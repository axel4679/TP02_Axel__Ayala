package ar.edu.unju.fi.ejercicio5.model;



import ar.edu.unju.fi.ejercicio5.interfaces.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PagoEfectivo implements Pago {
    private double montoPagado;
    private LocalDate fechaPago;

    public PagoEfectivo(double montoPagado, LocalDate fechaPago) {
        this.montoPagado = montoPagado;
        this.fechaPago = fechaPago;
    }

    @Override
    public void realizarPago(double monto) {
        montoPagado = monto * 0.9; // Aplicar un 10% de descuento
    }

    @Override
    public void imprimirRecibo() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        System.out.println("Fecha de pago: " + fechaPago.format(formatter));
        System.out.println("Monto pagado: " + montoPagado);
    }
    
}