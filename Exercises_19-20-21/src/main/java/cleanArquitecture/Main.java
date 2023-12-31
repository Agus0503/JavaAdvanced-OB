package cleanArquitecture;

public class Main {

    public static void main(String[] args) {
        Usuario usuario = new Usuario();
        usuario.nombreUsuario = "openbootcamp";
        usuario.nombre = "Open";
        usuario.apellidos = "Bootcamp";
        usuario.email = "ejemplos@open-bootcamp.com";
        usuario.nivelAcceso = 10;

        Usuarios usuarios = new Usuarios();
        usuarios.createUser(usuario);

        Usuario usuario2 = new Usuario();
        usuario2.nombreUsuario = "openbootcamp2";
        usuario2.nombre = "Open";
        usuario2.apellidos = "Bootcamp";
        usuario2.email = "ejemplos@open-bootcamp.com";
        usuario2.nivelAcceso = 10;
        usuarios.createUser(usuario2);

        Usuario openbootcamp = usuarios.getUser("openbootcamp2");
        System.out.println(openbootcamp.email);

        usuarios.deleteUser("openbootcamp2");
        for (Usuario a : usuarios.listUsers()) {
            System.out.println(a.nombreUsuario);
        }
    }
}
