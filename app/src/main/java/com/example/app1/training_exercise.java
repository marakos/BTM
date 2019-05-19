package com.example.app1;

public class training_exercise extends exercise {

    private String training_category;
    private int exercise_id;
    private String onoma;

    public training_exercise(String treatment_category, String onoma,int exercise_id) {
        this.training_category = training_category;
        this.exercise_id = exercise_id;
        this.onoma=onoma;
    }

    public void setcategory(String i)
    {
        training_category=i;
    }

    String getcategory()
    {
        return training_category;
    }

    public void setid(int id)
    {
        exercise_id=id;
    }

    int getid()
    {
        return exercise_id;
    }

    public void setonoma(String onoma1)
    {
        onoma=onoma1;
    }

    String getonoma()
    {
        return onoma;
    }
}

