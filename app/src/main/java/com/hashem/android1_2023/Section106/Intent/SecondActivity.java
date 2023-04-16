package com.hashem.android1_2023.Section106.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.hashem.android1_2023.R;

public class SecondActivity extends AppCompatActivity {
    TextView nameTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second3);

        nameTv = findViewById(R.id.nameTv);

        Intent i = getIntent();
        String name = i.getStringExtra("name");
        int age = i.getIntExtra("age",0);
        nameTv.setText(name+"\n"+age);


    }
}