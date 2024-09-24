package Reto1.ejercicio3YCuatro;

import java.io.Serializable;

public class Coche implements Serializable{
	private String marca;
	private String modelo;
	private int cv;
	public Coche(String marca, String modelo, int cv) {
		this.marca=marca;
		this.modelo=modelo;
		this.cv=cv;
	}
	public String getMarca() {
		return marca;
	}
	public String getModelo() {
		return modelo;
	}
	public int getCv() {
		return cv;
	}

}
