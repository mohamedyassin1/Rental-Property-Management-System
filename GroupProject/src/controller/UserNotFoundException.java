package controller;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
		super("User Is Not Registered");
	}
}
