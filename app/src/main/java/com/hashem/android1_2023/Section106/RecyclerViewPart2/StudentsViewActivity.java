package com.hashem.android1_2023.Section106.RecyclerViewPart2;

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
import com.hashem.android1_2023.databinding.ActivityStudentsView5Binding;

import java.util.ArrayList;

public class StudentsViewActivity extends AppCompatActivity implements StudentListener{
    ActivityStudentsView5Binding binding;
    ArrayList<Student> students;
    StudentAdapter adapter;

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getData()!= null && result.getResultCode() == 101){
                        int index = result.getData().getIntExtra("position",-1);
                        String name = result.getData().getStringExtra("newStudentName");
                        students.get(index).setName(name);
                        adapter.notifyDataSetChanged();
                    }
                }
            }

    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudentsView5Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

         students = new ArrayList<>();
        students.add(new Student(1,"Ahmed",90,"Mobile"));
        students.add(new Student(2,"Mohammed",88,"Web"));

        adapter = new StudentAdapter(students,this);

        binding.studentsRv.setAdapter(adapter);

        binding.studentsRv.setLayoutManager(new LinearLayoutManager(this,
                RecyclerView.VERTICAL,false));

        binding.addBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                students.add(new Student(3,binding.studentNameEt.getText().toString(),99,"Mobile"));
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