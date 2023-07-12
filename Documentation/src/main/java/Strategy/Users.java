package Strategy;

import java.util.ArrayList;

public interface Users {
    //Declaration methods
    void create(String name);
    ArrayList<String> getUsers();
    ArrayList<String> delete(String name);
    String findByName(String name);
    void listUsers();
}
