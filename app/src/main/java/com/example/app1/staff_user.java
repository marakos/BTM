package com.example.app1;

import java.io.Serializable;

public class staff_user extends user implements Serializable {

    private String staff_role;
    private boolean staff_access;

    public staff_user(int user_id, int user_team_id, String user_password,String role, boolean access){
        super(user_id,user_team_id,user_password);
        this.staff_role = role;
        this.staff_access = access;
    }

    public void setStaff_role(String role){
        this.staff_role = role;
    }

    public String getStaff_role() {
        return this.staff_role;
    }

    public void setStaff_access(boolean access) {
        this.staff_access = access;
    }

    public boolean getStaff_access() {
        return this.staff_access;
    }

}
