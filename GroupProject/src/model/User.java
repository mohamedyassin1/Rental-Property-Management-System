package model;

//Finished
public abstract class User{
    private static int count = 1000;
    private int id;
    protected String email;
    protected String password;
    protected String name;
    public User(String email, String password, String name) {
        this.email = email;
        this.password = password;
        this.name = name;
        id = count++;
    }
    public User() {
        this.name = "guest";
        
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }

    
}