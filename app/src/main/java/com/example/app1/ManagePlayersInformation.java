package com.example.app1;

import android.app.DatePickerDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ManagePlayersInformation extends AppCompatActivity {
    private Spinner spinner1, spinner2;

    private int my_age;
    private List<player_info> listp= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button selectDate = findViewById(R.id.btnDate);
        addItemsOnSpinner();
        addListenerOnButton();
        addListenerOnSpinnerItemSelection();


        //date picker for born on date. interface Method
        selectDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR);
                int mMonth = c.get(Calendar.MONTH);
                int mDay = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dateDialog = new DatePickerDialog(view.getContext(), datePickerListener, mYear, mMonth, mDay);
                dateDialog.getDatePicker().setMaxDate(new Date().getTime());
                dateDialog.show();
            }
        });

    }
    //Adding Items to spinner from list
    public void addItemsOnSpinner() {

        spinner2 = (Spinner) findViewById(R.id.injury_spinner);
        List<String> list = new ArrayList<String>();
        list.add("Not Injured");
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
        Button Btn_add_player;
        Btn_add_player = (Button) findViewById(R.id.add_player);

        Btn_add_player.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                EditText temp = findViewById(R.id.player_name_input);
                String my_name= temp.getText().toString();
                temp = findViewById(R.id.player_name_input);
                float my_height= Float.parseFloat(temp.getText().toString().trim());
                String my_position = spinner1.getSelectedItem().toString();
                String my_injury = spinner2.getSelectedItem().toString();
                if(!getPlayerInfo(my_name)) {
                    newPlayer(my_name, my_height, my_age, my_position, my_injury);
                    Toast.makeText(ManagePlayersInformation.this,
                            "Player Added Successfully",
                            Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(ManagePlayersInformation.this,
                            "Player Already Exists",
                            Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker datePicker, int year, int month, int day) {
            Calendar c = Calendar.getInstance();
            c.set(Calendar.YEAR, year);
            c.set(Calendar.MONTH, month);
            c.set(Calendar.DAY_OF_MONTH, day);
            my_age = calculateAge(c.getTimeInMillis());
        }
    };
    private int calculateAge(long date){
        Calendar dob = Calendar.getInstance();
        dob.setTimeInMillis(date);
        Calendar today = Calendar.getInstance();
        int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
        if(today.get(Calendar.DAY_OF_MONTH) < dob.get(Calendar.DAY_OF_MONTH)){
            age--;
        }
        return age;
    }
    private void newPlayer(String p_name,float p_height,int p_age,String p_position,String p_injury){
        ObjectOutputStream outputStream = null;

        try {
            player_info my_player = new player_info(p_name,p_position,p_height,p_age,p_injury);
            outputStream = new ObjectOutputStream(new FileOutputStream("player_info.txt"));
            outputStream.writeObject(my_player);


        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            //Close the ObjectOutputStream
            try {
                if (outputStream != null) {
                    outputStream.flush();
                    outputStream.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
    private boolean getPlayerInfo(String name){
        List<String> list = new ArrayList<>();
        try
        {
            FileInputStream file1 = new FileInputStream("player_info.txt");
            ObjectInputStream input= new ObjectInputStream(file1);
            boolean condition = true;
            while(condition)
            {
                Object ob = input.readObject();
                if(ob != null)
                {
                    player_info exe = (player_info) ob;
                    listp.add(exe);

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
        boolean found=false;

        if(listp!= null &!listp.isEmpty())
        {
            for (player_info tre : listp) {
                found =name.equals(tre.getPlayer_info_name());
            }
        }
        return found;
    }
}
