package model;

public class RegisteredRenter extends Renter{
    
    public RegisteredRenter(String email, String name, String pass){
        super(email, name, pass);
    }
    public RegisteredRenter(Renter r){
        super(r.email, r.name, r.password);
    }
    /*
    public void saveSearchCriteria(PropertyType type, int numBedrooms, int numBathrooms, boolean furnished, CityQuadrant quadrant){
        //save this criteria to the db
    }*/
    public void unsubscribe(){
        //delete the object
    }
    
    
}
