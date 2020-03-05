package com.example.thefourthproject;

import java.io.Serializable;

public class ProductModel implements Serializable {

    private int productName;
    public ProductModel(int userName) {
        this.productName = userName;
    }
    public int getUserName() {
        return productName;
    }
}