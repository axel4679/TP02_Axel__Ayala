package ar.edu.unju.fi.ejercicio1.main;

import ar.edu.unju.fi.ejercicio1.model.*;
import ar.edu.unju.fi.ejercicio1.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio1.model.Producto.OrigenDeFabricacion;

import java.util.ArrayList;
import java.util.List;




import ar.edu.unju.fi.ejercicio1.model.Producto;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Producto> listado = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("Menú de opciones:");
            System.out.println("1 - Crear Producto");
            System.out.println("2 - Mostrar productos");
            System.out.println("3 - Modificar producto");
            System.out.println("4 - Salir");
            System.out.print("Elija una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        crearProducto(listado, scanner);
                        break;
                    case 2:
                        mostrarProductos(listado);
                        break;
                    case 3:
                        modificarProducto(listado, scanner);
                        break;
                    case 4:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, elija una opción del 1 al 4.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número entero correspondiente a la opción.");
                scanner.nextLine(); // Limpiar el buffer
                opcion = 0; // Reiniciar la opción para evitar un bucle infinito
            }
        } while (opcion != 4);

        scanner.close();
    }

    private static void crearProducto(List<Producto> listado, Scanner scanner) {
        System.out.println("Ingrese los datos del nuevo producto:");
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Precio unitario: ");
        double precioUnitario = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer
        System.out.println("Origen de fabricación:");
        Producto.mostrarOpcionesOrigenFabricacion();
        System.out.print("Elija una opción: ");
        int origenIndex = scanner.nextInt();
        Producto.OrigenDeFabricacion origen = Producto.OrigenDeFabricacion.values()[origenIndex - 1];
        scanner.nextLine(); // Limpiar el buffer
        System.out.println("Categoría:");
        Producto.mostrarOpcionesCategoria();
        System.out.print("Elija una opción: ");
        int categoriaIndex = scanner.nextInt();
        Producto.Categoria categoria = Producto.Categoria.values()[categoriaIndex - 1];
        scanner.nextLine(); // Limpiar el buffer

        Producto nuevoProducto = new Producto(codigo, descripcion, precioUnitario, origen, categoria);
        listado.add(nuevoProducto);
        System.out.println("Producto creado exitosamente.");
    }

    private static void mostrarProductos(List<Producto> listado) {
        if (listado.isEmpty()) {
            System.out.println("No hay productos para mostrar.");
        } else {
            System.out.println("Listado de productos:");
            for (Producto producto : listado) {
                System.out.println(producto.getCodigo() + " - " + producto.getDescripcion() + " - $" + producto.getPrecioUnitario()
                        + " - Origen: " + producto.getOrigenFabricacion().name() + " - Categoría: " + producto.getCategoria().name());
            }
        }
    }

    private static void modificarProducto(List<Producto> listado, Scanner scanner) {
        if (listado.isEmpty()) {
            System.out.println("No hay productos para modificar.");
        } else {
            System.out.println("Ingrese el código del producto que desea modificar:");
            String codigo = scanner.nextLine();
            boolean encontrado = false;
            for (Producto producto : listado) {
                if (producto.getCodigo().equals(codigo)) {
                    encontrado = true;
                    System.out.println("¿Qué desea modificar?");
                    System.out.println("1 - Descripción");
                    System.out.println("2 - Precio unitario");
                    System.out.println("3 - Origen de fabricación");
                    System.out.println("4 - Categoría");
                    System.out.print("Elija una opción: ");
                    int opcion = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer

                    switch (opcion) {
                        case 1:
                            System.out.print("Ingrese la nueva descripción: ");
                            String nuevaDescripcion = scanner.nextLine();
                            producto.setDescripcion(nuevaDescripcion);
                            System.out.println("Descripción modificada exitosamente.");
                            break;
                        case 2:
                            System.out.print("Ingrese el nuevo precio unitario: ");
                            double nuevoPrecio = scanner.nextDouble();
                            producto.setPrecioUnitario(nuevoPrecio);
                            System.out.println("Precio unitario modificado exitosamente.");
                            break;
                        case 3:
                            System.out.println("Nuevo origen de fabricación:");
                            Producto.mostrarOpcionesOrigenFabricacion();
                            System.out.print("Elija una opción: ");
                            int origenIndex = scanner.nextInt();
                            Producto.OrigenDeFabricacion nuevoOrigen = Producto.OrigenDeFabricacion.values()[origenIndex - 1];
                            scanner.nextLine(); // Limpiar el buffer
                            producto.setOrigenFabricacion(nuevoOrigen);
                            System.out.println("Origen de fabricación modificado exitosamente.");
                            break;
                        case 4:
                            System.out.println("Nueva categoría:");
                            Producto.mostrarOpcionesCategoria();
                            System.out.print("Elija una opción: ");
                            int categoriaIndex = scanner.nextInt();
                            Producto.Categoria nuevaCategoria = Producto.Categoria.values()[categoriaIndex - 1];
                            scanner.nextLine(); // Limpiar el buffer
                            producto.setCategoria(nuevaCategoria);
                            System.out.println("Categoría modificada exitosamente.");
                            break;
                        default:
                            System.out.println("Opción inválida. No se realizó ninguna modificación.");
                            break;
                    }
                    break; // No necesitamos seguir buscando una vez que encontramos el producto
                }
            }
            if (!encontrado) {
                System.out.println("No se encontró ningún producto con el código ingresado.");
            }
        }
    }
}
