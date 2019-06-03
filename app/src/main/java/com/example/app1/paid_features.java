package com.example.app1;

import java.io.Serializable;

public class paid_features extends features implements Serializable {

    private String paid_features_name;

    public paid_features(String name, String aname) {
        super.features_name = name;
        this.paid_features_name = aname;
    }

    public void setPaid_features_name(String aname){
        this.paid_features_name = aname;
    }

    public String getPaid_features_name() {
        return this.paid_features_name;
    }

}
