package com.hashem.android1_2023.Testing.MidExam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.hashem.android1_2023.R;
import com.hashem.android1_2023.databinding.ActivityEditCarBinding;

public class EditCarActivity extends AppCompatActivity {
    ActivityEditCarBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityEditCarBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String carName = getIntent().getStringExtra("carName");
        int carIndex = getIntent().getIntExtra("carIndex",0);

        binding.carNameEt.setText(carName);


        binding.changeCarNameBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = binding.carNameEt.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("carName",name);
                intent.putExtra("carIndex",carIndex);
                setResult(101,intent);
                finish();

            }
        });

    }
}