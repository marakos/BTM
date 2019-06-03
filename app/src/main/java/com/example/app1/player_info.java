package com.example.app1;

import java.io.Serializable;

public class player_info implements Serializable {

    // fields
    private float player_height;
    private String player_info_name;
    private float player_age;
    private String player_position;
    private String player_injured;

    // constructors
    public player_info(String name, String position,float height, float age, String injured) {
        this.player_info_name = name;
        this.player_position = position;
        this.player_height = height;
        this.player_age = age;
        this.player_injured = injured;
    }
    // properties
    public void setPlayer_info_name(String name) {
        this.player_info_name = name;
    }
    public String getPlayer_info_name() {
        return this.player_info_name;
    }
    public void setPlayer_position(String position) {
        this.player_position = position;
    }
    public String getPlayer_position() {
        return this.player_position;
    }
    public void setPlayer_injured(String injured) {
        this.player_injured =injured ;
    }
    public String getPlayer_injured() {
        return this.player_injured;
    }
    public void setPlayer_age(float age) {

        this.player_age = age;
    }
    public float getPlayer_age() {
        return this.player_age;
    }
    public void setPlayer_height(float height) {

        this.player_height = height;
    }
    public float getPlayer_height() {
        return this.player_height;
    }
}
