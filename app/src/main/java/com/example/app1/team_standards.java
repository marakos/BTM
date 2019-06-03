package com.example.app1;

import java.io.Serializable;

public class team_standards implements Serializable {
    private String team_position;
    private float team_height,team_age,team_ft_per, team_2pts_per, team_3pts_per, team_reb_def, team_reb_off, team_assists, team_to, team_steals, team_blocks, team_foul;

    public team_standards(String position,float height,float age, float ft_per,float twopts_per, float threepts_per, float reb_off, float reb_def, float assists, float to, float steals, float blocks, float foul) {
        this.team_position = position;
        this.team_height = height;
        this.team_age = age;
        this.team_ft_per = ft_per;
        this.team_2pts_per = twopts_per;
        this.team_3pts_per = threepts_per;
        this.team_reb_def = reb_def;
        this.team_reb_off = reb_off;
        this.team_assists = assists;
        this.team_to = to;
        this.team_steals = steals;
        this.team_blocks = blocks;
        this.team_foul = foul;
    }

    public String getTeam_position() {
        return team_position;
    }
    public void setTeam_position(String position) {
        this.team_position = position;
    }

    public float getTeam_height() {
        return team_height;
    }
    public void setTeam_height(float height) {
        this.team_height = height;
    }

    public float getTeam_age() {
        return team_age;
    }
    public void setTeam_age(float age) {
        this.team_age = age;
    }

    public float getTeam_ft_per() {
        return team_ft_per;
    }
    public void setTeam_ft_per(float ft_per) {
        this.team_ft_per = ft_per;
    }

    public float getTeam_2pts_per() {
        return team_2pts_per;
    }
    public void setTeam_2pts_per(float twopts_per) {
        this.team_2pts_per = twopts_per;
    }

    public float getTeam_3pts_per() {
        return team_3pts_per;
    }
    public void setTeam_3pts_per(float threepts_per) {
        this.team_3pts_per = threepts_per;
    }

    public float getTeam_reb_def() {
        return team_reb_def;
    }
    public void setTeam_reb_def(float reb_def) {
        this.team_reb_def = reb_def;
    }

    public float getTeam_reb_off() {
        return team_reb_off;
    }
    public void setTeam_reb_off(float reb_off) {
        this.team_reb_off = reb_off;
    }

    public float getTeam_assists() {
        return team_assists;
    }
    public void setTeam_assists(float assists) {
        this.team_assists = assists;
    }

    public float getTeam_to() {
        return team_to;
    }
    public void setTeam_to(float to) {
        this.team_to = to;
    }

    public float getTeam_steals() {
        return team_steals;
    }
    public void setTeam_steals(float steals) {
        this.team_steals = steals;
    }

    public float getTeam_blocks() {
        return team_blocks;
    }
    public void setTeam_blocks(float blocks) {
        this.team_blocks = blocks;
    }

    public float getTeam_foul() {
        return team_foul;
    }
    public void setTeam_foul(float foul) {
        this.team_foul = foul;
    }


}
