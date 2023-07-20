package DataBase;

import com.solid.Coche;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class CocheDBFile extends CocheDB {
    public String ficheroDatos;

    public CocheDBFile(String ficheroDatos) { this.ficheroDatos = ficheroDatos; }

    @Override
    public ArrayList<Coche> getCoches() {
        ArrayList<Coche> coches = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(ficheroDatos));

            while (scanner.hasNext()) {
                String cocheActual = scanner.nextLine();
                String []partes = cocheActual.split(",");

                Coche coche = new Coche();
                coche.color = partes[0];
                coche.marca = partes[1];
                coche.modelo = partes[2];
                coche.velocidad = Integer.parseInt(partes[3]);

                coches.add(coche);
            }
            scanner.close();
        } catch (Exception ignored) {}
        return coches;
    }

    @Override
    public Coche search(Coche coche) {
        ArrayList<Coche> coches = getCoches();

        for (Coche cocheActual : coches) {
            if (cocheActual.modelo.equalsIgnoreCase(coche.modelo)) {
                return cocheActual;
            }
        }
        return null;
    }

    @Override
    public void insert(Coche coche) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(ficheroDatos, true);
            PrintStream printStream = new PrintStream(fileOutputStream);
            printStream.println(separarPorComas(coche));
            printStream.flush();
            printStream.close();
        } catch (Exception e) {
            System.out.println("Error al insertar el coche: " + e.getMessage());
        }
        incrementarInserciones();
    }

    @Override
    public void delete(Coche coche) {
        ArrayList<Coche> coches = getCoches();

        for (int i = 0; i < coches.size(); i++) {
            if (coches.get(i).modelo.equalsIgnoreCase(coche.modelo)) {
                Coche removed = coches.remove(i);
                System.out.println("Coche eliminado: " + removed);
            }
        }

        try {
            PrintStream printStream = new PrintStream(ficheroDatos);

            for (Coche cocheActual : coches) {
                String cocheComas = separarPorComas(cocheActual);
                printStream.println(cocheComas);
            }

            printStream.close();
        } catch (Exception ignored) {}
        incrementarEliminaciones();
    }

    private String separarPorComas(Coche coche) {
        return coche.color + ","
                + coche.marca + ","
                + coche.modelo + ","
                + coche.velocidad;
    }
}