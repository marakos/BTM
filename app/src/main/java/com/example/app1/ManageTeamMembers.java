package com.example.app1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import android.content.Context;


public class ManageTeamMembers extends AppCompatActivity implements Serializable, AdapterView.OnItemSelectedListener {

    private Spinner spinner_role;
    private Button AddMember;
    private CheckBox checkBox5;
    private CheckBox checkBox6;
    private CheckBox checkBox7;
    private CheckBox checkBox8;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.manage_team_members);

        String role = selectRole();

        textView = (TextView) findViewById(R.id.files);
        textView.setMovementMethod(new ScrollingMovementMethod());

        AddMember = findViewById(R.id.add_member);
        AddMember.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                verifyMembership();
                attachMembership();
                if(AddMember.isActivated()) {

                    staff_user su = new staff_user(1, 1,"a1b2c3d4","Staff", true);
                    su.getUser_id();
                    su.getUser_team_id();
                    su.getUser_password();
                    su.getStaff_role();
                    su.getStaff_access();
                    try {
                        FileInputStream file1 = new FileInputStream("user.txt");
                        ObjectInputStream su1in = new ObjectInputStream(file1);
                        su1in.close();
                        file1.close();
                    }
                    catch(IOException e)
                    {
                        Context context= getApplicationContext();
                        CharSequence text="error";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast=Toast.makeText(context,text,duration);
                        toast.show();
                    }

                    player_user pu = new player_user(2, 1, "d4c3b2a1", "Player", true);
                    pu.getUser_id();
                    pu.getUser_team_id();
                    pu.getUser_password();
                    pu.getPlayer_role();
                    pu.getPlayer_access();
                    try {
                        FileInputStream file2 = new FileInputStream("personal_settings.txt");
                        ObjectInputStream pu2in = new ObjectInputStream(file2);
                        pu2in.close();
                        file2.close();
                    }
                    catch(IOException e)
                    {
                        Context context= getApplicationContext();
                        CharSequence text="error";
                        int duration = Toast.LENGTH_SHORT;
                        Toast toast=Toast.makeText(context,text,duration);
                        toast.show();
                    }

                }
                else{
                    Toast my_toast = Toast.makeText(getApplicationContext(), "Duplicate Record!", Toast.LENGTH_LONG);
                    my_toast.show();
                }
            }
        });

        String delmemb = deleteMember();

    }

    @Override
    public void onItemSelected (AdapterView < ? > parent, View view,int position, long id){
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected (AdapterView < ? > parent){
        Toast my_toast1 = Toast.makeText(getApplicationContext(), "Role not selected!", Toast.LENGTH_LONG);
        my_toast1.show();
    }

    public void getUser() {
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            char input = (char)in.read();
        }
        catch (IOException e) {
            Context context= getApplicationContext();
            CharSequence text="error";
            int duration = Toast.LENGTH_SHORT;
            Toast toast=Toast.makeText(context,text,duration);
            toast.show();
        }
        personal_settings.find();
    }

    public void attachMembership() {

        shared_license shared_license = new shared_license(1, "team license");
        shared_license.setShared_license_id(1);
        shared_license.setShared_license_info("team license");

        try {
            FileOutputStream  shared_license1 = new FileOutputStream(new File("shared_license.txt"));
            ObjectOutputStream sl1out = new ObjectOutputStream(shared_license1);
            sl1out.writeObject(shared_license1);
            sl1out.close();
            shared_license1.close();
        }
        catch (IOException e) {
            Context context= getApplicationContext();
            CharSequence text="error";
            int duration = Toast.LENGTH_SHORT;
            Toast toast=Toast.makeText(context,text,duration);
            toast.show();
        }
    }

    public String selectRole(){

        spinner_role = findViewById(R.id.spinner_select_role);
        ArrayAdapter<CharSequence> my_adapter = ArrayAdapter.createFromResource(this, R.array.role, android.R.layout.simple_spinner_item);
        my_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_role.setAdapter(my_adapter);
        spinner_role.setOnItemSelectedListener(this);

        return null;
    }
    //the check was made in the spinner and in the button
    public void check(){

    }

    public void verifyMembership() {

        membership membership = new membership(1, "1/1/2019", "1/2/2019");
        membership.setMembership_id(1);
        membership.setMembership_start("1/1/2019");
        membership.setMembership_end("1/2/2019");

        try {
            FileOutputStream  membership1 = new FileOutputStream(new File("membership.txt"));
            ObjectOutputStream m1out = new ObjectOutputStream(membership1);
            m1out.writeObject(membership1);
            m1out.close();
            membership1.close();
        }
        catch (IOException e){
            Context context= getApplicationContext();
            CharSequence text="error";
            int duration = Toast.LENGTH_SHORT;
            Toast toast=Toast.makeText(context,text,duration);
            toast.show();
        }
    }

    public String deleteMember(){

        checkBox5 = (CheckBox) findViewById(R.id.delete_member1);
        checkBox5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox5.isChecked()){
                    Toast.makeText(getApplicationContext(), "Delete Member 1",Toast.LENGTH_LONG).show();
                }
            }
        });

        checkBox6 = (CheckBox) findViewById(R.id.delete_member2);
        checkBox6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox6.isChecked()){
                    Toast.makeText(getApplicationContext(), "Delete Member 2",Toast.LENGTH_LONG).show();
                }
            }
        });

        checkBox7 = (CheckBox) findViewById(R.id.delete_member3);
        checkBox7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox7.isChecked()){
                    Toast.makeText(getApplicationContext(), "Delete Member 3",Toast.LENGTH_LONG).show();
                }
            }
        });

        checkBox8 = (CheckBox) findViewById(R.id.delete_member4);
        checkBox8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox8.isChecked()){
                    Toast.makeText(getApplicationContext(), "Delete Member 4",Toast.LENGTH_LONG).show();
                }
            }
        });

        return null;
    }
}