package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
    JUJUY(750000, 53219), SALTA(1430000, 155488), TUCUMAN(1682000, 22524),
    CATAMARCA(397000, 102602), LA_RIOJA(398000, 89680), SANTIAGO_DEL_ESTERO(988000, 136351);

    private int cantidadPoblacion;
    private int superficie;

    private Provincia(int cantidadPoblacion, int superficie) {
        this.cantidadPoblacion = cantidadPoblacion;
        this.superficie = superficie;
    }

    public int getCantidadPoblacion() {
        return cantidadPoblacion;
    }

    public void setCantidadPoblacion(int cantidadPoblacion) {
        this.cantidadPoblacion = cantidadPoblacion;
    }

    public int getSuperficie() {
        return superficie;
    }

    public void setSuperficie(int superficie) {
        this.superficie = superficie;
    }

    public double calcularDensidadPoblacional() {
        return (double) cantidadPoblacion / superficie;
    }
}
