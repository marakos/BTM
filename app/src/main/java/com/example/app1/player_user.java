package com.example.app1;
import java.lang.*;

public class player_user extends user{
    private String player_role;
    private boolean player_access;

    public player_user(String role, boolean access){
        this.player_role = role;
        this.player_access = access;
    }
    public void setPlayer_role(String role){
        this.player_role = role;
    }
    public String getPlayer_role(){
        return this.player_role;
    }
    public void setPlayer_access(boolean access){
        this.player_access = access;
    }
    public boolean getPlayer_access(){
        return this.player_access;
    }
}
