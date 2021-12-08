package controller;

public class NotificationController {
    DBMS db;
    public NotificationController(){
        db = new DBMS("jdbc:mysql://localhost/mydb", "root", "koko2001");
    }
    public String[][] getNotifications(){
       return db.getNotifications(); 
    }
    public void saveCriteria(String propertyType, int numBedrooms, int numBathrooms, String furnished,
    String quadrant){
        
        db.saveSearchCriteria(propertyType, numBedrooms, numBathrooms, furnished, quadrant);
    }
    
}
