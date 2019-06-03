package com.example.app1;
import java.lang.*;

import android.content.Context;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.IOException;

public abstract class user implements Serializable {

    protected int user_id;
    protected int user_team_id;
    protected String user_password;

    public user(int id, int team_id, String password){
        this.user_id = id;
        this.user_team_id = team_id;
        this.user_password = password;
    }

    public void setUser_id(int id) {
        this.user_id = id;
    }

    public int getUser_id() {
        return this.user_id;
    }

    public void setUser_team_id(int team_id) {
        this.user_team_id = team_id;
    }

    public int getUser_team_id() {
        return this.user_team_id;
    }

    public void setUser_password(String password) {
        this.user_password = password;
    }

    public String getUser_password() {
        return this.user_password;
    }

    private Context getApplicationContext() {
        return null;
    }

    public void init2() {

        staff_user su = new staff_user(1, 1,"a1b2c3d4","Staff", true);
        su.setUser_id(1);
        su.setUser_team_id(1);
        su.setUser_password("a1b2c3d4");
        su.setStaff_role("Staff");
        su.setStaff_access(true);

        try {
            FileOutputStream su1 = new FileOutputStream(new File("user.txt"));
            ObjectOutputStream su1out = new ObjectOutputStream(su1);
            su1out.writeObject(su1);
            su1out.close();
            su1.close();

        } catch (IOException e) {
            Context context= getApplicationContext();
            CharSequence text="error";
            int duration = Toast.LENGTH_SHORT;
            Toast toast=Toast.makeText(context,text,duration);
            toast.show();

        }

        player_user pu = new player_user(2, 1, "d4c3b2a1", "Player", true);
        pu.setUser_id(2);
        pu.setUser_team_id(1);
        pu.setUser_password("d4c3b2a1");
        pu.setPlayer_role("Player");
        pu.setPlayer_access(true);

        try {
            FileOutputStream pu2 = new FileOutputStream(new File("user.txt"));
            ObjectOutputStream pu2out = new ObjectOutputStream(pu2);
            pu2out.writeObject(pu2);
            pu2out.close();
            pu2.close();

        } catch (IOException e) {
            Context context= getApplicationContext();
            CharSequence text="error";
            int duration = Toast.LENGTH_SHORT;
            Toast toast=Toast.makeText(context,text,duration);
            toast.show();

        }

    }

}
