package com.example.buddycart;


import com.example.buddycart.model.UserModel;

import java.util.ArrayList;
import java.util.List;

public class UserData {
    private static UserData instance;
    private List<UserModel> users;

    private UserData(){
        users = new ArrayList<>();
    }

    public static UserData getInstance(){
        if(instance == null){
            instance = new UserData();
        }
        return instance;
    }

    public List<UserModel> getUsers(){
        return users;
    }
    public void addUser(UserModel user){
        users.add(user);
    }
}
