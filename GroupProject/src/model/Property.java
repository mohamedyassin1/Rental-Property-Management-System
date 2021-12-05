package model;
/*
enum PropertyType {
    ATTACHEDHOUSE,
    DETACHEDHOUSE,
    APARTMENT,
    TOWNHOUSE,
    CONDO
}
public enum PropertyStatus {
    ACTIVE,
    RENTED,
    CANCELLED,
    SUSPENDED
}
public enum CityQuadrant {
    NW,
    NE,
    SW,
    SE
}*/

public class Property {
    
    private String propertyStatus;
    private String propertyType;
    private int numBedrooms;
    private int numBathrooms;
    private boolean furnished;
    private String quadrant;
    private String address;
    private int id;
    private String email;
    public Property(String propertyStatus, String propertyType, int numBedrooms, int numBathrooms, boolean furnished,
            String quadrant, String address, int id, String loggedinEmail) {
        this.propertyStatus = propertyStatus;
        this.propertyType = propertyType;
        this.numBedrooms = numBedrooms;
        this.numBathrooms = numBathrooms;
        this.furnished = furnished;
        this.quadrant = quadrant;
        this.address = address;
        this.id = id;
        this.email = loggedinEmail;
    }
    public String getStatus() {
        return propertyStatus;
    }
    public void setStatus(String propertyStatus) {
        this.propertyStatus = propertyStatus;
    }
    public String getType() {
        return propertyType;
    }
    
    public int getNumBedrooms() {
        return numBedrooms;
    }
    
    public int getNumBathrooms() {
        return numBathrooms;
    }
    
    public boolean isFurnished() {
        return furnished;
    }
    public void setFurnished(boolean furnished) {
        this.furnished = furnished;
    }
    public String getQuadrant() {
        return quadrant;
    }
    
    public String getAddress() {
        return address;
    }
    
    public int getId() {
        return id;
    }
    
    public String getEmail() {
        return email;
    }
    
    
}
