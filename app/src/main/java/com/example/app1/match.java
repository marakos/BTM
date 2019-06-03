package com.example.app1;

import java.io.Serializable;

public class match implements Serializable {
    private int match_id;
    private String match_opp;
    private String match_date;
    private String match_dif;

    public match(int match_id,String match_opp,String match_date,String match_dif)
    {
        this.match_id=match_id;
        this.match_opp=match_opp;
        this.match_date=match_date;
        this.match_dif=match_dif;

    }

    public void setID(int i)
    {
        match_id=i;
    }

    public int getID()
    {
        return match_id;


    }

    public void setDATE(String date)
    {
        match_date=date;

    }

    public String getDATE()
    {
        return match_date;
    }

    public void setOPP(String oppp1)
    {
        match_opp=oppp1;
    }
    public String getOPP()
    {
        return match_opp;
    }

    public void setDIF(String dif1)
    {
        match_dif=dif1;
    }

    public String getDIF()
    {
        return match_dif;

    }


}

