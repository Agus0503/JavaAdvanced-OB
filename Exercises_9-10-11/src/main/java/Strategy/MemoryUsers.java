package Strategy;

import java.util.ArrayList;

public class MemoryUsers implements Users{

    private final ArrayList<String> users = new ArrayList<>();

    @Override
    public void create(String name){
        users.add(name);
    }

    @Override
    public ArrayList<String> getUsers(){ return users; }

    @Override
    public ArrayList<String> delete(String name) {
        if(findByName(name) != null){
            ArrayList<String> users = getUsers();
            users.remove(name);
            return users;
        }
        return null;
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
