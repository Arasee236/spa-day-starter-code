package org.launchcode.spaday.models;

import java.time.LocalDate;
import java.util.Date;

public class User {
    private int id;
    private static int nextId =1;
    private  String userName;
    private  String email;
    private  String password;
    private LocalDate dateCreated;

    public User(String userName,String email, String password) {

        this.userName = userName;
        this.email =  email;
        this.password = password;
        this.id= nextId;
        nextId++;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public int getId() {
        return id;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }
}
