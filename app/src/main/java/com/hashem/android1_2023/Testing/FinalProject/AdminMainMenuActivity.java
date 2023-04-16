package com.hashem.android1_2023.Testing.FinalProject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ActivityAdminMainMenuBinding;

public class AdminMainMenuActivity extends AppCompatActivity {
    ActivityAdminMainMenuBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdminMainMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.addStudentBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AdditionFormActivity.class);
                intent.putExtra("additionType",2);
                startActivity(intent);

            }
        });
        binding.addTeacherBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AdditionFormActivity.class);
                intent.putExtra("additionType",1);
                startActivity(intent);

            }
        });
        binding.viewAllStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ViewListOfDataActivity.class).putExtra("viewType",2));
            }
        });
        binding.viewAllTeachers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ViewListOfDataActivity.class).putExtra("viewType",1));
            }
        });


    }
}