package com.example.app1;

import java.io.Serializable;

public class player_user extends user implements Serializable {

    private String player_role;
    private boolean player_access;

    public player_user(int user_id, int user_team_id, String user_password, String role, boolean access){
        super(user_id, user_team_id,user_password);
        this.player_role = role;
        this.player_access = access;
    }

    public void setPlayer_role(String role){
        this.player_role = role;
    }

    public String getPlayer_role() {
        return this.player_role;
    }

    public void setPlayer_access(boolean access) {
        this.player_access = access;
    }

    public boolean getPlayer_access() {
        return this.player_access;
    }

}
