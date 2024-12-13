package cse.fivestarhotel.Login;

import java.io.Serializable;


import java.io.*;

public class FrontDeskStaff implements Serializable{
    private String id;
    private String password;

    public FrontDeskStaff(String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}

