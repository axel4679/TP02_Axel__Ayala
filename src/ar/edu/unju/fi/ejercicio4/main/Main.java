package ar.edu.unju.fi.ejercicio4.main;


import ar.edu.unju.fi.ejercicio4.model.*;
import ar.edu.unju.fi.ejercicio4.constantes.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Jugador> jugadores = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Menú de opciones:");
            System.out.println("1 - Alta de jugador");
            System.out.println("2 - Mostrar todos los jugadores");
            System.out.println("3 - Modificar la posición de un jugador");
            System.out.println("4 - Eliminar un jugador");
            System.out.println("5 - Salir");
            System.out.print("Elija una opción: ");

            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer

                switch (opcion) {
                    case 1:
                        altaJugador(jugadores, scanner);
                        break;
                    case 2:
                        mostrarJugadores(jugadores);
                        break;
                    case 3:
                        modificarPosicion(jugadores, scanner);
                        break;
                    case 4:
                        eliminarJugador(jugadores, scanner);
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
                scanner.nextLine(); // Limpiar el buffer
                opcion = 0; // Reiniciar la opción para evitar un bucle infinito
            }
        } while (opcion != 5);

        scanner.close();
    }

    private static void altaJugador(ArrayList<Jugador> jugadores, Scanner scanner) {
        System.out.println("Ingrese los datos del nuevo jugador:");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();
        System.out.print("Fecha de nacimiento (AAAA-MM-DD): ");
        LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine());
        System.out.print("Nacionalidad: ");
        String nacionalidad = scanner.nextLine();
        System.out.print("Estatura (m): ");
        double estatura = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Peso (kg): ");
        double peso = scanner.nextDouble();
        scanner.nextLine(); // Limpiar el buffer
        System.out.print("Posición (DELANTERO, MEDIO, DEFENSA, ARQUERO): ");
        Posicion posicion = Posicion.valueOf(scanner.nextLine().toUpperCase());

        Jugador jugador = new Jugador(nombre, apellido, fechaNacimiento, nacionalidad, estatura, peso, posicion);
        jugadores.add(jugador);
        System.out.println("Jugador añadido correctamente.");
    }

    private static void mostrarJugadores(ArrayList<Jugador> jugadores) {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores para mostrar.");
        } else {
            System.out.println("Listado de jugadores:");
            for (Jugador jugador : jugadores) {
                System.out.println(jugador);
            }
        }
    }

    private static void modificarPosicion(ArrayList<Jugador> jugadores, Scanner scanner) {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores para modificar.");
        } else {
            System.out.print("Ingrese el nombre del jugador a modificar: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el apellido del jugador a modificar: ");
            String apellido = scanner.nextLine();

            Iterator<Jugador> iterator = jugadores.iterator();
            boolean encontrado = false;
            while (iterator.hasNext()) {
                Jugador jugador = iterator.next();
                if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
                    System.out.print("Ingrese la nueva posición (DELANTERO, MEDIO, DEFENSA, ARQUERO): ");
                    Posicion nuevaPosicion = Posicion.valueOf(scanner.nextLine().toUpperCase());
                    jugador.setPosicion(nuevaPosicion);
                    System.out.println("Posición modificada correctamente.");
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("No se encontró ningún jugador con los datos ingresados.");
            }
        }
    }

    private static void eliminarJugador(ArrayList<Jugador> jugadores, Scanner scanner) {
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores para eliminar.");
        } else {
            System.out.print("Ingrese el nombre del jugador a eliminar: ");
            String nombre = scanner.nextLine();
            System.out.print("Ingrese el apellido del jugador a eliminar: ");
            String apellido = scanner.nextLine();

            Iterator<Jugador> iterator = jugadores.iterator();
            boolean encontrado = false;
            while (iterator.hasNext()) {
                Jugador jugador = iterator.next();
                if (jugador.getNombre().equalsIgnoreCase(nombre) && jugador.getApellido().equalsIgnoreCase(apellido)) {
                    iterator.remove();
                    System.out.println("Jugador eliminado correctamente.");
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("No se encontró ningún jugador con los datos ingresados.");
            }
        }
    }
}
