package com.example.app1;

import java.io.Serializable;

public abstract class exercise implements Serializable {

    private int exercise_id;

    public exercise(int exercise_id) {
        this.exercise_id = exercise_id;
    }
}