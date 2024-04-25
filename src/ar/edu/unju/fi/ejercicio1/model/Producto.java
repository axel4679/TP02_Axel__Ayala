package ar.edu.unju.fi.ejercicio1.model;

public class Producto {
	
	    private String codigo;
	    private String descripcion;
	    private double precioUnitario;
	    private OrigenDeFabricacion origenFabricacion;
	    private Categoria categoria;
	    
		public Producto(String codigo, String descripcion, double precioUnitario, OrigenDeFabricacion origenFabricacion, Categoria categoria) {
			super();
			this.codigo = codigo;
			this.descripcion = descripcion;
			this.precioUnitario = precioUnitario;
			this.origenFabricacion = origenFabricacion;
			this.categoria = categoria;
		}

		public Producto(String codigo2, String descripcion2, int precioUnitario2, OrigenDeFabricacion china,
				Categoria informatica) {
			// TODO Auto-generated constructor stub
		}

		public String getCodigo() {
			return codigo;
		}

		public void setCodigo(String codigo) {
			this.codigo = codigo;
		}

		public String getDescripcion() {
			return descripcion;
		}

		public void setDescripcion(String descripcion) {
			this.descripcion = descripcion;
		}

		public double getPrecioUnitario() {
			return precioUnitario;
		}

		public void setPrecioUnitario(double precioUnitario) {
			this.precioUnitario = precioUnitario;
		}

	    
	


		public enum OrigenDeFabricacion {
	
	ARGENTINA, CHINA, BRASIL, URUGUAY
		}

		public enum Categoria {
	
	TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS
		}

	}
