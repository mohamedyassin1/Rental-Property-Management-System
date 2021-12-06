package controller;

import java.sql.*;
public class DBMS {
    /**Represents the database URL */
    public final String DBURL;
    /**Represents the database email */
    public final String USERNAME;
    /**Represents the database Password */
    public final String PASSWORD;
    /**Connection object that will be used to connect to the database */
    private Connection dbConnect;
    /**ResultSet Object that will be used to execute SQL commands */
    private ResultSet results;
    public DBMS(String dBURL, String username, String password) {
        DBURL = dBURL;
        USERNAME = username;
        PASSWORD = password;
        initializeConnection();
    }   
    
    public void initializeConnection(){
                
        try{
            dbConnect = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
            System.out.println("connected!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public boolean getRenter(String name, String email, String password){
        try {                    
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM renter");
            
            while (results.next()){
                String renterName = results.getString("name");
                String renterEmail = results.getString("email");
                String renterPassword = results.getString("password");
                if (name.equals(renterName) && email.equals(renterEmail) && password.equals(renterPassword)){
                    return true;
                }
            }
            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public void registerRenter(String name, String email, String password){
        try {
            String query = "INSERT INTO renter (email, name, password) VALUES (?,?,?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            
            myStmt.setString(1, email);
            myStmt.setString(2, name);
            myStmt.setString(3, password);
            myStmt.executeUpdate();
        // System.out.println("Rows affected: " + rowCount);
            
            myStmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public boolean getManager(String name, String email, String password){
        try {                    
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM manager");
            
            while (results.next()){
                String managerName = results.getString("name");
                String managerEmail = results.getString("email");
                String managerPassword = results.getString("password");
                if (name.equals(managerName) && email.equals(managerEmail) && password.equals(managerPassword)){
                    return true;
                }
            }
            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public void registerManager(String name, String email, String password){
        try {
                
            String query = "INSERT INTO manager (email, name, password) VALUES (?,?,?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            
            myStmt.setString(1, email);
            myStmt.setString(2, name);
            myStmt.setString(3, password);
            myStmt.executeUpdate();
        // System.out.println("Rows affected: " + rowCount);
            
            myStmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public boolean getLandlord(String name, String email, String password){
        try {                    
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM landlord");
            
            while (results.next()){
                String landlordName = results.getString("name");
                String landlordEmail = results.getString("email");
                String landlordPassword = results.getString("password");
                if (name.equals(landlordName) && email.equals(landlordEmail) && password.equals(landlordPassword)){
                    return true;
                }
            }
            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public void registerLandlord(String name, String email, String password){
        try {
                
            String query = "INSERT INTO landlord (email, name, password) VALUES (?,?,?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            
            myStmt.setString(1, email);
            myStmt.setString(2, name);
            myStmt.setString(3, password);
            myStmt.executeUpdate();
        // System.out.println("Rows affected: " + rowCount);
            
            myStmt.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void registerProperty(String propertyStatus, String propertyType, int numBedrooms, int numBathrooms, boolean furnished,
    String quadrant, String address, String landlord_email){
        try{
        String query = "INSERT INTO property (propertyStatus, propertyType, numBedrooms, numBathrooms,furnished,quadrant, address, landlord_email) VALUES (?,?,?,?,?,?,?,?)";
        PreparedStatement myStmt = dbConnect.prepareStatement(query);
        myStmt.setString(1, propertyStatus);
        myStmt.setString(2, propertyType);
        myStmt.setInt(3, numBedrooms);
        myStmt.setInt(4, numBathrooms);
        myStmt.setBoolean(5, furnished);
        myStmt.setString(6, quadrant);
        myStmt.setString(7, address);
        myStmt.setString(8, landlord_email);
        myStmt.executeUpdate();

        myStmt.close();

        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    public void close() {
        try {
            results.close();
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
