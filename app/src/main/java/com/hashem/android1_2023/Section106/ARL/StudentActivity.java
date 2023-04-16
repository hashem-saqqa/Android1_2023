package com.hashem.android1_2023.Section106.ARL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.hashem.android1_2023.R;

public class StudentActivity extends AppCompatActivity {
    EditText studentNameEt,studentIdEt;
    Button addNewStudentBt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student3);

        studentNameEt = findViewById(R.id.studentNameEt);
        studentIdEt = findViewById(R.id.studentIdEt);
        addNewStudentBt = findViewById(R.id.addNewStudentBt);

        addNewStudentBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = studentNameEt.getText().toString();
                String id = studentIdEt.getText().toString();

                Intent intent = new Intent();

                intent.putExtra("name",name);
                intent.putExtra("id",id);

                setResult(101,intent);

                finish();
            }
        });

    }
}