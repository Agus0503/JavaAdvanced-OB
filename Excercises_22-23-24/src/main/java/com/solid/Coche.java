package com.solid;

public class Coche {
    public String color;
    public String marca;
    public String modelo;
    public Integer velocidad;

    public Coche() {}

    public Coche(String color, String marca, String modelo, Integer velocidad) {
        this.color = color;
        this.marca = marca;
        this.modelo = modelo;
        this.velocidad = velocidad;
    }

    @Override
    public String toString() {
        return "Coche{" +
                "color='" + color + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", velocidad=" + velocidad +
                '}';
    }
}
