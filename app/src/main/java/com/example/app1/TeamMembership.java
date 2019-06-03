package com.example.app1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.widget.CheckBox;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TeamMembership extends AppCompatActivity implements Serializable {

    private Button BuyLicense1;
    private Button BuyLicense2;
    private Button BuyLicense3;
    private Button BuyLicense4;
    private Button GetHelpForFeatures;
    private CheckBox checkBox1;
    private CheckBox checkBox2;
    private CheckBox checkBox3;
    private CheckBox checkBox4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.team_membership);

        final Button BuyLicense1 = findViewById(R.id.buy_license1);
        BuyLicense1.setOnClickListener(new View.OnClickListener() {public void onClick(View view){
            if(BuyLicense1.isActivated()){
                Toast my_toast2 = Toast.makeText(getApplicationContext(), "Redirection to an External System", Toast.LENGTH_LONG);
                my_toast2.show();}}} );

        final Button BuyLicense2 = findViewById(R.id.buy_license2);
        BuyLicense2.setOnClickListener(new View.OnClickListener() {public void onClick(View view){
            if(BuyLicense2.isActivated()){
                Toast my_toast3 = Toast.makeText(getApplicationContext(), "Redirection to an External System", Toast.LENGTH_LONG);
                my_toast3.show();}}} );

        final Button BuyLicense3 = findViewById(R.id.buy_license3);
        BuyLicense3.setOnClickListener(new View.OnClickListener() {public void onClick(View view){
            if(BuyLicense3.isActivated()){
                Toast my_toast4 = Toast.makeText(getApplicationContext(), "Redirection to an External System", Toast.LENGTH_LONG);
                my_toast4.show();}}} );

        final Button BuyLicense4 = findViewById(R.id.buy_license4);
        BuyLicense4.setOnClickListener(new View.OnClickListener() {public void onClick(View view){
            if(BuyLicense4.isActivated()){
                Toast my_toast5 = Toast.makeText(getApplicationContext(), "Redirection to an External System", Toast.LENGTH_LONG);
                my_toast5.show();}}} );

        final Button GetHelpForFeatures = findViewById(R.id.get_help_for_features);
        GetHelpForFeatures.setOnClickListener(new View.OnClickListener() {public void onClick(View view){
            activateFeatures();
            if(GetHelpForFeatures.isActivated()){
                Toast my_toast6 = Toast.makeText(getApplicationContext(), "Tutorials of Features", Toast.LENGTH_LONG);
                my_toast6.show();}}} );

        String membership = selectMembership();

    }

    public String selectMembership(){

        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox1.isChecked()){
                    Toast.makeText(getApplicationContext(), "Membership Package checked",Toast.LENGTH_LONG).show();
                }
            }
        });

        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox2.isChecked()){
                    Toast.makeText(getApplicationContext(), "Membership Package checked",Toast.LENGTH_LONG).show();
                }
            }
        });

        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox3.isChecked()){
                    Toast.makeText(getApplicationContext(), "Membership Package checked",Toast.LENGTH_LONG).show();
                }
            }
        });

        checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
        checkBox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkBox4.isChecked()){
                    Toast.makeText(getApplicationContext(), "Membership Package checked",Toast.LENGTH_LONG).show();
                }
            }
        });
        return null;

    }

    //not make method of the external system
    public void setPaymentSystem(){

    }

    //not make method of the external system
    public void sendUserNameAndCost(){

    }

    //not make method of the external system
    public void getPayInfo(){

    }

    public void activateFeatures(){

        membership_package mp = new membership_package(40, 1, 'a', "Full Membership");
        mp.setPackage_price(40);
        mp.setPackage_id(1);
        mp.setPackage_feature('a');
        mp.setPackage_name("Full Membership");

        try {
            FileOutputStream mp1 = new FileOutputStream(new File("membership_package.txt"));
            ObjectOutputStream mp1out = new ObjectOutputStream(mp1);
            mp1out.writeObject(mp1);
            mp1out.close();
            mp1.close();
        }
        catch (IOException e) {
            Context context= getApplicationContext();
            CharSequence text="error";
            int duration = Toast.LENGTH_SHORT;
            Toast toast=Toast.makeText(context,text,duration);
            toast.show();
        }
    }

}
