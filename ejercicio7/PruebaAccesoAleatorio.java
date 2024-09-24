package Reto1.ejercicio7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PruebaAccesoAleatorio {
    private static final int NUM_ENTEROS = 20;
    private static final String NOMBRE_FICHERO = "datos.bin";
    private static final int TAMANO_REGISTRO = 4; // Un entero en Java ocupa 4 bytes

    public static void main(String[] args) {
        List<Integer> enteros = new ArrayList<>(NUM_ENTEROS);
        
        // Inicializar la lista
        for (int i = 0; i < NUM_ENTEROS; i++) {
            enteros.add(0);
        }

        // Comprobar si el archivo existe y leerlo o crearlo
        File fichero = new File(NOMBRE_FICHERO);
        if (fichero.exists()) {
            try (DataInputStream dis = new DataInputStream(new FileInputStream(fichero))) {
                for (int i = 0; i < NUM_ENTEROS; i++) {
                    enteros.set(i, dis.readInt());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(fichero))) {
                for (int i = 0; i < NUM_ENTEROS; i++) {
                    dos.writeInt(0);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Mostrar la lista inicial
        System.out.println("Lista inicial: " + enteros);

        // Abrir el archivo para acceso aleatorio
        try (RandomAccessFile raf = new RandomAccessFile(fichero, "rwd")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                // Mostrar la lista
                System.out.println("Lista actual: " + enteros);

                // Pedir posición a modificar
                System.out.print("Introduce la posición a modificar (negativo para salir): ");
                int posicion = Integer.parseInt(reader.readLine());
                if (posicion < 0) {
                    break;
                }

                // Pedir el nuevo valor
                System.out.print("Introduce el nuevo valor: ");
                int nuevoValor = Integer.parseInt(reader.readLine());

                // Actualizar la lista y el archivo
                if (posicion >= 0 && posicion < NUM_ENTEROS) {
                    enteros.set(posicion, nuevoValor);

                    // Mover el puntero del archivo a la posición correspondiente
                    raf.seek(posicion * TAMANO_REGISTRO);
                    raf.writeInt(nuevoValor);
                } else {
                    System.out.println("Posición fuera de rango. Inténtalo de nuevo.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Mostrar la lista final
        System.out.println("Lista final: " + enteros);
    }
}