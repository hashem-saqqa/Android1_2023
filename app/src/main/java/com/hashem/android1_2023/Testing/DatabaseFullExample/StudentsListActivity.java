package com.hashem.android1_2023.Testing.DatabaseFullExample;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ActivityStudentsListBinding;

import java.util.ArrayList;

public class StudentsListActivity extends AppCompatActivity implements StudentListener {

    ActivityStudentsListBinding binding;
    StudentsDatabase db;
    ArrayList<Student> students;
    StudentsAdapter adapter;
    ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    students = db.getAllStudents();
                    notifyChanges();

                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudentsListBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        db = new StudentsDatabase(this);
        db.insertStudent(new Student("Ahmed",90,"Mobile"));
        db.insertStudent(new Student("Mohammed",80.6,"Web"));
        db.insertStudent(new Student("Anas",88.5,"Mobile"));

        students = db.getAllStudents();

        adapter = new StudentsAdapter(students, this);
        binding.studentsRv.setAdapter(adapter);
        binding.studentsRv.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    public void onItemClick(int pos) {

    }

    @Override
    public void onEdit(int id, int pos) {
        Intent intent = new Intent(getApplicationContext(), EditStudentActivity.class);
        intent.putExtra("studentData", students.get(pos));
        launcher.launch(intent);

    }

    @Override
    public void onDelete(int id, int pos) {
        db.deleteStudent(id);
        students = db.getAllStudents();
        notifyChanges();
//        students.remove(pos);
//        adapter.notifyItemRemoved(pos);
//        adapter.notifyItemRangeChanged(pos, students.size());


    }
    public void notifyChanges(){
        adapter = new StudentsAdapter(students, StudentsListActivity.this);
        binding.studentsRv.setAdapter(adapter);
    }
}