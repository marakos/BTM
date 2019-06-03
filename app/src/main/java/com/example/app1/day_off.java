package com.example.app1;

import java.io.Serializable;

public class day_off implements Serializable {
    private int day_off_id;
    private String day_off_day;

    public day_off(int day_of_id,String day_off_day)
    {
        this.day_off_id=day_of_id;
        this.day_off_day=day_off_day;

    }


    public void setDayId(int id)
    {
        day_off_id=id;
    }

    int getDayId()
    {
        return day_off_id;

    }

    public void setDayOff(String day)
    {
        day_off_day=day;
    }

    String getDayOff()
    {
        return day_off_day;
    }




}
