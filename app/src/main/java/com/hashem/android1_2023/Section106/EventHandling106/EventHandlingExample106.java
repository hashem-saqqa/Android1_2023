package com.hashem.android1_2023.Section106.EventHandling106;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ActivityMainBinding;

public class EventHandlingExample106 extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();


        binding.showInfoBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = binding.nameEt.getText().toString();
                int year = Integer.parseInt(binding.yearEt.getText().toString());
                int age = 2023 - year;

                String gender = "";
                if (binding.genderRG.getCheckedRadioButtonId() == R.id.maleRB) {
                    gender = "Man";
                } else if (binding.genderRG.getCheckedRadioButtonId() == R.id.femaleRB){
                    gender = "Woman";
                }
                String status = "Single";
                if (binding.marriedCB.isChecked()) {
                    status = "married";
                }
                String city = (String) binding.citiesSpinner.getSelectedItem();
                String info = name + "\n" + age + "\n" + gender + "\n" + status + "\n" + city;
                binding.infoTv.setText(age);
            }
        });

    }
}