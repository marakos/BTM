package com.example.app1;

import java.io.Serializable;

public class attempts_stat implements Serializable {

    //fields
    private int stat_ft_attempted;
    private int stat_ft_made;
    private float stat_ft_per;
    private int stat_2pts_attempted;
    private int stat_2pts_made;
    private float stat_2pts_per;
    private int stat_3pts_attempted;
    private int stat_3pts_made;
    private float stat_3pts_per;
    private int player_id;



    //constructors
    public  attempts_stat(int ft_attempted, int ft_made, float ft_per, int twopts_attempted, int twopts_made, float twopts_per, int threepts_attempted, int threepts_made, float threepts_per){
        this.stat_2pts_attempted = twopts_attempted;
        this.stat_2pts_made = twopts_made;
        this.stat_3pts_attempted = threepts_attempted;
        this.stat_ft_attempted = ft_attempted;
        this.stat_ft_made = ft_made;
        this.stat_3pts_made = threepts_made;
        this.stat_ft_per = ft_per;
        this.stat_2pts_per = twopts_per;
        this.stat_3pts_per = threepts_per;
        this.player_id=player_id;
    }

    //properties
    public void setStat_ft_attempted(int ft_attempted){
        this.stat_ft_attempted = ft_attempted;
    }

    public int getStat_ft_attempted(){
        return stat_ft_attempted;
    }

    public void setStat_ft_made(int ft_made) {
        this.stat_ft_made = ft_made;
    }

    public int getStat_ft_made() {
        return stat_ft_made;
    }

    public void setStat_ft_per(float ft_per) {
        this.stat_ft_per = ft_per;
    }

    public float getStat_ft_per() {
        return stat_ft_per;
    }

    public void setStat_2pts_attempted(int twopts_attempted) {
        this.stat_2pts_attempted = twopts_attempted;
    }

    public int getStat_2pts_attempted() {
        return stat_2pts_attempted;
    }

    public void setStat_2pts_made(int twopts_made) {
        this.stat_2pts_made = twopts_made;
    }

    public int getStat_2pts_made() {
        return stat_2pts_made;
    }

    public void setStat_2pts_per(float twopts_per){
        this.stat_2pts_per = twopts_per;
    }

    public float getStat_2pts_per() {
        return stat_2pts_per;
    }

    public void setStat_3pts_attempted(int threepts_attempted) {
        this.stat_3pts_attempted = threepts_attempted;
    }

    public int getStat_3pts_attempted() {
        return stat_3pts_attempted;
    }

    public void setStat_3pts_made(int threepts_made) {
        this.stat_3pts_made = threepts_made;
    }

    public int getStat_3pts_made() {
        return stat_3pts_made;
    }

    public void setStat_3pts_per(float threepts_per){
        this.stat_3pts_per = threepts_per;
    }

    public float getStat_3pts_per() {
        return stat_3pts_per;
    }

    public int getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(int player_id) {
        this.player_id = player_id;
    }
    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("attempts_stat{");
        sb.append("stat_ft_attempted=").append(stat_ft_attempted);
        sb.append(", stat_ft_made=").append(stat_ft_made);
        sb.append(", stat_ft_per=").append(stat_ft_per);
        sb.append(", stat_2pts_attempted=").append(stat_2pts_attempted);
        sb.append(", stat_2pts_made=").append(stat_2pts_made);
        sb.append(", stat_2pts_per=").append(stat_2pts_per);
        sb.append(", stat_3pts_attempted=").append(stat_3pts_attempted);
        sb.append(", stat_3pts_made=").append(stat_3pts_made);
        sb.append(", stat_3pts_per=").append(stat_3pts_per);
        sb.append('}');
        return sb.toString();
    }
}