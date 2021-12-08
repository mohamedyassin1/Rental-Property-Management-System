
package controller;

import java.util.ArrayList;
import model.*;
public class AuthenticateController {
    private ArrayList<String> storedNames = new ArrayList<String>();
    private ArrayList<String> storedEmails = new ArrayList<String>();
    private ArrayList<String> storedPasswords = new ArrayList<String>();
    private ArrayList<String> storedTypes = new ArrayList<String>();
    private AuthenticateController instance;
    private User user;
    private String userType; 
    private DBMS db;
    public AuthenticateController(String name, String email, String password,String userType) {
        this.userType = userType;
        if(userType.equalsIgnoreCase("renter")){
            user = new RegisteredRenter(email, name, password);
        }else if(userType.equalsIgnoreCase("landlord")){
            user = new Landlord(email, name, password);
        }else if(userType.equalsIgnoreCase("manager")){
            user = new Manager(email, name, password);
        }
        db = new DBMS("jdbc:mysql://localhost/mydb", "root", "hello12345");
        
    }
    public AuthenticateController() {
    	db = new DBMS("jdbc:mysql://localhost/mydb", MainMenu.dbUsernameInput, MainMenu.dbPasswordInput);
    }
    public boolean login(){
        //get user
        if(userType.equalsIgnoreCase("renter")){
            return(db.getRenter(user.getName(), user.getEmail(), user.getPassword()));
        }else if(userType.equalsIgnoreCase("landlord")){
            return(db.getLandlord(user.getName(), user.getEmail(), user.getPassword()));
        }else if(userType.equalsIgnoreCase("manager")){
            return(db.getManager(user.getName(), user.getEmail(), user.getPassword()));
        }

        return false;
    }
    public boolean register(){
        //get user
        if(userType.equalsIgnoreCase("renter")){
            db.registerRenter(user.getName(), user.getEmail(), user.getPassword());
            storedNames.add(user.getName());
            storedEmails.add(user.getEmail());
            storedPasswords.add(user.getPassword());
            storedTypes.add("renter");
            return true;
        }else if(userType.equalsIgnoreCase("landlord")){
            db.registerLandlord(user.getName(), user.getEmail(), user.getPassword());
            storedNames.add(user.getName());
            storedEmails.add(user.getEmail());
            storedPasswords.add(user.getPassword());
            storedTypes.add("landlord");
            return true;
        }else if(userType.equalsIgnoreCase("manager")){
            db.registerManager(user.getName(), user.getEmail(), user.getPassword());
            storedNames.add(user.getName());
            storedEmails.add(user.getEmail());
            storedPasswords.add(user.getPassword());
            storedTypes.add("manager");
            return true;
        }

        return false;
    }   
}