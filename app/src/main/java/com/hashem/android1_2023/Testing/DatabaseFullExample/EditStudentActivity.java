package com.hashem.android1_2023.Testing.DatabaseFullExample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ActivityEditStudent3Binding;

public class EditStudentActivity extends AppCompatActivity {

    ActivityEditStudent3Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditStudent3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        StudentsDatabase db = new StudentsDatabase(this);

        Student student = (Student) getIntent().getExtras().get("studentData");

        binding.studentNameEt.setText(student.getName());
        binding.studentGPAEt.setText(String.valueOf(student.getGPA()));
        binding.studentFieldEt.setText(student.getField());

        binding.editBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.studentNameEt.getText().toString();
                double GPA = Double.parseDouble(binding.studentGPAEt.getText().toString());
                String field = binding.studentFieldEt.getText().toString();

                Student student1 = new Student(name, GPA, field);
                student1.setId(student.getId());

                db.updateStudent(student1);
                finish();
            }
        });

    }
}