package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.*;
import ar.edu.unju.fi.ejercicio6.model.*;

public class Main {
    public static void main(String[] args) {
        // Crear un felino doméstico
        FelinoDomestico garfield = new FelinoDomestico("Garfield", (byte) 45, 12f);

        // Definición de expresión lambda que define el convertidor de FelinoDomestico a FelinoSalvaje
        Converter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje(x.getNombre(), x.getEdad(), x.getPeso());

        // Se realiza la conversión
        FelinoSalvaje felino1 = converter.convert(garfield);

        // Mostramos los datos del objeto felino salvaje felino1
        converter.mostrarObjeto(felino1);

        // Realice la conversión de un objeto felino salvaje a felino doméstico
        FelinoSalvaje tanner = new FelinoSalvaje("Tanner", (byte) 20, 186f);

        // Verificar que el objeto a convertir no es nulo
        if (Converter.isNotNull(tanner)) {
            // Definición de expresión lambda que define el convertidor de FelinoSalvaje a FelinoDomestico
            Converter<FelinoSalvaje, FelinoDomestico> reverseConverter = x -> new FelinoDomestico(x.getNombre(), x.getEdad(), x.getPeso());

            // Se realiza la conversión
            FelinoDomestico felino2 = reverseConverter.convert(tanner);

            // Mostramos los datos del objeto felino doméstico felino2
            reverseConverter.mostrarObjeto(felino2);
        }
    }
}
