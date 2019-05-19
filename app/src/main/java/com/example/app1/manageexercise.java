package com.example.app1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.view.View;
import android.widget.Button;
import java.util.List;

public class manageexercise extends AppCompatActivity{
    EditText text1,text2;
    TextView textview, textview1;
    Spinner spinner1,spinner2;
    Button button,button1;
    Button button2;
    String katigoria,tipos_askisis;
    int arxiko_id=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manageexercise);
        textview = findViewById(R.id.textView);
        textview1 = findViewById(R.id.textView2);
        text1 = findViewById(R.id.text1);
        text2= findViewById(R.id.text2);
        spinner1 = findViewById(R.id.spinner);
        spinner2=findViewById(R.id.spinner2);
        //spinner1.setOnItemSelectedListener(this);
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

    public void OnItemSelected(AdapterView < ? > parent, View view,int thesi, long id)
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
