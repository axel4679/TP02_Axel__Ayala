package ar.edu.unju.fi.ejercicio7.main;

import ar.edu.unju.fi.ejercicio1.model.Producto;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Precarga de productos
        List<Producto> productos = cargarProductos();

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú de opciones:");
            System.out.println("1 - Mostrar productos disponibles");
            System.out.println("2 - Mostrar productos faltantes");
            System.out.println("3 - Incrementar precios de productos");
            System.out.println("4 - Mostrar productos de categoría Electrohogar disponibles");
            System.out.println("5 - Ordenar productos por precio descendente");
            System.out.println("6 - Mostrar los nombres de los productos en mayúsculas");
            System.out.println("7 - Salir");
            System.out.print("Elija una opción: ");

            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarProductosDisponibles(productos);
                    break;
                case 2:
                    mostrarProductosFaltantes(productos);
                    break;
                case 3:
                    productos = incrementarPrecios(productos);
                    System.out.println("Precios incrementados en un 20%.");
                    break;
                case 4:
                    mostrarProductosElectrohogarDisponibles(productos);
                    break;
                case 5:
                    ordenarProductosPorPrecioDescendente(productos);
                    break;
                case 6:
                    mostrarNombresEnMayusculas(productos);
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 7);

        scanner.close();
    }

    private static List<Producto> cargarProductos() {
        List<Producto> productos = new ArrayList<>();
        // Aquí agregas tus productos al ArrayList
        return productos;
    }

    private static void mostrarProductosDisponibles(List<Producto> productos) {
        System.out.println("Productos disponibles:");
        productos.stream()
                .filter(Producto::isDisponible)
                .forEach(System.out::println);
    }

    private static void mostrarProductosFaltantes(List<Producto> productos) {
        System.out.println("Productos faltantes:");
        productos.stream()
                .filter(producto -> !producto.isDisponible())
                .forEach(System.out::println);
    }

    private static List<Producto> incrementarPrecios(List<Producto> productos) {
        return productos.stream()
                .map(producto -> new Producto(producto.getCodigo(), producto.getDescripcion(), producto.getPrecio() * 1.20, producto.getOrigenFabricacion(), producto.getCategoria()))
                .collect(Collectors.toList());
    }

    private static void mostrarProductosElectrohogarDisponibles(List<Producto> productos) {
        System.out.println("Productos de categoría Electrohogar disponibles:");
        productos.stream()
                .filter(producto -> producto.getCategoria() == Producto.Categoria.ELECTROHOGAR && producto.isDisponible())
                .forEach(System.out::println);
    }

    private static void ordenarProductosPorPrecioDescendente(List<Producto> productos) {
        System.out.println("Productos ordenados por precio descendente:");
        productos.stream()
                .sorted(Comparator.thenComparingDouble(Producto::getPrecio).reversed())
                .forEach(System.out::println);
    }

    private static void mostrarNombresEnMayusculas(List<Producto> productos) {
        System.out.println("Nombres de productos en mayúsculas:");
        productos.stream()
                .map(producto -> producto.getDescripcion().toUpperCase())
                .forEach(System.out::println);
    }
}


