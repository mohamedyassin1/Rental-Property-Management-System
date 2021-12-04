package model;

public class RegisteredRenter extends Renter{
    
    RegisteredRenter(String name, String email, String pass){
        super(name, email, pass);
    }
    RegisteredRenter(Renter r){
        super(r.name, r.email, r.password);
    }
    public void saveSearchCriteria(PropertyType type, int numBedrooms, int numBathrooms, boolean furnished, CityQuadrant quadrant){
        //save this criteria to the db
    }
    public void unsubscribe(){
        //delete the object
    }
    
    
}
