package controller;

import java.util.ArrayList;

import GUI.MainMenu;

public class RegisteredRenterListener implements Observer{
	private NotificationsSubject notifications;
	private DBMS db;
	private String[][] newNotifs = new String[0][0];
	private NotificationController controller;
	private ArrayList<String> observers = new ArrayList<String>(db.getRentersEmails());
	
	
	public RegisteredRenterListener(NotificationsSubject notif) {
		db = new DBMS("jdbc:mysql://localhost/mydb", MainMenu.dbUsernameInput, MainMenu.dbPasswordInput);
		notifications = notif;
	}
	public void update() {
		newNotifs = controller.db.getNotifications();
	}
}
