package com.example.app1;

import java.io.Serializable;

public class player implements Serializable {

    private String player_name;
    private String player_lastname;
    private int player_id;


    public player(String player_name, String player_lastname, int player_id) {
        this.player_name = player_name;
        this.player_lastname = player_lastname;
        this.player_id = player_id;
    }

    public String getPlayer_name() {
        return player_name;
    }

    public void setPlayer_name(String player_name) {
        this.player_name = player_name;
    }

    public String getPlayer_lastname() {
        return player_lastname;
    }

    public void setPlayer_lastname(String player_lastname) {
        this.player_lastname = player_lastname;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }



}
