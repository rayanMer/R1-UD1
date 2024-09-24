package Reto1.pruebaDeConceptoApartado1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class pruebaPropertiesCargarTxt {
    public static void main(String[] args) {
        Properties catalogoCochesTextoPlano = new Properties();

        try(InputStream archivoTextoPlano = new FileInputStream("catalogo_coches.txt")) {
            catalogoCochesTextoPlano.load(archivoTextoPlano);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("--- CATALOGO CARGADO DE UN TEXTO PLANO");
        for(String key : catalogoCochesTextoPlano.stringPropertyNames()) {
            System.out.printf("Matricula: %s | Marca: %s\n", key, catalogoCochesTextoPlano.getProperty(key));
        }
    }
}
