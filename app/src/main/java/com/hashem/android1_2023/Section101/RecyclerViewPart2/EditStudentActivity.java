package com.hashem.android1_2023.Section101.RecyclerViewPart2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ActivityEditStudent2Binding;

public class EditStudentActivity extends AppCompatActivity {
    ActivityEditStudent2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditStudent2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.studentNameEt.setText(getIntent().getStringExtra("studentName"));

        binding.editBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("newStudentName",binding.studentNameEt.getText().toString());
                intent.putExtra("position",getIntent().getIntExtra("position",-1));
                setResult(101,intent);
                finish();
            }
        });

    }
}