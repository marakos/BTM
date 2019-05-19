package com.example.app1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class SetTeamStandards extends AppCompatActivity {

    private Button Btn_add_standard;
    private boolean DataIsOk=Boolean.FALSE;
    private CharSequence Toast_message;
    private Spinner my_spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.set_team_standards);
        //VerifyData(DataAreOk);
        addListenerOnSpinnerItemSelection();
        addListenerOnButton();

    }
    public void addListenerOnButton() {
        Btn_add_standard= (Button) findViewById(R.id.add_standard);
        if (DataIsOk){
            Toast_message = "Standard Added Successfully";}
        else{
            Toast_message = "Bad Input";
        }
        Btn_add_standard.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                Toast.makeText(SetTeamStandards.this,
                        Toast_message,
                        Toast.LENGTH_SHORT).show();
            }

        });
    }
    // public boolean
    public void addListenerOnSpinnerItemSelection() {
        my_spinner = (Spinner) findViewById(R.id.position_spinner);
        my_spinner.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }
}
