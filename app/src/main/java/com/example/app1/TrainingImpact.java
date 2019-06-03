package com.example.app1;

import android.app.DatePickerDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class TrainingImpact extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner spinner;
    private Button Btn_ShowCharts;
    private Button Btn_Export;
    private CharSequence Toast_message, Toast_message1;
    private static final String TAG = "TrainingImpact";
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;
    Spinner my_spin_selectplayer4;
    String selectedplayerfromspinner;
    List<player>lista= new ArrayList<>();
    int id2;
    int type;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.training_impact);
        mDisplayDate = (TextView) findViewById(R.id.DateFrom);
        mDisplayDate = (TextView) findViewById(R.id.DateTo);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        TrainingImpact.this,
                        android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                        mDateSetListener,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                Log.d(TAG, "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

                String date = month + "/" + day + "/" + year;
                mDisplayDate.setText(date);
            }
        };

        my_spin_selectplayer4 = (Spinner) findViewById(R.id.selectplayer4);
        insert_data_my_spin_selectplayer4();
        my_spin_selectplayer4.setOnItemSelectedListener(this);
        setContentView(R.layout.training_impact);
        Toast_message = "Show Charts Success !";
        Toast_message1 = "Exporting will begin soon";

        Btn_ShowCharts = findViewById(R.id.ShowCharts);
        Btn_ShowCharts.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ShowCharts(view);
            }

            private void ShowCharts(View view) {
                Context context = getApplicationContext();
                CharSequence text = "Chart Has Been Constructed Successfully";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
              // Create Object chart
            }

        });

        Btn_Export = findViewById(R.id.Export);
        Btn_Export.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Export(view);
            }

            private void Export(View view) {
                Context context = getApplicationContext();
                CharSequence text = "Data Has Been Exported Successfully";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            }

        });

        addListenerOnButton(Btn_ShowCharts, Toast_message);
        addListenerOnButton(Btn_Export, Toast_message1);
    }

    public void addListenerOnButton(Button Btn, final CharSequence Toast_Message) {
        Btn.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                Toast.makeText(TrainingImpact.this,
                        Toast_Message,
                        Toast.LENGTH_SHORT).show();
            }

        });

    }

    public void insert_data_my_spin_selectplayer4() {
        List<String> list = new ArrayList<>();
        try
        {
            FileInputStream file1 = new FileInputStream("selectplayer1.txt");
            ObjectInputStream input= new ObjectInputStream(file1);
            boolean condition = true;
            while(condition)
            {
                Object ob = input.readObject();
                if(ob != null)
                {
                    player exe = (player)ob;
                    lista.add(exe);

                }else
                {
                    condition = false;
                }

            }

            input.close();
            file1.close();

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
        String fullname;
        if(lista!= null &!lista.isEmpty())
        {
            for(Iterator<player> it = lista.iterator(); it.hasNext();)
            {
                player tre=it.next();
                fullname=tre.getPlayer_name() + " "+tre.getPlayer_lastname();
                list.add(fullname);
            }
        }

        ArrayAdapter<String> data1 = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        my_spin_selectplayer4.setAdapter(data1);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (parent.getId() == R.id.selectplayer4) {
            String selectplayer4 = parent.getItemAtPosition(position).toString();
            Toast.makeText(parent.getContext(), selectplayer4, Toast.LENGTH_SHORT).show();
            selectedplayerfromspinner=selectplayer4;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void getMatchStats()
    {
        List<attempts_stat>att = new ArrayList<>();
        List<num_stat> num= new ArrayList<>();
        List<String> lista12 = new ArrayList<>();
        boolean condition = false;
        String fullname;
        for(Iterator<player> it =lista.iterator(); it.hasNext();)
        {
            player tre= it.next();
            fullname=tre.getPlayer_name() + " "+tre.getPlayer_lastname();
            if(fullname.equals(selectedplayerfromspinner))
            {
                try
                {
                    FileInputStream file1 = new FileInputStream("attempts_stats.txt");
                    ObjectInputStream input= new ObjectInputStream(file1);
                    boolean condition1 = true;
                    while(condition1)
                    {
                        Object ob = input.readObject();
                        if(ob != null)
                        {
                            attempts_stat exe = (attempts_stat) ob;
                            att.add(exe);

                        }else
                        {
                            condition1 = false;
                        }

                    }

                    input.close();
                    file1.close();

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
                    FileInputStream file1 = new FileInputStream("num_stats.txt");
                    ObjectInputStream input= new ObjectInputStream(file1);
                    boolean condition2 = true;
                    while(condition2)
                    {
                        Object ob = input.readObject();
                        if(ob != null)
                        {
                            num_stat exe = (num_stat) ob;
                            num.add(exe);

                        }else
                        {
                            condition2 = false;
                        }

                    }

                    input.close();
                    file1.close();

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

                for(Iterator<attempts_stat> it1=att.iterator(); it.hasNext();)
                {
                    attempts_stat tre1=it1.next();

                    if(tre1.getPlayer_id()==tre.getPlayer_id())
                    {

                        String t1=Integer.toString(tre1.getStat_2pts_attempted());
                        String t2=Integer.toString(tre1.getStat_2pts_made());
                        String t3=Integer.toString(tre1.getStat_3pts_attempted());
                        String t4=Integer.toString(tre1.getStat_3pts_made());
                        String t5=Integer.toString(tre1.getStat_ft_attempted());
                        String t6=Integer.toString(tre1.getStat_ft_made());
                        String t7=Float.toString(tre1.getStat_2pts_per());
                        String t8=Float.toString(tre1.getStat_3pts_per());
                        String t9=Float.toHexString(tre1.getStat_ft_per());

                        lista12.add(t1);
                        lista12.add(t2);
                        lista12.add(t3);
                        lista12.add(t4);
                        lista12.add(t5);
                        lista12.add(t6);
                        lista12.add(t7);
                        lista12.add(t8);
                        lista12.add(t9);

                        break;
                    }

                }


                for(Iterator<num_stat> it12=num.iterator(); it.hasNext();)
                {
                    num_stat tre1=it12.next();

                    if(tre1.getPlayer_id()==tre.getPlayer_id())
                    {

                        String t1=Integer.toString(tre1.getStat_assists());
                        String t2=Integer.toString(tre1.getStat_blocks());
                        String t3=Integer.toString(tre1.getStat_foul());
                        String t4=Integer.toString(tre1.getStat_min());
                        String t5=Integer.toString(tre1.getStat_reb_def());
                        String t6=Integer.toString(tre1.getStat_reb_off());
                        String t7=Integer.toString(tre1.getStat_steals());
                        String t8=Integer.toString(tre1.getStat_to());

                        lista12.add(t1);
                        lista12.add(t2);
                        lista12.add(t3);
                        lista12.add(t4);
                        lista12.add(t5);
                        lista12.add(t6);
                        lista12.add(t7);
                        lista12.add(t8);

                        break;
                    }

                }

                break;

            }

        }

        ArrayAdapter<String> array = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,lista12);
        ListView listview=findViewById(R.id.aaaaaa);
        listview.setAdapter(array);


    }
    public String selectPlayer(){
        my_spin_selectplayer4.findViewById(R.id.selectplayer4);
        return String.valueOf(my_spin_selectplayer4.getSelectedItemId());
    }

}