package Session27.DataSources;

import Session27.Usuario;
import Session27.Interfaces.UsuariosDB;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class UsuariosDBFile implements UsuariosDB {

    public String ficheroDatos = "fichero.txt";

    public UsuariosDBFile() {}
    public UsuariosDBFile(String ficheroDatos) { this.ficheroDatos = ficheroDatos; }

    @Override
    public ArrayList<Usuario> getUsuarios() {
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(new File(ficheroDatos));

            while (scanner.hasNext()) {
                String usuarioActual = scanner.next();
                String []partes = usuarioActual.split(",");

                Usuario usuario = new Usuario();
                usuario.username = partes[0];
                usuario.name = partes[1];
                usuario.lastName = partes[2];
                usuario.email = partes[3];
                usuario.accessLevel = Integer.parseInt(partes[4]);

                usuarios.add(usuario);
            }

            scanner.close();
        } catch (Exception ignored) {
        }

        return usuarios;
    }

    @Override
    public Usuario search(Usuario usuario) {
        ArrayList<Usuario> usuarios = this.getUsuarios();

        for (Usuario usuarioActual : usuarios) {
            if (usuarioActual.username.equalsIgnoreCase(usuario.username)) { return usuarioActual; }
        }
        return null;
    }

    @Override
    public void insert(Usuario usuario) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(ficheroDatos, true);
            PrintStream printStream = new PrintStream(fileOutputStream);
            printStream.println(separarUsuarioPorComas(usuario));
            printStream.flush();
            printStream.close();
        } catch (Exception ignored) {
        }
    }

    @Override
    public void delete(Usuario usuario) {
        ArrayList<Usuario> usuarios = getUsuarios();

        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).username.equalsIgnoreCase(usuario.username)) {
                usuarios.remove(i);
            }
        }

        try {
            PrintStream printStream = new PrintStream(ficheroDatos);

            for (Usuario usuarioActual : usuarios) {
                String usuarioComas = separarUsuarioPorComas(usuarioActual);
                printStream.println(usuarioComas);
            }

            printStream.close();
        } catch (Exception ignored) {
        }
    }

    private String separarUsuarioPorComas(Usuario usuario) {
        return usuario.username + ","
                + usuario.name + ","
                + usuario.lastName + ","
                + usuario.email + ","
                + usuario.accessLevel;
    }
}
