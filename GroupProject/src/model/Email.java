package model;

public class Email {
    private String sender;
    private String receiver;
    private String message;
    private String subject;
    // private Property m;
    public Email(String sender, String receiver, String msg, String subj){
        this.sender = sender;
        this.receiver = receiver;
        this.message = msg;
        this.subject = subj;
    }
    public void send(){
        
    }
    public String getSender() {
        return sender;
    }

    public String getReceiver() {
        return receiver;
    }
    public String getSubject() {
        return subject;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setSubject(String subject) {
        this.subject = subject;
    }
    
}
