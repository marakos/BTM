package com.example.app1;
import java.lang.*;

public class shared_licence {
    private int shared_licence_id;
    private String shared_licence_info;

    public shared_licence(int id, String info){
        this.shared_licence_id = id;
        this.shared_licence_info = info;
    }
    public void setShared_licence_id(int id){
        this.shared_licence_id = id;
    }
    public int getShared_licence(){
        return this.shared_licence_id;
    }
    public void setShared_licence_info(String info){
        this.shared_licence_info = info;
    }
    public String getShared_licence_info(){
        return this.shared_licence_info;
    }
}
