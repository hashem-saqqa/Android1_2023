package com.hashem.android1_2023.Section101.Menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ActivityMain13Binding;

public class MainActivity extends AppCompatActivity {

    ActivityMain13Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMain13Binding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        String name = binding.nameEt.getText().toString();
        String year = binding.yearEt.getText().toString();

        binding.showInfoBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}