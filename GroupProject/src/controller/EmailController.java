package controller;

import model.Email;
import GUI.EmailSystemScreen;

public class EmailController {
    private EmailSystemScreen view;
    private Email email;
    private DBMS db;
    
    public EmailController() {
    	db = new DBMS("jdbc:mysql://localhost/mydb", "root", "hello12345");
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
    public String getLandlordEmail() {
    	return email.getReceiver();
    }
    public String getUserType() {
    	return db.loggedinType;
    }
    public String[][] getLandlordInbox(){
    	return db.getEmails();
    }
}