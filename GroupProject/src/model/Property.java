package model;
enum PropertyType {
    ATTACHEDHOUSE,
    DETACHEDHOUSE,
    APARTMENT,
    TOWNHOUSE,
    CONDO
}
enum PropertyStatus {
    ACTIVE,
    RENTED,
    CANCELLED,
    SUSPENDED
}
enum CityQuadrant {
    NW,
    NE,
    SW,
    SE
}
public class Property {
    private PropertyStatus status;
    private PropertyType type;
    private int numBedrooms;
    private int numBathrooms;
    private boolean furnished;
    private CityQuadrant quadrant;
    private String address;
    private int id;
    private Landlord owner;
    public Property(PropertyStatus status, PropertyType type, int numBedrooms, int numBathrooms, boolean furnished,
            CityQuadrant quadrant, String address, int id, Landlord owner) {
        this.status = status;
        this.type = type;
        this.numBedrooms = numBedrooms;
        this.numBathrooms = numBathrooms;
        this.furnished = furnished;
        this.quadrant = quadrant;
        this.address = address;
        this.id = id;
        this.owner = owner;
    }
    public PropertyStatus getStatus() {
        return status;
    }
    public void setStatus(PropertyStatus status) {
        this.status = status;
    }
    public PropertyType getType() {
        return type;
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
    public CityQuadrant getQuadrant() {
        return quadrant;
    }
    
    public String getAddress() {
        return address;
    }
    
    public int getId() {
        return id;
    }
    
    public Landlord getOwner() {
        return owner;
    }
    
    
}
