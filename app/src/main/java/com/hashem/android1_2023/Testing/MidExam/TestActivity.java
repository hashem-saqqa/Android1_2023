package com.hashem.android1_2023.Testing.MidExam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.hashem.android1_2023.R;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {

    TextView resultTv;
    Button addButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        resultTv = findViewById(R.id.resultTv);
        addButton = findViewById(R.id.addButton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = 5*(4+8);
                resultTv.setText(result);
            }
        });
    }
}