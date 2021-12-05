package controller;

import java.util.ArrayList;
import model.*;
public class AuthenticateController {
    private ArrayList<String> storedNames;
    private ArrayList<String> storedEmails;
    private ArrayList<String> storedPasswords;
    private ArrayList<String> storedTypes;
    private AuthenticateController instance;
    private User user;
    private DBMS db;
    public AuthenticateController(User user) {
        this.user = user;
        db = new DBMS("jdbc:mysql://localhost/mydb", "username", "password");
    }
    
    public boolean login(String userType){
        //get user
        if(userType.equals("renter")){
            return(db.getRenter(user.getName(), user.getEmail(), user.getPassword()));
        }else if(userType.equals("landlord")){
            return(db.getLandlord(user.getName(), user.getEmail(), user.getPassword()));
        }else if(userType.equals("manager")){
            return(db.getManager(user.getName(), user.getEmail(), user.getPassword()));
        }

        return false;
    }
    public boolean register(String userType){
        //get user
        if(userType.equals("renter")){
            db.registerRenter(user.getName(), user.getEmail(), user.getPassword());
            storedNames.add(user.getName());
            storedEmails.add(user.getEmail());
            storedPasswords.add(user.getPassword());
            storedTypes.add("renter");
            return true;
        }else if(userType.equals("landlord")){
            db.registerLandlord(user.getName(), user.getEmail(), user.getPassword());
            storedNames.add(user.getName());
            storedEmails.add(user.getEmail());
            storedPasswords.add(user.getPassword());
            storedTypes.add("landlord");
            return true;
        }else if(userType.equals("manager")){
            db.registerManager(user.getName(), user.getEmail(), user.getPassword());
            storedNames.add(user.getName());
            storedEmails.add(user.getEmail());
            storedPasswords.add(user.getPassword());
            storedTypes.add("manager");
            return true;
        }

        return false;
    }
    public AuthenticateController getInstance(){
        if(instance==null){
            instance = new AuthenticateController(null);
        }
        return instance;
    }
    public static void main(String[] args) {
        RegisteredRenter test = new RegisteredRenter("Moussavi", "Moussavi@gmail.com","8278");
        AuthenticateController testing = new AuthenticateController(test);
        System.out.println(testing.register("renter"));
    }
    
}
