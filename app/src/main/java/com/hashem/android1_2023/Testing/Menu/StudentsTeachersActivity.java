package com.hashem.android1_2023.Testing.Menu;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.Testing.ARL.StudentActivity;
import com.hashem.android1_2023.Testing.ARL.TeacherActivity;
import com.hashem.android1_2023.databinding.ActivityStudentsTeachersBinding;

public class StudentsTeachersActivity extends AppCompatActivity {
    ActivityStudentsTeachersBinding binding;
    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == 101 && result.getData() != null){
                       String name = result.getData().getStringExtra("name");
                       int id = result.getData().getIntExtra("id",0);
                       binding.studentsTeachersTv.append("Student "+name+" "+id+"\n");
                    } else if (result.getResultCode() == 102 && result.getData() != null){
                        String name = result.getData().getStringExtra("name");
                        int id = result.getData().getIntExtra("id",0);
                        binding.studentsTeachersTv.append("Teacher "+name+" "+id+"\n");
                    }
                }
            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudentsTeachersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        registerForContextMenu(binding.studentsTeachersTv);


    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.first_menu, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if (item.getItemId() == R.id.addTeacherItem) {
//            Intent intent = new Intent(getBaseContext(), TeacherActivity.class);
//            launcher.launch(intent);
//        } else if (item.getItemId() == R.id.addStudentItem) {
//            Intent intent = new Intent(getBaseContext(), StudentActivity.class);
//            launcher.launch(intent);
//        }
//        return true;
//    }
//
//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        super.onCreateContextMenu(menu, v, menuInfo);
//        getMenuInflater().inflate(R.menu.second_menu, menu);
//
//    }
//
//    @Override
//    public boolean onContextItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.blueColor:
//                binding.studentsTeachersTv.setTextColor(Color.BLUE);
//                return true;
//            case R.id.redColor:
//                binding.studentsTeachersTv.setTextColor(Color.RED);
//                return true;
//            case R.id.greenColor:
//                binding.studentsTeachersTv.setTextColor(Color.GREEN);
//                return true;
//        }
//        return true;
//
//    }
}