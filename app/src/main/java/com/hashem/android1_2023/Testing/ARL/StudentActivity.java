package com.hashem.android1_2023.Testing.ARL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hashem.android1_2023.R;

public class StudentActivity extends AppCompatActivity {
    EditText studentNameEt, studentIdEt;
    Button addStudentBt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        studentNameEt = findViewById(R.id.studentNameEt);
        studentIdEt = findViewById(R.id.studentIdEt);
        addStudentBt = findViewById(R.id.addNewStudentBt);

        addStudentBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = studentNameEt.getText().toString();
                int id = Integer.parseInt(studentIdEt.getText().toString());

                Intent intent = new Intent();
                intent.putExtra("name",name);
                setResult(101,intent.putExtra("id",id));
                finish();

            }
        });

    }
}