package com.example.app1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TrainingSchedule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.training_schedule);
        configureShowMenuButton();
        configureShowMenuButton2();
        configureShowMenuButton3();
        configureShowMenuButton4();
        configureShowMenuButton5();
    }

    private void configureShowMenuButton(){
        Button button =(Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TrainingSchedule.this, SetPositionsStandards.class));
            }
        });
    }
    private void configureShowMenuButton2(){
        Button button9 =(Button) findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TrainingSchedule.this, ManageExercises.class));
            }
        });
    }
    private void configureShowMenuButton3(){
        Button button10 =(Button) findViewById(R.id.button10);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TrainingSchedule.this, TrainingScheduleGenerator.class));
            }
        });
    }
    private void configureShowMenuButton4(){
        Button button12 =(Button) findViewById(R.id.button12);
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TrainingSchedule.this, TrainingImpact.class));
            }
        });
    }
    private void configureShowMenuButton5(){
        Button button2 =(Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TrainingSchedule.this, MainActivity.class));
            }
        });
    }
}