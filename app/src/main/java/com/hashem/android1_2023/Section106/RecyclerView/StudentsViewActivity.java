package com.hashem.android1_2023.Section106.RecyclerView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ActivityStudentsView2Binding;

import java.util.ArrayList;

public class StudentsViewActivity extends AppCompatActivity {
    ActivityStudentsView2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudentsView2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1,"Ahmed",90.4,"Mobile"));
        students.add(new Student(2,"Mohammed",80,"Web"));

        StudentAdapter adapter = new StudentAdapter(this,students);

        binding.studentsRv.setAdapter(adapter);

        binding.studentsRv.setLayoutManager(new LinearLayoutManager(this,RecyclerView.VERTICAL,false));

        binding.addStudentBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                students.add(new Student(3,binding.studentNameEt.getText().toString(),70,"Mobile"));
                adapter.notifyItemInserted(students.size()-1);
            }
        });


    }
}