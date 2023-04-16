package com.hashem.android1_2023.Section101.ARL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hashem.android1_2023.R;

public class TeacherActivity extends AppCompatActivity {
    EditText teacherNameEt,teacherIdEt;
    Button addNewTeacherBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacher2);
        teacherNameEt = findViewById(R.id.teacherNameEt);
        teacherIdEt = findViewById(R.id.teacherIdEt);
        addNewTeacherBt = findViewById(R.id.addNewTeacherBt);

        addNewTeacherBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = teacherNameEt.getText().toString();
                String id = teacherIdEt.getText().toString();

                Intent intent = new Intent();

                intent.putExtra("name",name);
                intent.putExtra("id",id);

                setResult(102,intent);

                finish();
            }
        });

    }
}