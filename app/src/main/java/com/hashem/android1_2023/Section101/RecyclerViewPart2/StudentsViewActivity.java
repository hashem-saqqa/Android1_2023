package com.hashem.android1_2023.Section101.RecyclerViewPart2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ActivityStudentsView4Binding;

import java.util.ArrayList;

public class StudentsViewActivity extends AppCompatActivity implements StudentListener{
    ActivityStudentsView4Binding binding;
    ArrayList<Student> students;
    StudentAdapter adapter;

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getData()!= null && result.getResultCode() == 101){
                        String newName = result.getData().getStringExtra("newStudentName");
                        int position  = result.getData().getIntExtra("position",-1);

                        students.get(position).setName(newName);
                        adapter.notifyItemChanged(position);

                    }
                }
            }
    );
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudentsView4Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

         students = new ArrayList<>();
        students.add(new Student(1,"Ahmed",92,"Mobile"));
        students.add(new Student(2,"Mohammed",70,"Web"));


         adapter = new StudentAdapter(students,this);

        binding.studentsRv.setAdapter(adapter);

        binding.studentsRv.setLayoutManager(new LinearLayoutManager(this,
                RecyclerView.VERTICAL,false));

        binding.addBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                students.add(new Student(3,binding.studentNameEt.getText().toString()
                        ,90,"Mobile"));
                adapter.notifyItemInserted(students.size()-1);
            }
        });

    }

    @Override
    public void onDelete(int pos) {
        students.remove(pos);
        adapter.notifyItemRemoved(pos);
    }

    @Override
    public void onEdit(int pos) {
        Intent intent = new Intent(this,EditStudentActivity.class);
        intent.putExtra("studentName",students.get(pos).getName());
        intent.putExtra("position",pos);
        launcher.launch(intent);

    }
}