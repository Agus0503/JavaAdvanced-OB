package Session27.Interfaces;

import Session27.Usuario;

import java.util.ArrayList;

public interface UsuariosDB {
    ArrayList<Usuario> getUsuarios();
    Usuario search(Usuario usuario);
    void insert(Usuario usuario);
    void delete(Usuario usuario);
}
