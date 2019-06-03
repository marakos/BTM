package com.example.app1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import android.widget.Toast;
import android.content.Context;

public class help implements Serializable {

    private String help_info;

    public help(String info) {
        this.help_info = info;
    }

    public void setHelp_info(String info) {
        this.help_info = info;
    }

    public String getHelp_info() {
        return this.help_info;
    }

    private Context getApplicationContext() {
        return null;
    }

    public void init3() {

        help help = new help("help for using this app");
        help.setHelp_info("help for using this app");

        try {
            FileOutputStream help1 = new FileOutputStream(new File("help.txt"));
            ObjectOutputStream h1out = new ObjectOutputStream(help1);
            h1out.writeObject(help1);
            h1out.close();
            help1.close();

        } catch (IOException e) {
            Context context= getApplicationContext();
            CharSequence text="error";
            int duration = Toast.LENGTH_SHORT;
            Toast toast=Toast.makeText(context,text,duration);
            toast.show();

        }
    }
}

