package com.solid;

import funcionalidad.FuncionalidadesCoche;

public class CocheHibrido extends Coche implements FuncionalidadesCoche {
    protected double capacidadCombustible;
    protected double capacidadBateria;

    CocheHibrido(){}
    public CocheHibrido(String color, String marca, String modelo, Integer velocidad, double capacidadBateria, double capacidadCombustible) {
        super(color, marca, modelo, velocidad);
        this.capacidadBateria = capacidadBateria;
        this.capacidadCombustible = capacidadCombustible;
    }

    public double getCapacidadCombustible() { return capacidadCombustible; }
    public void setCapacidadCombustible(double capacidadCombustible) { this.capacidadCombustible = capacidadCombustible; }

    public double getCapacidadBateria() { return capacidadBateria; }
    public void setCapacidadBateria(double capacidadBateria) { this.capacidadBateria = capacidadBateria; }

    @Override
    public void encender() { System.out.println("Motor hibrido encendido"); }

    @Override
    public void apagar() { System.out.println("Motor hibrido apagado"); }

    @Override
    public void acelerar() {}

    @Override
    public void frenar() {}
}
