package com.hashem.android1_2023.Testing.FormAssignment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CompoundButton;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ActivityForm4Binding;

public class FormActivity extends AppCompatActivity {
    ActivityForm4Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityForm4Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.ageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (i == 0) {
                    binding.graduatedCb.setVisibility(View.GONE);
                    binding.workCb.setVisibility(View.GONE);
                    binding.Et1.setVisibility(View.VISIBLE);
                    binding.Et2.setVisibility(View.VISIBLE);
                    binding.Et1.setHint("Enter the name of the school");
                    binding.Et2.setHint("Enter your grade");
                } else if (i == 1) {
                    binding.graduatedCb.setVisibility(View.GONE);
                    binding.workCb.setVisibility(View.GONE);
                    binding.Et1.setVisibility(View.VISIBLE);
                    binding.Et2.setVisibility(View.VISIBLE);
                    binding.Et1.setHint("Enter the name of the university");
                    binding.Et2.setHint("Enter your Level");
                } else if (i == 2) {
                    binding.graduatedCb.setVisibility(View.VISIBLE);
                    binding.workCb.setVisibility(View.VISIBLE);
                    binding.Et1.setVisibility(View.GONE);
                    binding.Et2.setVisibility(View.GONE);
                    binding.graduatedCb.setText("Graduated");
                    binding.workCb.setText("have a work?");
                }else if(i == 3){
                    binding.Et1.setVisibility(View.GONE);
                    binding.Et2.setVisibility(View.GONE);
                    binding.graduatedCb.setVisibility(View.GONE);
                    binding.workCb.setVisibility(View.GONE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        binding.workCb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.workCb.isChecked()) {
                    binding.Et1.setVisibility(View.VISIBLE);
                    binding.Et2.setVisibility(View.VISIBLE);
                    binding.Et1.setHint("Enter the place you work in");
                    binding.Et1.setHint("Enter your Job title");
                }else{
                    binding.Et1.setVisibility(View.GONE);
                    binding.Et2.setVisibility(View.GONE);
                }
            }
        });
        binding.workCb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            }
        });



        binding.marriedCb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.marriedCb.isChecked()) {
                    binding.cb1.setVisibility(View.VISIBLE);
                    binding.cb1.setText("have children?");
                }
            }
        });
        binding.cb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (binding.cb1.isChecked()) {
                    binding.et3.setVisibility(View.VISIBLE);
                    binding.et3.setHint("Enter the number of the children");
                }
            }
        });
    }
}