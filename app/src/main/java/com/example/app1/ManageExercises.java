package com.example.app1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class ManageExercises extends AppCompatActivity {

    private EditText text1,text2;
    private TextView textview, textview1;
    private Spinner spinner1,spinner2;
    private Button button,button1;
    private Button button2;
    private String katigoria;
    private int arxiko_id=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_exercises);
        text1 = findViewById(R.id.text1);
        text2= findViewById(R.id.text2);
        spinner1 = findViewById(R.id.spinner);
        spinner2=findViewById(R.id.spinner2);
        addItemsOnSpinner(spinner1);
        addItemsOnSpinner(spinner2);
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String label = text1.getText().toString();
                if (label.trim().length() > 0) {
                    Add(label, katigoria);
                }

            }
        });

        button1= findViewById(R.id.button2);
        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view)
            {
                String label = text2.getText().toString();
                if(label.trim().length()>0)
                {

                    Import(katigoria);
                }
            }

        });

        button2=findViewById(R.id.button3);
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0)
            {
                AddVideo();
            }

        });

    }

    public void addItemsOnSpinner(Spinner myspinner)
    {
        DatabaseHandler db = new DatabaseHandler(getApplicationContext());
        List<String> list = db.getAllLabels();
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspinner.setAdapter(dataAdapter);
    }

    public void OnItemSelected(AdapterView< ? > parent, View view, int thesi, long id)
    {
        String label = parent.getItemAtPosition(thesi).toString();
        Toast.makeText(parent.getContext(), label, Toast.LENGTH_LONG).show();
        katigoria=label;
    }

    public void onNothingSelected (AdapterView < ? > arg0)
    {

    }

    public void Add(String label,String katigoria)
    {
        training_exercise te = new training_exercise(katigoria,label,arxiko_id);
        te.setcategory(label);
        te.setid(arxiko_id);
        te.setonoma(label);
        arxiko_id++;
    }

    public void Import(String katigoria)
    {
        Toast.makeText(getApplicationContext(),"Upload video",Toast.LENGTH_SHORT).show();
    }

    public void AddVideo()
    {

        Toast.makeText(getApplicationContext()," Save Video ",Toast.LENGTH_SHORT).show();
    }
}
