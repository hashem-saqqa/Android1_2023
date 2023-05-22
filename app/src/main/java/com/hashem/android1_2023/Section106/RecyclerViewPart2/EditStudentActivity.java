package com.hashem.android1_2023.Section106.RecyclerViewPart2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ActivityEditStudentBinding;

public class EditStudentActivity extends AppCompatActivity {
    ActivityEditStudentBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditStudentBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.studentNameEt.setText(getIntent().getStringExtra("studentName"));

        binding.editBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = binding.studentNameEt.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("newStudentName",name);
                intent.putExtra("position",getIntent().getIntExtra("position",-1));
                setResult(101,intent);
                finish();
            }
        });
    }
}