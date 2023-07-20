package DataBase;

import com.solid.Coche;
import java.util.ArrayList;

public abstract class CocheDB {
    private int totalInserciones = 0;
    private int totalEliminaciones = 0;

    public int getTotalInserciones() { return totalInserciones; }
    public int getTotalEliminaciones() { return totalEliminaciones; }

    protected void incrementarInserciones() { totalInserciones++; }
    protected void incrementarEliminaciones() { totalEliminaciones++; }

    public abstract ArrayList<Coche> getCoches();
    public abstract Coche search(Coche coche);
    public abstract void insert(Coche coche);
    public abstract void delete(Coche coche);
}
