package Strategy;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for files management
 */
public class FileUsers implements Users{

    private final String fileUsers = "users.txt";
    private PrintStream file;

    //Constructor
    public FileUsers() {
        try{
            file = new PrintStream(fileUsers);
        }catch (Exception e){ System.out.println("Error opening file: " + e.getMessage()); }
    }

    /**
     * Construct the file
     * @param name Receives a name
     */
    @Override
    public void create(String name){
        file.println(name);
    }

    /**
     * Getting dates from file
     * @return ArrayList
     */
    @Override
    public ArrayList<String> getUsers(){
        ArrayList<String> users = new ArrayList<>();
        try{
            Scanner scanner = new Scanner(new File(fileUsers));
            while (scanner.hasNext()){ users.add(scanner.next()); }
            scanner.close();
        }catch (Exception e){ System.out.println("Error getting users: " + e.getMessage()); }
        return users;
    }

    /**
     * Delete a user from database(file in this case)
     * @param name Receives a specific name to delete
     * @return new ArrayList || null
     */
    @Override
    public ArrayList<String> delete(String name) {
        ArrayList<String> users = getUsers();
        if (users.contains(name)) {
            users.remove(name);
            saveUsers(users);
            return users;
        }
        return null;
    }

    /**
     * Save changes in file
     * @param users Receives list of users to update/save changes
     */
    private void saveUsers(ArrayList<String> users) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileUsers));
            for (String user : users) {
                writer.write(user);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) { System.out.println("Error saving users: " + e.getMessage()); }
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
