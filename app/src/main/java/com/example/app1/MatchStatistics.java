package com.example.app1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.content.Context;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;



public class MatchStatistics extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Button Btn_AddPlayerMatchPerformance;
    private Button Btn_ExportMatchStatistics;
    private CharSequence Toast_message, Toast_message1;
    private Spinner my_spin_selectplayer1;
    private Spinner my_spin_selectmatch;

    int player;
    int id;
    EditText edit1;
    EditText edit2;
    EditText edit3;
    EditText edit4;
    EditText edit5;
    EditText edit6;
    EditText edit7;
    EditText edit8;
    EditText edit9;
    EditText edit10;
    EditText edit11;
    EditText edit12;
    EditText edit13;
    EditText edit14;
    EditText edit15;
    EditText edit16;
    EditText edit17;

    String ft_attempted, ft_made, twopts_att, threepts_att, twopts_made, threepts_made, ft_per, twopts_per, threepts_per;
    String reb_off, reb_def, steals, assists, to, blocks, foul, min;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.match_statistics);
        Spinner my_spin_selectplayer1, my_spin_selectmatch;
        Toast_message = "Player Match Performance Succesfully added!";
        Toast_message1 = "Exporting will begin soon";

        edit1 = findViewById(R.id.ft_attempted);
        ft_attempted = edit1.getText().toString();

        edit2 = findViewById(R.id.ft_made);
        ft_made = edit2.getText().toString();

        edit3 = findViewById(R.id.twopts_att);
        twopts_att = edit3.getText().toString();

        edit4 = findViewById(R.id.threepts_att);
        threepts_att = edit4.getText().toString();

        edit5 = findViewById(R.id.twopts_made);
        twopts_made = edit5.getText().toString();

        edit6 = findViewById(R.id.threepts_made);
        threepts_made = edit6.getText().toString();

        edit7 = findViewById(R.id.ft_per);
        ft_per = edit7.getText().toString();

        edit8 = findViewById(R.id.twopts_per);
        twopts_per = edit8.getText().toString();

        edit9 = findViewById(R.id.threepts_per);
        threepts_per = edit9.getText().toString();

        edit10 = findViewById(R.id.reb_off);
        reb_off = edit10.getText().toString();

        edit11 = findViewById(R.id.reb_def);
        reb_def = edit11.getText().toString();

        edit12 = findViewById(R.id.steals);
        steals = edit12.getText().toString();

        edit13 = findViewById(R.id.assists);
        assists = edit13.getText().toString();

        edit14 = findViewById(R.id.to);
        to = edit14.getText().toString();

        edit15 = findViewById(R.id.blocks);
        blocks = edit15.getText().toString();

        edit16 = findViewById(R.id.foul);
        foul = edit16.getText().toString();

        edit17 = findViewById(R.id.min);
        min = edit17.getText().toString();

        my_spin_selectplayer1 = (Spinner) findViewById(R.id.selectplayer1);
        insert_data_my_spin_selectplayer1();
        my_spin_selectplayer1.setOnItemSelectedListener(this);
        my_spin_selectmatch = (Spinner) findViewById(R.id.selectmatch);
        my_spin_selectmatch.setOnItemSelectedListener(this);
        insert_data_my_spin_selectmatch();
        Btn_AddPlayerMatchPerformance = findViewById(R.id.AddPlayerMatchPerformance);
        Btn_AddPlayerMatchPerformance.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                NewMatchStats(view);
            }

        });

        Btn_ExportMatchStatistics = findViewById(R.id.ExportMatchStatistics);
        Btn_ExportMatchStatistics.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ExportMatchStatistics(view);
            }

        });

        addListenerOnButton(Btn_AddPlayerMatchPerformance, Toast_message);
        addListenerOnButton(Btn_ExportMatchStatistics, Toast_message1);
        addListenerOnSpinnerItemSelection(my_spin_selectplayer1);
        addListenerOnSpinnerItemSelection(my_spin_selectmatch);
    }

    private void insert_data_my_spin_selectmatch() {
        List<String> list = new ArrayList<>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader("selectmatch.txt"));
            String line = bf.readLine();
            while (line != null) {
                list.add(line);
                line = bf.readLine();

            }


        } catch (IOException e) {
            Context context = getApplicationContext();
            CharSequence text = "error";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        ArrayAdapter<String> data1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        my_spin_selectmatch.setAdapter(data1);
    }

    private void insert_data_my_spin_selectplayer1() {
        List<String> list = new ArrayList<>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader("selectplayer1.txt"));
            String line = bf.readLine();
            while (line != null) {
                list.add(line);
                line = bf.readLine();

            }


        } catch (IOException e) {
            Context context = getApplicationContext();
            CharSequence text = "error";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
        ArrayAdapter<String> data1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        my_spin_selectplayer1.setAdapter(data1);
    }


    public void addListenerOnButton(Button Btn, final CharSequence Toast_Message) {
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
        my_spinner = (Spinner) findViewById(R.id.selectplayer1);
        my_spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.selectplayer1) {
            String selectplayer1 = parent.getItemAtPosition(position).toString();
            Toast.makeText(parent.getContext(), selectplayer1, Toast.LENGTH_SHORT).show();
        } else if (parent.getId() == R.id.selectmatch) {
            String selectmatch = parent.getItemAtPosition(position).toString();
            Toast.makeText(parent.getContext(), selectmatch, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


    public void NewMatchStats(View view) {

        match_stats match_stats1 = new match_stats(id);
        match_stats1 = match_stats1.setStat_id;
        player++;

        try {

            FileOutputStream file1 = new FileOutputStream(new File("selectplayer1.txt"));
            ObjectOutputStream object = new ObjectOutputStream(file1);
            object.writeObject(my_spin_selectplayer1);
            object.close();
            file1.close();

        } catch (FileNotFoundException e) {
            Context context = getApplicationContext();
            CharSequence text = "file not found";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } catch (IOException e) {
            Context context = getApplicationContext();
            CharSequence text = "error initializing stream";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

    }

    public void ExportMatchStatistics(View view) {
        Context context = getApplicationContext();
        CharSequence text = "Match Statistics Has Been Exported Successfully";
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
    }

    public String selectPlayer(){

        my_spin_selectplayer1.findViewById(R.id.selectplayer1);
        return String.valueOf(my_spin_selectplayer1.getSelectedItemId());
    }

    public  String selectMatch(){
        my_spin_selectmatch.findViewById(R.id.selectmatch);
        return String.valueOf(my_spin_selectmatch.getSelectedItemId());
    }
}