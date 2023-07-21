package Session27.Controller;

import Session27.Interfaces.UsuariosDB;
import Session27.Usuario;

import java.util.ArrayList;

public class UsuariosController {
    UsuariosDB usuariosDB;

    public UsuariosController(UsuariosDB usuariosDB) { this.usuariosDB = usuariosDB; }

    public ArrayList<Usuario> listUsers() { return this.usuariosDB.getUsuarios(); }

    public Usuario getUser(String username) {
        Usuario usuario = new Usuario();
        usuario.username = username;
        return this.usuariosDB.search(usuario);
    }

    public void createUser(Usuario usuario) {
        if (this.usuariosDB.search(usuario) == null) {
            this.usuariosDB.insert(usuario);
        }
    }

    public void deleteUser(String username) {
        Usuario usuario = new Usuario();
        usuario.username = username;
        this.usuariosDB.delete(usuario);
    }
}
