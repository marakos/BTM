package com.example.app1;

import java.io.Serializable;

public class training_info implements Serializable {

    public Object setTraining_value;
    public Object setTraining_id;
    //fields
    private String training_value;
    private int training_id;

    //constructors
    public training_info(String value, int id) {
        this.training_value = value;
        this.training_id = id;
    }

    public training_info(int id1) {
    }

    public training_info(String value1) {

    }

    //properties
    public training_info setTraining_value(String value) {
        this.training_value = value;
        return null;
    }

    public String getTraining_value() {
        return training_value;
    }

    public training_info setTraining_id(int id) {
        this.training_id = id;
        return null;
    }

    public int getTraining_id() {
        return training_id;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("training_info{");
        sb.append("training_value='").append(training_value).append('\'');
        sb.append(", training_id=").append(training_id);
        sb.append('}');
        return sb.toString();
    }
}
