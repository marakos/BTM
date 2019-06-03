package com.example.app1;

import java.io.Serializable;

public class match_stats  implements Serializable {


    public match_stats setStat_id;
    //fields
    private int stat_id;

    //constructors
    public match_stats(int id) {
        this.stat_id = id;
    }

    //properties
    public void setStat_id(int id){
        this.stat_id = id;
    }

    public int getStat_id() {
        return stat_id;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("match_stats{");
        sb.append("stat_id=").append(stat_id);
        sb.append('}');
        return sb.toString();
    }

}