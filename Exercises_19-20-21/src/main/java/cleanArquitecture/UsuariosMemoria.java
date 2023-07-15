package cleanArquitecture;

import java.util.ArrayList;

public class UsuariosMemoria {
    ArrayList<Usuario> usuarios = new ArrayList<>();

    public ArrayList<Usuario> listarUsuarios() { return usuarios; }

    public Usuario obtenerUsuario(String username) {
        for (Usuario usuario : usuarios) {
            if (usuario.nombreUsuario.equalsIgnoreCase(username.toLowerCase())) { return usuario; }
        }
        return null;
    }

    public void crearUsuario(Usuario usuario) {
        for (Usuario usuarioActual : usuarios) {
            if (usuarioActual.nombreUsuario.equalsIgnoreCase(usuario.nombreUsuario)) { return; }
        }
        usuarios.add(usuario);
    }

    public void deleteUser(String username) {
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usuario = usuarios.get(i);
            if (usuario.nombreUsuario.equalsIgnoreCase(username.toLowerCase())) { usuarios.remove(i); }
        }
    }
}
