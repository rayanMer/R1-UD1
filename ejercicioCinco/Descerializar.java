package Reto1.ejercicioCinco;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class Descerializar {
    public static Coche deserializarObjeto(String nombreFich) {
        Coche c1 = null;
        try (FileInputStream fichero = new FileInputStream(nombreFich);
             ObjectInputStream ficheroGet = new ObjectInputStream(fichero)) {
            c1 = (Coche) ficheroGet.readObject();
            System.out.println("Objeto deserializado desde " + nombreFich);
        } catch (Exception e) {
			System.out.println("Error: "+e.getMessage());
        	
        } 
        return c1;
    }

    public static void main(String[] args) {
        Coche c1 = deserializarObjeto("Concesionario.ser");
        System.out.println("Coche deserializado: " + c1);
    }
}
