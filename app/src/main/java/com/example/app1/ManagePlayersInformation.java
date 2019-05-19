package com.example.app1;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ManagePlayersInformation extends AppCompatActivity {
    private Spinner spinner1, spinner2;
    private Button Btn_add_player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button selectDate = findViewById(R.id.btnDate);
        TextView date = findViewById(R.id.tvSelectedDate);

        addItemsOnSpinner();
        addListenerOnButton();
        addListenerOnSpinnerItemSelection();


        //date picker for born on date
        selectDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(ManagePlayersInformation.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {

                            }
                        }, 1975, 0, 0);
                datePickerDialog.show(); }
        });

        // add items into spinner dynamically


    }
    //dynamically adding items to spinner from database
    public void addItemsOnSpinner() {

        spinner2 = (Spinner) findViewById(R.id.injury_spinner);
        List<String> list = new ArrayList<String>();
        list.add("Injury 1");
        list.add("Injury 2");
        list.add("Injury 3");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);
    }

    public void addListenerOnSpinnerItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.position_spinner);
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    public void addListenerOnButton() {
        Btn_add_player = (Button) findViewById(R.id.add_player);

        Btn_add_player.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(ManagePlayersInformation.this,
                        "Player Added Successfully",
                        Toast.LENGTH_SHORT).show();
            }

        });
    }
}

