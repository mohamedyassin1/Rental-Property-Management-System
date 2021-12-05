package model;

import java.util.ArrayList;

public class Manager extends User{
    public Manager(String email, String name, String pass){
        super(email, name, pass);
    }
    public void createReport(int numHousesRented, int numHousesListed, int numActiveListings, ArrayList<Property> housesRented){
        Report createReport = new Report(numHousesRented, numHousesListed, numActiveListings, housesRented);
        createReport.generate();
    }
}
