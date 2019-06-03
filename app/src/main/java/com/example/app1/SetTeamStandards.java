package com.example.app1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SetTeamStandards extends AppCompatActivity {
    private CharSequence Toast_message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_team_standards);
        addListenerOnSpinnerItemSelection();
        addListenerOnButton();

    }
    public void addListenerOnButton(){

        Button Btn_add_standard;
        Btn_add_standard= (Button) findViewById(R.id.add_standard);
        Btn_add_standard.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                boolean Validation;
                String my_position = selectPosition();
                float[] input = new float[12];
                EditText temp = (EditText) findViewById(R.id.sts1);
                input[0]=  Float.parseFloat(temp.getText().toString().trim());
                temp = (EditText) findViewById(R.id.sts2);
                input[1]=  Float.parseFloat(temp.getText().toString().trim());
                temp = (EditText) findViewById(R.id.sts3);
                input[2]=  Float.parseFloat(temp.getText().toString().trim());
                temp = (EditText) findViewById(R.id.sts4);
                input[3]=  Float.parseFloat(temp.getText().toString().trim());
                temp = (EditText) findViewById(R.id.sts5);
                input[4]=  Float.parseFloat(temp.getText().toString().trim());
                temp = (EditText) findViewById(R.id.sts6);
                input[5]=  Float.parseFloat(temp.getText().toString().trim());
                temp = (EditText) findViewById(R.id.sts7);
                input[6]=  Float.parseFloat(temp.getText().toString().trim());
                temp = (EditText) findViewById(R.id.sts8);
                input[7]=  Float.parseFloat(temp.getText().toString().trim());
                temp = (EditText) findViewById(R.id.sts9);
                input[8]=  Float.parseFloat(temp.getText().toString().trim());
                temp = (EditText) findViewById(R.id.sts10);
                input[9]=  Float.parseFloat(temp.getText().toString().trim());
                temp = (EditText) findViewById(R.id.sts11);
                input[10]=  Float.parseFloat(temp.getText().toString().trim());
                temp = (EditText) findViewById(R.id.sts12);
                input[11]=  Float.parseFloat(temp.getText().toString().trim());
                int j=0;

                do {
                    Validation = checkStandard(input[j]); // check only if all inputs are filled-not empty. More validation rules here but are not implemented
                    j++;
                } while (j<12 && Validation);
                if (Validation){
                    createStandard(my_position,input);
                    Toast_message = "Standard Added Successfully";
                }
                else{
                    Toast_message = "Bad Input";
                }
                Toast.makeText(SetTeamStandards.this,
                        Toast_message,
                        Toast.LENGTH_SHORT).show();
            }

        });
    }
    public void addListenerOnSpinnerItemSelection() {
        Spinner my_spinner;
        my_spinner = (Spinner) findViewById(R.id.position_spinner);
        my_spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    public void createStandard(String pos, float[] in){
        ObjectOutputStream outputStream = null;

        try {
            outputStream = new ObjectOutputStream(new FileOutputStream("team_standards.txt"));
            team_standards standard = new team_standards(pos,in[0],in[1],in[2],in[3],
                    in[4],in[5],in[6],in[7],in[8],in[9],in[10],in[11]);

            outputStream.writeObject(standard);


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
    public boolean checkStandard(float myvalue){
        if (myvalue==0.0f){
            return false;
        }
        else{
            return true;
        }
    }
    public String selectPosition(){
        Spinner p_spinner = (Spinner) findViewById(R.id.position_spinner);;
        return p_spinner.getSelectedItem().toString();
    }
}