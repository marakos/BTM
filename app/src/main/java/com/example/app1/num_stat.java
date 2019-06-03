package com.example.app1;

import java.io.Serializable;

public class num_stat implements Serializable {

    //fields
    private int stat_reb_off;
    private int stat_reb_def;
    private int stat_steals;
    private int stat_assists;
    private int stat_to;
    private int stat_blocks;
    private int stat_foul;
    private int stat_min;
    private int player_id;



    //constructors
    public num_stat(int reb_off, int reb_def, int steals, int assists, int to, int blocks, int foul, int min) {
        this.stat_reb_off = reb_off;
        this.stat_reb_def = reb_def;
        this.stat_steals = steals;
        this.stat_assists = assists;
        this.stat_to = to;
        this.stat_blocks = blocks;
        this.stat_foul = foul;
        this.stat_min = min;
        this.player_id=player_id;
    }

    //properties
    public void setStat_reb_off(int reb_off) {
        this.stat_reb_off = reb_off;
    }

    public int getStat_reb_off() {
        return stat_reb_off;
    }

    public void setStat_reb_def(int reb_def) {
        this.stat_reb_def = reb_def;
    }

    public int getStat_reb_def() {
        return stat_reb_def;
    }

    public void setStat_steals(int steals) {
        this.stat_steals = steals;
    }

    public int getStat_steals() {
        return stat_steals;
    }

    public void setStat_assists(int assists) {
        this.stat_assists = assists;
    }

    public int getStat_assists() {
        return stat_assists;
    }

    public void setStat_to(int to) {
        this.stat_to = to;
    }

    public int getStat_to() {
        return stat_to;
    }

    public void setStat_blocks(int blocks) {
        this.stat_blocks = blocks;
    }

    public int getStat_blocks() {
        return stat_blocks;
    }

    public void setStat_foul(int foul) {
        this.stat_foul = foul;
    }

    public int getStat_foul() {
        return stat_foul;
    }

    public void setStat_min(int min) {
        this.stat_min = min;
    }

    public int getStat_min() {
        return stat_min;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("num_stat{");
        sb.append("stat_reb_off=").append(stat_reb_off);
        sb.append(", stat_reb_def=").append(stat_reb_def);
        sb.append(", stat_steals=").append(stat_steals);
        sb.append(", stat_assists=").append(stat_assists);
        sb.append(", stat_to=").append(stat_to);
        sb.append(", stat_blocks=").append(stat_blocks);
        sb.append(", stat_foul=").append(stat_foul);
        sb.append(", stat_min=").append(stat_min);
        sb.append('}');
        return sb.toString();
    }
}