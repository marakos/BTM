package com.example.app1;

import java.io.Serializable;

public class training_exercise extends exercise implements Serializable {

    private String tr_exercise_category;
    private int exercise_id;

    public training_exercise(int exercise_id,String tr_exercise_category) {
        super(exercise_id);
        this.tr_exercise_category = tr_exercise_category;
    }

    public String getTrainingExerciseCategory() {
        return tr_exercise_category;
    }

    public void setTrainingExerciseCategory(String tr_exercise_category) {
        this.tr_exercise_category = tr_exercise_category;
    }

    public void setid(int id)
    {
        exercise_id=id;
    }

    int getid()
    {
        return exercise_id;
    }


}



