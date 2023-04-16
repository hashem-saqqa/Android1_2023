package com.hashem.android1_2023.Testing.FinalProject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.util.Log;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ActivityViewListOfDataBinding;

import java.util.ArrayList;

public class ViewListOfDataActivity extends AppCompatActivity {
    ActivityViewListOfDataBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewListOfDataBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        MyDataBase db = new MyDataBase(this);

        int viewType = getIntent().getIntExtra("viewType",-1);

        if (viewType == 1){
            ArrayList<User> teachers =  db.getAllTeachers();
            TeacherAdapter adapter = new TeacherAdapter(teachers);
            binding.rv1.setLayoutManager(new LinearLayoutManager(ViewListOfDataActivity.this));
            binding.rv1.setAdapter(adapter);
        }else if (viewType == 2){
            ArrayList<User> students =  db.getAllStudents();
            StudentAdapter adapter = new StudentAdapter(students);
            binding.rv1.setLayoutManager(new LinearLayoutManager(ViewListOfDataActivity.this));
            binding.rv1.setAdapter(adapter);
        }
        else if (viewType == 3){
            ArrayList<Question> questions =  db.getAllQuestions();
            QuestionAdapter adapter = new QuestionAdapter(questions);
            binding.rv1.setLayoutManager(new LinearLayoutManager(ViewListOfDataActivity.this));
            binding.rv1.setAdapter(adapter);
        }
        else if (viewType == 4){
            ArrayList<Exam> exams =  db.getAllExams();
            ExamAdapter adapter = new ExamAdapter(exams);
            binding.rv1.setLayoutManager(new LinearLayoutManager(ViewListOfDataActivity.this));
            binding.rv1.setAdapter(adapter);
        }

    }
}