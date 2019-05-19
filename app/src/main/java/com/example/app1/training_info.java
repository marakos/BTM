package com.example.app1;

public class training_info {

    //fields
    private String training_value;
    private int training_id;

    //constructors
    public training_info(String value, int id) {
        this.training_value = value;
        this.training_id = id;
    }

    //properties
    public void setTraining_value(String value) {
        this.training_value = value;
    }

    public String getTraining_value() {
        return training_value;
    }

    public void setTraining_id(int id) {
        this.training_id = id;
    }

    public int getTraining_id() {
        return training_id;
    }
}
