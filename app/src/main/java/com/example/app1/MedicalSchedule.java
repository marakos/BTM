package com.example.app1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MedicalSchedule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medical_schedule);
        configureShowMenuButton();
        configureShowMenuButton2();
        configureShowMenuButton3();
        configureShowMenuButton4();
        configureShowMenuButton5();
        configureShowMenuButton6();
    }

    private void configureShowMenuButton(){
        Button button2 =(Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MedicalSchedule.this, ImportExportTeamData.class));
            }
        });
    }
    private void configureShowMenuButton2(){
        Button button =(Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MedicalSchedule.this, ManageTeamMembers.class));
            }
        });
    }
    private void configureShowMenuButton3(){
        Button button9 =(Button) findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MedicalSchedule.this, ManagePlayersInformation.class));
            }
        });
    }
    private void configureShowMenuButton4(){
        Button button4 =(Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MedicalSchedule.this, SetTeamStandards.class));
            }
        });
    }
    private void configureShowMenuButton5(){
        Button button10 =(Button) findViewById(R.id.button10);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MedicalSchedule.this, ManageTeamSchedule.class));
            }
        });
    }
    private void configureShowMenuButton6(){
        Button button3 =(Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MedicalSchedule.this, MainActivity.class));
            }
        });
    }
}
