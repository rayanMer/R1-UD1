package Reto1.pruebaDeConceptoApartado1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class pruebaPropertiesCargarXML {
    public static void main(String[] args) {
        Properties catalogoCochesXML = new Properties();

        try (InputStream archivoXML = new FileInputStream("catalogo_coches.xml")) {
            catalogoCochesXML.loadFromXML(archivoXML);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("--- CATALOGO CARGADO DE UN XML");
        for(String key : catalogoCochesXML.stringPropertyNames()) {
            System.out.printf("Modelo: %s | Marca: %s\n", key, catalogoCochesXML.getProperty(key));
        }

    }
}
