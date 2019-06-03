package com.example.app1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Collections;

public class ManageTeamSchedule extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private Button button1;
    private Button button2;

    EditText text1;
    EditText text2;
    EditText text3;

    String match_date;//imerominia agona
    String gettext2;//antipalos
    String day_off_day;//imerominia ksekourasis
    String match_dif;//diskolia agona

    ImageButton imageButton2;
    ImageButton imagebutton1;

    CheckBox checkbox1;
    CheckBox checkBox2;
    CheckBox checkbox3;

    Spinner spinner1;

    int match_id=234;
    int day_off_id=1000;

    List<String> match_dif_list= new ArrayList<>();
    List<app_settings> lista_settings = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_team_schedule);

        newAppSetting();
        setDefaultAppSettings();

        text1 = findViewById(R.id.text2);
        match_date = text1.getText().toString();

        text2=findViewById(R.id.text3);
        gettext2=text2.getText().toString();

        text3=findViewById(R.id.text4);
        day_off_day=text3.getText().toString();

        match_dif_list.add("Easy");
        match_dif_list.add("Medium");
        match_dif_list.add("Hard");

        spinner_insert_data();
        spinner1= findViewById(R.id.spinner3);
        spinner1.setOnItemSelectedListener(this);

        button1= findViewById(R.id.button4);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddMatch(v);
            }
        });

        button2= findViewById(R.id.button5);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AddDayOff(v);
            }
        });

        imagebutton1=findViewById(R.id.imageButton);
        imagebutton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar_message(v);
            }
        });

        imageButton2=findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar_message(v);
            }
        });

        checkbox1=findViewById(R.id.checkBox);
        checkBox2=findViewById(R.id.checkBox2);
        checkbox3=findViewById(R.id.checkBox3);

        select_check_box();

        insert_data_listview();
    }


    public void spinner_insert_data()
    {
        ArrayAdapter data1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,match_dif_list);
        data1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(data1);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        match_dif = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), match_dif, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void AddMatch(View v)
    {
        match match1 = new match(match_id,gettext2,match_date,match_dif);
        match1.setID(match_id);
        match1.setOPP(gettext2);
        match1.setDATE(match_date);
        match1.setDIF(match_dif);
        match_id++;

        if(getMatches(match_date,gettext2)) {
            try {
                FileOutputStream file1 = new FileOutputStream(new File("matches.txt"));
                ObjectOutputStream object = new ObjectOutputStream(file1);
                object.writeObject(match1);
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
            Context context = getApplicationContext();
            CharSequence text = "mi epitrepti imerominia gia agona";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    public void AddDayOff(View v)
    {
        if(!(getDaysoff(day_off_day))) {
            day_off day1 = new day_off(day_off_id, day_off_day);
            day1.setDayId(day_off_id);
            day1.setDayOff(day_off_day);
            try {
                FileOutputStream file1 = new FileOutputStream(new File("day_off.txt"));
                ObjectOutputStream object = new ObjectOutputStream(file1);
                object.writeObject(day1);
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
            Context context = getApplicationContext();
            CharSequence text = "mi epitrepti imerominia gia ksekourasi";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }

    }

    public void select_check_box()
    {
        if(checkbox1.isChecked())
        {
            Context context= getApplicationContext();
            CharSequence text=getAppSettings(1).getSetting_feature();
            int duration = Toast.LENGTH_SHORT;
            Toast toast=Toast.makeText(context,text,duration);
            toast.show();
        }
        if(checkBox2.isChecked())
        {
            Context context= getApplicationContext();
            CharSequence text=getAppSettings(4).getSetting_feature();
            int duration = Toast.LENGTH_SHORT;
            Toast toast=Toast.makeText(context,text,duration);
            toast.show();
        }

        if(checkbox3.isChecked())
        {
            Context context= getApplicationContext();
            CharSequence text=getAppSettings(2).getSetting_feature();
            int duration = Toast.LENGTH_SHORT;
            Toast toast=Toast.makeText(context,text,duration);
            toast.show();
        }
    }

    public void insert_data_listview()
    {
        List<match>matchdates= new ArrayList<>();
        List<day_off>day_off_dates=new ArrayList<>();
        List<String>dates= new ArrayList<>();

        try
        {
            FileInputStream file3 = new FileInputStream("matches.txt");
            ObjectInputStream input= new ObjectInputStream(file3);
            boolean condition = true;
            while(condition)
            {
                Object ob = input.readObject();
                if(ob != null)
                {
                    match exe = (match) ob;
                    matchdates.add(exe);

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

        try
        {
            FileInputStream file3 = new FileInputStream("day_off.txt");
            ObjectInputStream input= new ObjectInputStream(file3);
            boolean condition = true;
            while(condition)
            {
                Object ob = input.readObject();
                if(ob != null)
                {
                    day_off exe = (day_off) ob;
                    day_off_dates.add(exe);

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

        if(matchdates!= null &!matchdates.isEmpty())
        {
            for(Iterator<match> it = matchdates.iterator(); it.hasNext();)
            {
                match tre=it.next();
                dates.add(tre.getDATE());
            }
        }

        if(day_off_dates!=null&!matchdates.isEmpty())
        {
            for(Iterator<day_off> it = day_off_dates.iterator(); it.hasNext();)
            {
                day_off tre=it.next();
                dates.add(tre.getDayOff());
            }
        }

        Collections.sort(dates);

        ArrayAdapter<String> array = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,dates);
        ListView listview=findViewById(R.id.mobile_li);
        listview.setAdapter(array);

    }

    public void calendar_message(View v)
    {
        Context context= getApplicationContext();
        CharSequence text="Calendar";
        int duration = Toast.LENGTH_SHORT;
        Toast toast=Toast.makeText(context,text,duration);
        toast.show();

    }

    public void newAppSetting()
    {
        app_settings settings1=  new app_settings("setting 1","selected setting 1");
        settings1.setSetting_name("setting 1");
        settings1.setSetting_feature("selected setting 1");
        app_settings settings2 = new app_settings("setting 2","selected setting 2");
        settings2.setSetting_name("setting 2");
        settings2.setSetting_feature("selected setting 2");
        app_settings settings3 = new app_settings("setting 3","selected setting 3");
        settings3.setSetting_name("setting 3");
        settings3.setSetting_feature("selected setting 3");

        lista_settings.add(settings1);
        lista_settings.add(settings2);
        lista_settings.add(settings3);

    }

    public void setDefaultAppSettings()
    {
        app_settings settings4 = new app_settings("setting 4","selected setting 4");
        settings4.setSetting_name("settings 4");
        settings4.setSetting_feature("selected setting 4");
        app_settings settings5 = new app_settings("setting 5","selected setting 5");
        settings5.setSetting_name("setting 5");
        settings5.setSetting_feature("selected setting 5");
        app_settings settings6 = new app_settings("setting 6","selected setting 6");
        settings6.setSetting_name("setting 6");
        settings6.setSetting_feature("selected setting 6");

        lista_settings.add(settings4);
        lista_settings.add(settings5);
        lista_settings.add(settings6);

    }

    private boolean getMatches(String match_date,String match_opp) {
        List<match> listm = new ArrayList<>();
        List<day_off> listd = new ArrayList<>();
        try {
            FileInputStream file3 = new FileInputStream("matches.txt");
            ObjectInputStream input = new ObjectInputStream(file3);
            boolean condition = true;
            while (condition) {
                Object ob = input.readObject();
                if (ob != null) {
                    match exe = (match) ob;
                    listm.add(exe);

                } else {
                    condition = false;
                }
            }

            input.close();
            file3.close();

        } catch (FileNotFoundException e) {
            Context context = getApplicationContext();
            CharSequence text = "file not found";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }catch (IOException e)
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

        try {
            FileInputStream file3 = new FileInputStream("day_off.txt");
            ObjectInputStream input = new ObjectInputStream(file3);
            boolean condition = true;
            while (condition) {
                Object ob = input.readObject();
                if (ob != null) {
                    day_off exe = (day_off) ob;
                    listd.add(exe);

                } else {
                    condition = false;
                }
            }

            input.close();
            file3.close();

        } catch (FileNotFoundException e) {
            Context context = getApplicationContext();
            CharSequence text = "file not found";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }catch (IOException e)
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
        if(listm!=null&!listm.isEmpty())
        {
            for(match tre :listm)
            {
                if(tre.getDATE().equals(match_date))
                {
                    found=true;
                    break;
                }
                if((tre.getOPP().equals(match_opp)))
                {
                    found=true;
                    break;
                }
            }

        }

        if(found==false)
        {
            if (listd != null & !listd.isEmpty()) {
                for (day_off tre : listd) {
                    if (tre.getDayOff().equals(match_date)) {
                        found = false;
                        break;
                    }

                }

            }
        }

        return found;
    }

    private boolean getDaysoff(String day_off_day)
    {
        List<day_off> listd = new ArrayList<>();
        try {
            FileInputStream file3 = new FileInputStream("day_off.txt");
            ObjectInputStream input = new ObjectInputStream(file3);
            boolean condition = true;
            while (condition) {
                Object ob = input.readObject();
                if (ob != null) {
                    day_off exe = (day_off) ob;
                    listd.add(exe);

                } else {
                    condition = false;
                }
            }

            input.close();
            file3.close();

        } catch (FileNotFoundException e) {
            Context context = getApplicationContext();
            CharSequence text = "file not found";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }catch (IOException e)
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

        List<match> listm = new ArrayList<>();
        try {
            FileInputStream file3 = new FileInputStream("matches.txt");
            ObjectInputStream input = new ObjectInputStream(file3);
            boolean condition = true;
            while (condition) {
                Object ob = input.readObject();
                if (ob != null) {
                    match exe = (match) ob;
                    listm.add(exe);

                } else {
                    condition = false;
                }
            }

            input.close();
            file3.close();

        } catch (FileNotFoundException e) {
            Context context = getApplicationContext();
            CharSequence text = "file not found";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }catch (IOException e)
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

        boolean found = false;

        if(listd!=null & !listd.isEmpty()) {

            for (day_off tre : listd)
            {
                if(tre.getDayOff().equals(day_off_day))
                {
                    found=true;
                    break;
                }

            }
        }

        if(found==false) {

            if (listm != null & !listm.isEmpty()) {
                for (match tre : listm) {
                    if (tre.getDATE().equals(day_off_day)) {
                        found = true;
                        break;
                    }

                }

            }
        }

        return found;
    }

    private app_settings getAppSettings(int index)
    {
        return lista_settings.get(index);

    }
}
