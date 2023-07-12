package Strategy;

import java.util.ArrayList;

public class MemoryUsers implements Users{

    private final ArrayList<String> users = new ArrayList<>();

    /**
     * Creates a new instance of the MemoryUsers class
     * @param name Receives a specified name
     */
    @Override
    public void create(String name){ users.add(name); }

    /**
     * Get all users
     * @return ArrayList
     */
    @Override
    public ArrayList<String> getUsers(){ return users; }

    /**
     * Delete user from the list
     * @param name Receives a specified name to delete
     * @return new ArrayList
     */
    @Override
    public ArrayList<String> delete(String name) {
        if(findByName(name) != null){
            ArrayList<String> users = getUsers();
            users.remove(name);
            return users;
        }
        return null;
    }

    /**
     * Find a specific user by name
     * @param name Receives a specified name to search
     * @return name of user || null
     */
    @Override
    public String findByName(String name) {
        for(String user : getUsers()){
            if(user.equalsIgnoreCase(name)){ return name; }
        }
        return null;
    }

    /**
     * View all users from file
     */
    @Override
    public void listUsers() {
        for(String user : getUsers()) { System.out.println(user); }
    }

}
