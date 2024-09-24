package Reto1.ejercicioCinco;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
public class Serializar {
   public static void serializarObjeto(Coche coche, String nombreFich) {
       try (FileOutputStream fichero = new FileOutputStream(nombreFich);
            ObjectOutputStream ficheroPrint = new ObjectOutputStream(fichero)) {
           ficheroPrint.writeObject(coche);
           System.out.println("Objeto imprimido en : " + nombreFich);
       } catch (Exception e) {
			System.out.println("Error:" + e.getStackTrace());
		}
   }
   public static void main(String[] args) {
   	
       Coche c1 = new Coche("Mercedez", "c220",200);
      
       serializarObjeto(c1, "Concesionario.ser");
     
   }
}
