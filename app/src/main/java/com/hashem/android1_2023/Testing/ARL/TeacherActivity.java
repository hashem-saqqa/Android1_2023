package com.hashem.android1_2023.Testing.ARL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hashem.android1_2023.R;

public class TeacherActivity extends AppCompatActivity {
    EditText teacherNameEt, teacherIdEt;
    Button addTeacherBt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher);

        teacherNameEt = findViewById(R.id.teacherNameEt);
        teacherIdEt = findViewById(R.id.teacherIdEt);
        addTeacherBt = findViewById(R.id.addNewTeacherBt);

        addTeacherBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = teacherNameEt.getText().toString();
                int id = Integer.parseInt(teacherIdEt.getText().toString());

                Intent intent = new Intent();
                intent.putExtra("name",name);
                intent.putExtra("id",id);
                setResult(102,intent);
                finish();

            }
        });
    }
}