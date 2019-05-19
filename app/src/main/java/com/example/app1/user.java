package com.example.app1;
import java.lang.*;

public class user {
    private int user_id;
    private int user_team_id;
    private String user_password;

    public user(int id, int team_id, String password){
        this.user_id = id;
        this.user_team_id = team_id;
        this.user_password = password;
    }
    public void setUser_id(int id){
        this.user_id = id;
    }
    public int getUser_id(){
        return this.user_id;
    }
    public void setUser_team_id(int team_id){
        this.user_team_id = team_id;
    }
    public int getUser_team_id(){
        return this.user_team_id;
    }
    public void setUser_password(String password){
        this.user_password = password;
    }
    public String getUser_password(){
        return this.user_password;
    }
}
