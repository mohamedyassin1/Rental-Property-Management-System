package model;

public class Email {
    private User sender;
    private User receiver;
    private String message;
    // private Property m;
    public Email(User sender, User receiver, String msg){
        this.sender = sender;
        this.receiver = receiver;
        this.message = msg;
    }
    public void send(){
        
    }
    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    
}
