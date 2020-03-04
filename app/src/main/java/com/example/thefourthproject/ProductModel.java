package com.example.thefourthproject;

import java.io.Serializable;

public class ProductModel implements Serializable {

    private int userName;
    public ProductModel(int userName) {
        this.userName = userName;
    }
    public int getUserName() {
        return userName;
    }
}