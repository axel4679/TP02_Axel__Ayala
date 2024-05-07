package ar.edu.unju.fi.ejercicio6.interfaces.funcionales;

import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;



@FunctionalInterface
public interface Converter<T, R> {
    R convert(T t);

    static <T> boolean isNotNull(T t) {
        return t != null;
    }

    default void mostrarObjeto(R r) {
        System.out.println("Nombre = " + ((FelinoSalvaje) r).getNombre());
        System.out.println("Edad = " + ((FelinoSalvaje) r).getEdad());
        System.out.println("Peso = " + ((FelinoSalvaje) r).getPeso());
    }

	
}

