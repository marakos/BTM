package com.example.app1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MatchStatistics extends AppCompatActivity {
    private Button Btn_AddPlayerMatchPerformance;
    private Button Btn_ExportMatchStatistics ;
    private CharSequence Toast_message,Toast_message1;
    private Spinner spinner;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_statistics);
        Spinner my_spinner0,my_spinner4;
        Toast_message = "Player Performance Succesfully added!";
        Toast_message1 = "Exporting will begin soon";
        my_spinner0 = (Spinner) findViewById(R.id.selectplayer1);
        my_spinner4 = (Spinner) findViewById(R.id.selectmatch);
        Btn_AddPlayerMatchPerformance = findViewById(R.id.AddPlayerMatchPerformance);
        Btn_AddPlayerMatchPerformance.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View view){

            }

        });

        Btn_ExportMatchStatistics = findViewById(R.id.ExportMatchStatistics);
        Btn_ExportMatchStatistics.setOnClickListener(new View.OnClickListener()
        {
            public void onClick (View view){

            }

        });

        addPlayerOnSpinner(my_spinner0,"Giorgos","Dimitris","Petros");
        addPlayerOnSpinner(my_spinner4, "Agonas 1","Agonas 2", "Agonas3");
        addListenerOnButton(Btn_AddPlayerMatchPerformance,Toast_message);
        addListenerOnButton(Btn_ExportMatchStatistics,Toast_message1);
        addListenerOnSpinnerItemSelection(my_spinner0);
    }
    public void addPlayerOnSpinner(Spinner spinner,String myListItem1,String myListItem2,String myListItem3) {
        List<String> list = new ArrayList<String>();
        list.add(myListItem1);
        list.add(myListItem2);
        list.add(myListItem3);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);
    }
    public void addListenerOnButton(Button Btn, final CharSequence Toast_Message ) {
        Btn.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                Toast.makeText(MatchStatistics.this,
                        Toast_Message,
                        Toast.LENGTH_SHORT).show();
            }

        });
    }
    public void addListenerOnSpinnerItemSelection(Spinner my_spinner) {
        my_spinner= (Spinner) findViewById(R.id.selectplayer1);
        my_spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }
}

