package com.hashem.android1_2023.Section101.RecyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ActivityStudentsView3Binding;

import java.util.ArrayList;

public class StudentsViewActivity extends AppCompatActivity {
    ActivityStudentsView3Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudentsView3Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<com.hashem.android1_2023.Section101.RecyclerView.Student> students = new ArrayList<>();
        students.add(new Student(1,"Ahmed",90.5,"Mobile"));
        students.add(new Student(2,"Mohammed",80,"Web"));

        StudentAdapter studentAdapter = new StudentAdapter(this,students);

        binding.studentRv.setAdapter(studentAdapter);
        binding.studentRv.setLayoutManager(new LinearLayoutManager(this,
                RecyclerView.VERTICAL,false));



    }
}