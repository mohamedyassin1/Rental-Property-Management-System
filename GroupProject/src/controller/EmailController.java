package controller;

import model.Email;

import java.util.ArrayList;

import GUI.EmailSystemScreen;
import GUI.MainMenu;

public class EmailController {
    private EmailSystemScreen view;
    private Email email;
    private DBMS db;
    
    public EmailController() {
    	db = new DBMS("jdbc:mysql://localhost/mydb", MainMenu.dbUsernameInput, MainMenu.dbPasswordInput);
    }
    public String[] getProperties() {
    	String[][] temp =  db.getActiveProperties();
    	String[] x = new String[temp.length];
    	for (int i = 0; i < temp.length; i++)
    	{
    		x[i] = temp[i][0];
    	}
    	return x;
    }
    public void send(int propertyID, String message, String subject) {
    	email = new Email(db.loggedinEmail, db.getLandlordEmail(propertyID), message, subject);
    	db.sendEmail(email.getReceiver(), email.getMessage(), email.getSubject());
    }
    public void send(String renter_email, String message, String subject) {
    	// email = new Email(db.loggedinEmail, db.getLandlordEmail(propertyID), message, subject);
    	db.sendEmail(renter_email, message, subject);
    }
    public String getLandlordEmail() {
    	return email.getReceiver();
    }
    public String getUserType() {
    	return db.loggedinType;
    }
    public boolean getRenterEmails(String emailToCheck){
        return db.getRentersEmails().contains(emailToCheck);
    }
    public String[][] getLandlordInbox(){
    	return db.getEmails();
    }
}