package com.hashem.android1_2023.Testing.EventHandling;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.hashem.android1_2023.R;

public class EventHandlingExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();

        setContentView(R.layout.activity_main2);
        EditText nameEt = findViewById(R.id.nameEt);
        EditText idEt = findViewById(R.id.idEt);
        RadioGroup genderRg = findViewById(R.id.genderRG);
        CheckBox marriedCB = findViewById(R.id.marriedCb);
        Spinner citiesSpinner = findViewById(R.id.citiesSpinner);
        TextView infoTV = findViewById(R.id.infoTv);
        Button showInfoBt = findViewById(R.id.showInfoBt);

        showInfoBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameEt.getText().toString();
                String id = idEt.getText().toString();
                String gender;
                if (genderRg.getCheckedRadioButtonId() == R.id.maleRb){
                    gender = "male";
                }else{
                    gender = "female";
                }
                String married = "Single";
                if (marriedCB.isChecked()){
                    married = "married";
                }

                String city = (String) citiesSpinner.getSelectedItem();

                infoTV.setText(name+"\n"+id+"\n"+gender+"\n"+married+"\n"+city);
            }
        });

    }
}