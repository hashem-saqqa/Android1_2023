package com.hashem.android1_2023.Testing.RecyclerView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ActivityStudentsViewBinding;

import java.util.ArrayList;

public class StudentsViewActivity extends AppCompatActivity implements MyListener {
    ActivityStudentsViewBinding binding;
    ArrayList<Student> students;
    StudentAdapter adapter;
    Uri uri;
    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == RESULT_OK && result.getData() != null) {
                        uri = result.getData().getData();
                        binding.studentImageIv.setImageURI(uri);
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudentsViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        students = new ArrayList<>();
        students.add(new Student("Ahmed", "1", null));
        students.add(new Student("Anas", "2", null));

        adapter = new StudentAdapter(students, this);
        binding.studentsRv.setAdapter(adapter);
        binding.studentsRv.setLayoutManager(new LinearLayoutManager(this));

        binding.studentImageIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                launcher.launch(intent);
            }
        });

        binding.AddStudentBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                students.add(new Student(binding.StudentNameEt.getText().toString(), "4", uri));
                adapter.notifyItemInserted(students.size() - 1);
            }
        });


    }

    @Override
    public void onDelete(int pos) {
        students.remove(pos);
        adapter.notifyItemRemoved(pos);
    }
}