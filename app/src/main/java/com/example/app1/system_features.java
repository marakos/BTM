package com.example.app1;


import java.io.Serializable;

public class system_features extends features implements Serializable {

    private String system_features_name;

    public system_features(String name, String aname) {
        super.features_name = name;
        this.system_features_name = aname;
    }

    public void setSystem_features_name(String aname) {
        this.system_features_name = aname;
    }

    public String getSystem_features_name() {
        return this.system_features_name;
    }

}
