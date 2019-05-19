package com.example.app1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            configureShowMenuButton();
            configureShowMenuButton2();
            configureShowMenuButton3();
            configureShowMenuButton4();
            configureShowMenuButton5();
            configureShowMenuButton6();
            configureShowMenuButton7();
            configureShowMenuButton8();

    }


   private void configureShowMenuButton(){
        Button button =(Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TeamManagement.class));
            }
        });
    }
    private void configureShowMenuButton2(){
        Button button2 =(Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, TrainingSchedule.class));
            }
        });
    }
    private void configureShowMenuButton3(){
        Button button3 =(Button) findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PlayerStatistics.class));
            }
        });
    }
    private void configureShowMenuButton4(){
        Button button4 =(Button) findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MedicalSchedule.class));
            }
        });
    }
    private void configureShowMenuButton5(){
        Button button5 =(Button) findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AccountManagement.class));
            }
        });
    }
    private void configureShowMenuButton6(){
        Button button6 =(Button) findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, GameAnalysis.class));
            }
        });
    }
    private void configureShowMenuButton7(){
        Button button7 =(Button) findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, PlayerScouting.class));
            }
        });
    }
    private void configureShowMenuButton8(){
        Button button8 =(Button) findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });
    }
}
