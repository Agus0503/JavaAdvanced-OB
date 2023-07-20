package com.solid;

import funcionalidad.FuncionalidadesCoche;

public class CocheCombustion extends Coche implements FuncionalidadesCoche {
    protected double capacidadCombustible;

    CocheCombustion(){}
    public CocheCombustion(String color, String marca, String modelo, Integer velocidad, double capacidadCombustible) {
        super(color, marca, modelo, velocidad);
        this.capacidadCombustible = capacidadCombustible;
    }

    public double getCapacidadCombustible() { return capacidadCombustible; }
    public void setCapacidadCombustible(double capacidadCombustible) { this.capacidadCombustible = capacidadCombustible; }

    @Override
    public void encender() { System.out.println("Motor combustion encendido"); }

    @Override
    public void apagar() { System.out.println("Motor combustion apagado"); }

    @Override
    public void acelerar() {}

    @Override
    public void frenar() {}
}
