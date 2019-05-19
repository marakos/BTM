package com.example.app1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TeamManagement extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team_management);

        configureShowMenuButton();
        configureShowMenuButton2();
        configureShowMenuButton3();
        configureShowMenuButton4();
    }

    private void configureShowMenuButton(){
        Button button10 =(Button) findViewById(R.id.button10);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TeamManagement.this, TreatmentGenerator.class));
            }
        });
    }
    private void configureShowMenuButton2(){
        Button button9 =(Button) findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TeamManagement.this, ManageTreatments.class));
            }
        });
    }
    private void configureShowMenuButton3(){
        Button button =(Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TeamManagement.this, InjuryReport.class));
            }
        });
    }
    private void configureShowMenuButton4(){
        Button button2 =(Button) findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TeamManagement.this, MainActivity.class));
            }
        });
    }
}
