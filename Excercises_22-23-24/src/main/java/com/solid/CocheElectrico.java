package com.solid;

import funcionalidad.FuncionalidadesCoche;

public class CocheElectrico extends Coche implements FuncionalidadesCoche {
    protected double capacidadBateria;

    CocheElectrico(){}
    public CocheElectrico(String color, String marca, String modelo, Integer velocidad, double capacidadBateria) {
        super(color, marca, modelo, velocidad);
        this.capacidadBateria = capacidadBateria;
    }

    public double getCapacidadBateria() { return capacidadBateria; }
    public void setCapacidadBateria(double capacidadBateria) { this.capacidadBateria = capacidadBateria; }

    @Override
    public void encender() { System.out.println("Motor electrico encendido"); }

    @Override
    public void apagar() { System.out.println("Motor electrico apagado"); }

    @Override
    public void acelerar() {}

    @Override
    public void frenar() {}
}
