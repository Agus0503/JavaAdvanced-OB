package Session27;

public class Usuario {
    public String username;
    public String name;
    public String lastName;
    public String email="";
    public int accessLevel;

    @Override
    public String toString() {
        return "Usuario{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", accessLevel=" + accessLevel +
                '}';
    }
}
