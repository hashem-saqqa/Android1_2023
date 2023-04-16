package com.hashem.android1_2023.Section101.Intent;

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
        setContentView(R.layout.activity_second2);

        nameTv = findViewById(R.id.nameTv);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        int age = intent.getIntExtra("age",0);
//       String name = (String) getIntent().getExtras().get("age");
        nameTv.setText(name+"\n"+age);

    }
}