package com.example.app1;

import java.io.Serializable;

public class membership  implements Serializable {

    private int membership_id;
    private String membership_start;
    private String membership_end;

    public membership(int id, String start, String end){
        this.membership_id = id;
        this.membership_start = start;
        this.membership_end = end;
    }

    public void setMembership_id(int id){
        this.membership_id = id;
    }

    public int getMembership_id() {
        return this.membership_id;
    }

    public void setMembership_start(String start) {
        this.membership_start = start;
    }

    public String getMembership_start() {
        return this.membership_start;
    }

    public void setMembership_end(String end) {
        this.membership_end = end;
    }

    public String getMembership_end() {
        return this.membership_end;
    }

}
