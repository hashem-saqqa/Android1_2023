package com.hashem.android1_2023.Section106.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ActivityMain12Binding;

public class MainActivity extends AppCompatActivity {

    ActivityMain12Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain12Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

       String name = binding.nameEt.getText().toString();
       String id = binding.yearEt.getText().toString();


    }
}