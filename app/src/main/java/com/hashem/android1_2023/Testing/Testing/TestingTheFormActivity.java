package com.hashem.android1_2023.Testing.Testing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ActivityTestingTheFormBinding;

public class TestingTheFormActivity extends AppCompatActivity {

    ActivityTestingTheFormBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTestingTheFormBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


    }
}