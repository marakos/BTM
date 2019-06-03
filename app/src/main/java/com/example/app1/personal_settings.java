package com.example.app1;

import android.content.Context;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;

public class personal_settings implements Serializable {

    private String personal_name;
    private String personal_lastname;
    private String personal_email;
    private long personal_phone_number;

    public personal_settings(String name, String lastname, String email, long phone_number) {
        this.personal_name = name;
        this.personal_lastname = lastname;
        this.personal_email = email;
        this.personal_phone_number = phone_number;
    }

    public void setPersonal_name(String name) {
        this.personal_name = name;
    }

    public String getPersonal_name() {
        return this.personal_name;
    }

    public void setPersonal_lastname(String lastname) {
        this.personal_lastname = lastname;
    }

    public String getPersonal_lastname() {
        return this.personal_lastname;
    }

    public void setPersonal_email(String email) {
        this.personal_email = email;
    }

    public String getPersonal_email() {
        return this.personal_email;
    }

    public void setPersonal_phone_number(long number) {
        this.personal_phone_number = number;
    }

    public long getPersonal_phone_number() {
        return this.personal_phone_number;
    }

    public static void find() {
        Scanner input = new Scanner(System.in);
        String username = input.nextLine();
        Scanner search;
        search = new Scanner("personal_settings.txt").useDelimiter(" ");
        while (search.hasNext()) {
            final String lineFromFile = search.nextLine();
            if (lineFromFile.contains(username)) break;
            else {
                Toast check = Toast.makeText(getApplicationContext(), "Invalid input!", Toast.LENGTH_LONG);
                check.show();
            }
        }
    }

    private static Context getApplicationContext() {
        return null;
    }

    public void init1() {

        personal_settings member1 = new personal_settings("Eva", "Pot", "evapot@gmail.com", 691234567);
        member1.setPersonal_name("Eva");
        member1.setPersonal_lastname("Pot");
        member1.setPersonal_email("evapot@gmail.com");
        member1.setPersonal_phone_number(691234567);

        try {
            FileOutputStream member11 = new FileOutputStream(new File("personal_settings.txt"));
            ObjectOutputStream ps1out = new ObjectOutputStream(member11);
            ps1out.writeObject(member11);
            ps1out.close();
            member11.close();

        } catch (IOException e) {
            Context context= getApplicationContext();
            CharSequence text="error";
            int duration = Toast.LENGTH_SHORT;
            Toast toast=Toast.makeText(context,text,duration);
            toast.show();

        }

        personal_settings member2 = new personal_settings("Nick", "Pap", "nickpap@gmail.com", 699876543);
        member2.setPersonal_name("Nick");
        member2.setPersonal_lastname("Pap");
        member2.setPersonal_email("nickpap@gmail.com");
        member2.setPersonal_phone_number(699876543);

        try {
            FileOutputStream member22 = new FileOutputStream(new File("personal_settings.txt"));
            ObjectOutputStream ps2out = new ObjectOutputStream(member22);
            ps2out.writeObject(member22);
            ps2out.close();
            member22.close();

        } catch (IOException e) {
            Context context= getApplicationContext();
            CharSequence text="error";
            int duration = Toast.LENGTH_SHORT;
            Toast toast=Toast.makeText(context,text,duration);
            toast.show();

        }

    }
}
