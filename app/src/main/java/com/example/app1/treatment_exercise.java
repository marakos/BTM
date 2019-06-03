package com.example.app1;

import java.io.Serializable;

public class treatment_exercise extends exercise implements Serializable {
    private String treatment_category;

    public treatment_exercise(int exercise_id, String treatment_category) {
        super(exercise_id);
        this.treatment_category = treatment_category;
    }

    public String getTreatment_category() {
        return treatment_category;
    }

    public void setTreatment_category(String treatment_category) {
        this.treatment_category = treatment_category;
    }
}
