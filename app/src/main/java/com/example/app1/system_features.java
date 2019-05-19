package com.example.app1;
import java.lang.*;

public class system_features extends features{
    private String system_features_name;

    public system_features( String name){
        this.system_features_name = name;
    }
    public void setSystem_features(String name){
        this.system_features_name = name;
    }
    public String getSystem_features_name(){
        return this.system_features_name;
    }
}
