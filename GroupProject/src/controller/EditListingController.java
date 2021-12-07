package controller;

import java.util.ArrayList;
import model.*;
import model.Property;
public class EditListingController{
    private Property propertyModel;
    private DBMS db;


    public EditListingController() {
        db = new DBMS("jdbc:mysql://localhost/mydb", "root", "");
        // db.registerProperty(propertyStatus, propertyType, numBedrooms, numBathrooms,furnished,
        // quadrant, address, loggedinEmail);
    }

    public String[] getProperties() {
        return db.getPropertiesOfLandlord();
    }
    public boolean payFee(int house_id){
        return db.changeStatusOfProperty(house_id, "ACTIVE");
    }
    public String getFee(){
        return "$"+db.getFee();
    }
    public boolean changeStatus(int house_id, String Status){
        return db.changeStatusOfProperty(house_id, Status);
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
