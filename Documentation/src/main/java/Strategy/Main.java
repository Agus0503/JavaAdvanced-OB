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

    /**
     * Create a new user
     * @param user Receives a list of users
     * @param name Receives a name to create
     */
    public static void create(Users user, String name) { user.create(name); }

    /**
     * Get all users
     * @param users Receives a list of users
     * @return list of users
     */
    public static ArrayList<String> getUsers(Users users) { return users.getUsers(); }

    /**
     * Delete user from database(File or Arraylist in this case)
     * @param user Receives a list of users
     * @param name Receives a name to delete
     * @return new ArrayList
     */
    public static ArrayList<String> deleteUsers(Users user, String name) { return user.delete(name); }

    /**
     * List users
     * @param users Receives a list of user to show all users
     */
    public static void listUsers(Users users) { users.listUsers();}
}
