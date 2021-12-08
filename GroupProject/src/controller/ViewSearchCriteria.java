package controller;

import java.util.ArrayList;
import model.*;
import model.Property;
public class ViewSearchCriteria{
    private Property propertyModel;
    private DBMS db;


    public ViewSearchCriteria() {
        db = new DBMS("jdbc:mysql://localhost/mydb", "root", "hello12345");
        // db.registerProperty(propertyStatus, propertyType, numBedrooms, numBathrooms,furnished,
        // quadrant, address, loggedinEmail);
    }

    public String[][] getActiveProperties() {
        return db.getActiveProperties();
    }
    public String[][] getCriteriaProperties(String type, int numBedrooms, int numBathrooms, String furnished, String quadrant) {
        return db.getCriteriaProperties(type, numBedrooms, numBathrooms, furnished, quadrant);
    }
    public DBMS getDb() {
        return db;
    }
    public void setDb(DBMS db) {
        this.db = db;
    }
    /*
    public Landlord getLandlord() {
        return landlord;
    }*/
    /*
    public void setLandlord(Landlord landlord) {
        this.landlord = landlord;
    }*/
}
