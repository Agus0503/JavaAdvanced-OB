package Session27.DataBase;

import Session27.Interfaces.DataBaseStore;
import Session27.Usuario;

public class DataBaseMySQL implements DataBaseStore {

    @Override
    public void guardarUsuario(Usuario usuario) {
        System.out.println("Guardado en MySQL");
    }
}
