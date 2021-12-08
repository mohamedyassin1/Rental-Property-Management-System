package controller;

import java.util.ArrayList;

import GUI.MainMenu;

public class DBCViewController {
	private DBMS db;
	
	public DBCViewController() {
    	db = new DBMS("jdbc:mysql://localhost/mydb", MainMenu.dbUsernameInput, MainMenu.dbPasswordInput);
    }
	public ArrayList<String> getRenterInfo(){
		return db.getRenterInfo();
	}
	public ArrayList<String>getLandlordInfo(){
		return db.getLandlordInfo();
	}
	public String[][] getPropertyInfo(){
		return db.getPropertyInfo();
	}
}
