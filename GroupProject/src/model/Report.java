package model;

import java.io.*;

//Finished
public class Report {
    private int numHousesRented;
    private int numHousesListed;
    private int numActiveListings;
    private String[][] housesRented;
    public Report(int numHousesRented, int numHousesListed, int numActiveListings,String[][] housesRented) {
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
            for(int i=0;i<(int)housesRented.length;i++){
                //loop through each property that is rented in DB
                output.write(i+".  Landlord's Name: "+housesRented[i][0]+"   Property Id: "+housesRented[i][1]+"  Property address: "+housesRented[i][2]);
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
