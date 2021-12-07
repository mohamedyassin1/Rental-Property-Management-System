package controller;

import java.sql.*;
import java.util.ArrayList;

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
    public static String loggedinEmail;
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
                    loggedinEmail = renterEmail;
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
                    loggedinEmail = managerEmail;
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
                    loggedinEmail = landlordEmail;
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
    public String[] getPropertiesOfLandlord(){
        ArrayList<String> properties = new ArrayList<String>();
        try {                    
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM property");
            
            while (results.next()){
                int id = results.getInt("houseIdNum");
                String landlordEmail = results.getString("landlord_email");
               
                if (landlordEmail.equalsIgnoreCase(loggedinEmail)){
                    properties.add(String.valueOf(id));
                }
            }
            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        String[] properties_to_return =  new String[properties.toArray().length];
        properties.toArray(properties_to_return);
        return properties_to_return;
    }
    public boolean changeStatusOfProperty(int property_id, String newStatus){
        try {                    
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM property");
            
            while (results.next()){
                int id = results.getInt("houseIdNum");
                String status = results.getString("propertyStatus");
               
                if (property_id==id && !(status.equals(newStatus))){
                    String query ="UPDATE property SET propertyStatus = ? WHERE houseIdNum = ?";
                    PreparedStatement myStmt2 = dbConnect.prepareStatement(query);
                    myStmt2.setString(1, newStatus);
                    myStmt2.setInt(2, id);
                    myStmt2.executeUpdate();
                    myStmt2.close();
                    return true;
                }else if(property_id==id){
                    return false;
                }
            }
            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    public String[][] getActiveProperties(){
        String[][] activeProperties = new String[0][0];
        // ArrayList[][] activeProperties = new ArrayList<String, String>();
        try {                    
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM property");
            Statement myStmt2 = dbConnect.createStatement();
            ResultSet resultSet2 = myStmt2.executeQuery("SELECT * FROM property");
            int count = 0;
            while (resultSet2.next()) {
                if(resultSet2.getString("propertyStatus").equalsIgnoreCase("ACTIVE")){
                    count++;
                }
              
            } 
            activeProperties= new String[count][7];
            int i=0;
            while (results.next()){
                int id = results.getInt("houseIdNum");
                int numBedrooms = results.getInt("numBedrooms");
                int numBathrooms = results.getInt("numBathrooms");
                String status = results.getString("propertyStatus");
                String type = results.getString("propertyType");
                String furnished = results.getString("furnished");
                String address = results.getString("address");
               
                String quadrant = results.getString("quadrant");
                if(status.equalsIgnoreCase("ACTIVE")){
                    activeProperties[i][0] = String.valueOf(id);
                    activeProperties[i][1] = type;
                    activeProperties[i][2] = String.valueOf(numBedrooms);
                    activeProperties[i][3] = String.valueOf(numBathrooms);
                    activeProperties[i][4] = furnished;
                    activeProperties[i][5] = quadrant;
                    activeProperties[i][6] = address;
    
                    i++;
                }
                
            }
            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return activeProperties;
    }
    public String[][] getCriteriaProperties(String propertyType, int numBeds, int numBaths, String isFurnished, String cityQuadrant){
        String[][] activeProperties = new String[0][0];
        // ArrayList[][] activeProperties = new ArrayList<String, String>();
        try {                    
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM property");
            Statement myStmt2 = dbConnect.createStatement();
            ResultSet resultSet2 = myStmt2.executeQuery("SELECT * FROM property");
            int count = 0;
            while (resultSet2.next()) {
                if(resultSet2.getString("propertyStatus").equalsIgnoreCase("ACTIVE") && resultSet2.getString("furnished").equalsIgnoreCase(isFurnished)&&resultSet2.getString("propertyType").equalsIgnoreCase(propertyType) && resultSet2.getString("quadrant").equalsIgnoreCase(cityQuadrant)&&resultSet2.getInt("numBedrooms")==numBeds && resultSet2.getInt("numBathrooms")==numBaths){
                    count++;
                }
              
            } 
            activeProperties= new String[count][7];
            int i=0;
            while (results.next()){
                int id = results.getInt("houseIdNum");
                int numBedrooms = results.getInt("numBedrooms");
                int numBathrooms = results.getInt("numBathrooms");
                String status = results.getString("propertyStatus");
                String type = results.getString("propertyType");
                String furnished = results.getString("furnished");
                String address = results.getString("address");
               
                String quadrant = results.getString("quadrant");
                if(status.equalsIgnoreCase("ACTIVE") && furnished.equalsIgnoreCase(isFurnished)&&type.equalsIgnoreCase(propertyType) && quadrant.equalsIgnoreCase(cityQuadrant)&&numBedrooms==numBeds && numBathrooms==numBaths){
                    activeProperties[i][0] = String.valueOf(id);
                    activeProperties[i][1] = type;
                    activeProperties[i][2] = String.valueOf(numBedrooms);
                    activeProperties[i][3] = String.valueOf(numBathrooms);
                    activeProperties[i][4] = furnished;
                    activeProperties[i][5] = quadrant;
                    activeProperties[i][6] = address;
    
                    i++;
                }
                
            }
            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return activeProperties;
    }
    public String getFee(){
        try {                    
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM fees");
            
            while (results.next()){
                int amount = results.getInt("amount");
                int period = results.getInt("period");
                return String.valueOf(amount)+" every "+String.valueOf(period)+ " days.";
            }
            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return "Free";
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
