package com.example.app1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class TrainingStatistics extends AppCompatActivity {
    private Spinner spinner;
    private Button AddPlayerPerformance;
    private Button ExportTrainingStatistics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.training_statistics);
        Spinner my_spinner1,my_spinner3,my_spinner2;
        my_spinner1 = (Spinner) findViewById(R.id.selectplayer2);
        my_spinner3 = (Spinner) findViewById(R.id.selectexercise);
        my_spinner2 = (Spinner) findViewById(R.id.selectplayer3);
        AddPlayerPerformance = findViewById(R.id.AddPlayerPerformance);
        AddPlayerPerformance.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View view){

            }

        });

        ExportTrainingStatistics = findViewById(R.id.ExportTrainingStatistics);
        ExportTrainingStatistics.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View view){

            }

        });

        addPlayerOnSpinner(my_spinner1,"Giorgos","Andreas","Nikiforos" );
        addPlayerOnSpinner(my_spinner3,"Exercise1", "Exercise2", "Exercise3");
        addPlayerOnSpinner(my_spinner2, "Giannis","Andreas","Giorgos");


    }
    public void addPlayerOnSpinner(Spinner spinner, String myListItem1, String myListItem2, String myListItem3) {
        List<String> list = new ArrayList<String>();
        list.add(myListItem1);
        list.add(myListItem2);
        list.add(myListItem3);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }
}


