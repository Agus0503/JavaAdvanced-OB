package Strategy;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        MemoryUsers users = new MemoryUsers();
        System.out.println(users.getClass());
        create(users,"Agus");
        create(users, "Victor");
        create(users, "Alan");

        System.out.println("Before delete");
        listUsers(users);

        System.out.println("\nAfter delete");
        deleteUsers(users, "Agus");
        listUsers(users);
    }

    public static void create(Users user, String name) {
        user.create(name);
    }
    public static ArrayList<String> getUsers(Users users) { return users.getUsers(); }
    public static ArrayList<String> deleteUsers(Users user, String name) { return user.delete(name); }
    public static void listUsers(Users users) { users.listUsers();}
}
