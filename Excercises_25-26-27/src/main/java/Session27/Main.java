package Session27;

import Session27.Controller.UsuariosController;
import Session27.DataBase.DataBaseMySQL;
import Session27.DataSources.UsuariosDBFile;
import Session27.DataSources.UsuariosDBMemory;
import Session27.Interfaces.DataBaseStore;
import Session27.Interfaces.UsuariosDB;

public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        usuario.username = "openbootcamp";
        usuario.name = "Open";
        usuario.lastName = "Bootcamp";
        usuario.email = "ejemplos@open-bootcamp.com";
        usuario.accessLevel = 10;

        Usuario usuario2 = new Usuario();
        usuario2.username = "openbootcamp2";
        usuario2.name = "Open2";
        usuario2.lastName = "Bootcamp2";
        usuario2.email = "ejemplos2@open-bootcamp.com";
        usuario2.accessLevel = 5;

        Usuario usuario3 = new Usuario();
        usuario3.username = "openbootcamp3";
        usuario3.name = "Open3";
        usuario3.lastName = "Bootcamp3";
        usuario3.email = "ejemplos3@open-bootcamp.com";
        usuario3.accessLevel = 10;

        UsuariosDB usuariosDB;
        String type = "Memory";
        if(type.equalsIgnoreCase("file")){
            usuariosDB = new UsuariosDBFile();
        }else{
            usuariosDB = new UsuariosDBMemory();
        }

        UsuariosController usuarios = new UsuariosController(usuariosDB);
        usuarios.createUser(usuario);
        usuarios.createUser(usuario2);
        usuarios.createUser(usuario3);

        usuarios.deleteUser("openbootcamp3");

        Usuario openbootcamp = usuarios.getUser("openbootcamp");
        System.out.println("Email of user got: " + openbootcamp.email);

        for (Usuario a : usuarios.listUsers()) {
            System.out.println("Usuario actual: " + a.username);
            System.out.println("----------------" + "-".repeat(a.username.length()));
            System.out.println(a);
        }

        DataBaseStore db = new DataBaseMySQL();
        guardarEnDataBase(db, usuario);

        imprimirEstadisticas(usuariosDB);
    }

    public static void imprimirEstadisticas(UsuariosDB usuariosDB){
        if (usuariosDB instanceof UsuariosDBMemory){
            System.out.println("Inserciones: " + ((UsuariosDBMemory) usuariosDB).getTotalInserciones());
            System.out.println("Eliminaciones: " + ((UsuariosDBMemory) usuariosDB).getTotalEliminaciones());
        }
    }

    public static void guardarEnDataBase(DataBaseStore db, Usuario usuario) { db.guardarUsuario(usuario); }
}
