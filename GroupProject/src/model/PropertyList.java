package model;

import java.util.ArrayList;

public class PropertyList {
    private ArrayList<Property> properties;

    public PropertyList(ArrayList<Property> properties) {
        this.properties = properties;
    }

    public PropertyList() {
        properties = new ArrayList<>();
    }
    public void add(Property p){
        properties.add(p);
        
    }
    public void remove(int index){
        properties.remove(index);
    }
    public ArrayList<Property> getProperties() {
        return properties;
    }

    public void setProperties(ArrayList<Property> properties) {
        this.properties = properties;
    }
    
}
