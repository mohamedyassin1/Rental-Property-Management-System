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
    public static String loggedinType;
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
                    loggedinType = "Renter";
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
                    loggedinType = "Manager";
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
                    loggedinType = "Landlord";
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


    public void registerProperty(String propertyStatus, String propertyType, int numBedrooms, int numBathrooms, String furnished,
    String quadrant, String address, String landlord_email){
        try{
            String query = "INSERT INTO property (propertyStatus, propertyType, numBedrooms, numBathrooms,furnished,quadrant, address, landlord_email) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            myStmt.setString(1, propertyStatus);
            myStmt.setString(2, propertyType);
            myStmt.setInt(3, numBedrooms);
            myStmt.setInt(4, numBathrooms);
            myStmt.setString(5, furnished);
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
    public void addNotifications(int propertyId){
        try {                    
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM property");
            
            while (results.next()){
                int id = results.getInt("houseIdNum");
                String address = results.getString("address");
                if(id == propertyId){
                   
                    try{
                        Statement myStmtCriteria = dbConnect.createStatement();
                        ResultSet resultsCriteria = myStmtCriteria.executeQuery("SELECT * FROM search_criteria");
                        while (resultsCriteria.next()){
                            String type = resultsCriteria.getString("propertyType");
                            String cityQuadrant = resultsCriteria.getString("CityQuadrant");
                            int numberBeds = resultsCriteria.getInt("numBedrooms");
                            int numberBaths = resultsCriteria.getInt("numBathrooms");
                            String houseFurnished = resultsCriteria.getString("furnished");
                            String email = resultsCriteria.getString("renter_email");
                           
                            if (type.equalsIgnoreCase(results.getString("propertyType")) && 
                                results.getInt("numBedrooms") == numberBeds && 
                                results.getInt("numBathrooms") == numberBaths && 
                                results.getString("furnished").equalsIgnoreCase(houseFurnished) &&
                                cityQuadrant.equalsIgnoreCase(results.getString("quadrant"))){
                                try{
                                    String query = "INSERT INTO notifications (renter_email, property_id, property_address) VALUES (?,?,?)";
                                    PreparedStatement myStmt_notification = dbConnect.prepareStatement(query);
                                    myStmt_notification.setString(1, email);
                                    myStmt_notification.setInt(2, propertyId);
                                    myStmt_notification.setString(3, address);
                                    
                                    myStmt_notification.executeUpdate();
            
                                    myStmt_notification.close();
                                }
                                catch (SQLException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        }
                            myStmtCriteria.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                    
                    
            }   
            myStmt.close();
        } catch (SQLException ex) {
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
    public String getLandlordEmail(int PropertyID) {
    	try {                    
    	    Statement myStmt = dbConnect.createStatement();
    	    results = myStmt.executeQuery("SELECT * FROM property");
    	    
    	    while (results.next()){
    	        int house_num = results.getInt("houseIdNum");
    	        
    	        if (house_num == PropertyID){
    	            return results.getString("landlord_email");
    	        }
    	    }
    	    myStmt.close();
    	} catch (SQLException ex) {
    	    ex.printStackTrace();
    	}
    	return " ";
    }
    public void sendEmail(String recipientEmail, String message, String subject) {
    	 try {
             String query = "INSERT INTO emails (receiver_email, sender_email,subject, message) VALUES (?,?,?,?)";
             PreparedStatement myStmt = dbConnect.prepareStatement(query);
             
             myStmt.setString(1, recipientEmail);
             myStmt.setString(2, loggedinEmail);
             myStmt.setString(3, subject);
             myStmt.setString(4, message);
             myStmt.executeUpdate();
             myStmt.close();

         } catch (SQLException ex) {
             ex.printStackTrace();
         }
    }
    public String[][] getEmails(){
    	 String[][] landlordEmails = new String[0][0];
         // ArrayList[][] activeProperties = new ArrayList<String, String>();
         try {                    
             Statement myStmt = dbConnect.createStatement();
             results = myStmt.executeQuery("SELECT * FROM emails");
             Statement myStmt2 = dbConnect.createStatement();
             ResultSet resultSet2 = myStmt2.executeQuery("SELECT * FROM emails");
             int count = 0;
             while (resultSet2.next()) {
             if (loggedinEmail.equalsIgnoreCase(resultSet2.getString("receiver_email"))) {
            	 			count++;
                 }   
             } 
             landlordEmails= new String[count][3];
             int i=0;
             while (results.next()){
                 String renter_email = results.getString("sender_email");
                 String message = results.getString("message");
                 String subject = results.getString("subject");
                 
                 if(loggedinEmail.equalsIgnoreCase(results.getString("receiver_email"))){
                     landlordEmails[i][0] = (renter_email);
                     landlordEmails[i][1] = subject;
                     landlordEmails[i][2] = message;
                     i++;
                 }
             }
             myStmt.close();
         } catch (SQLException ex) {
             ex.printStackTrace();
         }
         return landlordEmails;
    }
    public ArrayList<String> getRentersEmails(){
        
        ArrayList<String> renterEmails = new ArrayList<String>();
        try {                    
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM renter");
            
            while (results.next()){
                
                
                String email = results.getString("email");
                renterEmails.add(email);
                
            
            }
            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return renterEmails;
    }
    public void saveSearchCriteria(String propertyType, int numBedrooms, int numBathrooms, String furnished,
    String quadrant){
        try{
            String query = "INSERT INTO search_criteria (propertyType, numBedrooms, numBathrooms,furnished,cityQuadrant, renter_email) VALUES (?,?,?,?,?,?)";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            myStmt.setString(1, propertyType);
            myStmt.setInt(2, numBedrooms);
            myStmt.setInt(3,numBathrooms);
            myStmt.setString(4, furnished);
            // myStmt.setBoolean(5, furnished);
            myStmt.setString(5, quadrant);
            // myStmt.setString(7, address);
            myStmt.setString(6, loggedinEmail);
            myStmt.executeUpdate();
    
            myStmt.close();
    
            }
            catch (SQLException ex) {
                ex.printStackTrace();
            }
    }
    public String[][] getNotifications(){
        String[][] activeNotifications = new String[0][0];
        // ArrayList[][] activeProperties = new ArrayList<String, String>();
        try {                    
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM notifications");
            Statement myStmt2 = dbConnect.createStatement();
            ResultSet resultSet2 = myStmt2.executeQuery("SELECT * FROM notifications");
            int count = 0;
            while (resultSet2.next()) {
                if(resultSet2.getString("renter_email").equalsIgnoreCase(loggedinEmail)){
                    count++;
                }
              
            } 
            activeNotifications= new String[count][2];
            int i=0;
            while (results.next()){
                int id = results.getInt("property_id");
                String renter_email = results.getString("renter_email");
                
                String address = results.getString("property_address");
               
               
                if(renter_email.equalsIgnoreCase(loggedinEmail)){
                    activeNotifications[i][0] = String.valueOf(id);
                    activeNotifications[i][1] = address;
                    i++;
                }
                
            }
            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return activeNotifications;
    }
    public ArrayList<String> getRenterInfo() {
    	ArrayList<String> listOfRenters = new ArrayList<String>();
    	  try {                    
              Statement myStmt = dbConnect.createStatement();
              results = myStmt.executeQuery("SELECT * FROM renter");
              while (results.next()){
                  listOfRenters.add(" | Email: " + results.getString("email") + " | Name: " + results.getString("name"));
              }
              myStmt.close();
    	  }
    	  catch (SQLException ex) {
              ex.printStackTrace();
          }
              return listOfRenters;
    }
    public ArrayList<String> getLandlordInfo(){
    	ArrayList<String> landlordEmails = new ArrayList<String>();
    	ArrayList<String> landlordInfo = new ArrayList<String>();
    	 try {                    
             Statement myStmt = dbConnect.createStatement();
             results = myStmt.executeQuery("SELECT * FROM landlord");
             Statement myStmt2 = dbConnect.createStatement();
             ResultSet resultSet2 = myStmt2.executeQuery("SELECT * FROM property");
             while (results.next()) {
            	 landlordEmails.add(results.getString("email"));
            	 landlordInfo.add(" | Email: " + results.getString("email") + " | Name: " + results.getString("name") + " | Properties Owned: ");
             }
             while (resultSet2.next()) {
            	 if (landlordEmails.contains(resultSet2.getString("landlord_email"))) {
            		 int index = landlordEmails.indexOf(resultSet2.getString("landlord_email"));
            		 landlordInfo.set(index, landlordInfo.get(index) + " PropertyID#" + String.valueOf(resultSet2.getInt("houseIdNum")));
            	 }
             }
             myStmt.close();
   	  }
   	  catch (SQLException ex) {
             ex.printStackTrace();
         }
             return landlordInfo;
    }
    public String[][] getPropertyInfo(){
    	String[][] propertyInfo = new String[0][0];
    	 try {                    
             Statement myStmt = dbConnect.createStatement();
             results = myStmt.executeQuery("SELECT * FROM property");
             Statement myStmt2 = dbConnect.createStatement();
             ResultSet resultSet2 = myStmt2.executeQuery("SELECT * FROM property");
             int count = 0;
             while (results.next()) {
            	 count++;
             }
             propertyInfo = new String[count][9];
             int i = 0;
             while (resultSet2.next()) {
            	 String propertyStatus = resultSet2.getString("propertyStatus");
            	 String propertyType = resultSet2.getString("propertyType");
            	 String numBedrooms = String.valueOf(resultSet2.getInt("numBedrooms"));
            	 String numBathrooms = String.valueOf(resultSet2.getInt("numBathrooms"));
            	 String furnished = resultSet2.getString("furnished");
            	 String quadrant = resultSet2.getString("quadrant");
            	 String address = resultSet2.getString("address");
            	 String houseIdNum = String.valueOf(resultSet2.getInt("houseIdNum"));
            	 String landlordEmail = resultSet2.getString("landlord_email");

            	 propertyInfo[i][0] = propertyStatus;
            	 propertyInfo[i][1] = propertyType;
            	 propertyInfo[i][2] = numBedrooms;
            	 propertyInfo[i][3] = numBathrooms;
            	 propertyInfo[i][4] = furnished;
            	 propertyInfo[i][5] = quadrant;
            	 propertyInfo[i][6] = address;
            	 propertyInfo[i][7] = houseIdNum;
            	 propertyInfo[i][8] = landlordEmail;
            	 i++;
             }
             myStmt.close();
    	 }
             catch (SQLException ex) {
                 ex.printStackTrace();
             }
                 return propertyInfo;
    }
    public void updateFee(int amount, int period){
        
        try{
            String query ="UPDATE fees SET amount = ?, period = ? WHERE amount = ?";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);
            myStmt.setInt(1, amount);
            myStmt.setInt(2, period);
            myStmt.setInt(3, currFee);
            myStmt.executeUpdate();
            currFee = amount;
            myStmt.close();
        }catch (SQLException ex) {
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
