package Session27.DataSources;

import Session27.Interfaces.UsuariosDBEstadisticas;
import Session27.Usuario;
import Session27.Interfaces.UsuariosDB;

import java.util.ArrayList;

public class UsuariosDBMemory implements UsuariosDB, UsuariosDBEstadisticas {

    private int totalEliminaciones;
    private int totalInserciones;

    ArrayList<Usuario> usuarios = new ArrayList<>();

    @Override
    public ArrayList<Usuario> getUsuarios() { return usuarios; }

    @Override
    public Usuario search(Usuario usuario) {
        for (Usuario usuarioActual : getUsuarios()) {
            if (usuarioActual.username.equalsIgnoreCase(usuario.username)){
                return usuario;
            }
        }
        return null;
    }

    @Override
    public void insert(Usuario usuario) {
        for(Usuario usuarioActual : usuarios) {
            if(usuarioActual.username.equalsIgnoreCase(usuario.username)){ return; }
        }
        usuarios.add(usuario);
        totalInserciones++;
    }

    @Override
    public void delete(Usuario usuario) {
        for (int i = 0; i < usuarios.size(); i++){
            if (usuarios.get(i).username.equalsIgnoreCase(usuario.username)) usuarios.remove(i);
        }
        totalEliminaciones++;
    }

    @Override
    public int getTotalInserciones() {
        return totalInserciones;
    }

    @Override
    public int getTotalEliminaciones() {
        return totalEliminaciones;
    }
}
