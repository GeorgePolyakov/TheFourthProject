package com.example.thefourthproject;

import java.io.Serializable;

public class UserModel implements Serializable {

    private int userName;
    public UserModel(int userName) {
        this.userName = userName;
    }
    public int getUserName() {
        return userName;
    }
}