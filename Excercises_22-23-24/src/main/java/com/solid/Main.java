package com.solid;

import DataBase.CocheDB;
import DataBase.CocheDBFile;
import DataBase.CocheDBMemory;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Coche coche = new Coche("Negro", "Volkswagen", "Gol Trend", 300);
        Coche coche1 = new Coche("Blanco", "Chevrolet", "Meriva", 280);
        Coche coche2 = new Coche("Gris", "Fiat", "Duna", 250);
        Coche coche3 = new Coche("lala", "lala", "lala", 200);

        System.out.println("Seleccione tipo de auto: ");
        System.out.println("1. Combustion");
        System.out.println("2. Electrico");
        System.out.println("3. Hibrido");
        System.out.print("Opcion: ");

        Scanner scanner = new Scanner(System.in);
        String tipoCoche = scanner.nextLine();

        CocheDB cocheDB;

        if (Objects.equals(tipoCoche, "1")){
            cocheDB = new CocheDBMemory();
            //cocheDB = new CocheDBFile("DeCombustion.txt");
        } else if (Objects.equals(tipoCoche, "2")) {
            cocheDB = new CocheDBMemory();
            //cocheDB = new CocheDBFile("Electricos.txt");
        } else if (Objects.equals(tipoCoche, "3")) {
            cocheDB = new CocheDBMemory();
            //cocheDB = new CocheDBFile("Hibridos.txt");
        }else {
            System.out.println("Tipo de coche seleccionado no válido.");
            return;
        }

        Coches coches = new Coches(cocheDB);
        coches.createCoche(coche);
        coches.createCoche(coche1);
        coches.createCoche(coche2);
        coches.createCoche(coche3);

        coches.deleteCoche("lala");

        for(Coche c : coches.listCoches()) {
            System.out.println("Coche actual: " + c.modelo);
            System.out.println("-".repeat(c.modelo.length()));
            System.out.println(c);
            System.out.println("----------------");
        }

        System.out.println("Inserts: " + cocheDB.getTotalInserciones());
        System.out.println("Deletes: " + cocheDB.getTotalEliminaciones());
    }
}
