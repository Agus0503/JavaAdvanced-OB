package Strategy;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileUsers implements Users{

    private final String fileUsers = "users.txt";
    private PrintStream file;

    public FileUsers() {
        try{
            file = new PrintStream(fileUsers);
        }catch (Exception e){ System.out.println("Error opening file: " + e.getMessage()); }
    }

    @Override
    public void create(String name){
        file.println(name);
    }

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

    @Override
    public String findByName(String name) {
        for(String user : getUsers()){
         if(user.equalsIgnoreCase(name)){ return name; }
        }
        return null;
    }

    @Override
    public void listUsers() {
        for(String user : getUsers()) { System.out.println(user); }
    }
}
