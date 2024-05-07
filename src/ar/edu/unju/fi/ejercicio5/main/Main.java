package ar.edu.unju.fi.ejercicio5.main;


import ar.edu.unju.fi.ejercicio5.interfaces.Pago;
import ar.edu.unju.fi.ejercicio5.model.*;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Precarga de productos
        ArrayList<Producto> productos = precargarProductos();

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú de opciones:");
            System.out.println("1 - Mostrar productos");
            System.out.println("2 - Realizar compra");
            System.out.println("3 - Salir");
            System.out.print("Elija una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        mostrarProductos(productos);
                        break;
                    case 2:
                        realizarCompra(productos, scanner);
                        break;
                    case 3:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número entero correspondiente a la opción.");
                scanner.nextLine(); // Limpiar el buffer
                opcion = 0; // Reiniciar la opción para evitar un bucle infinito
            }
        } while (opcion != 3);

        scanner.close();
    }

    private static ArrayList<Producto> precargarProductos() {
        ArrayList<Producto> productos = new ArrayList<>();
        // Supongamos que se precargan los productos
        // Aquí se agregan 15 productos con su respectivo estado
        // Ejemplo:
        for (int i = 0; i < 15; i++) {
            Producto producto = new Producto("P" + i, "Descripción del producto " + i, 100 * i, i % 2 == 0);
            productos.add(producto);
        }
        return productos;
    }

    private static void mostrarProductos(ArrayList<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos disponibles.");
        } else {
            System.out.println("Listado de productos:");
            for (Producto producto : productos) {
                System.out.println(producto);
            }
        }
    }

    private static void realizarCompra(ArrayList<Producto> productos, Scanner scanner) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos disponibles para comprar.");
            return;
        }

        // Supongamos que el usuario selecciona algunos productos para comprar
        // Creamos un ArrayList para almacenar los productos seleccionados
        ArrayList<Producto> productosSeleccionados = new ArrayList<>();
        // Supongamos que se han seleccionado algunos productos y se han agregado a productosSeleccionados

        // Calculamos el monto total de la compra sumando los precios de los productos seleccionados
        double montoTotal = 0;
        for (Producto producto : productosSeleccionados) {
            montoTotal += producto.getPrecio();
        }

        System.out.println("Monto total a pagar: " + montoTotal);

        // Mostramos las opciones de pago
        System.out.println("Seleccione el método de pago:");
        System.out.println("1 - Pago efectivo");
        System.out.println("2 - Pago con tarjeta");
        int opcionPago = scanner.nextInt();
     

        Pago pago;
        switch (opcionPago) {
            case 1:
                pago = new PagoEfectivo(montoTotal, LocalDate.now());
                break;
            case 2:
                System.out.print("Ingrese el número de tarjeta: ");
                String numeroTarjeta = scanner.nextLine();
                pago = new PagoTarjeta(numeroTarjeta, LocalDate.now(), montoTotal);
                break;
            default:
                System.out.println("Opción de pago inválida.");
                return;
        }

        try {
            pago.realizarPago(montoTotal);
            pago.imprimirRecibo();
        } catch (Exception e) {
            System.out.println("Error al realizar el pago: " + e.getMessage());
        }
    }
}