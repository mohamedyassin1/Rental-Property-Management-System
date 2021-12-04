package model;

import java.util.ArrayList;
import java.io.*;

//Finished
public class Report {
    private int numHousesRented;
    private int numHousesListed;
    private int numActiveListings;
    private ArrayList<Property> housesRented;
    public Report(int numHousesRented, int numHousesListed, int numActiveListings, ArrayList<Property> housesRented) {
        this.numHousesRented = numHousesRented;
        this.numHousesListed = numHousesListed;
        this.numActiveListings = numActiveListings;
        this.housesRented = housesRented;
    }
    
    public void generate(){
        File order = null;
        FileWriter output = null;
        try {
            order = new File("Report.txt");
            order.createNewFile();
            output = new FileWriter(order);
            output.write("Manager Report:\n\n");
            output.write("Houses Rented: "+numHousesRented+"\n");
            output.write("Houses Listed: "+numHousesListed+"\n");
            output.write("Houses Active: "+numActiveListings+"\n");
            output.write("Houses Rented:\n\n");
            for(int i=0;i<(int)housesRented.size();i++){
                //loop through each property that is rented in DB
                output.write(housesRented.get(i).getId()+"   "+housesRented.get(i).getType()+"   "+housesRented.get(i).getAddress()+"   "+housesRented.get(i).getOwner().name);
                output.write("\n");
            }
            output.close();
        }
        catch (IOException e) {
            System.err.print("IOException writing to file.");
            System.exit(1);
        }
    }
}
