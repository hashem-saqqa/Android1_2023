package com.hashem.android1_2023.Section106.ARL;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hashem.android1_2023.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button addStudentBt, addTeacherBt;
    TextView dataTv;

    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {

                    if (result.getData()!=null) {
                        if (result.getResultCode() == 101) {

                            Intent intent = result.getData();

                            String name = intent.getStringExtra("name");
                            String id = intent.getStringExtra("id");

//                            String oldText = dataTv.getText().toString();
//
//                            dataTv.setText(oldText + "\n" + "Student: " + name + " " + id);

                            dataTv.append("\n" + "Student: " + name + " " + id);


                        } else if (result.getResultCode() == 102) {

                            Intent intent = result.getData();

                            String name = intent.getStringExtra("name");
                            String id = intent.getStringExtra("id");

//                            String oldText = dataTv.getText().toString();
//
//                            dataTv.setText(oldText + "\n" + "Teacher: " + name + " " + id);
                            dataTv.append("\n" + "Teacher: " + name + " " + id);
                        }
                    }


                }
            }

    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        addStudentBt = findViewById(R.id.addStudentBt);
        addTeacherBt = findViewById(R.id.addTeacherBt);
        dataTv = findViewById(R.id.dataTv);


        addStudentBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), StudentActivity.class);
                launcher.launch(intent);
            }
        });
        addTeacherBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), TeacherActivity.class);
                launcher.launch(intent);
            }
        });


    }
}