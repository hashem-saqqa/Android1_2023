package com.hashem.android1_2023.Section101.EventHandling101;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ActivityEvantHandlingExample101Binding;

public class EventHandlingExample101 extends AppCompatActivity {

    ActivityEvantHandlingExample101Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEvantHandlingExample101Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();



        binding.infoTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.infoTv.setTextColor(Color.RED);
            }
        });

        binding.showInfoBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = binding.nameEt.getText().toString();
                int year = Integer.parseInt(binding.yearEt.getText().toString());
                int age = 2023-year;
                String gender = "";
                if (binding.genderRg.getCheckedRadioButtonId() == R.id.maleRB) {
                    gender = "Man";
                } else if (binding.genderRg.getCheckedRadioButtonId() == R.id.femaleRB) {
                    gender = "woman";
                }
                String status = "single";
                if (binding.marriedCB.isChecked()) {
                    status = "married";
                }

                String city = (String) binding.citiesSpinner.getSelectedItem();

                String c = name + "\n" + age + "\n" + gender + "\n" + status + "\n" + city;
                binding.infoTv.setText(age);

            }
        });


    }
}