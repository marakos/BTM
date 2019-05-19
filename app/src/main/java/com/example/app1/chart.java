package com.example.app1;

public class chart {

    //fields
    private int chart_type;
    private int chart_id;

    //constructors
    public chart(int type, int id){
        this.chart_type = type;
        this.chart_id = id;
    }

    //properties
    public void setChart_type(int type) {
        this.chart_type = type;
    }

    public int getChart_type() {
        return chart_type;
    }

    public void setChart_id(int id) {
        this.chart_id = id;
    }

    public int getChart_id() {
        return chart_id;
    }
}