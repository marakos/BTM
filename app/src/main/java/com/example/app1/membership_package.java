package com.example.app1;

import java.io.Serializable;

public class membership_package implements Serializable {

    private float package_price;
    private int package_id;
    private char package_feature;
    private String package_name;

    public membership_package(float price, int id, char features, String name){
        this.package_price = price;
        this.package_id = id;
        this.package_feature = features;
        this.package_name = name;
    }

    public void setPackage_price(float price){
        this.package_price = price;
    }

    public float getPackage_price(){
        return this.package_price;
    }

    public void setPackage_id(int id){
        this.package_id = id;
    }

    public int getPackage_id(){
        return this.package_id;
    }

    public void setPackage_feature(char feature){
        this.package_feature = feature;
    }

    public char getPackage_feature(){
        return this.package_feature;
    }

    public void setPackage_name(String name){
        this.package_name = name;
    }

    public String getPackage_name(){
        return this.package_name;
    }

}
