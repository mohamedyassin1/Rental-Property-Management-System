package controller;

import java.sql.*;
public class DBMS {
    /**Represents the database URL */
    public final String DBURL;
    /**Represents the database Username */
    public final String USERNAME;
    /**Represents the database Password */
    public final String PASSWORD;
    /**Connection object that will be used to connect to the database */
    private Connection dbConnect;
    /**ResultSet Object that will be used to execute SQL commands */
    private ResultSet results;
    public DBMS(String dBURL, String uSERNAME, String pASSWORD) {
        DBURL = dBURL;
        USERNAME = uSERNAME;
        PASSWORD = pASSWORD;
        initializeConnection();
    }   
    
    public void initializeConnection(){
                
        try{
            dbConnect = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int getRenter(String name, String username, String password){
        try {                    
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM renter");
            
            while (results.next()){
                String renterName = results.getString("name");
                String renterUsername = results.getString("username");
                String renterPassword = results.getString("password");
                if (name.equals(renterName) && username.equals(renterUsername) && password.equals(renterPassword)){
                    return results.getInt("id");
                }
            }
            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }
    public int getManager(String name, String username, String password){
        try {                    
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM manager");
            
            while (results.next()){
                String managerName = results.getString("name");
                String managerUsername = results.getString("username");
                String managerPassword = results.getString("password");
                if (name.equals(managerName) && username.equals(managerUsername) && password.equals(managerPassword)){
                    return results.getInt("id");
                }
            }
            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }
    public int getLandlord(String name, String username, String password){
        try {                    
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM landlord");
            
            while (results.next()){
                String landlordName = results.getString("name");
                String landlordUsername = results.getString("username");
                String landlordPassword = results.getString("password");
                if (name.equals(landlordName) && username.equals(landlordUsername) && password.equals(landlordPassword)){
                    return results.getInt("id");
                }
            }
            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
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
