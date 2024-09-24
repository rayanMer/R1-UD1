package Reto1.ejercicioSeis;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
public class RandomAccess {
  private static final String NOMBRE_FICHERO = "datos.bin";
  private static final int TAMAÑO = 20;
  public static void main(String[] args) {
      int[] datos = new int[TAMAÑO];
      File fichero = new File(NOMBRE_FICHERO);
      if (fichero.exists()) {
          // Leer los datos del fichero
          try (DataInputStream dis = new DataInputStream(new FileInputStream(fichero))) {
              for (int i = 0; i < TAMAÑO; i++) {
                  datos[i] = dis.readInt();
              }
          } catch (IOException e) {
              e.printStackTrace();
          }
      } else {
          // Crear el fichero y llenarlo con ceros
          try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fichero))) {
              for (int i = 0; i < TAMAÑO; i++) {
                  datos[i] = 0;
                  dos.writeInt(0);
              }
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
      // Abrir el fichero para escritura en acceso aleatorio
      try (RandomAccessFile raf = new RandomAccessFile(NOMBRE_FICHERO, "rwd")) {
          Scanner scanner = new Scanner(System.in);
          while (true) {
              // Mostrar el contenido del array
              System.out.println("Contenido del array:");
              for (int i = 0; i < TAMAÑO; i++) {
                  System.out.print(datos[i] + " ");
              }
              System.out.println();
              // Pedir al usuario una posición a modificar
              System.out.print("Introduce una posición a modificar (negativo para salir): ");
              int posicion = scanner.nextInt();
              if (posicion < 0) {
                  break;
              }
              // Pedir el nuevo valor
              System.out.print("Introduce el nuevo valor: ");
              int valorNuevo = scanner.nextInt();
              // Actualizar la estructura en Java y el fichero
              if (posicion >= 0 && posicion < TAMAÑO) {
                  datos[posicion] = valorNuevo;
                  raf.seek(posicion * Integer.BYTES); // Moverse a la posición en el fichero
                  raf.writeInt(valorNuevo); // Escribir el nuevo valor
              } else {
                  System.out.println("Posición fuera de rango.");
              }
          }
          scanner.close();
      } catch (IOException e) {
          e.printStackTrace();
      }
  }
}
