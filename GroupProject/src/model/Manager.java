package model;

import java.util.ArrayList;

public class Manager extends User{
    Manager(String email, String pass, String name){
        super(email, pass, name);
    }
    public void createReport(int numHousesRented, int numHousesListed, int numActiveListings, ArrayList<Property> housesRented){
        Report createReport = new Report(numHousesRented, numHousesListed, numActiveListings, housesRented);
        createReport.generate();
    }
}
