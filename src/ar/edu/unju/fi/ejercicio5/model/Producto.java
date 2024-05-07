package ar.edu.unju.fi.ejercicio5.model;


public class Producto {
    private String codigo;
    private String descripcion;
    private double precio;
    private boolean estado; // true para productos disponibles, false para productos sin stock

    public Producto(String codigo, String descripcion, double precio, boolean estado) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
        this.estado = estado;
    }

    // Getters y setters

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

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo='" + codigo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                ", estado=" + estado +
                '}';
    }
}
