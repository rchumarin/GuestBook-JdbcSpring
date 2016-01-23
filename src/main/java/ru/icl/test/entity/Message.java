package ru.icl.test.entity;

public class Message implements java.io.Serializable {

    private int id;
    private String message;
    private String clientid;

    public Message() {
    }	

    public Message(int id, String clientid, String message) {
        this.id = id;
        this.clientid = clientid;
        this.message = message;
    }
    
    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return this.message;
    }    
    public void setMessage(String message) {
        this.message = message;
    }

    public String getClientid() {
        return clientid;
    }
    public void setClientid(String clientid) {
        this.clientid = clientid;
    }

}


