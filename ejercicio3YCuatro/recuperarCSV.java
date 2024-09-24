package Reto1.ejercicio3YCuatro;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class recuperarCSV {

	public static void main(String[] args) {

		String coche1 = "ñercedes,c220,170\n";
		String coche2 = "audi,a6,205\n";
		String coche3 = "skòda,octavia,90\n";
		/// ESCRITURA DE DATOS
		PrintWriter out = null;
		try {
			out = new PrintWriter("listaCoches.csv");
			out.print(coche1);
			out.print(coche2);
			out.print(coche3);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} finally {
			if (out != null) {
				out.close();
			}

		}
		// LECTURA DE DATOS
		BufferedReader in = null;
		try {
			in = new BufferedReader(new FileReader("listaCoches.csv"));
			String linea;
			while ((linea = in.readLine()) != null) {
				System.out.println(linea);
			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException ex) {
					System.out.println(ex.getMessage());
				}
			}
		}
		System.out.println("Creando coches");

	}
}
