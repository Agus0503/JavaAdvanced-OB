package com.solid;

import DataBase.CocheDB;

import java.util.ArrayList;

public class Coches {
    CocheDB cochesDB;

    public Coches(CocheDB cocheDB) { this.cochesDB = cocheDB; }

    public ArrayList<Coche> listCoches(){ return cochesDB.getCoches(); }

    public Coche getCoche(String modelo){
        Coche coche = new Coche();
        coche.modelo = modelo;

        return cochesDB.search(coche);
    }

    public void createCoche(Coche coche){
        if(cochesDB.search(coche) != null){
            System.out.println("Cannot create");
            return;
        }
        cochesDB.insert(coche);
    }

    public void deleteCoche(String modelo){
        Coche coche = new Coche();
        coche.modelo = modelo;

        cochesDB.delete(coche);
    }
}
