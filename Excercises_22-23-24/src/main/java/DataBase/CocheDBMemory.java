package DataBase;

import com.solid.Coche;

import java.util.ArrayList;

public class CocheDBMemory extends CocheDB{
    ArrayList<Coche> coches = new ArrayList<>();

    @Override
    public ArrayList<Coche> getCoches() { return coches; }

    @Override
    public Coche search(Coche coche) {
        for (Coche cocheActual : getCoches()) {
            if (cocheActual.modelo.equalsIgnoreCase(coche.modelo)) {
                return coche;
            }
        }
        return null;
    }

    @Override
    public void insert(Coche usuario) {
        for (Coche cocheActual : coches) {
            if (cocheActual.modelo.equalsIgnoreCase(usuario.modelo.toLowerCase())) {
                return;
            }
        }
        coches.add(usuario);
        incrementarInserciones();
    }

    @Override
    public void delete(Coche coche) {
        for (int i = 0; i < coches.size(); i++) {
            if (coches.get(i).modelo.equalsIgnoreCase(coche.modelo)) {
                coches.remove(i);
            }
        }
        incrementarEliminaciones();
    }
}
