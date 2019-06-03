package com.example.app1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;
import android.content.Context;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
public class ManageExercises extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button button1;
    private Button button2;
    private Button button3;
    private Spinner spinner1;
    private Spinner spinner2;
    EditText editt1;
    EditText editt2;
    String onoma_video;
    String tr_exercise_category;
    int exercise_id=1111;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_exercises);

        spinner1 = findViewById(R.id.spinner);
        insert_data_spinner1();
        spinner1.setOnItemSelectedListener(this);

        spinner2 = findViewById(R.id.spinner2);
        insert_data_spinner2();
        spinner2.setOnItemSelectedListener(this);

        editt1 =  findViewById(R.id.text1);

        editt2 = findViewById(R.id.text2);
        onoma_video = editt2.getText().toString();


        button1 =  findViewById(R.id.button);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Add(v);
            }
        });

        button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Import(v);
            }
        });

        button3 = findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddVideo(v);
            }
        });

    }

    public void insert_data_spinner1()
    {
        List <String> list = new ArrayList<>();
        try
        {
            BufferedReader bf = new BufferedReader(new FileReader("category.txt"));
            String line =bf.readLine();
            while(line!=null)
            {
                list.add(line);
                line=bf.readLine();

            }

        }catch(IOException e)
        {
            Context context= getApplicationContext();
            CharSequence text="error";
            int duration = Toast.LENGTH_SHORT;
            Toast toast=Toast.makeText(context,text,duration);
            toast.show();
        }

        ArrayAdapter<String> data1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        spinner1.setAdapter(data1);
    }

    public void insert_data_spinner2()
    {
        List<training_exercise>lista= new ArrayList<>();
        List<String> list = new ArrayList<>();
        try
        {
            FileInputStream file3 = new FileInputStream("exercise.txt");
            ObjectInputStream input= new ObjectInputStream(file3);
            boolean condition = true;
            while(condition)
            {
                Object ob = input.readObject();
                if(ob != null)
                {
                    training_exercise exe = (training_exercise)ob;
                    lista.add(exe);

                }else
                {
                    condition = false;
                }

            }

            input.close();
            file3.close();

        }catch(FileNotFoundException e)
        {
            Context context= getApplicationContext();
            CharSequence text="file not found";
            int duration = Toast.LENGTH_SHORT;
            Toast toast=Toast.makeText(context,text,duration);
            toast.show();
        }catch(IOException e)
        {
            Context context= getApplicationContext();
            CharSequence text="error initializing stream";
            int duration = Toast.LENGTH_SHORT;
            Toast toast=Toast.makeText(context,text,duration);
            toast.show();
        }catch(ClassNotFoundException e)
        {
            Context context= getApplicationContext();
            CharSequence text="class not found";
            int duration = Toast.LENGTH_SHORT;
            Toast toast=Toast.makeText(context,text,duration);
            toast.show();
        }

        if(lista!= null &!lista.isEmpty())
        {
            for(Iterator<training_exercise> it = lista.iterator(); it.hasNext();)
            {
                training_exercise tre=it.next();
                list.add(tre.getTrainingExerciseCategory());
            }
        }

        ArrayAdapter<String> data1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        spinner2.setAdapter(data1);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        if(parent.getId()==R.id.spinner) {
            tr_exercise_category = parent.getItemAtPosition(position).toString();
            Toast.makeText(parent.getContext(), tr_exercise_category, Toast.LENGTH_SHORT).show();
        }else if(parent.getId()==R.id.spinner2)
        {
            String onomaas = parent.getItemAtPosition(position).toString();
            Toast.makeText(parent.getContext(), onomaas, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void Add(View v)
    {
        training_exercise training_exercise1 = new training_exercise(exercise_id,tr_exercise_category);
        training_exercise1.setTrainingExerciseCategory(tr_exercise_category);
        training_exercise1.setid(exercise_id);
        exercise_id++;
        if(!getTrainingExerciseCategory(tr_exercise_category)) {
            try {

                FileOutputStream file1 = new FileOutputStream(new File("exersice.txt"));
                ObjectOutputStream object = new ObjectOutputStream(file1);
                object.writeObject(training_exercise1);
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
        }else
        {

        }


    }

    public void Import(View v)
    {
        Context context= getApplicationContext();
        CharSequence text="Load video file";
        int duration = Toast.LENGTH_SHORT;
        Toast toast=Toast.makeText(context,text,duration);
        toast.show();
    }

    public void AddVideo(View v)
    {
        Context context= getApplicationContext();
        CharSequence text="Save video file";
        int duration = Toast.LENGTH_SHORT;
        Toast toast=Toast.makeText(context,text,duration);
        toast.show();
    }

    private boolean getTrainingExerciseCategory(String tr_exercise_category)
    {
        List<training_exercise> lista = new ArrayList<>();
        try
        {
            FileInputStream file3 = new FileInputStream("exercise.txt");
            ObjectInputStream input= new ObjectInputStream(file3);
            boolean condition = true;
            while(condition)
            {
                Object ob = input.readObject();
                if(ob != null)
                {
                    training_exercise exe = (training_exercise)ob;
                    lista.add(exe);

                }else
                {
                    condition = false;
                }

            }

            input.close();
            file3.close();

        }catch(FileNotFoundException e)
        {
            Context context= getApplicationContext();
            CharSequence text="file not found";
            int duration = Toast.LENGTH_SHORT;
            Toast toast=Toast.makeText(context,text,duration);
            toast.show();
        }catch(IOException e)
        {
            Context context= getApplicationContext();
            CharSequence text="error initializing stream";
            int duration = Toast.LENGTH_SHORT;
            Toast toast=Toast.makeText(context,text,duration);
            toast.show();
        }catch(ClassNotFoundException e)
        {
            Context context= getApplicationContext();
            CharSequence text="class not found";
            int duration = Toast.LENGTH_SHORT;
            Toast toast=Toast.makeText(context,text,duration);
            toast.show();
        }

        boolean found=false;

        if(lista!=null&!lista.isEmpty())
        {
            for(training_exercise tre :lista)
            {
                if(tre.getTrainingExerciseCategory().equals(tr_exercise_category))
                {
                    found=true;
                    break;
                }
            }

        }

        return found;
    }
}
