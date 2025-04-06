package com.example.buddycart.model;

public class UserModel {
    private String phoneNumber;
    private String name;


    //constructor
    public UserModel(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    //getters
    public String getName(){
        return name;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    //setters
    public void setName(String name){
        this.name = name;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
}
