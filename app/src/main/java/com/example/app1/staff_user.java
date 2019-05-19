package com.example.app1;
import java.lang.*;

public class staff_user extends user{
    private String staff_role;
    private boolean staff_access;

    public staff_user(String role, boolean access){
        this.staff_role = role;
        this.staff_access = access;
    }
    public void setStaff_role(String role){
        this.staff_role = role;
    }
    public String getStaff_role(){
        return this.staff_role;
    }
    public void setStaff_access(boolean access){
        this.staff_access = access;
    }
    public boolean getStaff_access(){
        return this.staff_access;
    }
}
