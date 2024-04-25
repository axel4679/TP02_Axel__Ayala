package ar.edu.unju.fi.ejercicio1.main;

import ar.edu.unju.fi.ejercicio1.model.*;
import ar.edu.unju.fi.ejercicio1.model.Producto.Categoria;
import ar.edu.unju.fi.ejercicio1.model.Producto.OrigenDeFabricacion;

import java.util.ArrayList;
import java.util.List;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		List<Producto> listado =new ArrayList<Producto>();
	Producto Prod01 = new Producto ("2P01" , "caracteristica kn jj", 23,OrigenDeFabricacion.CHINA, Categoria.INFORMATICA);
	listado.add(Prod01);
	System.out.print(listado);
 }
}
