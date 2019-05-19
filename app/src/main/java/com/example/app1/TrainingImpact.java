package com.example.app1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class TrainingImpact extends AppCompatActivity {
    private Spinner spinner;
    private Button ShowCharts;
    private Button Export;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Spinner my_spinner5;
        my_spinner5 = (Spinner) findViewById(R.id.selectplayer4);
        setContentView(R.layout.training_impact);
        ShowCharts = findViewById(R.id.ShowCharts);
        ShowCharts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

            }

        });

        Export = findViewById(R.id.Export);
        Export.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

            }

        });

        addPlayerOnSpinner(my_spinner5, "Andreas","Nikos","Petros");

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
