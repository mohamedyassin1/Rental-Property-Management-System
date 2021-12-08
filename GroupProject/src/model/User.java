package model;

//Finished
public abstract class User{
    protected String email;
    protected String password;
    protected String name;
    public User(String email, String name, String password) {
        this.email = email;
        this.password = password;
        this.name = name;
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
    

    
}
