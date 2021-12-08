package controller;

import java.util.ArrayList;
import model.*;
import model.Property;
public class PropertyPostingController{
    private Property propertyModel;
    private DBMS db;


    public PropertyPostingController(String propertyStatus, String propertyType, int numBedrooms, int numBathrooms, String furnished,
    String quadrant, String address, String loggedinEmail) {
        db = new DBMS("jdbc:mysql://localhost/mydb", "root", "");
        db.registerProperty(propertyStatus, propertyType, numBedrooms, numBathrooms,furnished,
        quadrant, address, loggedinEmail);
    }

    public Property getPropertyModel() {
        return propertyModel;
    }
    public void setPropertyModel(Property propertyModel) {
        this.propertyModel = propertyModel;
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
