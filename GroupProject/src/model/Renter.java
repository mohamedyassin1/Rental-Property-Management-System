package model;

public class Renter extends User{
    Renter(String email, String pass,String name){
        super(email, pass, name);
    }
    Renter(){
        super(); //unregistered
    }
    
    public void needFurtherDetails(String message){
        //send message to landlord(anonymous)
    }
    public void arrangeNeeting(String message){
        //send message to landlord(knowing their name and email)
    }
    public void SearchProperties(){
        //get All Properties in DB
    }
    public void SearchPropertiesByCriteria(PropertyType type, int numBedrooms, int numBathrooms, boolean furnished, CityQuadrant quadrant){
        //get all properties that match the criteria
    }
}
