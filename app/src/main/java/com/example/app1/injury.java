package com.example.app1;

import java.io.Serializable;

public class injury implements Serializable {
    private String injury_name;
    private String injury_category;
    private int injury_id;

    public injury(String injury_name, String injury_category, int injury_id) {
        this.injury_name = injury_name;
        this.injury_category = injury_category;
        this.injury_id = injury_id;
    }

    public String getInjury_name() {
        return injury_name;
    }

    public void setInjury_name(String injury_name) {
        this.injury_name = injury_name;
    }

    public String getInjury_category() {
        return injury_category;
    }

    public void setInjury_category(String injury_category) {
        this.injury_category = injury_category;
    }

    public int getInjury_id() {
        return injury_id;
    }

    public void setInjury_id(int injury_id) {
        this.injury_id = injury_id;
    }
}
