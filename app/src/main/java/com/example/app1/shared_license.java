package com.example.app1;

import java.io.Serializable;

public class shared_license implements Serializable {

    private int shared_license_id;
    private String shared_license_info;

    public shared_license(int id, String info){
        this.shared_license_id = id;
        this.shared_license_info = info;
    }

    public void setShared_license_id(int id) {
        this.shared_license_id = id;
    }

    public int getShared_license_id(){
        return this.shared_license_id;
    }

    public void setShared_license_info(String info) {
        this.shared_license_info = info;
    }

    public String getShared_license_info() {
        return this.shared_license_info;
    }

}
