package ar.edu.unju.fi.ejercicio2.main;



import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Efemeride> efemerides = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú de acciones:");
            System.out.println("1 - Crear efeméride");
            System.out.println("2 - Mostrar efemérides");
            System.out.println("3 - Eliminar efeméride");
            System.out.println("4 - Modificar efeméride");
            System.out.println("5 - Salir");
            System.out.print("Elija una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea pendiente

                switch (opcion) {
                    case 1:
                        crearEfemeride(efemerides, scanner);
                        break;
                    case 2:
                        mostrarEfemerides(efemerides);
                        break;
                    case 3:
                        eliminarEfemeride(efemerides, scanner);
                        break;
                    case 4:
                        modificarEfemeride(efemerides, scanner);
                        break;
                    case 5:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción inválida. Intente nuevamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingrese un número entero correspondiente a la opción.");
                scanner.nextLine(); // Consumir la entrada inválida
                opcion = 0; // Reiniciar la opción para evitar un bucle infinito
            }
        } while (opcion != 5);

        scanner.close();
    }

    private static void crearEfemeride(List<Efemeride> efemerides, Scanner scanner) {
        System.out.println("Ingrese los datos de la nueva efeméride:");
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Mes (1-12): ");
        int mesIndex = scanner.nextInt();
        if (mesIndex < 1 || mesIndex > 12) {
            System.out.println("Error: El mes debe estar entre 1 y 12.");
            return;
        }
        Mes mes = Mes.values()[mesIndex - 1];
        scanner.nextLine(); // Consumir el salto de línea pendiente
        System.out.print("Día: ");
        int dia = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea pendiente
        System.out.print("Detalle: ");
        String detalle = scanner.nextLine();

        Efemeride efemeride = new Efemeride(codigo, mes, dia, detalle);
        efemerides.add(efemeride);
        System.out.println("Efeméride creada exitosamente.");
    }

    private static void mostrarEfemerides(List<Efemeride> efemerides) {
        if (efemerides.isEmpty()) {
            System.out.println("No hay efemérides para mostrar.");
        } else {
            System.out.println("Efemérides:");
            for (Efemeride efemeride : efemerides) {
                System.out.println("Código: " + efemeride.getCodigo() +
                        ", Mes: " + efemeride.getMes().name() +
                        ", Día: " + efemeride.getDia() +
                        ", Detalle: " + efemeride.getDetalle());
            }
        }
    }

    private static void eliminarEfemeride(List<Efemeride> efemerides, Scanner scanner) {
        if (efemerides.isEmpty()) {
            System.out.println("No hay efemérides para eliminar.");
        } else {
            System.out.print("Ingrese el código de la efeméride a eliminar: ");
            String codigo = scanner.nextLine();
            boolean eliminado = efemerides.removeIf(efemeride -> efemeride.getCodigo().equals(codigo));
            if (eliminado) {
                System.out.println("Efeméride eliminada exitosamente.");
            } else {
                System.out.println("No se encontró ninguna efeméride con el código ingresado.");
            }
        }
    }

    private static void modificarEfemeride(List<Efemeride> efemerides, Scanner scanner) {
        if (efemerides.isEmpty()) {
            System.out.println("No hay efemérides para modificar.");
        } else {
            System.out.print("Ingrese el código de la efeméride a modificar: ");
            String codigo = scanner.nextLine();
            Efemeride efemeride = null;
            for (Efemeride e : efemerides) {
                if (e.getCodigo().equals(codigo)) {
                    efemeride = e;
                    break;
                }
            }
            if (efemeride == null) {
                System.out.println("No se encontró ninguna efeméride con el código ingresado.");
            } else {
                System.out.println("¿Qué desea modificar?");
                System.out.println("1 - Mes");
                System.out.println("2 - Día");
                System.out.println("3 - Detalle");
                System.out.print("Elija una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea pendiente

                switch (opcion) {
                    case 1:
                        System.out.print("Nuevo mes (1-12): ");
                        int mesIndex = scanner.nextInt();
                        if (mesIndex < 1 || mesIndex > 12) {
                            System.out.println("Error: El mes debe estar entre 1 y 12.");
                            break;
                        }
                        Mes nuevoMes = Mes.values()[mesIndex - 1];
                        efemeride.setMes(nuevoMes);
                        System.out.println("Mes modificado exitosamente.");
                        break;
                    case 2:
                        System.out.print("Nuevo día: ");
                        int nuevoDia = scanner.nextInt();
                        efemeride.setDia(nuevoDia);
                        System.out.println("Día modificado exitosamente.");
                        break;
                    case 3:
                        System.out.print("Nuevo detalle: ");
                        String nuevoDetalle = scanner.nextLine();
                        efemeride.setDetalle(nuevoDetalle);
                        System.out.println("Detalle modificado exitosamente.");
                        break;
                    default:
                        System.out.println("Opción inválida. No se realizó ninguna modificación.");
                        break;
                }
            }
        }
    }
}
