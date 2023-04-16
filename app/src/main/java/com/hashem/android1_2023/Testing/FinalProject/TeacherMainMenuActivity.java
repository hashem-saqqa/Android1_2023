package com.hashem.android1_2023.Testing.FinalProject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ActivityTeacherMainMenuBinding;

public class TeacherMainMenuActivity extends AppCompatActivity {
    ActivityTeacherMainMenuBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTeacherMainMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.addStudentBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),AdditionFormActivity.class);
                intent.putExtra("additionType",2);
                startActivity(intent);
            }
        });
        binding.viewAllStudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ViewListOfDataActivity.class).putExtra("viewType",2));
            }
        });
        binding.addQuestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AdditionFormActivity.class).putExtra("additionType",3));
            }
        });
        binding.addExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),AdditionFormActivity.class).putExtra("additionType",4));
            }
        });

        binding.viewAllQuestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ViewListOfDataActivity.class).putExtra("viewType",3));
            }
        });
        binding.viewAllExam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),ViewListOfDataActivity.class).putExtra("viewType",4));
            }
        });


    }
}