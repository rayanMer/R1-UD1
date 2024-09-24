package Reto1.pruebaDeConceptoApartado1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class pruebaPropertiesGuardar {
    public static void main(String[] args) {
        Properties catalogoCoches = new Properties();
        catalogoCoches.setProperty("5678JKL", "Ford Fiesta");
        catalogoCoches.setProperty("1234 ABC", "Volkswagen Golf");
        catalogoCoches.setProperty("8765 XYZ", "Toyota Corolla");
        catalogoCoches.setProperty("3456 DEF", "Honda Civic");
        catalogoCoches.setProperty("9012 GHI", "BMW Serie 3");

        try(OutputStream archivoTextoPlano = new FileOutputStream("catalogo_coches.txt")) {
            catalogoCoches.store(archivoTextoPlano, "Prueba de concepto Properties");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (OutputStream archivoXML = new FileOutputStream("catalogo_coches.xml")) {
            catalogoCoches.storeToXML(archivoXML, "Prueba de concepto Properties");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
