package com.example.app1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;




public class TrainingStatistics extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner my_spin_selectplayer2;
    private Spinner my_spin_selectplayer3;
    private Spinner my_spin_selectexercise;
    private Button Btn_AddPlayerPerformance;
    private Button Btn_ExportTrainingStatistics;
    private CharSequence Toast_message, Toast_message1;
    private String value;
    EditText Inputvalue;
    String value1;
    int id1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.training_statistics);
        Spinner my_spin_selectplayer2, my_spin_selectexercise, my_spin_selectplayer3;
        my_spin_selectplayer2 = (Spinner) findViewById(R.id.selectplayer2);
        insert_data_my_spin_selectplayer2();
        my_spin_selectplayer2.setOnItemSelectedListener(this);
        my_spin_selectexercise = (Spinner) findViewById(R.id.selectexercise);
        insert_data_my_spin_selectexercise();
        my_spin_selectexercise.setOnItemSelectedListener(this);
        my_spin_selectplayer3 = (Spinner) findViewById(R.id.selectplayer3);
        insert_data_my_spin_selectplayer3();
        my_spin_selectplayer3.setOnItemSelectedListener(this);
        Toast_message = "Player Performance Succesfully Added!";
        Toast_message1 = "Exporting will begin soon";
        Inputvalue = (EditText) findViewById(R.id.InputValue);
        Btn_AddPlayerPerformance = findViewById(R.id.AddPlayerPerformance);
        Btn_AddPlayerPerformance.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                value = Inputvalue.getText().toString();
                newTrainingStats(view);
            }

            private void newTrainingStats(View view) {
                com.example.app1.training_info training_info1 = new com.example.app1.training_info(value1);
                training_info1 = training_info1.setTraining_value(value1);

                com.example.app1.training_info training_info2=new com.example.app1.training_info(id1);
                training_info2= training_info2.setTraining_id(id1);

            }

        });

        Btn_ExportTrainingStatistics = findViewById(R.id.ExportTrainingStatistics);
        Btn_ExportTrainingStatistics.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                ExportTrainingStatistics(view);
            }

            private void ExportTrainingStatistics(View view) {
                Context context = getApplicationContext();
                CharSequence text = "Training Statistics Has Been Exported Successfully";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }

        });


        addListenerOnButton(Btn_AddPlayerPerformance, Toast_message);
        addListenerOnButton(Btn_ExportTrainingStatistics, Toast_message1);
        addListenerOnSpinnerItemSelection(my_spin_selectplayer2);
        addListenerOnSpinnerItemSelection(my_spin_selectexercise);
        addListenerOnSpinnerItemSelection(my_spin_selectplayer3);

    }


    public void addListenerOnButton(Button Btn, final CharSequence Toast_Message) {
        Btn.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                Toast.makeText(TrainingStatistics.this,
                        Toast_Message,
                        Toast.LENGTH_SHORT).show();
            }

        });

    }

    public void addListenerOnSpinnerItemSelection(Spinner my_spinner) {
        my_spinner = (Spinner) findViewById(R.id.selectplayer1);
        my_spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    public void insert_data_my_spin_selectplayer2() {
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
        my_spin_selectplayer2.setAdapter(data1);

    }

    private void insert_data_my_spin_selectplayer3() {
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
        my_spin_selectplayer3.setAdapter(data1);

    }

    private void insert_data_my_spin_selectexercise() {
        List<String> list = new ArrayList<>();
        try {
            BufferedReader bf = new BufferedReader(new FileReader("selectexercise.txt"));
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
        my_spin_selectexercise.setAdapter(data1);

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.selectplayer2) {
            String selectplayer2 = parent.getItemAtPosition(position).toString();
            Toast.makeText(parent.getContext(), selectplayer2, Toast.LENGTH_SHORT).show();
        } else if (parent.getId() == R.id.selectexercise) {
            String selectexercise = parent.getItemAtPosition(position).toString();
            Toast.makeText(parent.getContext(), selectexercise, Toast.LENGTH_SHORT).show();
        } else if (parent.getId() == R.id.selectplayer3) {
            String selectplayer3 = parent.getItemAtPosition(position).toString();
            Toast.makeText(parent.getContext(), selectplayer3, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public String selectPlayer(){
        my_spin_selectplayer2.findViewById(R.id.selectplayer2);
        return String.valueOf(my_spin_selectplayer2.getSelectedItemId());
    }

    public  String selectExercise(){
        my_spin_selectexercise.findViewById(R.id.selectexercise);
        return String.valueOf(my_spin_selectexercise.getSelectedItemId());
    }
    public String selectPlayer1(){
        my_spin_selectplayer3.findViewById(R.id.selectplayer3);
        return String.valueOf(my_spin_selectplayer3.getSelectedItemId());
    }
}

