package Reto1.pruebaPropertiesApartado2;

import java.util.ArrayList;
import java.util.Properties;

public class pruebaPropertiesObjetoCoche {
    public static void main(String[] args) {
        Coche coche1 = new Coche("5678 JKL", "Ford", "Fiesta", "Rojo", "Gasolina");
        Coche coche2 = new Coche("1234 ABC", "Volkswagen", "Golf", "Azul", "Diesel");
        Coche coche3 = new Coche("8765 XYZ", "Toyota", "Corolla", "Negro", "Híbrido");
        Coche coche4 = new Coche("3456 DEF", "Honda", "Civic", "Blanco", "Gasolina");
        Coche coche5 = new Coche("9012 GHI", "BMW", "Serie 3", "Gris", "Eléctrico");

        ArrayList<Coche> catalogoCoches = new ArrayList<>();
        catalogoCoches.add(coche1);
        catalogoCoches.add(coche2);
        catalogoCoches.add(coche3);
        catalogoCoches.add(coche4);
        catalogoCoches.add(coche5);

        Properties listaCoches = new Properties();

        for(Coche coche : catalogoCoches) {
            listaCoches.setProperty(coche.getMatricula(), getDetallesCoche(coche));
        }

        for(String key : listaCoches.stringPropertyNames()) {
            System.out.printf("Matricula: %s | Detalles: %s\n", key, listaCoches.getProperty(key));
        }


    }
    private static String getDetallesCoche(Coche coche) {
        return String.format("%s, %s, %s, %s", coche.getMarca(), coche.getModelo(), coche.getColor(), coche.getTipoCombustible());
    }
}
