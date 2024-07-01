package ar.edu.unju.fi.ejercicio7.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import ar.edu.unju.fi.ejercicio1.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio1.model.Producto.OrigenFabricacion;
import ar.edu.unju.fi.ejercicio5.model.Producto;
public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        List <Producto> lista = new ArrayList<>();
        boolean band=false;
        int op = 0;
        
        precarga(lista);
        
        try {
        	do {
        		do {
        			band=false;
        			try {
    					Menu();
        	      		op=scanner.nextInt();
        	      		scanner.nextLine();
        	      		band=true;
        			} catch (Exception e) {
        				System.out.println("Error");
        				scanner.nextLine();
        			}

        		} while(!band);
    			    			
    			switch (op) {
    			case 1:
    				System.out.println("\n--PRODUCTOS DISPONIBLES");
    				ProductoDisponible(lista);
    				break;
    			case 2:
    				System.out.println("\n--PRODUCTOS NO DISPONIBLES--");
    				ProductoNoDisponible(lista);
    				break;
    			case 3:
    				System.out.println("\n--PRECIOS ACTUALIZADOS--");
    				lista=AumentoPrecios(lista);
    				break;
    			case 4:
    				ElectroDisponible(lista);
    				break;
    			case 5:
    				Descendiente(lista);
    				break;
    			case 6:
    				Mayuscula(lista);
    				break;
    			case 7:
    				System.out.println("Programa terminado");
    				break;
     	         default: 
     	         	System.out.println("Opcion incorrecta. Vuelva a intentarlo");
     	         	break;
     	        }
    	     } while (op!=7);
		} finally {
			scanner.close();
		}

	}
	public static void Menu () {
		System.out.println("\n--MENU--");
		System.out.println("1 – Mostrar productos");
		System.out.println("2 – Mostrar los productos faltantes");
		System.out.println("3 – Incrementar los precios de los productos en un 20%");
		System.out.println("4 – Mostrar los productos que corresponden a la categoría Electrohogar y estén disponibles para la venta"); 
		System.out.println("5 – Ordenar los productos por precio de forma descendente");
		System.out.println("6 - Mostrar los productos con los nombres en mayúsculas");  
		System.out.println("7 - Salir");
		System.out.print("Elija una opcion: ");
	}
	public static void precarga (List <Producto> lista) {
		Producto producto1 = new Producto(2000, "Monitor Samsung 24''", 200000, OrigenFabricacion.ARGENTINA, Categoria.HERRAMIENTAS, true);
		Producto producto2 = new Producto(2001, "Mouse logitech g203", 12000, OrigenFabricacion.CHINA, Categoria.INFORMATICA, false);
		Producto producto3 = new Producto(2002, "Teclado hyperx alloy origins core", 56000, OrigenFabricacion.CHINA, Categoria.HERRAMIENTAS, true);
		Producto producto4 = new Producto(2003, "Placa madre gigabyte B450M DS3H", 25000, OrigenFabricacion.URUGUAY, Categoria.TELEFONIA, false);
		Producto producto5 = new Producto(2004, "Procesador amd ryzen 5 3600", 72000, OrigenFabricacion.ARGENTINA, Categoria.HERRAMIENTAS, true);
		Producto producto6 = new Producto(2005, "Placa de video Zotac gtx1660 super", 500000, OrigenFabricacion.CHINA, Categoria.ELECTRO_HOGAR, false);
		Producto producto7 = new Producto(2006, "Disco HDD Barracuda 2tb", 21000, OrigenFabricacion.BRASIL, Categoria.HERRAMIENTAS, true);
		Producto producto8 = new Producto(2007, "Disco SSD WDgreen 240gb", 14000, OrigenFabricacion.URUGUAY, Categoria.TELEFONIA, false);
		Producto producto9 = new Producto(2008, "Fuente Aerocool Cylon 600w 80 plus bronze", 28000, OrigenFabricacion.ARGENTINA, Categoria.ELECTRO_HOGAR, true);
		Producto producto10 = new Producto(2009, "Memoria ram Corsair 2x8gb 3200mhz", 32000, OrigenFabricacion.URUGUAY, Categoria.HERRAMIENTAS, false);
		Producto producto11 = new Producto(2010, "Auriculares Redragon Icon H520", 20000, OrigenFabricacion.BRASIL, Categoria.TELEFONIA, true);
		Producto producto12 = new Producto(2011, "Gabinete Sentey Z20", 29000, OrigenFabricacion.CHINA, Categoria.INFORMATICA, false);
		Producto producto13 = new Producto(2012, "Parlantes Genius", 10000, OrigenFabricacion.CHINA, Categoria.ELECTRO_HOGAR, true);
		Producto producto14 = new Producto(2013, "Impresora", 100000, OrigenFabricacion.URUGUAY, Categoria.INFORMATICA, false);
		Producto producto15 = new Producto(2014, "Celular Motorola", 198000, OrigenFabricacion.ARGENTINA, Categoria.TELEFONIA, true);
		lista.add(producto1);
		lista.add(producto2);
		lista.add(producto3);
		lista.add(producto4);
		lista.add(producto5);
		lista.add(producto6);
		lista.add(producto7);
		lista.add(producto8);
		lista.add(producto9);
		lista.add(producto10);
		lista.add(producto11);
		lista.add(producto12);
		lista.add(producto13);
		lista.add(producto14);
		lista.add(producto15);
	}
	public static void ProductoDisponible(List <Producto> lista) {
		Consumer<Producto> disponible = (producto) -> {
			if(producto.isEstado()) {
				producto.MostrarDatos();
			}
		};
		lista.forEach(disponible);
	}
	public static void ProductoNoDisponible(List <Producto> lista) {
		Predicate<Producto> NoDisponibles = (Producto) -> !Producto.isEstado();
		List<Producto> ProductosNoDisponibles = lista.stream()
														.filter(NoDisponibles)
														.collect(Collectors.toList());
		ProductosNoDisponibles.forEach(producto-> {
			producto.MostrarDatos();
		});
	}
	public static List<Producto> AumentoPrecios(List<Producto> lista) {
		Function<Producto,Producto> nuevoPrecio = p-> {
			p.setPrecioUnitario(p.getPrecioUnitario()*1.20);
			return p;
		};
		return lista.stream()
				.map(nuevoPrecio)
				.collect(Collectors.toList());
	}
	public static void ElectroDisponible(List<Producto> lista) {
		Predicate<Producto> NoDisponibles = (Producto) -> Producto.isEstado() && Producto.getCategoria().equals(Categoria.ELECTRO_HOGAR);
		List<Producto> ProductosNoDisponibles = lista.stream().filter(NoDisponibles).collect(Collectors.toList());
		
		ProductosNoDisponibles.forEach(producto-> {
			producto.MostrarDatos();
		});
	}
	public static void Descendiente(List<Producto> lista) {
		Comparator<Producto> Comparador = Comparator.comparing(Producto :: getPrecioUnitario).reversed();
		
		lista.sort(Comparador);
		System.out.println("\n--PRECIOS ORDENADOS DE FORMA DESCENDENTE--");
		lista.forEach(producto -> {
		    producto.MostrarDatos();
		});
	}
	public static void Mayuscula(List <Producto> lista){
		Function<Producto, Producto> Mayus = producto -> {
			String DesMayusculas = producto.getDescripcion().toUpperCase();
			producto.setDescripcion(DesMayusculas);
			return producto;
		};
		List<Producto> productosMayusculas = lista.stream().map(Mayus).collect(Collectors.toList());
		
		productosMayusculas.forEach(producto -> {
		    System.out.println("Producto: " + producto.getCodigo()+"|"+producto.getDescripcion());
		});
		
	}
	
}
