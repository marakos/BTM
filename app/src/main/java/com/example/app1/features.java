package com.example.app1;

import java.io.Serializable;

public abstract class features implements Serializable {

    protected String features_name;

    public features(String name){
        this.features_name = name;
    }

    public features(){

    }

    public void setFeatures_name(String name) {
        this.features_name = name;
    }

    public String getFeautures_name() {
        return this.features_name;
    }

}
