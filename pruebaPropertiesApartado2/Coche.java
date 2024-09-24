package Reto1.pruebaPropertiesApartado2;

public class Coche {
    private String matricula;
    private String marca;
    private String modelo;
    private String color;
    private String tipoCombustible;

    public Coche(String matricula, String marca, String modelo, String color, String tipoCombustible) {
        this.matricula = matricula;
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.tipoCombustible = tipoCombustible;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "matricula='" + matricula + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", tipoCombustible='" + tipoCombustible + '\'' +
                '}';
    }
}
