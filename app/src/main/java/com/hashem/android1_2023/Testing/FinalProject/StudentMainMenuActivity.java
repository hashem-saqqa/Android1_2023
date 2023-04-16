package com.hashem.android1_2023.Testing.FinalProject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ActivityStudentMainMenuBinding;

public class StudentMainMenuActivity extends AppCompatActivity {
    ActivityStudentMainMenuBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityStudentMainMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}