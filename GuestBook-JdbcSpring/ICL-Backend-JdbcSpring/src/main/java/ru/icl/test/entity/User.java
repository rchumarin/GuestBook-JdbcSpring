package ru.icl.test.entity;

public class User  implements java.io.Serializable {

    private String clientid;
    private String fname;
    
    public User() {
    }	
    public User(String clientid) {        
        this.clientid = clientid;
    }
    public User(String clientid, String fname) {        
        this.clientid = clientid;
        this.fname = fname;
    }

    public String getClientid() {
        return this.clientid;
    }
    public void setClientid(String clientid) {
        this.clientid = clientid;
    }

    public String getFname() {
        return this.fname;
    }    
    public void setFname(String fname) {
        this.fname = fname;
    }

}


